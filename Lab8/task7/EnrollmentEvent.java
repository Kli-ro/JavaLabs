package task7;

public class EnrollmentEvent {
    private final long studentId;
    private final long courseId;
    private final String level;
    private final boolean completed;

    public EnrollmentEvent(long studentId, long courseId, String level, boolean completed) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.level = level;
        this.completed = completed;
    }

    public long getStudentId() { return studentId; }
    public long getCourseId() { return courseId; }
    public String getLevel() { return level; }
    public boolean isCompleted() { return completed; }
}