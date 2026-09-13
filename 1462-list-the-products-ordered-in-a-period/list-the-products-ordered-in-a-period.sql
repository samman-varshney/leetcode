-- Write your PostgreSQL query statement below
select
(select product_name from products p where p.product_id = o.product_id) as product_name,
sum(unit) unit
from orders o
where order_date >= '2020-02-01'
and order_date <= '2020-02-29'
group by product_id
having sum(unit) >= 100;