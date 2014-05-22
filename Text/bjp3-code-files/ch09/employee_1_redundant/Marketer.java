// A redundant class to represent marketers.
public class Marketer {
    public void applyForVacation() {
        System.out.println("Use the yellow vacation form.");
    }
    
    // This is the only added behavior.
    public void advertise() {
        System.out.println("Act now, while supplies last!");
    }

    public void showHours() {
        System.out.println("I work 40 hours per week.");
    }

    // Different from standard salary.
    public void showSalary() {
        System.out.println("My salary is $50,000.");
    }

    public void showVacation() {
        System.out.println("I receive 2 weeks vacation.");
    }
}
