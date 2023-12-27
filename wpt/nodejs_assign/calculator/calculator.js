const fs = require("fs");
const http = require("http");
const url = require("url");
const mathOp = require("./functions");
let ans = 0;
let create_server = http.createServer(function (request, response) {
  response.writeHeader(200, { "content-type": "texthtml" });
  let q = url.parse(request.url, true);
  switch (q.pathname) {
    case "/home":
      let readStream = fs.createReadStream("Calculator.html");
      readStream.pipe(response);
      break;
    case "/math_op":
      let n1 = parseFloat(q.query.num1);
      let n2 = parseFloat(q.query.num2);
      console.log(`Inside math_op, you pressed ${q.query.btn}`);
      switch (q.query.btn) {
        case "add":
          ans = mathOp.sum(n1, n2);
          response.end(`Sum : ${ans}`);
          break;
        case "diff":
          ans = mathOp.diff(n1, n2);
          response.end(`Difference : ${ans}`);
          break;
        case "pro":
          ans = mathOp.product(n1, n2);
          response.end(`Product : ${ans}`);
          break;
        case "div":
          ans = mathOp.divide(n1, n2);
          response.end(`Division : ${ans}`);
          break;
        case "pow":
          ans = mathOp.power(n1, n2);
          response.end(`${n1}<sub>${n2} : ${ans}`);
          break;
        case "fact":
          ans = mathOp.factorial(n1);
          response.end(`${n1}! : ${ans}`);
          break;
        case "perm":
          ans = mathOp.permutation(n1, n2);
          response.end(`${n1}P${n2} : ${ans}`);
          break;
        case "comb":
          ans = mathOp.combinaton(n1, n2);
          response.end(`${n1}C${n2} : ${ans}`);
          break;
        default:
          console.log("Inside default");
          response.end("Inside Something wrong! Try Again");
          break;
      }
      break;

    default:
      response.write("<h1>Last Something wrong! Try Again</h1>");
      response.end("");
      break;
  }
});
create_server.listen(9090, function () {
  console.log("Calcultor Action server started");
});
