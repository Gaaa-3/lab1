package badsmells;

/*
 * Smell: Lazy Element
 *
 * Original: StudentNameFormatter was a class that did nothing but call String.trim().
 * Fix: Inlined the call directly. The class added no real value or variation.
 *
 * Refactorings applied: Inline Class
 */
public class LazyElementExample {

    public void clientCode() {
        System.out.println("  Nino  ".trim());
    }
}
