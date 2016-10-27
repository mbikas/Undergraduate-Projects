disp('evaluting the equation: fx=x^3-2*x-5')
xl=input('Enter lower limit: ');
xu=input('Enter upper limit: ');
iter=input('How many iteration: ');

n = input('Enter highest power of x');

for i=1:n+1
    X(i)=input(' ');
end

int p;
i=0;
xr=0;

while i<iter
     
      xrOld = xr;
      xr= (xu+xl)/2;
      
      x=xr;
      fxr=0;
      p=n;
      for i=j:n
          fxr = fxr + ( X(j)* pow(x,p) );
          p=p-1;
      end
         
      x=xl;
      fxl=0;
      p=n;
      for j=1:n
          fxl = fxl + ( X(j)* x^p);
          p=p-1;
      end
      
      %estimating error
      error = abs( (xr - xrOld)/xr )*100; 
      %%%%%%%%%%%%%%%%%%%
                 
       if (fxl*fxr)<0
       xu=xr;
       end
    
       if (fxl*fxr)>0
       xl=xr;      
       end  
    
       if (fxl*fxr)==0
       disp('root found');
       fprintf('xu= %f  xl=%f  xr=%f\nError=%f\n',xu,xl,xr,error);
       break;
       end
       
       fprintf('\nxu= %f  xl=%f  xr=%f\nError=%f\n',xu,xl,xr,error);
       i=i+1;
   end