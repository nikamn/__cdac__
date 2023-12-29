const express = require("express");
const app = express();
const path = require("path");
const bodyParser = require("body-parser");
const routes = require("./routes/router");
const { default: mongoose } = require("mongoose");

// configuartion
app.set("views", path.join(__dirname, "views"));
app.set("view engine", "ejs");

app.use(express.static(path.join(__dirname, "node_modules/bootstrap/dist/")));

// middlewares
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

// routes
app.use("/", routes);

mongoose.set("strictQuery", false);
const mongoDB = "mongodb://127.0.0.1/northwind";
const start = async () => {
  await mongoose.connect(mongoDB);
};
start();

const port = process.env.PORT || 9090;
app.listen(port, function () {
  console.log(`server running on port ${port}`);
});

module.exports = app;
