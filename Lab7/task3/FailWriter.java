package Lab7.task3;

public class FailWriter implements AutoCloseable {
    public void writerData(){
        System.out.println("Данные записаны");
    }

    @Override
    public void close() {
        System.out.println("FailWriter закрыт");
    }
}
