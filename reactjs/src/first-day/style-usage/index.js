import ReactDOM from "react-dom";


export default function StyledDiv() {
  const styledObject = {
    minWidth: 100,
    minHeight: 100,
    backgroundColor: "blue",
    textAlign: "center",
    lineHeight: "100px"
  };

  const element = <div style={styledObject}>This is styled div!</div>;
  const rootElement = document.getElementById("root");

  ReactDOM.render(element, rootElement);
}