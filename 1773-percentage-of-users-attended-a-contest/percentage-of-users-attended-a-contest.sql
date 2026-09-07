-- Write your PostgreSQL query statement below
select contest_id, round(count(user_id) * 100.0 / (select count(*) from users), 2) as percentage
from register
group by contest_id
order by percentage desc, contest_id asc;