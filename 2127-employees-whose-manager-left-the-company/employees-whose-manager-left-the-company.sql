# Write your MySQL query statement below


Select e1.employee_id
from Employees e1
where salary<30000

and manager_id NOT IN (Select employee_id from Employees)
order by e1.employee_id;
