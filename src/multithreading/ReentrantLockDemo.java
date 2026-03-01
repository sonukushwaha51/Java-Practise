package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    private static final Lock lock = new ReentrantLock(true);

    static int balance = 1000;
    public static void main(String[] args) {
        Thread[] threads = new Thread[100];
        for(int i=0; i<100; i++) {
            threads[i] = new Thread(() -> updateBalance(100));
            threads[i].start();
        }
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Balance: "+balance);
    }

    public static void updateBalance(int updateBy) {
        lock.lock();
        try {
            balance += 100;
            System.out.println(Thread.currentThread().getName() + " Updated balance to " + balance);
            Thread.sleep(20);
        } catch (Exception exception) {
            //
        } finally {
            lock.unlock();

        }

    }
}
