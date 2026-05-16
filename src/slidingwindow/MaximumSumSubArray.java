package slidingwindow;

import java.util.Arrays;

public class MaximumSumSubArray {

    /*
    Description: Find the highest sum of any contiguous group of l elements.
    Input: nums = [2, 1, 5, 1, 3, 2], k = 3
    Output: 9 (from [5, 1, 3])
     */
    static int[] findMaximumSumSubArray(int[] nums, int k) {
        int sum = 0;
        int[] res;
        int start = 0;
        for (int i = 0; i < k; i++) {
            sum = sum + nums[i];
        }
        for (int i = k; i < nums.length; i++) {
            int s = sum - nums[i - k] + nums[i];
            if (sum < s) {
                sum = s;
                start = i - k + 1;
            }
        }
        res = Arrays.copyOfRange(nums, start, start + k);
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {2,1,5,1,3,2};
        int k = 3;
        int[] res = findMaximumSumSubArray(nums, k);
        System.out.println(Arrays.toString(res));
    }
}
