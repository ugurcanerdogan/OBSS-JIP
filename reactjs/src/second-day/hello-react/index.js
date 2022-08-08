import ReactDOM from "react-dom";
import { React, StrictMode } from "react";
import HelloClass from "./HelloClass";

export default function() {
  const rootElement = document.getElementById("root");
  ReactDOM.render(
    <StrictMode>
      <HelloClass title="My title" name="My name" />
    </StrictMode>,
    rootElement
  );
}