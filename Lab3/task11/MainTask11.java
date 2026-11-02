package task11;

public class MainTask11 {
    public static void main(String[] args) {
        Course c = new Course(1, "Java", 32);
        OnlineCourse oc = new OnlineCourse(1, "Java", 32, "Step");

        System.out.println("c.equals(oc): " + c.equals(oc));
        System.out.println("oc.equals(c): " + oc.equals(c));
    }
}
