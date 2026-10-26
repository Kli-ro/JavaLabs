package Lab3.task5;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModificationExceptionMain {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("Java", "Python", "Go", "C"));

        try {
            for (String s : list) {
                if (s.equals("Python")) {
                    list.remove(s);
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("CME caught: " + e);
        }

        list = new ArrayList<>(List.of("Java", "Python", "Go", "C"));
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (s.equals("Python")) {
                it.remove();
            }
        }
        System.out.println("after iterator: " + list);

        list = new ArrayList<>(List.of("Java", "Python", "Go", "C"));
        list.removeIf(s -> s.equals("Python"));
        System.out.println("after removeIf: " + list);

        List<String> copy = new ArrayList<>(list);
        copy.removeIf(s -> s.equals("Go"));
        System.out.println("copy: " + copy + ", original: " + list);
    }
}