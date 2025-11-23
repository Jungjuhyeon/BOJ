SELECT info.REST_ID,
       info.REST_NAME,
       info.FOOD_TYPE,
       info.FAVORITES,
       info.ADDRESS,
       ROUND(AVG(review.REVIEW_SCORE),2) AS SCORE
  FROM REST_INFO AS info
  JOIN REST_REVIEW as review
    ON info.REST_ID = review.REST_ID
GROUP BY info.REST_ID 
HAVING info.ADDRESS LIKE '서울%'
ORDER BY 6 DESC, 4 DESC













# SELECT ri.REST_ID,
#         ri.REST_NAME,
#         ri.FOOD_TYPE,
#         ri.FAVORITES,
#         ri.ADDRESS,
#         ROUND(AVG(rr.REVIEW_SCORE),2) as SCORE
# FROM REST_INFO AS ri
# JOIN REST_REVIEW AS rr
# ON ri.REST_ID = rr.REST_ID
# GROUP BY 1
# HAVING ri.ADDRESS LIKE '서울%'
# ORDER BY SCORE DESC, ri.FAVORITES DESC