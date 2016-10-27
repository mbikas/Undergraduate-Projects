DECLARE

p number;
cursor my_cursor is select * from even_odd;
temp my_cursor % rowtype;

BEGIN

open my_cursor;
  LOOP
  fetch my_cursor into temp;
  exit when my_cursor % notfound;    
  select num into p from even_odd where num = temp.num;  
    
  dbms_output.put_line(p);  
  
  if  p mod 2 = 0 then
     insert into even_odd_output values(p ,'even');
  else
     insert into even_odd_output values(p ,'odd');
   
  end if; 
  
  
  END LOOP;




close my_cursor;





END;