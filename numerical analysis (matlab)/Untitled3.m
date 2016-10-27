x = input('x= ');
xold=x;
fx=log(x);

int i;
i=1;
xr=0;
while i>0
     
    x0 = input('lower ');
    x1= input('upper ');
    
    x=x0;
    fx0 = log(x);
    x=x1;
    fx1 = log(x);   
    
   
    f1x = fx0 +(  ( (fx1-fx0)/(x1-x0) ) *(xold-x0));
    
    error = abs( (fx-f1x)/fx );
    error=error*100;
    
    fprintf('\napproximation=%f\nError=%f%%\n',f1x,error);
     
    i=input('quit?give less than 0 ') ;  
    
    
end