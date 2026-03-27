package collections.internals;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackUsingDequeue {

    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(5);
        System.out.println(deque.peek());
        deque.removeLast();
        System.out.println(deque.peek());
    }
}
