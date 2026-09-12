
with distinct_customer as (
    select
        distinct visited_on
    from customer
)
select
c1.visited_on,
sum(c2.amount) as amount,
round(sum(c2.amount)/7::numeric, 2) as average_amount
from distinct_customer c1
join customer c2
on c1.visited_on >= c2.visited_on and c1.visited_on - c2.visited_on < 7
where c1.visited_on >= (
    select 
        min(visited_on)
    from
        customer
) + 6
group by c1.visited_on
order by c1.visited_on;


-- select
-- *
-- from distinct_customer c1
-- join customer c2
-- on c1.visited_on >= c2.visited_on and c1.visited_on - c2.visited_on < 7
-- where c1.visited_on >= (
--     select 
--         min(visited_on)
--     from
--         customer
-- ) + 6
-- order by c1.visited_on desc;