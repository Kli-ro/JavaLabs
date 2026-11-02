package task9;

public class CapacityEnrollmentPolicy implements EnrollmentPolicy {
    @Override
    public boolean checkAdmission(EnrollmentData data) {
        if (data.getCurrentEnrollment() < data.getCapacity()) {
            return true;
        }
        else
            return false;
    }
}
