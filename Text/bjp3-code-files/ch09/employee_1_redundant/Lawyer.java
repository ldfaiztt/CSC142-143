// A redundant class to represent lawyers.
public class Lawyer {
    // Different from standard vacation form.
    public void applyForVacation() {
        System.out.println("Use the pink vacation form.");
    }
    
    public void showHours() {
        System.out.println("I work 40 hours per week.");
    }
    
    public void showSalary() {
        System.out.println("My salary is $40,000.");
    }
    
    public void showVacation() {
        System.out.println("I receive 3 weeks vacation.");
    }
    
    // This is the only added behavior.
    public void sue() {
        System.out.println("I'll see you in court!");
    }
}
