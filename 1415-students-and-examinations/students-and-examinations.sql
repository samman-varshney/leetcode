-- Write your PostgreSQL query statement below
select s.student_id, s.student_name, sb.subject_name, sum(case when e.student_id is not null then 1 else 0 end) attended_exams
from students s
cross join subjects sb
left join examinations e
on s.student_id = e.student_id and sb.subject_name = e.subject_name
group by s.student_id, s.student_name, sb.subject_name;