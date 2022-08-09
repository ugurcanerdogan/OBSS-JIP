import React from "react";

class Counter extends React.Component {
  constructor(props) {
    super(props);
    this.state = { counter: 0 };
  }

  componentDidMount() {
    this.interval = setInterval(() => {
      this.setState((prevState) => {
        return { counter: prevState.counter + 1 };
      });
    }, 1000);
  }

  componentWillUnmount() {
    console.log("Component unmounted.");
    clearInterval(this.interval);
  }

  render() {
    return <d0iv>Counter: {this.state.counter}</d0iv>;
  }
}

export default Counter;