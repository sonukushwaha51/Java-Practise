package slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class ShortestSubStringContainingUniqueCharacters {

    /*
    Description: Find the length of the smallest substring that contains every distinct character that exists in the entire string at least once.
    Input: s = "aabcbcdbca"
    Output: 4 (The substring "dbca" contains 'a', 'b', 'c', and 'd').
     */
    static String findShortestString(String str) {
        if (str == null || str.length() == 0) return "";

        // 1. Count total distinct characters in the whole string
        Set<Character> distinctChars = new HashSet<>();
        for (char c : str.toCharArray()) distinctChars.add(c);
        int targetCount = distinctChars.size();
        int left = 0;
        int count = 0;
        int length = Integer.MAX_VALUE;
        int[] freq = new int[128];
        int start = 0;
        for (int right = 0; right < str.length(); right++) {
            if (freq[str.charAt(right)] == 0) {
                count++;
            }
            freq[str.charAt(right)]++;
            while (count == targetCount) {
                if (length > right - left + 1) {
                    length = right - left + 1;
                    start = left;
                }
                freq[str.charAt(left)]--;
                if (freq[str.charAt(left)] == 0) {
                    count--;
                }
                left++;
            }
        }
        return str.substring(start, start + length);
    }

    public static void main(String[] args) {

        String s = "aabcbcdbca";
        String result = findShortestString(s);
        System.out.println(result);
    }
}
