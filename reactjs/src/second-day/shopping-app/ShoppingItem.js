import React from "react";

class ShoppingItem extends React.Component {
  render() {
    let { entities, size } = this.props;

    return (
      <>
        <ol>
          {entities.map(entity =>
            <li>{entity}</li>
          )}
        </ol>
        <h4>Total item number: {size}</h4>
      </>
    );
  }
}

export default ShoppingItem;