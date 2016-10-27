disp('evaluting the equation: fx=e^-x-x');
xi_1=input('Enter x_1: ');
xi=input('Enter x0: ');
iter=input('How many iteration: ');


i=1;
xiPlus1=0;

while i<=iter 
    
      x=xi_1;
      fxi_1=exp(-x)-x;
          
      x=xi;
      fxi=exp(-x)-x;       
          
      xiOld = xiPlus1;
      
      xiPlus1 = xi - ( (fxi*(xi_1-xi)) / (fxi_1-fxi) );
            
      %estimating error
      p= (xiPlus1 - xiOld)/xiPlus1;
      error = abs(p)*100; 
      %%%%%%%%%%%%%%%%%%%      
               
      fprintf('\nx%.0f=%f\nError=%f\n',i,xiPlus1,error);
      
      
      xi_1=xi;
      xi=xiPlus1;
      i=i+1;
   end