package badsmells;

/*
 * Smell: Insider Trading
 *
 * Original: AuditService directly read and wrote BankAccount's raw fields,
 * creating tight coupling to internal state.
 * Fix: Hid fields behind private access. Added freezeIfNegative() on BankAccount
 * and an isFrozen() query. AuditService now asks the account to handle its own state.
 *
 * Refactorings applied: Encapsulate Field, Move Method
 */
public class InsiderTradingExample {

    static class BankAccount {
        private double balance;
        private String status = "ACTIVE";

        BankAccount(double balance) {
            this.balance = balance;
        }

        public void freezeIfNegative() {
            if (balance < 0) {
                status = "FROZEN";
            }
        }

        public String getStatus() {
            return status;
        }
    }

    static class AuditService {
        public void freezeIfNeeded(BankAccount account) {
            account.freezeIfNegative();
        }
    }

    public void clientCode() {
        BankAccount account = new BankAccount(-50);
        AuditService auditService = new AuditService();
        auditService.freezeIfNeeded(account);
        System.out.println(account.getStatus());
    }
}
