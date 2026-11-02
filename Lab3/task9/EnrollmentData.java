package task9;

public class EnrollmentData {
    private final int studentAge;
    private final String[] complectedCourses;
    private final int currentEnrollment;
    private final int capacity;

    public EnrollmentData(int studentAge, String[] completedCourses, int currentEnrollment, int capacity) {
        this.studentAge = studentAge;
        this.complectedCourses = completedCourses;
        this.currentEnrollment = currentEnrollment;
        this.capacity = capacity;
    }
    public int getStudentAge() {
        return this.studentAge;
    }
    public String[] getComplectedCourses() {
        return this.complectedCourses;
    }
    public int getCurrentEnrollment() {
        return this.currentEnrollment;
    }
    public int getCapacity() {
        return this.capacity;
    }
}
