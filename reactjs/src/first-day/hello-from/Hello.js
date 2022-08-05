// const Hello = function() {
//   return <h1>Hello REACT</h1>;
// };

// const Hello = () => {
//   return <h1>Hello REACT</h1>;
// };

const Hello = function(props) {
  let { title, name } = props;
  return (
    <>
      {title}
      <h1>Hello REACT - Functional Component {name}</h1>
    </>
  );
};
export default Hello;