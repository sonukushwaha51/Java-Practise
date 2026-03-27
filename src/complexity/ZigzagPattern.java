package complexity;

import java.util.*;
import java.util.stream.Collectors;

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);


Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
Example 3:

Input: s = "A", numRows = 1
Output: "A"


Constraints:

1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000
 */
public class ZigzagPattern {

    static String convertString(String string, int numberOfRows) {
        if (string.length() < 2) {
            return string;
        }
        Map<Integer, String> map = new LinkedHashMap<>();
        String[] arr = string.split("");
        int n = string.length();
        int start = 0;
        while (n > 0) {
            for (int i = 0; i < numberOfRows; i++) {
                if (n != 0) {
                    map.merge(i, arr[start], (oldValue, newValue) -> oldValue + newValue);
                    start++;
                    n--;
                }
            }
            for (int i = numberOfRows - 2; i > 0; i--) {
                if (n != 0) {
                    map.merge(i, arr[start], (oldValue, newValue) -> oldValue + newValue);
                    start++;
                    n--;
                }
            }
        }
        return String.join("", map.values());

        // Another approach
        // if number of rows 4, second element in first row is 6, if rows are 5 the second element in first row is 8 i.e. numberOfRows * 2 - 2
        // for second row, the gap is numberOfRows * 2 - 1
    }

    public static void main(String[] args) {
        String str = "PAYPALISHIRING";
        int numRows = 4;
        String convertedString = convertString(str, numRows);
        System.out.println(convertedString);
    }
}
