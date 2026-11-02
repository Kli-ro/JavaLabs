package task13;

public class SenderFactory {
    public static NotificationSender create(String type) {
        return switch (type) {
            case "email" -> new EmailSender();
            case "console" -> new ConsoleSender();
            case "sms" -> new MessageSender();
            default -> throw new IllegalArgumentException("Unknown type: " + type);
        };
    }
}