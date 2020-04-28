--https://www.hackerrank.com/challenges/weather-observation-station-5/
select city,length(city)  from station order by length(city) desc,city limit 1;
select city,length(city)  from station order by length(city),city limit 1;