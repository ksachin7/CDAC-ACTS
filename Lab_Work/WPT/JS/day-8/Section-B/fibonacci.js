const num = 100;

// Fibonacci: 0, 1, 1, 2, 3, 5, 8, 13, 21, ...
const printFibonacci = (num) => {
    let first = 0, second = 1;

    for (let i = 0; i < num; i++) {
        // console.log(first);
        process.stdout.write(first + " ");
        let next = first + second;
        first = second;
        second = next;
    }
    return first;
}

printFibonacci(num)
// let fib= printFibonacci(num)
// console.log(fib, " ")