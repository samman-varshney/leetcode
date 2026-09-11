# Write your MySQL query statement below
select
id,
case
    when id%2 = 0
        then previous
        else next
    end student
from
(select
*,
lag(student, 1, student) over(order by id) previous,
lead(student, 1, student) over(order by id) next
from seat) s
order by id;