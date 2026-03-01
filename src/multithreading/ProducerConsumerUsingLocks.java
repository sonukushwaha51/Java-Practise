package multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerUsingLocks {

    private static final Lock lock = new ReentrantLock();

    private final Condition notEmptyCondition = lock.newCondition();

    private final Condition notFullCondition = lock.newCondition();

    private static final Integer POISON_PILL = Integer.MIN_VALUE;

    private final Queue<Integer> queue = new LinkedList<>();
    public int getFromQueue() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                try {
                    notEmptyCondition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            notFullCondition.signal();
            Integer i = queue.poll();
            System.out.println(Thread.currentThread().getName() + " retrieved "+ i + " from queue");
            return i;
        } finally {
            lock.unlock();
            System.out.println("Consumer released lock");
        }
    }

    public void putIntoQueue(int i) {
        lock.lock();
        try {
            while (queue.size() > 0 ) {
                try {
                    notFullCondition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            queue.add(i);
            Thread.sleep(200);
            System.out.println(Thread.currentThread().getName() + " put "+ i + " in queue");
            notEmptyCondition.signalAll();
        } catch (Exception exception) {
            //
        } finally {
            lock.unlock();
            System.out.println("Producer released lock");
        }
    }

    public static void main(String[] args) {
        ProducerConsumerUsingLocks producerConsumerUsingLocks = new ProducerConsumerUsingLocks();

        Thread consumer = new Thread(() -> {
            while (true) {
                int i = producerConsumerUsingLocks.getFromQueue();
                if (i == POISON_PILL) {
                    break;
                }
            }
        });

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                producerConsumerUsingLocks.putIntoQueue(i);
            }
            producerConsumerUsingLocks.putIntoQueue(POISON_PILL);
        });

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
