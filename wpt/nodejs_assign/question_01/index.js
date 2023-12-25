import { createServer } from "http";
import fs from "fs";
import { sum, substract, multiply, divide, square } from "./calc";

fs.readFileSync("./public/index.html", (err, html) => {
  if (err) {
    throw err;
  } else {
    const server = createServer((req, res) => {
        res.writeHead(200, {"Content-Type" : "text/html"});
        res.write(html);
        res.end();
    });
    
    const PORT = 9090;
    server.listen(PORT, () => {
        console.log(`server listening on ${PORT}`);
    })
  }
});

// console.log("2 + 3 = ", sum(2, 3));
// console.log("10 - 5 = ", substract(10, 5));
// console.log("-8 * 3 = ", multiply(-8, 3));
// console.log("12 / 0 = ", divide(12, 0));
// console.log("pow(7, 2)  = ", square(7));
// console.log("1 + ... + 9 = ", sum(1, 2, ...[3, 4, 5, 6, 7, 8, 9]));
