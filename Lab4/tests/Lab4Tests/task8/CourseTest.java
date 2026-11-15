package Lab4.task8;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseTest {
    @Test
    public void testGetHours() {
        // Arrange
        CompletedHours course = new CompletedHours();

        // Act
        int result = course.getHours(5);

        // Assert
        assertEquals(5, result);
        // если изменить значение на 100, будет падающий тест
    }
}
