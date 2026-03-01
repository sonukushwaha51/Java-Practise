package multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {

    /*
        AtomicInteger uses a low-level mechanism called Compare-And-Swap (CAS).
        Instead of using heavy "locks" (which put threads to sleep and wake them up, costing performance),
        it uses a "keep trying until you succeed" strategy.

        The CAS Algorithm
        The process works like this:

        Fetch: The thread reads the current value (let's say 10).

        Calculate: The thread calculates the new value (11).

        Compare-And-Swap: Before writing, the thread asks the CPU: "Is the current value still 10?"

        If Yes: It updates the value to 11.

        If No: It means another thread changed the value while this thread was calculating. The thread fails the update,
        fetches the new value, and tries the whole process again.
     */
    static AtomicInteger balance = new AtomicInteger(1000);

    private static int finalBalance = 0;

    public static void main(String[] args) {
        Thread[] threads = new Thread[100];
        for(int i=0; i<100; i++) {
            threads[i] = new Thread(AtomicIntegerDemo::updateBalance);
            threads[i].start();
        }
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Balance: "+finalBalance);
    }

    public static void updateBalance() {
        try {
            Thread.sleep(200);
        } catch (Exception exception) {
            //
        }
        finalBalance = balance.incrementAndGet();
    }
}
