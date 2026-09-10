-- Write your PostgreSQL query statement below
select e.employee_id, e.department_id 
from 
(
    select 
        *,
        rank() over(partition by employee_id order by primary_flag desc) 
    from employee
) e
where rank = 1;