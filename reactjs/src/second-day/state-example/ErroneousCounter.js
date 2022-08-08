import React, {useState} from "react";

class ErroneousCounter extends React.Component{
  constructor(props) {
    super(props);
    this.state={value:0};
  }

  componentDidMount() {
    this.setState({value: this.state.value + 1});
    this.setState({value: this.state.value + 1});
    this.setState({value: this.state.value + 1});
    this.setState({value: this.state.value + 1});
  }

  render() {
    return(
      <div>
        Counter: {this.state.value}
      </div>
    );
  }
}

export default ErroneousCounter;