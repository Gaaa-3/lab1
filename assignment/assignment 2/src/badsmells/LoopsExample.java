package badsmells;

import java.util.List;
import java.util.stream.Collectors;

/*
 * Smell: Loops
 *
 * Original: Manual for-each loop with a mutable result list hid the intent.
 * Fix: Replaced with a stream pipeline — filter then map — which reads as a
 * direct description of the transformation.
 *
 * Refactorings applied: Replace Loop with Pipeline
 */
public class LoopsExample {

    public List<String> honorStudents(List<Student> students) {
        return students.stream()
                .filter(student -> student.gpa > 3.5)
                .map(student -> student.name)
                .collect(Collectors.toList());
    }

    static class Student {
        final String name;
        final double gpa;

        Student(String name, double gpa) {
            this.name = name;
            this.gpa = gpa;
        }
    }

    public void clientCode() {
        List<Student> students = java.util.Arrays.asList(
            new Student("Nino", 3.9),
            new Student("Giorgi", 3.1),
            new Student("Maka", 3.7)
        );
        System.out.println(honorStudents(students));
    }
}
