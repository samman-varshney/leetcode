select
    product_id,
    (select product_name from product where product_id = sales.product_id)
from 
    sales
group by 
    product_id
having sum(
    case 
        when sale_date >= '2019-01-01' and sale_date <= '2019-03-31' then 0
        else 1
    end
) = 0;