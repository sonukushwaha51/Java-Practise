package slidingwindow;

import java.util.Arrays;

public class MinimumWindowSubstring {

    /*
    Description: Find the smallest substring in s that contains every character (including duplicates) found in.
    Input: s = "ADOBECODEBANC", t = "ABC"
    Output: "BANC"
     */
    private static String findMinimumWindowSubstring(String str, String t) {
        int[] freq = new int[26];
        for (char ch : t.toCharArray()) {
            freq[ch - 'A']++;
        }
        int left = 0;
        int start = 0;
        int minLength = Integer.MAX_VALUE;
        int targetLength = t.length();
        for (int right = 0; right < str.length(); right++) {
           if (freq[str.charAt(right) - 'A'] > 0) {
               targetLength--;
           }
           freq[str.charAt(right) - 'A']--;
           while (targetLength == 0) {
               if (minLength > right - left + 1) {
                   minLength = right - left + 1;
                   start = left;
               }
               freq[str.charAt(left) - 'A']++;
               if (freq[str.charAt(left) - 'A'] > 0) {
                   targetLength++;
               }
               left++;
           }
        }
        return str.substring(start, start + minLength);
    }

    public static void main(String[] args) {
        String str = "AADOBECODEBANC";
        String t = "ABC";
        String result = findMinimumWindowSubstring(str, t);
        System.out.println(result);
    }
}
