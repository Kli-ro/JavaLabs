package Lab7.task3;

public class FailReader implements AutoCloseable{
    public void readerData() {
        System.out.println("Данные прочитаны");
    }
    @Override
    public void close() {
        System.out.println("FailReader закрыт");
    }
}
