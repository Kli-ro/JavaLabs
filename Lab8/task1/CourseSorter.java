package task1;

import java.util.List;

public class CourseSorter {
    public static void sort(List<SortDeterm> courses) {
        courses.sort(new SortDermComp());
    }
}