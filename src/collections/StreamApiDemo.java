package collections;

import java.util.*;
import java.util.stream.Collectors;

public class StreamApiDemo {

    public static void main(String[] args) {

        // Find the longest string without repeating characters
        String longestString = "";
        List<String> list = List.of("hello", "hungry", "nascomed", "apple", "giraffe");
        longestString = list.stream()
                .filter(word -> word.chars().distinct().count() == word.length())
                .sorted(Comparator.comparing(String::length).reversed())
                .limit(1)
                .collect(Collectors.joining());
        System.out.println(longestString);

        // Return a map by grouping the list of elements by first letter as key
        Map<String, List<String>> map = list.stream().collect(Collectors.groupingBy(word -> {
            char[] ch = word.toCharArray();
            return String.valueOf(ch[0]);
        }));
        System.out.println(map);

        // Find most occurring character in a string
        String str = "pineapple";
        String result = str.chars().mapToObj(s -> String.valueOf((char) s))
                        .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                                .entrySet().stream()
                        .max(Map.Entry.comparingByValue())
                                .map(Map.Entry::getKey)
                                        .get();
        System.out.println(result);

    }
}
