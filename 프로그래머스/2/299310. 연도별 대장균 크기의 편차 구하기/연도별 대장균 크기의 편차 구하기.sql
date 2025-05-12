SELECT YEAR(DIFFERENTIATION_DATE) AS YEAR,
        (MAX-SIZE_OF_COLONY) as YEAR_DEV,
        ID
FROM (
    SELECT *,
            MAX(SIZE_OF_COLONY) OVER(PARTITION BY YEAR(DIFFERENTIATION_DATE)) AS MAX
    FROM ECOLI_DATA
)as a
ORDER BY 1,2















# SELECT 
#     YEAR(differentiation_date) year,
#     (year_max - size_of_colony) year_dev,
#     id
# FROM 
#     (SELECT 
#         *,
#         MAX(size_of_colony) OVER (PARTITION BY YEAR(differentiation_date)) year_max
#     FROM
#         ecoli_data) t
# ORDER BY
#     1, 2;