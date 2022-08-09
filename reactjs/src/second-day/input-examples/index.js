import ReactDOM from "react-dom";
import { StrictMode } from "react";
import CarFilter from "./CarFilter";

export default function() {
  const rootElement = document.getElementById("root");

  ReactDOM.render(
    <StrictMode>
      <CarFilter />
    </StrictMode>,
    rootElement
  );
}
