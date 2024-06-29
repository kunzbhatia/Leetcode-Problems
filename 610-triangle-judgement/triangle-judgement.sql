# Write your MySQL query statement below


-- Select 
-- x , y , z , 

-- case when x+y>z and y+z>x and z+x>y then 'Yes' else 'No' end
-- as triangle

-- from triangle;

Select 
x , y , z , 
IF(x+y>z and y+z>x and z+x>y, "Yes", "No")
as triangle
from triangle;