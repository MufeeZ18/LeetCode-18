# Write your MySQL query statement below
SELECT 
    name,         -- return country name
    population,   -- return population
    area          -- return area
FROM World
WHERE 
    area >= 3000000      -- condition 1: area is at least 3 million
    OR
    population >= 25000000; -- condition 2: population is at least 25 million
