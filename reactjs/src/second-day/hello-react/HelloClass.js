import React from "react";

class HelloClass extends React.Component {
  render() {
    let { title, name } = this.props;
    return (
      <>
        {title}
        <h1>Hello React - Class Component {name}</h1>
      </>
    );
  }
}

export default HelloClass;