select
    ra1.requester_id id,
    count(*) num
from (select distinct requester_id from requestaccepted union select distinct accepter_id from requestaccepted) ra1
join requestaccepted ra2
on ra1.requester_id = ra2.accepter_id
or ra1.requester_id = ra2.requester_id
group by ra1.requester_id
order by count(*) desc
limit 1;

