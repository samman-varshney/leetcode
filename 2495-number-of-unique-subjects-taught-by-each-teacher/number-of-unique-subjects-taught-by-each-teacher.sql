# Write your MySQL query statement below
select teacher_id, count(*) cnt
from (
    select teacher_id, subject_id
    from teacher
    group by teacher_id, subject_id
) w
group by teacher_id;