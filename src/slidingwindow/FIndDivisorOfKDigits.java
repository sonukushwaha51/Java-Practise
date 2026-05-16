package slidingwindow;

public class FIndDivisorOfKDigits {

    static int findDivisorOfKDigits(int number, int size) {
        String string = String.valueOf(number);
        int left = 0;
        int total = 0;
        String s = "";
        for (int right = 0; right < string.length(); right++) {
            s += string.charAt(right);
            if (s.length() >= size) {
                if (number % Integer.parseInt(s) == 0) {
                    total++;
                    System.out.println(s);
                }
                if (s.charAt(left) != '0') {
                    s = s.replace(String.valueOf(string.charAt(left)), "");
                }

                left++;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int number = 2400;
        int size = 2;
        int divisorCount = findDivisorOfKDigits(number, size);
        System.out.println(divisorCount);
    }
}
