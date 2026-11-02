package Lab4.task3;

public class MainTask3 {
    public static void main(String[] args) {
        // create obj exception reason
        Throwable exceptReason = new IllegalArgumentException("Нет свободных мест");
        RejectedException rejectEx = new RejectedException("S_VR07", "C_J01", exceptReason);

        System.out.println(rejectEx);
        System.out.println(rejectEx.getCause());
    }
}
