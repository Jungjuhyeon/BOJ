SELECT 
    I.item_id,
    I.item_name,
    I.rarity
FROM 
    item_info  I
JOIN 
    item_tree  T ON I.item_id = T.item_id
JOIN 
    item_info  P ON T.parent_item_id = P.item_id
WHERE
    P.rarity = 'RARE'
ORDER BY
    I.item_id DESC;