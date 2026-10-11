package Lab3.task7;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GenericMain {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("Java", "Go", "C"));
        System.out.println(GenericMethod.firstOrThrow(list));

        GenericMethod.swap(list, 0, 2);
        System.out.println(list);

        Map<Integer, List<String>> byLength =
                GenericMethod.indexBy(list, String::length);
        System.out.println(byLength);

        List<String> duplicateKeys = List.of("Go", "C", "R");
        System.out.println(GenericMethod.indexBy(duplicateKeys, s -> 1));
    }
}