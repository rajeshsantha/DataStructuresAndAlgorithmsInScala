--https://www.hackerrank.com/challenges/asian-population/
select sum(CITY.population) from CITY INNER JOIN COUNTRY ON
CITY.CountryCode = COUNTRY.Code WHERE COUNTRY.CONTINENT ='Asia' ;