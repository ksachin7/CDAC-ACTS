const express = require("express")
const bodyParser = require('body-parser')
const cors = require('cors')

const app = express();
const PORT = 3000;

app.use(cors({
    origin: '*',
    methods: ['GET', 'POST', 'DELETE']
}))

app.use(bodyParser.json())
app.use(bodyParser.urlencoded({ extended: true }))

let fruits = []

app.post('/save', (req, res) => {
    const formData = req.body;
    console.log("form-data: ", formData)
    if (formData) {
        fruits.push(formData.name)
        res.json("fruit saved successfully!")
    }
    else res.status(400).json({ error: "Invalid data!" });
})

app.get('/fruits', (req, res) => {
    res.json(fruits)
})

app.delete('/delete', (req, res) => {
    const { name } = req.body;  // get fruit name from JSON body

    if (!name || typeof name !== 'string') {
        return res.status(400).json({ error: "Fruit name is required and must be a string." });
    }

    const index = fruits.indexOf(name);
    if (index === -1) {
        return res.status(404).json({ error: "Fruit not found." });
    }

    fruits.splice(index, 1);  // remove fruit from array
    res.json({ message: `Fruit "${name}" deleted successfully.` });
});

// Error handling middleware
app.use((err, req, res, next) => {
    console.error(err.stack);
    res.status(500).json({ error: 'Something went wrong!' });
});

app.listen(PORT, () => {
    console.log(`Server is listening on Port: ${PORT}`)
})