package slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class LongestSubstringWithKRepeatingCharacter {

    /*
    Description: Find the length of the longest substring such that no single character appears more than k times.
    Input: s = "aaabbbccc", k = 2
    Output: 4 (Substrings: "aabb" or "bbcc")
     */
    static int findLongestSubstringWithKRepeatingCharacters(String string, int k) {
        int left = 0;
        int[] freq = new int[26];
        int maxLength = 0;
        int maxLengthForList = 0;
        List<String> list = new ArrayList<>();
        for (int right = 0; right < string.length(); right++) {
            freq[string.charAt(right) - 'a']++;
            while (freq[string.charAt(right) - 'a'] > k) {
                freq[string.charAt(left) - 'a']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);

            // if I want to print the strings as well
            if (right - left + 1 > maxLengthForList) {
                maxLengthForList = right - left + 1;
                list.clear();
                list.add(string.substring(left, right + 1));
            } else if (right - left + 1 == maxLength) {
                list.add(string.substring(left, right + 1));
            }
        }
        System.out.println(list);
        return maxLength;
    }

    public static void main(String[] args) {

        String s = "aaabbbccc";
        int k = 2;
        int result = findLongestSubstringWithKRepeatingCharacters(s, k);
        System.out.println(result);
    }
}
