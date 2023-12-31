const express = require("express");
const app = express();
const path = require("path");
const bodyParser = require("body-parser");
const routes = require("./routes/router");
const { default: mongoose } = require("mongoose");

// middlewares
app.use((req, res, next) => {
  res.setHeader("Access-Control-Allow-Origin", "*");
  res.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
  res.setHeader("Access-Control-Allow-Headers", "*");
  res.setHeader("Access-Control-Allow-Content", "application/json");
  next();
});
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

// routes
app.use("/", routes);

mongoose.set("strictQuery", false);
const mongoDB = "mongodb://127.0.0.1/test";
const start = async () => {
  await mongoose.connect(mongoDB);
};
start()
  .then(() => {
    console.log("Connection established successfully on " + mongoDB);
  })
  .catch((err) => {
    console.log("Error connecting to Mongo ...@ " + err);
  });

const port = process.env.PORT || 9090;
app.listen(port, function () {
  console.log(`server running on port ${port}`);
});

module.exports = app;
