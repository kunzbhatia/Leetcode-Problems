# Write your MySQL query statement below


Select max(num) as num
from
(Select num from MyNumbers 
group by num
having count(*)=1)
as temp