const http = require("http");
const url = require("url");
const fs = require("fs");
const m1 = require("./module1");

var server = http.createServer(function (req, resp) {
  resp.writeHeader(200, { "content-type": "text/html" });
  var q = url.parse(req.url, true);
  switch (q.pathname) {
    case "/form":
      var rs = fs.createReadStream("form1.html");
      rs.pipe(resp);
      break;

    case "/submit_form":
      var num = parseInt(q.query.num);
      console.log(num);
      if (num < 5) {
        resp.write("<h2>Factorial of number</h2>");
        resp.end(`<h2>Factorial : ${m1.factorial(num)}</h2>`);
      } else if (num >= 5 && num < 10) {
        console.log(Math.floor(Math.sqrt(num)));
        resp.write("<h2>Factorial of number</h2>");
        resp.end(
          `<h2>Prime : ${
            m1.myprime(num) ? "Prime Number" : "Not a Prime Number"
          }</h2>`
        );
      } else {
        var arr = m1.printable(num);

        resp.write(`${arr.toString()}`);
        resp.end("<h3>Functions Completed</h3>");
      }
      break;

    default:
      resp.write("<h2>For details visit /form</h2>");
      break;
  }
});

server.listen(9090, function () {
  console.log("listening on port 9090");
});
