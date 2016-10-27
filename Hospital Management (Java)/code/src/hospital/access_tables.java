package hospital;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import com.borland.dx.sql.dataset.*;
import com.borland.dbswing.*;
import com.borland.dx.sql.dataset.ConnectionDescriptor;


public class access_tables extends JFrame {

  Connection connection;

  TableScrollPane tableScrollPane1 = new TableScrollPane();
  JdbTable jdbTable1 = new JdbTable();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextArea area = new JTextArea();
  JButton show = new JButton();


  Database database1 = new Database();
  QueryDataSet queryDataSet1 = new QueryDataSet();
  JPanel jPanel1 = new JPanel();
  JLabel jLabel1 = new JLabel();
  JPanel jPanel2 = new JPanel();
  JLabel jLabel2 = new JLabel();
  JPanel jPanel3 = new JPanel();
  JLabel jLabel3 = new JLabel();
  JScrollPane jScrollPane2 = new JScrollPane();
  JButton execute = new JButton();
  JButton close = new JButton();
  JTextArea area2 = new JTextArea();
  JButton table = new JButton();

  public access_tables() {
    try {
      jbInit();
      setSize(530,490);
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
    this.setTitle(" ACCESS TABLE FOR ADMINISTRATOR");
    this.getContentPane().setLayout(null);
    tableScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    tableScrollPane1.getViewport().setBackground(new Color(173, 201, 139));
    tableScrollPane1.setEnabled(true);
    tableScrollPane1.setBounds(new Rectangle(12, 117, 480, 91));
    jScrollPane1.setBounds(new Rectangle(10, 36, 480, 39));
    show.setBackground(new Color(173, 201, 139));
    show.setBounds(new Rectangle(201, 79, 104, 32));
    show.setFont(new java.awt.Font("Dialog", 1, 12));
    show.setBorder(BorderFactory.createRaisedBevelBorder());
    show.setText("SHOW");
    show.addActionListener(new Frame2_show_actionAdapter(this));
    jPanel1.setBackground(new Color(173, 201, 139));
    jPanel1.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel1.setBounds(new Rectangle(8, 5, 508, 30));
    jPanel1.setLayout(null);
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1.setText("ADMINISTRATOR");
    jLabel1.setBounds(new Rectangle(199, 7, 95, 16));
    jPanel2.setBackground(new Color(173, 201, 139));
    jPanel2.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel2.setBounds(new Rectangle(10, 40, 505, 220));
    jPanel2.setLayout(null);
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel2.setText("INFORMATION OF A TABLE");
    jLabel2.setBounds(new Rectangle(169, 0, 161, 31));
    area.setFont(new java.awt.Font("Dialog", 1, 12));
    area.setText("select * from ");
    jPanel3.setBackground(new Color(173, 201, 139));
    jPanel3.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel3.setDebugGraphicsOptions(0);
    jPanel3.setBounds(new Rectangle(9, 269, 507, 120));
    jPanel3.setLayout(null);
    jLabel3.setBounds(new Rectangle(134, 7, 207, 31));
    jLabel3.setText("UPDATE/MODIFY/DELETE TABLE");
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 12));
    jScrollPane2.setBounds(new Rectangle(16, 35, 481, 38));
    execute.setBackground(new Color(173, 201, 139));
    execute.setBounds(new Rectangle(180, 78, 107, 33));
    execute.setFont(new java.awt.Font("Dialog", 1, 11));
    execute.setBorder(BorderFactory.createRaisedBevelBorder());
    execute.setText("EXECUTE");
    execute.addActionListener(new Frame2_execute_actionAdapter(this));
    close.setText("CLOSE");
    close.addActionListener(new Frame2_close_actionAdapter(this));
    close.setBorder(BorderFactory.createRaisedBevelBorder());
    close.setBackground(new Color(173, 201, 139));
    close.setBounds(new Rectangle(353, 399, 107, 33));
    close.setFont(new java.awt.Font("Dialog", 1, 11));
    area2.setText("");
    table.setFont(new java.awt.Font("Dialog", 1, 11));
    table.setBounds(new Rectangle(41, 401, 120, 33));
    table.setBackground(new Color(173, 201, 139));
    table.setBorder(BorderFactory.createRaisedBevelBorder());
    table.setText("TABLE NAMES");
    table.addActionListener(new Frame2_table_actionAdapter(this));
    this.getContentPane().add(jPanel1, null);
    jPanel1.add(jLabel1, null);
    this.getContentPane().add(jPanel2, null);
    jPanel2.add(jLabel2, null);
    jPanel2.add(jScrollPane1, null);
    jScrollPane1.getViewport().add(area, null);
    jPanel2.add(tableScrollPane1, null);
    jPanel2.add(show, null);
    this.getContentPane().add(jPanel3, null);
    jPanel3.add(jLabel3, null);
    jPanel3.add(jScrollPane2, null);
    jPanel3.add(execute, null);
    this.getContentPane().add(close, null);
    this.getContentPane().add(table, null);
    jScrollPane2.getViewport().add(area2, null);
    tableScrollPane1.getViewport().add(jdbTable1, null);


  }

  public static void main(String[] args) {
   access_tables frame2 = new access_tables();
  }

  void show_actionPerformed(ActionEvent e) {

    try{

      database1.setConnection(new ConnectionDescriptor("jdbc:oracle:oci8:@",
       "system", "manager", false, "oracle.jdbc.driver.OracleDriver"));
     Statement statement=database1.createStatement();
     queryDataSet1.close();
     queryDataSet1.setQuery(new com.borland.dx.sql.dataset.QueryDescriptor(database1,
     area.getText(), null, true, Load.ALL));
     queryDataSet1.executeQuery();
      jdbTable1.setDataSet(queryDataSet1);
    }
    catch(Exception ex){
 DBExceptionHandler.handleException(ex);
}



  }

  void close_actionPerformed(ActionEvent e) {

    dispose();
  }

  void execute_actionPerformed(ActionEvent e) {


    try {

      Statement stat;
      String sql = "";


      stat = connection.createStatement();
      sql = area2.getText();


      boolean insertResult = stat.execute(sql);
      stat.close();


    }
    catch (SQLException sqlException) {
      JOptionPane.showMessageDialog(null, sqlException.getMessage(),"Database error",JOptionPane.ERROR_MESSAGE);
    }


  }

  void table_actionPerformed(ActionEvent e) {
   new TableName();
  }


}

class Frame2_show_actionAdapter implements java.awt.event.ActionListener {
  access_tables adaptee;

  Frame2_show_actionAdapter(access_tables adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.show_actionPerformed(e);
  }
}

class Frame2_close_actionAdapter implements java.awt.event.ActionListener {
  access_tables adaptee;

  Frame2_close_actionAdapter(access_tables adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.close_actionPerformed(e);
  }
}

class Frame2_execute_actionAdapter implements java.awt.event.ActionListener {
  access_tables adaptee;

  Frame2_execute_actionAdapter(access_tables adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.execute_actionPerformed(e);
  }
}

class Frame2_table_actionAdapter implements java.awt.event.ActionListener {
  access_tables adaptee;

  Frame2_table_actionAdapter(access_tables adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.table_actionPerformed(e);
  }
}
