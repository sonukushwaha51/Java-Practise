package slidingwindow;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeNumberInWindow {

    /*
    Description: For every contiguous block of size k, find the first negative integer.
     If a window has no negative integers, the output for that window is 0.
     Input: nums = [12, -1, -7, 8, -15, 30, 16, 28], k = 3
     Output: [-1, -1, -7, -15, -15, 0]
     */
    static int[] findFirstNegativeInWindow(int[] nums, int size) {
        int[] result = new int[nums.length - size + 1];
        Queue<Integer> queue = new LinkedList<>();
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                queue.offer(nums[i]);
            }
            if (i >= size) {
                if (!queue.isEmpty()) {
                    result[left] = queue.peek();
                } else {
                    result[left] = 0;
                }
                if (!queue.isEmpty() && nums[left] == queue.peek()) {
                    queue.poll();
                }
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {12, -1, -7, 8, -15, 30, 16, 28};
        int size = 3;
        int[] result = findFirstNegativeInWindow(nums, size);
        System.out.println(Arrays.toString(result));
    }
}
