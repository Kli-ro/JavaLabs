package Lab4.task3;

public class RejectedException extends RuntimeException{
    public RejectedException(String studentID, String courseID, Throwable cause) {
        String text = "Студент: " + studentID + " отказано в курсе: " + courseID;
        super(text, cause);
    }

    public String toString() {
        return "Отказ в записи на курс(без показа данных)";
    }
}
