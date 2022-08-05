import ShoppingTitle from "./ShoppingTitle";
import ShoppingList from "./ShoppingList";

const ShoppingApp = (props) => {
  let foods = props.foods;
  let clothes = props.clothes;
  let supplies = props.supplies;

  let totalSize = foods.length + clothes.length + supplies.length;
  return (
    <>
      <ShoppingTitle message="Welcome tho shopping!" size={totalSize} />
      <ShoppingList allItems={foods} itemType="Foods" />
      <ShoppingList allItems={clothes} itemType="Clothes" />
      <ShoppingList allItems={supplies} itemType="Supplies" />

    </>
  );
};

export default ShoppingApp;