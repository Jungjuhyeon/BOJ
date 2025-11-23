SELECT ID,
       CASE
       WHEN SIZE = 1 THEN 'CRITICAL'
       WHEN SIZE = 2 THEN 'HIGH'
       WHEN SIZE = 3 THEN 'MEDIUM'
       ELSE 'LOW'
       END AS COLONY_NAME
FROM (
    SELECT
    ID,
    NTILE(4) OVER(ORDER BY SIZE_OF_COLONY DESC) AS SIZE
    FROM ECOLI_DATA
) AS p
ORDER BY ID












# # SELECT ID, 
# #         CASE WHEN SizeRank = 1 THEN 'CRITICAL'
# #              WHEN SizeRank = 2 THEN 'HIGH'
# #              WHEN SizeRank = 3 THEN 'MEDIUM'
# #              ELSE 'LOW'
# #              END AS COLONY_NAME
# # FROM (
# #     SELECT ID,
# #             SIZE_OF_COLONY,
# #             NTILE(4) OVER(ORDER BY SIZE_OF_COLONY DESC) AS SizeRank
# #     FROM ECOLI_DATA
# # )AS rankDATA
# # ORDER BY ID ASC;