package epam.stream;

import java.util.List;

public class EmployeeDB {
    public static List<Employee> getEmployees() {
        return List.of(
                new Employee(101, "Alice", "HR", 50000, 30, "Mumbai", true),
                new Employee(102, "Bob", "Finance", 60000, 40, "Delhi", true),
                new Employee(103, "Charlie", "IT", 80000, 28, "Mumbai", false),
                new Employee(104, "David", "IT", 75000, 35, "Bangalore", true),
                new Employee(105, "Eva", "HR", 48000, 25, "Delhi", true),
                new Employee(106, "Frank", "Finance", 62000, 50, "Chennai", false),
                new Employee(107, "Grace", "IT", 90000, 32, "Mumbai", true),
                new Employee(108, "Hannah", "HR", 52000, 29, "Bangalore", true),
                new Employee(109, "Ian", "Finance", 55000, 38, "Mumbai", true),
                new Employee(110, "Jane", "IT", 87000, 45, "Chennai", false)
        );
    }
}
