package hospital;

import javax.swing.*;
import java.awt.*;
import com.borland.dbswing.*;
import java.util.*;
import com.borland.dx.sql.dataset.*;
import com.borland.dx.sql.dataset.ConnectionDescriptor;
import java.sql.*;
import java.awt.event.*;


public class Income extends JFrame {

  Database database1 = new Database();
  QueryDataSet queryDataSet1 = new QueryDataSet();
  Connection connection;
  String dat="";
  Statement stat;
     ResultSet rset;

  JPanel jPanel1 = new JPanel();
  JLabel jLabel1 = new JLabel();
  JPanel jPanel2 = new JPanel();
  TableScrollPane tableScrollPane1 = new TableScrollPane();
  JdbTable jdbTable1 = new JdbTable();
  JPanel jPanel3 = new JPanel();
  JButton show = new JButton();
  JButton exit = new JButton();
  JPanel jPanel4 = new JPanel();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JTextField indoor = new JTextField();
  JTextField outdoor = new JTextField();
  JTextField total = new JTextField();
  JLabel jLabel5 = new JLabel();
  JTextField dates = new JTextField();

  public Income() {
    try {
      jbInit();
      setSize(410,495);
      setLocation(100,60);
      show();

      String sql;

      connection = Main.connection;






           sql = "select to_char(sysDate,'DD-MM-YYYY') from dual";
           stat = connection.createStatement();
           rset = stat.executeQuery(sql);
           while(rset.next())
           dat= rset.getString(1);
           dates.setText(dat);
           //dates.setEditable(false);


           stat.close();



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
    jPanel1.setBounds(new Rectangle(14, 9, 359, 34));
    jPanel1.setLayout(null);
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1.setForeground(Color.blue);
    jLabel1.setText("TOTAL INCOME");
    jLabel1.setBounds(new Rectangle(126, 5, 112, 25));
    jPanel2.setBackground(new Color(173, 201, 139));
    jPanel2.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel2.setBounds(new Rectangle(15, 50, 358, 215));
    jPanel2.setLayout(null);
    tableScrollPane1.getViewport().setBackground(new Color(173, 201, 139));
    tableScrollPane1.setBounds(new Rectangle(23, 41, 304, 164));
    jPanel3.setBackground(new Color(173, 201, 139));
    jPanel3.setFont(new java.awt.Font("MS Sans Serif", 0, 11));
    jPanel3.setForeground(Color.black);
    jPanel3.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel3.setBounds(new Rectangle(15, 396, 358, 49));
    jPanel3.setLayout(null);
    show.setBackground(new Color(173, 201, 139));
    show.setBounds(new Rectangle(29, 7, 108, 33));
    show.setFont(new java.awt.Font("Dialog", 1, 12));
    show.setText("SHOW");
    show.addActionListener(new Income_show_actionAdapter(this));
    exit.setText("EXIT");
    exit.addActionListener(new Income_exit_actionAdapter(this));
    exit.setFont(new java.awt.Font("Dialog", 1, 12));
    exit.setBackground(new Color(173, 201, 139));
    exit.setBounds(new Rectangle(196, 8, 108, 33));
    jPanel4.setBackground(new Color(173, 201, 139));
    jPanel4.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel4.setBounds(new Rectangle(16, 274, 357, 117));
    jPanel4.setLayout(null);
    jLabel2.setBounds(new Rectangle(11, 6, 171, 25));
    jLabel2.setText("INCOME(INDOOR PATIENT)");
    jLabel2.setForeground(Color.blue);
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel3.setBounds(new Rectangle(8, 41, 173, 25));
    jLabel3.setText("INCOME(OUTDOOR PATIENT)");
    jLabel3.setForeground(Color.blue);
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel4.setBounds(new Rectangle(9, 77, 112, 25));
    jLabel4.setText("TOTAL INCOME");
    jLabel4.setForeground(Color.blue);
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 12));
    indoor.setBackground(Color.white);
    indoor.setFont(new java.awt.Font("Dialog", 1, 12));
    indoor.setEditable(false);
    indoor.setText("");
    indoor.setBounds(new Rectangle(193, 6, 132, 29));
    outdoor.setBounds(new Rectangle(192, 38, 133, 29));
    outdoor.setText("");
    outdoor.setBackground(Color.white);
    outdoor.setFont(new java.awt.Font("Dialog", 1, 12));
    outdoor.setEditable(false);
    total.setBounds(new Rectangle(193, 74, 134, 29));
    total.setText("");
    total.setBackground(Color.white);
    total.setFont(new java.awt.Font("Dialog", 1, 12));
    total.setEditable(false);
    jLabel5.setBounds(new Rectangle(121, 8, 65, 25));
    jLabel5.setText("DATE");
    jLabel5.setForeground(Color.blue);
    jLabel5.setFont(new java.awt.Font("Dialog", 1, 12));
    dates.setFont(new java.awt.Font("Dialog", 1, 12));
    dates.setEditable(false);
    dates.setText("");
    dates.setBounds(new Rectangle(196, 7, 144, 27));
    jdbTable1.setBackground(new Color(173, 201, 139));
    this.getContentPane().add(jPanel1, null);
    jPanel1.add(jLabel1, null);
    this.getContentPane().add(jPanel2, null);
    jPanel2.add(dates, null);
    jPanel2.add(jLabel5, null);
    jPanel2.add(tableScrollPane1, null);
    tableScrollPane1.getViewport().add(jdbTable1, null);
    jPanel3.add(show, null);
    jPanel3.add(exit, null);
    this.getContentPane().add(jPanel4, null);
    jPanel4.add(jLabel2, null);
    jPanel4.add(indoor, null);
    jPanel4.add(outdoor, null);
    jPanel4.add(total, null);
    jPanel4.add(jLabel4, null);
    jPanel4.add(jLabel3, null);
    this.getContentPane().add(jPanel3, null);
  }

  public static void main(String[] args) {
    Income income = new Income();
  }

  void show_actionPerformed(ActionEvent e) {

    try {

         jdbTable1.setVisible(true);

         String sql;

           sql = "select * from  income order by dates";

         database1.setConnection(new ConnectionDescriptor("jdbc:oracle:oci8:@",
             "system", "manager", false, "oracle.jdbc.driver.OracleDriver"));
         Statement statement = database1.createStatement();
         queryDataSet1.close();
         queryDataSet1.setQuery(new com.borland.dx.sql.dataset.QueryDescriptor(
             database1, sql, null, true, Load.ALL));
         queryDataSet1.executeQuery();
         jdbTable1.setDataSet(queryDataSet1);
         database1.closeConnection();


         double income_indoor=0,income_outdoor=0,totals=0,in=0,out=0;
         stat = connection.createStatement();
         rset = stat.executeQuery(sql);
         while (rset.next()) {
           income_indoor  = Double.parseDouble(rset.getString("indoor"));
           in+=income_indoor;
           income_outdoor  = Double.parseDouble(rset.getString("outdoor"));
           out+=income_outdoor;
         }
         totals = in+out;
         indoor.setText(""+in);
         outdoor.setText(""+out);
         total.setText(""+totals);

       }
       catch (Exception ex) {
         DBExceptionHandler.handleException(ex);
       }


  }

  void exit_actionPerformed(ActionEvent e) {
      dispose();
  }
}

class Income_show_actionAdapter implements java.awt.event.ActionListener {
  Income adaptee;

  Income_show_actionAdapter(Income adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.show_actionPerformed(e);
  }
}

class Income_exit_actionAdapter implements java.awt.event.ActionListener {
  Income adaptee;

  Income_exit_actionAdapter(Income adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.exit_actionPerformed(e);
  }
}
