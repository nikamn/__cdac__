import { Button, Form } from "react-bootstrap";

const AddSupplier = () => {
  return (
    <Form>
      <Form.Group className="mb-3" controlId="_id">
        <Form.Label>SupplierID</Form.Label>
        <Form.Control type="number"></Form.Control>
        <Form.Text className="text-muted">
          SupplierID should be unique.
        </Form.Text>
      </Form.Group>

      <Form.Group className="mb-3" controlId="company">
        <Form.Label>Company</Form.Label>
        <Form.Control type="text"></Form.Control>
      </Form.Group>

      <Form.Group className="mb-3" controlId="first_name">
        <Form.Label>First Name</Form.Label>
        <Form.Control type="text"></Form.Control>
      </Form.Group>

      <Form.Group className="mb-3" controlId="last_name">
        <Form.Label>Last Name</Form.Label>
        <Form.Control type="text"></Form.Control>
      </Form.Group>

      <Form.Group className="mb-3" controlId="job_title">
        <Form.Label>Job Title</Form.Label>
        <Form.Control type="text"></Form.Control>
      </Form.Group>

      <Button variant="primary" type="submit">
        Submit
      </Button>
    </Form>
  );
};

export default AddSupplier;
