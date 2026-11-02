package task11;

public class MainSolve11 {
    public static void main(String[] args) {
        NewCourse c = new NewCourse(1, "Java", 32);
        NewOnlineCourse oc = new NewOnlineCourse(1, "Java", 32, "Step");

        System.out.println("c.equals(oc): " + c.equals(oc));
        System.out.println("oc.equals(c): " + oc.equals(c));
    }
}