                  // Name   : Md Abu Naser Bikas
                  // Sec    : B
                  // Reg. No: 2002331056

package bikas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Arrays;

public class Input extends JFrame
{
  private JTextField nameField,eMailField,phoneField,mobileField;
  private JLabel nameLabel,districtLabel,emailLabel,telephoneLabel,mobileLabel,addressLabel;
  private JComboBox districtBox;
  private JTextArea addressArea;
  private JButton save,close;
  private Box box1,box2;
  private final String district[]={"","FENI","DHAKA","SYLHET","NOKHALI","BOGRA","MOYMENSING","FARIDPUR","MYMENSING",
                                   "DINAGPUR","RANGPUR","BARISAL","RAJSHASHI","KHULNA",

                                   };

  private Container c;
  private String informations="";
  public static File theFile=new File("addressBook.txt");



  public Input()
  {
  super("Input Box");

  //declaring Container and setting Layout
  c=getContentPane();
  c.setLayout(new FlowLayout());
  c.setBackground(new Color(136,225,165));

  //creating Box
  box1=Box.createVerticalBox();
  box2=Box.createVerticalBox();

  //declaring component for box1
  nameLabel=new JLabel("Name");
  Arrays.sort(district);
  districtLabel=new JLabel("District");
  emailLabel=new JLabel("Email Address");
  telephoneLabel=new JLabel("Telephone");
  mobileLabel=new JLabel("Mobile");
  nameField=new JTextField(15);
  eMailField=new JTextField(15);
  phoneField=new JTextField(15);
  mobileField=new JTextField(15);
  districtBox=new JComboBox(district);
  districtBox.setMaximumRowCount(5);


  //declaring component for box2
  addressLabel=new JLabel("Address");
  addressArea=new JTextArea(7,15);
  addressArea.getBorder();
  addressArea.setLineWrap(true);
  addressArea.setFont(new Font("Sherif",Font.BOLD,13));
  addressArea.setWrapStyleWord(true);
  save=new JButton("   SAVE");
  close=new JButton("CLOSE");
  save.setToolTipText("Press to Save Ur Informations in C:\\addressBook.txt");
  close.setToolTipText("Press Alt+C");


  districtBox.setBackground(Color.white);
  save.setBackground(new Color(136,225,165));
  close.setBackground(new Color(136,225,165));


  //setting the ForeGround color
  nameField.setFont(new Font("Sherif",Font.BOLD,13));
  eMailField.setFont(new Font("Sherif",Font.BOLD,13));
  phoneField.setFont(new Font("Sherif",Font.BOLD,13));
  mobileField.setFont(new Font("Sherif",Font.BOLD,13));
  districtBox.setToolTipText("Select Your District");
  addressArea.setToolTipText("Enter Your Address");

  nameField.setToolTipText("Enter Your Name");
  eMailField.setToolTipText("Enter Your Name");
  phoneField.setToolTipText("Enter Your Phone Number");
  mobileField.setToolTipText("Enter Your Mobile Number");


  //setting color of the levels
  nameLabel.setForeground(Color.blue);
  districtLabel.setForeground(Color.blue);
  emailLabel.setForeground(Color.blue);
  telephoneLabel.setForeground(Color.blue);
  mobileLabel.setForeground(Color.blue);
  addressLabel.setForeground(Color.blue);
  save.setForeground(Color.blue);
  close.setForeground(Color.blue);

  save.setMnemonic('S');
  close.setMnemonic('C');

  //adding components in box1
  box1.add(nameLabel);
  box1.add(nameField);
  box1.add(districtLabel);
  box1.add(districtBox);
  box1.add(emailLabel);
  box1.add(eMailField);
  box1.add(telephoneLabel);
  box1.add(phoneField);
  box1.add(mobileLabel);
  box1.add(mobileField);


  //adding components in box2
  box2.add(addressLabel);
  box2.add( new JScrollPane( addressArea ) );
  box2.add(save);
  box2.add(close);


  //adding box1 and box2 in the Container
  c.add(box1);
  c.add(box2);

  //declaring Handler Class and adding it to the components
  Handler handler=new Handler();
  save.addActionListener(handler);
  close.addActionListener(handler);


   setSize(390,300);
   show();

  }


  private class Handler implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
   {
   if(e.getSource()==save)
    {

     informations="~"+nameField.getText()+"$";
     int nameLength=informations.indexOf('$');

     if(nameLength<2)
       JOptionPane.showMessageDialog(null,"PLEASE ENTER YOUR NAME");

     else
     {

     String address=addressArea.getText();
     address=address.replace('\n','%');

     informations=informations+"District= "+district[districtBox.getSelectedIndex()];
     informations=informations+"%E-Mail= "+eMailField.getText();
     informations=informations+"%Phone= "+phoneField.getText();
     informations=informations+"%Mobile= "+mobileField.getText();
     informations=informations+"%Address= "+address+"#";

     try{
     boolean FMode=true;
     FileWriter fw=new FileWriter("addressBook.txt",FMode);
     BufferedWriter bw=new  BufferedWriter(fw);

     bw.write(informations);

     bw.flush();
     fw.flush();
     bw.close();
     fw.close();

     JOptionPane.showMessageDialog(null,"Your Informationtions has been successfully Saved\nBikas.");
     String stt=null;
     nameField.setText(stt);
     eMailField.setText(stt);
     phoneField.setText(stt);
     mobileField.setText(stt);
     addressArea.setText(stt);
     districtBox.setSelectedIndex(0);

    }//end of try block

    catch(IOException exp)
     {
      System.out.print("Error="+exp.toString());
     }//end of catch block

   }//end of else

  }//end of if


  if(e.getSource()==close)
      dispose();


  }//end of actionPerformed function
 }//end of Handler class


  public static void main(String[] args)
   {
   Input input1=new Input();
   input1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}