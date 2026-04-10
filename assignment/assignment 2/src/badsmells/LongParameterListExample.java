package badsmells;

/*
 * Smell: Long Parameter List
 *
 * Original: registerStudent took 12 loose primitives.
 * Fix: Introduced parameter objects Address, GuardianContact, and Enrollment
 * to group related values into meaningful concepts.
 *
 * Refactorings applied: Introduce Parameter Object
 */
public class LongParameterListExample {

    static class Address {
        final String city;
        final String street;
        final String zipCode;

        Address(String city, String street, String zipCode) {
            this.city = city;
            this.street = street;
            this.zipCode = zipCode;
        }

        @Override
        public String toString() {
            return city + ", " + street + ", " + zipCode;
        }
    }

    static class GuardianContact {
        final String name;
        final String phone;

        GuardianContact(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }
    }

    static class Enrollment {
        final String program;
        final int startYear;
        final boolean scholarship;

        Enrollment(String program, int startYear, boolean scholarship) {
            this.program = program;
            this.startYear = startYear;
            this.scholarship = scholarship;
        }
    }

    public String registerStudent(String firstName, String lastName, String email, String phone,
                                   Address address, GuardianContact guardian, Enrollment enrollment) {
        return firstName + " " + lastName + " -> " + enrollment.program + " (" + enrollment.startYear + ")"
             + ", guardian=" + guardian.name
             + ", scholarship=" + enrollment.scholarship
             + ", address=" + address
             + ", contact=" + email + "/" + phone
             + ", guardianPhone=" + guardian.phone;
    }

    public void clientCode() {
        Address address = new Address("Tbilisi", "Rustaveli Ave 10", "0108");
        GuardianContact guardian = new GuardianContact("Maka Beridze", "+995-555-000-999");
        Enrollment enrollment = new Enrollment("Computer Science", 2026, true);

        String summary = registerStudent("Nino", "Beridze", "nino@example.com", "+995-555-000-001",
                address, guardian, enrollment);
        System.out.println(summary);
    }
}
