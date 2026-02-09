import java.util.concurrent.CountDownLatch;

public class CountdownLatchDemo {

    private static final CountDownLatch countDownLatch = new CountDownLatch(5);

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                countDownLatch.countDown();
                System.out.println(i + " person arrived");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread.start();

        try {
            countDownLatch.await();
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Countdown latch opened");
    }
}
