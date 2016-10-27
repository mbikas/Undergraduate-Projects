create table prime_check(num number);
create table prime_check_output(num number,prime_nonprime varchar(15));

DECLARE
i number;

BEGIN

for i in 1..10 LOOP
insert into prime_check values(i);
END LOOP;


END;