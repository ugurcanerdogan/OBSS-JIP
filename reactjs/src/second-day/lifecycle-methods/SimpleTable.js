import React from "react";
import { uniqueId } from "lodash";

class SimpleTable extends React.Component {
  shouldComponentUpdate(nextProps, nextState) {
    return (
      this.props.items !== nextProps.items ||
      this.props.model !== nextProps.model
    );
  }

  componentDidMount() {
    console.log("SimpleTable gets MOUNTED!");
  }

  componentDidUpdate(prevProps, prevState) {
    console.log("SimpleTable gets UPDATED!");
  }

  render() {
    const { headers, items, model } = this.props;

    console.log(`Table is rendered`);

    return (
      <>
        <table>
          <thead>
          <tr>
            {headers &&
              headers.map((header) => (
                <td key={uniqueId("car-table-header-")}>{header}</td>
              ))}
          </tr>
          </thead>
          <tbody>
          {items &&
            items.map(
              (item) =>
                (!model || item.model === model) && (
                  <tr key={uniqueId("car-")}>
                    <td>{item.model}</td>
                    <td>{item.year}</td>
                    <td>{item.price}</td>
                  </tr>
                )
            )}
          </tbody>
        </table>
      </>
    );
  }
}

export default SimpleTable;
