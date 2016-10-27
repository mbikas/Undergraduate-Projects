delete from even_odd_sum_output;
DECLARE
ans number;
i number;
p number;
cursor my_cursor is select * from even_odd_sum;
temp my_cursor % rowtype;

BEGIN

open my_cursor;
  LOOP
  fetch my_cursor into temp;
  exit when my_cursor % notfound;    
  select num into p from even_odd_sum where num = temp.num;  
    
  if p mod 2 =0 then
    i := 2;
  else
    i := 1;
  end if;   
  
  ans :=  0;
   
   while i<=p loop
    ans := ans + i;
    i := i+2;  
   end loop; 
   
  dbms_output.put_line(p ||' '|| ans);
  insert into even_odd_sum_output values(p ,ans); 
  
  END LOOP;




close my_cursor;





END;