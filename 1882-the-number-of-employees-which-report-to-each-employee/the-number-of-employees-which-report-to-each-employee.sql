-- Write your PostgreSQL query statement below
select
    managers.employee_id,
    managers.name,
    count(*) reports_count,
    round(avg(employees.age)) average_age
from employees
join employees managers
on employees.reports_to = managers.employee_id
group by managers.employee_id, managers.name
order by managers.employee_id;