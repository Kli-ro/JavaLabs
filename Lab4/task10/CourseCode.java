package Lab4.task10;

public class CourseCode {
    public boolean isValidCode(String code) {
        if (code == null || code.isEmpty()) {
            return false;
        }
        return code.startsWith("Course: ");
    }
}
