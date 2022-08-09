import React from "react";

class Switch extends React.Component {
  constructor(props) {
    super(props);
    this.state = { activeArray: [0, 0], details: null };
  }

  clickHandler = (id, details) => {
    var arr = [0, 0];
    arr[id] = 1;

    this.setState({ activeArray: arr, details: details });
  };

  render() {
    return (
      <div>
        <Button
          id={0}
          active={this.state.activeArray[0]}
          clickHandler={this.clickHandler}
          name="Jack"
        />

        <Button
          id={1}
          active={this.state.activeArray[1]}
          clickHandler={this.clickHandler}
          name="Bob"
        />
      </div>
    );
  }
}


class Button extends React.Component {
  render() {
    return (
      <button
        style={{ color: this.props.active ? "red" : "blue" }}
        onClick={() => {
          this.props.clickHandler(this.props.id, this.props.name);
        }}
      >
        {this.props.name}
      </button>
    );
  }
}

export default Switch;