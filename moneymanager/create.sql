CREATE TABLE IF NOT EXISTS person
(
  id serial,
  login character varying(30) UNIQUE,
  password character varying(64) NOT NULL,
  CONSTRAINT person_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS expense
(
  id serial,
  name character varying(30) NOT NULL,
  details character varying(30),
  amount numeric(10,2) NOT NULL,
  createdate date,
  person_id integer NOT NULL,
  CONSTRAINT expense_pk PRIMARY KEY (id),
  CONSTRAINT person_fk FOREIGN KEY (person_id)
  REFERENCES person (id) 
  ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS inflow
(
id serial,
amount numeric(10,2) NOT NULL,
createdate date,
name character varying(30),
details character varying(30),
person_id integer NOT NULL,
CONSTRAINT inflow_pk PRIMARY KEY (id),
CONSTRAINT person_fk FOREIGN KEY (person_id) 
REFERENCES person (id)
ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS deposit
(
id serial,
amount numeric(10,2) NOT NULL,
createdate date,
duration int NOT NULL,
interest real NOT NULL,
person_id integer NOT NULL,
CONSTRAINT deposit_pk PRIMARY KEY (id),
CONSTRAINT person_fk FOREIGN KEY (person_id) 
REFERENCES person (id)
ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS shop
(
id serial,
name character varying(30) UNIQUE,
CONSTRAINT shop_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS shopping
(
id serial,
createdate date,
person_id integer NOT NULL,
shop_id integer NOT NULL,
CONSTRAINT shopping_pk PRIMARY KEY (id),
CONSTRAINT person_fk FOREIGN KEY (person_id) 
REFERENCES person (id)
ON UPDATE CASCADE ON DELETE CASCADE,
CONSTRAINT shop_fk FOREIGN KEY (shop_id) 
REFERENCES shop (id)
ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS category
(
id serial,
name character varying(30) UNIQUE,
CONSTRAINT category_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS subcategory
(
id serial,
name character varying(30),
content real,
category_id integer NOT NULL,
CONSTRAINT subcategory_pk PRIMARY KEY (id),
CONSTRAINT category_fk FOREIGN KEY (category_id) 
REFERENCES category (id)
ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS product
(
id serial,
producer character varying(30),
subcategory_id integer NOT NULL,
CONSTRAINT product_pk PRIMARY KEY (id),
CONSTRAINT subcategory_fk FOREIGN KEY (subcategory_id)
REFERENCES subcategory (id)
ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS shopping_product
(
shopping_id integer,
product_id integer,
price numeric(10,2) NOT NULL,
number integer DEFAULT 1,
PRIMARY KEY (shopping_id, product_id),
CONSTRAINT shopping_fk FOREIGN KEY (shopping_id)
REFERENCES shopping (id)
ON UPDATE CASCADE ON DELETE CASCADE,
CONSTRAINT product_fk FOREIGN KEY (product_id)
REFERENCES product (id)
ON UPDATE CASCADE ON DELETE CASCADE
);




