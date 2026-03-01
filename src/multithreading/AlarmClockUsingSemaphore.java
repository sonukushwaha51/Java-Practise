package multithreading;

import java.time.Duration;
import java.time.Instant;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AlarmClockUsingSemaphore {
    private static final Semaphore producerSemaphore = new Semaphore(5);

    private static final Queue<Instant> queue = new LinkedList<>();

    private static final ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(5);

    private static final AtomicInteger totalAlarms = new AtomicInteger(0);

    public void setAlarm(Instant time) {
        if (time.isBefore(Instant.now())) {
            System.out.println("Cannot set alarm in the past.");
            return;
        }
        try {
            if (producerSemaphore.tryAcquire(2, TimeUnit.MINUTES)) {
                queue.add(time);
                System.out.println("Alarm set for: "+ time);
                long delay = Duration.between(Instant.now(), time).toMillis();
                scheduledExecutor.schedule(() -> ringAlarm(time), delay, TimeUnit.MILLISECONDS);
                totalAlarms.incrementAndGet();
            } else {
                System.out.println("No Slots available for alarm. Please wait for any one alarm to ring");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void ringAlarm(Instant time) {
        if (time.isAfter(Instant.now())) {
            return;
        }
        queue.remove(time);
        System.out.println("Alarm ringing for time: "+ time);
        producerSemaphore.release();

        if (totalAlarms.incrementAndGet() == 6) {
            scheduledExecutor.shutdown();
        }
    }

    public static void main(String[] args) {

        AlarmClockUsingSemaphore alarmClockUsingSemaphore = new AlarmClockUsingSemaphore();

        Runnable alarmTask = () -> {
            Instant time = Instant.now().plusMillis(10000);
            for (int i = 0; i < 6; i++) {
                alarmClockUsingSemaphore.setAlarm(time);
                time = time.plusMillis(10000);
            }
        };

        scheduledExecutor.submit(alarmTask);
    }


}
