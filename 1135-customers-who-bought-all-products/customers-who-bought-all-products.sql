-- Write your PostgreSQL query statement below
with ranked_customer as (
    select 
        customer_id,
        count( distinct product_key) product_bought
    from customer
    where product_key is not null
    group by customer_id
)

select 
    customer_id
from ranked_customer
where product_bought = (select count(*) from product);