package collections;

import java.util.Map;

public class FindCommonPrefix {

    public static void main(String[] args) {
        String[] strArray = {"flower", "flow", "fly","flo"};
        String commonPrefix = "";
        String str = strArray[0];
        boolean matched = true;
        int count = 0;
        for (int i = 0; i < strArray[0].length(); i++) {
            for (int j = 1; j < strArray.length; j++) {
                if (i <= strArray[j].length() && strArray[0].charAt(i) != strArray[j].charAt(i)) {
                    matched = false;
                    break;
                }
            }
            if (matched) {
                count++;
            } else {
                break;
            }
        }
        commonPrefix = str.substring(0, count);
        System.out.println(commonPrefix);
    }
}
