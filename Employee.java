public class Employee {
    private int id;
    private String name;
    private String dob;
    private int ssn;
    private String phone;
    private String emgName;
    private String emgPhone;
    private int salary;

    Employee(int id, String name, String dob, int ssn, String phone, String emgName, int emgPhone, int salary) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.ssn = ssn;
        this.phone = phone;
        this.emgName = emgName;
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

    String getPhone() {
        return phone;
    }

    String getEmgName() {
        return emgName;
    }

    String getEmgPhone() {
        return emgPhone;
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

    void setPhone(String phone) {
        this.phone = phone;
    }

    void setEmgName(String emgName) {
        this.emgName = emgName;
    }

    void setEmgPhone(String emgPhone) {
        this.emgPhone = emgPhone;
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
