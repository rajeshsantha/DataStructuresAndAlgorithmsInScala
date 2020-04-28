--https://www.hackerrank.com/challenges/weather-observation-station-8
Select distinct city from station where substring(city,(length(city)),1) in ('a','e','i','o','u') and substring(city,1,1) in ('a','e','i','o','u') ;
