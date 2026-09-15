package complexity;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParenthesis {

    public static void main(String[] args) {
        String str = "[(])";
        Deque<Character> deque = new ArrayDeque<>();
        boolean isValid = true;
        for (char ch : str.toCharArray()) {
            if (ch == '[' || ch == '{' || ch == '(') {
                deque.offerLast(ch);
            } else {
                switch (ch) {
                    case ']' -> isValid = deque.pollLast() == '[';
                    case '}' -> isValid = deque.pollLast() == '{';
                    case ')' -> isValid = deque.pollLast() == '(';
                    default -> isValid = false;
                }
            }
        }
        System.out.println(isValid);
    }

}
