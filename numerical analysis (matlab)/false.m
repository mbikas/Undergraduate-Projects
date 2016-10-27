disp('evaluting the equation: fx=x^3-2*x-5')
xl=input('Enter lower limit: ');
xu=input('Enter upper limit: ');
iter=input('How many iteration: ');

i=0;
xr=0;

while i<iter 
    
      x=xl;
      fxl=x^3-2*x-5;
          
      x=xu;
      fxu=x^3-2*x-5;      
          
      xrOld = xr;
      xr= xu-( (fxu*(xl-xu)) / (fxl-fxu) );
      
      x=xr;
      fxr=x^3-2*x-5;
      
      
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
       disp('root found\n');
       fprintf('\nxu= %f  xl=%f  xr=%f\nError=%f\n',xu,xl,xr,error);
       break;
       end
       
          
      fprintf('xu= %f  xl=%f  xr=%f\nError=%f\n',xu,xl,xr,error);
      i=i+1;
   end