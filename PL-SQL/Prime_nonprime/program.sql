delete from prime_check_output;

DECLARE

p number;
flag number;
cursor my_cursor is select * from prime_check;
temp my_cursor % rowtype;

BEGIN

open my_cursor;
  LOOP
  fetch my_cursor into temp;
  exit when my_cursor % notfound;    
  select num into p from prime_check where num = temp.num;  
    
  dbms_output.put_line(p);  
  
  flag := 1;
  for i in 2.. sqrt(p) loop
    if p mod i =0 then
     flag := 0;
    end if;
  end loop;
  
  if flag = 1 AND p !=1 then
   insert into prime_check_output values (p,'Prime');
  else
   insert into prime_check_output values(p,'Not Prime');
     
  
  end if; 
  
             
 
  
  
  END LOOP;




close my_cursor;





END;