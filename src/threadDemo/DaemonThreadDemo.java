package threadDemo;

public class DaemonThreadDemo {

    public static void main(String[] args) {

        // Thread.currentThread().setDaemon(true); // IllegalThreadStateException

        // Daemon thread is used to support the current thread such as logging etc.
        // It will die as soon as main thread dies

        Thread t1 = new Thread(() -> {
            System.out.println("Thread started" + Thread.currentThread().getName());
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.setDaemon(true);
        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main thread ended");

        // Main thread has ended here. Hence, only 0 will be printed from for loop whic hwas executed before end of main thread
    }
}
