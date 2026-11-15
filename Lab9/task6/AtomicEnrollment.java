package Lab9.task6;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicEnrollment implements CourseEnrollment {
    private final AtomicInteger currentEnrolled = new AtomicInteger(0);
    private final Map<String, Boolean> registeredStudents = new ConcurrentHashMap<>();
    private final int capacity;

    public AtomicEnrollment(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean enroll(String studentId) {
        if (registeredStudents.putIfAbsent(studentId, true) != null) {
            return false;
        }
        if (currentEnrolled.incrementAndGet() > capacity) {
            currentEnrolled.decrementAndGet();
            registeredStudents.remove(studentId);
            return false;
        }
        return true;
    }

    @Override
    public int getEnrolledCount() {
        return currentEnrolled.get();
    }
}