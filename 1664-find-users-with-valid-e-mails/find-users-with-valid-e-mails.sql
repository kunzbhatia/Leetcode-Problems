# Write your MySQL query statement below

Select * from Users
where mail REGEXP '^[a-zA-Z][a-zA-Z0-9_.-]*@leetcode[.]com$' 