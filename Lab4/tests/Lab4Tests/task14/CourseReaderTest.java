package Lab4.task14;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CourseReaderTest {

    @Test
    public void testReader() {
        RuntimeException mainException = assertThrows(RuntimeException.class, () -> {
            try (CourseReader reader = new CourseReader()) {
                reader.readRecord();
            }
        });

        assertEquals("Неверный формат записи", mainException.getMessage());
        assertEquals(1, mainException.getSuppressed().length);
        assertEquals("Ошибка при закрытии", mainException.getSuppressed()[0].getMessage());
    }
}