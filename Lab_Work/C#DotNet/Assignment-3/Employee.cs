using System;

class Employee
{
    public int EmpNo { get; set; }
    public string Name { get; set; }
    public double Salary { get; set; }

    public void AcceptDetails()
    {
        Console.Write("Enter Employee Number: ");
        EmpNo = int.Parse(Console.ReadLine());

        Console.Write("Enter Name: ");
        Name = Console.ReadLine();

        Console.Write("Enter Salary: ");
        Salary = double.Parse(Console.ReadLine());
    }

    public void DisplayDetails()
    {
        Console.WriteLine($"EmpNo: {EmpNo}, Name: {Name}, Salary: {Salary}");
    }
}
