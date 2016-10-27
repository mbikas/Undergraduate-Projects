create table square(num number);
create table square_output(num number,square number);

DECLARE
i number;

BEGIN

for i in 1..50 LOOP
insert into square values(i);
END LOOP;


END;