# Write your MySQL query statement below

-- Select w1.id
-- from weather w1
-- where w1.id IN
-- (Select w2.id 
-- from weather w2 
-- where w1.temperature<w2.temperature and datediff(w1.recordDate,w2.recordDate)=1)

SELECT w1.id
FROM weather w1
WHERE w1.temperature >(
    SELECT w2.temperature 
    FROM weather w2 
    WHERE w1.recordDate = DATE_ADD(w2.recordDate, INTERVAL 1 DAY)
);