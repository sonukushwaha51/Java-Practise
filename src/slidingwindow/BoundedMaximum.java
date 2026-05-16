package slidingwindow;

public class BoundedMaximum {

    /*
    Description: Count the number of sub arrays where the value of the maximum element is between L and R inclusive.
    Input: nums = [2, 1, 4, 3], L = 2, R = 3
    Output: 3 (Sub arrays are [2], [2, 1], [3]).
     */
    static int findBoundedMaximum(int[] nums, int low, int high) {
        int total = 0;
        int lastInvalid = -1;
        int lastValid = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > high) {
                lastInvalid = i;
            }
            if (nums[i] >= low) {
                lastValid = i;
            }

            // This calculates the count of subarrays ending at i
            // that contain at least one element in [L, R]
            // and no elements > R.
            total += Math.max(0, lastValid - lastInvalid);
        }

        return total;
    }
    public static void main(String[] args) {
        int[] nums = {2,1,4,1,3};
        int low = 2;
        int high = 3;
        int result = findBoundedMaximum(nums, low, high);
        System.out.println(result);

    }
}
