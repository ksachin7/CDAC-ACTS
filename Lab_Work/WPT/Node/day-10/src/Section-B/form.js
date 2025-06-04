const http = require('http');
const fs = require('fs');
const path = require('path');
const url = require('url');

const PORT = 3000;
console.log(__dirname)
const publicDir = path.join(__dirname, '../..', 'public');

const server = http.createServer((req, res) => {
    const parsedUrl = url.parse(req.url, true);
    // console.log(parsedUrl)
    if (req.url === '/data') {
        const filePath = path.join(publicDir, 'data.html');
        serveHTML(res, filePath);
    } else if (req.url === '/profile') {
        const filePath = path.join(publicDir, 'profile.html');
        serveHTML(res, filePath);
    } else if ( parsedUrl.pathname === '/submit') {
        console.log("req.url: ",req.url)
        console.log("parsedUrl: ",parsedUrl)
        let body = '';

        req.on('data', chunk => {
            body += chunk.toString(); // convert buffer to string
        });
        console.log(body);
        
        req.on('end', () => {
            const formData = new URLSearchParams(body);
            console.log("FormData: ",formData)

            const name = formData.get('name');
            const email = formData.get('email');
            const tel = formData.get('tel');

            res.writeHead(200, { 'Content-Type': 'text/html' });
            res.end(`
            <h1>Thank You, ${name}!</h1>
            <p>Email: ${email}</p>
            <p>Phone: ${tel}</p>
        `);
        });
    }
    else {
        res.writeHead(404, { 'Content-Type': 'text/plain' });
        res.end('404 Not Found');
    }
});

function serveHTML(res, filePath) {
    // console.log("Attempting to read:", filePath);
    fs.readFile(filePath, 'utf8', (err, content) => {
        if (err) {
            res.writeHead(500, { 'Content-Type': 'text/plain' });
            res.end('Internal Server Error: ', err);
        } else {
            res.writeHead(200, { 'Content-Type': 'text/html' });
            res.end(content);
        }
    });
}

server.listen(PORT, () => {
    console.log(`Server running at http://localhost:${PORT}`);
});
