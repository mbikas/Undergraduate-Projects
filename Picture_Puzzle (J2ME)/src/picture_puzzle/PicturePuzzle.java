package picture_puzzle;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class PicturePuzzle extends MIDlet implements CommandListener{

  private Command exit, submit, cancel, help,inst_back,back,preview,last,diff_back;
  private List list,level,we,picture;
  public static Display display;
  private Form us, helpForm;
  private MyCanvas canvas;
  public static int diff=1;
  public static int pic=4,ind=1,w = 242,h = 295;
  private String previous=null;
  public static boolean first=true;


  public PicturePuzzle() {

    display = Display.getDisplay(this);
    canvas  = new MyCanvas(this);

    list = new List("Select One", List.IMPLICIT);
    level = new List("Difficulty", List.EXCLUSIVE);
    picture = new List("Choose Picture", List.IMPLICIT);
    we = new List("We", List.IMPLICIT);

    list.append("Play", null);
    list.append("Difficulty",null);
    list.append("Choose Picture",null);
    list.append("Instructions", null);
    list.append("About Us", null);
    list.append("Exit",null);

    level.append("Easy",null);
    level.append("Hard",null);

    picture.append("Eye",null);
    picture.append("Face",null);
    picture.append("Nature",null);
    picture.append("Tea Garden",null);
    picture.append("Clock",null);

    we.append("Bikas",null);
    we.append("Kingshuk",null);
    we.append("Rubel",null);

    exit = new Command("Exit", Command.EXIT, 0);
    submit = new Command("Ok", Command.SCREEN, 1);
    cancel = new Command("Back", Command.SCREEN, 1);
    help = new Command("Instructions", Command.SCREEN, 1);
    back = new Command("Back", Command.SCREEN, 1);
    preview = new Command("Preview", Command.SCREEN, 0);
    last = new Command("Back", Command.SCREEN, 1);
    diff_back = new Command("Back",Command.SCREEN,1);
    inst_back = new Command("Back",Command.SCREEN,1);


    list.addCommand(exit);
    list.addCommand(submit);
    list.setCommandListener(this);

    level.addCommand(diff_back);
    level.setCommandListener(this);

    picture.addCommand(back);
    picture.setCommandListener(this);


    we.addCommand(last);
    we.setCommandListener(this);
  }

  public void startApp() {
    display.setCurrent(list);
  }

  public void pauseApp() {
  }

  public void exitMIDlet() {

    destroyApp(true);
    notifyDestroyed();
  }
  public void new_win()
  {
    display.setCurrent(list);
  }
  public void return_game()
 {
   display.setCurrent(canvas);
 }

  public void destroyApp(boolean bool) {
  }

  public void commandAction(Command command, Displayable dis) {

    if(previous=="Choose Picture" && command==picture.SELECT_COMMAND)
    {
      String msg = picture.getString(picture.getSelectedIndex());
      previous = picture.getString(picture.getSelectedIndex());
      if (msg == "Eye" || msg == "Face" || msg == "Nature" || msg == "Tea Garden" ||
          msg == "Clock") {

        System.out.println(msg);
        ind = 2;
        Form prevw = new Form("Preview");
        Image images = null;
        try {

          int p = picture.getSelectedIndex();

          Image imag = null;

          if (p == 0)
          {
            imag = Image.createImage("/eye.PNG");
            images = Image.createImage(imag, 0, 0, w, h, 0);
            //images = Image.createImage("/eye.PNG");
          }
          else if (p == 1){
            imag = Image.createImage("/face.PNG");
            images = Image.createImage(imag, 0, 0, w, h, 0);
            //images = Image.createImage("/face.PNG");
          }
          else if (p == 2){
            imag = Image.createImage("/nature.PNG");
            images = Image.createImage(imag, 0, 0, w, h, 0);
            //images = Image.createImage("/nature.PNG");
          }
          else if (p == 3){
            //images = Image.createImage("/tea.PNG");
            imag = Image.createImage("/tea.PNG");
            images = Image.createImage(imag, 0, 0, w, h, 0);
          }
          else if (p==4){
            //images = Image.createImage("/clock.PNG");
            imag = Image.createImage("/clock.PNG");
            images = Image.createImage(imag, 0, 0, w, h, 0);
          }

          ImageItem imageItem = new ImageItem(null, images,
                                              ImageItem.LAYOUT_NEWLINE_BEFORE |
                                              ImageItem.LAYOUT_LEFT |
                                              ImageItem.LAYOUT_NEWLINE_AFTER,
                                              "My Image");
          prevw.append(imageItem);
        }
        catch (java.io.IOException error) {

        }
        prevw.addCommand(cancel);
        prevw.setCommandListener(this);
        display.setCurrent(prevw);
      }

    }

    if(previous == "About Us" && command == we.SELECT_COMMAND)
    {
      ind = 3;
      String msg = we.getString(we.getSelectedIndex());

      if (msg == "Bikas" || msg == "Kingshuk" || msg == "Rubel") {

        Form helpForm = new Form("Personal Informations");

        if (msg == "Bikas")
          helpForm.append(
              "Name: Md. Abu Naser Bikas\nReg. No: 2002331056\nSection: B\nMail: bikasbd@yahoo.com\nSUST\n");
        else if (msg == "Rubel")
            helpForm.append(
                "Name: Rubel\nReg. No: 2002331001\nSection: B\nSUST\n");
        else if (msg == "Kingshuk")
          helpForm.append(
              "Name: Janesar Azad\nReg. No: 2002331058\nSection: B\nSUST\n");

        helpForm.addCommand(cancel);

        helpForm.setCommandListener(this);
        display.setCurrent(helpForm);

      }
    }

    if (command == submit || command==list.SELECT_COMMAND) {

      String msg=null;

      previous = list.getString(list.getSelectedIndex());
      msg = list.getString(list.getSelectedIndex());

       if (msg == "About Us") {
         display.setCurrent(we);
      }
      if (msg == "Instructions") {

        helpForm = new Form("Help");
        helpForm.append(" Instruction  : \n * Press 8 or UP to Move the picture up\n * Press 2 or DOWN to Move the picture down\n * Press 4 or LEFT to Move the picture left\n * Press 6 or RIGHT to Move the picture right\n");
        //if(diff==1)
        helpForm.append("\n**In Easy mode you have to complete the puzzle within 100 moves.\n");
        //else if(diff==2)
        helpForm.append("\n**In hard mode you have to complete the puzzle within 300 moves.\n");
        helpForm.addCommand(inst_back);
        //helpForm.addCommand(exit);
        helpForm.setCommandListener(this);
        display.setCurrent(helpForm);
      }
      if (msg == "Play") {
        display.setCurrent(canvas);
      }
      if (msg == "Difficulty") {
       display.setCurrent(level);
     }
     if (msg == "Choose Picture") {
      display.setCurrent(picture);
    }
      if(msg=="Exit")
        exitMIDlet();

    }

    if(command==last || command == inst_back)
      display.setCurrent(list);


    if (command == cancel) {

      if(ind==3)
        display.setCurrent(we);
     else if(ind==2)
        display.setCurrent(picture);
      else
            display.setCurrent(list);
    }

    else if (command == exit) {
      exitMIDlet();
    }
    if(command==diff_back)
    {
      ind = 1;
      String msg = level.getString(level.getSelectedIndex());
      if (msg == "Easy") diff=1;
      if (msg == "Hard") diff = 2;
      display.setCurrent(list);

    }
    if (command == back) {
        ind=1;
        String msg = picture.getString(picture.getSelectedIndex());
        //System.out.println(msg);
        if (msg == "Eye")     pic = 1;
        if (msg == "Face")    pic = 2;
        if (msg == "Nature")  pic = 3;
        if (msg == "Tea Garden") pic = 4;
        if(msg == "Clock")      pic = 5;
        display.setCurrent(list);
    }

  }
}

