SELECT DISTINCT a.email AS Email
FROM Person a
JOIN Person b
ON a.id < b.id AND a.email = b.email;