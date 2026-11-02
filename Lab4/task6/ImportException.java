package Lab4.task6;

public class ImportException extends RuntimeException{
    public ImportException(String failText, Throwable cause) {
        super(failText, cause);
    }
}
