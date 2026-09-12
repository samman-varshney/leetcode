with sorted_insurance as (
    select 
        *,
        lag(tiv_2015, 1) over(order by tiv_2015) previous,
        lead(tiv_2015, 1) over(order by tiv_2015) next
    from insurance 
),

unique_location as  (
    select
        (select tiv_2015 from sorted_insurance si1 where si1.lat = si2.lat and si1.lon = si2.lon),
        (select previous from sorted_insurance si1 where si1.lat = si2.lat and si1.lon = si2.lon),
        (select next from sorted_insurance si1 where si1.lat = si2.lat and si1.lon = si2.lon),
        (select tiv_2016 from sorted_insurance si1 where si1.lat = si2.lat and si1.lon = si2.lon)
    from
        sorted_insurance si2
    group by
        lat,
        lon
    having
        count(*) = 1
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
from unique_location;

