package combinations;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumII {

    public static void main(String[] args) {

        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> result = new ArrayList<>();
        findSumWithNoReuse(0, 0,  nums, target, new ArrayList<>(), result);
        System.out.println(result);
    }

    private static void findSumWithNoReuse(int num, int sum, int[] nums, int target, ArrayList<Integer> current, List<List<Integer>> result) {

        if (sum == target) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = num; i < nums.length; i++) {
            int newSum = sum + nums[i];
            if (newSum > target) {
                continue;
            }
            current.add(nums[i]);
            findSumWithNoReuse(i + 1, newSum, nums, target, current, result);
            current.remove(current.size() - 1);
        }
    }
}
