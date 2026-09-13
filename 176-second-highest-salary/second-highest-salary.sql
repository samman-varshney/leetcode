-- Write your PostgreSQL query statement below
select * 
from (
    (select
        distinct salary secondhighestsalary
    from employee
    where salary != 
    (
        select max(salary) from employee
    )
    order by salary desc)
    union all
    (select null secondhighestsalary)
) 
limit 1;
