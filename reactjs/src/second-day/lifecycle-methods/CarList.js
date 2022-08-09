import React from "react";
import SimpleTable from "./SimpleTable";
import SimpleCheckBox from "./SimpleCheckbox";
import SimpleSelect from "./SimpleSelect";

import "./style.css";

class CarList extends React.Component {
  static HEADERS = ["Model", "Year", "Price"];

  constructor(props) {
    super(props);
    this.state = {
      cars: [
        { model: "A", year: 2012, price: 5 },
        { model: "B", year: 2014, price: 10 },
        { model: "C", year: 2018, price: 20 },
        { model: "D", year: 2021, price: 100 },
        { model: "E", year: 2000, price: 1000 }
      ],
      isNew: true,
      model: null
    };
  }

  componentDidMount() {
    console.log("CarList gets MOUNTED!");
  }

  componentDidUpdate(prevProps, prevState) {
    console.log("CarList gets UPDATED!");
  }

  onUsageChoiceChanged = (event) => {
    this.setState({ isNew: event.target.checked });
  };

  onModelChange = (event) => {
    console.log(`Model: ${event.target.value}`);
    this.setState({ model: event.target.value });
  };

  render() {
    console.log("CarList rendered");
    return (
      <>
        <div>
          <p>Filter</p>
          <SimpleCheckBox
            label="New"
            name="New"
            value="New"
            checked={this.state.isNew}
            onChange={this.onUsageChoiceChanged}
          />
          <br />
          <SimpleSelect onChange={this.onModelChange} />
        </div>
        <div>
          <br />
          <SimpleTable
            headers={CarList.HEADERS}
            items={this.state.cars}
            model={this.state.model}
          />
        </div>
      </>
    );
  }
}

export default CarList;
