const express = require("express");
const path = require("path");

const app = express();
const PORT = 3000;

let movies = [];

app.use(express.json());
app.use(express.static(path.join(__dirname, "public")));

app.post("/add-movies", (req, res) => {
    const movieData = req.body;

    if (!Array.isArray(movieData) || movieData.length !== 3) {
        return res.status(400).json({ error: "Must send 3 movie objects" });
    }

    movies = movieData;
    res.json({ message: "Movies saved successfully" });
});

app.get("/movies", (req, res) => {
    res.json(movies);
});

app.listen(PORT, () => {
    console.log(`Server running at http://localhost:${PORT}`);
});
