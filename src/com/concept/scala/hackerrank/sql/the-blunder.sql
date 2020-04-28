--https://www.hackerrank.com/challenges/the-blunder/
select  round(avg(salary)) - round(avg(replace(salary,0,''))) from EMPLOYEES;