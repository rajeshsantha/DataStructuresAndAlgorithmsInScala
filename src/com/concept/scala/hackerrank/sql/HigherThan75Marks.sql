--https://www.hackerrank.com/challenges/more-than-75-marks/

select name from STUDENTS where marks >75 order by substring(name,length(name)-2,3), id;