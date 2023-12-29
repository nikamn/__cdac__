const { default: mongoose } = require("mongoose");

const SupplierSchema = new mongoose.Schema(
  {
    _id: Number,
    company: String,
    last_name: String,
    first_name: String,
    job_title: String,
  },
  { collection: "suppliers" }
);

module.exports = mongoose.model("suppliers", SupplierSchema);
