import ShoppingItem from "./ShoppingItem";
import React from "react";

class ShoppingList extends React.Component {
  render() {
    let { itemType, allItems } = this.props;


    return (
      <>
        <h3>Name: {itemType}</h3>
        <ShoppingItem entities={allItems} size={allItems.length} />
      </>
    );
  }
}

export default ShoppingList;