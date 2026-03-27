package complexity;

public class BinarySearchExample {

    static int index(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {

        int index = index(new int[]{1,3,7,9,11,15}, 15);
        System.out.println(index);
    }
}
