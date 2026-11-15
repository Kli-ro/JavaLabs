package Lab4.task11;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CourseEnrollmentTest {

    @Test
    public void testEnrollThrowsException() {
        CourseEnrollmentService service = new CourseEnrollmentService();

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> service.enroll(null)
        );

        assertEquals("ID студента не может быть пустым", exception.getMessage());
        assertEquals(0, service.getEnrolledCount());
    }
}