import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {

        String s = "apple";

        Character firstUnique = s.chars() // IntStream of character codes
                .mapToObj(c -> (char) c)  // convert to Character stream
                .collect(Collectors.groupingBy(
                        Function.identity(), LinkedHashMap::new, Collectors.counting())) // maintain order
                .entrySet().stream()
                .filter(e -> e.getValue() == 1) // only unique chars
                .map(Map.Entry::getKey)
                .findFirst() // get the first unique
                .orElse(null); // return null if none found

        System.out.println(firstUnique); // Output: 'a' for "apple" → but note it's not unique, so actually 'l'

     char[] characters = s.toCharArray();
        for (Character character : characters) {
            System.out.println(character);
        }

        }
}
