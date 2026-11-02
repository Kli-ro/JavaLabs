package Lab4.task6;

public class MainTask6 {
    public static void main(String[] args) {
        CourseImporter importObj = new CourseImporter();

        try {
            importObj.importCourseData("Java_1");
        } catch (ImportException ex) {
            System.out.println("Ошибка импорта: " + ex.getMessage() + "\n" +"Исходная ошибка: " + ex.getCause());
        }
    }
}
