package Lab3.task9;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<OnlineCourse> source = List.of(new OnlineCourse("Java"));
        List<Course> target = new ArrayList<>();

        Pecs.copy(source, target);
        System.out.println(target);

        List<? extends Course> producer = source;
        Course c = producer.get(0);
        System.out.println(c);

        List<? super Course> consumer = target;
        consumer.add(new Course("Python"));
        System.out.println(target);
    }
}
