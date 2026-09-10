select
    reports_to employee_id,
    (
        select
            name
        from employees e1
        where e1.employee_id = e2.reports_to
    ),
    count(*) reports_count,
    round(avg(age)) average_age
from employees e2
where reports_to is not null
group by reports_to
order by reports_to;