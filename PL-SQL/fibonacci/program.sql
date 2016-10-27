declare

ct number;
p number;
x number;
y number;
z number;

cursor my_cursor is select * from fibo;
temp my_cursor % rowtype;

BEGIN

    /*  SET SERVEROUTPUT ON;*/   
    /*  USE THE ABOVE COMMAND TO SEE OUTPUT; */     
    open my_cursor;
    
    LOOP
    
    fetch my_cursor into temp;
    exit when my_cursor % notfound ;
    
    select num into p from fibo where num = temp.num;
    dbms_output.put_line(p);    
    
    end loop;
    
    close my_cursor; 
    
    DELETE FROM fibo_output;
    ct := 3;
    x := 1;
    y := 1;
    insert into fibo_output values(1,1);
    insert into fibo_output values(2,1);
     
    while ct <= P LOOP
          
          z := x + y;
          
          insert into fibo_output values(ct,z);
          x := y;
          y := z; 
          
          ct := ct +1;
    
    
    
    END LOOP;  


    dbms_output.put_line('THE '||P||'TH FIBONACCI NUMBER IS '||z);


END;