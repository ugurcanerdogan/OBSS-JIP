import ReactDOM from "react-dom";

export const renderApp = () => {
  const hello = <h1>Hello</h1>;
  const rootElement = document.getElementById("root");

  ReactDOM.render(hello,rootElement);
}

export const renderApp1 = () => {
  const hello = <h1>Hello1</h1>;
  const rootElement = document.getElementById("root");

  ReactDOM.render(hello,rootElement);
}