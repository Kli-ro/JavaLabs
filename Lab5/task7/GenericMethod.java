package Lab3.task7;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;

public final class GenericMethod {
    private GenericMethod() {
    }

    public static <T> T firstOrThrow(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new NoSuchElementException("empty list");
        }
        return list.get(0);
    }

    public static <T> void swap(List<T> list, int i, int j) {
        T tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }

    public static <T, K> Map<K, List<T>> indexBy(List<T> list, Function<T, K> keyFn) {
        Map<K, List<T>> result = new LinkedHashMap<>();
        for (T item : list) {
            K key = keyFn.apply(item);
            result.computeIfAbsent(key, k -> new ArrayList<>()).add(item);
        }
        return result;
    }
}
