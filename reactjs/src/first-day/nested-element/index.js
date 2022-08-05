import ReactDOM from "react-dom";

export default function() {
  const nestedElement = (
    <>
      <div>
        <div>Hello1</div>
        <div>Hello2</div>
      </div>
      <div>
        <div>Hello3</div>
        <div>Hello4</div>
      </div>
    </>
  );

  ReactDOM.render(nestedElement, document.getElementById("root"));

}