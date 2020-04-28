--https://www.hackerrank.com/challenges/draw-the-triangle-2/problem

SET @number = 0;
select REPEAT('* ', @number := @number+1) FROM information_schema.tables LIMIT 20;