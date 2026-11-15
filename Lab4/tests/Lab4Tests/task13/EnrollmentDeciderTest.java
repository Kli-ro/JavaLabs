package Lab4.task13;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnrollmentDeciderTest {

    @Test
    public void testDuplicate() {
        EnrollmentDecider decider = new EnrollmentDecider();
        assertEquals("Отклонено", decider.decide(true, true, true));
    }

    @Test
    public void testPrerequisite() {
        EnrollmentDecider decider = new EnrollmentDecider();
        assertEquals("Отклонено, нет переквизита", decider.decide(true, false, false));
    }

    @Test
    public void testFreePlaces() {
        EnrollmentDecider decider = new EnrollmentDecider();
        assertEquals("Отклонено, нет мест", decider.decide(false, true, false));
    }

    @Test
    public void testSuccess() {
        EnrollmentDecider decider = new EnrollmentDecider();
        assertEquals("Зачислен", decider.decide(true, true, false));
    }
}