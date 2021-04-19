BEGIN;

DROP TABLE IF EXISTS products CASCADE;

CREATE TABLE IF NOT EXISTS products (id bigserial PRIMARY KEY, title VARCHAR(255), price numeric(6, 2));

INSERT INTO products (title, price) VALUES
('Banana', 9.0),
('Bread', 4.0),
('Apple', 20.0),
('Raspberry', 10.5),
('Orange', 31.0);

COMMIT;