package Lab4.task6;

public class CourseImporter {
    public void importCourseData(String courseID) {
        try {
            CourseParser parser = new CourseParser();
            parser.stringParser(courseID);
        } catch (NumberFormatException ex) {
            throw new ImportException("Ошибка парсинга из строки в число", ex);
        }
    }
}
