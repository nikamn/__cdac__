const express = require("express");
const router = express.Router();
const supplierSchema = require("../models/supplier");

// home page
router.get("/", async (req, res) => {
  res.send("Hello World!");
});

// about page
router.get("/about", async (req, res) => {
  res.send("About Us");
});

// get all suppliers
router.get("/suppliers", async (req, res) => {
  const suppliers = await supplierSchema.find();
  res.render("index", { suppliers: suppliers });
  //return res.json(suppliers);
});

// get /suppliers/add
router.get("/suppliers/add", async (req, res) => {
  res.render("add");
});

// post /suppliers
router.post("/suppliers", async (req, res) => {
  console.log(req.body);

  const newSupplier = new supplierSchema({ ...req.body });
  //const insertedSupplier = await newSupplier.save();

  await newSupplier.save();
  res.redirect("/suppliers");
  //return res.status(201).json(insertedSupplier);
});

// get /suppliers/edit/:id
router.get("/suppliers/edit/:id", async (req, res) => {
  let { id } = req.params;

  const supplier = await supplierSchema.findById(id);
  res.render("edit", { supplier: supplier });
});

// post /suppliers/edit/:id
router.post("/suppliers/edit/:id", async (req, res) => {
  console.log(req.body);

  await supplierSchema.findByIdAndUpdate(req.params.id, req.body);
  res.redirect("/suppliers");
});

// get /suppliers/delete/:id
router.get("/suppliers/delete/:id", async (req, res) => {
  await supplierSchema.findByIdAndDelete(req.params.id);
  res.redirect("/suppliers");
});

module.exports = router;
