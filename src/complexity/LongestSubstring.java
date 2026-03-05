package complexity;

import java.util.*;

public class LongestSubstring {

    public static void main(String[] args) {

        // Longest substring without repeating characters
        String str = "hello, how are you doing";
        String[] arr = str.split("");
        String largestString = "";
        int length = arr.length;
        int left = 0;
        int maxLength = 0;
        int maxStart = 0;

        // For returning list of all largest string
        int maxLengthForList = 0;
        List<String> stringList = new ArrayList<>();

        Set<Character> set = new HashSet<>();
        for (int right = 0; right < length; right++) {
            while(set.contains(str.charAt(right))) {
                set.remove(str.charAt(left));
                left++;
            }
            set.add(str.charAt(right));

            // If we only want to find max length
            //maxLength = Math.max(maxLength, right - left + 1);

            // if we want to find the largest string as well
            if (maxLength < right - left + 1) {
                maxLength = right - left + 1;
                maxStart = left;
            }

            // Return list of all largest substring
            int currentLength = right - left + 1;
            if (currentLength > maxLengthForList) {
                maxLengthForList = currentLength;
                stringList.clear();
                stringList.add(str.substring(left, right + 1));
            } else if (currentLength == maxLengthForList) {
                stringList.add(str.substring(left, right + 1));
            }

        }
        largestString = str.substring(maxStart, maxStart + maxLength);
        System.out.println("Largest string: " + largestString);
        System.out.println("Max length: " + maxLength);
        System.out.println(stringList);

    }
}
