const SimpleSelect = () => {
  return (
    <>
      <label htmlFor="model"> Choose a model: </label>
      <select name="cars" id="cars">
        <option value="a">A</option>
        <option value="b">B</option>
        <option value="c">C</option>
        <option value="d">D</option>
        <option value="e">E</option>
      </select>
    </>
  );
};

export default SimpleSelect;
