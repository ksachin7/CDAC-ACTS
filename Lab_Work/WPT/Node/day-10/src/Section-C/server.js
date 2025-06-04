const express = require("express");
const path = require("path");

const app = express();
const PORT = 3000;

app.use(express.urlencoded({ extended: true }));

app.use(express.static(path.join(__dirname, "public")));

const basicRoutes = require("./routes/basicRoutes");
const calcRoutes = require("./routes/calculator");
const arithmaticRoutes = require("./routes/arithmatic");
const registerRoutes = require("./routes/register");

app.use("/", basicRoutes);
app.use("/", calcRoutes);
app.use("/", registerRoutes);
app.use("/", arithmaticRoutes)

app.use("/", require("./routes/arithmatic"));

app.listen(PORT, () => {
    console.log(`Server running at http://localhost:${PORT}`);
});
