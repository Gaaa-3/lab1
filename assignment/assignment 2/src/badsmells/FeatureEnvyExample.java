package badsmells;

/*
 * Smell: Feature Envy
 *
 * Original: ScholarshipCalculator.qualifies() only used StudentAccount data,
 * so the logic clearly belonged in StudentAccount itself.
 * Fix: Moved qualifiesForScholarship() into StudentAccount.
 * ScholarshipCalculator is removed as it no longer adds value.
 *
 * Refactorings applied: Move Method
 */
public class FeatureEnvyExample {

    static class StudentAccount {
        private final int completedCredits;
        private final double gpa;

        StudentAccount(int completedCredits, double gpa) {
            this.completedCredits = completedCredits;
            this.gpa = gpa;
        }

        public boolean qualifiesForScholarship() {
            return completedCredits >= 30 && gpa >= 3.7;
        }
    }

    public void clientCode() {
        StudentAccount account = new StudentAccount(36, 3.9);
        System.out.println(account.qualifiesForScholarship());
    }
}
