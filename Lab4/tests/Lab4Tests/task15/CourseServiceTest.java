package Lab4.task15;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class CourseServiceTest {

    CourseService service = new CourseService();

    @ParameterizedTest
    @NullAndEmptySource
    public void testNullAndEmptyStudentId(String id) {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> service.enrollStudent(id, 10, "Java", 20));
        assertEquals("Неверный ID студента: пустой или null", ex.getMessage());
    }

    @Test
    public void testStudentIdWithoutPrefix() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> service.enrollStudent("12345", 10, "Java", 20));
        assertEquals("Неверный формат ID: должен начинаться с ST-", ex.getMessage());
    }

    @Test
    public void testValidStudentId() {
        assertDoesNotThrow(() -> service.enrollStudent("S_101", 10, "Java", 20));
    }

    @Test
    public void testInfrastructureError() {
        RuntimeException ex = assertThrows(RuntimeException.class, () -> service.enrollStudent("ST-ERROR", 10, "Java", 20));
        assertEquals("Инфраструктурная ошибка базы данных", ex.getMessage());
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void testNullAndEmptyCourseName(String course) {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> service.enrollStudent("ST-101", 10, course, 20));
        assertEquals("Название курса не может быть пустым", ex.getMessage());
    }

    @Test
    public void testTooShortCourseName() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> service.enrollStudent("ST-101", 10, "Ja", 20));
        assertEquals("Название курса слишком короткое", ex.getMessage());
    }

    @Test
    public void testValidCourseName() {
        assertDoesNotThrow(() -> service.enrollStudent("ST-101", 10, "Java", 20));
    }

    @ParameterizedTest
    @ValueSource(ints = {15, 0, -5})
    public void testTooYoungStudent(int age) {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> service.enrollStudent("ST-101", 10, "Java", age));
        assertEquals("Студент слишком молод", ex.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {101, 150})
    public void testTooOldStudent(int age) {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> service.enrollStudent("ST-101", 10, "Java", age));
        assertEquals("Некорректный возраст", ex.getMessage());
    }

    @Test
    public void testValidAgeBoundaries() {
        assertDoesNotThrow(() -> service.enrollStudent("ST-101", 10, "Java", 16));
        assertDoesNotThrow(() -> service.enrollStudent("ST-102", 10, "Java", 100));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -100})
    public void testNoAvailableSeats(int seats) {
        IllegalStateException ex = assertThrows(IllegalStateException.class, () -> service.enrollStudent("ST-101", seats, "Java", 20));
        assertEquals("Нет свободных мест", ex.getMessage());
    }

    @Test
    public void testOneAvailableSeat() {
        assertDoesNotThrow(() -> service.enrollStudent("ST-101", 1, "Java", 20));
    }

    @Test
    public void testMultipleValidationErrorsPriorityIdFirst() {
        // Если пустой ID и нет мест, должно выброситься исключение про ID
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> service.enrollStudent("", 0, "Java", 20));
        assertEquals("Неверный ID студента: пустой или null", ex.getMessage());
    }

    @Test
    public void testMultipleValidationErrorsPriorityAgeBeforeSeats() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> service.enrollStudent("ST-101", 0, "Java", 10));
        assertEquals("Студент слишком молод", ex.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "S_101, 10, Java, 20",
            "S_202, 5, Python, 30",
            "S_303, 1, C++, 50"
    })
    public void testFullyValidEnrollments(String id, int seats, String course, int age) {
        assertDoesNotThrow(() -> service.enrollStudent(id, seats, course, age));
    }
}