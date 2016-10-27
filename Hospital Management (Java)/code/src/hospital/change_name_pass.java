package hospital;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class change_name_pass extends JFrame {

  Connection connection;
  JPanel jPanel1 = new JPanel();
  JLabel jLabel4 = new JLabel();
  JLabel jLabel5 = new JLabel();
  JLabel jLabel6 = new JLabel();
  JLabel jLabel7 = new JLabel();
  JTextField name = new JTextField();
  JButton jButton1 = new JButton();
  JButton close = new JButton();
  JPasswordField old_pass = new JPasswordField();
  JPasswordField new_pass = new JPasswordField();


  public change_name_pass() {
    try {
      jbInit();

      setSize(420,220);
      setLocation(100,50);

      connection = Main.connection;

      show();

    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    this.getContentPane().setBackground(new Color(173, 201, 139));
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setResizable(false);
    this.getContentPane().setLayout(null);
    jPanel1.setBackground(new Color(173, 201, 139));
    jPanel1.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel1.setBounds(new Rectangle(20, 6, 376, 126));
    jPanel1.setLayout(null);
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel4.setBorder(null);
    jLabel4.setText("CHANGE PASSWORD");
    jLabel4.setBounds(new Rectangle(132, 3, 144, 16));
    jLabel5.setBounds(new Rectangle(28, 37, 118, 24));
    jLabel5.setText("NAME");
    jLabel5.setBorder(null);
    jLabel5.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel6.setBounds(new Rectangle(31, 91, 126, 24));
    jLabel6.setText("NEW PASSWORD");
    jLabel6.setBorder(null);
    jLabel6.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel7.setBounds(new Rectangle(28, 64, 126, 24));
    jLabel7.setText("OLD PASSWORD");
    jLabel7.setBorder(null);
    jLabel7.setFont(new java.awt.Font("Dialog", 1, 12));
    name.setText("");
    name.setBounds(new Rectangle(234, 32, 119, 21));
    jButton1.setBackground(new Color(173, 201, 139));
    jButton1.setBounds(new Rectangle(65, 138, 94, 26));
    jButton1.setFont(new java.awt.Font("Dialog", 1, 12));
    jButton1.setText("OK");
    jButton1.addActionListener(new change_name_pass_jButton1_actionAdapter(this));
    close.setText("CLOSE");
    close.addActionListener(new change_name_pass_close_actionAdapter(this));
    close.setBackground(new Color(173, 201, 139));
    close.setBounds(new Rectangle(247, 138, 94, 26));
    close.setFont(new java.awt.Font("Dialog", 1, 12));
    old_pass.setSelectionStart(15);
    old_pass.setText("");
    old_pass.setBounds(new Rectangle(234, 58, 119, 23));
    new_pass.setBounds(new Rectangle(234, 87, 119, 23));
    new_pass.setText("");
    new_pass.setSelectionStart(15);
    jPanel1.add(jLabel6, null);
    jPanel1.add(jLabel7, null);
    jPanel1.add(jLabel5, null);
    jPanel1.add(name, null);
    jPanel1.add(jLabel4, null);
    jPanel1.add(old_pass, null);
    jPanel1.add(new_pass, null);
    this.getContentPane().add(jButton1, null);
    this.getContentPane().add(close, null);
    this.getContentPane().add(jPanel1, null);
  }

  public static void main(String[] args) {
    change_name_pass change_name_pass = new change_name_pass();
  }

  void jButton1_actionPerformed(ActionEvent e) {
    String names="",oldPass="",newPass="";
    int found=0;

    names = name.getText();
    oldPass = new String(old_pass.getPassword());
    newPass = new String(new_pass.getPassword());


    if(names.equals("") && oldPass.equals("") && newPass.equals(""))
    {
      JOptionPane.showMessageDialog(null, "Fillup all the Field",
                                    "ERROR MESSAGE",  JOptionPane.ERROR_MESSAGE);

    }
    else
    {


      try {

        Statement stat;
        ResultSet rset;
        String sql, n = "", p = "";

        stat = connection.createStatement();
        sql = "select name,pass from user_password";
        rset = stat.executeQuery(sql);
        while (rset.next()) {
          n = rset.getString("name");
          p = rset.getString("pass");
          if (n.equals(names) && p.equals(oldPass)) {
            found = 1;
            break;
          }
        }

        if (found == 0)
          JOptionPane.showMessageDialog(null, "Invalid name or password.",
                                        "ERROR MESSAGE",
                                        JOptionPane.ERROR_MESSAGE);
        else {
             sql = " update user_password set pass = '" + newPass +
                "' where ( name = '" + names + "'  AND pass = '" + oldPass +
                "' )";
            stat = connection.createStatement();
            boolean insertResult = stat.execute(sql);
            stat.close();
            JOptionPane.showMessageDialog(null, "Your Password have updated.",
                                          "CONFIRMATION MESSAGE",
                                         JOptionPane.INFORMATION_MESSAGE);

          }
      }
      catch (SQLException sqlException) {
        JOptionPane.showMessageDialog(null, sqlException.getMessage(),
                                      "Database error",
                                      JOptionPane.ERROR_MESSAGE);
      }
    }


  }

  void close_actionPerformed(ActionEvent e) {


    dispose();

  }

}

class change_name_pass_jButton1_actionAdapter implements java.awt.event.ActionListener {
  change_name_pass adaptee;

  change_name_pass_jButton1_actionAdapter(change_name_pass adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton1_actionPerformed(e);
  }
}

class change_name_pass_close_actionAdapter implements java.awt.event.ActionListener {
  change_name_pass adaptee;

  change_name_pass_close_actionAdapter(change_name_pass adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.close_actionPerformed(e);
  }
}
