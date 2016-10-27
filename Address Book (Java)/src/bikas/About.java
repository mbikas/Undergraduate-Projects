                  // Name   : Md Abu Naser Bikas
                  // Sec    : B
                  // Reg. No: 2002331056

package bikas;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame
{
  Container c;
  private JLabel bangladesh,bikas;
  private JButton close;
  private JTextArea logo;
  Icon icon=new ImageIcon("bangladesh.gif");
  Icon icon1=new ImageIcon("bikas.jpg");

  String string="";

  public About()
  {
   super("About Me");
   c=getContentPane();
   c.setLayout(new FlowLayout()) ;
   c.setBackground(new Color(136,225,165));
   setSize(700,550);

   bangladesh=new JLabel(icon);
   bikas=new JLabel(icon1);

   string=string+"WELCOME\n\n#This Program is developed by:\n"+
              "\nMD ABU NASER BIKAS"+
              "\nB.Sc ENGINEERING IN COMPUTER SCIENCE"+
              "\nSHAHJALAL UNIVERSITY OF SCIENCE & TECHNOLOGY"+
              "\nSYLHET"+
              "\nBANGLADESH\n";
   string+="\n#To know More Details Contact with me\n"+
             "\nMy Mailing Address\n"+
             "\n411/1,WEST SHEWRAPARA,\nMIRPUR, DHAKA-1216"+
             "\nCONTACT NUMBER: 0177097890, 9016594"+
             "\nE-MAIL: bikasbd@yahoo.co.uk"+
             "\nBANGLADESH"+
             "\n\nThank You\nBikas";



   logo=new JTextArea(22,30);
   logo.setEditable(false);
   logo.setBackground(new Color(136,225,165));
   logo.setForeground(Color.black);
   logo.setFont(new Font("sherif",Font.BOLD,13));
   logo.setText(string);

   close=new JButton("CLOSE");
   close.setBackground(new Color(136,225,165));
   close.setForeground(Color.blue);
   close.setMnemonic('C');
   close.setToolTipText("Press Alt+C");

   //adding components to container
   c.add(bangladesh);
   c.add(logo);
   c.add(bikas);
   c.add(close);


   //associating Handler
   Handler hand=new Handler();
   close.addActionListener(hand);

   show();

  }


  private class Handler implements ActionListener
   { public void actionPerformed(ActionEvent event )
     {
       if(event.getSource()==close)
        dispose();
     }
   }//end of class Handler1



  public static void main(String[] args)
  {
    About About1 = new About();
  }
}