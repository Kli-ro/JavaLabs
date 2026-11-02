package task15;

import task1.Course;

import java.util.List;

public class MainTask15 {
    public static void main(String[] args) {
        Course java = new Course(1, "Java Fundamentals", 32);

        EnrollmentRule ageRule = new AgeRule(18);
        EnrollmentRule capRule = new CapacityRule();
        EnrollmentRule prereqRule = new PrerequisitesRule(new String[]{"C", "Java"});
        EnrollmentRule minRule = new MinCompletedRule(2);
        EnrollmentRule blacklistRule = new NotBlacklistedRule(66);

        EnrollmentRule allRules = new AllOfRule(List.of(ageRule, capRule, prereqRule, minRule, blacklistRule));
        EnrollmentRule anyRules = new AnyOfRule(List.of(ageRule, capRule));

        EnrollmentEngine engine1 = new EnrollmentEngine(allRules);
        EnrollmentEngine engine2 = new EnrollmentEngine(anyRules);

        EnrollmentResult r1 = engine1.enroll(java, 20, 5, 10, new String[]{"C", "Java"});
        EnrollmentResult r2 = engine1.enroll(java, 16, 5, 10, new String[]{"C", "Java"});
        EnrollmentResult r3 = engine1.enroll(java, 20, 10, 10, new String[]{"C", "Java"});
        EnrollmentResult r4 = engine2.enroll(java, 20, 10, 10, new String[]{"C", "Java"});
        EnrollmentResult r5 = engine1.enroll(java, 20, 5, 10, new String[]{"C"});

        print(r1);
        print(r2);
        print(r3);
        print(r4);
        print(r5);
    }

    static void print(EnrollmentResult result) {
        switch (result) {
            case EnrollmentResult.Accepted a ->
                    System.out.println("Записан на " + a.course().title());
            case EnrollmentResult.Rejected r ->
                    System.out.println("Отказ на " + r.course().title() + ": " + r.reason());
        }
    }
}