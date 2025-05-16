package eclipse_workspace.day7.emp;

import java.time.LocalDate;
import java.util.Scanner;

public class EmployeeInputHandler {

    private Scanner sc = new Scanner(System.in);

    public Employee collectEmployeeDetails() {
        System.out.print("Enter employee id: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter employee name: ");
        String name = sc.nextLine();

        System.out.print("Enter employee street: ");
        String street = sc.nextLine();

        System.out.print("Enter employee city: ");
        String city = sc.nextLine();

        System.out.print("Enter employee state: ");
        String state = sc.nextLine();

        System.out.print("Enter employee country: ");
        String country = sc.nextLine();

        System.out.print("Enter employee pincode: ");
        int pincode = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter employee salary: ");
        double sal = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter employee DOB (yyyy-MM-dd): ");
        LocalDate dob = LocalDate.parse(sc.nextLine());

        System.out.print("Enter employee DOJ (yyyy-MM-dd): ");
        LocalDate doj = LocalDate.parse(sc.nextLine());

        System.out.print("Enter employee department (HR/IT/SALES/ADMIN/FINANCE): ");
        Dept dept = Dept.valueOf(sc.nextLine().toUpperCase());

        Address address = new Address(street, city, state, country, pincode);
        return new Employee(name, id, sal, address, dob, doj, dept);
    }
}
