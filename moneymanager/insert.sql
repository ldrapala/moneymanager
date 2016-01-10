INSERT INTO person (login, password) VALUES ('luke', 'luke');
INSERT INTO person (login, password) VALUES ('dorota', 'dorota');

INSERT INTO expense (amount, name, person_id) 
VALUES (505, 'mieszkanie', 1);
INSERT INTO expense (amount, name, person_id) VALUES (100, 'pr¹d', 1);
INSERT INTO expense (amount, name, person_id) 
VALUES (50, 'internet', 1);
INSERT INTO expense (amount, name, createdate, person_id) 
VALUES (505, 'mieszkanie', '2014-12-01', 1);
INSERT INTO expense (amount, name, createdate, person_id) 
VALUES (100, 'pr¹d', '2014-12-01', 1);
INSERT INTO expense (amount, name, createdate, person_id) 
VALUES (50, 'internet', '2014-12-01', 1);

INSERT INTO inflow (amount, name, createdate, person_id) 
VALUES (3850, 'praca', '2014-11-30', 1);
INSERT INTO inflow (amount, name, createdate, person_id) 
VALUES (700, 'premia', '2014-11-30', 1);
INSERT INTO inflow (amount, name, createdate, person_id) 
VALUES (3850, 'praca', '2014-12-31', 1);
INSERT INTO inflow (amount, name, createdate, person_id) 
VALUES (2000, 'premia', '2014-12-31', 1);
INSERT INTO inflow (amount, name, createdate, person_id) 
VALUES (2150, 'praca', '2014-12-31', 2);
INSERT INTO inflow (amount, createdate, person_id) 
VALUES (2150, '2014-12-31', 2);

INSERT INTO deposit (amount, createdate, duration, interest, 

person_id) 
VALUES (500, '2015-01-05', 365, 4, 1);
INSERT INTO deposit (amount, duration, interest, person_id) 
VALUES (1000, 90, 3, 2);
INSERT INTO deposit (amount, duration, interest, person_id) 
VALUES (1500, 180, 3.5, 2);
INSERT INTO deposit (amount, duration, interest, person_id) 
VALUES (3000, 30, 2, 1);
INSERT INTO deposit (amount, duration, interest, person_id) 
VALUES (500, 365, 4, 1);

INSERT INTO category (name) VALUES ('alkohol');
INSERT INTO category (name) VALUES ('pieczywo');
INSERT INTO category (name) VALUES ('chemia');
INSERT INTO category (name) VALUES ('napoje');
INSERT INTO category (name) VALUES ('owoce');
INSERT INTO category (name) VALUES ('warzywa');
INSERT INTO category (name) VALUES ('art. spo¿ywcze');

INSERT INTO subcategory (name, content, category_id) 
VALUES ('piwo', 0.5, 1);
INSERT INTO subcategory (name, content, category_id) 
VALUES ('piwo', 0.66, 1);
INSERT INTO subcategory (name, category_id) 
VALUES ('chleb', 2);
INSERT INTO subcategory (name, category_id) 
VALUES ('bu³ka', 2);
INSERT INTO subcategory (name, category_id) 
VALUES ('szampon', 3);
INSERT INTO subcategory (name, category_id) 
VALUES ('myd³o', 3);
INSERT INTO subcategory (name, content, category_id) 
VALUES ('woda gazowana', 1.5, 4);
INSERT INTO subcategory (name, content, category_id) 
VALUES ('woda niegazowana', 1.5, 4);
INSERT INTO subcategory (name, category_id) 
VALUES ('banany', 5);
INSERT INTO subcategory (name, category_id) 
VALUES ('jab³ka', 5);
INSERT INTO subcategory (name, category_id) 
VALUES ('ziemniaki', 6);
INSERT INTO subcategory (name, category_id) 
VALUES ('ketchup', 7);
INSERT INTO subcategory (name, content, category_id) 
VALUES ('parówki', 5, 7);
INSERT INTO subcategory (name, content, category_id) 
VALUES ('parówki', 6, 7);

INSERT INTO product (producer, subcategory_id) 
VALUES ('pudliszki', 12);
INSERT INTO product (producer, subcategory_id) 
VALUES ('warka', 1);
INSERT INTO product (producer, subcategory_id) 
VALUES ('tyskie', 1);
INSERT INTO product (producer, subcategory_id) 
VALUES ('tyskie', 2);
INSERT INTO product (producer, subcategory_id) 
VALUES ('warka', 2);
INSERT INTO product (subcategory_id) 
VALUES (3);

INSERT INTO shop (name) VALUES ('biedronka');
INSERT INTO shop (name) VALUES ('osiedlowy');
INSERT INTO shop (name) VALUES ('netto');

INSERT INTO shopping (createdate, shop_id, person_id) 
VALUES ('2014-12-31', 2, 2);
INSERT INTO shopping (createdate, shop_id, person_id) 
VALUES ('2015-01-04', 3, 2);
INSERT INTO shopping (shop_id, person_id) 
VALUES (3, 2);

INSERT INTO shopping_product (shopping_id, product_id, price)
VALUES (1, 1, 1.99);
INSERT INTO shopping_product (shopping_id, product_id, price, number)
VALUES (1, 2, 2.99, 2);
INSERT INTO shopping_product (shopping_id, product_id, price)
VALUES (1, 3, 3.19);
INSERT INTO shopping_product (shopping_id, product_id, price)
VALUES (1, 4, 3.59);
INSERT INTO shopping_product (shopping_id, product_id, price)
VALUES (1, 5, 3.69);
INSERT INTO shopping_product (shopping_id, product_id, price)
VALUES (1, 6, 1.99);
INSERT INTO shopping_product (shopping_id, product_id, price)
VALUES (2, 1, 1.79);
INSERT INTO shopping_product (shopping_id, product_id, price, number)
VALUES (2, 2, 2.79, 2);
INSERT INTO shopping_product (shopping_id, product_id, price)
VALUES (2, 3, 2.99);
INSERT INTO shopping_product (shopping_id, product_id, price)
VALUES (2, 4, 3.39);
INSERT INTO shopping_product (shopping_id, product_id, price)
VALUES (2, 5, 3.49);
INSERT INTO shopping_product (shopping_id, product_id, price)
VALUES (2, 6, 1.59);
INSERT INTO shopping_product (shopping_id, product_id, price)
VALUES (3, 1, 1.75);
INSERT INTO shopping_product (shopping_id, product_id, price, number)
VALUES (3, 2, 2.75, 2);
INSERT INTO shopping_product (shopping_id, product_id, price)
VALUES (3, 3, 2.95);
INSERT INTO shopping_product (shopping_id, product_id, price)
VALUES (3, 4, 3.35);
INSERT INTO shopping_product (shopping_id, product_id, price)
VALUES (3, 5, 3.45);
