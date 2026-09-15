package complexity;

public class SortedArraySum {

    public static void main(String[] args) {
        // Find two numbers in a sorted array whose sum equals a target.
        int[] arr = {1,2,5,6,8,11,17,21};
        int target = 27;
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) {
                System.out.println("Pair found: "
                        + arr[left] + " + " + arr[right]);
                break;
            }

            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }

}
