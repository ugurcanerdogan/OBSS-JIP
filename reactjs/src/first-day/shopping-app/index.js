import ReactDOM from "react-dom";
import ShoppingApp from "./ShoppingApp";

export default function() {

  let foods = ["banana", "apple", "cheese"];
  let clothes = ["shirt", "pants", "hat"];
  let supplies = ["pen", "paper", "glue"];

  ReactDOM.render(<ShoppingApp foods={foods} clothes={clothes} supplies={supplies} />, document.getElementById("root"));
}