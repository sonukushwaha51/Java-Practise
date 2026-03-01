package complexity;

import java.util.HashSet;
import java.util.Set;

public class PairSum {

    static void printPair(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(target - num)) {
                System.out.println("Pair found " + num + "," + (target - num));
            }
            set.add(num);
        }
    }

    public static void main(String[] args) {

        int[] nums = {4,1,6,2,5,3};
        printPair(nums, 6);

    }
}
