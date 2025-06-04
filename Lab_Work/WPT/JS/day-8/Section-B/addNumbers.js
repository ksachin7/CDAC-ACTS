const fs = require("fs")

let sum = 0;
const data = fs.readFileSync("out/listOfNums.txt", "utf8");
const numbers = data.split(", ").map(e => parseInt(e))

sum = numbers.reduce((acc, val) => acc + val, 0);

const expression = numbers.join('+') + ' = ' + sum;

fs.writeFileSync("out/sumOfNums.txt", expression);