class MyCanvas extends Canvas implements CommandListener
{
    private Command exit,back,preview,current_game;
    private PicturePuzzle game;
    byte box[][] = new byte[4][4];
    boolean finish = false,start;
    int move=0,preview_count=0;
    int diffs = PicturePuzzle.diff;
    Image image1;
    Image image[]=new Image[20];
    Image image_hard[]=new Image[20];

    public MyCanvas(PicturePuzzle game)
    {

        this.game = game;

        exit = new Command("Exit",Command.EXIT,0);
        back = new Command("Back",Command.SCREEN,1);
        preview = new Command("Preview",Command.EXIT,0);
        current_game = new Command("Back",Command.SCREEN,1);

        addCommand(preview);
        addCommand(back);
        setCommandListener(this);

        initialize();
    }

    protected void paint(Graphics g)
    {
      int p=0,q=0,x=0,y=0,m=0,n=0,i,j;

      game.w = getWidth();
      game.h = getHeight();

      if(PicturePuzzle.first)
      {
        PicturePuzzle.first = false;
        clip_picture(PicturePuzzle.pic);
      }
      if(PicturePuzzle.diff ==1)
      {
        if(move==0)box[2][2]=-1;
        if (move >= 100) {

          g.setColor(200, 200, 200);
          g.fillRect(0, 0, getWidth(), getHeight());

          g.setColor(0, 0, 255);
          g.drawString("You Lose",10,getHeight()/3, Graphics.TOP | Graphics.LEFT);
          g.drawString("You have exceeded 100 moves", 10,getHeight()/3+15,
                       Graphics.TOP | Graphics.LEFT);
          move = 0;
          return;

        }
        p = getWidth() / 3;
        q = getHeight() / 3;

        //filling rectangle
        g.setColor(200, 200, 200);
        g.fillRect(0, 0, getWidth(), getHeight());

        for (i = 0; i < 3; i++) {
          for (j = 0; j < 3; j++) {

            //System.out.println(j*p+" "+i*q);
            if (box[i][j] != -1)
              g.drawImage(image[box[i][j]], j * p, i * q,
                          Graphics.TOP | Graphics.LEFT);
            else if (box[i][j] == -1) {
              g.setColor(255, 255, 255);
              g.fillRect(j * p, i * q, j * p + p, j * q + q);
            }
          }
        }

        //drawing line
        g.setColor(255, 255, 255);
        g.drawLine(p, 0, p, (3 * q));
        g.drawLine( (2 * p), 0, (2 * p), (3 * q));
        g.drawLine(0, q, (3 * p), q);
        g.drawLine(0, (2 * q), (3 * p), (2 * q));

        finish = check_win();

        if (finish) {
          g.setColor(200, 200, 200);
          g.fillRect(0, 0, getWidth(), getHeight());

          g.setColor(0, 0, 255);

          if ( (PicturePuzzle.diff == 1 && move <= 50) ){
            g.drawString("Excellent Play", 10,getHeight()/3, Graphics.TOP | Graphics.LEFT);
            g.drawString("You Win", 10,getHeight()/3+15, Graphics.TOP | Graphics.LEFT);
            g.drawString("Total move = " + move + "",10,getHeight()/3+30,
                         Graphics.TOP | Graphics.LEFT);
          }
          else {
            g.drawString("You Win", 10,getHeight()/3, Graphics.TOP | Graphics.LEFT);
            g.drawString("Total move = " + move + "",10,getHeight()/3+15,
                         Graphics.TOP | Graphics.LEFT);
          }
          move=0;
        }

      }
      else//diff=2
      {
        if(move==0)box[3][3]=-1;
        if (move >=300) {
          g.setColor(200, 200, 200);
          g.fillRect(0, 0, getWidth(), getHeight());

          g.setColor(0, 0, 255);
          g.drawString("You Lose",10,getHeight()/3, Graphics.TOP | Graphics.LEFT);
          g.drawString("You have exceeded 100 moves", 10,getHeight()/3+15,
                       Graphics.TOP | Graphics.LEFT);
          move = 0;
          return;
        }

        p = getWidth() / 4;
        q = getHeight() / 4;

        //filling rectangle
        g.setColor(200, 200, 200);
        g.fillRect(0, 0, getWidth(), getHeight());

        for (i = 0; i < 4; i++) {
          for (j = 0; j < 4; j++) {

            //System.out.println(j*p+" "+i*q);
            if (box[i][j] != -1)
              g.drawImage(image_hard[box[i][j]], j * p, i * q,
                          Graphics.TOP | Graphics.LEFT);
            else if (box[i][j] == -1) {
              g.setColor(255, 255, 255);
              g.fillRect(j * p, i * q, j * p + p, j * q + q);
            }
          }
        }

        //drawing line
        g.setColor(255, 255, 255);
        g.drawLine(p, 0, p, (4 * q));
        g.drawLine( (2 * p), 0, (2 * p), (4 * q));
        g.drawLine( (3 * p), 0, (3 * p), (4 * q));
        g.drawLine(0, q, (4 * p), q);
        g.drawLine(0, (2 * q), (4 * p), (2 * q));
        g.drawLine(0, (3 * q), (4 * p), (3 * q));

        finish = check_win();

        if (finish) {

         g.setColor(200, 200, 200);
         g.fillRect(0, 0, getWidth(), getHeight());

         g.setColor(0, 0,255);

         if ( (PicturePuzzle.diff == 2 && move <= 200) ){
           g.drawString("Excellent Play", 10,getHeight()/3, Graphics.TOP | Graphics.LEFT);
           g.drawString("You Win", 10,getHeight()/3+15, Graphics.TOP | Graphics.LEFT);
           g.drawString("Total move = " + move + "", 10,getHeight()/3+30,
                        Graphics.TOP | Graphics.LEFT);
         }
         else {

           g.drawString("You Win", 10,getHeight()/3, Graphics.TOP | Graphics.LEFT);
           g.drawString("Total move = " + move + "", 10,getHeight()/3+15,
                        Graphics.TOP | Graphics.LEFT);
         }
         move=0;
       }

      }
    }

