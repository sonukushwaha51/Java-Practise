package slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramString {

    /*
    Description: Find every start index in string s where the substring is an anagram of string p.
    Input: s = "cbaebabacd", p = "abc"
    Output: [0, 6]
     */
    static List<Integer> findStartIndexOfAnagrams(String str, String word) {
        int[] freq = new int[128];
        for (char ch : word.toCharArray()) {
            freq[ch]++;
        }
        List<Integer> list = new ArrayList<>();
        int left = 0;
        int[] currentFreq = new int[128];
        for (int right = 0; right < str.length(); right++) {
            currentFreq[str.charAt(right)]++;

            if (right >= word.length()) {
                currentFreq[str.charAt(left)]--;
                left++;
            }

            if (Arrays.equals(freq, currentFreq)) {
                list.add(left);
            }

        }
        return list;
    }

    static List<String> findAnagrams(String str, String word) {
        int[] freq = new int[128];
        for (char ch : word.toCharArray()) {
            freq[ch]++;
        }
        List<String> list = new ArrayList<>();
        int left = 0;
        int[] currentFreq = new int[128];
        for (int right = 0; right < str.length(); right++) {
            currentFreq[str.charAt(right)]++;

            if (right >= word.length()) {
                currentFreq[str.charAt(left)]--;
                left++;
            }

            if (Arrays.equals(freq, currentFreq)) {
                list.add(str.substring(left, left + word.length()));
            }
            System.out.println(list);

        }
        return list;
    }


    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> indexOfAnagrams = findStartIndexOfAnagrams(s, p);
        System.out.println(indexOfAnagrams);
        List<String> anagrams = findAnagrams(s, p);
        System.out.println(anagrams);
    }
}
