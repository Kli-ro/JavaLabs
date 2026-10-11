package Lab3.task13;
import java.util.HashSet;
import java.util.Set;

public class InvertedMain {
    public static void main(String[] args) {
        InvertedIndex index = new InvertedIndex();
        index.addCourse("CS101", new HashSet<>(Set.of("java", "backend")));
        index.addCourse("CS102", new HashSet<>(Set.of("java", "algo")));
        index.addCourse("CS103", new HashSet<>(Set.of("python", "ml")));

        System.out.println(index.coursesByTag("java"));
        System.out.println(index.tagsOf("CS101"));
        System.out.println(index.coursesByAllTags(new HashSet<>(Set.of("java", "backend"))));

        index.removeCourse("CS101");
        System.out.println(index.coursesByTag("java"));
        System.out.println(index.coursesByTag("backend"));
    }
}
