create table even_odd(num number);
create table even_odd_output(num number,even_odd varchar(10));

DECLARE
i number;

BEGIN

for i in 1..10 LOOP
insert into even_odd values(i);
END LOOP;


END;