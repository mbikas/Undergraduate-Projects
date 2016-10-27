DECLARE

p number;
ans number;
i number;
cursor my_cursor is select * from fact;
temp my_cursor % rowtype;

BEGIN

open my_cursor;
  LOOP
  fetch my_cursor into temp;
  exit when my_cursor % notfound;    
  select num into p from fact where num = temp.num;  
  
  ans := 1;
  for i in 2..p loop
  ans := ans * i;
  end loop;
  
  dbms_output.put_line(p||' '||ans);
  insert into fact_output values(p,ans); 
  
  
  
  
  
  END LOOP;




close my_cursor;





END;