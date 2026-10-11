package Lab3.task10;
import java.util.Objects;

public class ChangeCourse {
    private String code;
    private String title;

    public ChangeCourse(String code, String title) {
        this.code = code;
        this.title = title;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChangeCourse)) return false;
        ChangeCourse that = (ChangeCourse) o;
        return Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return code + ":" + title;
    }

}
