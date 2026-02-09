public class RaceCondition {

    static int balance = 1000;

    public static void main(String[] args) {
        Thread[] threads = new Thread[100];
        for(int i=0; i<100; i++) {
            threads[i] = new Thread(RaceCondition::updateBalance);
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

    public static void updateBalance() {
        try {
            Thread.sleep(200);
        } catch (Exception exception) {
            //
        }
        balance += 100;
    }
}
