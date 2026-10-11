package Lab3.task6;

import java.util.function.Function;

public interface Result<T> {
    boolean isSuccess();
    T getOrThrow();
    <R> Result<R> map(Function<T, R> mapper);

    static <T> Result<T> success(T value) {
        return new Success<>(value);
    }

    static <T> Result<T> failure(String message) {
        return new Failure<>(message);
    }
}