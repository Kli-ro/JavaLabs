package Lab4.task9;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CourseDurationTest {

    @Test
    public void testMinBoundary() {
        CourseDuration course = new CourseDuration();
        assertTrue(course.CheckHours(10));
    }

    @Test
    public void testBelowMinBoundary() {
        CourseDuration course = new CourseDuration();
        assertFalse(course.CheckHours(9));
    }

    @Test
    public void testMaxBoundary() {
        CourseDuration course = new CourseDuration();
        assertTrue(course.CheckHours(100));
    }

    @Test
    public void testAboveMaxBoundary() {
        CourseDuration course = new CourseDuration();
        assertFalse(course.CheckHours(101));
    }

    @Test
    public void testNormalValue() {
        CourseDuration course = new CourseDuration();
        assertTrue(course.CheckHours(50));
    }
}