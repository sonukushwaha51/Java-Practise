package complexity;

import java.util.PriorityQueue;

public class KthLargestElement {

    public static void main(String[] args) {
        int[] nums = {12,24,13,46,213,13,547,133};
        int k = 2;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int n : nums) {
            priorityQueue.offer(n);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        System.out.println(priorityQueue.poll());
    }
}
