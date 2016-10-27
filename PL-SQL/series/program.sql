delete from series_output;
DECLARE
summation number;
i number;
p number;
cursor my_cursor is select * from series;
temp my_cursor % rowtype;

BEGIN

open my_cursor;
  LOOP
  fetch my_cursor into temp;
  exit when my_cursor % notfound;    
  select num into p from series where num = temp.num;  
    
  
  
  summation := 0;
  
  for i in 0..p loop
   summation := summation + p + i;
   
  end loop; 
   
  dbms_output.put_line(p ||' '|| summation);
  insert into series_output values(p ,summation); 
  
  END LOOP;




close my_cursor;





END;