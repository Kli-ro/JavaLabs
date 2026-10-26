package Lab3.task8;

import java.util.List;

public final class MaxUtil {
    private MaxUtil() {
    }

    public static <T extends Comparable<? super T>> T max(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("empty");
        }
        T best = list.get(0);
        for (T item : list) {
            if (item.compareTo(best) > 0) {
                best = item;
            }
        }
        return best;
    }
}
