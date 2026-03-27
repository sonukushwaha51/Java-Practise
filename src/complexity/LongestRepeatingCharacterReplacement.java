package complexity;

public class LongestRepeatingCharacterReplacement {

    static int longestCharacterReplacement(String s, int k) {
        int longest = 0;
        int n = s.length();
        int left = 0;
        int[] freq = new int[128];
        int maxFreq = 0;
        for (int right = 0; right < n; right++) {
            freq[s.charAt(right)]++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right)]);

            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left)]--;
                left++;
            }
            longest = Math.max(longest, right - left + 1);
        }
        return longest;
    }
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(longestCharacterReplacement(s, k));
    }
}
