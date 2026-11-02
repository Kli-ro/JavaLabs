package task8;

import java.util.List;

public class MainTask8 {
    public static void main(String[] args) {
        MemoryCourseRepository fullRepo = new MemoryCourseRepository();
        fullRepo.save(new NewCourseT8(1, "Java"));
        fullRepo.save(new NewCourseT8(2, "SQL"));

        OnReadCourseRepository readOnlyRepo =
                new OnReadCourseRepository(List.of(
                        new NewCourseT8(10, "Python"),
                        new NewCourseT8(11, "Go")));

        CourseReader reader1 = fullRepo;
        CourseReader reader2 = readOnlyRepo;

        System.out.println("full findById(1):   " + reader1.findById(1));
        System.out.println("readOnly findById(10): " + reader2.findById(10));

        CourseWriter writer = fullRepo;
        writer.save(new NewCourseT8(3, "Kotlin"));

        System.out.println("All find: " + reader1.findAll());
    }
}
