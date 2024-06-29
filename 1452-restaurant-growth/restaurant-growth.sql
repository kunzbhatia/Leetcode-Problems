# Write your MySQL query statement below

Select c.visited_on, 

(Select sum(amount) from customer 
where visited_on between date_sub(c.visited_on, INTERVAL 6 DAY) and c.visited_on) AS amount,

round((Select sum(amount)/7 from customer 
where visited_on between date_sub(c.visited_on, INTERVAL 6 DAY) and c.visited_on),2) AS average_amount

from customer c

where c.visited_on>=(Select date_add(min(visited_on), INTERVAL 6 DAY) from customer)

group by visited_on
order by visited_on