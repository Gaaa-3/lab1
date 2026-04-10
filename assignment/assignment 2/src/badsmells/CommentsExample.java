package badsmells;

/*
 * Smell: Comments
 *
 * Original: Three inline comments explained what each calculation step did,
 * compensating for unclear code structure.
 * Fix: Extracted three intention-revealing private methods. The comments
 * are no longer needed because the code now explains itself.
 *
 * Refactorings applied: Extract Method, Rename
 */
public class CommentsExample {

    public double finalPrice(double basePrice, boolean vip, int quantity) {
        double price = applyVipDiscount(basePrice, vip);
        price = applyBulkDiscount(price, quantity);
        price = applyTax(price);
        return price;
    }

    private double applyVipDiscount(double price, boolean vip) {
        return vip ? price - price * 0.10 : price;
    }

    private double applyBulkDiscount(double price, int quantity) {
        return quantity > 20 ? price - price * 0.05 : price;
    }

    private double applyTax(double price) {
        return price + price * 0.18;
    }

    public void clientCode() {
        double vipOrder     = finalPrice(120, true, 25);
        double regularOrder = finalPrice(120, false, 5);
        System.out.println(vipOrder);
        System.out.println(regularOrder);
    }
}
