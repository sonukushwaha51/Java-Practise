package complexity;

public class PalindromeProblem {

    public static String longestPalindrome(String s) {
        String c = "";
        for(int i = 0 ; i < s.length() ; i++){
            for(int j = i+1 ; j <= s.length() ; j++ ){
                String ss = s.substring(i , j);
                int a = 0;
                int b = ss.length()-1;
                while(a < b){
                    if(ss.charAt(a) != ss.charAt(b)){
                        break;
                    }else{
                        a++;
                        b--;
                    }
                }
                if(a >= b && ss.length() > c.length()){
                    c = ss;
                }
            }
        }
        return c;
    }

    public static void main(String[] args) {
        String string = "ahuhduwwudhusa";

        // USing traditional way. time complexity O(n)
        int n = string.length();
        boolean palindrome = false;
        int i = 0;
        while ((i < n/2)) {
            if ((string.charAt(i) == string.charAt(n - i - 1))) {
                System.out.println("Match Found for " + string.charAt(i));
                palindrome = true;
            } else {
                palindrome = false;
                break;
            }
            i++;
        }
        System.out.println(palindrome);

        // Using string builder
        StringBuilder stringBuilder = new StringBuilder(string);
        stringBuilder.reverse();
        boolean stringBuilderPalindrome = string.equals(stringBuilder.toString());
        System.out.println(stringBuilderPalindrome);

        // Find longest palindrome in a given String
        String str = "ashdasadhacidicidica";

        int strLength = str.length();
        String longestPalindrome = "";
        int start = 0;
        int maxLength = 0;
        if (strLength < 2) {
            longestPalindrome = string;
        } else {
            for (int j = 0; j < strLength; j++) {
                // --- ODD CASE ---
                int low = j;
                int high = j;
                while (low >= 0 && high < strLength && str.charAt(low) == str.charAt(high)) {
                    int currentLength = high - low + 1;
                    if (currentLength > maxLength) {
                        maxLength = currentLength;
                        start = low;
                    }
                    low--;
                    high++;
                }

                // --- EVEN CASE ---
                low = j;
                high = j + 1; // Center is between j and j+1
                while (low >= 0 && high < strLength && str.charAt(low) == str.charAt(high)) {
                    int currentLength = high - low + 1;
                    if (currentLength > maxLength) {
                        maxLength = currentLength;
                        start = low;
                    }
                    low--;
                    high++;
                }
            }
            longestPalindrome = str.substring(start, start + maxLength);
        }
        System.out.println("Longest palindrome is: "+ longestPalindrome);
        System.out.println(longestPalindrome(str));
    }
}
