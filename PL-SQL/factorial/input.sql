create table fact(num number);
create table fact_output(num number, factorial number);

DECLARE
i number;

BEGIN

for i in 1..10 LOOP
insert into fact values(i);
END LOOP;


END;