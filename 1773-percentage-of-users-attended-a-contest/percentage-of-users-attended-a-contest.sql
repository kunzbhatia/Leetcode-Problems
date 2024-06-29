# Write your MySQL query statement below


Select r.contest_id,
round(count(distinct r.user_id)*100/(Select count(user_id) from users),2) as percentage

from register r

group by r.contest_id
order by percentage DESC,contest_id ASC