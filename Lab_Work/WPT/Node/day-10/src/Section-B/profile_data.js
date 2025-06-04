const http = require("http");
const fs = require("fs")

var server = http.createServer((req, res) => {
    // console.log(req)
    // console.log(res)
    // res.write("Hello from node server!")
    res.writeHead(200, { 'Content-Type': 'text/plain' });

    if (req.url == "/") {
        res.write("\n Current url: "+req.url)
        res.end()
    }else if(req.url == "/data"){
        res.write("this is data")
        res.end()
    }
    else if(req.url== "/profile"){
        res.write("this is profile")
        res.end()
    }else{
        res.write("Invalid path!")
        res.end()
    }
})

// Contents of Response includes:
// {
//  "content-length": "123",
//   "content-type": "text/plain",
//   "connection": "keep-alive",
//   "host": "example.com",
//   "accept": "*" 
// }


server.listen(3000, () => {
    console.log("Server is started on port 3000!")
})