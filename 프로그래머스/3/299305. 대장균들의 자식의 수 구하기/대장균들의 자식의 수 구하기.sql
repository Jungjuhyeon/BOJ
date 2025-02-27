-- 코드를 작성해주세요
SELECT child.ID AS ID,
        count(parent.parent_id) as child_count
FROM ECOLI_DATA AS child 
LEFT JOIN ECOLI_DATA AS parent 
ON child.ID = parent.PARENT_ID
group by 1
order by 1

