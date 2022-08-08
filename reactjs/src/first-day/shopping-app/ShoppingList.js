import ShoppingItem from "./ShoppingItem";

const ShoppingList = (props) => {
  let itemType = props.itemType;
  let allItems = props.allItems;

  return (
    <>
      <h3>Name: {itemType}</h3>
      <ShoppingItem entities={allItems} size={allItems.length} />
    </>
  );
};
export default ShoppingList;