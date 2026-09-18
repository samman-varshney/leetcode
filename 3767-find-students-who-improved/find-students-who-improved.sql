-- Write your PostgreSQL query statement below
with exam as (
    select
        student_id,
        subject,
        (
            select 
                score 
            from 
                scores s2 
            where 
                s2.student_id = s1.student_id and 
                s2.subject = s1.subject and 
                exam_date = min(s1.exam_date)
        ) first_score,
        (
            select 
                score 
            from 
                scores s2 
            where 
                s2.student_id = s1.student_id and 
                s2.subject = s1.subject and 
                exam_date = max(s1.exam_date)
        ) latest_score
    from 
        scores s1
    group by 
        student_id, 
        subject
)

select 
    student_id,
    subject,
    first_score,
    latest_score
from
    exam
where 
    latest_score > first_score
order by 
    student_id,
    subject;
