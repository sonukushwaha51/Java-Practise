package collections;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class MatcherDemo {

    public static void main(String[] args) {
        String text = "Order #1234, Order #5678, Order #9101 are placed";
        String regex = "[\\d]+";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(text);
       // matcher.find scans the complete string to find a specific pattern.
       // In this case, it will scan the complete string to find any numerical value
        while (matcher.find()) {
            // matcher group is used to print the match
            System.out.println("Match found "+ matcher.group());
            // gives starting index of match
            System.out.println("At index "+ matcher.start());

            // gives ending index of match
            System.out.println("At index "+ matcher.end());
        }

        // MatchResult returns stream of Matches
        // We need to reset the matcher as in earlier code matcher has already moved to the end index.
        // Hence, we need to reset matcher to start from the beginning again
        matcher.reset();
        Stream<MatchResult> result = matcher.results();
        result.forEach(matchResult -> System.out.println(matchResult.group()));

        // matcher.matches validates the complete string against a pattern
        // best for validating email or phone numbers
        Pattern emailPattern = Pattern.compile("[a-z0-9.]+@[a-z]+.[a-z]+", Pattern.CASE_INSENSITIVE);
        String email = "sonukush.90@gmail.com";
        Matcher matcher1 = emailPattern.matcher(email);
        System.out.println(matcher1.matches());


    }
}
