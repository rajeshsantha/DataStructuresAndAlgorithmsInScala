--https://www.hackerrank.com/challenges/average-population-of-each-continent/

select COUNTRY.Continent,floor(avg(CITY.Population))
from COUNTRY join CITY
on CITY.CountryCode = COUNTRY.Code
group by COUNTRY.Continent