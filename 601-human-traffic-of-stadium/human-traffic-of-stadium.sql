-- Write your PostgreSQL query statement below
with t as (
    select
    *,
    lag(id, 1) over(order by id) previous,
    lead(id, 1) over(order by id) next
    from stadium s
    where people >= 100
),

w as (
    select
    *,
    id = previous + 1 and id = next - 1 as consecutive
    from t
),

z as (
    select
    *,
    lead(consecutive, 1) over(order by id) next_consecutive,
    lag(consecutive, 1) over(order by id) previous_consecutive
    from w
)

select
id,
visit_date,
people
from z
where 
consecutive 
or (previous + 1 = id and previous_consecutive)
or (next - 1 = id and next_consecutive)
order by visit_date;
