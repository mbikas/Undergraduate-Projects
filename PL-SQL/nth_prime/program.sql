DECLARE

COUNT NUMBER;
FLAG NUMBER;
i NUMBER;
X nuMBER;
P numbER;
given number;
NUM NUMBER;

CURSOR my_cursor IS SELECT * FROM nth_prime;
temp my_cursor % ROWTYPE;


BEGIN

  OPEN my_cursor;

  LOOP
      FETCH my_cursor INTO temp;
      EXIT WHEN my_cursor % NOTFOUND;
      COUNT := temp.num;  
  END Loop;
  
  CLOSE my_cursor;
  
     
      select num into given from nth_prime where num = count;   
      dbms_output.put_line('count = '|| given);     
      delete from nth_prime_output;   
 
  
    P := 1;
    NUM := 2;
     
    WHILE P <= given   LOOP
    
            FLAG :=1 ;
            X := SQRT ( NUM );
            FOR i IN 2..X LOOP
                    IF NUM MOD i =0 THEN
                    FLAG := 0;
                    END IF;
            END LOOP;
      
     
            IF FLAG = 1 THEN 
                INSERT INTO nth_prime_output VALUES ( P,NUM);
                P := P+1;
                X := NUM;
            END IF;
    
            NUM := NUM+1;  
    
    
     END LOOP;
     
     dbms_output.put_line('The '||given||'th prime Number is '||X);
     
     

  


END;