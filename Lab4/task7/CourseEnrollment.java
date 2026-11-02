package Lab4.task7;

import java.util.ArrayList;
import java.util.List;

public class CourseEnrollment {

    int freePlaces = 2;
    ArrayList<String> enrollStudentID = new ArrayList<>();


    public Boolean enroll(String studentID) {
        if (freePlaces <= 0 || enrollStudentID.contains(studentID)) {
            return false;
        }
        enrollStudentID.add(studentID);
        freePlaces--;
        return true;

    }
}
