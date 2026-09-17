with t as (
    select
        *,
        lag(id, 1) over(order by id) previous_id
    from
        stadium
    where people >= 100
),

u as (
    select
        *,
        sum(case when id = previous_id + 1 then 0 else 1 end) over(order by id) rank
    from 
        t
),

v as (
    select
        *,
        count(*) over(partition by rank) as size
    from
        u
)

select 
    id,
    visit_date,
    people
from 
    v
where size >= 3;