package badsmells;

/*
 * Smell: Repeated Switches
 *
 * Original: The same student type switch appeared in both tuitionDiscount() and dormPriority().
 * Adding a new type required editing both methods.
 * Fix: Centralized all type-specific values in a StudentType enum. New types are added in one place.
 *
 * Refactorings applied: Replace Conditional with Polymorphism (via enum), Extract Method
 */
public class RepeatedSwitchesExample {

    enum StudentType {
        STUDENT(0.05, "NORMAL"),
        ATHLETE(0.15, "HIGH"),
        EMPLOYEE_CHILD(0.25, "LOW");

        private final double tuitionDiscount;
        private final String dormPriority;

        StudentType(double tuitionDiscount, String dormPriority) {
            this.tuitionDiscount = tuitionDiscount;
            this.dormPriority = dormPriority;
        }

        public double tuitionDiscount() { return tuitionDiscount; }
        public String dormPriority()    { return dormPriority; }

        public static StudentType fromString(String value) {
            for (StudentType type : values()) {
                if (type.name().equals(value)) return type;
            }
            return null;
        }
    }

    public double tuitionDiscount(String studentType) {
        StudentType type = StudentType.fromString(studentType);
        return type != null ? type.tuitionDiscount() : 0;
    }

    public String dormPriority(String studentType) {
        StudentType type = StudentType.fromString(studentType);
        return type != null ? type.dormPriority() : "UNKNOWN";
    }

    public void clientCode() {
        System.out.println(tuitionDiscount("ATHLETE"));
        System.out.println(dormPriority("ATHLETE"));
    }
}
