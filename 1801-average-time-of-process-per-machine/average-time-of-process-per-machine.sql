select machine_id,
round(2*avg(case when activity_type = 'start' then timestamp*-1 else timestamp end)::numeric, 3) processing_time
from Activity
group by machine_id;