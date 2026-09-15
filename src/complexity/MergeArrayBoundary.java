package complexity;

import java.util.ArrayList;
import java.util.List;

public class MergeArrayBoundary {

    public static void main(String[] args) {
        int[][] arr = {{1,3},{2,5},{7,10},{9,14},{15,17}};
        int start = arr[0][0];
        int end = arr[0][1];
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            if (end >= arr[i][0]) {
                end = Math.max(end, arr[i][1]);
            } else {
                list.add(new int[]{start, end});
                start = arr[i][0];
                end = arr[i][1];
            }

        }
        list.add(new int[]{start, end});
        System.out.println(list);
    }
}
