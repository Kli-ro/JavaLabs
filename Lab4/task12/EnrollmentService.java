package Lab4.task12;

import java.util.ArrayList;

public class EnrollmentService {
    private String courseName = "Java";
    private int freePlaces = 2;
    private ArrayList<String> students = new ArrayList<>();

    public boolean enroll(String studentId) {
        if (freePlaces <= 0 || students.contains(studentId)) {
            return false;
        }
        students.add(studentId);
        freePlaces--;
        return true;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getFreePlaces() {
        return freePlaces;
    }
}