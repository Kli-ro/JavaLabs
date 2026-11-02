package task7;

public class MainTask7 {
    public static void main(String[] args) {
        NotificationSender base = new EmailSender();

        System.out.println("Logging - Retry - Metrics");
        NotificationSender order1 = new MetricsDecorator(
                new RetryDecorator(
                        new LoggingDecorator(base), 2));
        order1.send("order 1");

        System.out.println();
        System.out.println("Metrics - Retry - Logging");
        NotificationSender order2 = new LoggingDecorator(
                new RetryDecorator(
                        new MetricsDecorator(base), 2));
        order2.send("order 2");
    }
}
