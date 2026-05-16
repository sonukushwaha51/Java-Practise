package slidingwindow;

import java.util.Arrays;

public class LongestDistinctSubArray {

    /*
    Description: Given an array of integers representing fruit types, find the longest sub-array containing only k distinct integers.
    Input: fruits = [1, 2, 3, 2, 2], k = 2
    Output: 4 (the sub-array [2, 3, 2, 2])
     */
    private static int[] findLongestDistinctSubArray(int[] nums, int distinct) {
        int[] freq = new int[10];
        int left = 0;
        int max = 0;
        int dis = 0;
        for (int right = 0; right < nums.length; right++) {
            freq[nums[right]]++;

            if (freq[nums[right]] == 1) {
                dis++;
            }
            while (dis > distinct) {
                freq[nums[left]]--;
                if (freq[nums[left]] == 0) {
                    dis--;
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        System.out.println("Longest length is "+ max);
        return Arrays.copyOfRange(nums, left, left + max );
    }

    public static void main(String[] args) {

        int[] nums = {2,1,3,1,2,2,1};
        int distinct = 2;
        int[] longestDistinctSubArray = findLongestDistinctSubArray(nums, distinct);
        System.out.println(Arrays.toString(longestDistinctSubArray));
    }
}
