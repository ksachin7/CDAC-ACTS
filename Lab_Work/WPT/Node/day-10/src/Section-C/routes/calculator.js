const express = require("express");

const router = express.Router();

router.post("/calculate", (req, res) => {
    const { num1, num2, operation } = req.body;
    
    const a = parseFloat(num1);
    const b = parseFloat(num2);
    let result;

    if (isNaN(a) || isNaN(b)) {
        return res.send("Invalid numbers");
    }

    switch (operation) {
        case "add": result = a + b; break;
        case "subtract": result = a - b; break;
        case "multiply": result = a * b; break;
        case "divide": result = b !== 0 ? a / b : "Cannot divide by zero"; break;
        case "modulus": result = b !== 0 ? a % b : "Cannot divide by zero"; break;
        default: result = "Invalid operation";
    }

    res.send(`Result: ${result}`);
});

module.exports = router;