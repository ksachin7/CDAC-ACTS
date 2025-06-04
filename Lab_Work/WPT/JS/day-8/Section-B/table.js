const fs = require("fs")
const fs_prom = require("fs/promises")

let table = ""
for (let i = 1; i <= 10; i++) {
    table += `3x${i}= ${3 * i} \n`
}

// using synchronous writeFileSync
fs.writeFileSync("out/tableOfThree.txt", table);

// Note: it requires 'out' dir. to be existed
// another way: using async writeFile
fs.writeFile("out/tableOfThree.txt", table, (err) => {
    if (err) {
        console.error("Failed to write file:", err);
    } else {
        console.log("File written successfully!");
    }
});

// newer way: using promises
(async () => {
    try {
        await fs_prom.writeFile("out/tableOfThree.txt", table)
        console.log("File written successfully!");
    }
    catch(err) {
        console.error("Failed to write file:", err);
    }
})();

// reading from file
fs.readFile("out/tableOfThree.txt", "utf8", (err, data)=>{
    if (err) {
        console.log("Error reading file: ", err);
    }else{
        console.log(`\nTable of Three: \n${data}`)
    }
})