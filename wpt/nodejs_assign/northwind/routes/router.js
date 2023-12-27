const express = require("express");
const router = express.Router();
const conn = require("../db/dbconfig");

router.get("/customers", (req, res) => {
  conn.query("SELECT * FROM customers", (err, results, fields) => {
    if (err) {
      console.log(`error occured during get /customers query: `, err);
    } else {
      console.log(results);
      res.render("index", { customers: results });
    }
  });
});

router.get("/customers/add", (req, res) => {
      res.render("add");
});

router.get("/customers/edit/:id", (req, res) => {
  res.render("edit");
});

module.exports = router;
