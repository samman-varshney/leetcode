
select
request_at "Day",
round((count(*) filter (where status != 'completed')) * 1.0 / greatest(1, count(*)), 2) "Cancellation Rate"
from trips t
join users c
on  t.client_id = c.users_id and c.banned = 'No'
join users d
on t.driver_id = d.users_id and d.banned = 'No'
where request_at = '2013-10-01' or request_at = '2013-10-02' or request_at = '2013-10-03'
group by request_at;