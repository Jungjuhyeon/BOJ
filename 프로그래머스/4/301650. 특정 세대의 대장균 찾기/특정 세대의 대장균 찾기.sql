WITH RECURSIVE rc AS(
    SELECT ID, PARENT_ID, 1 AS GEN
    FROM ECOLI_DATA
    WHERE PARENT_ID IS NULL
    
    UNION ALL 
    
    SELECT e.ID, e.PARENT_ID, rc.GEN+1 AS GEN
    FROM ECOLI_DATA as e
    JOIN rc ON rc.ID = e.PARENT_ID
)

SELECT ID
FROM rc
WHERE GEN = 3



















# SELECT third.ID
# FROM ECOLI_DATA as first
# LEFT JOIN ECOLI_DATA as second ON first.ID = second.PARENT_ID
# LEFT JOIN ECOLI_DATA as third ON second.ID = third.PARENT_ID
# WHERE first.PARENT_ID IS NULL AND second.ID IS NOT NULL AND third.ID IS NOT NULL
# ORDER BY third.ID ASC












