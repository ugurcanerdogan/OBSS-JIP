import ReactDOM from "react-dom";
import { React, StrictMode } from "react";
import Basket from "./Basket";

export default function() {
  //let items =  ["item1", "item2", "item3"];
  let items = [];

  ReactDOM.render(
    <StrictMode>
      <Basket items={items} />
    </StrictMode>,
    document.getElementById("root")
  );
}