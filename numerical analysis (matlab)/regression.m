number=input('how many number: ');
X=input('Enter X(like [1 2 3 n])\n:' );
Y=input('Enter Y(like [1 2 3 n])\n:' );

xy=0;
xx=0;
x=0;
y=0;
st=0;
sr=0;
for i= 1:number
    xy= xy + (X(i)*Y(i));
    xx= xx + (X(i)*X(i));
    x= x + X(i);
    y= y + Y(i);
end

avgX = x/number;
avgY = y/number;

a1 = (  ((number*xy)-(x*y)) / ((number*xx)-(x*x)) );
a0 = avgY - ( a1* avgX );

for i= 1:number
    st = st + ( (Y(i)-avgY)^2 ) ;
    sr = sr + ( ( Y(i)-( a1*X(i) )- a0)^2 ); 
end

deviation = sqrt ( st/(number-1) );
error= sqrt( (st-sr)/st );




disp('The least square fit is:');
fprintf('y=%f+%fx\n',real(a0),real(a1) );
fprintf('Deviation=%f\nError=%f\n',real(deviation),real(error) );



