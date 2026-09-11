
select
id,
case
    when id%2 = 0
        then coalesce((select s2.student from seat s2 where s2.id + 1 = s1.id), student)
        else coalesce((select s3.student from seat s3 where s3.id - 1 = s1.id), student)
    end as student
from
seat s1
order by id;