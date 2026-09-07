-- Write your PostgreSQL query statement below
select name from
(
    select e1.name name, count(e2.id) report
    from employee e1
    join employee e2
    on e1.id = e2.managerId
    group by e1.id, e1.name
)
where report >= 5;