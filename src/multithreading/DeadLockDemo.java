package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockDemo {

    private static final Lock lock1 = new ReentrantLock();

    private static final Lock lock2 = new ReentrantLock();

    static int balance = 1000;
    public static void main(String[] args) {

        Runnable runnable = () -> {
            updateBalance(100);
            int balance = getBalance();
            System.out.println("Balance is :" + balance);
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    static int getBalance() {
        lock1.lock();
        try {
            Thread.sleep(200);
            try {
                lock2.lock();
            } finally {
                lock2.unlock();
            }
        } catch (Exception exception) {
            //
        } finally {
            lock1.unlock();
        }
        return balance;
    }

    static void updateBalance(int updateBy) {
        lock2.lock();
        try {
            Thread.sleep(200);
            balance += updateBy;
            try {
                lock1.lock();
            } finally {
                lock1.unlock();
            }
        } catch (Exception exception) {
            //
        } finally {
            lock2.unlock();
        }
    }
}
