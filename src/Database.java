import java.sql.*;
import java.util.Scanner;

class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/emp_db";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    void updateEmployee(int employeeId) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Check if employee exists
            String selectQuery = "SELECT * FROM employees WHERE empID = ?";
            PreparedStatement selectStmt = con.prepareStatement(selectQuery);
            selectStmt.setInt(1, employeeId);

            ResultSet rs = selectStmt.executeQuery();

            if (!rs.next()) {
                System.out.println("Employee not found!");
                return;
            }

            int currentId = rs.getInt("empID");
            String currentName = rs.getString("name");
            Date currentDob = rs.getDate("dob");
            int currentSsn = rs.getInt("ssn");
            String currentPhone = rs.getString("phone");
            String currentEmgName = rs.getString("emg_name");
            int currentEmgPhone = rs.getInt("emg_phone");
            int currentSalary = rs.getInt("salary");

            Employee employee = new Employee(currentId, currentName, currentDob, currentSsn, currentPhone, currentEmgName, currentEmgPhone, currentSalary);
            employee.display();

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter new name: ");
            String nameInput = sc.nextLine();
            String name = nameInput.isEmpty() ? employee.getName() : nameInput;
            employee.setName(name);

            System.out.print("Enter new DOB (YYYY-MM-DD): ");
            String dobInput = sc.nextLine();
            Date dob = dobInput.isEmpty() ? employee.getDob() : Date.valueOf(dobInput);
            employee.setDob(dob);

            System.out.print("Enter new SSN: ");
            String ssnInput = sc.nextLine();
            int ssn = ssnInput.isEmpty() ? employee.getSsn() : Integer.parseInt(ssnInput);
            employee.setSsn(ssn);

            System.out.print("Enter new phone #: ");
            String phoneInput = sc.nextLine();
            String phone = phoneInput.isEmpty() ? employee.getPhone() : phoneInput;
            employee.setPhone(phone);

            System.out.print("Enter new emergency contact: ");
            String emgNameInput = sc.nextLine();
            String emgName = emgNameInput.isEmpty() ? employee.getEmgName() : emgNameInput;
            employee.setEmgName(emgName);

            System.out.print("Enter new emergency phone #: ");
            String emgPhoneInput = sc.nextLine();
            int emgPhone = emgPhoneInput.isEmpty() ? employee.getEmgPhone() : Integer.parseInt(emgPhoneInput);
            employee.setEmgPhone(emgPhone);

            System.out.print("Enter new salary: ");
            String salaryInput = sc.nextLine();
            int salary = salaryInput.isEmpty() ? employee.getSalary() : Integer.parseInt(salaryInput);
            employee.setSalary(salary);

            String updateQuery = "UPDATE employees SET name = ?, dob = ?, ssn = ?, phone = ?, emg_name = ?, emg_phone = ?, salary = ? WHERE empID = ?";
            PreparedStatement updateStmt = con.prepareStatement(updateQuery);
            updateStmt.setString(1, name);
            updateStmt.setDate(2, dob);
            updateStmt.setInt(3, ssn);
            updateStmt.setString(4, phone);
            updateStmt.setString(5, emgName);
            updateStmt.setInt(6, emgPhone);
            updateStmt.setInt(7, salary);
            updateStmt.setInt(8, employeeId);

            int rowsUpdated = updateStmt.executeUpdate();
            System.out.println(rowsUpdated + " record(s) updated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
