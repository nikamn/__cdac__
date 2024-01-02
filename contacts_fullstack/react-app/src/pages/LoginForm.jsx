import { useState } from "react";
import { useNavigate } from "react-router-dom";
// import contactService from "../service/ContactService";

export default function LoginForm() {
  const [formData, setFormData] = useState({ username: "", password: "" });
  const navigate = useNavigate();

  const handleChange = (event) => {
    let { name, value } = event.target;
    setFormData({ ...formData, [name]: value });
  };

  const validateUser = () => {
    if (formData.username == "user" && formData.password == "1234") {
      console.log("User logged in successfully");
      navigate("/");
    }
  };

  return (
    <div className="container-fluid m-auto w-50">
      <form className="border-2">
        <div className="form-group mb-3">
          <label htmlFor="username">Username</label>
          <input
            type="text"
            className="form-control"
            id="username"
            name="username"
            onChange={handleChange}
            value={formData.user}
          />
        </div>
        <div className="form-group mb-3">
          <label htmlFor="password">Password</label>
          <input
            type="password"
            name="password"
            className="form-control"
            id="password"
            onChange={handleChange}
            value={formData.pass}
          />
        </div>
        <div className="form-group mb-3">
          <button
            type="button"
            className="btn btn-outline-primary text-center"
            id="btn"
            onClick={validateUser}
          >
            Login
          </button>
        </div>
      </form>
    </div>
  );
}
