-- Write your PostgreSQL query statement below
select distinct on (employee_id) employee_id, department_id
from employee
order by employee_id, primary_flag desc;