    void clip_picture(int val)
    {
      try {

       Image temp= null;
        int width = 0, height = 0, p = 0;
        if(val==1)
        {
          //image1 = Image.createImage("/eye.PNG");
          temp = Image.createImage("/eye.PNG");
          image1 = Image.createImage(temp,0,0,getWidth(),getHeight(),0);
        }
        if(val==2)
        {
          temp = Image.createImage("/face.PNG");
          image1 = Image.createImage(temp,0,0,getWidth(),getHeight(),0);
          //image1 = Image.createImage("/face.PNG");
        }
        if(val==3)
        {
          //image1 = Image.createImage("/nature.PNG");
          temp = Image.createImage("/nature.PNG");
          image1 = Image.createImage(temp, 0, 0, getWidth(), getHeight(), 0);
          //image1 = Image.createImage("/doel.PNG");
        }
       if(val==4)
       {
        // image1 = Image.createImage("/tea.PNG");
          temp = Image.createImage("/tea.PNG");
          image1 = Image.createImage(temp,0,0,getWidth(),getHeight(),0);
       }

       if(val==5)
       {
         //image1 = Image.createImage("/clock.PNG");
         temp = Image.createImage("/clock.PNG");
         image1 = Image.createImage(temp, 0, 0, getWidth(), getHeight(), 0);
       }


      if(PicturePuzzle.diff==1)
      {
        width = getWidth() / 3;
        height = getHeight() / 3;
        p = 1;
        for (int i = 0; i < 3; i++) {
          for (int j = 0; j < 3; j++) {
            image[p] = Image.createImage(image1, j * width, i * height, width,
                                         height, 0);
            p++;
          }
        }
      }
      else
      {
        width = getWidth() / 4;
        height = getHeight() / 4;
        p = 1;
        for (int i = 0; i < 4; i++) {
          for (int j = 0; j < 4; j++) {
            image_hard[p] = Image.createImage(image1, j * width, i * height,
                                              width,
                                              height, 0);
            p++;
          }
        }
      }

      }
      catch (Exception error) {
        Alert alert = new Alert("Failure", "Can't open Image File", null, null);
        alert.setTimeout(Alert.FOREVER);
        PicturePuzzle.display.setCurrent(alert);

      }
    }

