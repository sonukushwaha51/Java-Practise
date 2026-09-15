package complexity;

public class PeakElement {

    public static void main(String[] args) {
        int[] nums = {1,2,3,5,7,9,5,2,1};
        int left = 0;
        int peak = 0;
        int right = nums.length - 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                peak = nums[mid];
                break;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(peak);
    }
}
