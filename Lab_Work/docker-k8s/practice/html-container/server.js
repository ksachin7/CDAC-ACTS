const express = require('express');
const path = require('path');
const app = express();
const PORT = 3000;

// Middleware to parse JSON body
app.use(express.json());

// Serve static files from public folder
app.use(express.static(path.join(__dirname, 'public')));

// To store submitted data in-memory (for demo)
let submittedData = [];

// API endpoint to receive form data
app.post('/submit', (req, res) => {
  const { name, email } = req.body;
  if(!name || !email) {
    return res.status(400).json({ error: 'Name and email required' });
  }
  submittedData.push({ name, email });
  res.json({ success: true, data: submittedData });
});

// Start server
app.listen(PORT, () => {
  console.log(`Server running at http://localhost:${PORT}`);
});
