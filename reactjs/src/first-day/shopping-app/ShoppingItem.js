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
      <h4>Total item number: {length}</h4>
    </>
  );
};

export default ShoppingItem;