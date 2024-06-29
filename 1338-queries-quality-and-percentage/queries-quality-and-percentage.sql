# Write your MySQL query statement below


Select query_name ,

round(AVG(rating/position),2) as quality,
round(AVG(IF(rating < 3, 1, 0)) * 100,2) AS poor_query_percentage

from queries 
where query_name is NOT NULL
group by query_name;

-- SELECT 
--     query_name, 
--     AVG(rating / position) AS quality,
--     AVG(IF(rating < 3, 1, 0)) * 100 AS poor_query_percentage
-- FROM 
--     queries 
-- GROUP BY 
--     query_name;