package complexity;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SegregateNumberAndString {

    public static void main(String[] args) {

        // input adsyd132a1f35s
        // output = adsydafs,132135

        String s = "adsyd132a1f35s";
        List<String> list = List.of(s.split(""));
//
        // Using flags in Pattern compile
//        String numRegex = Pattern.compile("[0-9]", Pattern.CASE_INSENSITIVE).pattern();

        String num = list.stream().filter(elem -> Pattern.matches("[0-9]", elem)).collect(Collectors.joining());
        String str = list.stream().filter(elem -> !Pattern.matches("[0-9]", elem)).collect(Collectors.joining());

        System.out.println(str + "," + num);
    }
}
