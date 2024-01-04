import { useState } from "react";

const ProductForm = (props) => {
  const [name, setName] = useState("");
  const [desc, setDesc] = useState("");

  const getName = (event) => {
    setName(event.target.value);
  };

  const getDesc = (event) => {
    setDesc(event.target.value);
  };

  const saveProduct = (event) => {
    event.preventDefault();
    const proData = {
        pname:name,
        pdesc:desc
    }
    props.newProductDetails(proData);
  };

  return (
    <form className="mt-5">
      <div className="row">
        <div className="form-group col-md-3">
          <label htmlFor="pname">Product Name</label>
          <input
            type="text"
            name="pname"
            id="pname"
            className="form-control"
            required
            onChange={getName}
          />
        </div>
        <div className="form-group col-md-4">
          <label htmlFor="pdesc">Product Description</label>
          <input
            type="text"
            name="pdesc"
            id="pdesc"
            className="form-control"
            onChange={getDesc}
          />
        </div>
        <div className="form-group align-self-end col-md-3">
          <button
            type="button"
            className="btn btn-primary"
            onClick={saveProduct}
          >
            Save Product
          </button>
        </div>
      </div>
    </form>
  );
};

export default ProductForm;
