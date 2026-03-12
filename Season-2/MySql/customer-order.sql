CREATE TABLE customer (
  customer_id INT PRIMARY KEY,
  customer_name VARCHAR(50)
);

CREATE TABLE orders (
  order_id INT PRIMARY KEY,
  customer_id INT,
  item_count INT,
  order_amount INT,
  FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
);
INSERT INTO customer VALUES
(1,'Ravi'), (2,'Anil'), (3,'Kiran');

INSERT INTO orders VALUES
(101,1,3,3000),
(102,1,2,2000),
(103,2,5,5000),
(104,3,1,1000);
