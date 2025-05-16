package eclipse_workspace.day7.emp;

import eclipse_workspace.day8.emp.Employee;
import eclipse_workspace.day8.emp.EmployeeInputHandler;

public class Test {
    public static void main(String[] args) {
        EmployeeInputHandler inputHandler = new EmployeeInputHandler();
        Employee emp = inputHandler.collectEmployeeDetails();

        System.out.println("\n" + emp);

        if (emp.isEligibleForGratuity()) {
            System.out.println("Employee is eligible for gratuity.");
        } else {
            System.out.println("Employee is NOT eligible for gratuity.");
        }
    }
}
