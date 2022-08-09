import ReactDOM from "react-dom";
import { React, StrictMode } from "react";
import Counter from "./Counter";
import Switch from "./Switch";

export default function() {
  const rootElement = document.getElementById("root");
  ReactDOM.render(
    <StrictMode>
      {/*<Counter title="My title" name="My name" />*/}
      <Switch />
    </StrictMode>,
    rootElement
  );
}