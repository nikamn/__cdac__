import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";

import { Routes, Route } from "react-router-dom";

import Header from "./components/Header";
import Footer from "./components/Footer";

import HomePage from "./pages/HomePage";
import AboutPage from "./pages/AboutPage";
import SignupForm from "./pages/SignupForm";
import LoginForm from "./pages/LoginForm";

function App() {
  return (
    <>
      <div className="d-flex flex-column min-vh-100">
        <Header />

        <Routes>
          <Route path="/home" element={<HomePage />}/>
          <Route path="/about" element={<AboutPage />}/>
          <Route path="/signup" element={<SignupForm />} />
          <Route path="/login" element={<LoginForm />} />
          <Route path="/user/:id/"></Route>
        </Routes>

        <Footer />
      </div>
    </>
  );
}

export default App;
