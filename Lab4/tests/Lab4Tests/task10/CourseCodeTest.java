package Lab4.task10;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseCodeTest {

    @ParameterizedTest(name = "Код: {0}, ожидается: {1}")
    @CsvSource({
            "Crs_101, true",
            "Crs_202, true",
            "C_Java_101, false",
            "101, false",
            "Crs, false"
    })
    public void testIsValidCode(String inputCode, boolean expectedResult) {
        CourseCode validator = new CourseCode();
        boolean actualResult = validator.isValidCode(inputCode);
        assertEquals(expectedResult, actualResult);
    }
}