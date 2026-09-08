-- Write your PostgreSQL query statement below
select 
    month, 
    country, 
    count(*) trans_count, 
    sum(
        case 
            when state = 'approved' 
                then 
                    1 
                else 
                    0 
                end
        ) approved_count, 
    sum(amount) trans_total_amount, 
    sum(
        case 
            when state = 'approved' 
                then 
                    amount 
                else 
                    0 
                end
        ) approved_total_amount
from
    (
        select 
            *, 
            to_char(trans_date, 'YYYY-MM') as month
        from 
            transactions
    ) t
group by country, 
         month;