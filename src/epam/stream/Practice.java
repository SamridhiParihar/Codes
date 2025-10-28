package epam.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Practice {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        List<Integer> list2 = Arrays.asList(1,2,3,4,5);
        //1. Find the Sum of All Elements in a List
        long sum = list.stream()
                .mapToInt(Integer::intValue)
                .sum();

        //2 .Find the Product of All Elements in a List
        long product = list.stream()
                .reduce(1,(a,b)->a*b);

        //3. Find the Average of All Elements in a List
        double average = list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);

        //4. Find the Maximum Element in a List
        int max = list.stream()
                .max(Comparator.comparing(Integer::intValue))
                .orElse(0);

        //5 . Find the Minimum Element in a List
        int min = list.stream()
                .min(Comparator.comparing(Integer::intValue))
                .orElse(0);

        //6. Count the Number of Elements in a List
        long freq = list.stream()
                .count();

        //7. Check if a List Contains a Specific Element
        int ele = 2;
        boolean check = list.stream()
                .anyMatch(a->a==2);

        //8. Filter Out Even Numbers from a List
        List<Integer> list8 = list.stream()
                .filter(a->a%2==0)
                .toList();

        //9.  Filter Out Odd Numbers from a List
        List<Integer> list9 = list.stream()
                .filter(a->a%2==1)
                .toList();

        //10.  Convert a List of Strings to Uppercase
        List<String> list_10= Arrays.asList("abc","def","gfi");
        List<String> list10 = list_10.stream()
                .map(String::toUpperCase)
                .toList();

        //11. Convert a List of Integers to Their Squares
        List<Integer> list11= list.stream()
                .map(a->a*a)
                .toList();

        //12. Find the First Element in a List
        int ele12 = list.stream()
                .findFirst()
                .orElse(0);

        //13. Find the Last Element in a List
        int ele13 = list.stream()
                .reduce((a,b)->b)
                .orElse(0);

        //14.  Check if All Elements in a List Satisfy a Condition
        boolean check14 = list.stream()
                .allMatch(a->a%2==0);

        //15. Check if Any Element in a List Satisfies a Condition
        boolean check15 = list.stream()
                .anyMatch(a->a%2==0);

        //16. Remove Duplicate Elements from a List
        List<Integer> list16 = list.stream()
                .distinct()
                .toList();

        //17. Sort a List of Integers in Ascending Order
        List<Integer> list17 = list.stream()
                .sorted(Comparator.comparing(Integer::intValue))
                .toList();

        //18. Sort a List of Integers in Descending Order
        List<Integer> list18 = list.stream()
                .sorted(Comparator.comparing(Integer::intValue).reversed())
                .toList();

        //19. Sort a List of Strings in Alphabetical Order
        List<String> list19 = list_10.stream()
                .sorted()
                .toList();

        //20. Sort a List of Strings by Their Length
        List<String> list20 = list_10.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();




        //21. Find the Sum of Digits of a Number
        int number = 56767;
        int sum21 = String.valueOf(number).chars()
                .map(Character::getNumericValue)
                .sum();

        //22.  Find the Factorial of a Number
        int num = 5;
        int fact22 = IntStream.rangeClosed(1,number)
                .reduce(1,(a,b)->a*b);

        //23 .  Find the Second-Largest Element in a List
        int ele23 = list.stream()
                .sorted(Comparator.comparing(Integer::intValue).reversed())
                .skip(1)
                .findFirst()
                .orElse(0);

        //24. Find the Second-Smallest Element in a List
        int ele24 = list.stream()
                .sorted(Comparator.comparing(Integer::intValue))
                .skip(1)
                .findFirst()
                .orElse(0);

        //25. Find the Longest String in a List
        String st25 = list_10.stream()
                .max(Comparator.comparing(String::length))
                .orElse("");

        //26.  Find the Shortest String in a List
        String st26 = list_10.stream()
                .min(Comparator.comparing(String::length))
                .orElse("");

        //27. Group a List of Strings by Their Length
        Map<Integer,List<String>> list27 = list_10.stream()
                .collect(
                        Collectors.groupingBy(String::length)
                );

        //28. Group a List of Objects by a Specific Attribute

        //29. Partition a List of Integers into Even and Odd Numbers
        Map<Boolean,List<Integer>> map29 = list.stream()
                .collect(
                        Collectors.partitioningBy(n->n%2==0)
                );

        //30. Merge Two Lists into a Single List
        List<Integer> list30 = Stream.concat(list.stream(),list2.stream())
                .toList();

        //31 . Find the Intersection of Two Lists
        List<Integer> list31 = list.stream()
                .filter(list2::contains)
                .toList();

        //32.Find the Union of Two Lists
        List<Integer> list32 = Stream.concat(list.stream(),list2.stream())
                .distinct()
                .toList();

        //33. Find the Difference Between Two Lists
        List<Integer> list33 = list.stream()
                .filter(n->!list2.contains(n))
                .toList();

        //34. Count the Occurrences of Each Element in a List
        Map<Integer,Long> list34 = list.stream()
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        )
                );

        //35. Count the Occurrences of Each Character in a String
        String st35 = "aaabbbbbbbccccccdd";
        Map<Character,Long> list35 = st35.chars()
                .mapToObj(ch->(char)ch)
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        )
                );

        //36.  Count the Occurrences of Each Word in a String
        String input = "hello world hello";
        Map<String,Long> map36 = Arrays.stream(input.split(" "))
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        )
                );

        //37. Count the Occurrences of Each Vowel in a String
        Map<Character,Long> list37 = st35.chars()
                .mapToObj(ch->(char)ch)
                .filter(ch->(ch=='a' || ch=='e'|| ch=='i' || ch=='o'|| ch=='u'))
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        )
                );

        //38. Count the Occurrences of Each Digit in a String
        String st38 = "12345333442215";
        Map<Character,Long> map38 = st38.chars()
                .mapToObj(ch->(char)ch)
                .filter(Character::isDigit)
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        )
                );

        //39. Reverse a List Using Streams
        List<Integer> list39 = list.stream()
                .collect(
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                lst-> {
                                    Collections.reverse(lst);
                                    return lst;
                                }
                        )
                );

        //40. Reverse a String Using Streams
        String st40 = "abcd";
        String str40 = st40.chars()
                .mapToObj(String::valueOf)
                .reduce("",(a,b)->b+a);

        // 20 more tough ones

        List<Employee> employees = EmployeeDB.getEmployees();
        //1. Get names of all employees with salary > 60K and active status.
        List<String> list1 = employees.stream()
                .filter(emp->emp.getSalary()>60000 && emp.isActive())
                .map(Employee::getName)
                .toList();

        //2. Find the highest salary in each department.
        Map<String,Double> map2 = employees.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.mapping(
                                        Employee::getSalary,
                                        Collectors.collectingAndThen(
                                                Collectors.maxBy(Double::compareTo),
                                                opt->opt.orElse(0.0)
                                        )
                                )
                        )
                );

        //3 Group employees by department and count them.\
        Map<String,Long> map3 = employees.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.counting()
                        )
                );


        //4 Find the average salary of employees in each city.
        Map<String,Double> map4 = employees.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getCity,
                                Collectors.averagingDouble(Employee::getSalary)
                        )
                );

        //5 Find the youngest employee in each department.
        Map<String,Employee> map5  = employees.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.collectingAndThen(
                                        Collectors.minBy(Comparator.comparing(Employee::getAge)),
                                        opt->opt.orElse(new Employee())
                                )
                        )
                );

        // 6. Create a map of department -> list of employee names.
        Map<String,List<String>> map6 = employees.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.mapping(
                                        Employee::getName,
                                        Collectors.toList()
                                )
                        )
                );

        //7. Sort employees by salary descending, then by name ascending.
        List<Employee> list7 = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary,Comparator.reverseOrder())
                        .thenComparing(Comparator.comparing(Employee::getName)))
                .toList();

        //8. Partition employees into two groups: salary > 70K and ≤ 70K.
        Map<Boolean, List<Employee>> map8 = employees.stream()
                .collect(
                        Collectors.partitioningBy(
                                emp->emp.getSalary()>70000,
                                Collectors.toList()
                        )
                );

        //9 Find second-highest salary employee in IT department.
        Employee employee9 = employees.stream()
                .filter(emp->emp.getDepartment().equals("IT"))
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .skip(1)
                .findFirst()
                .orElse(new Employee());

        //10 Get employee names in uppercase who belong to Mumbai and are active.
        List<String> list10_1 = employees.stream()
                .filter(emp->emp.getCity().equals("Mumbai")&& emp.isActive())
                .map(Employee::getName)
                .map(String::toUpperCase)
                .toList();

        //11 Check if any employee from HR is older than 45.
        boolean check11 = employees.stream()
                .anyMatch(emp->emp.getAge()>45 && emp.getDepartment().equals("HR"));

        //12 Are all employees from IT active?
        boolean check12 = employees.stream()
                .filter(emp->emp.getDepartment().equals("IT"))
                .allMatch(Employee::isActive);

        //13 Find first inactive employee in Finance.
        Employee employee = employees.stream()
                .filter(emp->emp.getDepartment().equals("Finance") && !emp.isActive())
                .findFirst()
                .orElse(new Employee());

        //14. Get the top 3 highest paid employees.
        List<Employee> list14 = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .limit(3)
                .toList();

        //15. Get employee with the longest name.
        Employee employee15 = employees.stream()
                .sorted(Comparator.comparing((Employee emp)->emp.getName().length()).reversed())
                .findFirst()
                .orElse(new Employee());

        //16. Find total salary paid to employees under age 35.
        Double total = employees.stream()
                .filter(emp->emp.getAge()<35)
                .map(Employee::getSalary)
                .reduce(0.0, Double::sum);

        //17. List departments sorted by average salary descending.
        List<String> departmentsSortedByAvgSalary = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .toList();


        //18 Group employees by department, then by city.
        Map<String,Map<String,List<Employee>>> map18 = employees.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.groupingBy(
                                        Employee::getCity
                                )
                        )
                );

        //19 Find department with maximum number of active employees.
        String department19 = employees.stream()
                .filter(Employee::isActive)
                .collect(
                        Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.counting()
                        )
                ).entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("");
















































    }
}
