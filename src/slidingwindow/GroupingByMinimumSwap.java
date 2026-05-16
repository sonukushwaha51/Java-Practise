package slidingwindow;

public class GroupingByMinimumSwap {
    /*
    Description: Given a binary array, find the minimum number of swaps needed to bring all the 1s appearing in the array together in any contiguous block.
    Input: nums = [1, 0, 1, 0, 1]
    Output: 1 (The total number of 1s is 3; the window size is 3. Find the window with the most 1s).
     */
    static int findMinimumSwapNeeded(int[] nums) {
        int windowSize = 0;
        if (nums.length == 0) return windowSize;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                windowSize++;
            }
        }
        int totalSwap = Integer.MAX_VALUE;
        int left = 0;
        int count = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 1) {
                count++;
            }
            if (right - left + 1 == windowSize) {
                totalSwap = Math.min(totalSwap, windowSize - count);
                if (nums[left] == 1) {
                    count--;
                }
                left++;
            }
        }
        return totalSwap;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0, 1};
        int result = findMinimumSwapNeeded(nums);
        System.out.println(result);
    }
}
