import { useEffect } from "react";
import { useState } from "react";
import { Button, Form } from "react-bootstrap";
import { useLocation } from "react-router-dom";

const SupplierForm = () => {
  let supplier = useLocation();
  // console.log("Supplier: ", supplier);

  const [supplierDetails, setSupplierDetails] = useState({
    _id: "",
    company: "",
    first_name: "",
    last_name: "",
    job_title: "",
  });

  useEffect(() => {
    console.log(supplier);
    if (supplier.state !== null && supplier.state.supplier !== null) {
      setSupplierDetails((supplierDetails) => ({
        ...supplierDetails,
        ...supplier.state.supplier,
      }));
    }
  }, []);

  const handleChange = (event) => {
    const { name, value } = event.target;
    setSupplierDetails({
      ...supplierDetails,
      [name]: value,
    });
  };

  return (
    <Form>
      <Form.Group className="mb-3" controlId="_id">
        <Form.Label>SupplierID</Form.Label>
        <Form.Control
          type="number"
          value={supplierDetails._id}
          onChange={handleChange}
        />
        <Form.Text className="text-muted">
          SupplierID should be unique.
        </Form.Text>
      </Form.Group>

      <Form.Group className="mb-3" controlId="company">
        <Form.Label>Company</Form.Label>
        <Form.Control
          type="text"
          value={supplierDetails.company}
          onChange={handleChange}
        />
      </Form.Group>

      <Form.Group className="mb-3" controlId="first_name">
        <Form.Label>First Name</Form.Label>
        <Form.Control
          type="text"
          value={supplierDetails.first_name}
          onChange={handleChange}
        />
      </Form.Group>

      <Form.Group className="mb-3" controlId="last_name">
        <Form.Label>Last Name</Form.Label>
        <Form.Control
          type="text"
          value={supplierDetails.last_name}
          onChange={handleChange}
        />
      </Form.Group>

      <Form.Group className="mb-3" controlId="job_title">
        <Form.Label>Job Title</Form.Label>
        <Form.Control
          type="text"
          value={supplierDetails.job_title}
          onChange={handleChange}
        />
      </Form.Group>

      <Button variant="primary" type="submit">
        Submit
      </Button>
    </Form>
  );
};

export default SupplierForm;
