# Write your MySQL query statement below

Select 'Low Salary' as Category,
sum(if(income<20000,1,0)) as accounts_count
from accounts

UNION


Select 'Average Salary' as Category,
sum(if(income BETWEEN 20000 and 50000,1,0)) as accounts_count
from accounts

UNION

Select 'High Salary' as Category,
sum(if(income>50000,1,0)) as accounts_count
from accounts