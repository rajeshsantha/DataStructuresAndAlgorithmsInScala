--https://www.hackerrank.com/challenges/the-report/problem
select IF(g.grade>7, s.name, null),g.grade,s.marks FROM Students s, Grades g where s.marks between  g.Min_mark and g.max_mark order by grade desc, name;
