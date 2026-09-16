CREATE OR REPLACE FUNCTION NthHighestSalary(N INT) RETURNS TABLE (Salary INT) AS $$
BEGIN
  RETURN QUERY 
   
        select 
            w.salary 
        from 
        (
            select 
                e.salary,
                rank() over(order by e.salary desc) rk
            from employee e
            group by 
                e.salary
        ) w
        where rk = N;
    
      

END;
$$ LANGUAGE plpgsql;