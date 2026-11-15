package Lab9.task6;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentCollectionEnrollment implements CourseEnrollment {
    private final Set<String> enrolled = ConcurrentHashMap.newKeySet();
    private final int capacity;

    public ConcurrentCollectionEnrollment(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean enroll(String studentId) {
        if (enrolled.add(studentId)) {
            if (enrolled.size() > capacity) {
                enrolled.remove(studentId);
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public int getEnrolledCount() {
        return enrolled.size();
    }
}