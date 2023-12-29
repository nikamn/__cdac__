const express = require("express");
const router = express.Router();
const conn = require("../db/dbconfig");

// GET /
router.get("/", (req, res) => {
  res.status(200).send("Hello World!");
});

// GET /about
router.get("/about", (req, res) => {
  res.status(200).send("about");
});

// GET /customers
router.get("/api/customers", (req, res) => {
  conn.query("SELECT * FROM customers", (err, results, fields) => {
    if (err) {
      console.log(`error occured during GET /customers query: `, err);
      res.status(500).send("No Data Found @...!");
    } else {
      res.status(200).send(results);
    }
  });
});

// GET /api/customers/:id
router.get("/api/customers/:id", (req, res) => {
  conn.query(
    "SELECT * FROM customers WHERE CustomerID=?",
    [req.params.id],
    (err, result) => {
      if (err) {
        console.log(`error occured during GET /customers/:id query: `, err);
        res.status(500).send("No Data Found @...!");
      } else {
        console.log(result);
        res.status(200).send(result);
      }
    }
  );
});

// POST /api/customers
router.post("/api/customers", (req, res) => {
  let { CustomerName, ContactName, Address, City, PostalCode, Country } =
    req.body;

  console.log(req.body);

  conn.query(
    "INSERT INTO customers VALUES (default, ?,?,?,?,?,?)",
    [CustomerName, ContactName, Address, City, PostalCode, Country],
    (err, result, fields) => {
      if (err) {
        console.log("err occurred in POST /customers : ", err);
        res.status(500).send("No Data Found @...!");
      } else {
        console.log(result);
        res.status(200).json("Customer added successfully @...!");
      }
    }
  );
});

// PUT /api/customers/edit/:id
router.put("/api/customers/edit/:id", (req, res) => {
  let {
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
    [CustomerName, ContactName, Address, City, PostalCode, Country, req.params.id],
    (err, result) => {
      if (err) {
        console.log("err occurred in PUT /customers/edit/:id : ", err);
        res.status(500).send("No Data Found @...!");
      } else {
        console.log(result);
        res.status(200).send("Customer updated successfully @...!");
      }
    }
  );
});

// DELETE /api/customers/delete/:id
router.delete("/api/customers/delete/:id", (req, res) => {
  let { id } = req.params;
  console.log(id);

  conn.query(
    "DELETE FROM customers WHERE CustomerID = ?",
    id,
    (err, result, fields) => {
      if (err) {
        console.log("err occurred in GET /customers/delete/:id : ", err);
        res.status(500).send("No Data Found @...!");
      } else {
        res.status(200).send("Customer deleted successfully @...!");
      }
    }
  );
});

module.exports = router;
