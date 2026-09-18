SELECT
    s.product_id,
    p.product_name
FROM sales s
JOIN product p
    ON p.product_id = s.product_id
GROUP BY s.product_id, p.product_name
HAVING MIN(s.sale_date) >= DATE '2019-01-01'
   AND MAX(s.sale_date) <= DATE '2019-03-31';