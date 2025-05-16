package com.cdac.acts.collect;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class StreamOperationsExample {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "Engineering", "Developer", 70000, true),
                new Employee("Bob", "Engineering", "Developer", 50000, true),
                new Employee("Charlie", "HR", "Manager", 60000, false),
                new Employee("Diana", "Engineering", "Tester", 40000, true),
                new Employee("Eve", "HR", "Assistant", 35000, true)
        );

        // 1. Filter and collect to list
        List<Employee> activeEmployees = employees.stream()
                .filter(Employee::isActive)
                .collect(toList());

        // 2. Partitioning by predicate (active vs inactive)
        Map<Boolean, List<Employee>> partitionedByActive = employees.stream()
                .collect(partitioningBy(Employee::isActive));


        // 3. Grouping by single key (department)
        Map<String, List<Employee>> groupByDepartment = employees.stream()
                .collect(groupingBy(Employee::getDepartment));

        // 4. Grouping by multiple keys using custom key class (department + role)
        record DeptRole(String department, String role) {}

        Map<DeptRole, List<Employee>> groupByDeptAndRole = employees.stream()
                .collect(groupingBy(e -> new DeptRole(e.getDepartment(), e.getRole())));

        // 5. Nested grouping (department -> role)
        Map<String, Map<String, List<Employee>>> nestedGroup = employees.stream()
                .collect(groupingBy(Employee::getDepartment,
                        groupingBy(Employee::getRole)));

        // using map
//        Map<String, Map<String, Employee>> deptToRoleToEmployee =
//                employees.stream()
//                        .collect(Collectors.groupingBy(
//                                Employee::getDepartment,
//                                Collectors.toMap(
//                                        Employee::getRole,     // key
//                                        e -> e,                // value
//                                        (e1, e2) -> e1         // merge function if duplicate keys
//                                )
//                        ));
//        System.out.println("Map Grouped by Department & Role: " + deptToRoleToEmployee);

        // 6. Counting employees per department
        Map<String, Long> countByDepartment = employees.stream()
                .collect(groupingBy(Employee::getDepartment, counting()));

        // 7. Summing salary per department
        Map<String, Double> totalSalaryByDepartment = employees.stream()
                .collect(groupingBy(Employee::getDepartment, summingDouble(Employee::getSalary)));

        // Output
        System.out.println("Active Employees: " + activeEmployees);
        System.out.println("Partitioned by Active: " + partitionedByActive);
        System.out.println("Grouped by Department: " + groupByDepartment);
        System.out.println("Grouped by Department & Role: " + groupByDeptAndRole);
        System.out.println("Nested Grouping (Dept -> Role): " + nestedGroup);
        System.out.println("Employee Count by Dept: " + countByDepartment);
        System.out.println("Total Salary by Dept: " + totalSalaryByDepartment);
    }
}
