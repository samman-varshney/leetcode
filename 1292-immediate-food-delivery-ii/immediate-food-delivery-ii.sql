with first_orders as (
    select  
        *,
        row_number() over(partition by customer_id order by order_date) as rn
        from delivery
)
select 
    round( count(*) filter (where order_date = customer_pref_delivery_date) * 100.0 / count(*), 2) immediate_percentage
    from first_orders
    where rn = 1;