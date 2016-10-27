delete from square_output;
DECLARE
ans number;
p number;
cursor my_cursor is select * from square;
temp my_cursor % rowtype;

BEGIN

open my_cursor;
  LOOP
  fetch my_cursor into temp;
  exit when my_cursor % notfound;    
  select num into p from square where num = temp.num;  
    
  
  
  
  
  
   ans := p*p ;  
  
   
  dbms_output.put_line(p ||' '|| ans);
  insert into square_output values(p ,ans); 
  
  END LOOP;




close my_cursor;





END;