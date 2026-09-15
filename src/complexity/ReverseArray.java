package complexity;

import java.util.Arrays;

public class ReverseArray {

    public static void main(String[] args) {
        int[] nums = {1,2,5,8,3,2};
        int right = nums.length - 1;
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[right];
            nums[right] = temp;
            right--;
        }
        System.out.println(Arrays.toString(nums));
    }
}
