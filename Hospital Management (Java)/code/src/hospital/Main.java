
package hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Main extends JFrame {

  public static int status=0;
  static Connection connection;

  JLabel Hospital_phone = new JLabel();
  JLabel Hospital_name = new JLabel();
  JLabel Hospital_address = new JLabel();
  JLabel Hospital_web_address = new JLabel();
  JLabel User_name = new JLabel();
  JTextField username = new JTextField();
  JLabel jLabel1 = new JLabel();
  JPasswordField passwords = new JPasswordField();
  JButton jButton2 = new JButton();
  JButton Ok = new JButton();
  JLabel User_name1 = new JLabel();
  String type[]={"User","Doctor/Stuff","Administrator"};
  JComboBox combo = new JComboBox(type);

  public Main() {

    try {
      jbInit();
      setSize( 600,450);
      setLocation(100,90);
      show();

      status=0;

      DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
      String url = "jdbc:oracle:oci8:@";
      connection = DriverManager.getConnection(url, "system" , "manager" );



    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    Hospital_web_address.setFont(new java.awt.Font("Dialog", 1, 12));
    Hospital_web_address.setText("WEB: www.jrrmc.edu.bd      EMAIL: jrrmc@btsnet.net");
    Hospital_web_address.setBounds(new Rectangle(118, 61, 302, 15));
    Hospital_address.setFont(new java.awt.Font("Dialog", 1, 12));
    Hospital_address.setText("RAGIB-RABEYA MEDICAL COLLEGE ROAD, PATHANTULA, SYLHET. ");
    Hospital_address.setBounds(new Rectangle(107, 40, 377, 17));
    Hospital_name.setFont(new java.awt.Font("Dialog", 1, 18));
    Hospital_name.setForeground(SystemColor.desktop);
    Hospital_name.setText("JALALABAD RAGIB-RABEYA MEDICAL COLLEGE HOSPITAL");
    Hospital_name.setBounds(new Rectangle(33, 15, 560, 28));
    Hospital_phone.setFont(new java.awt.Font("Dialog", 1, 12));
    Hospital_phone.setText("PHONE: 719090");
    Hospital_phone.setBounds(new Rectangle(221, 78, 94, 17));
    this.getContentPane().setLayout(null);
    this.getContentPane().setBackground(new Color(173, 201, 139));
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setForeground(Color.black);
    this.setResizable(false);
    this.setTitle("Hospital Management Software");
    User_name.setFont(new java.awt.Font("Dialog", 1, 14));
    User_name.setForeground(SystemColor.activeCaption);
    User_name.setRequestFocusEnabled(true);
    User_name.setText("User name:");
    User_name.setBounds(new Rectangle(104, 214, 90, 26));
    username.setBackground(SystemColor.textHighlightText);
    username.setFont(new java.awt.Font("Dialog", 1, 12));
    username.setText("");
    username.setBounds(new Rectangle(207, 217, 176, 24));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 14));
    jLabel1.setForeground(SystemColor.activeCaption);
    jLabel1.setText("Password:");
    jLabel1.setBounds(new Rectangle(108, 263, 89, 22));
    passwords.setBackground(SystemColor.textHighlightText);
    passwords.setFont(new java.awt.Font("Dialog", 1, 12));
    passwords.setText("");
    passwords.setEchoChar('*');
    passwords.setBounds(new Rectangle(207, 265, 176, 24));
    jButton2.setBackground(new Color(173, 201, 139));
    jButton2.setBounds(new Rectangle(289, 322, 79, 25));
    jButton2.setFont(new java.awt.Font("Times New Roman", 1, 12));
    jButton2.setBorder(BorderFactory.createRaisedBevelBorder());
    jButton2.setMnemonic('E');
    jButton2.setText("EXIT");
    jButton2.addActionListener(new Main_jButton2_actionAdapter(this));
    Ok.setBackground(new Color(173, 201, 139));
    Ok.setBounds(new Rectangle(169, 322, 69, 24));
    Ok.setFont(new java.awt.Font("Times New Roman", 1, 13));
    Ok.setBorder(BorderFactory.createRaisedBevelBorder());
    Ok.setMnemonic('S');
    Ok.setText("SIGN IN");
    Ok.addActionListener(new Main_Ok_actionAdapter(this));
    User_name1.setBounds(new Rectangle(102, 173, 90, 26));
    User_name1.setText("Catagory:");
    User_name1.setRequestFocusEnabled(true);
    User_name1.setForeground(SystemColor.activeCaption);
    User_name1.setFont(new java.awt.Font("Dialog", 1, 14));
    combo.setBackground(new Color(173, 201, 139));
    combo.setFont(new java.awt.Font("Dialog", 1, 12));
    combo.setBounds(new Rectangle(206, 176, 178, 25));
    combo.addActionListener(new Main_combo_actionAdapter(this));
    this.getContentPane().add(Hospital_name, null);
    this.getContentPane().add(Hospital_web_address, null);
    this.getContentPane().add(Hospital_address, null);
    this.getContentPane().add(passwords, null);
    this.getContentPane().add(username, null);
    this.getContentPane().add(User_name, null);
    this.getContentPane().add(jLabel1, null);
    this.getContentPane().add(User_name1, null);
    this.getContentPane().add(combo, null);
    this.getContentPane().add(Hospital_phone, null);
    this.getContentPane().add(Ok, null);
    this.getContentPane().add(jButton2, null);
  }

  public static void main(String[] args) {
    Main main = new Main();

  }

  void Ok_actionPerformed(ActionEvent e) {

    //status 1 = administrator
    //status 2  = doctor or stuff
    //status 3 = user

       String name="",password="";
       int f=0;

        Statement stat;
        ResultSet rset;
        String sql;
        boolean insertResult;

     name = username.getText().toLowerCase();
     password = new String(passwords.getPassword());

     if (username.getText().equals("") || password.equals("")) {
      JOptionPane.showMessageDialog(null,"Enter Name or Password");
    }
    else if (combo.getSelectedIndex() == 2)
     {
      if(name.equals("admin") &&password.equals("123")) {
        JOptionPane.showMessageDialog(null,
                                      "You are logging in as an administrator");
        status = 1;
        dispose();
        new Menubar();

      }
      else
        JOptionPane.showMessageDialog(null,"Invalid Name or Password");
     }


     else if (combo.getSelectedIndex() == 1)
     {
       if( name.equals("doc_stuff") &&password.equals("456")) {
         JOptionPane.showMessageDialog(null,
             "You are logging in as an authorized person");

        status = 2;
        dispose();
         new Menubar();

       }
       else JOptionPane.showMessageDialog(null,"Invalid Name or Password");
     }
     else{

       if(name.equals("user") && password.equals("789"))
       {
         status = 3;
         JOptionPane.showMessageDialog(null,
                                    "You are logging in as an User");
         dispose();
         new Menubar();
       }

       else
       {

         try {

           stat = connection.createStatement();
           sql = "select lower(name) as name,pass from user_password";
           rset = stat.executeQuery(sql);
           String users[] = new String[100];
           String pas[] = new String[100];
           int i = 0;
           while (rset.next()) {
             users[i] = rset.getString("name");
             pas[i] = rset.getString("pass");
             i++;
           }

           for (int j = 0; j < i; j++) {
             if (users[j].equals(name) && pas[j].equals(password)) {
               status = 3;
               f = 1;
               break;
             }
           }
           stat.close();
           rset.close();

           if (f == 0)
             JOptionPane.showMessageDialog(null, "Invalid name or Password",
                                           "ERROR MESSAGE",
                                           JOptionPane.ERROR_MESSAGE);
           else {
             JOptionPane.showMessageDialog(null, "You are logging in as an user");
             dispose();
             new Menubar();
           }
         }
         catch (SQLException sqlException) {
           JOptionPane.showMessageDialog(null, sqlException.getMessage(),
                                         "Database error",
                                         JOptionPane.ERROR_MESSAGE);
         }
       }
   }
  }




  void jButton2_actionPerformed(ActionEvent e) {
       System.exit(0);
  }

  void combo_actionPerformed(ActionEvent e) {
     username.setText("");
     passwords.setText("");
     status=1;
  }
}

class Main_Ok_actionAdapter implements java.awt.event.ActionListener {
  Main adaptee;

  Main_Ok_actionAdapter(Main adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.Ok_actionPerformed(e);
  }
}

class Main_jButton2_actionAdapter implements java.awt.event.ActionListener {
  Main adaptee;

  Main_jButton2_actionAdapter(Main adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton2_actionPerformed(e);
  }
}

class Main_combo_actionAdapter implements java.awt.event.ActionListener {
  Main adaptee;

  Main_combo_actionAdapter(Main adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.combo_actionPerformed(e);
  }
}
