
--create table Occupation(Name varchar,Occupation varchar);

--delete  from Occupation;

--insert into Occupation values ('Samantha','Doctor');
--insert into Occupation values ('Julia','Actor');
--insert into Occupation values ('Maria','Actor');
--insert into Occupation values ('Meera','Singer');
--insert into Occupation values ('Ashely','Professor');
--insert into Occupation values ('Ketty','Professor');
--insert into Occupation values ('Christeen','Professor');
--insert into Occupation values ('Jane','Actor');
--insert into Occupation values ('Jenny','Doctor');
--insert into Occupation values ('Priya','Singer');

--select name, Occupation from Occupation;

SET @r1=0, @r2=0, @r3 =0, @r4=0;
SELECT CASE Occupation WHEN 'Doctor' THEN @r1:=@r1+1
                       WHEN 'Professor' THEN @r2:=@r2+1
                       WHEN 'Singer' THEN @r3:=@r3+1
                       WHEN 'Actor' THEN @r4:=@r4+1 END
       AS RowLine,
       CASE WHEN Occupation = 'Doctor' THEN Name END AS Doctor,
       CASE WHEN Occupation = 'Professor' THEN Name END AS Professor,
       CASE WHEN Occupation = 'Singer' THEN Name END AS Singer,
       CASE WHEN Occupation = 'Actor' THEN Name END AS Actor
       FROM OCCUPATIONS ORDER BY Name