const fs = require('fs').promises;
const readline = require('readline')

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
})

async function processNumbers() {
    try {
        const ask = q => new Promise(res => rl.question(q, res));

        const dataFile = await ask('enter the file to read input from: ');
        const outFile = await ask('enter file name to write on to: ')
        rl.close()

        const data = await fs.readFile(dataFile, 'utf8');

        const numbers = data
            .split(',')
            .map(e => parseInt(e.trim()))
            .filter(n => !isNaN(n));

        const sum = numbers.reduce((acc, val) => acc + val, 0);
        const expression = `${numbers.join('+')} = ${sum}`;
        await fs.writeFile(outFile, expression);

        console.log("Sum written successfully:", expression);
    } catch (err) {
        console.error("Error:", err.message);
    }
}

processNumbers();
