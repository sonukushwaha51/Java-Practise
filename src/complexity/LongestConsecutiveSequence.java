package complexity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LongestConsecutiveSequence {

    static int longestConsecutiveSeq(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int n : nums) {
            hashSet.add(n);
        }
        int longestSequence = 0;

        // Find the longest sequence
        List<Integer> longestSequenceList = null;
        for (int i = 0; i < nums.length; i++) {
            if (!hashSet.contains(nums[i] - 1)) {
                List<Integer> currentSequence = new ArrayList<>();
                int count = 0;
                int start = 0;

                while (hashSet.contains(nums[i] + start)) {
                    currentSequence.add(nums[i] + start);
                    count++;
                    start++;
                }
                if (count > longestSequence) {
                    longestSequence = count;
                    longestSequenceList = currentSequence;
                }
            }
        }
        System.out.println(longestSequenceList);
        return longestSequence;
    }

    public static void main(String[] args) {
        //Input:  [100,4,200,1,3,2]
        //Output: 4 → sequence: [1,2,3,4]

        int[] nums = {100,4,200,1,3,2};
        int n = longestConsecutiveSeq(nums);
        System.out.println(n);

    }
}
