-- 코드를 입력하세요
SELECT INGREDIENT_TYPE,
        SUM(TOTAL_ORDER)
FROM FIRST_HALF fh INNER JOIN ICECREAM_INFO ii
on fh.FLAVOR = ii.FLAVOR
GROUP BY INGREDIENT_TYPE