x = input('Enter the value of x: ');
oldX=x;
fx=log(x);


err=1;

while err>0

      x0= input('Give lower limit: ');
      x1= input('Give upper limit: ');

      x=x0;
      fx0 = log(x);

      x=x1;
      fx1 = log(x);

      f1x = (fx0 + ((fx1-fx0)/(x1-x0)) * (oldX-x0));
      error = ((fx-f1x)/fx)*100;

      fprintf('error=%f\n',real(error));

      err = input('want to quit? if yes give value less than zero :  ');

      if (err <0)
        disp('Thanks for using this program...Bikas');
        break;
      end

end

