class Employee {
  constructor(name, email, salary, department) {
    this.name = name;
    this.email = email;
    this.salary = salary;
    this.department = department;
  }

  calculateTax() {
    return this.salary * 0.2;
  }
}

class Student {
  constructor(name, email, department, dob, marks) {
    this.name = name;
    this.email = email;
    this.department = department;
    this.dob = dob;
    this.marks = marks;
  }

  calculateTotalMarks() {
    return this.marks.reduce((acc, m) => acc + m.mark, 0);
  }
}
