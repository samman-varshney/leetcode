with temp as (
    select *,
    lag(id, 2, id) over(partition by num order by id) third
    from logs
)
select distinct num "ConsecutiveNums"
from temp
where id - third = 2;