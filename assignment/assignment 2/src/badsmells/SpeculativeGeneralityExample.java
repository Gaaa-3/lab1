package badsmells;

/*
 * Smell: Speculative Generality
 *
 * Original: NotificationChannel.send() had futureTemplate, encrypted, and urgent
 * parameters that EmailChannel completely ignored.
 * Fix: Removed the unused parameters. The interface now matches actual usage.
 *
 * Refactorings applied: Remove Parameter (Change Method Signature), Inline
 */
public class SpeculativeGeneralityExample {

    interface NotificationChannel {
        void send(String message);
    }

    static class EmailChannel implements NotificationChannel {
        @Override
        public void send(String message) {
            System.out.println(message);
        }
    }

    public void clientCode() {
        NotificationChannel channel = new EmailChannel();
        channel.send("Exam starts at 10:00");
    }
}
