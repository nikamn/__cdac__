import { useEffect } from "react";
import { useState } from "react";
import SupplierService from "../../services/supplier.service";
import { Link } from "react-router-dom";

const SuppliersList = () => {
  const [suppliers, setSuppliers] = useState([]);

  useEffect(() => {
    SupplierService.getAll()
      .then((results) => setSuppliers([...results.data]))
      .catch((err) => console.log(err));
  }, []);

  const removeSupplier = (id) => {
    SupplierService.remove(id)
      .then((result) =>
        suppliers.filter((supplier) => supplier._id !== result._id)
      )
      .catch((err) => console.log(err));
  };

  return (
    <div>
      <table className="table table-bordered table-hover table-striped-columns">
        <thead className="table-primary">
          <tr>
            <th>SupplierID</th>
            <th>Company</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Job Title</th>
            <th className="text-center">Actions</th>
          </tr>
        </thead>
        <tbody>
          {suppliers.map((supplier, index) => (
            <tr key={index}>
              <td>{supplier._id}</td>
              <td>{supplier.company}</td>
              <td>{supplier.first_name}</td>
              <td>{supplier.last_name}</td>
              <td>{supplier.job_title}</td>
              <td className="text-center">
                <Link
                  to={`/suppliers/edit/${supplier._id}`}
                  state={{ supplier: supplier, mode: "edit" }}
                >
                  <button type="button" className="btn btn-outline-info mx-1">
                    Edit
                  </button>
                </Link>
                <Link to={"/suppliers"}>
                  <button
                    type="button"
                    className="btn btn-outline-danger mx-1"
                    onClick={removeSupplier(supplier._id)}
                  >
                    Delete
                  </button>
                </Link>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default SuppliersList;
