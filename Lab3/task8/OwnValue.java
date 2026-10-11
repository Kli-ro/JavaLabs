package Lab3.task8;

public class OwnValue implements Comparable<OwnValue>{
    private final int value;

    public OwnValue(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(OwnValue o) {
        return Integer.compare(this.value, o.value);
    }

    @Override
    public String toString() {
        return "OwnValue{" + value + "}";
    }
}
