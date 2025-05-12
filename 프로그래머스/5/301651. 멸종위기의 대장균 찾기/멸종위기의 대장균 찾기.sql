WITH RECURSIVE rs AS(
    SELECT ID, PARENT_ID, 1 AS GEN
    FROM ECOLI_DATA
    WHERE PARENT_ID IS NULL
    
    UNION ALL 
    
    SELECT e.ID, e.PARENT_ID, rs.GEN+1 AS GEN
    FROM ECOLI_DATA as e
    JOIN rs ON rs.ID = e.PARENT_ID
) 

SELECT COUNT(*) AS COUNT ,
        fir.GEN as GENERATION
FROM rs as fir
LEFT JOIN rs as second ON fir.ID = second.PARENT_ID
WHERE second.ID IS NULL
GROUP BY fir.GEN















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