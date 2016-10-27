package inventory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Help extends JFrame {
  JPanel jPanel1 = new JPanel();
  JLabel jLabel1 = new JLabel();
  JPanel jPanel2 = new JPanel();
  JButton req = new JButton();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextArea area = new JTextArea();
  JPanel jPanel3 = new JPanel();
  TitledBorder titledBorder1;
  JButton use = new JButton();
  JButton exit = new JButton();

  public Help() {
    try {
      jbInit();
      setSize(500,400);
      setLocation(110,60);
      show();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    titledBorder1 = new TitledBorder("");
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setForeground(Color.black);
    this.setResizable(false);
    this.getContentPane().setLayout(null);
    jPanel1.setBackground(SystemColor.control);
    jPanel1.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel1.setBounds(new Rectangle(9, 15, 474, 40));
    jPanel1.setLayout(null);
    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
    jLabel1.setForeground(Color.blue);
    jLabel1.setText("HELP MENU");
    jLabel1.setBounds(new Rectangle(177, 5, 85, 27));
    jPanel2.setBackground(SystemColor.control);
    jPanel2.setAlignmentY((float) 0.5);
    jPanel2.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel2.setDebugGraphicsOptions(0);
    jPanel2.setBounds(new Rectangle(9, 62, 183, 218));
    jPanel2.setLayout(null);
    req.setBackground(SystemColor.controlHighlight);
    req.setBounds(new Rectangle(13, 26, 156, 34));
    req.setFont(new java.awt.Font("Dialog", 1, 12));
    req.setAlignmentY((float) 0.5);
    req.setBorder(BorderFactory.createRaisedBevelBorder());
    req.setActionCommand("REQUIREMENT");
    req.setText("REQUIREMENT");
    req.addActionListener(new Help_req_actionAdapter(this));
    jScrollPane1.setBounds(new Rectangle(199, 63, 281, 217));
    area.setBackground(SystemColor.control);
    area.setFont(new java.awt.Font("Dialog", 1, 13));
    area.setEditable(false);
    area.setText("");
    jPanel3.setBackground(SystemColor.control);
    jPanel3.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel3.setBounds(new Rectangle(9, 291, 473, 43));
    jPanel3.setLayout(null);
    use.setText("HOW TO USE");
    use.addActionListener(new Help_use_actionAdapter(this));
    use.setBorder(BorderFactory.createRaisedBevelBorder());
    use.setFont(new java.awt.Font("Dialog", 1, 12));
    use.setBounds(new Rectangle(14, 105, 156, 34));
    use.setBackground(SystemColor.controlHighlight);

    exit.setBackground(SystemColor.controlHighlight);
    exit.setBounds(new Rectangle(145, 5, 148, 32));
    exit.setFont(new java.awt.Font("Dialog", 1, 12));
    exit.setBorder(BorderFactory.createRaisedBevelBorder());
    exit.setMnemonic('Q');
    exit.setText("QUIT");
    exit.addActionListener(new Help_exit_actionAdapter(this));
    this.getContentPane().add(jPanel1, null);
    jPanel1.add(jLabel1, null);
    this.getContentPane().add(jPanel2, null);
    jPanel2.add(req, null);
    jPanel2.add(use, null);
    this.getContentPane().add(jScrollPane1, null);
    this.getContentPane().add(jPanel3, null);
    jPanel3.add(exit, null);
    jScrollPane1.getViewport().add(area, null);
  }

  public static void main(String[] args) {
    Help Helps = new Help();
  }


  void req_actionPerformed(ActionEvent e) {

    String info="";
    info+="1. Apache2triad1.5.3.exe"+"\n";
    info+="3. JDK 1.5"+"\n";
    area.setText(info);

  }



  void use_actionPerformed(ActionEvent e) {
    String info="";


    info+="File Menu"+"\n";
    info+="-----------------"+"\n";
    info += "In the File Menu you will get the\n";
    info += "Data Entry , Adjust Items and Lc Input options.\n\n";

    info+="Search Menu"+"\n";
    info+="-----------------"+"\n";
    info += "In the Search Menu you will get the\n";
    info += "Search Items and Search LC Nooptions.\n";
    info += "In Search Items will get all sort of informations\n";
    info += "that you entered into the database.\n\n";

    info+="Administrator Menu"+"\n";
    info+="-----------------"+"\n";
    info += "You can Update or Delete all sort of informations\n";
    info += "stored in your database\n\n";

    info+="For More Details"+"\n";
    info+="You can directly contact with me."+"\n";
    info += "Contact no: 01911614279\n";
    info += "e-mail: bikasnd@yahoo.com\n";

    area.setText(info);


  }



  void exit_actionPerformed(ActionEvent e) {

    dispose();

  }


}

class Help_req_actionAdapter implements java.awt.event.ActionListener {
  Help adaptee;

  Help_req_actionAdapter(Help adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.req_actionPerformed(e);
  }
}

class Help_use_actionAdapter implements java.awt.event.ActionListener {
  Help adaptee;

  Help_use_actionAdapter(Help adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.use_actionPerformed(e);
  }
}

class Help_exit_actionAdapter implements java.awt.event.ActionListener {
  Help adaptee;

  Help_exit_actionAdapter(Help adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.exit_actionPerformed(e);
  }
}

