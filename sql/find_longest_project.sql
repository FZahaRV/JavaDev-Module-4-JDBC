WITH ProjectsWithNames AS (
    SELECT
        ID,
        START_DATE,
        FINISH_DATE,
        DATEDIFF('MONTH', START_DATE, FINISH_DATE) AS MONTH_COUNT,
        'Project' || CHR(65 + (ID - 2)) AS NAME
    FROM project
)
SELECT NAME, MONTH_COUNT
FROM ProjectsWithNames
WHERE MONTH_COUNT = (
    SELECT MAX(MONTH_COUNT)
    FROM ProjectsWithNames
);
