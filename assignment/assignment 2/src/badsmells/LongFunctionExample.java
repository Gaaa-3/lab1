package badsmells;

/*
 * Smell: Long Function
 *
 * Original: processOrder mixed discount, shipping, tax, approval, and formatting all in one block.
 * Fix: Extracted each concern into its own focused private method.
 *
 * Refactorings applied: Extract Method
 */
public class LongFunctionExample {

    public String processOrder(String customerType, int quantity, double price, boolean expressDelivery) {
        double subtotal = quantity * price;
        double discount = calculateDiscount(customerType, subtotal);
        double shipping = calculateShipping(expressDelivery, quantity);
        double tax = calculateTax(subtotal, discount);
        double total = subtotal - discount + shipping + tax;
        String status = determineApprovalStatus(total);
        return buildSummary(customerType, quantity, price, subtotal, discount, shipping, tax, total, status);
    }

    private double calculateDiscount(String customerType, double subtotal) {
        switch (customerType) {
            case "STUDENT":  return subtotal * 0.05;
            case "VIP":      return subtotal * 0.12;
            case "EMPLOYEE": return subtotal * 0.20;
            default:         return 0;
        }
    }

    private double calculateShipping(boolean expressDelivery, int quantity) {
        if (expressDelivery) {
            return quantity > 10 ? 35 : 25;
        } else {
            return quantity > 10 ? 15 : 10;
        }
    }

    private double calculateTax(double subtotal, double discount) {
        return (subtotal - discount) * 0.18;
    }

    private String determineApprovalStatus(double total) {
        if (total > 500) return "MANAGER_APPROVAL";
        if (total > 200) return "FINANCE_REVIEW";
        return "AUTO_APPROVED";
    }

    private String buildSummary(String customerType, int quantity, double price,
                                 double subtotal, double discount, double shipping,
                                 double tax, double total, String status) {
        return "customerType=" + customerType + '\n'
             + "quantity=" + quantity + '\n'
             + "price=" + price + '\n'
             + "subtotal=" + subtotal + '\n'
             + "discount=" + discount + '\n'
             + "shipping=" + shipping + '\n'
             + "tax=" + tax + '\n'
             + "total=" + total + '\n'
             + "status=" + status;
    }

    public void clientCode() {
        System.out.println(processOrder("VIP", 12, 30, true));
        System.out.println(processOrder("STUDENT", 2, 50, false));
    }
}
