-- Write your PostgreSQL query statement belo


select 
    round( 
            count(*) filter (where first_order = customer_pref_delivery_date) * 100.0 / count(*),
            2
        ) as immediate_percentage 
from 
    (
        select 
            customer_id, 
            MIN(order_date) first_order
        from delivery
        group by 
            customer_id 
    ) as w
join delivery d
on w.customer_id = d.customer_id
    and w.first_order = d.order_date;


