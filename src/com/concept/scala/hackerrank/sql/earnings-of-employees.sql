--https://www.hackerrank.com/challenges/earnings-of-employees/
select (salary*months) as earning ,count(*) from employee group by earning order by earning desc limit 1;
