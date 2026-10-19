package combinations;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {

        int[] nums = {2,3,6,7};
        int target = 7;
        List<List<Integer>> result = new ArrayList<>();
        findSum(0, 0, nums, target, new ArrayList<>(), result);
        System.out.println(result);
    }

    private static void findSum(int num, int sum, int[] nums, int target, ArrayList<Integer> current, List<List<Integer>> result) {

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
            findSum(i, newSum, nums, target, current, result);
            current.remove(current.size() - 1);
        }
    }
}
