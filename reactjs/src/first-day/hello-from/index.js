import ReactDOM from "react-dom";
import { React, StrictMode } from "react";
import Hello from "./Hello";

// export default function() {
//   const element = <h1> Hello From React! </h1>
//   const element = React.createElement("h1", null, "Hello From React!");
//   ReactDOM.render(element, document.getElementById("root"));
// }

// export default function() {
//   const element = React.createElement(
//     "div",
//     null,
//     React.createElement("h2",null,"Hello feom React h2")
//   );
//   ReactDOM.render(element, document.getElementById("root"));
// }


// export default function() {
//   const rootElement = document.getElementById("root");
//   ReactDOM.render(
//     <StrictMode>
//       <Hello />
//     </StrictMode>
//     , rootElement);
//   //ReactDOM.render(<Hello2/>, rootElement);
// }

export default function() {
  let propObject = {
    title: "My title",
    name: "My name"
  };
  ReactDOM.render(
    <StrictMode>
      <Hello title={propObject.title} name={propObject.name} />
    </StrictMode>
    , document.getElementById("root"));

}