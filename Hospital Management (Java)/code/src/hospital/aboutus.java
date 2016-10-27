
package hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.lang.*;

public class aboutus extends JFrame {
  JLabel jLabel1 = new JLabel();
  Border border1;
  JButton ok = new JButton();
  JButton back = new JButton();
  TitledBorder titledBorder1;
  Icon icon = new ImageIcon("k.jpg");
  Icon icon1 = new ImageIcon("b.jpg");
  Icon icon2 = new ImageIcon("bikas1.jpg");
  JLabel Label1 = new JLabel();
  JLabel Label2 = new JLabel();

  String S1 = "Member1:\tBiplab Chandra sarker\n\tReg No: 2002331019 , CSE - (3/1)\n\tContact No : 01717567800\n\tmail : biplab_06@yahoo.com\n   Shahjalal University of Science & Technology ";
  String S2 = "Member2:\tMd. Abu Naser Bikas\n\tReg No: 2002331056 , CSE - (3/1)\n\tContact No : 0191614279\n\tmail : bikasbd@yahoo.com\n   Shahjalal University of Science & Technology ";
  String S3 = "Member3:\tJanesar Azad\n\tReg No: 2002331058 , CSE - (3/1)\n\tContact No : 01719147503\n\tmail : kingshuk058@gmail.com\n   Shahjalal University of Science & Technology";


  JTextArea area1 = new JTextArea();
  JTextArea area2 = new JTextArea();
  JTextArea area3 = new JTextArea();
  JLabel Label4 = new JLabel();
  JButton button_bikas = new JButton();

  public aboutus() {
    super("Information About the Developers....");
    Label1.setIcon(icon);
    try {
      jbInit();



      setSize(580,480);
      show();
      setLocation(100,80);



      Label1.setIcon(icon);


    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    border1 = BorderFactory.createLineBorder(Color.black,4);
    titledBorder1 = new TitledBorder("");
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 18));
    jLabel1.setForeground(Color.blue);
    jLabel1.setBorder(BorderFactory.createLoweredBevelBorder());
    jLabel1.setText("       DEVELOPER\'S INFORMATION");
    jLabel1.setBounds(new Rectangle(124, 19, 346, 40));
    this.getContentPane().setLayout(null);
    this.getContentPane().setBackground(new Color(173, 201, 139));
    this.setEnabled(true);
    this.setResizable(false);
    this.setTitle("ABOUT US");
    ok.setBounds(new Rectangle(286, 403, 89, 33));
    ok.setFont(new java.awt.Font("Dialog", 1, 13));
    ok.setBorder(BorderFactory.createRaisedBevelBorder());
    ok.setBackground(new Color(173, 201, 139));
    ok.setText("OK");
    ok.addActionListener(new About_Us_ok_actionAdapter(this));
    back.setBounds(new Rectangle(181, 401, 94, 35));
    back.setFont(new java.awt.Font("Dialog", 1, 13));
    back.setBorder(BorderFactory.createRaisedBevelBorder());
    back.setBackground(new Color(173, 201, 139));
    back.setText("<< Back");
    back.addActionListener(new About_Us_back_actionAdapter(this));
    Label1.setBorder(BorderFactory.createLoweredBevelBorder());
    Label1.setRequestFocusEnabled(false);
    Label1.setVerifyInputWhenFocusTarget(false);
    Label1.setBounds(new Rectangle(79, 287, 106, 104));
    //Label1.setIcon(icon);
    Label2.setFont(new java.awt.Font("Dialog", 1, 11));
    Label2.setBorder(BorderFactory.createLoweredBevelBorder());
    Label2.setRequestFocusEnabled(false);
    Label2.setVerifyInputWhenFocusTarget(false);
    //Label2.setText(S1);
    Label2.setBounds(new Rectangle(219, 71, 292, 318));
    area1.setBackground(new Color(173, 201, 139));
    area1.setFont(new java.awt.Font("Dialog", 1, 12));
    area1.setText(S1);
    area1.setEditable(false);
    area1.setBounds(new Rectangle(225, 80, 279, 90));
    area2.setBackground(new Color(173, 201, 139));
    area2.setFont(new java.awt.Font("Dialog", 1, 12));
    area2.setDisabledTextColor(Color.gray);
    area2.setText(S2);
    area2.setEditable(false);
    area2.setBounds(new Rectangle(224, 179, 280, 95));
    area3.setBackground(new Color(173, 201, 139));
    area3.setFont(new java.awt.Font("Dialog", 1, 12));
    area3.setText(S3);
    area3.setEditable(false);
    area3.setBounds(new Rectangle(225, 280, 280, 103));
    Label4.setBounds(new Rectangle(79, 78, 105, 100));
    Label4.setIcon(icon1);
    Label4.setVerifyInputWhenFocusTarget(false);
    Label4.setBorder(BorderFactory.createLoweredBevelBorder());
    Label4.setRequestFocusEnabled(false);



    button_bikas.setBounds(new Rectangle(78, 179, 107, 106));
    button_bikas.setText("");
    button_bikas.addActionListener(new aboutus_button_bikas_actionAdapter(this));
    button_bikas.setIcon(icon2);
    this.getContentPane().add(jLabel1, null);
    this.getContentPane().add(area1, null);
    this.getContentPane().add(area3, null);
    this.getContentPane().add(area2, null);
    this.getContentPane().add(Label4, null);
    this.getContentPane().add(Label2, null);
    this.getContentPane().add(back, null);
    this.getContentPane().add(ok, null);
    this.getContentPane().add(Label1, null);
    this.getContentPane().add(button_bikas, null);
  }

  public static void main(String[] args) {
    aboutus about_Us = new aboutus();
  }

  void ok_actionPerformed(ActionEvent e) {
  dispose();
  }

  void back_actionPerformed(ActionEvent e) {

    dispose();


  }

  void button_bikas_actionPerformed(ActionEvent e) {
    dispose();

    About_bikas frame1= new About_bikas();
  // Putting in the Center
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  Dimension frameSize = frame1.getSize();
  if (frameSize.height > screenSize.height) {
  frameSize.height = screenSize.height;
}
if (frameSize.width > screenSize.width) {
  frameSize.width = screenSize.width;
}
frame1.setLocation((screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2);
frame1.setVisible(true);


  }
}

class About_Us_ok_actionAdapter implements java.awt.event.ActionListener {
  aboutus adaptee;

  About_Us_ok_actionAdapter(aboutus adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.ok_actionPerformed(e);
  }
}

class About_Us_back_actionAdapter implements java.awt.event.ActionListener {
  aboutus adaptee;

  About_Us_back_actionAdapter(aboutus adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.back_actionPerformed(e);
  }
}

class aboutus_button_bikas_actionAdapter implements java.awt.event.ActionListener {
  aboutus adaptee;

  aboutus_button_bikas_actionAdapter(aboutus adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.button_bikas_actionPerformed(e);
  }
}
