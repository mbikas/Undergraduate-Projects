package hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class help extends JFrame {
  JPanel jPanel1 = new JPanel();
  JLabel jLabel1 = new JLabel();
  JPanel jPanel2 = new JPanel();
  JButton req = new JButton();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextArea area = new JTextArea();
  JPanel jPanel3 = new JPanel();
  TitledBorder titledBorder1;
  JButton use = new JButton();
  JButton more = new JButton();
  JButton exit = new JButton();

  public help() {
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
    this.getContentPane().setBackground(new Color(173, 201, 139));
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setResizable(false);
    this.getContentPane().setLayout(null);
    jPanel1.setBackground(new Color(173, 201, 139));
    jPanel1.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel1.setBounds(new Rectangle(9, 15, 474, 40));
    jPanel1.setLayout(null);
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1.setText("HELP MENU");
    jLabel1.setBounds(new Rectangle(177, 5, 121, 27));
    jPanel2.setBackground(new Color(173, 201, 139));
    jPanel2.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel2.setDebugGraphicsOptions(0);
    jPanel2.setBounds(new Rectangle(9, 62, 183, 218));
    jPanel2.setLayout(null);
    req.setBackground(new Color(173, 201, 139));
    req.setBounds(new Rectangle(13, 26, 156, 34));
    req.setFont(new java.awt.Font("Dialog", 1, 12));
    req.setBorder(BorderFactory.createRaisedBevelBorder());
    req.setText("REQUIREMENT");
    req.addActionListener(new help_req_actionAdapter(this));
    jScrollPane1.setBounds(new Rectangle(199, 63, 281, 217));
    area.setBackground(new Color(173, 201, 139));
    area.setFont(new java.awt.Font("Dialog", 1, 13));
    area.setText("");
    jPanel3.setBackground(new Color(173, 201, 139));
    jPanel3.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel3.setBounds(new Rectangle(9, 291, 473, 43));
    jPanel3.setLayout(null);
    use.setText("HOW TO USE");
    use.addActionListener(new help_use_actionAdapter(this));
    use.setBorder(BorderFactory.createRaisedBevelBorder());
    use.setFont(new java.awt.Font("Dialog", 1, 12));
    use.setBounds(new Rectangle(12, 78, 156, 34));
    use.setBackground(new Color(173, 201, 139));
    more.addActionListener(new help_more_actionAdapter(this));
    more.setText("MORE");
    more.setBorder(BorderFactory.createRaisedBevelBorder());
    more.setFont(new java.awt.Font("Dialog", 1, 12));
    more.setBounds(new Rectangle(14, 138, 156, 34));
    more.setBackground(new Color(173, 201, 139));

    exit.setBackground(new Color(173, 201, 139));
    exit.setBounds(new Rectangle(145, 5, 148, 32));
    exit.setFont(new java.awt.Font("Dialog", 1, 12));
    exit.setBorder(BorderFactory.createRaisedBevelBorder());
    exit.setText("QUIT");
    exit.addActionListener(new help_exit_actionAdapter(this));
    this.getContentPane().add(jPanel1, null);
    jPanel1.add(jLabel1, null);
    this.getContentPane().add(jPanel2, null);
    jPanel2.add(req, null);
    jPanel2.add(use, null);
    jPanel2.add(more, null);
    this.getContentPane().add(jScrollPane1, null);
    this.getContentPane().add(jPanel3, null);
    jPanel3.add(exit, null);
    jScrollPane1.getViewport().add(area, null);
  }

  public static void main(String[] args) {
    help helps = new help();
  }


  void req_actionPerformed(ActionEvent e) {

    String info="";
    info+="1. JBuilder 10"+"\n";
    info+="2. Oracle 9i"+"\n";
    info+="3. JDK 1.5"+"\n";

    area.setText(info);

  }



  void use_actionPerformed(ActionEvent e) {
    String info="";

    info+="Software Initialization"+"\n";
    info+="-----------------------"+"\n";
    info += "To initialize this software you have to login\n";
    info += "as an Administrator.\n";
    info +="The you have to give the right name and password\n";
    info +="to access the main database."+"\n";

    info +="The to create all the table you have press the\n";
    info +="CREATE ALL\" button to create all the tables."+"\n";
    info+="Here you can also create new user and\n";
    info+=" directly access the database."+"\n\n";

    info+="Information Entry"+"\n";
    info+="-----------------"+"\n";
    info += "To entry data about patient,doctor,staff or supply\n";
    info += "you have to login as an user.\n";
    info += "You will get all those information in \"Data Entry\" menu.\n\n";



    info+="Search Information"+"\n";
    info+="------------------"+"\n";
    info += "You can get information about the patient,\n";
    info += "patient bill,doctor,stuff or supply\n";
    info += "You will get all those information in \"Search\" menu.\n\n";


    info+="Print Facility"+"\n";
    info+="------------------"+"\n";
    info += "Here you can also get all types of print facility\n\n";

    info += "For more information just read the readme file.\n\nThank You.\n";




    area.setText(info);


  }

  void more_actionPerformed(ActionEvent e) {
    String info="";
    info += "To know details just read" + "\n";
    info += "the \"README\" file attached" + "\n";
    info += "with the software." + "\n";
    info += "Thank You." + "\n";

    area.setText(info);

  }

  void exit_actionPerformed(ActionEvent e) {

    dispose();

  }


}

class help_req_actionAdapter implements java.awt.event.ActionListener {
  help adaptee;

  help_req_actionAdapter(help adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.req_actionPerformed(e);
  }
}

class help_use_actionAdapter implements java.awt.event.ActionListener {
  help adaptee;

  help_use_actionAdapter(help adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.use_actionPerformed(e);
  }
}

class help_more_actionAdapter implements java.awt.event.ActionListener {
  help adaptee;

  help_more_actionAdapter(help adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.more_actionPerformed(e);
  }
}

class help_exit_actionAdapter implements java.awt.event.ActionListener {
  help adaptee;

  help_exit_actionAdapter(help adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.exit_actionPerformed(e);
  }
}

