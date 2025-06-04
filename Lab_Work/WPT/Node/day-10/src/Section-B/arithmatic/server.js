const http = require("http");
const fs = require("fs");
const path = require("path");
const PORT = 3000;

// const publicDir = path.join(__dirname, 'public');

const server = http.createServer((req, res) => {
    const url = new URL(req.url, `http://${req.headers.host}`);
    // console.log("req.url: ", req.url)
    // console.log("url: ", url)
    /* Example url Output:
    req.url:  /subtract
    url:  URL {
        href: 'http://localhost:3000/subtract',
        origin: 'http://localhost:3000',
        protocol: 'http:',
        username: '',
        password: '',
        host: 'localhost:3000',
        hostname: 'localhost',
        port: '3000',
        pathname: '/subtract',
        search: '',
        searchParams: URLSearchParams {},
        hash: ''
    }
    */

    if (req.method === "GET") {
        let filePath = "";
        if (url.pathname === "/") filePath = "index.html";
        else if (url.pathname === "/add") filePath = "addition.html";
        else if (url.pathname === "/subtract") filePath = "subtraction.html";
        else if (url.pathname === "/multiply") filePath = "multiplication.html";
        else if (url.pathname === "/divide") filePath = "division.html";
        else return send404(res);

        // return serveHTML(res, path.join(publicDir, filePath));
        return serveHTML(res, filePath);
    }

    if (req.method === "POST") {
        let body = "";
        req.on("data", chunk => body += chunk.toString());
        req.on("end", () => {
            try {
                const formData = new URLSearchParams(body);
                // console.log("body: ", body)
                // console.log("formData: ", formData)
                
                // body:  num1=1&num2=2
                // formData:  URLSearchParams { 'num1' => '1', 'num2' => '2' }

                const num1 = parseFloat(formData.get("num1"));
                const num2 = parseFloat(formData.get("num2"));

                let result;
                switch (url.pathname) {
                    case "/add":
                        result = num1 + num2;
                        break;
                    case "/subtract":
                        result = num1 - num2;
                        break;
                    case "/multiply":
                        result = num1 * num2;
                        break;
                    case "/divide":
                        if (num2 === 0) {
                            throw new Error("Divide by zero error");
                        }
                        result = num1 / num2;
                        break;
                    default:
                        return send404(res);
                }

                res.writeHead(200, { "Content-Type": "text/html" });
                res.end(`<h1>Result: ${result}</h1><a href="/">Go Back</a>`);
            } catch (error) {
                console.error("Error caught:", error);
                sendError(res, 500, error.message);
            }
        });
    }
});

function serveHTML(res, filePath) {
    fs.readFile(filePath, "utf8", (err, data) => {
        if (err) return sendError(res, 500, "Internal Server Error");
        res.writeHead(200, { "Content-Type": "text/html" });
        res.end(data);
    });
}

function send404(res) {
    res.writeHead(404, { "Content-Type": "text/plain" });
    res.end("404 Not Found");
}

function sendError(res, code, message) {
    res.writeHead(code, { "Content-Type": "text/plain" });
    res.end(message);
}

server.listen(PORT, () => {
    console.log(`Server running at http://localhost:${PORT}`);
});
