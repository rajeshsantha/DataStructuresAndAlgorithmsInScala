--https://www.hackerrank.com/challenges/african-cities/

select CITY.name from CITY JOIN COUNTRY
 on CITY.CountryCode = COUNTRY.Code WHERE CONTINENT = 'Africa';

