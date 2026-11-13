# Write your MySQL query statement below
SELECT
    user_id, -- Preserve the user's identifier.
    CONCAT(
        UPPER(LEFT(name, 1)),      -- Capitalize the first character.
        LOWER(SUBSTRING(name, 2))  -- Lowercase all remaining characters.
    ) AS name                     -- Keep the expected output column name.
FROM Users                        -- Read without modifying stored data.
ORDER BY user_id;                 -- Return users in ascending ID order.
