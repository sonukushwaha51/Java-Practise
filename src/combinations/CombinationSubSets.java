package combinations;

import java.util.ArrayList;
import java.util.List;

public class CombinationSubSets {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        List<List<Integer>> result = new ArrayList<>();
        backTrack(0, nums, new ArrayList<>(), result);
        System.out.println(result);
    }

    private static void backTrack(int num, int[] nums, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        for (int i = num; i < nums.length; i++) {
            current.add(nums[i]);
            backTrack(i + 1, nums, current, result);
            current.remove(current.size() - 1);
        }
    }
}
