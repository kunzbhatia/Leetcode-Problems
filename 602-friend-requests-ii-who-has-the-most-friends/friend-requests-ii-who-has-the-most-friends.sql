# Write your MySQL query statement below

select id, count(id) as num from
(Select requester_id as id from RequestAccepted
union all
Select accepter_id as id from RequestAccepted) as temp

group by  id
order by num DESC limit 1;