package task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<SortDeterm> list1 = new ArrayList<>(List.of(
                new SortDeterm("B", 10, "C2"),
                new SortDeterm("A", 20, "C1"),
                new SortDeterm("A", 10, "C3")
        ));
        List<SortDeterm> list2 = new ArrayList<>(list1);
        Collections.shuffle(list2);

        CourseSorter.sort(list1);
        CourseSorter.sort(list2);

        System.out.println(list1.equals(list2));
        System.out.println(list1);
    }
}