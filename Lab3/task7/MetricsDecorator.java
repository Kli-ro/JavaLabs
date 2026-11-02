package task7;

public class MetricsDecorator implements NotificationSender {
    private final NotificationSender wrapped;
    private int counter = 0;

    public MetricsDecorator(NotificationSender wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public void send(String message) {
        counter++;
        wrapped.send(message);
        System.out.println("[METRICS] sends: " + counter);
    }
}
