package task1;

import task2.ConsoleSender;
import task2.EmailSender;
import task2.NotificationSender;

public class Main {
    public static void main(String[] args) {
        // task1
        Course javaCourse = new Course(10, "Java course", 16);

        CourseFormatter formatter = new CompactCourseFormatter();
        System.out.println(formatter.format(javaCourse));

        formatter = new DetailedCourseFormatter();
        System.out.println(formatter.format(javaCourse));

        // task2
        NotificationSender message = new EmailSender();
        message.sendMessage("No problem");

        message = new ConsoleSender();
        message.sendMessage("No problem");

        EmailSender em_message = new EmailSender();
        em_message.sendMessage("Override email message");
        em_message.sendMessage("Overload email message", true);

        ConsoleSender cns_message = new ConsoleSender();
        cns_message.sendMessage("Override console message");
        cns_message.sendMessage("Overload cns message", true);

        // task3
        CourseFormatter[] arrFormatters = {new CompactCourseFormatter(), new DetailedCourseFormatter(), new ArrCourseFormatter()};

        for (int i = 0; i < arrFormatters.length; i++) {
            System.out.println(arrFormatters[i].format(javaCourse));
        }
    }
}