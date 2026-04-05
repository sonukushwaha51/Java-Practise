package sorting;

import java.util.Arrays;

public class SelectionSort {

    // In selection sort, we iterate over the arrays, pick the smallest and move it to i-th position.
    // It results in time complexity of O(n^2)
    static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[index]) {
                    index = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {7,3,6,1,8,2,9,5};
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
