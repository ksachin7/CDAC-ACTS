using System;

public class Employee
{
    private static int empNoCounter = 0;

    // Fields
    private readonly int empNo;
    private string name;
    private decimal basic;
    private short deptNo;

    public int EmpNo => empNo;

    public string Name
    {
        get => name;
        set
        {
            if (string.IsNullOrWhiteSpace(value))
                throw new ArgumentException("Name cannot be blank.");
            name = value;
        }
    }

    public decimal Basic
    {
        get => basic;
        set
        {
            if (value < 10000 || value > 50000)
                throw new ArgumentException("Basic salary must be between 10,000 and 50,000.");
            basic = value;
        }
    }

    public short DeptNo
    {
        get => deptNo;
        set
        {
            if (value <= 0)
                throw new ArgumentException("DeptNo must be greater than 0.");
            deptNo = value;
        }
    }

    public Employee(string name, decimal basic, short deptNo)
    {
        empNo = ++empNoCounter;
        Name = name;
        Basic = basic;
        DeptNo = deptNo;
    }

    public Employee(string name, decimal basic) : this(name, basic, 1)
    { }

    public Employee(string name) : this(name, 10000, 1)
    { }

    public Employee() : this("Unknown", 10000, 1)
    { }

    public decimal GetNetSalary()
    {
        // Net = Basic + HRA(20%) + DA(10%) - Tax(5%)
        decimal hra = Basic * 0.20m;
        decimal da = Basic * 0.10m;
        decimal tax = Basic * 0.05m;
        return Basic + hra + da - tax;
    }
}
