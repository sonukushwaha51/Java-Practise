package sorting;

import java.util.Arrays;

public class InsertionSort {

    static void insertionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            while (j > 0 && nums[j-1] > nums[j]) {
                int temp = nums[j-1];
                nums[j-1] = nums[j];
                nums[j] = temp;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {7,3,6,1,8,2,9,5};
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
