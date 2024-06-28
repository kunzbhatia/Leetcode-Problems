# Write your MySQL query statement below
Select D.name as department,E1.name as employee,E1.salary as salary
from Employee E1 join Department d
on e1.DepartmentId=d.Id
where 3>(select count(distinct e2.salary)
        from Employee E2
            where e2.salary>e1.salary and e1.DepartmentId=e2.DepartmentId)

