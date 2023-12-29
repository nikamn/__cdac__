const express = require("express");
const app = express();
const bodyParser = require("body-parser");
const routes = require("./routes/router");

// middlewares
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

// routes
app.use("/", routes);

// listen
const port = process.env.PORT || 9090;
app.listen(port, function () {
  console.log(`server running on port ${port}`);
});

module.exports = app;
