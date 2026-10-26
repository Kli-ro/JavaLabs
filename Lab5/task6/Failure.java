package Lab3.task6;
import java.util.function.Function;

public final class Failure<T> implements Result<T>{
    private final String message;

    public Failure(String message) {
        this.message = message;
    }

    @Override
    public boolean isSuccess() {
        return false;
    }

    @Override
    public T getOrThrow() {
        throw new IllegalStateException(message);
    }

    @Override
    public <R> Result<R> map(Function<T, R> mapper) {
        return Result.failure(message);
    }
}
