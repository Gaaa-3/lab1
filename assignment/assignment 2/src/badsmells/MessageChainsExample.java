package badsmells;

/*
 * Smell: Message Chains
 *
 * Original: client called university.getDepartment().getCoordinator().getOffice().getPhoneNumber()
 * coupling it to the full internal structure.
 * Fix: Added a getCoordinatorPhoneNumber() method on University that hides the chain.
 * Callers now ask for what they need without navigating the graph.
 *
 * Refactorings applied: Hide Delegate (Extract Method, Move)
 */
public class MessageChainsExample {

    static class University {
        private final Department department = new Department();

        public String getCoordinatorPhoneNumber() {
            return department.getCoordinator().getOffice().getPhoneNumber();
        }
    }

    static class Department {
        Coordinator getCoordinator() {
            return new Coordinator();
        }
    }

    static class Coordinator {
        Office getOffice() {
            return new Office();
        }
    }

    static class Office {
        String getPhoneNumber() {
            return "555-0101";
        }
    }

    public void clientCode() {
        University university = new University();
        System.out.println(university.getCoordinatorPhoneNumber());
    }
}
