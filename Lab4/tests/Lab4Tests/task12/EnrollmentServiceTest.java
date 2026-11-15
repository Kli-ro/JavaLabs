package Lab4.task12;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.Random.class)
public class EnrollmentServiceTest {

    @Test
    public void testCourseJava() {
        EnrollmentService service = new EnrollmentService();
        assertEquals("Java", service.getCourseName());
    }

    @Test
    public void testSuccessEnrollment() {
        EnrollmentService service = new EnrollmentService();
        assertTrue(service.enroll("S_101"));
        assertEquals(1, service.getFreePlaces());
    }

    @Test
    public void testDuplicateEnrollment() {
        EnrollmentService service = new EnrollmentService();
        service.enroll("S_101");
        assertFalse(service.enroll("S_101"));
    }

    @Test
    public void testNoFreePlaces() {
        EnrollmentService service = new EnrollmentService();
        service.enroll("S_101");
        service.enroll("S_102");
        assertFalse(service.enroll("S_103"));
    }
}