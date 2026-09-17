
select
request_at "Day",
round((count(*) filter (where status != 'completed')) * 1.0 / count(*), 2) "Cancellation Rate"
from trips t
join users client
on  t.client_id = client.users_id and client.banned = 'No'
join users driver
on t.driver_id = driver.users_id and driver.banned = 'No'
where request_at = '2013-10-01' or request_at = '2013-10-02' or request_at = '2013-10-03'
group by request_at;