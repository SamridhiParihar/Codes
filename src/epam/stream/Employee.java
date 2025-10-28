package epam.stream;

public class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;
    private int age;
    private String city;
    private boolean isActive;
    public Employee(){}

    public Employee(int id, String name, String department, double salary, int age, String city, boolean isActive) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
        this.city = city;
        this.isActive = isActive;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    public int getAge() { return age; }
    public String getCity() { return city; }
    public boolean isActive() { return isActive; }

    @Override
    public String toString() {
        return String.format("%s (ID: %d, Dept: %s, Age: %d, Salary: %.2f, City: %s, Active: %b)",
                name, id, department, age, salary, city, isActive);
    }
}
