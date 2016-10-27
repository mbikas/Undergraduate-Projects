package tictactoe;


import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;


public class TicTacToe extends MIDlet implements CommandListener{
    public static Display display;
    public MyCanvas canvas;
    private Command exit,ok,back;
    public static List menu;
    public static boolean turn = true;



    public TicTacToe() {

         turn =true;
         display = Display.getDisplay(this);
         canvas = new MyCanvas(this);

        display = Display.getDisplay(this);
        canvas = new MyCanvas(this);

        menu = new List("Select", List.IMPLICIT);

        menu.append("Play", null);
        menu.append("Instructions", null);
        menu.append("About Me", null);
        menu.append("Exit", null);

        exit = new Command("Exit", Command.EXIT, 0);
        ok = new Command("Ok", Command.SCREEN, 1);
        back = new Command("Back", Command.SCREEN, 1);

        menu.addCommand(exit);
        menu.addCommand(ok);
        menu.setCommandListener(this);




    }

    public void startApp() {
        display.setCurrent(menu);
    }

    protected void pauseApp() {
    }

    protected void destroyApp(boolean con) {

      }

    public void new_win()
    {
      display.setCurrent(menu);
    }


    public void exitMidlet() {
        destroyApp(true);
        notifyDestroyed();
    }


    public void commandAction(Command command, Displayable dis) {

     if (command == ok || command==menu.SELECT_COMMAND) {

        int val = 0;

        val = menu.getSelectedIndex();

         if (val == 2) {

          Form us = new Form("Me");
          us.append("Name: Md. Abu Naser Bikas\nContact No: 01911614279\nE-Mail: bikasbd@yahoo.com\nBangladesh\n");
          us.addCommand(back);
          us.setCommandListener(this);
          display.setCurrent(us);


        }
        if (val == 1) {

          Form help = new Form("Instructions");
          help.append("Instructions  : \n * Use all numeric key (1 to 9) to make your turn\n * Each numeric key represents a rectangle(or box) of the game board\nKEY 1 represents first box, KEY 2 represents second box and so on ...\n * Simply hit the numeric key of your device Key-Pad to make your turn.");
          help.addCommand(back);
          help.setCommandListener(this);
          display.setCurrent(help);
        }
        if (val ==0) {
          display.setCurrent(canvas);
        }
        if (val == 3) {
          exitMidlet();
        }


      }
      if(command == exit)exitMidlet();

      if (command == back) {

          display.setCurrent(menu);
      }
  }





}
class MyCanvas extends Canvas implements CommandListener
{
    private Command exit,back;
    private TicTacToe play;
    public int b[][]=new int[3][3];
    Image image=null;

    public MyCanvas(TicTacToe play)
    {

        this.play = play;
        exit = new Command("Exit",Command.EXIT,0);
        back = new Command("Back",Command.SCREEN,1);

        initialize();
        addCommand(exit);
        addCommand(back);
        setCommandListener(this);
    }

    protected void paint(Graphics g)
    {
       int x=0,y=0,i=0,j=0,p,q;

       x= getWidth() / 3;
       y = getHeight() / 3;

       p = isGameOver();
       //p = 2 ; lose
       //p = 1 ; won
       //p=3;  draw

       if( p != -1){
         g.setColor(0, 0, 0);
         g.fillRect(0, 0, getWidth(), getHeight());
         g.setColor(250,250,250);
         if (p == 2){
           g.drawString("You Lose", x, y, Graphics.TOP | Graphics.LEFT);
           g.drawString("Better Luck Next Time", x, y+15, Graphics.TOP | Graphics.LEFT);
         }
         else if (p == 1) {
           g.setColor(250, 250,250);
           g.drawString("Congratulation", x, y, Graphics.TOP | Graphics.LEFT);
           g.drawString("You Win", x, y+15, Graphics.TOP | Graphics.LEFT);
        }
         else {
           g.setColor(250, 250, 250);
           g.drawString("Tight Contest", x, y, Graphics.TOP | Graphics.LEFT);
           g.drawString("Game is Draw", x, y+15, Graphics.TOP | Graphics.LEFT);
         }
     }

     else
     {



       //filling rectangle
       g.setColor(0,50,0);
       g.fillRect(0, 0, getWidth(), getHeight());

       //drawing line
       g.setColor(255, 255, 255);
       g.drawLine(x, 0, x, (3 * y));
       g.drawLine( (2 * x), 0, (2 * x), (3 * y));
       g.drawLine(0, y, (3 * x), y);
       g.drawLine(0, (2 * y), (3 * x), (2 * y));

       computer_move();

       p = x/4;
       q = y/4;

       for (i = 0; i < 3; i++)
         for (j = 0; j < 3; j++) {

           if (b[i][j] == 1) {
             g.setColor(255, 0,255);
             g.drawLine(j*x+p, i*y+q,(j + 1)*x-p, (i + 1)*y-q);
             g.drawLine((j + 1) * x-p, i * y+q, j * x+p, (i + 1) * y-q);
           }

           if (b[i][j] == -1) {
             g.setColor(0,255,0);
             g.drawArc(j*x+p,i*y+q,p*2,q*2,360,360);
           }
         }

     }

}







