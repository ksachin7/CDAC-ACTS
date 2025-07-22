class Program
{
    static void Main()
    {
        // ------------- CDAC Batch Management System ---------------
        // CDACBatch batch1 = new CDACBatch();
        // batch1.AcceptBatch(1, 3);
        // batch1.DisplayBatch(1);

        // CDACBatch batch2 = new CDACBatch();
        // batch2.AcceptBatch(2);
        // batch2.DisplayBatch(2);

        // ------------- Employee Management System ---------------
        Console.Write("Enter the number of employees: ");
        int n = int.Parse(Console.ReadLine());

        Employee[] employees = new Employee[n];

        // Accept employee details
        for (int i = 0; i < n; i++)
        {
            Console.WriteLine($"\nEnter details for Employee {i + 1}:");
            employees[i] = new Employee();
            employees[i].AcceptDetails();
        }

        // Find employee with highest salary
        Employee highestPaid = employees[0];
        foreach (var emp in employees)
        {
            if (emp.Salary > highestPaid.Salary)
                highestPaid = emp;
        }

        Console.WriteLine("\nEmployee with highest salary:");
        highestPaid.DisplayDetails();

        // Search for an employee by EmpNo
        Console.Write("\nEnter EmpNo to search: ");
        int searchEmpNo = int.Parse(Console.ReadLine());

        bool found = false;
        foreach (var emp in employees)
        {
            if (emp.EmpNo == searchEmpNo)
            {
                Console.WriteLine("Employee found:");
                emp.DisplayDetails();
                found = true;
                break;
            }
        }

    }
}
