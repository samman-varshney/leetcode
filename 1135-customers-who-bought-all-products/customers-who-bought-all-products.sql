select 
    customer_id
from customer
where product_key is not null
group by customer_id
having count(distinct product_key) = (select count(*) from product);