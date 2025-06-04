const express = require("express");
const path = require("path");

const app = express();
const PORT = 3000;

app.use(express.json());
app.use(express.static(path.join(__dirname, "public")));

app.post("/calculate", (req, res) => {
    const { num1, num2, operation } = req.body;
    const a = parseFloat(num1);
    const b = parseFloat(num2);
    let result;

    switch (operation) {
        case "add": result = a + b; break;
        case "subtract": result = a - b; break;
        case "multiply": result = a * b; break;
        case "divide":
            if (b === 0) return res.json({ error: "Cannot divide by zero" });
            result = a / b;
            break;
        default: return res.json({ error: "Invalid operation" });
    }

    res.json({ result });
});

app.listen(PORT, () => {
    console.log(`Server running on http://localhost:${PORT}`);
});
