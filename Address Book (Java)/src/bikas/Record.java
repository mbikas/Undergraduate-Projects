                  // Name   : Md Abu Naser Bikas
                  // Sec    : B
                  // Reg. No: 2002331056

package bikas;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Arrays;


public class Record extends JFrame
{

  private Container c;
  private JLabel label1,label2;
  private JTextField nameField;
  private Box box1,box2,box3;
  private JList  list;
  private JTextArea area;
  private JButton close;
  private String address[],names1[],names2[];

  int i,z=1;
  int totalName;

  public Record()
  {
    super("RECORDS");
    setSize(400,350);
    c=getContentPane();
    c.setLayout(new FlowLayout());
    c.setBackground(new Color(136,225,165));



    //***********************************************//
    //generation informations from the file
    if(Input.theFile.isFile())
      {
     try {


      FileReader fr = new FileReader(Input.theFile);
      BufferedReader br = new BufferedReader(fr);

      String s="";
      String temp="";
      while((temp = br.readLine()) != null)
       s=temp;


      char a[]=s.toCharArray();

      totalName=0;
      for(i=0;i<a.length;i++)
       {
         if(a[i]=='~')
          totalName++;
       }


      names1=new String[totalName];
      names2=new String[totalName];
      address=new String[totalName];


      totalName=0;



      //reading names and records in two arrays from the char array a[]//

      for(i=0;i<a.length;i++)
       {
         if(a[i]=='~')
           { i=i+1;
             String s1="";
             while(a[i]!='$')
             { s1=s1+a[i];
               i++;
             }

            names1[totalName]=s1;
            names2[totalName]=s1;
           }

         if(a[i]=='$')
           { i=i+1;
             String s2="";
             //s2=s2+"// Name=" +names1[totalName-1]+"\n";
             while(a[i]!='#')
             { if(a[i]=='%')
                s2=s2+"\n";

               else
                s2=s2+a[i];

               i++;
             }

              address[totalName]=s2;
           }

        totalName++;

      }//end of for loop



     Arrays.sort(names1);

   }//end 0f try


   catch(IOException ex)
    {
       System.out.print("Error="+ex.toString());
    }
  }

  else
     { names1=new String[0];
       z=0;

    }
  //***********************************************//


    //arranging the Container
    box1=Box.createVerticalBox();
    box2=Box.createVerticalBox();
    box3=Box.createHorizontalBox();

    label1=new JLabel("Name:");
    label1.setForeground(Color.blue);
    nameField=new JTextField(10);
    label2=new JLabel("Records");
    label2.setForeground(Color.blue);

    list=new JList(names1);
    list.setBackground(new Color(136,189,240));
    list.setForeground(Color.black);
    list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    list.setVisibleRowCount(11);
    list.setFixedCellHeight(18);
    list.setFixedCellWidth(135);
    list.setFont(new Font("sherif",Font.BOLD,13));

    area=new JTextArea(14,18);
    area.setLineWrap(true);
    area.setEditable(false);
    area.setFont(new Font("sherif",Font.BOLD,13));
    area.setBackground(new Color(136,189,240));
    area.setForeground(Color.black);
    if(z==0)
       area.setText("FILE NOT FOUND");
    else
       area.setText("Just Type\n   Or\nSelect a Name");


    close=new JButton("CLOSE");
    close.setBackground(new Color(136,225,165));
    close.setForeground(Color.blue);
    close.setMnemonic('C');
    close.setToolTipText("Press Alt+C");

    //adding components to boxes
    box1.add(label1);
    box1.add(nameField);
    box1.add(new JScrollPane(list));
    box2.add(label2);
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
    nameField.addActionListener(hand1);


    show();


  }

  private class Handler implements ListSelectionListener
   {

     public void valueChanged(ListSelectionEvent e )
      {

        String ss="";
        int pp=list.getSelectedIndex();
        ss=names1[pp];
        for(int x=0;x<names2.length;x++)
          {
            if( names2[x].equals( ss ))
            {
               area.setText(address[x]);
               break;
            }
          }//end of for loop



      }
  }//end of class Handler


 private class Handler1 implements ActionListener
   { public void actionPerformed(ActionEvent event )
     {
       if(event.getSource()==nameField)
       {
         if(z==0)
           area.setText("FILE NOT FOUND");
         else{
         int p=1;
         String check="";
         check=nameField.getText();
         System.out.print(check.length());
         for(int x=0;x<names2.length;x++)
          {
            if( names2[x].equals( check ))
            {  p=0;
               int y;
               for( y=0;y<names1.length;y++)
                {if( names1[y].equals(names2[x]))
                    break;
                }
               list.setSelectedIndex(y);
               area.setText(address[x]);
               break;
            }
          }//end of for loop

          if( p==1&&check.length()>0)
           {
             if(totalName==0)
               area.setText("List is EMPTY");
             else
             {
               area.setText(check+" not found");
               //*****************************//
               list.clearSelection();
             }
            }
          }
        }

       if(event.getSource()==close)
        dispose();

     }
   }//end of class Handler1


  public static void main(String[] args) {
    Record record1 = new Record();
  }
}