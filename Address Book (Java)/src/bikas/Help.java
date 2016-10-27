                  // Name   : Md Abu Naser Bikas
                  // Sec    : B
                  // Reg. No: 2002331056

package bikas;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Help extends JFrame
{
  private Container c;
  private JLabel label1;
  private JButton close;
  private JList list;
  private JTextArea area;
  private Box box1,box2,box3;
  private String str[]={"How to use","what is it"};
  private String string[]=new String[2];

  public Help()
  {
   super("Need Help?");
   c=getContentPane();
   c.setLayout(new FlowLayout()) ;
   c.setBackground(new Color(136,225,165));
   setSize(470,400);

   box1=Box.createVerticalBox();
   box2=Box.createVerticalBox();
   box3=Box.createHorizontalBox();

   list=new JList(str);
   list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

   list.setBackground(new Color(136,189,240));
   list.setForeground(Color.black);
   list.setFixedCellHeight(15);
   list.setFixedCellWidth(130);
   list.setFont(new Font("sherif",Font.BOLD,13));

   label1=new JLabel("HELP???");
   label1.setForeground(Color.blue);
   area=new JTextArea(16,24);
   area.setLineWrap(true);
   area.setEditable(false);
   area.setBackground(new Color(136,189,240));
   area.setForeground(Color.black);
   area.setFont(new Font("sherif",Font.BOLD,13));

   close=new JButton("CLOSE");
   close.setBackground(new Color(136,225,165));
   close.setForeground(Color.blue);
   close.setMnemonic('C');
   close.setToolTipText("Press Alt+C");

   //adding components to boxes
   box1.add(label1);
   box1.add(new JScrollPane(list));
   box2.add(new JScrollPane(area));
   box3.add(close);

   //adding Boxed to Container
   c.add(box1);
   c.add(box2);
   c.add(box3);


   //associating Handler
   Handler hand=new Handler();
   list.addListSelectionListener(hand);
   Handler1 hand1=new Handler1();
   close.addActionListener(hand1);


  string[0]="#To Input Something select the Input from\nthe File Menu. "+
            "Then Fillup the input Form \nappropriately. "+
            "Then press the SAVE Button \nand "+
            "Your Given Informations will be autom-\natically stored in your Hard Disk "+
            "as a text\nDocument in  C:\\bikas.txt\n\n"+
            "#To see your Records open the Output Form\nfrom the File Menu. "+
            "For Your Details Type\nyour Name in the TextField "+
            " or select\nthe Name Displayed in the list.\n"+
            "Then Required Information will be Displayed\nin the Text Area"+
            "\n\nThank You\nBikas";

   string[1]="# This is an Address Book. By Using this you\ncan store "+
             "Informations about someone in\nyour hard Drive. "+
             "Then You can also see\nthe given informations in a relaxed time."+
             "\n\nThank You\nBikas";


   show();

  }

   private class Handler implements ListSelectionListener
   {
     public void valueChanged(ListSelectionEvent e )
      { area.setText(string[list.getSelectedIndex()]);
      }
   }//end of class Handler


  private class Handler1 implements ActionListener
   { public void actionPerformed(ActionEvent event )
     {
       if(event.getSource()==close)
        dispose();
     }
   }//end of class Handler1



  public static void main(String[] args)
  {
    Help help1 = new Help();
  }
}