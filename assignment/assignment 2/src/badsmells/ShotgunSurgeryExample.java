package badsmells;

/*
 * Smell: Shotgun Surgery
 *
 * Original: Course title formatting was duplicated across Course, Invoice, and Certificate.
 * One naming change would require edits in all three classes.
 * Fix: Introduced a CourseTitle value object as the single source of truth for formatting.
 *
 * Refactorings applied: Extract Class, Move
 */
public class ShotgunSurgeryExample {

    static class CourseTitle {
        private final String title;

        CourseTitle(String title) {
            this.title = title;
        }

        public String asLabel()       { return "Course: " + title; }
        public String asInvoiceDescription() { return "Invoice for " + title; }
        public String asCertificateText()    { return "Completed " + title; }
    }

    static class Course {
        private final CourseTitle courseTitle;

        Course(String title) {
            this.courseTitle = new CourseTitle(title);
        }

        public String label() {
            return courseTitle.asLabel();
        }
    }

    static class Invoice {
        private final CourseTitle courseTitle;

        Invoice(String title) {
            this.courseTitle = new CourseTitle(title);
        }

        public String description() {
            return courseTitle.asInvoiceDescription();
        }
    }

    static class Certificate {
        private final CourseTitle courseTitle;

        Certificate(String title) {
            this.courseTitle = new CourseTitle(title);
        }

        public String text() {
            return courseTitle.asCertificateText();
        }
    }

    public void clientCode() {
        Course course = new Course("Refactoring");
        Invoice invoice = new Invoice("Refactoring");
        Certificate certificate = new Certificate("Refactoring");

        System.out.println(course.label());
        System.out.println(invoice.description());
        System.out.println(certificate.text());
    }
}
