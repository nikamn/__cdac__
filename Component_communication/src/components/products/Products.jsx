import { useEffect, useState } from "react";
import Product from "./Product";
import ProductForm from "./ProductForm";

const Products = (props) => {
  const [productForm, setProductForm] = useState(false);
  const [products, setProducts] = useState(props.products);
  
  const addNewProduct = () => {
    setProductForm(true);
  };
  const getNewProduct = (data) => {
    const product = {
      pid : Math.ceil(Math.random() * 10000),
      ...data

    };
    props.productDetails(product);
  };

  useEffect(() => {
    console.log("products:", products)
  }, [products]);

  return (
    <div>
      <div className="row">
        <button
          type="button"
          className="btn btn-secondary my-2 ml-3"
          onClick={addNewProduct}
        >
          Add New Product
        </button>
      </div>
      <table className="table table-hover">
        <thead className="thead-light">
          <tr>
            <th scope="col">Product Id</th>
            <th scope="col">Product Name</th>
            <th scope="col">Product Description</th>
            <th scope="col">Actions</th>
          </tr>
        </thead>
        <tbody>
          {products.map((elem) => (
            <Product
              key={elem.pid}
              id={elem.pid}
              name={elem.pname}
              desc={elem.pdesc}
            ></Product>
          ))}
        </tbody>
      </table>
      {productForm ? <ProductForm newProductDetails = {getNewProduct}></ProductForm> : " "}
    </div>
  );
};

export default Products;
