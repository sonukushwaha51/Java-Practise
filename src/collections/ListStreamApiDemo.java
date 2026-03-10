package collections;

import java.util.*;
import java.util.stream.Collectors;

public class ListStreamApiDemo {

    public static void main(String[] args) {
        List<String> stringList = List.of("apple", "banana", "grapes", "guava", "apple", "grapes", "strawberry");

        // Remove duplicates from list
        List<String> uniqueList = stringList.stream().distinct().toList();
        System.out.println(uniqueList);

        // Remove duplicates, skip first two and then return 3 elements
        List<String> shortenedList = stringList.parallelStream().distinct().skip(2).limit(3).toList();
        System.out.println(shortenedList);

        // Spliterator --> Spliterator was introduced in java 8 for parallel processing
        // when we call parallelStream, it internally first calls spliterator anf then trySplit method of spliterator
        Spliterator<String> splittedString = stringList.spliterator();
        Spliterator<String> spl1 = splittedString.trySplit();
        spl1.forEachRemaining(System.out::println);
        System.out.println("Second half");
        splittedString.forEachRemaining(System.out::println);

        // Peek --> Used to debug the collection. It is intermediate operation
        // map  --> Returns a new transformation for each item
        List<String> transformedList = stringList.stream().peek(System.out::println)
                .map(String::toUpperCase).toList();
        System.out.println(transformedList);

        // Sort in descending using comparator and return comma separated string
        String sortedString = stringList.stream().sorted().collect(Collectors.joining(", "));
        System.out.println(sortedString);

        // List retainALl -> Will retain elements which are there in stringList
        List<String> stringList1 = new ArrayList<>();
        stringList1.add("banana");
        stringList1.add("Kiwi");
        stringList1.retainAll(stringList);
        System.out.println(stringList1);

        // Modify all contents of list uniformly
        stringList1.replaceAll(String::toUpperCase);
        System.out.println(stringList1);

        // Given list of Numbers in string. find its average
        List<String> numStringList = Arrays.asList("1","5","7","9","14","67");
        OptionalDouble average = numStringList.stream().mapToInt(Integer::parseInt).average();
        if (average.isPresent()) {
            System.out.println(average.getAsDouble());
        }

        // Subtract all values
        long subtraction = numStringList.stream().mapToInt(Integer::parseInt).reduce(0, (a , b) -> a - b);
        System.out.println(subtraction);



    }
}
