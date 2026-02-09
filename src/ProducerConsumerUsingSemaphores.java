import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class ProducerConsumerUsingSemaphores {

    private static final Semaphore consumerSemaphore = new Semaphore(0);

    private static final Semaphore producerSemaphore = new Semaphore(1);

    private static final Queue<Integer> queue = new LinkedList<>();

    private static final Integer POISON_PILL = Integer.MIN_VALUE;

    public int getFromQueue() {
        try {
            consumerSemaphore.acquire();
            int i = queue.poll();
            System.out.println("Consumer read "+ i + " from queue");
            return i;
        } catch (Exception exception) {
            //
        } finally {
            producerSemaphore.release();
        }
        return 0;
    }

    public void putIntoQueue(int i) {
        try {
            producerSemaphore.acquire();
            queue.add(i);
            System.out.println("Producer Added "+ i + " to queue");
            Thread.sleep(200);
        } catch (Exception exception) {
            //
        } finally {
            consumerSemaphore.release();
        }

    }

    public static void main(String[] args) {

        ProducerConsumerUsingSemaphores producerConsumerUsingSemaphores = new ProducerConsumerUsingSemaphores();
        Thread consumer = new Thread(() -> {
            while (true) {
                int i = producerConsumerUsingSemaphores.getFromQueue();
                if (i == POISON_PILL) {
                    break;
                }
            }
        });

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                producerConsumerUsingSemaphores.putIntoQueue(i);
            }
            producerConsumerUsingSemaphores.putIntoQueue(POISON_PILL);
        });

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
