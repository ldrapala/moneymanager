--jakie są średnie wpływy danego użytkowika

SELECT login, TO_CHAR(AVG(amount), 'FM99999999.00') AS "Średnie wpływy" 
FROM inflow, person
WHERE person.id = inflow.person_id
GROUP BY login ORDER BY "Średnie wpływy" desc;

--jakie są wydatki miesięczne danego użytkownika

SELECT login, EXTRACT(MONTH FROM date) as "Miesiąc", 
  EXTRACT(YEAR FROM date) as "Rok", 
  SUM(amount) as "Suma wydatków"
FROM expense, person
WHERE person.id = expense.person_id
GROUP BY EXTRACT(MONTH FROM date), EXTRACT(year from date), login;

--ilość depozytów na osobę

SELECT login, COUNT(*) AS "Liczba depozytów" 
FROM deposit, person
WHERE deposit.person_id = person.id
GROUP BY login;

--odsetki z lokaty

SELECT id, amount, duration, 
TO_CHAR(amount*interest/100*duration/365, 'FM99999999.00') 
AS "odsetki" FROM deposit;

--wpływy ze znanych źródeł

SELECT * FROM inflow WHERE source IS NOT NULL ORDER BY source;

--produkty bez nazwy producenta

SELECT product.id, product.producer, subcategory.name 
FROM product, subcategory 
WHERE product.subcategory_id = subcategory.id 
AND product.producer IS NULL;

--wybrane podkategorie wg wzorca

SELECT * from subcategory WHERE name LIKE '%woda%';

--porównanie średnich cen produktów w różnych sklepach

SELECT nested.name, nested.sub, nested.producer,
TO_CHAR(AVG(nested.price), 'FM99999999.00'), 
nested.content
FROM (
SELECT shop.name , shopping_product.price, 
subcategory.content,
product.producer, subcategory.name as "sub"
FROM shop INNER JOIN shopping
ON shop.id = shopping.shop_id
INNER JOIN shopping_product
ON shopping.id = shopping_product.shopping_id
INNER JOIN product
ON shopping_product.product_id = product.id
INNER JOIN subcategory
ON subcategory.id = product.subcategory_id
) AS nested
GROUP BY nested.name, nested.content, 
nested.producer, nested.sub
ORDER BY nested.producer, nested.content,
nested.name

-- aktualizacja hasła

UPDATE person SET password='dorota2' WHERE id = 2;

-- usunięcie użytkownika

DELETE FROM person WHERE id = 1;

