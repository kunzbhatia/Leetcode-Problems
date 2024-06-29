# Write your MySQL query statement below

select product_id, new_price as price
from Products
where (Product_id,change_date)
IN 
(
    Select product_id, max(change_date)
    from Products
    where change_date <='2019-08-16'
    group by product_id
)

UNION 

select product_id, 10 as price
from Products
where (Product_id)
NOT IN 
(
    Select product_id
    from Products
    where change_date <='2019-08-16'
    group by product_id
)

