const express = require("express");
const router = express.Router();
const supplierSchema = require("../models/supplier");

// home page
router.get("/", async (req, res) => {
  return res.status(200).json("Hello World!");
});

// about page
router.get("/about", async (req, res) => {
  return res.status(200).json("About Us");
});

//////////////////////////
// next task ---> try catch to catch mongo server errors and pass to postman/swagger

// get /suppliers
router.get("/suppliers", async (req, res) => {
  const suppliers = await supplierSchema.find();
  if (suppliers === undefined) {
    return res.json("No suppliers found in collection @...!");
  }
  return res.status(200).json(suppliers);
});

// get /suppliers/:id
router.get("/suppliers/:id", async (req, res) => {
  const supplier = await supplierSchema.findById(req.params.id);
  if (supplier === null) {
    return res.status(200).json(`No supplier found with _id: ${req.params.id}`);
  }
  return res.status(200).json(supplier);
});

// need server error handling using try/catch
// post /suppliers
router.post("/suppliers", async (req, res) => {
  const newSupplier = new supplierSchema({ ...req.body });
  const insertedSupplier = await newSupplier.save();
  return res.status(201).json(insertedSupplier);
});

// put /suppliers/edit/:id
router.put("/suppliers/edit/:id", async (req, res) => {
  const updatedSupplier = await supplierSchema.findByIdAndUpdate(req.params.id, req.body);
  console.log(updatedSupplier);
  return res.status(200).json(updatedSupplier);
});

// delete /suppliers/delete/:id
router.delete("/suppliers/delete/:id", async (req, res) => {
  const info = await supplierSchema.findByIdAndDelete(req.params.id);
  console.log(info);
  return res.status(200).json(info);
});

module.exports = router;
