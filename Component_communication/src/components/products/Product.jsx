const Product = (props) => {
  return (
    <tr>
      <th scope="row">{props.id}</th>
      <td>{props.name}</td>
      <td>{props.desc}</td>
      <td>
        <button type="button" className="btn btn-primary">View</button>
        <button type="button" className="btn btn-success mx-2">Edit</button>
        <button type="button" className="btn btn-danger">Delete</button>
      </td>
    </tr>
  );
};

export default Product;
