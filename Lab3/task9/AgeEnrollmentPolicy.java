package task9;

public class AgeEnrollmentPolicy implements EnrollmentPolicy {
    private final int minAge;
    public AgeEnrollmentPolicy(int minAge) {
        this.minAge = minAge;
    }
    @Override
    public boolean checkAdmission(EnrollmentData data) {
        return data.getStudentAge() >= minAge;
    }
}
