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

app.get('/fruits', (req, res) => {
    res.json(fruits)
})

app.post('/save', (req, res) => {
    const formData = req.body;
    console.log("form-data: ", formData)

    if (formData) {
        fruits.push(formData.name)
        res.json("fruit saved successfully!")
    }
    else res.status(400).json({ error: "Invalid data!" });
})

app.delete('/delete', (req, res) => {
    const { name } = req.body;  // get fruit name from JSON body
    console.log(req.params)

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

app.put('/update', (req, res) => {
    const { oldName, newName } = req.body;

    if (!oldName || !newName || typeof oldName !== 'string' || typeof newName !== 'string') {
        return res.status(400).json({ error: "Both oldName and newName are required and must be strings." });
    }

    const index = fruits.indexOf(oldName);
    if (index === -1) {
        return res.status(404).json({ error: "Fruit not found." });
    }

    fruits[index] = newName;
    res.json({ message: `Fruit renamed from "${oldName}" to "${newName}".` });
});

// Error handling middleware
app.use((err, req, res, next) => {
    console.error(err.stack);
    res.status(500).json({ error: 'Something went wrong!' });
});

app.listen(PORT, () => {
    console.log(`Server is listening on Port: ${PORT}`)
})