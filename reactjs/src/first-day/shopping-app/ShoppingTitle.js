const ShoppingTitle = (props) => {
  let { message, size } = props;
  return (
    <>
      <h1>{message}</h1>
      <h2>Total item number: {size}</h2>
    </>
  );
};

export default ShoppingTitle;