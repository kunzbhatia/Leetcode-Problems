# Write your MySQL query statement below


Select 
 round(sum(if(min_order=min_pref_delivery_date,1,0))/count(min_order)*100,2) as immediate_percentage
from

(Select customer_id ,
min(order_date) as min_order,
min(customer_pref_delivery_date) as min_pref_delivery_date

from delivery
group by customer_id) AS new_table;
