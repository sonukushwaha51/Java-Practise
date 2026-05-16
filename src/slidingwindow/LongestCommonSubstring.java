package slidingwindow;

public class LongestCommonSubstring {

    /*
    Description: Given two strings, find the length of the longest substring that appears in both.
    While often solved with DP, it can be optimized using a sliding window of a fixed size L and checking for matches via hashing.
    Input: s1 = "abcdgh", s2 = "acdghi"
    Output: 4 (The substring is "cdgh")
    Complexity Goal: O((n+m)log(min(n, m))) using Binary Search on length and Rolling Hash.
     */
    private static String findCommonSubstring(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        if (s1Len > s2Len) findCommonSubstring(s2, s1);
        for (int i = 0; i < s1Len; i++) {
  
        }
        return "";
    }

    public static void main(String[] args) {
        String s1 = "abcdgh";
        String s2 = "giabc";
        String commonSubstring = findCommonSubstring(s1, s2);
        System.out.println(commonSubstring);
    }
}
