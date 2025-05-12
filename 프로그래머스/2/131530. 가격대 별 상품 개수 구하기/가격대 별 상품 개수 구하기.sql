SELECT FLOOR(price*0.0001)*10000 AS price_group,
        COUNT(*) AS PRODUCTS
FROM PRODUCT
GROUP BY price_group 
order by 1