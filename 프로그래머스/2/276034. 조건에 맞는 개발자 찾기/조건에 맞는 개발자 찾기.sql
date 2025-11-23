# SELECT *
# FROM DEVELOPERS



SELECT d.ID,
       d.EMAIL,
       d.FIRST_NAME,
       d.LAST_NAME
FROM DEVELOPERS as d
WHERE (d.SKILL_CODE & (SELECT s.CODE FROM SKILLCODES as s WHERE s.NAME ='Python') != 0) 
   OR (d.SKILL_CODE & (SELECT s.CODE FROM SKILLCODES as s WHERE s.NAME ='C#') != 0) 
ORDER BY d.ID
        












# SELECT DISTINCT
#         ID,
#         EMAIL,
#         FIRST_NAME,
#         LAST_NAME
# FROM DEVELOPERS as d
# JOIN SKILLCODES as s
# ON d.SKILL_CODE & s.CODE = s.Code
# WHERE s.NAME = 'Python' OR s.NAME = 'C#'
# ORDER BY ID ASC








# SELECT
#     DISTINCT(id),
#     email,
#     first_name,
#     last_name
# FROM
#     developers d
#     JOIN skillcodes s
#     AND d.skill_code & s.code = s.code 
# ORDER BY
#     1