package task2;

public class ConsoleSender implements NotificationSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("Console: " + message);
    }

    public void sendMessage(String message, boolean flag) {
        if (flag) {
            System.out.println("Console: " + message + " " + "flag: " + flag);
        }
        else {
            System.out.println("Console: " + message);
        }
    }
}



