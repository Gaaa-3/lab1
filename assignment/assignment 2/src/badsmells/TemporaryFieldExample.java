package badsmells;

/*
 * Smell: Temporary Field
 *
 * Original: examRoom and onlineMeetingLink were instance fields but only one
 * was ever meaningful depending on which method was called.
 * Fix: Extracted OnsiteExam and OnlineExam classes so each owns only its
 * relevant field. No field is ever irrelevant in its class.
 *
 * Refactorings applied: Extract Class, Move Field
 */
public class TemporaryFieldExample {

    static class OnsiteExam {
        private final String examRoom = "B-204";

        public String prepare() {
            return "Use room " + examRoom;
        }
    }

    static class OnlineExam {
        private final String meetingLink = "https://meet.example/exam";

        public String prepare() {
            return "Join " + meetingLink;
        }
    }

    public void clientCode() {
        OnsiteExam onsite = new OnsiteExam();
        OnlineExam online = new OnlineExam();

        System.out.println(onsite.prepare());
        System.out.println(online.prepare());
    }
}
