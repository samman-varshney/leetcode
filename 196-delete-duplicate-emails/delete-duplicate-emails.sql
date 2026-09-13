-- Write your PostgreSQL query statement below
delete from person where id not in (select id from 
(select
    *,
    row_number() over(partition by email order by id) rn
from person) t
where rn = 1);
