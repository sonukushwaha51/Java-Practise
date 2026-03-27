package complexity;

import java.util.Arrays;

public class ShiftArrayExample {

    static void shiftZerosToRight(int[] nums) {
        int n = nums.length;
        int numPositions = 0;
        for (int i = 0; i < n; i++ ) {
            if (nums[i] != 0) {
                int temp = nums[numPositions];
                nums[numPositions] = nums[i];
                nums[i] = temp;
                numPositions++;
            }
        }
    }

    static void shiftZerosToLeft(int[] nums) {
        int n = nums.length;
        int numPositions = 0;
        for (int i = 0; i < n; i++ ) {
            if (nums[i] == 0) {
                int temp = nums[numPositions];
                nums[numPositions] = nums[i];
                nums[i] = temp;
                numPositions++;
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,4,0,31,0,48,0};
        shiftZerosToRight(nums);
        System.out.println(Arrays.toString(nums));
        shiftZerosToLeft(nums);
        System.out.println(Arrays.toString(nums));

    }
}
