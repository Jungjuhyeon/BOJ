SELECT p.ID AS ID,
        COUNT(c.ID) AS CHILD_COUNT
FROM ECOLI_DATA as p
LEFT JOIN ECOLI_DATA as c
ON p.ID = c.PARENT_ID
GROUP BY p.ID
ORDER BY p.ID


# SELECT child.ID AS ID,
#         count(parent.parent_id) as child_count
# FROM ECOLI_DATA AS child 
# LEFT JOIN ECOLI_DATA AS parent 
# ON child.ID = parent.PARENT_ID
# group by 1
# order by 1