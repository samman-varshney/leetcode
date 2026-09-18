select
    product_id,
    (select product_name from product where product_id = sales.product_id)
from 
    sales
group by 
    product_id
having COUNT(*) FILTER (
    WHERE sale_date NOT BETWEEN DATE '2019-01-01' AND DATE '2019-03-31'
) = 0;