import java.util.concurrent.*;

public class BlockingQueueDemo {

    private final BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);

    private final static Integer POISON_PILL = Integer.MIN_VALUE;

    private static final ExecutorService executor = Executors.newFixedThreadPool(100);

    void putIntoQueue(int i) {
        try {
            blockingQueue.put(i);
            System.out.println("Put "+ i + " in queue");
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    int getFromQueue() {
        try {
            Integer item = blockingQueue.take();
            System.out.println("Consumed "+ item + " from queue");
            if (item.equals(POISON_PILL)) {
                System.out.println("Nothing left to consume. Shutting down");
            }
            return item;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        BlockingQueueDemo blockingQueueDemo = new BlockingQueueDemo();

        Runnable producer = () -> {
            for (int i = 0; i < 100; i++) {
                blockingQueueDemo.putIntoQueue(i);
            }
            blockingQueueDemo.putIntoQueue(POISON_PILL);
        };

        Runnable consumer = () -> {
            while (true) {
                Integer item = blockingQueueDemo.getFromQueue();
                if (item.equals(POISON_PILL)) {
                    break;
                }
            }
        };

        executor.submit(producer);
        executor.submit(consumer);

        executor.shutdown();
    }

}
