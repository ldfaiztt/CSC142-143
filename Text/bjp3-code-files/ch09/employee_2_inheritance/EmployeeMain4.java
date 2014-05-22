public class EmployeeMain4 {
    public static void main(String[] args) {
        Employee[] employees = {new Employee(), new Lawyer(),
                new Marketer(), new Secretary()};
        
        // print information about each employee
        for (int i = 0; i < employees.length; i++) {
            employees[i].applyForVacation();
            employees[i].showHours();
            employees[i].showSalary();
            employees[i].showVacation();
            System.out.println();
        }
    }
}
