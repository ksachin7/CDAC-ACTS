const readline = require('readline')

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
})

// const num = 100;

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

// printFibonacci(num)
// let fib= printFibonacci(num)
// console.log(fib, " ")

const ask = q => new Promise(res => rl.question(q, res));

async function main() {
    const input = await ask("Enter a number: ")
    const num = parseInt(input)

    if (isNaN(num)) console.error("Please enter a valid number!")
    else printFibonacci(num)
    rl.close()
}

main()