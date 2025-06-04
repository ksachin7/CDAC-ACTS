const express = require("express");

const router = express.Router();

// console.log("__dirname: ", __dirname)
// console.log("__filename: ", __filename)

// __dirname:  /Users/sachin/Desktop/CDAC_ACTS/Lab_Work/WPT/Node/day-10/src/Section-C
// __filename:  /Users/sachin/Desktop/CDAC_ACTS/Lab_Work/WPT/Node/day-10/src/Section-C/register.js

router.post("/register", (req, res) => {
    console.log("Received registration data:", req.body);
    res.send("Got the data!");
});

module.exports = router;
