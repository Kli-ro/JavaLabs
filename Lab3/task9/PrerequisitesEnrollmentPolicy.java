package task9;

public class PrerequisitesEnrollmentPolicy implements EnrollmentPolicy {
    private final String[] requiredCourses;
    public PrerequisitesEnrollmentPolicy(String[] requiredCourses) {
        this.requiredCourses = requiredCourses;
    }
    @Override
    public boolean checkAdmission(EnrollmentData data) {
        String[] completed = data.getComplectedCourses();
        for (int i = 0; i < requiredCourses.length; i++) {
            boolean found = false;
            for (int j = 0; j < completed.length; j++) {
                if (completed[j].equals(requiredCourses[i])) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }
}
