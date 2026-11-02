package Lab4.task7;

public class MainTask7 {
    public static void main(String[] args) {
        CourseFind course = new CourseFind();

        System.out.println("Поиск Java: " + course.findCourse("Java"));
        System.out.println("Поиск пустой строки: " + course.findCourse(""));

        PriceCalculator price = new PriceCalculator();
        try {
            price.calculatePrice(-100);
        } catch (CalculationException ex) {
            System.out.println("Ошибка: " + ex.getMessage());
        }

        System.out.println("Запись на курс");
        CourseEnrollment newStudent = new CourseEnrollment();

        System.out.println("Студент S_VR07: " + newStudent.enroll("S_VR07"));
        System.out.println("Студент S_VR07: " + newStudent.enroll("S_VR07"));
        System.out.println("Студент S_SA07: " + newStudent.enroll("S_SA07"));


    }

}
