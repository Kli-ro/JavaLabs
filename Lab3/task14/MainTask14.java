package task14;

import task1.Course;

public class MainTask14 {
    public static void main(String[] args) {
        Course java = new Course(1, "Java Fundamentals", 32);

        NewCourse c1 = new NewCourse(java, new OnlineFormat(), new FreePayment());
        NewCourse c2 = new NewCourse(java, new ClassroomFormat(), new FixedPayment(8000));
        NewCourse c3 = new NewCourse(java, new HybridFormat(), new SubscriptionPayment("month"));

        System.out.println(c1.describe());
        System.out.println(c2.describe());
        System.out.println(c3.describe());
    }
}