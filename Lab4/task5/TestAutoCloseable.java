package Lab4.task5;


public class TestAutoCloseable implements AutoCloseable{
    @Override
    public void close() {
        // Success test
        // System.out.println("Тест закрыт");

        // break method
        throw new RuntimeException("Ошибка при закрытии");
    }
}

