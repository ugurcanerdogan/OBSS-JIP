import ShoppingItem from "./ShoppingItem";

const ShoppingList = (props) => {
  let itemType = props.itemType;
  let allItems = props.allItems;

  return (
    <>
      <h1>Name: {itemType}</h1>
      <ShoppingItem entities={allItems} size={allItems.length} />
    </>
  );
};
export default ShoppingList;