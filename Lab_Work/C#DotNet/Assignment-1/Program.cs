// See https://aka.ms/new-console-template for more information
// Console.WriteLine("Hello, World!");
using System;
class Program
{
    static void Main(string[] args)
    {
        Employee employee = new Employee("Pro Coder", 30, 36000, 101);

        Console.WriteLine($"Employee Name: {employee.Name}");
        Console.WriteLine($"Employee ID: {employee.EmpNo}");

        Console.WriteLine($"Employee Salary: {employee.GetSalary()}");
    }
}