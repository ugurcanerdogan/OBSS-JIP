import React from "react";

class Counter extends React.Component {
  constructor(props) {
    super(props);
    this.state = { count: 0 };
    this.clickHandler = this.clickHandler.bind(this);
  }

  clickHandler() {
    this.setState((prevState) => {
      return { count: prevState.count + 1 };
    });
  }

  clickHandlerArrow = () => {
    console.log("Click handler executed.");
    this.setState(
      (prevState) => {
        return { count: prevState.count + 1 };
      },
      () => {
        console.log("State updated.");
      }
    );
  };

  render() {
    console.log("Component rendered.");
    return <button onClick={this.clickHandlerArrow}>{this.state.count}</button>;
  }

}

export default Counter;