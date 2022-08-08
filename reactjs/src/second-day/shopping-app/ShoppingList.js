import ShoppingItem from "./ShoppingItem";
import React from "react";

class ShoppingList extends React.Component {
  render() {
    let { itemType, allItems } = this.props;

    return (
      <div>
        <h3>Name: {itemType}</h3>
        <ol>
          {allItems && allItems.map((item) => <ShoppingItem key = {item} item={item}/>)}
        </ol>
      </div>
    );
  }
}

export default ShoppingList;