   void computer_move()
   {
     int i,j,row_sum,col_sum,r1,r2,c1,c2,diagonal_sum;

//     for(i=0;i<3;i++)
//     for(j=0;j<3;j++)
//     System.out.print(b[i][j]);
//     System.out.print("\n");


     if(play.turn == false){

       //try win
       for(i=0;i<3;i++){
         row_sum=0;
         col_sum=0;
         r1=r2=c1=c2=-1;

         for(j=0;j<3;j++){
           row_sum+=b[i][j];
           col_sum+=b[j][i];
           if(b[i][j]==0){
             r1 = i;
             c1 = j;
           }
           if(b[j][i]==0){
             r2 = j;
             c2 = i;
           }
         }//inner for
         if(row_sum==-2){
           b[r1][c1] = -1;
           play.turn = true;
           repaint();
           return;
         }
         if(col_sum==-2){b[r2][c2]=-1;
           play.turn = true;
           repaint();
           return;
         }
       }

       diagonal_sum=0;
       r1=c1=-1;
       for(i=0;i<3;i++)
        { diagonal_sum +=b[i][i];
          if(b[i][i]==0){
            r1=c1=i;
          }
        }
       if(diagonal_sum==-2){b[r1][c1]=-1;
         play.turn = true;
         repaint();
         return;
       }

       diagonal_sum = b[0][2]+b[1][1]+b[2][0];
       if(diagonal_sum==-2)
       { if(b[0][2]==0)b[0][2]=-1;
         else if(b[1][1]==0)b[1][1]=-1;
         else if(b[2][0]==0)b[2][0]=-1;
         play.turn = true;
         repaint();
         return;
       }


      //try check
      for(i=0;i<3;i++){
        row_sum=0;
        col_sum=0;
        r1=r2=c1=c2=-1;

        for(j=0;j<3;j++){
          row_sum+=b[i][j];
          col_sum+=b[j][i];
          if(b[i][j]==0){
            r1 = i;
            c1 = j;
          }
          if(b[j][i]==0){
            r2 = j;
            c2 = i;
          }
        }//inner for
        if(row_sum==2){b[r1][c1]=-1;
          play.turn = true;
          repaint();
          return;
        }
        if(col_sum==2){
          b[r2][c2] = -1;
          play.turn = true;
          repaint();
          return;
        }
      }

      diagonal_sum=0;
      r1=c1=-1;
      for(i=0;i<3;i++)
       { diagonal_sum +=b[i][i];
         if(b[i][i]==0){
           r1=c1=i;
         }
       }
      if(diagonal_sum==2){b[r1][c1]=-1;
        play.turn = true;
        repaint();
        return;
      }

      diagonal_sum = b[0][2]+b[1][1]+b[2][0];
      if(diagonal_sum==2)
      { if(b[0][2]==0)b[0][2]=-1;
        else if(b[1][1]==0)b[1][1]=-1;
        else if(b[2][0]==0)b[2][0]=-1;
        play.turn = true;
        repaint();
        return;
      }

      //place any where
      if (b[1][1] == 0)  {
        b[1][1] = -1;
        play.turn = true;
        repaint();
        return;
      }
      else {
        boolean n = true;
        for (i = 0; i < 3; i++) {
          for (j = 0; j < 3; j++) {
            if (b[i][j] == 0) {
              b[i][j] = -1;

              play.turn = true;
              n = false;
              break;
            }
          }
          if (n == false)break;

        }
        repaint();
      }

    }



 }

    int isGameOver()
    {
      boolean draw,row=true,col = true;
      int i,j,row_sum,col_sum;

      draw = true;
      for (i = 0; i < 3; i++) {
        row_sum = 0;
        col_sum = 0;
        for (j = 0; j < 3; j++) {
          row_sum += b[i][j];
          col_sum += b[j][i];
          if (b[i][j] == 0) draw = false;
        }
        if (row_sum == 3)return 1;
        if (col_sum == 3)return 1;
        if (row_sum == -3)return 2;
        if (col_sum == -3)return 2;
      }
      if (b[0][0] == 1 && b[1][1] == 1 && b[2][2] == 1)return 1;
      if (b[0][2] == 1 && b[1][1] == 1 && b[2][0] == 1)return 1;
      if (b[0][0] == -1 && b[1][1] == -1 && b[2][2] == -1)return 2;
      if (b[0][2] == -1 && b[1][1] == -1 && b[2][0] == -1)return 2;

      if (draw)return 3;
      return -1;
    }

    void initialize()
    {

      for(int i=0;i<3;i++)
       for(int j=0;j<3;j++){
         b[i][j]=0;
       }

     play.turn = true;
    }


    protected void keyPressed(int key){

    boolean t = play.turn;

    switch(key){
      case KEY_NUM1:
        if (t == true && b[0][0] == 0) {
          b[0][0] = 1;
          play.turn = false;
          break;
        }
      case KEY_NUM2:
        if (t == true && b[0][1] == 0) {
          b[0][1] = 1;
          play.turn = false;
          break;
        }
      case KEY_NUM3:
        if (t == true && b[0][2] == 0) {
          b[0][2] = 1;
          play.turn = false;
          break;
        }
      case KEY_NUM4:
        if (t == true && b[1][0] == 0) {
          b[1][0] = 1;
          play.turn = false;
          break;
        }
      case KEY_NUM5:
        if (t == true && b[1][1] == 0) {
          b[1][1] = 1;
          play.turn = false;
          break;
        }
      case KEY_NUM6:
        if (t == true && b[1][2] == 0) {
          b[1][2] = 1;
          play.turn = false;
          break;
        }

      case KEY_NUM7:
        if (t == true && b[2][0] == 0) {
          b[2][0] = 1;
          play.turn = false;
          break;
        }
      case KEY_NUM8:
        if (t == true && b[2][1] == 0) {
          b[2][1] = 1;
          play.turn = false;
          break;
        }
      case KEY_NUM9: if(t == true && b[2][2] == 0 ){
                     b[2][2] = 1;
                     play.turn = false;
                     break;
                   }

    }

    repaint();
  }




  public void commandAction(Command command, Displayable dis) {
    if(command==exit)
                 play.exitMidlet();
     if(command==back){
        initialize();
        Display.getDisplay(play).setCurrent(play.menu);

     }
   }


}
