package task4;

public class ConsoleSender extends AbstractNotificationSender {
    @Override
    protected void doSend(String message) {
        System.out.println("Console: " + message);
    }
}
