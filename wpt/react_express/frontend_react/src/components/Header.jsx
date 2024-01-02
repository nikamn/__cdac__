import viteLogo from "/vite.svg";
import reactLogo from "/react.svg";
import { Link } from "react-router-dom";
import { Container, Navbar } from "react-bootstrap";

const Header = () => {
  return (
    <header className="p-3 mb-3 border-bottom navbar navbar-expand navbar-expand-lg bg-light w-100">
      <a href="https://vitejs.dev" target="_blank" rel="noreferrer">
        <img src={viteLogo} className="logo" alt="Vite logo" />
      </a>
      <a href="https://react.dev" target="_blank" rel="noreferrer">
        <img src={reactLogo} className="logo react" alt="React logo" />
      </a>
      <a
        href="/suppliers"
        className="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none"
      >
        <svg className="bi me-2" width="40" height="32">
          <use xlinkHref="#bootstrap"></use>
        </svg>
        <span className="fs-4">Northwind</span>
      </a>

      <ul className="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
        <li>
          <Link to={"/suppliers"} className="nav-link px-2 link-primary">
            Suppliers
          </Link>
        </li>
        <li>
          <Link
            to={"/suppliers/add"}
            state={{ mode: "add" }}
            className="nav-link px-2 link-success"
          >
            Add New
          </Link>
        </li>
        <li>
          <a href="#" className="nav-link px-2 link-dark">
            Customers
          </a>
        </li>
        <li>
          <a href="#" className="nav-link px-2 link-dark">
            Products
          </a>
        </li>
      </ul>
    </header>

    // <Navbar bg="light" collapseOnSelect expand="sm">
    //   <Container>
    //     <Navbar.Brand href="/">Example Site</Navbar.Brand>
    //     <Navbar.Toggle aria-controls="navbar-toggle" />
    //     {/* <Navbar.Collapse id="navbar-toggle">
    //       <Nav className="me-auto">
    //         <Nav.Link href="/">Home</Nav.Link>
    //         <Nav.Link href="/link">Link</Nav.Link>
    //         <NavDropdown title="Drop-down" id="nav-dropdown">
    //           <NavDropdown.Item href="/action1">Action 1</NavDropdown.Item>
    //           <NavDropdown.Item href="/action2">Action 2</NavDropdown.Item>
    //           <NavDropdown.Item href="/action3">Action 3</NavDropdown.Item>
    //         </NavDropdown>
    //       </Nav>
    //     </Navbar.Collapse> */}
    //   </Container>
    // </Navbar>
  );
};

export default Header;
