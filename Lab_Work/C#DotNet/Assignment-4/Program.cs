using System;

interface IDbFunctions
{
    void Insert();
    void Update();
    void Delete();
}

abstract class Employee : IDbFunctions
{
    private static int empCounter = 1000;
    private string name;
    private short deptNo;

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

    public readonly int EmpNo;

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

    public abstract decimal Basic { get; set; }

    public abstract decimal CalcNetSalary();

    public Employee(string name, short deptNo)
    {
        EmpNo = ++empCounter;
        Name = name;
        DeptNo = deptNo;
    }

    // IDbFunctions implementation
    public void Insert() => Console.WriteLine($"Inserting record for EmpNo {EmpNo}");
    public void Update() => Console.WriteLine($"Updating record for EmpNo {EmpNo}");
    public void Delete() => Console.WriteLine($"Deleting record for EmpNo {EmpNo}");
}

class Manager : Employee
{
    private string designation;
    private decimal basic;

    public string Designation
    {
        get => designation;
        set
        {
            if (string.IsNullOrWhiteSpace(value))
                throw new ArgumentException("Designation cannot be blank.");
            designation = value;
        }
    }

    public override decimal Basic
    {
        get => basic;
        set
        {
            if (value < 30000 || value > 80000)
                throw new ArgumentException("Basic salary for Manager must be between 30,000 and 80,000.");
            basic = value;
        }
    }

    public override decimal CalcNetSalary()
    {
        return Basic + (Basic * 0.3M) + 5000; // DA + Fixed Allowance
    }

    public Manager(string name, short deptNo, string designation, decimal basic)
        : base(name, deptNo)
    {
        Designation = designation;
        Basic = basic;
    }
}

class GeneralManager : Manager
{
    public string Perks { get; set; }

    public override decimal Basic
    {
        get => base.Basic;
        set
        {
            if (value < 50000 || value > 100000)
                throw new ArgumentException("Basic salary for General Manager must be between 50,000 and 100,000.");
            base.Basic = value;
        }
    }

    public override decimal CalcNetSalary()
    {
        return Basic + (Basic * 0.4M) + 10000; // More perks and DA
    }

    public GeneralManager(string name, short deptNo, string designation, decimal basic, string perks)
        : base(name, deptNo, designation, basic)
    {
        Perks = perks;
    }
}

class CEO : Employee
{
    private decimal basic;

    public override decimal Basic
    {
        get => basic;
        set
        {
            if (value < 100000)
                throw new ArgumentException("CEO's Basic must be >= 100000.");
            basic = value;
        }
    }

    public sealed override decimal CalcNetSalary()
    {
        return Basic + (Basic * 0.5M) + 20000; // CEO gets highest DA and bonus
    }

    public CEO(string name, short deptNo, decimal basic)
        : base(name, deptNo)
    {
        Basic = basic;
    }
}
class Program
{
    static void Main()
    {
        try
        {
            Manager mgr = new Manager("Alice", 10, "HR Manager", 50000);
            GeneralManager gm = new GeneralManager("Bob", 20, "GM IT", 75000, "Car, House");
            CEO ceo = new CEO("Charlie", 1, 120000);

            Console.WriteLine($"Manager Salary: {mgr.CalcNetSalary()}");
            Console.WriteLine($"GM Salary: {gm.CalcNetSalary()}");
            Console.WriteLine($"CEO Salary: {ceo.CalcNetSalary()}");

            mgr.Insert(); gm.Update(); ceo.Delete();
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Error: {ex.Message}");
        }
    }
}
