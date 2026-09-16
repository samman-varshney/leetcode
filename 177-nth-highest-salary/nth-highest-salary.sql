CREATE OR REPLACE FUNCTION NthHighestSalary(N INT) RETURNS TABLE (Salary INT) AS $$
BEGIN
  RETURN QUERY 
   
        select 
            e.salary
        from employee e
        group by
            e.salary
        order by
            e.salary desc
        limit 1
        offset 
        (
            
            case 
            when N > 0 
            then N - 1 
            else 
            (
                select 
                    count( distinct e2.salary ) 
                from employee e2
            ) 
            end 
        );

END;
$$ LANGUAGE plpgsql;