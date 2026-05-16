package slidingwindow;

import java.util.*;

public class SubArraysWithKDistinctIntegers {

    /*
    Description: Count how many subarrays have exactly k different integers.
    Input: nums = [1, 2, 1, 2, 3], k = 2
    Output: 7 (The subarrays are [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2])
     */

    static List<List<Integer>> findSubListsWithKDistinctIntegers(int[] nums, int distinct) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> resultList = new ArrayList<>();
        int left = 0;
        int total = 0;
        for (int right = 0; right < nums.length; right++) {
            map.merge(nums[right], 1, Integer::sum);
            while (map.size() > distinct) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            total += right - left + 1;
        }
        total = total - nums.length;
        System.out.println("Total sub Array: "+ total);
        return resultList;
    }
    public static void main(String[] args) {

        int[] nums = {1, 2, 1, 2, 3};
        int distinct = 2;
        List<List<Integer>> result = findSubListsWithKDistinctIntegers(nums, distinct);
        System.out.println(result);

    }
}
