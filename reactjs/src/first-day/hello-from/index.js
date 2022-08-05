import ReactDOM from "react-dom";
import React from "react";

// eslint-disable-next-line import/no-anonymous-default-export
export default function() {
  //const element = <h1> Hello From React! </h1>
  const element = React.createElement("h1", null, "Hello From React!");
  ReactDOM.render(element, document.getElementById("root"));
}