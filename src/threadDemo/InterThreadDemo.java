package threadDemo;

public class InterThreadDemo {

    public static void main(String[] args) {

        SharedResource obj = new SharedResource();

        // Shows how Threads communicate with each other using wait() and notify()

        Thread producer = new Thread(() -> {
            try {
                obj.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread consumer = new Thread(obj::consume);

        producer.start();
        consumer.start();

    }
}

class SharedResource {

    synchronized void produce() throws InterruptedException {
        System.out.println("Producer producing...");
        wait();   // waits until consumer notifies
        System.out.println("Producer resumed");
    }

    synchronized void consume() {
        System.out.println("Consumer consuming...");
        notify(); // wakes producer
    }
}
