package complexity;

public class MaximumAreaOfWater {

    public static void main(String[] args) {
        int[] nums = {4,2,3,6,7,1};
        int right = nums.length - 1;
        int left = 0;
        int area = 1;
        int start = 0;
        int end = 0;
        while (left < right) {
            int min = Math.min(nums[left], nums[right]);
            int currentArea = min * (right - left);
            if (currentArea > area) {
                area = currentArea;
                start = left;
                end = right;
            }
            if (nums[left] < nums[right]) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(area);
        System.out.println(start);
        System.out.println(end);
    }
}
