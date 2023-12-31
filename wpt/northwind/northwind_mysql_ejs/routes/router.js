const express = require("express");
const router = express.Router();
const conn = require("../db/dbconfig");

// GET /
router.get("/", (req, res) => {
  res.send("Hello World!");
});

// GET /customers
router.get("/customers", (req, res) => {
  conn.query("SELECT * FROM customers", (err, results, fields) => {
    if (err) {
      console.log(`error occured during GET /customers query: `, err);
      res.status(500).send("<h3>no data found</h3>");
    } else {
      //console.log(results);
      res.render("index", { customers: results });
    }
  });
});

// GET /customers/add
router.get("/customers/add", (req, res) => {
  res.render("add");
});

// POST /customers
router.post("/customers", (req, res) => {
  let { CustomerName, ContactName, Address, City, PostalCode, Country } =
    req.body;

  console.log(req.body);

  conn.query(
    "INSERT INTO customers VALUES (default, ?,?,?,?,?,?)",
    [CustomerName, ContactName, Address, City, PostalCode, Country],
    (err, result, fields) => {
      if (err) {
        console.log("err occurred in POST /customers : ", err);
        res.status(500).send("<h3>no data found</h3>");
      } else {
        res.redirect("/customers");
      }
    }
  );
});

// GET /customers/edit/:id
router.get("/customers/edit/:id", (req, res) => {
  let { id } = req.params;
  //console.log(id);

  conn.query(
    "SELECT * FROM customers WHERE CustomerId=?",
    id,
    (err, result, fields) => {
      if (err) {
        console.log("err occurred in GET /customers/edit/:id : ", err);
        res.status(500).send("<h3>no data found</h3>");
      } else {
        console.log(result);
        res.render("edit", { customer: result[0] });
      }
    }
  );
});

// POST /customers/edit/:id
router.post("/customers/edit/:id", (req, res) => {
  let {
    CustomerID,
    CustomerName,
    ContactName,
    Address,
    City,
    PostalCode,
    Country,
  } = req.body;

  console.log(req.body);

  conn.query(
    "UPDATE customers SET CustomerName=?, ContactName=?, Address=?, City=?, PostalCode=?, Country=? WHERE CustomerID=?",
    [CustomerName, ContactName, Address, City, PostalCode, Country, CustomerID],
    (err, result, fields) => {
      if (err) {
        console.log("err occurred in POST /customers/edit/:id : ", err);
        res.status(500).send("<h3>no data found</h3>");
      } else {
        console.log(result);
        res.redirect("/customers");
      }
    }
  );
});

// GET /customers/delete/:id
router.get("/customers/delete/:id", (req, res) => {
  let { id } = req.params;
  console.log(id);

  conn.query(
    "DELETE FROM customers WHERE CustomerId = ?",
    id,
    (err, result, fields) => {
      if (err) {
        console.log("err occurred in GET /customers/delete/:id : ", err);
        res.status(500).send("<h3>no data found</h3>");
      } else {
        res.redirect("/customers");
      }
    }
  );
});

module.exports = router;
