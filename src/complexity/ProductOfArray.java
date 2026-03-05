package complexity;

import java.util.Arrays;

public class ProductOfArray {

    public static void main(String[] args) {

        int[] arr = {5,6,9,10,13};
        int[] result = new int[5];
        // Store product of numbers in an array where input[i] should not be multiplied
        // e.g. output[0] = 6 * 9 * 10 * 13

        // Calculate left product first
        result[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            result[i] = result[i - 1] * arr[i - 1];
        }

        // Calculate right product
        int rightProduct = 1;
        for (int i = arr.length - 1; i >=0; i--) {
            result[i] = result[i] * rightProduct;
            rightProduct = rightProduct * arr[i];
        }

        System.out.println(Arrays.toString(result));
    }
}
