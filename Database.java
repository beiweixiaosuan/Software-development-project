import java.sql.*;
import java.util.Scanner;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/emp_db";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter Employee ID: ");
            int empId = Integer.parseInt(sc.nextLine());

            // Check if employee exists
            String selectQuery = "SELECT * FROM employees WHERE empID = ?";
            PreparedStatement selectStmt = con.prepareStatement(selectQuery);
            selectStmt.setInt(1, empId);

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

            System.out.println("ID: " + currentId);
            System.out.println("Name: " + currentName);
            System.out.println("DOB: " + currentDob);
            System.out.println("SSN: " + currentSsn);
            System.out.println("Phone: " + currentPhone);
            System.out.println("Salary: " + currentSalary);

            System.out.print("Enter new name: ");
            String nameInput = sc.nextLine();
            String name = nameInput.isEmpty() ? currentName : nameInput;

            System.out.print("Enter new DOB (YYYY-MM-DD): ");
            String dobInput = sc.nextLine();
            Date dob = dobInput.isEmpty() ? currentDob : Date.valueOf(dobInput);

            System.out.print("Enter new SSN: ");
            String ssnInput = sc.nextLine();
            int ssn = ssnInput.isEmpty() ? currentSsn : Integer.parseInt(ssnInput);

            System.out.print("Enter new phone #: ");
            String phoneInput = sc.nextLine();
            String phone = phoneInput.isEmpty() ? currentPhone : phoneInput;

            System.out.print("Enter new emergency contact: ");
            String emgNameInput = sc.nextLine();
            String emgName = emgNameInput.isEmpty() ? currentEmgName : emgNameInput;

            System.out.print("Enter new emergency phone #: ");
            String emgPhoneInput = sc.nextLine();
            int emgPhone = emgPhoneInput.isEmpty() ? currentEmgPhone : Integer.parseInt(emgPhoneInput);

            System.out.print("Enter new salary: ");
            String salaryInput = sc.nextLine();
            int salary = salaryInput.isEmpty() ? currentSalary : Integer.parseInt(salaryInput);

            String updateQuery = "UPDATE employees SET name = ?, dob = ?, ssn = ?, phone = ?, emg_name = ?, emg_phone = ?, salary = ? WHERE empID = ?";
            PreparedStatement updateStmt = con.prepareStatement(updateQuery);
            updateStmt.setString(1, name);
            updateStmt.setDate(2, dob);
            updateStmt.setInt(3, ssn);
            updateStmt.setString(4, phone);
            updateStmt.setString(5, emgName);
            updateStmt.setInt(6, emgPhone);
            updateStmt.setInt(7, salary);
            updateStmt.setInt(8, empId);

            int rowsUpdated = updateStmt.executeUpdate();
            System.out.println(rowsUpdated + " record(s) updated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
