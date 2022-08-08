import ShoppingTitle from "./ShoppingTitle";
import ShoppingList from "./ShoppingList";
import React from "react";

class ShoppingApp extends React.Component {
  render() {
    let { foods, clothes, supplies } = this.props;

    let totalSize = foods.length + clothes.length + supplies.length;

    return (
      <>
        <ShoppingTitle message="Welcome to shopping!" size={totalSize} />
        <ShoppingList allItems={foods} itemType="Foods" />
        <ShoppingList allItems={clothes} itemType="Clothes" />
        <ShoppingList allItems={supplies} itemType="Supplies" />
      </>
    );
  }
}

export default ShoppingApp;