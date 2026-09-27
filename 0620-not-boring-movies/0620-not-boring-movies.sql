# Write your MySQL query statement below
-- Return all columns for qualifying movies.
SELECT *
FROM Cinema
-- Keep odd IDs and exclude the exact description 'boring'.
WHERE id % 2 = 1
  AND description <> 'boring'
-- Show the highest-rated movies first.
ORDER BY rating DESC;
