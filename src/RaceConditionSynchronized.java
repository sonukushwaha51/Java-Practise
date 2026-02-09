public class RaceConditionSynchronized {

    static int balance = 1000;

    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread[] threads = new Thread[100];
        for(int i=0; i<100; i++) {
            //threads[i] = new Thread(updateBalance(100));

            // What the compiler effectively turns it into:
            threads[i] = new Thread(() -> RaceConditionSynchronized.updateBalance(100));
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
        synchronized (lock) {
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                //
            }
            balance += 100;
        }
    }

}
