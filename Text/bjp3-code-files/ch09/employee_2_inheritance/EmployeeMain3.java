public class EmployeeMain3 {
    public static void main(String[] args) {
        Employee empl = new Employee();
        Lawyer law = new Lawyer();
        Marketer mark = new Marketer();
        Secretary sec = new Secretary();

        printInfo(empl);
        printInfo(law);
        printInfo(mark);
        printInfo(sec);
    }

    public static void printInfo(Employee employee) {
        employee.applyForVacation();
        employee.showHours();
        employee.showSalary();
        employee.showVacation();
        System.out.println();
    }
}
