package slidingwindow;

import java.util.Arrays;

public class LongestSubArrayAfterDeletingOneElement {

    /*
    Find longest subArray of same elements after removing one element from array.
    Input: nums = [0, 1, 1, 1, 0, 1, 1, 0]
    Output: 5 (delete the 0 at index 4).
     */
    static int findLongestArrayLength(int[] nums, int removal) {
        int maxLength = 0;
        int left = 0;
        int removed = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                removed++;
            }
            while (removed > removal) {
                if (nums[left] == 0) {
                    removed--;
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1 - removal);
        }

        return maxLength;
    }
    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 1, 0, 1, 1, 0};
        int removal = 1;
        int result = findLongestArrayLength(nums, removal);
        System.out.println(result);
    }
}
