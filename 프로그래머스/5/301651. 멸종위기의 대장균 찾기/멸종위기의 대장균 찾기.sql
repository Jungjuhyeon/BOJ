WITH RECURSIVE rc AS(
    SELECT ID,
           PARENT_ID,
           1 AS gen
      FROM ECOLI_DATA
     WHERE PARENT_ID IS NULL
    
    UNION ALL
    
    SELECT e.id, e.parent_id, rc.gen+1 AS gen
    FROM ECOLI_DATA AS e
    JOIN rc ON rc.id = e.parent_id
)

SELECT COUNT(*) AS COUNT,
       r1.gen AS GENERATION
FROM rc AS r1 
LEFT JOIN rc AS r2
ON r1.ID = r2.PARENT_ID
WHERE r2.PARENT_ID IS NULL
GROUP BY 2
ORDER BY 2











# WITH RECURSIVE rc AS(
#     SELECT id,parent_id,1 AS gen
#     FROM ECOLI_DATA
#     WHERE PARENT_ID IS NULL
    
#     UNION ALL

#     SELECT e.id, e.parent_id, rc.gen+1 AS gen
#     FROM ECOLI_DATA AS e
#     JOIN rc ON rc.id = e.parent_id
# )
# # SELECT * FROM rc;

# SELECT COUNT(r1.gen) AS COUNT,
#         r1.gen AS GENERATION
# FROM rc AS r1 LEFT JOIN rc AS r2
# ON r1.id = r2.parent_id
# WHERE r2.parent_id IS NULL
# GROUP BY r1.gen
# ORDER BY r1.gen