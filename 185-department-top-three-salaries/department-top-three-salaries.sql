# Write your MySQL query statement below

#Approach one
-- Select d.name as department,e1.name as employee,e1.salary as salary

-- from Employee e1 join Department d

-- on e1.DepartmentId=d.Id

-- where 3> 
-- (
--     select count(distinct e2.salary)
--     from Employee E2
--     where e2.salary>e1.salary and e1.DepartmentId=e2.DepartmentId
-- )


#Approach two
SELECT 
    temp.department,
    temp.employee,
    temp.salary
FROM (
    SELECT 
        d.name AS Department,
        e.name AS Employee,
        e.salary AS Salary,
        DENSE_RANK() OVER (PARTITION BY d.name ORDER BY e.salary DESC) AS department_rank
    FROM 
    employee e
    LEFT JOIN 
    department d 
    ON e.departmentId = d.id
) AS temp

WHERE 
    temp.department_rank <= 3;

