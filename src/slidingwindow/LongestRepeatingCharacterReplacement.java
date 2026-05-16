package slidingwindow;

public class LongestRepeatingCharacterReplacement {

    /*
    Description: You can change k characters in a string. Find the longest substring of all the same characters you can create.
    Input: s = "AABABBAA", k = 1
    Output: 4 (Replace 'B' at index 2 to get "AAAA")
     */
    static String longestRepeatingString(String string, int k) {
        int left = 0;
        int maxLength = 0;
        String result = "";
        int[] freq = new int[128];
        int maxFreq = 0;
        for (int right = 0; right < string.length(); right++) {
            freq[string.charAt(right)]++;
            maxFreq = Math.max(maxFreq, freq[string.charAt(right)]);

            while ((right - left + 1) - maxFreq > k) {
                freq[string.charAt(left)]--;
                left++;
            }
            maxLength = Math.max(right - left + 1, maxLength);
        }
        System.out.println("Max length is: "+maxLength);
        result = string.substring(left, left + maxLength);
        return result;
    }

    public static void main(String[] args) {
        String string = "AABABBAAA";
        int k = 2;
        String result = longestRepeatingString(string, k);
        System.out.println(result);
    }
}
