package Lab3.task9;
import java.util.List;

public class Pecs {
    private Pecs() {
    }
    public static void copy(List<? extends Course> src, List<? super Course> dst) {
        for (Course c : src) {
            dst.add(c);
        }
    }
}
