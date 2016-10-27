package hospital;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;


public class admin_pass extends JFrame{
  JLabel jLabel1 = new JLabel();
  JButton ok = new JButton();
  JPasswordField pass = new JPasswordField();

  public admin_pass() {

    super("PASSWORD");

    try {

      jbInit();
      setSize(230,110);
      setLocation(150,80);
      show();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }






  }

  void jbInit() throws Exception {
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1.setText("PASSWORD:");
    jLabel1.setBounds(new Rectangle(10, 8, 78, 24));
    this.getContentPane().setBackground(new Color(173, 201, 139));
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setResizable(false);
    this.getContentPane().setLayout(null);
    ok.setBackground(new Color(173, 201, 139));
    ok.setBounds(new Rectangle(79, 42, 67, 25));
    ok.setFont(new java.awt.Font("Dialog", 1, 12));
    ok.setText("OK");
    ok.addActionListener(new admin_pass_ok_actionAdapter(this));
    pass.setBounds(new Rectangle(87, 9, 123, 27));
    this.getContentPane().add(jLabel1, null);
    this.getContentPane().add(pass, null);
    this.getContentPane().add(ok, null);
  }

  public static void main(String[] args) {
    admin_pass admin_pass = new admin_pass();
  }

  void ok_actionPerformed(ActionEvent e) {

    String password="";
    password = new String(pass.getPassword());

    if(password.equals("cse"))
    {
      dispose();
      new administrator();
    }
    else
           JOptionPane.showMessageDialog(null,"Wrong Password.","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);


  }
}

class admin_pass_ok_actionAdapter implements java.awt.event.ActionListener {
  admin_pass adaptee;

  admin_pass_ok_actionAdapter(admin_pass adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.ok_actionPerformed(e);
  }
}
