
package inventory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Main extends JFrame {

  JLabel inventory_name = new JLabel();
  JLabel User_name = new JLabel();
  JTextField username = new JTextField();
  JLabel jLabel1 = new JLabel();
  JPasswordField passwords = new JPasswordField();
  JButton jButton2 = new JButton();
  JButton Ok = new JButton();
  static String type[]={"Chemical","Dyes","Fabrics","Yarn","Accessories"};

  static int id=0;
  static String entryTable="",upTable="",names="";

  public static Connection conn;
  static final String url = "jdbc:mysql://localhost/inventory";
  static final String user_name = "root";
  static final String password = "triadpass";
  JLabel jLabel2 = new JLabel();
  JComboBox combo = new JComboBox(type);


  public Main() {

    try {
      jbInit();
      setSize(400,300);
      centerScreen();

      show();

    }
    catch(Exception ex) {
      ex.printStackTrace();
    }

    try {
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(url, user_name, password);

      //JOptionPane.showMessageDialog(null, "Connected.");

    }

    catch (SQLException sqlException) {
      JOptionPane.showMessageDialog(null, sqlException.getMessage(),
                                    "Database error",
                                    JOptionPane.ERROR_MESSAGE);
    }

    catch (ClassNotFoundException ex) {
      ex.printStackTrace();
      JOptionPane.showMessageDialog(null, "Class Error.");

    }





  }
  void centerScreen()
        {
                Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
                int x = (int) ((d.getWidth() - getWidth()) / 2);
                int y = (int) ((d.getHeight() - getHeight()) / 2);
                setLocation(x, y);
        }


  void jbInit() throws Exception {
    inventory_name.setFont(new java.awt.Font("Dialog", 1, 18));
    inventory_name.setForeground(Color.blue);
    inventory_name.setText("INVENTORY MANAGEMANT");
    inventory_name.setBounds(new Rectangle(77, 12, 256, 28));
    this.getContentPane().setLayout(null);
    this.getContentPane().setBackground(new Color(173, 180, 173));
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setForeground(Color.black);
    this.setResizable(false);
    this.setTitle("Inventory Management Software");
    User_name.setFont(new java.awt.Font("Dialog", 1, 14));
    User_name.setRequestFocusEnabled(true);
    User_name.setText("User name:");
    User_name.setBounds(new Rectangle(62, 81, 90, 26));
    username.setBackground(SystemColor.textHighlightText);
    username.setFont(new java.awt.Font("Dialog", 1, 12));
    username.setText("");
    username.setBounds(new Rectangle(171, 81, 177, 27));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 14));
    jLabel1.setText("Password:");
    jLabel1.setBounds(new Rectangle(63, 118, 89, 22));
    passwords.setBackground(SystemColor.textHighlightText);
    passwords.setFont(new java.awt.Font("Dialog", 1, 12));
    passwords.setText("");
    passwords.setEchoChar('*');
    passwords.setBounds(new Rectangle(171, 117, 177, 27));
    jButton2.setBackground(new Color(173, 180, 173));
    jButton2.setBounds(new Rectangle(223, 207, 79, 25));
    jButton2.setFont(new java.awt.Font("Times New Roman", 1, 12));
    jButton2.setBorder(BorderFactory.createRaisedBevelBorder());
    jButton2.setMnemonic('E');
    jButton2.setText("EXIT");
    jButton2.addActionListener(new Main_jButton2_actionAdapter(this));
    Ok.setBackground(new Color(173, 180, 173));
    Ok.setBounds(new Rectangle(113, 209, 69, 24));
    Ok.setFont(new java.awt.Font("Times New Roman", 1, 13));
    Ok.setBorder(BorderFactory.createRaisedBevelBorder());
    Ok.setMnemonic('S');
    Ok.setText("SIGN IN");
    Ok.addActionListener(new Main_Ok_actionAdapter(this));
    jLabel2.setBounds(new Rectangle(64, 156, 89, 22));
    jLabel2.setText("Select Type: ");
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 14));
    combo.setBackground(SystemColor.window);
    combo.setFont(new java.awt.Font("Dialog", 1, 12));
    combo.setAutoscrolls(true);
    combo.setBounds(new Rectangle(171, 157, 177, 27));
    this.getContentPane().add(inventory_name, null);
    this.getContentPane().add(username, null);
    this.getContentPane().add(User_name, null);
    this.getContentPane().add(passwords, null);
    this.getContentPane().add(jLabel1, null);
    this.getContentPane().add(jLabel2, null);
    this.getContentPane().add(combo, null);
    this.getContentPane().add(jButton2, null);
    this.getContentPane().add(Ok, null);
  }

  public static void main(String[] args) {
    Main main = new Main();

  }

  static void set_table_and_name(int p)
  {
    if(p==0){
       entryTable = "dataentry_chemical";
       upTable = "up_no_chemical";
       names = "Chemical";
     }
     else if(p==1)
     {
       entryTable = "dataentry_dyes";
       upTable = "up_no_dyes";
       names="Dyes";
     }

     else if(p==2)
     {
       entryTable = "dataentry_fabrics";
       upTable = "up_no_fabrics";
       names="Fabrics";
     }
     else if(p==3)
     {
       entryTable = "dataentry_yarn";
       upTable = "up_no_yarn";
       names="Yarn";
     }
     else if(p==4)
    {
      entryTable = "dataentry_accessories";
      upTable = "up_no_accessories";
      names="Accessories";
    }


  }

  void Ok_actionPerformed(ActionEvent e) {
    String name,pass;
    name = username.getText().toLowerCase();
    pass = new String(passwords.getPassword());

    //JOptionPane.showMessageDialog(null,name+" "+pass);

    if (username.getText().equals("") || pass.equals("")) {
       JOptionPane.showMessageDialog(null,"Enter Name or Password");
    }
   else if (name.equals("jabed") && pass.equals("abunaser")) {

     id  = combo.getSelectedIndex();
     set_table_and_name(id);
     dispose();
     new MenuBar();
   }
   else
    JOptionPane.showMessageDialog(null,"Invalid User Name or Password");

  }




  void jButton2_actionPerformed(ActionEvent e) {
       System.exit(0);
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
