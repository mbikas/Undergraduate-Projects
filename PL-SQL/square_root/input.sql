create table square_root(num number);
create table square_root_output(num number,square_root number);

DECLARE
i number;

BEGIN

for i in 1..50 LOOP
insert into square_root values(i);
END LOOP;


END;