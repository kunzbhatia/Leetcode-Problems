# Write your MySQL query statement below


Select round(sum(tiv_2016),2) as tiv_2016

from insurance

where tiv_2015 in 
(
    Select tiv_2015
    from insurance
    group by tiv_2015
    having count(*)>1
)

and (lat,lon) IN

(
    Select lat,lon
    from insurance
    group by lat,lon
    having count(*)=1
)
