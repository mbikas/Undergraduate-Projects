                  // Name   : Md Abu Naser Bikas
                  // Sec    : B
                  // Reg. No: 2002331056

package bikas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Final extends JFrame
{

 private JMenu file,help;
 private JMenuItem input,output,item3,item4,helpItem;
 private JLabel label,blood;
 private Icon icon=new ImageIcon("blood.gif");
 private Container c;

 public Final()
 {

  super("ADDRESS BOOK");


  c=getContentPane();

  c.setBackground(new Color(136,225,165));

  JMenuBar bar=new JMenuBar();
  setJMenuBar(bar);

  file=new JMenu("FILE");
  file.setMnemonic('F');
  help=new JMenu("HELP");
  help.setMnemonic('H');

  input=new JMenuItem("Input");
  output=new JMenuItem("OutPut");
  item3=new JMenuItem("Close");
  item4=new JMenuItem("About...");
  helpItem=new JMenuItem("Help");

  blood=new JLabel(icon);


  input.setMnemonic('I');
  output.setMnemonic('O');
  item3.setMnemonic('C');
  item4.setMnemonic('A');
  helpItem.setMnemonic('E');

  file.add(input);
  file.add(output);
  file.add(item3);
  help.add(helpItem);
  help.add(item4);

  bar.add(file);
  bar.add(help);

  file.setBackground(Color.pink);
  help.setBackground(Color.pink);
  bar.setBackground(Color.pink);
  input.setBackground(Color.pink);
  output.setBackground(Color.pink);
  item3.setBackground(Color.pink);
  item4.setBackground(Color.pink);
  helpItem.setBackground(Color.pink);

  file.setToolTipText("File Menu");
  file.addSeparator();
  help.setToolTipText("Help Menu");
  help.addSeparator();
  bar.setToolTipText("Menu Bar");


  Handler handler=new Handler();
  input.addActionListener(handler);
  output.addActionListener(handler);
  item3.addActionListener(handler);
  item4.addActionListener(handler);
  helpItem.addActionListener(handler);


  label=new JLabel("WELCOME TO BIKAS'S ADDRESS BOOK",SwingConstants.CENTER);
  label.setFont(new Font("Times new Roman",Font.BOLD,20));
  label.setForeground(Color.black);

  c.add(blood,BorderLayout.NORTH);

  c.add(label,BorderLayout.CENTER);

  setSize(800,580);
  show();
 }

 private class Handler implements ActionListener
 {
  public void actionPerformed(ActionEvent e)
  {
   if(e.getSource()==input)
     new Input();

   if(e.getSource()==output)
      new Record();

   if(e.getSource()==item3)
    {JOptionPane.showMessageDialog(null,"THANKS FOR USING THIS PROGRAM\n"+
                                        "BIKAS");
     System.exit(0);
    }
   if(e.getSource()==helpItem)
     new Help();

   if(e.getSource()==item4)
     new About();

  }//end of actionPerformed method

}//end of Handler class





 public static void main(String[] args)
  {
   Final application=new Final();
   application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }
}