package task2;

public class EmailSender implements NotificationSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("Email: " + message);
    }
    public void sendMessage(String message, boolean flag) {
        if (flag) {
            System.out.println("Email: " + message + " " + "flag: " + flag);
        }
        else {
            System.out.println("Email: " + message);
        }
    }
}
