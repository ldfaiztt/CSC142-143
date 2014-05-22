public class EmployeeMain {
    public static void main(String[] args) {
        System.out.println("Employee:");
        Employee employee1 = new Employee();
        employee1.applyForVacation();
        employee1.showHours();
        employee1.showSalary();
        employee1.showVacation();
        System.out.println();
        
        System.out.println("Secretary:");
        Secretary employee2 = new Secretary();
        employee2.applyForVacation();
        employee2.showHours();
        employee2.showSalary();
        employee2.showVacation();
        employee2.takeDictation();
    }
}
