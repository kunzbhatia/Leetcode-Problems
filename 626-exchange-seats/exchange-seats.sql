# Write your MySQL query statement below


Select 
case
when id=(Select max(id) from Seat) and id%2=1 then id
when id%2=1 then id+1 else id-1 end

as id, student 

from seat

order by id;