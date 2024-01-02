import { Container } from "react-bootstrap";

const Footer = () => {
  return (
    // <footer className="bg-secondary navbar position-absolute bottom-0 w-100 mt-auto">
    //     <span className="m-auto text-white">© 2024 Copyright : nikamn.in</span>
    // </footer>
    <footer className="bg-secondary mt-auto">
      <Container>
        <p className="text-white text-center pt-3">© 2024 Copyright : nikamn.in</p>
      </Container>
    </footer>
  );
};

export default Footer;
