package badsmells;

import java.util.ArrayList;
import java.util.List;

/*
 * Smell: Large Class
 *
 * Original: One class mixed enrollment, staffing, finance, help desk, transport,
 * cafeteria, payroll, and website — eight unrelated responsibilities.
 * Fix: Extracted five focused classes, each owning one domain area.
 *
 * Refactorings applied: Extract Class, Move Field, Move Method
 */
public class LargeClassExample {

    static class AcademicRegistry {
        private final List<String> students = new ArrayList<>();
        private final List<String> teachers = new ArrayList<>();
        private final List<String> courses  = new ArrayList<>();

        public void enrollStudent(String student) { students.add(student); }
        public void hireTeacher(String teacher)   { teachers.add(teacher); }
        public void addCourse(String course)       { courses.add(course); }
    }

    static class FinanceOffice {
        private double budget;

        public void chargeTuition(double amount) { budget += amount; }
        public void paySalary(double amount)     { budget -= amount; }
    }

    static class HelpDesk {
        private int openTickets;

        public void openTicket() { openTickets++; }
    }

    static class FacilitiesService {
        private String cafeteriaMenu;
        private String busSchedule;

        public void publishBusSchedule(String schedule) { busSchedule = schedule; }
        public void publishCafeteriaMenu(String menu)   { cafeteriaMenu = menu; }
    }

    static class HrPayroll {
        private String payrollDay;
        private String websiteTheme;

        public void setPayrollDay(String day)         { payrollDay = day; }
        public void updateWebsiteTheme(String theme)  { websiteTheme = theme; }
    }

    public void clientCode() {
        AcademicRegistry registry    = new AcademicRegistry();
        FinanceOffice finance        = new FinanceOffice();
        HelpDesk helpDesk            = new HelpDesk();
        FacilitiesService facilities = new FacilitiesService();
        HrPayroll hr                 = new HrPayroll();

        registry.enrollStudent("Nino");
        registry.hireTeacher("Ms. Kapanadze");
        registry.addCourse("Refactoring");
        finance.chargeTuition(2400);
        finance.paySalary(1200);
        helpDesk.openTicket();
        hr.updateWebsiteTheme("blue");
        facilities.publishBusSchedule("Route A at 08:00");
        facilities.publishCafeteriaMenu("Soup and salad");
        hr.setPayrollDay("Friday");
    }
}
