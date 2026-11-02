package task14;

import task1.Course;

public class NewCourse {
    private final Course course;
    private final CourseFormat format;
    private final PaymentPolicy payment;

    public NewCourse(Course course, CourseFormat format, PaymentPolicy payment) {
        this.course = course;
        this.format = format;
        this.payment = payment;
    }

    public String describe() {
        return course.title() + " " + format.describe() + " " + payment.describe();
    }
}