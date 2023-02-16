SELECT author, title, amount AS Количество FROM book WHERE price < 750ORDER BY 1, 3 DESC;

SELECT title FROM book WHERE title LIKE 'Б%';

/*SELECT amount FROM book GROUP BY amount;*/
SELECT DISTINCT amount FROM book;

SELECT title, author FROM book WHERE (title LIKE '_% %') AND (author LIKE '%С.%') ORDER BY title;

SELECT author FROM book GROUP BY author;

SELECT author, sum(amount), count(amount) FROM book GROUP BY author;