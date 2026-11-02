package task4;

public class EmailSender extends AbstractNotificationSender {
    @Override
    protected void doSend(String message) {
        System.out.println("Email: " + message);
    }
}
