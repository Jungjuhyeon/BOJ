SELECT SUM(g.SCORE) AS SCORE,
        em.EMP_NO,
        em.EMP_NAME,
        em.POSITION,
        em.EMAIL
FROM HR_EMPLOYEES AS em
JOIN HR_GRADE AS g ON em.EMP_NO = g.EMP_NO
JOIN HR_DEPARTMENT AS d ON em.DEPT_ID = d.DEPT_ID 
GROUP BY em.EMP_NO
ORDER BY SCORE DESC
LIMIT 1


















# -- 코드를 작성해주세요
# SELECT SUM(SCORE) as SCORE,
#         he.EMP_NO,
#         he.EMP_NAME,
#         he.POSITION,
#         he.EMAIL
# FROM HR_EMPLOYEES AS he 
# LEFT JOIN  HR_GRADE AS hg
# ON he.EMP_NO = hg.EMP_NO
# GROUP BY he.EMP_NO
# ORDER BY SCORE DESC
# LIMIT 1