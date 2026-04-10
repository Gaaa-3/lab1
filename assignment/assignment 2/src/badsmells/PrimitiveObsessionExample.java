package badsmells;

/*
 * Smell: Primitive Obsession
 *
 * Original: age, status, unpaidBalance, countryCode were raw primitives with rules scattered inline.
 * Fix: Introduced enums StudentStatus and CountryCode, and a DormApplication value object
 * that owns the eligibility rule.
 *
 * Refactorings applied: Replace Primitive with Object, Extract Class
 */
public class PrimitiveObsessionExample {

    enum StudentStatus { ACTIVE, BLOCKED }

    enum CountryCode { GE, US }

    static class DormApplication {
        private final int age;
        private final StudentStatus status;
        private final double unpaidBalance;
        private final CountryCode countryCode;

        DormApplication(int age, StudentStatus status, double unpaidBalance, CountryCode countryCode) {
            this.age = age;
            this.status = status;
            this.unpaidBalance = unpaidBalance;
            this.countryCode = countryCode;
        }

        public boolean canRentDormRoom() {
            return age >= 18
                && status == StudentStatus.ACTIVE
                && unpaidBalance < 100
                && countryCode == CountryCode.GE;
        }
    }

    public void clientCode() {
        DormApplication eligible = new DormApplication(19, StudentStatus.ACTIVE, 0.0, CountryCode.GE);
        DormApplication ineligible = new DormApplication(17, StudentStatus.BLOCKED, 120.0, CountryCode.US);

        System.out.println(eligible.canRentDormRoom());
        System.out.println(ineligible.canRentDormRoom());
    }
}
