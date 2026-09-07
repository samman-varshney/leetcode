select id from
(select id, temperature current_day_temperature, lag(temperature, 1, temperature) over(order by recordDate asc) as last_day_temperature, recordDate current_date, lag(recordDate, 1, recordDate) over(order by recordDate asc) last_date  from Weather) as e
where e.current_day_temperature > e.last_day_temperature and e.current_date - e.last_date = 1;