const Footer = (props) => {
    return(
        <div className="col-md-4 text-center">
            <h6 className="text-light py-2">&copy; copyright reserved, {props.foot}</h6>
        </div>
    )
}

export default Footer;