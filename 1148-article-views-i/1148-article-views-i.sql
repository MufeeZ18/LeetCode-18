# Write your MySQL query statement below
SELECT DISTINCT
    author_id AS id   -- return author_id with column name id
FROM Views
WHERE author_id = viewer_id   -- author viewed their own article
ORDER BY id ASC;   -- sort result in ascending order
