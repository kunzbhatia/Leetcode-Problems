# Write your MySQL query statement below

-- SELECT w1.id
-- FROM weather w1
-- WHERE w1.temperature > (
--     SELECT w2.temperature 
--     FROM weather w2 
--     WHERE w1.recordDate = DATE_ADD(w2.recordDate, INTERVAL 1 DAY)
-- );

Select w1.id
from weather w1 join weather w2
where datediff(w1.recordDate,w2.recordDate)=1
and w1.temperature>w2.temperature;


