package hospital;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class Create_user extends JFrame {

  Connection connection;
  JPanel jPanel1 = new JPanel();
  JLabel jLabel4 = new JLabel();
  JLabel jLabel5 = new JLabel();
  JLabel jLabel6 = new JLabel();
  JLabel jLabel7 = new JLabel();
  JTextField name = new JTextField();
  JButton create = new JButton();
  JButton close = new JButton();
  JPasswordField pass = new JPasswordField();
  JPasswordField pass1 = new JPasswordField();
  JPanel jPanel2 = new JPanel();


  public Create_user() {
    try {
      jbInit();

      setSize(420,300);
      setLocation(100,60);

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
    jPanel1.setBounds(new Rectangle(6, 62, 385, 139));
    jPanel1.setLayout(null);
    jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 12));
    jLabel4.setForeground(Color.blue);
    jLabel4.setBorder(null);
    jLabel4.setText("CREATE NEW USER");
    jLabel4.setBounds(new Rectangle(129, 7, 144, 25));
    jLabel5.setBounds(new Rectangle(23, 15, 118, 24));
    jLabel5.setText("NAME");
    jLabel5.setBorder(null);
    jLabel5.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel6.setBounds(new Rectangle(20, 85, 163, 24));
    jLabel6.setText("CONFIRM NEW PASSWORD");
    jLabel6.setBorder(null);
    jLabel6.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel7.setBounds(new Rectangle(21, 48, 126, 24));
    jLabel7.setText("PASSWORD");
    jLabel7.setBorder(null);
    jLabel7.setFont(new java.awt.Font("Dialog", 1, 12));
    name.setText("");
    name.setBounds(new Rectangle(188, 11, 174, 29));
    create.setBackground(new Color(173, 201, 139));
    create.setBounds(new Rectangle(50, 216, 94, 26));
    create.setFont(new java.awt.Font("Dialog", 1, 12));
    create.setText("CREATE");
    create.addActionListener(new Create_user_create_actionAdapter(this));
    close.setText("CLOSE");
    close.addActionListener(new Create_user_close_actionAdapter(this));
    close.setBackground(new Color(173, 201, 139));
    close.setBounds(new Rectangle(247, 214, 94, 26));
    close.setFont(new java.awt.Font("Dialog", 1, 12));
    pass.setSelectionStart(15);
    pass.setText("");
    pass.setBounds(new Rectangle(188, 46, 174, 28));
    pass1.setBounds(new Rectangle(188, 85, 174, 29));
    pass1.setText("");
    pass1.setSelectionStart(15);
    jPanel2.setBackground(new Color(173, 201, 139));
    jPanel2.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel2.setBounds(new Rectangle(8, 5, 383, 49));
    jPanel2.setLayout(null);
    jPanel1.add(jLabel5, null);
    jPanel1.add(jLabel7, null);
    jPanel1.add(jLabel6, null);
    jPanel1.add(pass, null);
    jPanel1.add(pass1, null);
    jPanel1.add(name, null);
    this.getContentPane().add(jPanel2, null);
    jPanel2.add(jLabel4, null);
    this.getContentPane().add(create, null);
    this.getContentPane().add(close, null);
    this.getContentPane().add(jPanel1, null);
  }

  public static void main(String[] args) {
    Create_user user = new Create_user();
    user.setDefaultCloseOperation(Create_user.EXIT_ON_CLOSE);

  }

  void create_actionPerformed(ActionEvent e) {

    String names="",password="",again="";

    names = name.getText();
    password = new String(pass.getPassword());
    again = new String(pass1.getPassword());

    if(names.equals(""))
         JOptionPane.showMessageDialog(null,"Type Your Name","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
    else if(password.equals(""))
        JOptionPane.showMessageDialog(null,"Type a password","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
    else if(again.equals(""))
        JOptionPane.showMessageDialog(null,"Retype the password","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);

      else if(!password.equals(again))
        JOptionPane.showMessageDialog(null,"Retype the Password","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
      else {



        try {

          Statement stat;
          ResultSet rset;
          String sql;

          stat = connection.createStatement();
          sql = "select name from user_password";
          rset = stat.executeQuery(sql);
          String users[] = new String[100];
          users[0] = "hospital";
          int i = 1;
          while (rset.next()) {
            users[i] = rset.getString(1);
            i++;
          }
          int flag = 1;
          for (int j = 0; j < i; j++) {
            if (users[j].equals(names)) {
              JOptionPane.showMessageDialog(null,
                                            "This User name exists\nYou should try different User Name",
                                            "ERROR MESSAGE",
                                            JOptionPane.ERROR_MESSAGE);
              flag = 0;
              break;
            }
          }

          if (flag == 1) {
            sql = "insert into user_password values('" + names + "','" + password +
                "')";
            stat = connection.createStatement();
            boolean insertResult = stat.execute(sql);
            stat.close();
          }

          stat.close();
          rset.close();
          JOptionPane.showMessageDialog(null,"User Created","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);

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

class Create_user_create_actionAdapter implements java.awt.event.ActionListener {
  Create_user adaptee;

  Create_user_create_actionAdapter(Create_user adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.create_actionPerformed(e);
  }
}

class Create_user_close_actionAdapter implements java.awt.event.ActionListener {
  Create_user adaptee;

  Create_user_close_actionAdapter(Create_user adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.close_actionPerformed(e);
  }
}
