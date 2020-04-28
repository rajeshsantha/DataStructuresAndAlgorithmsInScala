--https://www.hackerrank.com/challenges/weather-observation-station-12

select distinct city from station where substring(city,(length(city)),1) not in ('a','e','i','o','u') and substring(city,1,1)not in ('a','e','i','o','u')