create table addition(num number);
create table addition_output(num number,series number);

DECLARE
i number;

BEGIN

for i in 1..10 LOOP
insert into addition values(i);
END LOOP;


END;