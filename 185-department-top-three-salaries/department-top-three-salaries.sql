select department, employee, salary 
from
(
    select
    d.name department,
    e.name employee,
    salary,
    dense_rank() over(partition by departmentId order by salary desc) rank
    from employee e
    join department d
    on e.departmentId = d.id
) t
where rank <= 3
order by department;