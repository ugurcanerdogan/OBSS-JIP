import React from "react";

class ShoppingTitle extends React.Component {
  render() {
    let { message, size } = this.props;

    return (
      <>
        <h1>{message}</h1>
        <h2>Total item number: {size}</h2>
      </>
    );
  }
}

export default ShoppingTitle;