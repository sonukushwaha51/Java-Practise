package complexity;

public class GCD {

    public static void main(String[] args) {
        int num1 = 48;
        int num2 = 18;
        while ( num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        //gcd
        System.out.println(num1);

        // LCM
        int num3 = 48;
        int num4 = 18;
        int lcm = (num3 /num1 * num4);
        System.out.println(lcm);

        // Check whether number is power of 2
        int num = 64;
        int n = 1;
        while (n <= num) {
            n = n << 1;
        }
        n = n >> 1;
        if (n == num) {
            System.out.println(num + " is power of 2");
        } else {
            System.out.println(num + " is not power of 2");
        }

        // Find the number which appears only once in array
        int[] arr = {1,2,1,4,2,3,3,5,5};
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result ^= arr[i];
        }
        System.out.println(result);
        int[] freq = new int[10];
        for (int a : arr) {
            freq[a]++;
        }
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 1) {
                System.out.println(i);
                break;
            }
        }

        // Check both numbers are opposite
        int a = -10;
        int b = -5;
        boolean isNegative = a > 0 ^ b > 0;
        System.out.println(isNegative);


    }
}
