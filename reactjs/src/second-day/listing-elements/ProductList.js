import { uniqueId } from "lodash";

const ProductList = ({ products }) => {
  return (
    <ol>
      {products &&
        products.map((product) => {
          return <ProductItem key={uniqueId("product-")} {...product} />;
        })}
    </ol>
  );
};

const ProductItem = ({ name, price }) => {
  return (
    <li>
      Product: {name}, Price: ${price}
    </li>
  );
};

export default ProductList;

