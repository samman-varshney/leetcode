
SELECT 
    (
        select
            q3.person_name
        from queue q3
        where q3.turn = q1.turn
    )
FROM Queue q1 JOIN Queue q2 ON q1.turn >= q2.turn
GROUP BY q1.turn
HAVING SUM(q2.weight) <= 1000
ORDER BY SUM(q2.weight) DESC
LIMIT 1