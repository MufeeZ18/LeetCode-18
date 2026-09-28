# Write your MySQL query statement below
SELECT
    m.employee_id,                         -- Manager's ID
    m.name,                                -- Manager's name
    COUNT(e.employee_id) AS reports_count, -- Number of direct reports
    ROUND(AVG(e.age)) AS average_age       -- Rounded average report age
FROM Employees AS m                        -- Potential managers
JOIN Employees AS e                        -- Employees reporting to them
    ON e.reports_to = m.employee_id        -- Match each report to their manager
GROUP BY m.employee_id, m.name             -- One result row per manager
ORDER BY m.employee_id;                    -- Required output order
