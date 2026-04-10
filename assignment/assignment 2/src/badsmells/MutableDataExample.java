package badsmells;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Smell: Mutable Data
 *
 * Original: getEnrolledStudents() returned the internal list directly, allowing
 * callers to mutate it without the class knowing.
 * Fix: Return an unmodifiable view so only enroll() can add students.
 *
 * Refactorings applied: Encapsulate Field
 */
public class MutableDataExample {

    private final List<String> enrolledStudents = new ArrayList<>();

    public List<String> getEnrolledStudents() {
        return Collections.unmodifiableList(enrolledStudents);
    }

    public void enroll(String studentId) {
        enrolledStudents.add(studentId);
    }

    public void clientCode() {
        enroll("s-1001");
        List<String> students = getEnrolledStudents();
        // students.clear(); // would now throw UnsupportedOperationException — correct behavior
        System.out.println(getEnrolledStudents().size());
    }
}
