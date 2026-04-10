package badsmells;

/*
 * Smell: Data Class
 *
 * Original: StudentRecord was a passive data bag with public fields. All behavior
 * lived in three separate evaluator classes that reached into the data.
 * Fix: Made fields private, added a constructor, and moved the three behaviors
 * into StudentRecord as cohesive methods.
 *
 * Refactorings applied: Move Method, Encapsulate Field
 */
public class DataClassExample {

    public static class StudentRecord {
        private final String name;
        private final int credits;
        private final double gpa;

        public StudentRecord(String name, int credits, double gpa) {
            this.name = name;
            this.credits = credits;
            this.gpa = gpa;
        }

        public boolean isEligibleForHonors() {
            return credits >= 30 && gpa >= 3.7;
        }

        public double tuitionDiscountPercent() {
            if (gpa >= 3.8) return 0.15;
            if (gpa >= 3.5) return 0.10;
            return 0.0;
        }

        public String describeAcademicStanding() {
            if (gpa < 2.0)      return name + " is on academic probation";
            if (credits < 15)   return name + " is a new student";
            return name + " is in good standing";
        }
    }

    public void clientCode() {
        StudentRecord student = new StudentRecord("Nino", 32, 3.8);

        System.out.println(student.isEligibleForHonors());
        System.out.println(student.tuitionDiscountPercent());
        System.out.println(student.describeAcademicStanding());
    }
}
