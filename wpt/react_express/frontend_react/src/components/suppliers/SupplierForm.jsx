import { useEffect } from "react";
import { useState } from "react";
import { Button, Form } from "react-bootstrap";
import { useLocation } from "react-router-dom";

const SupplierForm = () => {
  let props = useLocation();
  console.log("useLocation props: ", props);

  const [formData, setFormData] = useState({
    _id: "",
    company: "",
    first_name: "",
    last_name: "",
    job_title: "",
  });

  useEffect(() => {
    //console.log("props", props);
    if (props.state !== null) {
      if (props.state.mode === "edit") {
        setFormData({
          ...formData,
          ...props.state.supplier,
        });

        //console.log("formData: ", formData);
        // } else {
        //   setFormData({
        //     _id: "",
        //     company: "",
        //     first_name: "",
        //     last_name: "",
        //     job_title: "",
        //   });

        //console.log("formData: ", formData);
      }
    } else {
      //console.log("formData: ", formData);
    }
  }, []);

  // useEffect(() => {
  //   setFormData({
  //     ...formData,
  //     ...props.state.supplier,
  //   });
  // }, [formData]);

  const handleChange = (event) => {
    const { name, value } = event.target;

    setFormData({
      ...formData,
      [name]: value,
    });

    //props.state.supplier = formData;
  };

  return (
    <Form>
      <Form.Group className="mb-3" controlId="_id">
        <Form.Label>SupplierID</Form.Label>
        <Form.Control
          type="number"
          name="_id"
          value={formData._id}
          onChange={handleChange}
          readOnly={props.state.mode === "edit" ? true : false}
        />
        <Form.Text className="text-muted">
          SupplierID should be unique.
        </Form.Text>
      </Form.Group>

      <Form.Group className="mb-3" controlId="company">
        <Form.Label>Company</Form.Label>
        <Form.Control
          type="text"
          name="company"
          value={formData.company}
          onChange={handleChange}
        />
      </Form.Group>

      <Form.Group className="mb-3" controlId="first_name">
        <Form.Label>First Name</Form.Label>
        <Form.Control
          type="text"
          name="first_name"
          value={formData.first_name}
          onChange={handleChange}
        />
      </Form.Group>

      <Form.Group className="mb-3" controlId="last_name">
        <Form.Label>Last Name</Form.Label>
        <Form.Control
          type="text"
          name="last_name"
          value={formData.last_name}
          onChange={handleChange}
        />
      </Form.Group>

      <Form.Group className="mb-3" controlId="job_title">
        <Form.Label>Job Title</Form.Label>
        <Form.Control
          type="text"
          name="job_title"
          value={formData.job_title}
          onChange={handleChange}
        />
      </Form.Group>

      <Button variant="primary" type="button">
        {props.state === null ? "Add Supplier" : "Edit Supplier"}
      </Button>
    </Form>
  );
};

export default SupplierForm;
