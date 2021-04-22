BEGIN;

DROP TABLE IF EXISTS products CASCADE;
DROP TABLE IF EXISTS categories CASCADE;
DROP TABLE IF EXISTS products_categories CASCADE;

CREATE TABLE IF NOT EXISTS categories (id serial, title varchar(255), PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS products (id serial PRIMARY KEY, title VARCHAR(255), price int, category_id integer REFERENCES categories (id));

CREATE TABLE IF NOT EXISTS products_categories (product_id integer REFERENCES products (id), category_id integer REFERENCES categories (id));

INSERT INTO categories (id, title) VALUES
(1, 'food');

INSERT INTO products (title, price, category_id) VALUES
('Bread', 25, 1),
('Milk', 80, 1);

COMMIT;