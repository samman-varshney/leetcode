select w1.id from
Weather w1
join Weather w2
on w1.recordDate - w2.recordDate = 1 and w1.temperature > w2.temperature;
