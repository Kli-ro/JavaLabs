package Lab4.task15;

public class CourseService {
    public void enrollStudent(String studentId, int availableSeats, String courseName, int studentAge) {
        if (studentId == null || studentId.isEmpty()) {
            throw new IllegalArgumentException("Неверный ID студента: пустой или null");
        }
        if (!studentId.startsWith("ST-")) {
            throw new IllegalArgumentException("Неверный формат ID: должен начинаться с S");
        }

        if (courseName == null || courseName.isEmpty()) {
            throw new IllegalArgumentException("Название курса не может быть пустым");
        }
        if (courseName.length() < 3) {
            throw new IllegalArgumentException("Название курса слишком короткое");
        }

        if (studentAge < 16) {
            throw new IllegalArgumentException("Студент слишком молод");
        }
        if (studentAge > 100) {
            throw new IllegalArgumentException("Некорректный возраст");
        }

        if (availableSeats <= 0) {
            throw new IllegalStateException("Нет свободных мест");
        }

        if (studentId.equals("S-ERROR")) {
            throw new RuntimeException("Инфраструктурная ошибка базы данных");
        }
    }
}