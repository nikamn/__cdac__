import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";
import Header from "./components/header/Header";
import Footer from "./components/footer/Footer";
import Products from "./components/products/Products";
// import { useEffect } from "react";

function App() {
  const productList = [
    {
      pid: 1,
      pname: "Amul Butter Pasteurised",
      pdesc:
        "Flavor Name: Salted; Material Features: Vegetarian; Item Form: Bar",
    },
    {
      pid: 2,
      pname: "Natural Wholegrain, Nutritious Breakfast Cereals",
      pdesc: "100% Natural Wholegrain Oats contain complex carbohydrates.",
    },
    {
      pid: 3,
      pname: "Cadbury Bournvita Chocolate Nutrition Drink, 2 kg",
      pdesc:
        "Strength Every Day+ Bournvita is a scientifically designed formula.",
    },
    {
      pid: 4,
      pname: "Vedaka Raw Peanuts, Pink, 1kg",
      pdesc: "Flavor Name: Whole Natural; Material Features: Vegetarian",
    },
    {
      pid: 5,
      pname: "Vim Dishwash Liquid Gel Lemon Refill Pouch, 2 Ltr",
      pdesc: "Prevents Scratches On Delicate Cookware",
    },
  ];

  const productData = (data) => {
    productList.push(data);
  };

  return (
    <div className="container-fluid">
      <div className="row justify-content-center bg-primary">
        <Header title="Component Communication"></Header>
      </div>
      <div className="row bg-light justify-content-center">
        <Products
          products={productList}
          productDetails={productData}
        ></Products>
      </div>
      <div className="row justify-content-center bg-primary fixed-bottom">
        <Footer foot="Himanshu Wakodikar"></Footer>
      </div>
    </div>
  );
}

export default App;
