select 
    product_id,
    year first_year,
    quantity,
    price
from sales
where (product_id, year) in (
    select 
        product_id,
        min(year) first_year
        from sales
        group by product_id
);