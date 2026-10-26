package Lab3.task6;

import java.util.function.Function;

public final class Success<T> implements Result<T> {
    private final T value;

    public Success(T value) {
        this.value = value;
    }

    @Override
    public boolean isSuccess() {
        return true;
    }

    @Override
    public T getOrThrow() {
        return value;
    }

    @Override
    public <R> Result<R> map(Function<T, R> mapper) {
        return Result.success(mapper.apply(value));
    }
}
