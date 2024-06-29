# Write your MySQL query statement below



(Select u.name as results
from Users u
left join MovieRating mr
on u.user_id=mr.user_id

group by u.user_id
order by count(mr.user_id) desc ,u.name limit 1)

UNION ALL

(Select m.title as results
from Movies m
left join MovieRating mr
on m.movie_id=mr.movie_id

WHERE EXTRACT(YEAR FROM mr.created_at) = 2020 
  AND EXTRACT(MONTH FROM mr.created_at) = 2

group by m.movie_id
order by avg(mr.rating) desc ,m.title limit 1)


