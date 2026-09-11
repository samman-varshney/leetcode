# Write your MySQL query statement below
select
s1.id,
coalesce(s2.student, s1.student) student
from seat s1
left join seat s2
on (s1.id % 2 = 0
and s1.id = s2.id+1)
or (s1.id %2 = 1
and s1.id+1 = s2.id)
order by s1.id;