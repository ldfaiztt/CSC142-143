public class EmployeeMain2 {
    public static void main(String[] args) {
        System.out.println("Lawyer:");
        Lawyer employee1 = new Lawyer();
        employee1.applyForVacation();
        employee1.showHours();
        employee1.showSalary();
        employee1.showVacation();
        employee1.sue();
        System.out.println();

        System.out.println("Marketer:");
        Marketer employee2 = new Marketer();
        employee2.applyForVacation();
        employee2.showHours();
        employee2.showSalary();
        employee2.showVacation();
        employee2.advertise();
    }
}
