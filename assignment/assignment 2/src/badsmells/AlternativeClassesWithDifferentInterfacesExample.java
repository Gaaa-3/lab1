package badsmells;

/*
 * Smell: Alternative Classes with Different Interfaces
 *
 * Original: ZoomClassroom.beginSession() and TeamsClassroom.openMeeting() did the same
 * thing under different names. Client code couldn't treat them uniformly.
 * Fix: Introduced a Classroom interface with a single start() method.
 * Both classes now implement it, and client code works with Classroom uniformly.
 *
 * Refactorings applied: Extract Interface, Rename Method
 */
public class AlternativeClassesWithDifferentInterfacesExample {

    interface Classroom {
        void start();
    }

    static class ZoomClassroom implements Classroom {
        @Override
        public void start() {
            System.out.println("Zoom session started");
        }
    }

    static class TeamsClassroom implements Classroom {
        @Override
        public void start() {
            System.out.println("Teams meeting started");
        }
    }

    public void clientCode() {
        Classroom zoom  = new ZoomClassroom();
        Classroom teams = new TeamsClassroom();

        zoom.start();
        teams.start();
    }
}
