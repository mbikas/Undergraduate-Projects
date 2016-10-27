package bikas;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Output extends JFrame
{
  private Container c;
  private JLabel label1,label2,label3,label4;
  private Box box1,box2,box3;
  private JList  list=new JList();
  private JTextArea area;
  private JButton close;
  private String read,item;
  private String names[];
  private String address[];
  StringTokenizer token1,token2;
  int itemNumber,i;
  Vector vector = new Vector();



  public Output()
  {
   super("RECORDS");
    setSize(280,300);
    c=getContentPane();
    c.setLayout(new FlowLayout());

    //declaring JList
    list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    //list.setBounds(new Rectangle(10, 10, 120, 100));

    //generation informations from the file
     try {

      //FileReader fr = new FileReader("G:\\shoeb.txt");
      FileReader fr = new FileReader("F:\\bikas.txt");
      BufferedReader br = new BufferedReader(fr);

      while((read = br.readLine()) != null){
        token1 = new StringTokenizer(read,"$");
        itemNumber = token1.countTokens();
        names = new String[itemNumber];
        address = new String[itemNumber];
        for(i=0;i<itemNumber;i++){
          item = token1.nextToken();
          token2 = new StringTokenizer(item,"~");
          names[i] = token2.nextToken();
          address[i] = token2.nextToken();
          vector.add(names[i]);
          list.setListData(vector);
        }//end of while
      }//end of for


    }//end 0f try
    catch(IOException ex)
    {
       System.out.print("Error="+ex.toString());
    }


    box1=Box.createVerticalBox();
    box2=Box.createVerticalBox();
    box3=Box.createHorizontalBox();

    label1=new JLabel("Name:");
    label2=new JLabel("Records");

    area=new JTextArea(11,12);
    area.setLineWrap(true);
    area.setEditable(false);

    close=new JButton("CLOSE");

    //adding components to boxes
    box1.add(label1);
    box1.add(new JScrollPane(list));
    box2.add(label2);
    box2.add(new JScrollPane(area));
    box3.add(close);

    //adding Boxed to Container
    c.add(box1);
    c.add(box2);
    c.add(box3);


    Handler hand=new Handler();
    list.addListSelectionListener(hand);

    Handler1 hand1=new Handler1();
    close.addActionListener(hand1);


    show();

  }

  private class Handler implements ListSelectionListener
   { public void valueChanged(ListSelectionEvent e )
      {
       String s3="";
       String s1=address[list.getSelectedIndex()];
       char a[]=s1.toCharArray();
       for(int j=1;j<a.length;j++)
        {   if(a[j]=='#')
              s3=s3+"\n";
            else
              s3=s3+a[j];
         }

       area.setText(s3);

   // area.setText(address[list.getSelectedIndex()]);
    }//end of Method ActionPerformed
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
    Output output1 = new Output();
  }
}