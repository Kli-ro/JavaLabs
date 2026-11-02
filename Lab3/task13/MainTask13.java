package task13;

public class MainTask13 {
    public static void main(String[] args) {
        NotificationSender s1 = SenderFactory.create("email");
        NotificationSender s2 = SenderFactory.create("console");
        NotificationSender s3 = SenderFactory.create("message");

        s1.send("Course Java update");
        s2.send("Course Java update");
        s3.send("Course Java update");
    }
}