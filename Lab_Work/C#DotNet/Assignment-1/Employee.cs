using System;
internal class Employee
{
    private string name;
    private int empNo;
    private decimal basic;
    private short deptNo;

    public Employee(string name, int empNo, decimal basic, short deptNo)
    {
        this.name = name;
        this.empNo = empNo;
        this.basic = basic;
        this.deptNo = deptNo;
    }

    public decimal GetSalary()
    {
        return basic + (basic * 0.2m); // Assuming a 20% bonus on basic salary
    }

    public string Name
    {
        get { return name; }
        set { name = value; }
    }

    public int EmpNo
    {
        get { return empNo; }
        set { empNo = value; }
    }

    public decimal Basic
    {
        get { return basic; }
        set { basic = value; }
    }
    public short DeptNo
    {
        get { return deptNo; }
        set { deptNo = value; }
    }
}