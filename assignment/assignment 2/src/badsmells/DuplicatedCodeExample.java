package badsmells;

/*
 * Smell: Duplicated Code
 *
 * Original: summerInvoice and winterInvoice repeated identical tax and shipping logic.
 * Fix: Extracted shared tax and shipping into private helper methods. Only the
 * discount rule differs between seasons and stays in each method.
 *
 * Refactorings applied: Extract Method
 */
public class DuplicatedCodeExample {

    public double summerInvoice(double subtotal) {
        double discount = subtotal > 200 ? subtotal * 0.10 : 0;
        return subtotal + calculateTax(subtotal) + calculateShipping(subtotal) - discount;
    }

    public double winterInvoice(double subtotal) {
        double discount = subtotal > 200 ? subtotal * 0.20 : 50;
        return subtotal + calculateTax(subtotal) + calculateShipping(subtotal) - discount;
    }

    private double calculateTax(double subtotal) {
        return subtotal * 0.18;
    }

    private double calculateShipping(double subtotal) {
        return subtotal > 100 ? 0 : 15;
    }

    public void clientCode() {
        System.out.println(summerInvoice(240));
        System.out.println(winterInvoice(240));
    }
}
