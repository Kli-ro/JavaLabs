package Lab3.task1;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();

        String[] languages = {"Java", "Python", "Go", "C"};
        for (int i = 0; i < 100_000; i++) {
            arrayList.add(languages[i % languages.length]);
            linkedList.add(languages[i % languages.length]);
        }

        long start = System.nanoTime();
        for (int i = 0; i < 10_000; i++) {
            arrayList.get(i);
        }
        long arrayGet = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < 10_000; i++) {
            linkedList.get(i);
        }
        long linkedGet = System.nanoTime() - start;

        start = System.nanoTime();
        for (String s : arrayList) {
            if (s.isEmpty()) break;
        }
        long arrayIter = System.nanoTime() - start;

        start = System.nanoTime();
        for (String s : linkedList) {
            if (s.isEmpty()) break;
        }
        long linkedIter = System.nanoTime() - start;

        System.out.println("ArrayList get: " + arrayGet);
        System.out.println("LinkedList get: " + linkedGet);
        System.out.println("ArrayList iterate: " + arrayIter);
        System.out.println("LinkedList iterate: " + linkedIter);

        List<String> registry = new ArrayList<>();
        registry.add("Java");
        registry.add("Python");
        registry.add("Go");
        registry.add(1, "C");
        registry.remove("Python");
        System.out.println(registry);

        List<String> withDuplicates = new ArrayList<>(List.of("Java", "Python", "Java", "Go", "Python"));
        Set<String> unique = new LinkedHashSet<>(withDuplicates);
        System.out.println(unique);
    }
}