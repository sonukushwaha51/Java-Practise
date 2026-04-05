package sorting;

import java.util.Arrays;

public class BubbleSort {

    // In bubble sort we do adjacent swapping. if first index is greater than next index value, then swap it.
    // We ensure that last element is always highest, hence reducing iteration count by n-1 in each iteration
    // THis results in O(n^2) time complexity for worst and average case.
    // if array is sorted, it can be optimized for time complexity of O(n)
    static void bubbleSort(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {7,3,6,1,8,2,9,5};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
