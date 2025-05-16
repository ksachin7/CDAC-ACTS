package com.cdac.acts.collect;

class Employee {
    String name;
    String department;
    String role;
    double salary;
    boolean isActive;

    public Employee(String name, String department, String role, double salary, boolean isActive) {
        this.name = name;
        this.department = department;
        this.role = role;
        this.salary = salary;
        this.isActive = isActive;
    }

    // Getters
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public String getRole() { return role; }
    public double getSalary() { return salary; }
    public boolean isActive() { return isActive; }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", role='" + role + '\'' +
                ", salary=" + salary +
                ", isActive=" + isActive +
                '}';
    }
}
