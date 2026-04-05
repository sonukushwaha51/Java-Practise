package sorting;

import java.util.Arrays;

public class QuickSort {

    static int partition(int[] nums, int start, int end) {
        int pivot = nums[start];

        int pivotIndex;
        int count = 0;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] < pivot) {
                count++;
            }
        }
        pivotIndex = start + count;
        swap(nums, pivotIndex, start);
        int i = start; int j = end;
        while (i < pivotIndex && j > pivotIndex) {
            while (nums[i] < pivot) {
                i++;
            }
            while (nums[j] > pivot) {
                j--;
            }
            if (i < pivotIndex && j > pivotIndex) {
                swap(nums, i, j);
            }
        }

        return pivotIndex;
    }

    static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    static void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = partition(nums, start, end);
        quickSort(nums, start, pivot - 1);
        quickSort(nums, pivot + 1, end);
    }
    public static void main(String[] args) {

        int[] nums = {7,3,6,1,8,2,9,5};
        quickSort(nums, 0 , nums.length - 1);
        System.out.println(Arrays.toString(nums));

    }
}
