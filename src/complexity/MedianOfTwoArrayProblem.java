package complexity;

import java.util.Arrays;

public class MedianOfTwoArrayProblem {

    static double findMedian(int[] nums1, int[] nums2) {
        double median = 0.0;
        int m = nums1.length;
        int n = nums2.length;
        int result[] = new int[m + n];
        int i = 0; int j = 0; int k = 0;
        while (i < m && j < n) {
            if (nums1[i] > nums2[j]) {
                result[k] = nums2[j];
                j++;
                k++;
            } else {
                result[k] = nums1[i];
                i++;
                k++;
            }
        }
        while (i < m) {
            result[k++] = nums1[i++];
        }
        while (j < n) {
            result[k++] = nums2[j++];
        }
        System.out.println(Arrays.toString(result));
        int mid = (result.length) / 2;
        if (result.length % 2 == 0) {
            median = (result[mid] + result[mid+1]) / 2;
        } else {
            median = result[mid];
        }
        return median;
    }

    public static void main(String[] args) {
        int[] nums1 = {5,3,8,7};
        int[] nums2 = {1,2,4,6};
        // 1,2,3,4,5,6,7,8
        double median = findMedian(nums1, nums2);
        System.out.println(median);

    }
}
