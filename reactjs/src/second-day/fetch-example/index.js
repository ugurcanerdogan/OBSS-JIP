import ReactDOM from "react-dom";
import { StrictMode } from "react";
import PersonList from "./PersonList";

export default function() {
  const rootElement = document.getElementById("root");

  ReactDOM.render(
    <StrictMode>
      <PersonList />
    </StrictMode>,
    rootElement
  );
}
