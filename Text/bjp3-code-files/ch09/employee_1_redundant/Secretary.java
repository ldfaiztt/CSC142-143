// A redundant class to represent secretaries.
public class Secretary {
    public void applyForVacation() {
        System.out.println("Use the yellow vacation form.");
    }
    
    public void showHours() {
        System.out.println("I work 40 hours per week.");
    }
    
    public void showSalary() {
        System.out.println("My salary is $40,000.");
    }
    
    public void showVacation() {
        System.out.println("I receive 2 weeks vacation.");
    }
    
    // This is the only added behavior.
    public void takeDictation() {
        System.out.println("I know how to take dictation.");
    }
}
