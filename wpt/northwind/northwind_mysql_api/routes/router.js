const express = require("express");
const router = express.Router();
const conn = require("../db/dbconfig");

router.get("/", (req, res) => {
  return res.json("Hello World @...!");
});

router.get("/about", (res, req) => {
  return res.json("About us @...!");
});

// get
router.get("/customers", (req, res) => {
  conn.query("SELECT * FROM customers", (err, results, fields) => {
    if (err) {
      console.log(`error occured during GET /customers query: `, err);
      return res.status(500).json("No Data Found @...!");
    } else {
      if (results.length === 0) {
        return res.status(200).json("No data is present in customers @...!");
      }
      return res.status(200).json(results);
    }
  });
});

// post
router.post("/customers", (req, res) => {
  let { CustomerName, ContactName, Address, City, PostalCode, Country } =
    req.body;

  // console.log(req.body);

  conn.query(
    "INSERT INTO customers VALUES (default, ?,?,?,?,?,?)",
    [CustomerName, ContactName, Address, City, PostalCode, Country],
    (err, results, fields) => {
      if (err) {
        console.log("err occurred in POST /customers : ", err);
        return res.status(500).json("No Data Found @...!");
      } else {
        return res.status(201).json("Data added successfully @...!");
      }
    }
  );
});

// get id
router.get("/customers/:id", (req, res) => {
  conn.query(
    "SELECT * FROM customers WHERE CustomerId = ?",
    [req.params.id],
    (err, results, fields) => {
      if (err) {
        console.log("err occureed in GET /customers/:id -> ", err);
        return res.status(500).json("No Data Found @...!");
      } else {
        if (results.length === 0) {
          return res.status(200).json(`No customer with id: ${req.params.id} is present in customers @...!`);
        }
        res.status(200).json(results[0]);
      }
    }
  );
});

// put /customers/edit/:id
router.put("/customers/edit/:id", (req, res) => {
  let { CustomerName, ContactName, Address, City, PostalCode, Country } =
    req.body;

  conn.query(
    "UPDATE customers SET CustomerName=?,ContactName=?,Address=?,City=?,PostalCode=?,Country=? WHERE CustomerId=?",
    [
      CustomerName,
      ContactName,
      Address,
      City,
      PostalCode,
      Country,
      req.params.id,
    ],
    (err, results, fields) => {
      if (err) {
        console.log("err occurred in PUT /customers/edit/:id : ", err);
        return res.status(500).json("No Data Found @...!");
      } else {
        if (results.affectedRows === 0) {
          return res.status(200).json(`No customer with id: ${req.params.id} is present in customers @...!`);
        }
        return res.status(200).json("Data Updated Successfully @...!");
      }
    }
  );
});

// delete /customers/delete/:id
router.delete("/customers/delete/:id", (req, res) => {
  conn.query(
    "DELETE FROM customers WHERE CustomerId = ?",
    req.params.id,
    (err, results, fields) => {
      if (err) {
        console.log("err occurred in DELETE /customers/delete/:id : ", err);
        return res.status(500).json("No Data Found @...!");
      } else {
        if (results.affectedRows === 0) {
          return res.status(200).json(`No customer with id: ${req.params.id} is present in customers @...!`);
        }
        return res.status(200).json("Data Deleted Successfully @...!");
      }
    }
  );
});

module.exports = router;
