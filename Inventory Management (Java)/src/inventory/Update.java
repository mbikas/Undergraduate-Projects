package inventory;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import com.borland.dbswing.*;
import java.awt.event.*;
import java.sql.*;


import com.borland.dx.sql.dataset.*;
import com.borland.dbswing.*;
import com.borland.dx.sql.dataset.ConnectionDescriptor;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Update extends JFrame {

  static String bname=null;
  static String bdate=null;
  static String cname=null;

  JPanel jPanel1 = new JPanel();
  JLabel jLabel1 = new JLabel();
  JPanel jPanel2 = new JPanel();
  JLabel jLabel2 = new JLabel();
  TableScrollPane tableScrollPane1 = new TableScrollPane();
  JdbTable jdbTable1 = new JdbTable();
  JPanel jPanel3 = new JPanel();
  JLabel jLabel3 = new JLabel();
  JScrollPane jScrollPane1 = new JScrollPane();
  JScrollPane jScrollPane2 = new JScrollPane();
  JLabel jLabel4 = new JLabel();
  JScrollPane jScrollPane3 = new JScrollPane();
  JLabel name_lable = new JLabel();
  JPanel jPanel4 = new JPanel();
  JButton update = new JButton();
  JButton jButton2 = new JButton();
  Database database1 = new Database();
  QueryDataSet queryDataSet1 = new QueryDataSet();
  JList b_list = new JList();
  Connection connection=Main.conn;
  JList d_list = new JList();
  JList c_list = new JList();
  Statement stat;

  public Update() {
    try {
      jbInit();

      name_lable.setText("Select "+Main.names + " Name");
      jdbTable1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);


       show_all();
       show_bond_name();
      setSize(590,500);
      centerScreen();
      show();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }


    //listener for bond name list
    b_list.addListSelectionListener(
        new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent e) {
        try {

          ResultSet rset;
          String sql;
          String s = (String) b_list.getSelectedValue();
          stat = connection.createStatement();
          sql = "select Bond_Date from "+Main.entryTable+" where Bond_Name = '" + s +
              "' order by Bond_Date";
          rset = stat.executeQuery(sql);
          int p = 0, i;
          String str1[] = new String[100];
          while (rset.next()) {
            str1[p] = rset.getString("Bond_Date");
            p++;
          }
          String str[] = new String[p];
          for (i = 0; i < p; i++)
            str[i] = str1[i];
          d_list.setListData(str);
          stat.close();
          rset.close();
        }
        catch (SQLException sqlException) {
          JOptionPane.showMessageDialog(null, sqlException.getMessage(),
                                        "Database error",
                                        JOptionPane.ERROR_MESSAGE);
        }

      }
    }
    );

    //listener for bond date list
    d_list.addListSelectionListener(
        new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent e) {
        try {

          ResultSet rset;
          String sql;
          String s1 = (String) b_list.getSelectedValue();
          String s2 = (String) d_list.getSelectedValue();
          stat = connection.createStatement();
          sql = "select "+Main.names+"_Name from "+Main.entryTable+" where (Bond_Name = '" + s1 +
              "'  AND Bond_Date = '" + s2 + "') order by "+Main.names+"_Name";
          rset = stat.executeQuery(sql);
          int p = 0, i;
          String str1[] = new String[100];

          while (rset.next()) {
            str1[p] = rset.getString(""+Main.names+"_Name");
            p++;
          }
          String str[] = new String[p];
          for (i = 0; i < p; i++)
            str[i] = str1[i];
          c_list.setListData(str);

          stat.close();
          rset.close();
        }
        catch (SQLException sqlException) {
          JOptionPane.showMessageDialog(null, sqlException.getMessage(),
                                        "Database error",
                                        JOptionPane.ERROR_MESSAGE);
        }

      }
    }
    );




  }



  void centerScreen()
       {
               Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
               int x = (int) ((d.getWidth() - getWidth()) / 2);
               int y = (int) ((d.getHeight() - getHeight()) / 2);
               setLocation(x, y);
       }

    void show_all()
    {

      database1.setConnection(new ConnectionDescriptor(Main.url,
          Main.user_name, Main.password, false, "com.mysql.jdbc.Driver"));
      Statement statement = database1.createStatement();
      queryDataSet1.close();
      queryDataSet1.setQuery(new com.borland.dx.sql.dataset.QueryDescriptor(
          database1,
        "select * from "+Main.entryTable+" order by "+Main.names+"_Name", null, true, Load.ALL));
      queryDataSet1.executeQuery();
      jdbTable1.setDataSet(queryDataSet1);

     //database1.closeConnection();

    }
    void show_bond_name()
    {

      try{

        Statement stat = connection.createStatement();
        ResultSet rset = stat.executeQuery("select Bond_Name from "+Main.entryTable+" order by Bond_Name");
        String temp[]=new String[100];
        int p=0;
        while (rset.next()) {
          temp[p++] = rset.getString("Bond_Name");
        }
        String str[]=new String[p];
        for(int i=0;i<p;i++)str[i]=temp[i];

        b_list.setListData(str);



      }
      catch (SQLException sqlException) {
       JOptionPane.showMessageDialog(null, sqlException.getMessage(),
                                     "Database error",
                                     JOptionPane.ERROR_MESSAGE);
     }





    }


  void jbInit() throws Exception {
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setResizable(false);
    this.getContentPane().setLayout(null);
    jPanel1.setBorder(BorderFactory.createRaisedBevelBorder());
    jPanel1.setDoubleBuffered(true);
    jPanel1.setBounds(new Rectangle(13, 5, 550, 34));
    jPanel1.setLayout(null);
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel1.setForeground(Color.blue);
    jLabel1.setText("UPDATE");
    jLabel1.setBounds(new Rectangle(227, 7, 68, 22));
    jPanel2.setBorder(BorderFactory.createLineBorder(Color.black));
    jPanel2.setBounds(new Rectangle(14, 45, 549, 220));
    jPanel2.setLayout(null);
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel2.setText("Stored Data");
    jLabel2.setBounds(new Rectangle(12, 3, 78, 19));
    tableScrollPane1.setBounds(new Rectangle(6, 28, 538, 187));
    jPanel3.setBorder(BorderFactory.createLineBorder(Color.black));
    jPanel3.setBounds(new Rectangle(14, 270, 550, 117));
    jPanel3.setLayout(null);
    jLabel3.setBounds(new Rectangle(6, 3, 109, 19));
    jLabel3.setText("Select Bond Name");
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 12));
    jScrollPane1.setBounds(new Rectangle(8, 22, 109, 80));
    jScrollPane2.setBounds(new Rectangle(169, 22, 109, 80));
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel4.setText("Select Bond Date");
    jLabel4.setBounds(new Rectangle(170, 5, 105, 17));
    jScrollPane3.setBounds(new Rectangle(341, 23, 132, 80));
    name_lable.setFont(new java.awt.Font("Dialog", 1, 12));
    name_lable.setText("Select Chemical Name");
    name_lable.setBounds(new Rectangle(340, 4, 138, 19));
    jPanel4.setBorder(BorderFactory.createLineBorder(Color.black));
    jPanel4.setBounds(new Rectangle(13, 391, 551, 45));
    jPanel4.setLayout(null);
    update.setBounds(new Rectangle(29, 8, 113, 27));
    update.setFont(new java.awt.Font("Dialog", 1, 12));
    update.setBorder(BorderFactory.createRaisedBevelBorder());
    update.setDoubleBuffered(false);
    update.setContentAreaFilled(true);
    update.setMnemonic('U');
    update.setRolloverEnabled(true);
    update.setSelected(false);
    update.setText("Update");
    update.addActionListener(new Update_update_actionAdapter(this));
    jButton2.setText("Exit");
    jButton2.addActionListener(new Update_jButton2_actionAdapter(this));
    jButton2.setBorder(BorderFactory.createRaisedBevelBorder());
    jButton2.setVerifyInputWhenFocusTarget(true);
    jButton2.setMnemonic('X');
    jButton2.setSelected(false);
    jButton2.setFont(new java.awt.Font("Dialog", 1, 12));
    jButton2.setBounds(new Rectangle(295, 6, 113, 27));
    jdbTable1.setBorder(BorderFactory.createLineBorder(Color.black));
    jdbTable1.setEditable(false);
    this.getContentPane().add(jPanel1, null);
    jPanel1.add(jLabel1, null);
    this.getContentPane().add(jPanel2, null);
    jPanel2.add(tableScrollPane1, null);
    jPanel2.add(jLabel2, null);
    this.getContentPane().add(jPanel3, null);
    jPanel3.add(jLabel3, null);
    jPanel3.add(jLabel4, null);
    jPanel3.add(jScrollPane2, null);
    jScrollPane2.getViewport().add(d_list, null);
    jPanel3.add(jScrollPane1, null);
    jScrollPane1.getViewport().add(b_list, null);
    jPanel3.add(jScrollPane3, null);
    jPanel3.add(name_lable, null);
    this.getContentPane().add(jPanel4, null);
    jPanel4.add(update, null);
    jPanel4.add(jButton2, null);
    tableScrollPane1.getViewport().add(jdbTable1, null);
    jScrollPane3.getViewport().add(c_list, null);
  }

  public static void main(String[] args) {
    Update update = new Update();
  }

  void jButton2_actionPerformed(ActionEvent e) {
     dispose();
  }

  void update_actionPerformed(ActionEvent e) {


    bname = (String)b_list.getSelectedValue();
    bdate = (String)d_list.getSelectedValue();
    cname = (String)c_list.getSelectedValue();

    if(bname==null)
      JOptionPane.showMessageDialog(null,"Select Bond Name");
    else if(bdate==null)
      JOptionPane.showMessageDialog(null,"Select Bond Date");
    else if(cname==null)
      JOptionPane.showMessageDialog(null,"Select "+Main.names+" Name");
    else
    {

        dispose();
        new FinalUpdate();

    }

  }
}

class Update_jButton2_actionAdapter implements java.awt.event.ActionListener {
  Update adaptee;

  Update_jButton2_actionAdapter(Update adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton2_actionPerformed(e);
  }
}

class Update_update_actionAdapter implements java.awt.event.ActionListener {
  Update adaptee;

  Update_update_actionAdapter(Update adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.update_actionPerformed(e);
  }
}
