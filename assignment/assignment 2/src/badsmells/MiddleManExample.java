package badsmells;

/*
 * Smell: Middle Man
 *
 * Original: StudentPortal only forwarded findGrade() to TranscriptService — pure delegation,
 * zero added value.
 * Fix: Removed StudentPortal. Client now talks to TranscriptService directly.
 *
 * Refactorings applied: Remove Middle Man (Inline Class)
 */
public class MiddleManExample {

    static class TranscriptService {
        public String findGrade(String studentId) {
            return "A";
        }
    }

    public void clientCode() {
        TranscriptService transcriptService = new TranscriptService();
        System.out.println(transcriptService.findGrade("s-1001"));
    }
}
