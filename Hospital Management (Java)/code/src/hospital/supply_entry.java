package hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class supply_entry extends JFrame {

  Connection connection;

  JPanel jPanel1 = new JPanel();
  JLabel Hospital_name = new JLabel();
  JLabel jLabel1 = new JLabel();
  JPanel jPanel3 = new JPanel();
  JPanel jPanel2 = new JPanel();
  JLabel jLabel2 = new JLabel();
  JTextField name = new JTextField();
  JLabel jLabel3 = new JLabel();
  String depts[]={"Medicine","Surgery","Gynae","Paediactric","Orthopaeddics","Neoral"};
  JComboBox dept = new JComboBox(depts);
  JLabel jLabel4 = new JLabel();
  JTextField quantity = new JTextField();
  JLabel jLabel5 = new JLabel();
  JTextField price = new JTextField();
  JPanel jPanel4 = new JPanel();
  JButton jButton2 = new JButton();
  JButton jButton1 = new JButton();
  JButton jButton3 = new JButton();


  public supply_entry() {
    try {
      jbInit();
      setSize(600,400);
      setLocation(110,80);

      connection = Main.connection;

      show();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    jPanel1.setLayout(null);
    jPanel1.setBounds(new Rectangle(10, 6, 569, 62));
    jPanel1.setBackground(new Color(173, 201, 139));
    jPanel1.setBorder(BorderFactory.createLoweredBevelBorder());
    this.getContentPane().setLayout(null);
    Hospital_name.setBounds(new Rectangle(21, 12, 544, 28));
    Hospital_name.setText("JALALABAD RAGIB-RABEYA MEDICAL COLLEGE HOSPITAL");
    Hospital_name.setForeground(SystemColor.desktop);
    Hospital_name.setFont(new java.awt.Font("Dialog", 1, 18));
    jLabel1.setFont(new java.awt.Font("Book Antiqua", 1, 14));
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("Supply Entry");
    jLabel1.setBounds(new Rectangle(150, 6, 218, 25));
    jPanel3.setBackground(new Color(173, 201, 139));
    jPanel3.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel3.setBounds(new Rectangle(11, 73, 570, 35));
    jPanel3.setLayout(null);
    jPanel2.setBackground(new Color(173, 201, 139));
    jPanel2.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel2.setBounds(new Rectangle(13, 117, 565, 138));
    jPanel2.setLayout(null);
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel2.setText("DEPARTMENT:");
    jLabel2.setBounds(new Rectangle(8, 14, 78, 23));
    name.setBackground(SystemColor.textHighlightText);
    name.setFont(new java.awt.Font("Dialog", 1, 12));
    name.setText("");
    name.setBounds(new Rectangle(371, 9, 126, 26));
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel3.setText("ITEM NAME:");
    jLabel3.setBounds(new Rectangle(280, 12, 78, 25));
    dept.setBackground(new Color(173, 201, 139));
    dept.setFont(new java.awt.Font("Dialog", 1, 12));
    dept.setBounds(new Rectangle(109, 14, 122, 23));
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel4.setText("QUANTITY");
    jLabel4.setBounds(new Rectangle(10, 71, 65, 20));
    quantity.setBackground(SystemColor.textHighlightText);
    quantity.setFont(new java.awt.Font("Dialog", 1, 12));
    quantity.setText("");
    quantity.setBounds(new Rectangle(110, 71, 122, 23));
    jLabel5.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel5.setText("PER UNIT PRICE:");
    jLabel5.setBounds(new Rectangle(247, 65, 114, 35));
    price.setBackground(SystemColor.textHighlightText);
    price.setFont(new java.awt.Font("Dialog", 1, 12));
    price.setText("");
    price.setBounds(new Rectangle(374, 71, 120, 25));
    jPanel4.setBackground(new Color(173, 201, 139));
    jPanel4.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel4.setBounds(new Rectangle(14, 270, 564, 65));
    jPanel4.setLayout(null);
    jButton2.setText("CLEAR");
    jButton2.addActionListener(new supply_entry_jButton2_actionAdapter(this));
    jButton2.setMnemonic('C');
    jButton2.setBorder(BorderFactory.createRaisedBevelBorder());
    jButton2.setFont(new java.awt.Font("Dialog", 1, 12));
    jButton2.setBackground(new Color(173, 201, 139));
    jButton2.setBounds(new Rectangle(246, 18, 75, 25));
    jButton1.setText("SAVE");
    jButton1.addActionListener(new supply_entry_jButton1_actionAdapter(this));
    jButton1.setMnemonic('S');
    jButton1.setBorder(BorderFactory.createRaisedBevelBorder());
    jButton1.setFont(new java.awt.Font("Dialog", 1, 12));
    jButton1.setBackground(new Color(173, 201, 139));
    jButton1.setBounds(new Rectangle(146, 16, 72, 26));
    jButton3.setText("CLOSE");
    jButton3.addActionListener(new supply_entry_jButton3_actionAdapter(this));
    jButton3.setMnemonic('L');
    jButton3.setBorder(BorderFactory.createRaisedBevelBorder());
    jButton3.setFont(new java.awt.Font("Dialog", 1, 12));
    jButton3.setBackground(new Color(173, 201, 139));
    jButton3.setBounds(new Rectangle(348, 17, 66, 27));
    this.getContentPane().setBackground(new Color(173, 201, 139));
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setResizable(false);
    this.setTitle("SUPPLY ENTRY");
    jPanel2.add(price, null);
    jPanel2.add(dept, null);
    jPanel2.add(jLabel5, null);
    jPanel2.add(quantity, null);
    jPanel2.add(jLabel4, null);
    jPanel2.add(jLabel2, null);
    jPanel2.add(jLabel3, null);
    jPanel2.add(name, null);
    this.getContentPane().add(jPanel4, null);
    this.getContentPane().add(jPanel1, null);
    jPanel1.add(Hospital_name, null);
    this.getContentPane().add(jPanel3, null);
    jPanel3.add(jLabel1, null);
    this.getContentPane().add(jPanel2, null);
    jPanel4.add(jButton1, null);
    jPanel4.add(jButton2, null);
    jPanel4.add(jButton3, null);

  }

  public static void main(String[] args) {
    supply_entry supply_entry = new supply_entry();
  }

  void jButton1_actionPerformed(ActionEvent e) {

    try{

             boolean insertResult;

              //for table supply_entry


              double p,cost,quan;
              quan = Double.parseDouble(quantity.getText());
              p= Double.parseDouble(price.getText());
              cost = p*quan;

              //System.out.print(cost);

              String sql = "insert into supply_entry values('"+name.getText()+"','"+dept.getSelectedItem()+"',"+quan+","+cost+")";
              Statement stat= connection.createStatement();
              insertResult= stat.execute(sql);

              stat.close();
              JOptionPane.showMessageDialog(null,"Your Information have successfully saved.","CONFIRMATION MESSAGE",JOptionPane.INFORMATION_MESSAGE);


            }

            catch(SQLException sqlException)
            {
              JOptionPane.showMessageDialog(null,sqlException.getMessage(),
                                     "Database error",JOptionPane.ERROR_MESSAGE);
             }


  }

  void jButton3_actionPerformed(ActionEvent e) {
dispose();
  }

  void jButton2_actionPerformed(ActionEvent e) {
    price.setText("");
   name.setText("");
   quantity.setText("");


  }
}

class supply_entry_jButton1_actionAdapter implements java.awt.event.ActionListener {
  supply_entry adaptee;

  supply_entry_jButton1_actionAdapter(supply_entry adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton1_actionPerformed(e);
  }
}

class supply_entry_jButton3_actionAdapter implements java.awt.event.ActionListener {
  supply_entry adaptee;

  supply_entry_jButton3_actionAdapter(supply_entry adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton3_actionPerformed(e);
  }
}

class supply_entry_jButton2_actionAdapter implements java.awt.event.ActionListener {
  supply_entry adaptee;

  supply_entry_jButton2_actionAdapter(supply_entry adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton2_actionPerformed(e);
  }
}
