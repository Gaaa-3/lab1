package badsmells;

/*
 * Smell: Mysterious Name
 *
 * Original: method f with parameters a, b, c and locals x, y reveal nothing.
 * Fix: Renamed everything to reflect the actual calculation — net area halved.
 *
 * Refactorings applied: Rename (method, parameters, local variables)
 */
public class MysteriousNameExample {

    public int calculateHalfNetArea(int width, int height, int deduction) {
        int grossArea = width * height;
        int netArea = grossArea - deduction;
        return netArea / 2;
    }

    public void clientCode() {
        int result = calculateHalfNetArea(8, 4, 6);
        System.out.println(result);
    }
}
