import React, {useState} from "react";

class FooBar extends React.Component{
  constructor(props) {
    super(props);
    this.state={foo: 123, bar:456};
  }

  render() {
    return(
      <div>
        foo: {this.state.foo} bar: {this.state.bar}
      </div>
      );
  }
}

// const FooBar = () => {
//   const [fooBar, setFooBar] = useState({foo:123, bar:456});
//
//   return (
//     <div>
//       foo: {fooBar.foo} bar: {fooBar.bar}
//     </div>
//   );
// }

export default FooBar;