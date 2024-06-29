# Write your MySQL query statement below

Select e1.name 
from Employee e1
inner join Employee e2
on e1.id=e2.managerId
group by e2.managerId
having count(e2.managerId)>=5

-- SELECT name 
-- FROM Employee 
-- WHERE id IN (
--     SELECT managerId 
--     FROM Employee 
--     GROUP BY managerId 
--     HAVING COUNT(*) >= 5)