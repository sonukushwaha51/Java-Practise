package complexity;

public class MinimumWindowSubstring {

    static String findMinimumWIndowSubstring(String s, String target) {

        int freq[] = new int[128];
        for (char c : target.toCharArray()) {
            freq[c]++;
        }
        int targetLength = target.length();
        int minLength = Integer.MAX_VALUE;
        int start = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            if (freq[s.charAt(right)] > 0) {
                targetLength--;
            }
            freq[s.charAt(right)]--;

            while (targetLength == 0) {
                if (minLength > right - left + 1) {
                    start = left;
                    minLength = right - left + 1;
                }
                freq[s.charAt(left)]++;
                if (freq[s.charAt(left)] > 0) {
                    targetLength++;
                }
                left++;
            }
        }
        String finalString = s.substring(start, start + minLength);

        return finalString;
    }
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String target = "ABC";
        System.out.println(findMinimumWIndowSubstring(s, target));
    }
}
