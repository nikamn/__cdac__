const Header = (props) => {
    return(
        <div className="col-md-4 text-center">
            <h2 className="text-light py-2">{props.title}</h2>
        </div>
    )
}

export default Header;