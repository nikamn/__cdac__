const express = require("express");
const router = express.Router();
const conn = require("../db/dbconfig");

router.get("/", (req, res) => {
  res.send("Hello World!");
});

router.get("/customers", (req, res) => {
  conn.query("SELECT * FROM customers", (err, results, fields) => {
    if (err) {
      console.log(`error occured during GET /customers query: `, err);
    } else {
      //console.log(results);
      res.render("index", { customers: results });
    }
  });
});

router.get("/customers/add", (req, res) => {
  res.render("add");
});

router.post("/customers", (req, res) => {
  let { CustomerName, ContactName, Address, City, PostalCode, Country } =
    req.body;

  console.log(req.body.CustomerName);

  conn.query(
    "INSERT INTO customers VALUES (default, ?,?,?,?,?,?)",
    [CustomerName, ContactName, Address, City, PostalCode, Country],
    (err, result, fields) => {
      if (err) {
        console.log("err occurred in POST /customers/add : ", err);
        res.status(500).send("<h3>no data found</h3>");
      } else {
        res.redirect("/customers");
      }
    }
  );
});

router.get("/customers/edit/:id", (req, res) => {
  res.render("edit");
});

module.exports = router;
