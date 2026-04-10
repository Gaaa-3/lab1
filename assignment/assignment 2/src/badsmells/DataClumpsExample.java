package badsmells;

/*
 * Smell: Data Clumps
 *
 * Original: name, email, phone traveled together as three loose parameters in every method.
 * Fix: Introduced ContactInfo to encapsulate the clump. Methods now belong to that object.
 *
 * Refactorings applied: Introduce Parameter Object (Extract Class), Move Method
 */
public class DataClumpsExample {

    static class ContactInfo {
        private final String name;
        private final String email;
        private final String phone;

        ContactInfo(String name, String email, String phone) {
            this.name = name;
            this.email = email;
            this.phone = phone;
        }

        public String buildLabel() {
            return name + " <" + email + ">, phone: " + phone;
        }

        public String buildEmailGreeting() {
            return "To: " + email + ", hello " + name;
        }

        public String buildSmsMessage() {
            return "SMS to " + phone + ": Hi " + name;
        }

        public boolean isReachable() {
            return email != null && !email.trim().isEmpty()
                && phone != null && !phone.trim().isEmpty();
        }
    }

    public void clientCode() {
        ContactInfo student    = new ContactInfo("Nino",   "nino@example.com",   "+995-555-000-001");
        ContactInfo advisor    = new ContactInfo("Giorgi", "giorgi@example.com",  "+995-555-000-002");
        ContactInfo accountant = new ContactInfo("Maka",   "maka@example.com",   "+995-555-000-003");

        for (ContactInfo contact : new ContactInfo[]{student, advisor, accountant}) {
            System.out.println(contact.buildLabel());
            System.out.println(contact.buildEmailGreeting());
            System.out.println(contact.buildSmsMessage());
            System.out.println(contact.isReachable());
        }
    }
}
