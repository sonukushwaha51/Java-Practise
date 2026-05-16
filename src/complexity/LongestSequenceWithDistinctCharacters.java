package complexity;

import java.util.Arrays;

public class LongestSequenceWithDistinctCharacters {

    static int longestSequence(int[] nums, int k) {
        int n = nums.length;
        int[] freq = new int[10];
        int left = 0;
        int longest = 0;
        for (int right = 0; right < n; right++) {
            freq[nums[right]]++;

            while (freq[nums[right]] > k) {
                freq[nums[left]]--;
                left++;
            }

            longest = Math.max(longest, right - left + 1);
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,2,3,1,3,1};
        int k = 2;
        int longest = longestSequence(nums, k);

        // Expected output : 4 {1,2,1,2}
        System.out.println(longest);
    }
}