    boolean check_win()
    {
      int p = 1;

      if (PicturePuzzle.diff == 1) {
        for (int i = 0; i < 2; i++)
          for (int j = 0; j < 3; j++) {
            if (box[i][j] != p)
              return false;
            p++;
          }
        for (int i = 0; i < 2; i++) {
          if (box[2][i] != p)
            return false;
          p++;
        }


        return true;
      }

      else
      {

        for (int i = 0; i < 3; i++)
          for (int j = 0; j < 4; j++) {
            if (box[i][j] != p)
              return false;
            p++;
          }
        for (int i = 0; i < 3; i++) {
          if (box[3][i] != p)
            return false;
          p++;
        }
        return true;
      }
    }

  void initialize()
  {
    box[0][0] = 6;
    box[0][1] = 7;
    box[0][2] = 1;
    box[0][3] = 9;
    box[1][0] = 2;
    box[1][1] = 8;
    box[1][2] = 3;
    box[1][3] = 10;
    box[2][0] = 5;
    box[2][1] = 4;
    box[2][2] = 15;
    box[2][3] = 11;
    box[3][0] = 13;
    box[3][1] = 12;
    box[3][2] = 14;
    box[3][3] = -1;

    PicturePuzzle.first =true;
    finish = false;
    move = 0;
  }


