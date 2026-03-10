package collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsDemo {

    public static void main(String[] args) {
        Employee employee = new Employee("Santosh", 26, 56500.82, Gender.MALE);
        Employee employee1 = new Employee("Deepak", 26, 66500.82, Gender.MALE);
        Employee employee2 = new Employee("Laxmi", 26, 26500.82, Gender.FEMALE);
        List<Employee> employees = Arrays.asList(employee, employee1, employee2);

        // COllectors partitionBy
        Map<Boolean, List<Employee>> partitionByGenderMap = employees.stream()
                .collect(Collectors.partitioningBy(emp -> emp.getGender().equals(Gender.MALE)));

        partitionByGenderMap.forEach((empKey, empValue) -> System.out.println(empValue.toString()));

        // Collectors groupingBy - Return count of each employee based on gender
        Map<String, Long> countMap = employees.stream()
                .collect(Collectors.groupingBy(emp -> emp.getGender().name(), Collectors.counting()));
        System.out.println(countMap);

        // Return a string with each employee name in sorted order and comma separated in array format
        String employeesName = employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .map(Employee::getName)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println("Employees name: "+ employeesName);

        // Average of salary
        double averageSalary = employees.stream()
                .map(Employee::getSalary)
                .collect(Collectors.averagingDouble(salary -> salary));

        System.out.println("Average salary: " + averageSalary);

        // Total salary provided
        double totalSalary = employees.stream()
                .map(Employee::getSalary)
                .collect(Collectors.reducing(0.0, (a,b) -> a+b));

        System.out.println("Total salary: "+ totalSalary);
    }
}

class Employee {

    private String name;

    private int age;

    private double salary;

    private Gender gender;

    public Employee(String name, int age, double salary, Gender gender) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", gender=" + gender +
                '}';
    }
}

enum Gender {
    MALE,
    FEMALE
}