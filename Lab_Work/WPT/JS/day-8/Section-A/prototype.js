// Implementing Inheritance with Prototypes
// Task:
// -> Write a constructor function named Person that accepts two parameters: name and age.
// -> Add a method greet on Person.prototype that returns "Hello, I'm <name>!".
// -> Write another constructor function called Student that inherits from Person and accepts an additional parameter subject.
// -> Add a method study on Student.prototype that returns "<name> is studying <subject>.".
// -> Ensure that Student inherits the greet method from Person using prototype inheritance.

// Note : Implement this without using ES6 class syntax. Consider how you’ll link the prototype chain and ensure the constructor property is correctly set.


function Person(name, age) {
    this.name=name;
    this.age= age;
}

Person.prototype.greet = function () {
    return `Hello, I'm ${this.name}!`;
}

function Student(name, age, subject) {
    Person.call(this, name, age)
    this.subject = subject;
}

// Inheriting Student from Person
Student.prototype= Object.create(Person.prototype)
// The constructor will point to Person, not Student — which is not what we want

// SO, This line manually sets it back
Student.prototype.constructor= Student

Student.prototype.study= function(){
    return `${this.name} is studying  ${this.subject}.`
}


// Creating Student Obj
const Pranit= new Student("Pranit", 22, "Mathematics")

// Calling Person method
console.log(Pranit.greet())

// Calling Student method
console.log(Pranit.study())

// Terminal Output:
// ❯ node prototype.js
// Hello, I'm Pranit!
// Pranit is studying  Mathematics