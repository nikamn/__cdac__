import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";

import Header from "./components/Header";
import Footer from "./components/Footer";
import { Route, Routes } from "react-router-dom";
import SuppliersList from "./components/suppliers/SuppliersList";
import AddSupplier from "./components/suppliers/AddSupplier";
import SupplierDetails from "./components/suppliers/SupplierDetails";

function App() {
  return (
    <>
      <div className="d-flex flex-column min-vh-100">
        {/* <ResponsiveNavbar /> */}
        <Header />
        <div className="container mt-3">
          <Routes>
            <Route path="/" element={<SuppliersList />} />
            <Route path="/suppliers" element={<SuppliersList />} />
            <Route path="/suppliers/add" element={<AddSupplier />} />
            <Route path="/suppliers/:id" element={<SupplierDetails />} />
          </Routes>
        </div>
        <Footer />
      </div>
    </>
  );
}

export default App;
