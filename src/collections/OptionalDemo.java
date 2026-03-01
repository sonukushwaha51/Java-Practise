package collections;

import java.util.*;

public class OptionalDemo {

    static String string = null;

    static Optional<String> fetchString() {
        return Optional.ofNullable(string);
    }

    public static void main(String[] args) {
        String string1 = "Hello";
        String string2  = "world";

        List<String> list = Arrays.asList(string1.split(""));
        Map<String, Integer> map = new HashMap<>();
        for (String str : string2.split("")) {
            if (list.contains(str)) {
                System.out.println("Common letter found "+ str);
                map.merge(str, 1, Integer::sum);
            }
        }
        System.out.println(map);

        string = "Hello";

        // Optional Demo. If present takes consumer function i.e. takes input, returns void
        fetchString().ifPresentOrElse(System.out::println, () -> System.out.println("S"));

        // Throws NoSuchElementException by default
        //String optional = fetchString().orElseThrow();

        // Throws any other custom exception
        //String optional1 = fetchString().orElseThrow(RuntimeException::new);

        // Use of OrElse, it accepts a value which is returned if optional returns null
        String optional2 = fetchString().orElse("No String");
        System.out.println(optional2);

        // Use of OrElseGet, it accepts a supplier which is returned if optional returns null
        String optional3 = fetchString().orElseGet(() -> "No string after executing or else get");
        System.out.println(optional3);
    }
}
