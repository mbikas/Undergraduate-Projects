create table even_odd_sum(num number);
create table even_odd_sum_output(num number,even_odd_sum number);

DECLARE
i number;

BEGIN

for i in 1..10 LOOP
insert into even_odd_sum values(i);
END LOOP;


END;