-- 코드를 입력하세요
SELECT DATE_FORMAT(datetime, '%H') hour,
        COUNT(*) AS count
FROM ANIMAL_OUTS
WHERE DATE_FORMAT(datetime, '%H') BETWEEN 09 AND 19
GROUP BY
    1
ORDER BY
    1;


