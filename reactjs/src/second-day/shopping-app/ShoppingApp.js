import ShoppingTitle from "./ShoppingTitle";
import ShoppingList from "./ShoppingList";
import React from "react";

class ShoppingApp extends React.Component {
  render() {

    const shoppingList = {
      pageTitle: "Welcome to shopping!",
      items: [
        {header: "Food", items: ["Apple", "Bread", "Cheese"]},
        {header: "Clothes", items: ["Shirt", "Pants", "Hat"]},
        {header: "Supplies", items: ["Pen", "Paper", "Glue"]},
      ]
    }
    let totalSize = 0;

    shoppingList.items.forEach(element => {
      totalSize += element.items ? element.items.length : 0
    });

    return (
      <div>
        <ShoppingTitle message = {shoppingList.pageTitle} size = {totalSize}/>
        {shoppingList.items && shoppingList.items.map(item => <ShoppingList itemType = {item.header} allItems={item.items}/>)}
      </div>
    );
  }
}
export default ShoppingApp;