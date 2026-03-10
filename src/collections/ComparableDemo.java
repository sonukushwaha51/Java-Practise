package collections;

import java.util.Collections;

public class ComparableDemo implements Comparable<Integer> {

    private Integer value;

    public ComparableDemo(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public int compareTo(Integer integer) {
        return this.value - integer;
    }
}

class ComparableMain {
    public static void main(String[] args) {

        ComparableDemo comparableDemo = new ComparableDemo(52);
        int i = comparableDemo.compareTo(67);
        System.out.println(i);
    }
}
