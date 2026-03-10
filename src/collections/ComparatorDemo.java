package collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComparatorDemo implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getAge() - o2.getAge() == 0) {
            return o1.getName().compareTo(o2.getName());
        }
        return o1.getAge() - o2.getAge();
    }
}

class ComparatorMain {

    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setAge(35);
        p1.setName("Sonu");
        Person p2 = new Person();
        p2.setAge(35);
        p2.setName("Deepak");

        List<Person> list = Arrays.asList(p1, p2);
        List<Person> sortedList = list.stream().sorted(new ComparatorDemo()).toList();
        System.out.println(sortedList.get(0).getAge() + ", " + sortedList.get(0).getName());
    }
}
