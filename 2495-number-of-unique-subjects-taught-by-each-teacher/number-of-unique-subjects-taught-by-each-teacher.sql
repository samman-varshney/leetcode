with ranked as (
    select 
        *,
        dense_rank() over(partition by teacher_id order by subject_id asc) cnt
    from teacher
)

select teacher_id, max(cnt) cnt
from ranked
group by teacher_id;