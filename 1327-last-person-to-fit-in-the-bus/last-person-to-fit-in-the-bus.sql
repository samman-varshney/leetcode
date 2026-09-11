with cumulative_queue as (
    select
        *,
        sum(weight) over(order by turn) as cumulative_weight
    from queue
)
select
    person_name
from cumulative_queue
where cumulative_weight = (
    select 
        max(cumulative_weight) 
    from cumulative_queue 
    where cumulative_weight <= 1000
    );