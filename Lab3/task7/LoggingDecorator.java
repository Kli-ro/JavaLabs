package task7;

public class LoggingDecorator implements NotificationSender {
    private final NotificationSender wrapped;

    public LoggingDecorator(NotificationSender wrapped) {
        this.wrapped = wrapped;
    }
    @Override
    public void send(String message) {
        System.out.println("[LOG] before send: " + message);
        wrapped.send(message);
        System.out.println("[LOG] after send: " + message);
    }
}
