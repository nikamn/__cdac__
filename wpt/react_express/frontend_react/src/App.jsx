import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";

import { Route, Routes } from "react-router-dom";

import Header from "./components/Header";
import Footer from "./components/Footer";

import SupplierDetails from "./components/suppliers/SupplierDetails";
import SupplierForm from "./components/suppliers/SupplierForm.jsx";
import SuppliersList from "./components/suppliers/SuppliersList";

function App() {
  return (
    <>
      <div className="d-flex flex-column min-vh-100">
        {/* <ResponsiveNavbar /> */}
        <Header />
        <div className="container mt-3">
          <Routes>
            <Route path="/" element={<SuppliersList />} />
            <Route path="/suppliers/" element={<SuppliersList />}></Route>
            <Route path="/suppliers/add" element={<SupplierForm />} />
            <Route path="/suppliers/:id" element={<SupplierDetails />} />
            <Route path="/suppliers/edit/:id" element={<SupplierForm />} />
          </Routes>
        </div>
        <Footer />
      </div>
    </>
  );
}

export default App;
