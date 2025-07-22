using System;
using System.Collections.Generic;
using System.Linq;

class Employee
{
    public int EmpNo { get; set; }
    public string Name { get; set; }
    public decimal Salary { get; set; }

    public Employee(int empNo, string name, decimal salary)
    {
        EmpNo = empNo;
        Name = name;
        Salary = salary;
    }

    public void Display()
    {
        Console.WriteLine($"EmpNo: {EmpNo}, Name: {Name}, Salary: {Salary}");
    }
}

class Program
{
    static void Main()
    {
        List<Employee> employees = new List<Employee>();
        string? choice;

        do
        {
            int empNo = ReadInt("Enter EmpNo: ");
            string name = ReadString("Enter Name: ");
            decimal salary = ReadDecimal("Enter Salary: ");

            employees.Add(new Employee(empNo, name, salary));

            choice = ReadString("Do you want to add another employee? (yes/no): ").ToLower();
        } while (choice == "yes");

        if (employees.Count > 0)
        {
            Employee highestPaid = employees.OrderByDescending(e => e.Salary).First();

            Console.WriteLine("\nEmployee with Highest Salary:");
            highestPaid.Display();
        }

        int searchEmpNo = ReadInt("\nEnter EmpNo to search: ");
        var foundEmp = employees.FirstOrDefault(e => e.EmpNo == searchEmpNo);
        if (foundEmp != null)
        {
            Console.WriteLine("Employee found:");
            foundEmp.Display();
        }
        else
        {
            Console.WriteLine("Employee not found.");
        }

        int n = ReadInt("\nEnter N (1-based index) to view Nth employee: ");
        if (n >= 1 && n <= employees.Count)
        {
            Console.WriteLine($"Details of Employee #{n}:");
            employees[n - 1].Display();
        }
        else
        {
            Console.WriteLine("Invalid index.");
        }

        Console.WriteLine("\n--- Part 2 and 3 follow ---\n");
        RunPart2And3();
    }

    static int ReadInt(string prompt)
    {
        int value;
        while (true)
        {
            Console.Write(prompt);
            string? input = Console.ReadLine();
            if (int.TryParse(input, out value))
                return value;
            Console.WriteLine("Invalid input. Please enter a valid integer.");
        }
    }

    static decimal ReadDecimal(string prompt)
    {
        decimal value;
        while (true)
        {
            Console.Write(prompt);
            string? input = Console.ReadLine();
            if (decimal.TryParse(input, out value))
                return value;
            Console.WriteLine("Invalid input. Please enter a valid decimal number.");
        }
    }

    static string ReadString(string prompt)
    {
        string? input;
        do
        {
            Console.Write(prompt);
            input = Console.ReadLine();
            if (!string.IsNullOrWhiteSpace(input))
                return input.Trim();
            Console.WriteLine("Input cannot be empty.");
        } while (true);
    }

    static void RunPart2And3()
    {
        Console.WriteLine("Part 2: Convert Array to List and Display:");
        Employee[] empArray = new Employee[]
        {
            new Employee(201, "Amit", 45000),
            new Employee(202, "Sneha", 55000),
            new Employee(203, "Rahul", 40000)
        };

        List<Employee> empListFromArray = new List<Employee>(empArray);
        foreach (var emp in empListFromArray)
            emp.Display();

        Console.WriteLine("\nPart 3: Convert List to Array and Display:");
        List<Employee> empList = new List<Employee>
        {
            new Employee(301, "John", 60000),
            new Employee(302, "Priya", 65000),
            new Employee(303, "Karan", 70000)
        };

        Employee[] arrayFromList = empList.ToArray();
        foreach (var emp in arrayFromList)
            emp.Display();
    }
}
