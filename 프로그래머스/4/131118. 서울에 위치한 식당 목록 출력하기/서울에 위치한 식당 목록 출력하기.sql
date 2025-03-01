# SELECT *
# FROM REST_INFO AS ri LEFT JOIN REST_REVIEW AS rr
# ON ri.REST_ID = rr.REST_ID

SELECT ri.REST_ID,
        ri.REST_NAME,
        ri.FOOD_TYPE,
        ri.FAVORITES,
        ri.ADDRESS,
        ROUND(AVG(rr.REVIEW_SCORE),2) AS SCORE
FROM REST_INFO AS ri INNER JOIN REST_REVIEW AS rr
ON ri.REST_ID = rr.REST_ID
WHERE ri.ADDRESS LIKE '서울%'
GROUP BY ri.REST_NAME
ORDER BY SCORE DESC ,ri.FAVORITES DESC