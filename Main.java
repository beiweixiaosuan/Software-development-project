import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Database database = new Database();

    static void addEmployee() {}

    static void updateEmployee(int employeeId) {
        database.updateEmployee(employeeId);
    }

    static void deleteEmployee(int employeeId) {}

    static void updateSalary(int employeeId) {}

    static void displayEmployees() {}

    public static void main(String[] args) {
        System.out.println("Employee Management System");
        while (true) {
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Update Salary");
            System.out.println("5. Display Employees");
            System.out.println("0. Exit");

            int choice = sc.nextInt();
            int employeeId;

            switch (choice) {
                case 0:
                    System.exit(0);
                case 1:
                    addEmployee();
                    break;
                case 2:
                    employeeId = Integer.parseInt(sc.nextLine());
                    updateEmployee(employeeId);
                    break;
                case 3:
                    employeeId = Integer.parseInt(sc.nextLine());
                    deleteEmployee(employeeId);
                    break;
                case 4:
                    employeeId = Integer.parseInt(sc.nextLine());
                    updateSalary(employeeId);
                    break;
                case 5:
                    displayEmployees();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
