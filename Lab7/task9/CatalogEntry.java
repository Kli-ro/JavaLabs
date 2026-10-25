package Lab7.task9;

public class CatalogEntry {
    private final String name;
    private final int hours;
    private final String level;

    public CatalogEntry(String name, int hours, String level) {
        this.name = name;
        this.hours = hours;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getHours() {
        return hours;
    }

    public String getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "CatalogEntry{name='" + name + "', hours=" + hours + ", level='" + level + "'}";
    }
}