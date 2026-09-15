package complexity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortedArrayManipulation {

    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3,4};

        // 1. Remove duplicates from sorted array
        // Below solution results in space complexity of O(n) which can be avoided in sorted array
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                list.add(arr[i]);
            }
        }
        System.out.println(list);

        // Removing duplicates using two pointer approach
        int j = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i-1]) {
                arr[j++] = arr[i];
            }
        }
        System.out.println(Arrays.toString(arr));

        // 2. Missing number in sorted sequence
        int[] arr1 = {1,2,4,5,6,7,8,9};
        int length = arr1.length + 1;
        int totalSum = length * (length + 1) / 2;
        int arrSum = 0;
        for (int n : arr1) {
            arrSum += n;
        }
        int missing = totalSum - arrSum;
        System.out.println(missing);

        // Using O(logn)
        missing = 0;
        int left = 0; int right = arr1.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr1[mid] == mid + 1) {
                left = mid + 1;
            } else if (arr1[mid] > mid) {
                right = mid - 1;
            }
        }
        missing = left + 1;
        System.out.println(missing);

        // Find first occurrence of a number in sorted sequence
        int[] arr3 = {1,2,2,2,2,2,2,4,4,5,6,8};
        int l = 0; int h = arr3.length - 1;
        int target = 2;
        int index = -1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (arr3[mid] <= target) {
                index = mid;
                l = mid + 1;
            } else{
                h = mid - 1;
            }
        }
        System.out.println(index);

        // Count how many times target occur in sorted array
        int[] nums = {1,2,2,2,2,2,4,6,8};
        System.out.println(findOccurrence(nums, 2));

    }

    static int findOccurrence(int[] nums, int target) {
        int left = 0; int right = nums.length - 1;
        int firstIndex = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                if (nums[mid] == target) {
                    firstIndex = mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (firstIndex == -1) return -1;
        System.out.println("First occurrence: "+firstIndex);

        left = 0; right = nums.length - 1;
        int lastIndex = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                if (nums[mid] == target) {
                    lastIndex = mid;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("Last occurrence: " +lastIndex);
        return firstIndex + lastIndex - 1;
    }
}
