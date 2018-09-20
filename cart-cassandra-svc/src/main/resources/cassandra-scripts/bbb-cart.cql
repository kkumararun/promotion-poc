use bbbcart;

CREATE TABLE cart (
  id timeuuid,
  createDate TIMESTAMP,
  dicountedTotalPrice VARINT,
  discountTotalAmount VARINT,
  discountType TEXT,
  discountValue VARINT,
  orderTotal VARINT,
  userId TEXT,
  PRIMARY KEY (id));
  
CREATE TABLE cart_item (
  id timeuuid,
  discountType TEXT,
  discountValue VARINT,
  discountedPrice VARINT,
  image TEXT,
  productID TEXT,
  productListPrice VARINT,
  productName TEXT,
  productQuantity INT,
  salePrice VARINT,
  cartID TEXT,
  PRIMARY KEY (id));
  
CREATE INDEX cart_id_index ON bbbcart.cart_item (cartID);