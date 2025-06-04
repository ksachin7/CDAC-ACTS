const express = require("express");
// const cors = require("cors");
const path = require("path");

const app = express();

// Serve static frontend
app.use(express.static(path.join(__dirname, "public")));

// app.use(cors({
//   origin: ['http://localhost:5500', 'http://127.0.0.1:5500']
// }));

app.use(express.json());

const movies = [];

app.post("/api/movies", (req, res) => {
  const { movieName, actor, release, types } = req.body;

  if (movieName.length < 5 || actor.length < 3) {
    return res.status(400).json({ error: "Validation failed" });
  }

  const newMovie = { movieName, actor, release, types };
  movies.push(newMovie);
  res.json(newMovie);
});

const PORT = 3000;
app.listen(PORT, () => {
  console.log(`Server running on http://localhost:${PORT}`);
});
