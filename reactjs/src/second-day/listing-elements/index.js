import ReactDOM from "react-dom";
import { StrictMode } from "react";
import ProductList from "./ProductList";

export default function() {

  var products = [
    { name: "Apple", price: 2 },
    { name: "Banana", price: 8 },
    { name: "Carrot", price: 4 },
    { name: "Kiwi", price: 7 },
    { name: "Orange", price: 3 }
  ];

  const rootElement = document.getElementById("root");
  ReactDOM.render(
    <StrictMode>
      <ProductList products={products} />
    </StrictMode>,
    rootElement
  );
}