  public void commandAction(Command command, Displayable displayable) {
    if(command==exit)
                  game.exitMIDlet();

    if (command == current_game)
            game.return_game();


    if(command==back)
    {

         initialize();
         move=0;
         preview_count=0;



      game.new_win();
    }
   if(command==preview)
   {

     int n=0;
     n = PicturePuzzle.pic;
     Image images=null;

     Form f = new Form("Preview");
     try {
       Image imag=null;
       if(n==1)
       {
         //images = Image.createImage("/eye.PNG");
         imag = Image.createImage("/eye.PNG");
         images = Image.createImage(imag, 0, 0, getWidth(), getHeight(), 0);
       }
       if(n==2)
       {
         //images = Image.createImage("/face.PNG");
         imag = Image.createImage("/face.PNG");
         images = Image.createImage(imag, 0, 0, getWidth(), getHeight(), 0);
       }
       if(n==3)
       {
         imag = Image.createImage("/nature.PNG");
         images = Image.createImage(imag, 0, 0, getWidth(), getHeight(), 0);
       }
       if(n==4)
       {
         imag = Image.createImage("/tea.PNG");
         images = Image.createImage(imag, 0, 0, getWidth(), getHeight(), 0);
       }
       if(n==5)
       {

         imag = Image.createImage("/clock.PNG");
         images = Image.createImage(imag, 0, 0, getWidth(), getHeight(), 0);
       }
       ImageItem imageItem = new ImageItem(null, images,
                                           ImageItem.LAYOUT_NEWLINE_BEFORE |
                                           ImageItem.LAYOUT_LEFT |
                                           ImageItem.LAYOUT_NEWLINE_AFTER,
                                           "My Image");
       f.append(imageItem);

     }
     catch (java.io.IOException error) {


     }

     f.addCommand(current_game);
     f.setCommandListener(this);
     PicturePuzzle.display.setCurrent(f);

   }



  }

  protected void keyPressed(int key){

    int row = 0, col = 0, c_row = 0, c_col = 0;

    if(PicturePuzzle.diff ==1)
    {

      for (int i = 0; i < 3; i++)
        for (int j = 0; j < 3; j++) {
          if (box[i][j] == -1) {
            row = i;
            col = j;
            break;
          }
        }
    }
    else if(PicturePuzzle.diff ==2)
    {

      for (int i = 0; i < 4; i++)
        for (int j = 0; j < 4; j++) {
          if (box[i][j] == -1) {
            row = i;
            col = j;
            break;
          }
        }
    }

    switch(getGameAction(key)){
        //left button
        case Canvas.LEFT :
                       c_row = row;
                       c_col = col+1;
                       if( (PicturePuzzle.diff ==1 && c_col<=2) || (PicturePuzzle.diff ==2 && c_col<=3) )
                       {
                         box[row][col] = box[c_row][c_col];
                         box[c_row][c_col] = -1;
                         move++;
                       }
                       break;
        //right button
        case Canvas.RIGHT:
                       c_row = row;
                       c_col = col - 1;
                       if( (PicturePuzzle.diff ==1 && c_col>=0) || (PicturePuzzle.diff ==2 && c_col>=0) )
                       {
                         box[row][col] = box[c_row][c_col];
                         box[c_row][c_col] = -1;
                         move++;
                       }
                       break;
        //up button
        case Canvas.UP:
                       c_row = row+1;
                       c_col = col;
                       if( (PicturePuzzle.diff ==1 && c_row<=2) || (PicturePuzzle.diff ==2 && c_row<=3) )
                       {
                         box[row][col] = box[c_row][c_col];
                         box[c_row][c_col] = -1;
                         move++;
                       }
                       break;
       //down button
       case Canvas.DOWN:
                         c_row = row - 1;
                         c_col = col;
                         if( (PicturePuzzle.diff ==1 && c_row>=0) || (PicturePuzzle.diff ==2 && c_row>=0) )
                         {
                           box[row][col] = box[c_row][c_col];
                           box[c_row][c_col] = -1;
                           move++;
                         }
                         break;

      }



      repaint();


    }
}





