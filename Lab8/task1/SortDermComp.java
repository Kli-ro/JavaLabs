package task1;

import java.util.Comparator;

public class SortDermComp implements Comparator<SortDeterm> {
    @Override
    public int compare(SortDeterm obj1, SortDeterm obj2) {
        int levelResult = obj1.getLevel().compareTo(obj2.getLevel());
        if (levelResult != 0)
            return levelResult;

        int durationResult = Integer.compare(obj1.getDuration(), obj2.getDuration());
        if (durationResult != 0)
            return durationResult;

        return obj1.getCode().compareTo(obj2.getCode());
    }

}
