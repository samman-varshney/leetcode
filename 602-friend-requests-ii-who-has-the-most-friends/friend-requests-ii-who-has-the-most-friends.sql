select
    ra1.id,
    count(id) num
from (
    select  requester_id id from requestaccepted 
    union all
    select  accepter_id id from requestaccepted) ra1
group by id
order by count(id) desc
limit 1;

