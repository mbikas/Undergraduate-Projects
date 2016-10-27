create table series(num number);
create table series_output(num number,series number);

DECLARE
i number;

BEGIN

for i in 1..10 LOOP
insert into series values(i);
END LOOP;


END;