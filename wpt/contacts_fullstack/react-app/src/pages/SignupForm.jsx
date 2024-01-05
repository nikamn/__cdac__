import { useState } from "react";

export default function SignupForm() {
  const [formData, setFormData] = useState({ username: "", password: "" });

  const handleChange = (event) => {
    let { name, value } = event.target;
    setFormData({ ...formData, [name]: value });
  };

  const addUser = () => {

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
          <button type="button" className="btn btn-outline-primary text-center"  id="btn" onClick={addUser}>
            Signup
          </button>
        </div>
      </form>
    </div>
  );
}
