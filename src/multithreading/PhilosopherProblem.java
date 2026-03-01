package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PhilosopherProblem {

    // Fair locks to reduce starvation
    private static final Lock lock1 = new ReentrantLock(true);
    private static final Lock lock2 = new ReentrantLock(true);

    public static void acquireBothForks() {
        boolean hasEaten = false;

        while (!hasEaten) {
            if (lock1.tryLock()) {
                try {
                    if (lock2.tryLock()) {
                        System.out.println(Thread.currentThread().getName() + " acquired both fork");
                        try {
                            Thread.sleep(1000); // Eating
                            hasEaten = true;
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        } finally {
                            lock2.unlock();
                        }
                    } else {
                        System.out.println("Unlocking one fork as second is not available");
                    }
                } finally {
                    lock1.unlock();
                }
            }

            // Backoff to avoid busy spinning.
            // Without this, threads would repeatedly call tryLock() in a tight loop,
            // causing high CPU usage and allowing aggressive threads to dominate lock
            // acquisition (tryLock() bypasses lock fairness).
            // Sleeping briefly improves scheduling fairness and reduces contention.
            // This is not required for correctness, only for efficiency and fairness.
            if (!hasEaten) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {

        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i]  = new Thread(PhilosopherProblem::acquireBothForks);
            threads[i].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
