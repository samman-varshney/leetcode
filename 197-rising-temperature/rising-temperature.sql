SELECT id
FROM (
    SELECT
        id,
        temperature,
        recordDate,
        LAG(temperature) OVER (ORDER BY recordDate) AS prev_temperature,
        LAG(recordDate) OVER (ORDER BY recordDate) AS prev_date
    FROM Weather
) w
WHERE temperature > prev_temperature
  AND recordDate - prev_date = 1;