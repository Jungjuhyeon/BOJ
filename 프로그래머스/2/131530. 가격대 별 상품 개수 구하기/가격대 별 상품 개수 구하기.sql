-- 코드를 입력하세요
SELECT 
    TRUNCATE(price, -4) price_group,
    COUNT(product_id) products
FROM PRODUCT
GROUP BY
    1
ORDER BY
    1;

