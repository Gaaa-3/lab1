package badsmells;

/*
 * Smell: Refused Bequest
 *
 * Original: Penguin extended Bird and threw UnsupportedOperationException from fly(),
 * breaking the contract that Bird implies.
 * Fix: Introduced a FlyingBird subclass that carries fly(). Bird is now a general
 * animal base. Penguin extends Bird without inheriting flying behavior it can't honor.
 *
 * Refactorings applied: Extract Superclass, Push Down Method
 */
public class RefusedBequestExample {

    static class Bird {
        // common bird behavior can go here
    }

    static class FlyingBird extends Bird {
        public void fly() {
            System.out.println("Flying");
        }
    }

    static class Sparrow extends FlyingBird {
        @Override
        public void fly() {
            System.out.println("Sparrow is flying");
        }
    }

    static class Eagle extends FlyingBird {
        @Override
        public void fly() {
            System.out.println("Eagle is soaring");
        }
    }

    static class Penguin extends Bird {
        // no fly() — Penguin simply does not have that capability
    }

    public void clientCode() {
        FlyingBird sparrow = new Sparrow();
        FlyingBird eagle   = new Eagle();
        Bird penguin       = new Penguin();

        sparrow.fly();
        eagle.fly();
        // penguin.fly() is not possible — which is correct
        System.out.println("Penguin cannot fly");
    }
}
