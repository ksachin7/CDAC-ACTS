const express = require("express");
const path = require("path");

const router = express.Router();

router.get("/", (req, res) => {
    res.sendFile(path.join(__dirname, "../public/index.html"));
});

router.get("/data", (req, res) => {
    res.send("This is data");
});

router.get("/profile", (req, res) => {
    res.send("This is profile");
});

module.exports = router;
