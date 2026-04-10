package badsmells;

/*
 * Smell: Global Data
 *
 * Original: public static fields were accessible and mutable from anywhere.
 * Fix: Encapsulated state in a AcademicConfiguration object with controlled access methods.
 * BillingService and SemesterAdministration now depend on the config object, not globals.
 *
 * Refactorings applied: Encapsulate Field, Extract Class, Move
 */
public class GlobalDataExample {

    static class AcademicConfiguration {
        private String currentSemester;
        private double tuitionRate;

        AcademicConfiguration(String currentSemester, double tuitionRate) {
            this.currentSemester = currentSemester;
            this.tuitionRate = tuitionRate;
        }

        public String getCurrentSemester() { return currentSemester; }
        public double getTuitionRate()      { return tuitionRate; }

        public void setSemester(String semester)      { this.currentSemester = semester; }
        public void applyRateIncrease(double delta)   { this.tuitionRate += delta; }
    }

    static class BillingService {
        private final AcademicConfiguration config;

        BillingService(AcademicConfiguration config) {
            this.config = config;
        }

        public double calculateInvoice(int credits) {
            return credits * config.getTuitionRate();
        }
    }

    static class SemesterAdministration {
        private final AcademicConfiguration config;

        SemesterAdministration(AcademicConfiguration config) {
            this.config = config;
        }

        public void openFallSemester() {
            config.setSemester("FALL");
        }

        public void approveRateIncrease() {
            config.applyRateIncrease(100);
        }
    }

    public void clientCode() {
        AcademicConfiguration config = new AcademicConfiguration("SPRING", 1250.0);
        BillingService billingService = new BillingService(config);
        SemesterAdministration administration = new SemesterAdministration(config);

        System.out.println(config.getCurrentSemester());
        System.out.println(billingService.calculateInvoice(3));
        administration.openFallSemester();
        administration.approveRateIncrease();
        System.out.println(config.getCurrentSemester());
        System.out.println(billingService.calculateInvoice(3));
    }
}
