package complexity;

import java.util.Arrays;

public class MergeSort {

    static void divideArray(int[] arr, int start, int end) {

    }

    static int[] mergeSort(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            divideArray(nums, start, mid);
            divideArray(nums, mid + 1, end);
            end = mid;
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {7,3,6,1,8,2,9,5};
        int[] merged = mergeSort(nums);
        System.out.println(Arrays.toString(merged));
    }
}
