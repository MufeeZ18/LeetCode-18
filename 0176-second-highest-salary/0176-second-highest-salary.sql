# Write your MySQL query statement below
SELECT
    -- Find the maximum salary that is smaller than the overall maximum salary
    MAX(salary) AS SecondHighestSalary
FROM Employee
WHERE salary < (
    -- Get the highest salary in the table
    SELECT MAX(salary)
    FROM Employee
);
