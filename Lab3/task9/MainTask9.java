package task9;

public class MainTask9 {
    public static void main(String[] args) {
        String[] completed = {"C", "Java"};

        EnrollmentService ageService = new EnrollmentService(new AgeEnrollmentPolicy(18));
        System.out.println("Age policy (age=20): " + ageService.enroll(20, completed, 5, 10));
        System.out.println("Age policy (age=16): " + ageService.enroll(16, completed, 5, 10));

        EnrollmentService capacityService = new EnrollmentService(new CapacityEnrollmentPolicy());
        System.out.println("Capacity policy (5/10): " + capacityService.enroll(20, completed, 5, 10));
        System.out.println("Capacity policy (10/10): " + capacityService.enroll(20, completed, 10, 10));

        EnrollmentService prereqService = new EnrollmentService(
                new PrerequisitesEnrollmentPolicy(new String[]{"C", "Java"}));
        System.out.println("Prerequisites policy (has C, Java): " + prereqService.enroll(20, completed, 5, 10));
        System.out.println("Prerequisites policy (missing SQL): " + prereqService.enroll(20, completed, 5, 10));
    }
}
