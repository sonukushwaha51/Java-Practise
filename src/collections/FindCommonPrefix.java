package collections;

import java.util.Map;

public class FindCommonPrefix {

    public static void main(String[] args) {
        String[] strArray = {"flower", "flow", "fly","abc"};
        String commonPrefix = "";
        String str1 = strArray[0];
        int longest = str1.length();
        for (int i = 1; i < strArray.length; i++) {
            int left = 0;
            while (strArray[i].length() > left && (str1.charAt(left) == strArray[i].charAt(left))) {
                left++;
            }
            if (longest > left) {
                longest = left;
            }
            System.out.println(longest);
        }
        commonPrefix = str1.substring(0, longest);
        System.out.println(commonPrefix);
    }
}
