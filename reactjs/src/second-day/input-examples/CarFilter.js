import React from "react";

class CarFilter extends React.Component {
  constructor(props) {
    super(props);
    this.state = {};
  }

  handleChange = (event) => {
    this.setState({
      [event.target.name]: event.target.checked || event.target.value
    });
  };

  render() {
    console.log(this.state);
    return (
      <>
        <label htmlFor="isNew">New: </label>
        <input
          name="isNew"
          type="checkbox"
          value={this.state.isNew}
          onChange={this.handleChange}
        />
        <br />
        <label htmlFor="model">Model: </label>
        <input
          name="model"
          type="text"
          value={this.state.model}
          onChange={this.handleChange}
        />
      </>
    );
  }
}

export default CarFilter;
