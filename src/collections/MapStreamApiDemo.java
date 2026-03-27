package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;

public class MapStreamApiDemo {

    public static void main(String[] args) {

        Map<String, String> map = Map.of("India", "Asia", "Srilanka", "Asia", "Japan","Asia"
                ,"UK", "Europe", "Netherlands","Europe", "Canada", "North America", "Mexico", "North America"
                , "Brazil", "South America", "Chile", "South America");
        // ---------------------Map-------------------------------------------------

        // Map operations
        // find occurrence of countries in each continent
        Map<String, Long> occurenceMap = map.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.counting()));
        System.out.println(occurenceMap);

        // Above can also be achieved by using map merge method

        Map<String, Integer> mergeMap = new HashMap<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            mergeMap.merge(entry.getValue(), 1, Integer::sum);
        }
        System.out.println(mergeMap);

        // Difference between put and replace:
        // Put is Add or Update operation. If key does not exist it will add or else update the existing key
        // Replace will only replace if key exists otherwise it will ignore
        mergeMap.replace("Australia", 1); // will be ignored since key is not present
        System.out.println(mergeMap);

        // ReplaceAll accepts a BiConsumer. It is used when we want to apply some change across all values
        mergeMap.replaceAll((k,v) -> v * 2);
        System.out.println(mergeMap);

        // Map computeIfAbsent and putIfAbsent
        // computeIfAbsent puts the value in map if key is not present, then it calculates the value to be put.
        //Value takes a function
        // computeIfPresent is also same. it will compute the value if key is present
        Map<String, Person> personMap = new HashMap<>();
        Person person = new Person("abc@gmail.com");

        personMap.computeIfAbsent(person.getEmail(), newPerson -> new Person(person.getName(), person.getEmail(),
                "827927223", 26, new ArrayList<>()));

        //putIfAbsent --> Puts the value in map if key is absent otherwise it is ignored
        mergeMap.put("Australia", 1);
        mergeMap.putIfAbsent("Australia", 5); // ignored
        mergeMap.putIfAbsent("Africa", 3); // accepted
        System.out.println(mergeMap);

    }
}
