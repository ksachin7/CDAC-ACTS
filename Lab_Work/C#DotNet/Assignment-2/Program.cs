// See https://aka.ms/new-console-template for more information
// Console.WriteLine("Hello, World!");

Employee emp1 = new Employee("Ganesh", 30000, 2);
Console.WriteLine($"Employee No: {emp1.EmpNo}, Name: {emp1.Name}, Basic: {emp1.Basic}, DeptNo: {emp1.DeptNo}");
Console.WriteLine($"Net Salary: {emp1.GetNetSalary()}");

Employee emp2 = new Employee("Swati", 50000, 10);
Console.WriteLine($"Employee No: {emp2.EmpNo}, Name: {emp2.Name}, Basic: {emp2.Basic}, DeptNo: {emp2.DeptNo}");
Console.WriteLine($"Net Salary: {emp2.GetNetSalary()}");

Employee emp3 = new Employee("Rahul", 15000);
Console.WriteLine($"Employee No: {emp3.EmpNo}, Name: {emp3.Name}, Basic: {emp3.Basic}, DeptNo: {emp3.DeptNo}");
Console.WriteLine($"Net Salary: {emp3.GetNetSalary()}");

Employee emp4 = new Employee();
Console.WriteLine($"Employee No: {emp4.EmpNo}, Name: {emp4.Name}, Basic: {emp4.Basic}, DeptNo: {emp4.DeptNo}");
Console.WriteLine($"Net Salary: {emp4.GetNetSalary()}");
