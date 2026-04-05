package collections;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringToMap {

    public static void main(String[] args) {

        String items = "non-veg,chicken      #  veg,  paneer     #    non-veg    , fish        #    fruit ,   banana  #   fruit ,   apple";
        items = items.replaceAll("\\s", "");
        List<String> list = Arrays.asList(items.split("#"));
        Map<String, List<String>> map = list.stream().collect(Collectors.groupingBy(word -> {
            String[] arr = word.split(",");
            return arr[0];
        }, Collectors.collectingAndThen(
                Collectors.toList(),
                word -> word.stream().map(s -> s.split(",")[1]).toList()
                )));

        System.out.println(map);
    }
}
