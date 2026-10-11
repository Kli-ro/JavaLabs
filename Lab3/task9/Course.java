package Lab3.task9;

public class Course {
    private final String code;

    public Course(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return code;
    }
}
