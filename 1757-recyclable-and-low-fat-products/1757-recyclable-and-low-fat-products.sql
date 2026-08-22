# Write your MySQL query statement below
SELECT 
    product_id  -- Return only the product id
FROM Products
WHERE low_fats = 'Y'      -- Product must be low fat
  AND recyclable = 'Y';   -- Product must also be recyclable
