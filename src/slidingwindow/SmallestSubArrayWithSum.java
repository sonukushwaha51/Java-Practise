package slidingwindow;

import java.util.Arrays;

public class SmallestSubArrayWithSum {

    /*
    Description: Find the shortest  subarray whose sum is at least S.
    Input: nums = [2, 3, 1, 2, 4, 3], S = 7
    Output:  [4, 3]
     */
    static int[] findSmallestSubArray(int[] nums, int target) {
        int[] res;
        int left = 0;
        int sum = 0;
        int start = -1;
        int minLength = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum = sum + nums[right];
            while (sum >= target) {
                int currentLength = right - left + 1;
                if (minLength > currentLength) {
                    minLength = currentLength;
                    start = left;
                }
                sum = sum - nums[left];
                left++;
            }
        }
        if (start == -1) return new int[0];
        res = Arrays.copyOfRange(nums, start, start + minLength);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        int[] res = findSmallestSubArray(nums, target);
        System.out.println(Arrays.toString(res));
    }
}
