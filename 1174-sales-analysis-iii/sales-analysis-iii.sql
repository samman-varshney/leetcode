-- Write your PostgreSQL query statement below
select
    distinct product_id, 
    (select product_name from product p where p.product_id = s.product_id)
from sales s
where sale_date between '2019-01-01' and '2019-03-31' 
and product_id not in (
    select 
        distinct product_id
    from sales s
    where sale_date < '2019-01-01' or sale_date > '2019-03-31'
);