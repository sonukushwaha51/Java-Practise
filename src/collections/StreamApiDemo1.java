package collections;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamApiDemo1 {

    public static void main(String[] args) {

        // First Non-Repeating Character (Order Sensitive)
        String string1 = "hello hi how are you";
        Map<String, Long> stringLongMap = string1.chars().mapToObj(s -> String.valueOf((char) s))
                .collect(Collectors.groupingBy(s -> s, LinkedHashMap::new, Collectors.counting()));
        stringLongMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .limit(1)
                .forEach(System.out::println);

        // Most Frequent Element in List
        Map<String, Long> mostOccurredString = stringLongMap.entrySet().stream()
                .filter(s -> !s.getKey().equals(" "))
                .max(Map.Entry.comparingByValue())
                .map(entry -> Map.of(entry.getKey(), entry.getValue()))
                .get();
        System.out.println(mostOccurredString);

        // top 3 Most Frequent Element in List
        Map<String, Long> topMostOccurredString = stringLongMap.entrySet().stream()
                .filter(s -> !s.getKey().equals(" "))
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(topMostOccurredString);

        // Group Anagrams together and also find the group with the highest size
        List<String> wordsList = Arrays.asList("eat","tea","tan","ate", "ant","hello","tat", "tit");
        Collection<List<String>> anagramsList = wordsList.stream().collect(Collectors.groupingBy(word -> {
            char[] ch = word.toCharArray();
            Arrays.sort(ch);
            return new String(ch);
        })).values();
        System.out.println(anagramsList);

        System.out.println(anagramsList.stream()
                .max(Comparator.comparingInt(List::size)).get());

        // Flatten list of list and filter string less than length of 3
        List<String> filteredList = anagramsList.stream().flatMap(Collection::stream)
                .filter(str -> str.length() > 3)
                .toList();
        System.out.println(filteredList);

        // Extract first letter of string and Convert list to map. In case of duplicate key, keep old value
        Map<String, String> stringMap = wordsList.stream()
                .collect(Collectors.toMap(s -> String.valueOf(s.charAt(0)), s -> s, (oldValue, newValue) -> oldValue));
        System.out.println(stringMap);

        // Partition person by Age threshold i.e. age > 40
        List<Person> personList = List.of(new Person("Sonu", 28),
                new Person("Deepak", 30),
                new Person("Lax", 61),
                new Person("Rajkumar", 65),
                new Person("Ravi", 31));
        Map<Boolean, List<Person>> partitionByAgeMap = personList.stream()
                .collect(Collectors.partitioningBy(person -> person.getAge() > 30));
        System.out.println(partitionByAgeMap);

        // Partition BY age threshold age > 50, but key name should be Youth and Senior citizen
        Map<String, List<Person>> stringKeyMap = personList.stream()
                .collect(Collectors.groupingBy(person -> person.getAge() > 60 ? "Senior Citizen" : "Youth"));
        System.out.println(stringKeyMap);

        // Group employees by age Threshold and then by their name first character
        Map<String, Map<String, List<Person>>> nestedMap = personList.stream()
                .collect(Collectors.groupingBy(person -> person.getAge() > 60 ? "Senior Citizen" : "Youth",
                        Collectors.groupingBy(person -> String.valueOf(person.getName().charAt(0)))));

        System.out.println(nestedMap);

        // Convert Map<K, List<V>> → Flat Map<K, V>
        Map<String, Person> personMap = stringKeyMap.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream())
                .collect(Collectors.toMap(Person::getName, p -> p));
        System.out.println(personMap);

        // Find Duplicate Elements Using Streams Only
        List<String> duplicatedList = List.of("ate", "tea","ate","hello");
        List<String> duplicates = duplicatedList.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet()
                .stream().filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println(duplicates);

        // Find Missing Number in Sequence
        Set<Integer> set = Set.of(1,4,6,7,9,13,21,2,19);
        int min = set.stream().min(Integer::compare).get();
        int max = set.stream().max(Integer::compare).get();
        List<Integer> missingNumbers = IntStream.range(min, max)
                .filter(num -> !set.contains(num))
                .boxed()
                .toList();
        System.out.println(missingNumbers);

        // Detect Palindromes in List of Strings
        List<String> palindromes = wordsList.stream()
                .filter(word -> IntStream.rangeClosed(0, word.length() / 2)
                        .allMatch(w -> word.charAt(w) == word.charAt(word.length() - w - 1)))
                .toList();
        System.out.println(palindromes);

        //First Non-Repeating Character (Order Sensitive)
        String nonRepeating = string1.chars()
                .filter(c -> string1.indexOf(c) == string1.lastIndexOf(c))
                .mapToObj(s -> String.valueOf((char) s))
                .findFirst().get();
        System.out.println(nonRepeating);


    }
}
