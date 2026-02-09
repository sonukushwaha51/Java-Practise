import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockDemo {

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
        if (lock1.tryLock()) {
            System.out.println("Balance is "+ balance);
            try {
                Thread.sleep(200);
                try {
                    lock2.tryLock(1, TimeUnit.SECONDS);
                } finally {
                    lock2.unlock();
                }
            } catch (Exception exception) {
                //
            } finally {
                lock1.unlock();
            }
        }
        return balance;
    }

    static void updateBalance(int updateBy) {
        if (lock2.tryLock()) { // Try to get the first lock
            try {
                balance += updateBy;
                // Now try to get the second lock with a timeout
                if (lock1.tryLock(1, TimeUnit.SECONDS)) {
                    try {
                        // Critical section with both locks
                    } finally {
                        lock1.unlock();
                    }
                } else {
                    System.out.println("Could not get lock1, giving up to avoid deadlock");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock2.unlock();
            }
        }
    }

}
