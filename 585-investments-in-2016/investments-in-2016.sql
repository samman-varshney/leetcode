-- Write your PostgreSQL query statement below
select round(sum(tiv_2016)::numeric, 2) tiv_2016
from insurance 
where pid in (select distinct i1.pid
from insurance i1
join insurance i2
on i1.tiv_2015 = i2.tiv_2015 
and i1.pid != i2.pid
where (i1.lat, i1.lon) in

(select
lat, lon
from insurance
group by lat, lon
having count(*) = 1));