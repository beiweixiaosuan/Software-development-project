public class Employee {
    private int id;
    private String name;
    private String dob;
    private int ssn;
    private double phone;
    private int salary;

    Employee(int id, String name, String dob, int ssn, double phone, int salary) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.ssn = ssn;
        this.phone = phone;
        this.salary = salary;
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    String getDob() {
        return dob;
    }

    int getSsn() {
        return ssn;
    }

    double getPhone() {
        return phone;
    }

    int getSalary() {
        return salary;
    }

    void setId(int id) {
        this.id = id;
    }

    void setName(String name) {
        this.name = name;
    }

    void setDob(String dob) {
        this.dob = dob;
    }

    void setSsn(int ssn) {
        this.ssn = ssn;
    }

    void setPhone(double phone) {
        this.phone = phone;
    }

    void setSalary(int salary) {
        this.salary = salary;
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("SSN: " + ssn);
        System.out.println("DOB: " + dob);
        System.out.println("Phone #: " + phone);
        System.out.println("Salary: " + salary);
    }
}
