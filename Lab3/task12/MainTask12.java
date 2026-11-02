package task12;

import task1.Course;

public class MainTask12 {
    public static void main(String[] args) {
        Course java = new Course(1, "Java Fundamentals", 32);
        EnrollmentService service = new EnrollmentService();

        EnrollmentResult r1 = service.enroll(java, 20, 5, 10);
        EnrollmentResult r2 = service.enroll(java, 16, 5, 10);
        EnrollmentResult r3 = service.enroll(java, 20, 10, 10);

        print(r1);
        print(r2);
        print(r3);
    }

    static void print(EnrollmentResult result) {
        switch (result) {
            case EnrollmentResult.Accepted a ->
                    System.out.println("Written on " + a.course().title());
            case EnrollmentResult.Rejected r ->
                    System.out.println("Reject on " + r.course().title() + ": " + r.reason());
            case EnrollmentResult.WaitListed w ->
                    System.out.println("Waitlist " + w.course().title()
                            + " position: " + w.position());
        }
    }
}
