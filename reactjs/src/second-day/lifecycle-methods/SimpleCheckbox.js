const SimpleCheckBox = ({ label, name, value, checked, onChange }) => {
  return (
    <>
      <input
        type="checkbox"
        id={name}
        name={name}
        value={value}
        checked={checked}
        onChange={onChange}
      />
      <label htmlFor={name}> {label} </label>
      <br />
    </>
  );
};

export default SimpleCheckBox;
