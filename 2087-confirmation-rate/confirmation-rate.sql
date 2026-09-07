-- Write your PostgreSQL query statement below
select s.user_id, round((sum(case when c.action = 'confirmed' then 1 else 0 end) * 1.0 / count(*))::numeric, 2) confirmation_rate
from signups s
left join confirmations c
on s.user_id = c.user_id
group by s.user_id;