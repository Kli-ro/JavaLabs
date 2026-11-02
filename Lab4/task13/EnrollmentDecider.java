package Lab4.task13;

public class EnrollmentDecider {
    public String decide(boolean hasFreePlaces, boolean hasPrerequisite, boolean isDuplicate) {
        if (isDuplicate) {
            return "Отклонено";
        }
        if (!hasPrerequisite) {
            return "Отклонено, нет переквизита";
        }
        if (!hasFreePlaces) {
            return "Отклонено, нет мест";
        }
        return "Зачислен";
    }
}