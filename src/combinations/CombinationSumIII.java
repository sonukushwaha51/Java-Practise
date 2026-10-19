package combinations;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

    /*
    Find all combinations of k distinct numbers from 1 through 9 whose sum equals n. Each number can be used only once.
     */
    public static void main(String[] args) {
        int n = 9;
        int k = 3;
        List<List<Integer>> result = new ArrayList<>();
        findSumCombination(1, 0, n, k, new ArrayList<>(), result);
        System.out.println(result);
    }

    private static void findSumCombination(int num, int sum, int n, int k, ArrayList<Integer> current, List<List<Integer>> result) {

        if (sum == n && current.size() == k) {
            result.add(new ArrayList<>(current));
        }

        for (int i = num; i <= 9; i++) {
            int newSum = sum + i;
            if (newSum > n) {
                continue;
            }
            current.add(i);
            findSumCombination(i + 1, newSum, n, k, current, result);
            current.remove(current.size() - 1);
        }
    }
}
