# Write your MySQL query statement below

SELECT 
    p.firstName,      -- get first name from Person table
    p.lastName,       -- get last name from Person table
    a.city,           -- get city from Address table
    a.state           -- get state from Address table
FROM Person p         -- start with Person table since all persons must appear
LEFT JOIN Address a   -- keep all persons even if address is missing
ON p.personId = a.personId; -- match rows using personId

