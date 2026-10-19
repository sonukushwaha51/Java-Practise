package combinations;

import java.util.ArrayList;
import java.util.List;

public class CombinationProblem {

    public static void main(String[] args) {
        // Find all combination
        int n = 4; int k = 2;
        List<List<Integer>> result = new ArrayList<>();
        backTrack(1, n, k, new ArrayList<>(), result);
        System.out.println(result);
    }

    private static void backTrack(int num, int n, int k, ArrayList<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = num; i <= n; i++) {
            current.add(i);
            backTrack(i+1, n, k, current, result);
            current.remove(current.size() - 1);
        }

    }
}
