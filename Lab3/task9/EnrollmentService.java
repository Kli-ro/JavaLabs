package task9;

public class EnrollmentService {
    private final EnrollmentPolicy policy;

    public EnrollmentService(EnrollmentPolicy policy) {
        this.policy = policy;
    }

    public boolean enroll(int age, String[] completed, int current, int capacity) {
        EnrollmentData data = new EnrollmentData(age, completed, current, capacity);
        return policy.checkAdmission(data);
    }
}
