package inventory;

import javax.swing.*;
import java.awt.*;
import com.borland.dbswing.*;
import java.awt.event.*;
import java.sql.*;


import com.borland.dx.sql.dataset.*;
import com.borland.dbswing.*;
import com.borland.dx.sql.dataset.ConnectionDescriptor;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class LCSearch extends JFrame {
  JPanel jPanel1 = new JPanel();
  JLabel jLabel1 = new JLabel();
  JPanel jPanel2 = new JPanel();
  JLabel jLabel2 = new JLabel();
  JTextField n1 = new JTextField();
  JLabel jLabel3 = new JLabel();
  JTextField n2 = new JTextField();
  JLabel jLabel4 = new JLabel();
  JTextField y = new JTextField();
  JPanel jPanel3 = new JPanel();
  TableScrollPane tableScrollPane1 = new TableScrollPane();
  JdbTable jdbTable1 = new JdbTable();
  JPanel jPanel4 = new JPanel();
  JButton search = new JButton();
  JButton all = new JButton();
  JButton exit = new JButton();
  Statement stat;
  Database database1 = new Database();
  QueryDataSet queryDataSet1 = new QueryDataSet();
  JComboBox combo = new JComboBox(Main.type);
  JLabel jLabel5 = new JLabel();

  public LCSearch() {
    try {
      jbInit();
      jdbTable1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
      setSize(520,380);
      centerScreen();
      show();
    }
    catch(Exception ex) {
      ex.printStackTrace();
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
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setResizable(false);
    this.getContentPane().setLayout(null);
    jPanel1.setBorder(BorderFactory.createRaisedBevelBorder());
    jPanel1.setBounds(new Rectangle(12, 6, 486, 32));
    jPanel1.setLayout(null);
    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13));
    jLabel1.setForeground(Color.blue);
    jLabel1.setText("LC SEARCH");
    jLabel1.setBounds(new Rectangle(196, 4, 95, 23));
    jPanel2.setBorder(BorderFactory.createLineBorder(Color.black));
    jPanel2.setBounds(new Rectangle(12, 40, 488, 62));
    jPanel2.setLayout(null);
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel2.setHorizontalTextPosition(SwingConstants.CENTER);
    jLabel2.setText("Give Start UP No");
    jLabel2.setBounds(new Rectangle(5, 5, 99, 20));
    n1.setDoubleBuffered(false);
    n1.setText("");
    n1.setBounds(new Rectangle(4, 26, 105, 24));
    jLabel3.setBounds(new Rectangle(125, 6, 99, 20));
    jLabel3.setText("Give End UP No");
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel3.setHorizontalTextPosition(SwingConstants.CENTER);
    n2.setBounds(new Rectangle(124, 27, 105, 24));
    n2.setText("");
    n2.setDoubleBuffered(false);
    jLabel4.setBounds(new Rectangle(244, 5, 99, 20));
    jLabel4.setText("Give Year(YYYY)");
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel4.setHorizontalTextPosition(SwingConstants.CENTER);
    y.setBounds(new Rectangle(243, 26, 105, 24));
    y.setText("");
    y.setDoubleBuffered(false);
    jPanel3.setBorder(BorderFactory.createLineBorder(Color.black));
    jPanel3.setBounds(new Rectangle(14, 110, 487, 174));
    jPanel3.setLayout(null);
    tableScrollPane1.setBounds(new Rectangle(2, 3, 482, 169));
    jPanel4.setBorder(BorderFactory.createEtchedBorder());
    jPanel4.setBounds(new Rectangle(13, 291, 491, 45));
    jPanel4.setLayout(null);
    search.setBounds(new Rectangle(25, 10, 105, 27));
    search.setFont(new java.awt.Font("Dialog", 1, 12));
    search.setBorder(BorderFactory.createRaisedBevelBorder());
    search.setMnemonic('S');
    search.setText("Search");
    search.addActionListener(new LCSearch_search_actionAdapter(this));
    all.setText("Show All");
    all.addActionListener(new LCSearch_all_actionAdapter(this));
    all.setFont(new java.awt.Font("Dialog", 1, 12));
    all.setBounds(new Rectangle(160, 10, 105, 27));
    all.setBorder(BorderFactory.createRaisedBevelBorder());
    all.setMnemonic('A');
    exit.setText("Exit");
    exit.addActionListener(new LCSearch_exit_actionAdapter(this));
    exit.setFont(new java.awt.Font("Dialog", 1, 12));
    exit.setBounds(new Rectangle(301, 9, 105, 27));
    exit.setBorder(BorderFactory.createRaisedBevelBorder());
    exit.setMnemonic('X');
    combo.setBounds(new Rectangle(364, 25, 112, 25));
    jLabel5.setHorizontalTextPosition(SwingConstants.CENTER);
    jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel5.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel5.setText("Type");
    jLabel5.setBounds(new Rectangle(366, 3, 99, 20));
    this.getContentPane().add(jPanel1, null);
    jPanel1.add(jLabel1, null);
    this.getContentPane().add(jPanel2, null);
    jPanel2.add(jLabel2, null);
    jPanel2.add(n1, null);
    jPanel2.add(n2, null);
    jPanel2.add(jLabel3, null);
    jPanel2.add(y, null);
    jPanel2.add(jLabel4, null);
    jPanel2.add(combo, null);
    jPanel2.add(jLabel5, null);
    this.getContentPane().add(jPanel3, null);
    jPanel3.add(tableScrollPane1, null);
    this.getContentPane().add(jPanel4, null);
    jPanel4.add(search, null);
    tableScrollPane1.getViewport().add(jdbTable1, null);
    jPanel4.add(all, null);
    jPanel4.add(exit, null);
  }

  public static void main(String[] args) {
    LCSearch LCSearch = new LCSearch();
  }

  void search_actionPerformed(ActionEvent e) {

    String year="";
    int start=0,end=0;
    if(n1.getText().equals(""))
      JOptionPane.showMessageDialog(null,"Give Starting UP No");
    else if(n2.getText().equals(""))
      JOptionPane.showMessageDialog(null,"Give Ending UP No");
    else if(y.getText().equals(""))
      JOptionPane.showMessageDialog(null,"Give Year");
    else
    {
        start = Integer.parseInt(n1.getText());
        end = Integer.parseInt(n2.getText());
        year = y.getText();
      try {
        String sql = "select * from up_no_"+combo.getSelectedItem()+" where UP_No>= "+start+" AND UP_No <= "+end+" AND UP_Date like '%"+year+"' ";
        database1.setConnection(new ConnectionDescriptor(Main.url,
            Main.user_name, Main.password, false, "com.mysql.jdbc.Driver"));
        stat = database1.createStatement();
        queryDataSet1.close();
        queryDataSet1.setQuery(new com.borland.dx.sql.dataset.QueryDescriptor(
            database1,
            sql, null, true, Load.ALL));
        queryDataSet1.executeQuery();
        jdbTable1.setDataSet(queryDataSet1);
        database1.closeConnection();

      }

      catch (Exception ex) {
        DBExceptionHandler.handleException(ex);
        // JOptionPane.showMessageDialog(null, " DB TABLE ERROR");
      }


    }

  }

  void all_actionPerformed(ActionEvent e) {

    n1.setText("");
    n2.setText("");
    y.setText("");

    try {
        String sql = "select * from up_no_"+combo.getSelectedItem()+"";
          database1.setConnection(new ConnectionDescriptor(Main.url,
               Main.user_name, Main.password, false, "com.mysql.jdbc.Driver"));
           stat = database1.createStatement();
           queryDataSet1.close();
           queryDataSet1.setQuery(new com.borland.dx.sql.dataset.QueryDescriptor(
               database1,
               sql, null, true, Load.ALL));
           queryDataSet1.executeQuery();
           jdbTable1.setDataSet(queryDataSet1);
           database1.closeConnection();

   }

   catch (Exception ex) {
           DBExceptionHandler.handleException(ex);
          // JOptionPane.showMessageDialog(null, " DB TABLE ERROR");
         }



  }

  void exit_actionPerformed(ActionEvent e) {
    dispose();
  }
}

class LCSearch_search_actionAdapter implements java.awt.event.ActionListener {
  LCSearch adaptee;

  LCSearch_search_actionAdapter(LCSearch adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.search_actionPerformed(e);
  }
}

class LCSearch_all_actionAdapter implements java.awt.event.ActionListener {
  LCSearch adaptee;

  LCSearch_all_actionAdapter(LCSearch adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.all_actionPerformed(e);
  }
}

class LCSearch_exit_actionAdapter implements java.awt.event.ActionListener {
  LCSearch adaptee;

  LCSearch_exit_actionAdapter(LCSearch adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.exit_actionPerformed(e);
  }
}
