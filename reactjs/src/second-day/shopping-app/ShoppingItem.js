import React from "react";

class ShoppingItem extends React.Component {
  render() {
    let { item } = this.props;
    return (
      <li>{item}</li>
    );
  }
}

export default ShoppingItem;