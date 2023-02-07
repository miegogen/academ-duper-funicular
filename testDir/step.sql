SELECT author, title, amount AS Количество
FROM book
WHERE price < 750ORDER BY 1, 3 DESC;