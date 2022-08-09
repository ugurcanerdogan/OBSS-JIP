import ReactDOM from "react-dom";
import { React, StrictMode } from "react";
import FooBar from "./FooBar";
import ErroneousCounter from "./ErroneousCounter";
import Counter from "./Counter";

export default function() {
  const rootElement = document.getElementById("root");
  ReactDOM.render(
    <StrictMode>
      {/*<FooBar/>*/}
      {/*<ErroneousCounter/>*/}
      <Counter />
    </StrictMode>,
    rootElement
  );
}