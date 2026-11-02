package Lab4.task14;

public class CourseReader implements AutoCloseable {
    private int processedRecords = 0;

    public void readRecord() {
        processedRecords++;
        throw new RuntimeException("Неверный формат записи");
    }

    public int getProcessedRecords() {
        return processedRecords;
    }

    @Override
    public void close() {
        throw new RuntimeException("Ошибка при закрытии");
    }
}