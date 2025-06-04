const express = require("express");

const router = express.Router();

router.post("/add", (req, res) => {
    const { num1, num2 } = req.body;
    const result = parseFloat(num1) + parseFloat(num2);
    res.send(`Result: ${result}`);
});

router.post("/subtract", (req, res) => {
    const { num1, num2 } = req.body;
    const result = parseFloat(num1) - parseFloat(num2);
    res.send(`Result: ${result}`);
});

router.post("/multiply", (req, res) => {
    const { num1, num2 } = req.body;
    const result = parseFloat(num1) * parseFloat(num2);
    res.send(`Result: ${result}`);
});

router.post("/divide", (req, res) => {
    const { num1, num2 } = req.body;
    const a = parseFloat(num1);
    const b = parseFloat(num2);

    if (b === 0) {
        return res.send("Cannot divide by zero");
    }

    res.send(`Result: ${a / b}`);
});


module.exports = router;

