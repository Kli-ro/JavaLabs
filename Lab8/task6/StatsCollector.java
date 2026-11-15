package task6;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class StatsCollector implements Collector<Integer, StatsAccumulator, Stats> {
    @Override
    public Supplier<StatsAccumulator> supplier() {
        return StatsAccumulator::new;
    }

    @Override
    public BiConsumer<StatsAccumulator, Integer> accumulator() {
        return StatsAccumulator::accept;
    }

    @Override
    public BinaryOperator<StatsAccumulator> combiner() {
        return StatsAccumulator::combine;
    }

    @Override
    public Function<StatsAccumulator, Stats> finisher() {
        return StatsAccumulator::finish;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.noneOf(Characteristics.class));
    }
}