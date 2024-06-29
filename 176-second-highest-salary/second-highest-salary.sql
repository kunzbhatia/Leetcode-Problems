-- # Write your MySQL query statement below
-- select(select distinct salary 
-- from Employee 
-- order by salary desc
-- Limit 1 offset 1) as SecondHighestSalary

# Write your MySQL query statement below

SELECT  MAX(SALARY) AS SecondHighestSalary 
FROM EMPLOYEE WHERE SALARY <(SELECT MAX(SALARY) FROM EMPLOYEE);