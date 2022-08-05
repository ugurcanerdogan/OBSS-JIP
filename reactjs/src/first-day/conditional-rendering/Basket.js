const Basket = ({ items }) => {
  let message;

  if (Array.isArray(items) && items.length) {
    message = <h1>There is {items.length} items.</h1>;
  } else {
    //message = null;
    message = <h1>There is no items.</h1>;

  }
  return message;
};

export default Basket;