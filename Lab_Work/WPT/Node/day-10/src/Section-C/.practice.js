const express = require("express");
const path = require("path");
const app = express();
const PORT = 3000;

// Middleware to parse form data
app.use(express.urlencoded({ extended: true }));

// Serve static files from public
app.use(express.static(path.join(__dirname, "public")));

// 1. Simple text routes
app.get("/data", (req, res) => {
    res.send("This is data");
});

app.get("/profile", (req, res) => {
    res.send("This is profile");
});

// 2. Arithmetic operations
app.post("/calculate", (req, res) => {
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

// 4. Register form handler
app.post("/register", (req, res) => {
    console.log("Received registration data:", req.body);
    res.send("Got data");
});

// Start server
app.listen(PORT, () => {
    console.log(`Server running at http://localhost:${PORT}`);
});
