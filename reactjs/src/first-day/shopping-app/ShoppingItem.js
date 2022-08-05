const ShoppingItem = (props) => {
  let entities = props.entities;
  let length = entities.length;
  return (
    <>
      <ol>
        {entities.map(entity =>
          <li>{entity}</li>
        )}
      </ol>
      <h2>Total item number: {length}</h2>
    </>
  );
};

export default ShoppingItem;