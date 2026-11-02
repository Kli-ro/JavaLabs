package task4;

public abstract class AbstractNotificationSender {
    public final void send(String message) {
        if (message != null) {
            String newMess = message.trim();
            if (!newMess.isEmpty()) {
                doSend(newMess);
            }
            else
                System.out.println("Message null");
        }
        else
            System.out.println("Message null");
    }
    protected abstract void doSend(String message);
}
