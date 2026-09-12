with sorted_insurance as (
    select 
        *,
        lag(tiv_2015, 1) over(order by tiv_2015) previous,
        lead(tiv_2015, 1) over(order by tiv_2015) next
        
    from insurance 
),
unique_location as (
    select
        *,
        count(*) over(partition by lon, lat) size
    from
        sorted_insurance
)
select 
    round(
            sum(
                    case 
                        when 
                            tiv_2015 = previous 
                        or 
                            tiv_2015 = next 
                        then 
                            tiv_2016 
                        else 
                            0
                        end
                )::numeric,
                2
        ) tiv_2016
from unique_location
where size = 1;

