const express = require("express");
const app = express();
const path = require("path");
const bodyParser = require("body-parser");
const routes = require("./routes/router");

app.get('/', (req, res) => {
  res.send('Hello World!')
})

// configuartion
app.set("views", path.join(__dirname, "views"));
app.set("view engine", "ejs");

app.use(express.static(path.join(__dirname, "node_modules/bootstrap/dist/")));

// middlewares
app.use(bodyParser.urlencoded({ extended: false }));
app.use("/", routes);

const port = 5173;
app.listen(port, function() {
  console.log(`server running on port ${port}`);
});

module.exports = app;
