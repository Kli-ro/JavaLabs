package task7;

public class RetryDecorator implements NotificationSender {
    private final NotificationSender wrapped;
    private final int attempts;

    public RetryDecorator(NotificationSender wrapped, int attempts) {
        this.wrapped = wrapped;
        this.attempts = attempts;
    }

    @Override
    public void send(String message) {
        for (int i = 1; i <= attempts; i++) {
            System.out.println("[RETRY] attempt " + i + " of " + attempts);
            wrapped.send(message);
        }
    }
}
