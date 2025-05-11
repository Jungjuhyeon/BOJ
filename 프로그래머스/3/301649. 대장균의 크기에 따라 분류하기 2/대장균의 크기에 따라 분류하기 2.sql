SELECT ID,
        CASE
        WHEN size = 1 THEN 'CRITICAL'
        WHEN size = 2 THEN 'HIGH'
        WHEN size = 3 THEN 'MEDIUM'
        ELSE 'LOW'
        END AS COLONY_NAME
FROM (
    SELECT ID,
            # SIZE_OF_COLONY,
            NTILE(4) OVER(ORDER BY SIZE_OF_COLONY DESC) AS size
    FROM ECOLI_DATA
) as ranked
ORDER BY ID ASC















# SELECT ID, 
#         CASE WHEN SizeRank = 1 THEN 'CRITICAL'
#              WHEN SizeRank = 2 THEN 'HIGH'
#              WHEN SizeRank = 3 THEN 'MEDIUM'
#              ELSE 'LOW'
#              END AS COLONY_NAME
# FROM (
#     SELECT ID,
#             SIZE_OF_COLONY,
#             NTILE(4) OVER(ORDER BY SIZE_OF_COLONY DESC) AS SizeRank
#     FROM ECOLI_DATA
# )AS rankDATA
# ORDER BY ID ASC;