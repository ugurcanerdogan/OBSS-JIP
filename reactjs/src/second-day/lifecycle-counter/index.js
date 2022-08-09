import ReactDOM from "react-dom";
import { StrictMode } from "react";
import Counter from "./Counter";

export default function() {
  const rootElement = document.getElementById("root");
  ReactDOM.render(
    <StrictMode>
      <Counter />
    </StrictMode>,
    rootElement
  );
}
