package slidingwindow;

public class SubArrayProductLessThanTarget {

    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        int targetProduct = 100;
        int total = findTotalSubArrayProductLessThanTarget(nums, targetProduct);
        System.out.println(total);
    }

    /*
    Description: Count how many contiguous subarrays have a product that is strictly less than a given value k.
    Input: nums = [10, 5, 2, 6], k = 100
    Output: 8 (The subarrays are [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6])
     */
    private static int findTotalSubArrayProductLessThanTarget(int[] nums, int targetProduct) {
        int total = 0;
        int product = 1;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            product = product * nums[right];
            while (product >= targetProduct && left <= right) {
                product = product / nums[left];
                left++;
            }
            total += right - left + 1;
        }
        return total;
    }
}
