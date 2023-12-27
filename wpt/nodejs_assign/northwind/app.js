const express = require("express");
const app = express();
const path = require("path");
const bodyParser = require("body-parser");
const routes = require("./routes/router");

// configuartion
app.set("views", path.join(__dirname, "views"));
app.set("view engine", "ejs");

// middlewares
app.use(bodyParser.urlencoded({extended: false}));
app.use("/", routes);

const PORT = process.env.PORT || 9090;
app.listen(PORT, () => {
    console.log(`server running on port ${PORT}`);
});

module.exports = app;