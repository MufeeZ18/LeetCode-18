# Write your MySQL query statement below
SELECT 
    eu.unique_id,      -- Get the unique identifier if it exists
    e.name             -- Get the employee's name
FROM Employees e       -- Start with all employees
LEFT JOIN EmployeeUNI eu   -- Join with EmployeeUNI to find matching unique IDs
ON e.id = eu.id;       -- Match rows using employee id
