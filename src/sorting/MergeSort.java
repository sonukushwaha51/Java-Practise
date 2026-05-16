package sorting;

import java.util.Arrays;

public class MergeSort {

    static void merge(int[] nums, int start, int end) {
        int mid = start + (end - start) / 2;
        int len1 = mid - start + 1;
        int len2 = end - mid;
        int[] a = new int[len1];
        int[] b = new int[len2];
        int total = start;
        for (int i = 0; i < len1; i++) {
            a[i] = nums[total++];
        }
        for (int i = 0; i < len2; i++) {
            b[i] = nums[total++];
        }

        int i = 0; int k = start; int j = 0;
        while (i < a.length && j < b.length) {
            if ( a[i] < b[j]) {
                nums[k++] = a[i++];
            } else {
                nums[k++] = b[j++];
            }
        }

        while (i < a.length) {
            nums[k++] = a[i++];
        }
        while (j < b.length) {
            nums[k++] = b[j++];
        }
    }

    private static void mergeSort(int[] nums, int start, int end) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);

        merge(nums, start, end);
    }

    public static void main(String[] args) {

        int[] nums = {3,1,6,8,2,11,19,8,5};
        mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
