package slidingwindow;

public class MinimumOperationToReduceTotalToZero {

    /*
    Description: You can remove elements from either the leftmost or rightmost end of the array.
    Find the minimum number of removals to make the sum of removed elements exactly x.
    Input: nums = [1, 1, 4, 2, 3], x = 5
    Output: 2 (remove 2 and 3 from the right).
     */
    static int findMinimumLength(int[] nums, int x) {
        int rightElement = 0;
        int leftElement = 0;
        int rightSum = 0;
        int leftSum = 0;
        int minLength = 0;
        for (int i = 0; i < nums.length; i++) {
            leftSum += nums[i];
            if (leftSum == x) {
                leftElement++;
                break;
            } else if (leftSum > x) {
                System.out.println("No sum found with exact match in left");
                leftElement = Integer.MAX_VALUE;
                break;
            }
            leftElement++;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            rightSum += nums[i];
            if (rightSum == x) {
                rightElement++;
                break;
            } else if (rightSum > x) {
                System.out.println("No sum found with exact match in right");
                rightElement = Integer.MAX_VALUE;
                break;
            }
            rightElement++;
        }
        minLength = Math.min(rightElement, leftElement);
        return minLength;
    }


    public static void main(String[] args) {
        int[] nums = {3, 2, 20, 1, 1, 3};
        int x = 10;
        int result = findMinimumLength(nums, x);
        System.out.println(result);
    }
}
