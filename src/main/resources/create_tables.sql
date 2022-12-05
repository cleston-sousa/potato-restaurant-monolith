# Sql Scripts - Single Service

CREATE TABLE IF NOT EXISTS customer_table (
  id BIGSERIAL PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  status SMALLINT NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT NULL,
  UNIQUE(name)
);

CREATE TABLE IF NOT EXISTS invoice (
  id BIGSERIAL PRIMARY KEY,
  customer_table_id BIGINT NOT NULL,
  customer_table_name VARCHAR(50) NOT NULL,
  total_items SMALLINT NOT NULL,
  total_price NUMERIC(7,2) NOT NULL,
  status SMALLINT NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT NULL,
  CONSTRAINT fk_customer_table FOREIGN KEY(customer_table_id) REFERENCES customer_table(id) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS invoice_item (
  id BIGSERIAL PRIMARY KEY,
  invoice_id BIGINT NOT NULL,
  name VARCHAR(50) NOT NULL,
  removed_ingredients VARCHAR NOT NULL,
  added_ingredients VARCHAR NOT NULL,
  quantity SMALLINT NOT NULL,
  price NUMERIC(7,2) NOT NULL,
  CONSTRAINT fk_invoice FOREIGN KEY(invoice_id) REFERENCES invoice(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS menu_category (
  id BIGSERIAL PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT NULL,
  UNIQUE(name)
);

CREATE TABLE IF NOT EXISTS menu_item (
  id BIGSERIAL PRIMARY KEY,
  menu_category_id BIGINT NOT NULL,
  name VARCHAR(50) NOT NULL,
  description TEXT NOT NULL,
  price NUMERIC(7,2) NOT NULL,
  status SMALLINT NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT NULL,
  CONSTRAINT fk_menu_category FOREIGN KEY(menu_category_id) REFERENCES menu_category(id) ON DELETE SET NULL,
  UNIQUE(name)
);

CREATE TABLE IF NOT EXISTS ingredient (
  id BIGSERIAL PRIMARY KEY,
  menu_item_id BIGINT NOT NULL,
  name VARCHAR(50) NOT NULL,
  description TEXT NOT NULL,
  included BOOLEAN NOT NULL,
  price NUMERIC(7,2) NOT NULL,
  CONSTRAINT fk_menu_item FOREIGN KEY(menu_item_id) REFERENCES menu_item(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS customer_order (
  id BIGSERIAL PRIMARY KEY,
  customer_table_name VARCHAR(50) NOT NULL,
  menu_item_name VARCHAR(50) NOT NULL,
  quantity SMALLINT NOT NULL,
  status SMALLINT NOT NULL,
  price NUMERIC(7,2) NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT NULL,
  CONSTRAINT fk_customer_table FOREIGN KEY(customer_table_id) REFERENCES customer_table(id) ON DELETE SET NULL,
  CONSTRAINT fk_menu_item FOREIGN KEY(menu_item_id) REFERENCES menu_item(id) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS remove_ingredient (
  customer_order_id BIGINT NOT NULL,
  ingredient_id BIGINT NOT NULL,
  CONSTRAINT fk_customer_order FOREIGN KEY(customer_order_id) REFERENCES customer_order(id) ON DELETE SET NULL,
  CONSTRAINT fk_ingredient FOREIGN KEY(ingredient_id) REFERENCES ingredient(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS add_ingredient (
  customer_order_id BIGINT NOT NULL,
  ingredient_id BIGINT NOT NULL,
  CONSTRAINT fk_customer_order FOREIGN KEY(customer_order_id) REFERENCES customer_order(id) ON DELETE SET NULL,
  CONSTRAINT fk_ingredient FOREIGN KEY(ingredient_id) REFERENCES ingredient(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS custom_ingredient (
  id BIGSERIAL PRIMARY KEY,
  customer_order_id BIGINT NOT NULL,
  ingredient_name VARCHAR(50) NOT NULL,
  action SMALLINT NOT NULL,
  price NUMERIC(7,2) NOT NULL,
  CONSTRAINT fk_customer_order FOREIGN KEY(customer_order_id) REFERENCES customer_order(id) ON DELETE SET NULL
);










# Sql Scripts - Multi-Service

## customer-tables-service
CREATE TABLE IF NOT EXISTS customer_table (
  id BIGSERIAL PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  status SMALLINT NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT NULL,
  UNIQUE(name)
);

## invoices-service
CREATE TABLE IF NOT EXISTS invoice (
  id BIGSERIAL PRIMARY KEY,
  customer_table_name VARCHAR(50) NOT NULL,
  total_items SMALLINT NOT NULL,
  total_price NUMERIC(7,2) NOT NULL,
  status SMALLINT NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS invoice_item (
  id BIGSERIAL PRIMARY KEY,
  invoice_id BIGINT NOT NULL,
  name VARCHAR(50) NOT NULL,
  removed_ingredients VARCHAR NOT NULL,
  added_ingredients VARCHAR NOT NULL,
  quantity SMALLINT NOT NULL,
  price NUMERIC(7,2) NOT NULL,
  CONSTRAINT fk_invoice FOREIGN KEY(invoice_id) REFERENCES invoice(id) ON DELETE CASCADE
);

## menu-items-service
CREATE TABLE IF NOT EXISTS menu_category (
  id BIGSERIAL PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT NULL,
  UNIQUE(name)
);

CREATE TABLE IF NOT EXISTS menu_item (
  id BIGSERIAL PRIMARY KEY,
  menu_category_id BIGINT NOT NULL,
  name VARCHAR(50) NOT NULL,
  description TEXT NOT NULL,
  price NUMERIC(7,2) NOT NULL,
  status SMALLINT NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT NULL,
  CONSTRAINT fk_menu_category FOREIGN KEY(menu_category_id) REFERENCES menu_category(id) ON DELETE SET NULL,
  UNIQUE(name)
);

CREATE TABLE IF NOT EXISTS ingredient (
  id BIGSERIAL PRIMARY KEY,
  menu_item_id BIGINT NOT NULL,
  name VARCHAR(50) NOT NULL,
  description TEXT NOT NULL,
  included BOOLEAN NOT NULL,
  price NUMERIC(7,2) NOT NULL,
  CONSTRAINT fk_menu_item FOREIGN KEY(menu_item_id) REFERENCES menu_item(id) ON DELETE CASCADE
);

## customer_orders-service
CREATE TABLE IF NOT EXISTS customer_order (
  id BIGSERIAL PRIMARY KEY,
  customer_table_name VARCHAR(50) NOT NULL,
  menu_item_name VARCHAR(50) NOT NULL,
  quantity SMALLINT NOT NULL,
  price NUMERIC(7,2) NOT NULL,
  status SMALLINT NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS remove_ingredient (
  customer_order_id BIGINT NOT NULL,
  ingredient_name VARCHAR(50) NOT NULL,
  price NUMERIC(7,2) NOT NULL,
  CONSTRAINT fk_customer_order FOREIGN KEY(customer_order_id) REFERENCES customer_order(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS add_ingredient (
  customer_order_id BIGINT NOT NULL,
  ingredient_name VARCHAR(50) NOT NULL,
  price NUMERIC(7,2) NOT NULL,
  CONSTRAINT fk_customer_order FOREIGN KEY(customer_order_id) REFERENCES customer_order(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS custom_ingredient (
  id BIGSERIAL PRIMARY KEY,
  customer_order_id BIGINT NOT NULL,
  ingredient_name VARCHAR(50) NOT NULL,
  price NUMERIC(7,2) NOT NULL,
  action SMALLINT NOT NULL,
  CONSTRAINT fk_customer_order FOREIGN KEY(customer_order_id) REFERENCES customer_order(id) ON DELETE SET NULL
);


# drop tables ordered

drop table custom_ingredient;
drop table add_ingredient;
drop table remove_ingredient;
drop table ingredient;
drop table invoice_item;
drop table invoice;
drop table customer_order;
drop table menu_item;
drop table menu_category; 
drop table customer_table;

# test data

INSERT INTO  customer_table (name, status) VALUES ('Mesa 1', 0);
INSERT INTO  customer_table (name, status) VALUES ('Mesa 2', 0);
INSERT INTO  customer_table (name, status) VALUES ('Mesa 3', 0);

INSERT INTO  menu_category (name) VALUES ('Drinks');
INSERT INTO  menu_category (name) VALUES ('Sides');
INSERT INTO  menu_category (name) VALUES ('Main Dishes');

INSERT INTO  menu_item (menu_category_id, name, description, price, status) VALUES (1, 'Suco de laranja', 'Suco de laranja feito na hora', 10.0, 1);
INSERT INTO  menu_item (menu_category_id, name, description, price, status) VALUES (1, 'Suco de uva', 'Suco de uva direto da vinícula', 15.0, 1);
INSERT INTO  menu_item (menu_category_id, name, description, price, status) VALUES (1, 'Suco de morango', 'Suco de morangos congelados', 9.0, 1);

INSERT INTO  menu_item (menu_category_id, name, description, price, status) VALUES (2, 'Fritas & Bacon', 'Batatas fritas com bacon em cubos', 35.0, 1);
INSERT INTO  ingredient (menu_item_id, name, description, included, price) VALUES (4, 'Chedar', 'Queijo chedar', true, 0.0);
INSERT INTO  ingredient (menu_item_id, name, description, included, price) VALUES (4, 'Parmesão', 'Queijo parmesão', false, 2.0);
INSERT INTO  ingredient (menu_item_id, name, description, included, price) VALUES (4, 'Mais Bacon', 'Porção extra de bacon para amantes', false, 5.0);

INSERT INTO  menu_item (menu_category_id, name, description, price, status) VALUES (2, 'Ham+Burguer+Dog', 'Lanche diferenciado da caso com hamburguer e salsicha', 55.0, 1);
INSERT INTO  ingredient (menu_item_id, name, description, included, price) VALUES (5, 'Pão', 'Pão gigante e macio', true, 0.0);
INSERT INTO  ingredient (menu_item_id, name, description, included, price) VALUES (5, 'Mussarela', 'Queijo mussarela', true, 0.0);
INSERT INTO  ingredient (menu_item_id, name, description, included, price) VALUES (5, 'Tomate', 'Tomate picato', true, 0.0);
INSERT INTO  ingredient (menu_item_id, name, description, included, price) VALUES (5, 'Presunto', 'Fatias de presunto', true, 0.0);
INSERT INTO  ingredient (menu_item_id, name, description, included, price) VALUES (5, 'Salsicha', 'Uma salsicha em pedaços', true, 0.0);
INSERT INTO  ingredient (menu_item_id, name, description, included, price) VALUES (5, 'Molho da casa', 'Uma mistura de ervas muito loucas que adicionam uma experiência de outro mundo ao sabor', true, 0.0);
INSERT INTO  ingredient (menu_item_id, name, description, included, price) VALUES (5, 'Chedar', 'Queijo chedar', false, 2.0);
INSERT INTO  ingredient (menu_item_id, name, description, included, price) VALUES (5, 'Honey Mustard', '50g de molho mostarda e mel adicional para mais sabor nas mordidas', false, 2.0);
INSERT INTO  ingredient (menu_item_id, name, description, included, price) VALUES (5, 'Bacon', 'Bacon picado', false, 5.0);

