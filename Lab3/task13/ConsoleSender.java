package task13;

public class ConsoleSender implements NotificationSender {
    @Override
    public void send(String message) {
        System.out.println("Console: " + message);
    }
}