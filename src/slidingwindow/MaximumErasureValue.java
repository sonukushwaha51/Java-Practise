package slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class MaximumErasureValue {

    /*
    Description: You want to erase a sub array containing unique elements. Find the maximum possible sum you can get from such a subarray.
    Input: nums = [4, 2, 4, 5, 6]
    Output: 17 (The sub array is [2, 4, 5, 6])
     */
    private static int findSumOfUniqueElements(int[] nums) {
        int sum = 0;
        int left = 0;
        int total = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int right = 0; right < nums.length; right++) {
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                sum = sum - nums[left];
                left++;
            }
            sum = sum + nums[right];
            set.add(nums[right]);

            if (sum > total) {
                total = sum;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[] nums = {4,2,4,5,6};
        int sum = findSumOfUniqueElements(nums);
        System.out.println(sum);
    }
}
