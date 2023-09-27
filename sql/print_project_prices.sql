WITH ProjectsWithNames AS (
    SELECT
        p.ID,
        'Project' || CHR(65 + (p.ID - 1)) AS NAME,
        SUM(w.SALARY) * TIMESTAMPDIFF(MONTH, p.START_DATE, p.FINISH_DATE) AS PRICE
    FROM project AS p
    INNER JOIN project_worker AS pw ON p.ID = pw.PROJECT_ID
    INNER JOIN worker AS w ON pw.WORKER_ID = w.ID
    GROUP BY p.ID, p.START_DATE, p.FINISH_DATE
)
SELECT
    NAME,
    PRICE
FROM ProjectsWithNames
ORDER BY PRICE DESC;