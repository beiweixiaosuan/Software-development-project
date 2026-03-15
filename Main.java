import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Database database = new Database();

    static void addEmployee() {}

    static void updateEmployee() {
        database.updateEmployee(1);
    }

    static void deleteEmployee() {}

    static void updateSalary() {}

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

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    updateEmployee();
                    break;
                case 3:
                    deleteEmployee();
                    break;
                case 4:
                    updateSalary();
                    break;
                case 5:
                    displayEmployees();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
