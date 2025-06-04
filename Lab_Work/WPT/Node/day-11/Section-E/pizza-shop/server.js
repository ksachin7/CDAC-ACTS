const express = require("express");
const cors = require("cors");

const app = express();

app.use(cors());
app.use(express.json());

const orders = [];

app.post("/api/orders", (req, res) => {
  const { name, topping, sauce, extras, instructions } = req.body;

  if (!name || name.length < 5) {
    return res.status(400).json({ error: "Name must be at least 5 characters." });
  }

  if (sauce === "Tomato" && topping === "Supreme") {
    return res.status(400).json({ error: "Supreme topping is not allowed with Tomato sauce." });
  }

  if (!instructions || instructions.trim().split(/\s+/).length < 5) {
    return res.status(400).json({ error: "Instructions must have at least 5 words." });
  }

  const order = { name, topping, sauce, extras, instructions };
  orders.push(order);
  res.json(order);
});

const PORT = 3000;
app.listen(PORT, () => {
  console.log(`Server running at http://localhost:${PORT}`);
});
