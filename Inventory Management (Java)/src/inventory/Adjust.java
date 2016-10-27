package inventory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.event.*;
import javax.swing.border.*;

import java.awt.event.*;
import java.awt.print.Printable;
import java.awt.print.PageFormat;
import java.awt.print.PrinterJob;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.text.DecimalFormat;

public class Adjust extends JFrame {
  JPanel jPanel1 = new JPanel();
  JLabel jLabel1 = new JLabel();
  JPanel jPanel2 = new JPanel();
  JLabel jLabel2 = new JLabel();
  JTextField upn = new JTextField();
  JLabel jLabel3 = new JLabel();
  JTextField upd = new JTextField();
  JList bname_list = new JList();
  JScrollPane jScrollPane1 = new JScrollPane();
  JLabel jLabel4 = new JLabel();
  JLabel jLabel5 = new JLabel();
  JScrollPane jScrollPane2 = new JScrollPane();
  JLabel name_label = new JLabel();
  JScrollPane jScrollPane3 = new JScrollPane();
  JList ch_list = new JList();
  JLabel jLabel7 = new JLabel();
  JTextField imp_v = new JTextField();
  JLabel jLabel8 = new JLabel();
  JTextField imp_q = new JTextField();
  JLabel jLabel9 = new JLabel();
  JLabel jLabel10 = new JLabel();
  JTextField val = new JTextField();
  JTextField quan = new JTextField();
  JLabel jLabel11 = new JLabel();
  JTextField adj_v = new JTextField();
  JLabel jLabel12 = new JLabel();
  JTextField adj_q = new JTextField();
  JLabel jLabel13 = new JLabel();
  JLabel jLabel14 = new JLabel();
  JTextField balance_q = new JTextField();
  JTextField balance_v = new JTextField();
  Statement stat;
  DecimalFormat three = new DecimalFormat("0.000");
  String entry_table=Main.entryTable;
  String up_table = Main.upTable;


  JList dlist = new JList();
  JList clist = new JList();
  JPanel jPanel3 = new JPanel();
  TitledBorder titledBorder1;
  TitledBorder titledBorder2;
  JButton Update = new JButton();
  JButton exit = new JButton();


  public Adjust() {
    try {

      jbInit();

      name_label.setText(Main.names+" Name");

       String sql = "select Bond_Name from "+entry_table+" order by Bond_name";
       stat = Main.conn.createStatement();
       ResultSet rset = stat.executeQuery(sql);
       double import_quantity=0,import_value=0,unit_price=0;
       String temp[]=new String[100];
       int p=0;
       while (rset.next()) {
         temp[p] = rset.getString("Bond_Name");
         p++;
       }
       String b_name[]=new String[p];
       for(int i=0;i<p;i++)b_name[i]=temp[i];
       bname_list.setListData(b_name);




      ///////////////////



      setSize(500,500);
      centerScreen();

      show();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }


    //listener for bond name list
    bname_list.addListSelectionListener(
        new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent e) {
        try {

           ResultSet rset;
          String sql;
          String s =(String) bname_list.getSelectedValue();
          stat = Main.conn.createStatement();
          sql = "select Bond_Date from "+entry_table+" where Bond_Name = '"+s+"' order by Bond_Date";
          rset = stat.executeQuery(sql);
          int p=0,i;
          String str1[] = new String[100];
          while (rset.next()) {
            str1[p] = rset.getString("Bond_Date");
            p++;
          }
          String str[] = new String[p];
          for(i=0;i<p;i++)
                  str[i] = str1[i];
          dlist.setListData(str);
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
  dlist.addListSelectionListener(
      new ListSelectionListener() {
    public void valueChanged(ListSelectionEvent e) {
      try {

        ResultSet rset;
        String sql;
        String s1 = (String)  bname_list.getSelectedValue();
        String  s2 = (String) dlist.getSelectedValue();
        //JOptionPane.showMessageDialog(null,s1);
        //JOptionPane.showMessageDialog(null,s2);
        stat = Main.conn.createStatement();
        sql = "select "+Main.names+"_Name from "+entry_table+" where (Bond_Name = '"+s1+"'  AND Bond_Date = '"+s2+"') order by "+Main.names+"_Name";
        rset = stat.executeQuery(sql);
        int p=0,i;
        String str1[] = new String[100];


        while (rset.next()) {
          str1[p] = rset.getString(""+Main.names+"_Name");
          p++;
        }
        String str[] = new String[p];
        for(i=0;i<p;i++)
                str[i] = str1[i];
        clist.setListData(str);

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

  //listener for chemical_name list
  clist.addListSelectionListener(
      new ListSelectionListener() {
    public void valueChanged(ListSelectionEvent e) {

      String s1 = (String) bname_list.getSelectedValue();
      String s2 = (String) dlist.getSelectedValue();
      String s3 = (String) clist.getSelectedValue();

    //  JOptionPane.showMessageDialog(null,s1+"\n"+s2+"\n"+s3);


     if (s1==null || s2==null || s3==null) {
        imp_q.setText("");
        imp_v.setText("");
        adj_q.setText("");
        adj_v.setText("");
        balance_q.setText("");
        balance_v.setText("");
      }
      else {
        try {

          ResultSet rset;
          String sql;

          if (!s1.equals("") && !s2.equals("") && !s3.equals("")) {
            stat = Main.conn.createStatement();
            sql = "select * from "+entry_table+" where (Bond_Name = '" +
                s1 + "'  AND Bond_Date = '" + s2 + "' AND "+Main.names+"_Name = '" +
                s3 + "')";

            rset = stat.executeQuery(sql);

            double n;

            while (rset.next()) {
              n = Double.parseDouble(rset.getString("Import_Quantity"));
              imp_q.setText(String.valueOf(three.format(n)));
              n = Double.parseDouble(rset.getString("Import_Value"));
              imp_v.setText(String.valueOf(three.format(n)));
              n = Double.parseDouble(rset.getString("Adjusted_Quantity"));
              adj_q.setText(String.valueOf(three.format(n)));
              n = Double.parseDouble(rset.getString("Adjusted_Value"));
              adj_v.setText(String.valueOf(three.format(n)));
              n = Double.parseDouble(rset.getString("Balanced_Quantity"));
              balance_q.setText(String.valueOf(three.format(n)));
              n = Double.parseDouble(rset.getString("Balanced_Value"));
              balance_v.setText(String.valueOf(three.format(n)));

            }

            stat.close();
            rset.close();
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
  );





  }

  void centerScreen()
         {
                 Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
                 int x = (int) ((d.getWidth() - getWidth()) / 2);
                 int y = (int) ((d.getHeight() - getHeight()) / 2);
                 setLocation(x, y);
         }

  void jbInit() throws Exception {
    titledBorder1 = new TitledBorder("");
    titledBorder2 = new TitledBorder("");
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setResizable(false);
    this.getContentPane().setLayout(null);
    jPanel1.setBorder(BorderFactory.createRaisedBevelBorder());
    jPanel1.setBounds(new Rectangle(8, 3, 467, 33));
    jPanel1.setLayout(null);
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel1.setForeground(Color.blue);
    jLabel1.setText("Adjust Items");
    jLabel1.setBounds(new Rectangle(175, 4, 84, 23));
    jPanel2.setBorder(BorderFactory.createLineBorder(Color.black));
    jPanel2.setBounds(new Rectangle(9, 42, 466, 370));
    jPanel2.setLayout(null);
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel2.setText("UP No");
    jLabel2.setBounds(new Rectangle(11, 7, 59, 22));
    upn.setText("");
    upn.setBounds(new Rectangle(94, 8, 116, 28));
    jLabel3.setBounds(new Rectangle(219, 10, 59, 22));
    jLabel3.setText("UP Date");
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel3.setToolTipText("DD/MM/YYYY");
    upd.setBounds(new Rectangle(282, 8, 116, 28));
    upd.setToolTipText("DD/MM/YYYY");
    upd.setText("");
    jScrollPane1.setBounds(new Rectangle(12, 68, 96, 117));
    jLabel4.setBounds(new Rectangle(13, 41, 79, 22));
    jLabel4.setText("Bond Name");
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel5.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel5.setText("Bond Date");
    jLabel5.setBounds(new Rectangle(119, 41, 79, 22));
    jScrollPane2.setBounds(new Rectangle(118, 68, 96, 117));
    name_label.setFont(new java.awt.Font("Dialog", 1, 12));
    name_label.setText("Chemical No");
    name_label.setBounds(new Rectangle(227, 41, 100, 22));
    jScrollPane3.setBounds(new Rectangle(227, 69, 96, 117));
    jLabel7.setBounds(new Rectangle(8, 202, 95, 22));
    jLabel7.setText("Import Quantity");
    jLabel7.setFont(new java.awt.Font("Dialog", 1, 12));
    imp_v.setFont(new java.awt.Font("Dialog", 1, 12));
    imp_v.setForeground(Color.blue);
    imp_v.setDoubleBuffered(false);
    imp_v.setEditable(false);
    imp_v.setText("");
    imp_v.setBounds(new Rectangle(340, 200, 116, 24));
    jLabel8.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel8.setText("Import Value");
    jLabel8.setBounds(new Rectangle(241, 201, 83, 22));
    imp_q.setBounds(new Rectangle(113, 202, 116, 24));
    imp_q.setFont(new java.awt.Font("Dialog", 1, 12));
    imp_q.setForeground(Color.blue);
    imp_q.setDoubleBuffered(false);
    imp_q.setEditable(false);
    imp_q.setText("");
    jLabel9.setBounds(new Rectangle(7, 333, 83, 22));
    jLabel9.setText("Adjust Value");
    jLabel9.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel10.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel10.setText("Adjust Quantity");
    jLabel10.setBounds(new Rectangle(8, 304, 95, 22));
    val.setBounds(new Rectangle(115, 331, 116, 24));
    val.setText("");
    quan.setText("");
    quan.setBounds(new Rectangle(115, 304, 116, 24));
    jLabel11.setBounds(new Rectangle(238, 232, 91, 22));
    jLabel11.setText("Adjusted Value");
    jLabel11.setFont(new java.awt.Font("Dialog", 1, 12));
    adj_v.setBounds(new Rectangle(341, 229, 116, 24));
    adj_v.addActionListener(new Adjust_adj_v_actionAdapter(this));
    adj_v.setFont(new java.awt.Font("Dialog", 1, 12));
    adj_v.setForeground(Color.blue);
    adj_v.setDoubleBuffered(false);
    adj_v.setEditable(false);
    adj_v.setText("");
    jLabel12.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel12.setText("Adjusted Quantity");
    jLabel12.setBounds(new Rectangle(10, 232, 103, 22));
    adj_q.setFont(new java.awt.Font("Dialog", 1, 12));
    adj_q.setForeground(Color.blue);
    adj_q.setDoubleBuffered(false);
    adj_q.setEditable(false);
    adj_q.setText("");
    adj_q.setBounds(new Rectangle(114, 231, 116, 24));
    jLabel13.setBounds(new Rectangle(10, 261, 103, 22));
    jLabel13.setText("Balanced Quantity");
    jLabel13.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel14.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel14.setText("Balanced Value");
    jLabel14.setBounds(new Rectangle(238, 261, 91, 22));
    balance_q.setBounds(new Rectangle(114, 260, 116, 24));
    balance_q.setFont(new java.awt.Font("Dialog", 1, 12));
    balance_q.setForeground(Color.blue);
    balance_q.setDoubleBuffered(false);
    balance_q.setEditable(false);
    balance_q.setText("");
    balance_v.setFont(new java.awt.Font("Dialog", 1, 12));
    balance_v.setForeground(Color.blue);
    balance_v.setDoubleBuffered(false);
    balance_v.setEditable(false);
    balance_v.setText("");
    //jTextField10.addActionListener(new Adjust_jTextField10_actionAdapter(this));
    balance_v.setBounds(new Rectangle(341, 258, 116, 24));
    bname_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    dlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    clist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    jPanel3.setBorder(titledBorder2);
    jPanel3.setBounds(new Rectangle(8, 418, 469, 39));
    jPanel3.setLayout(null);
    Update.setBounds(new Rectangle(30, 5, 109, 29));
    Update.setFont(new java.awt.Font("Dialog", 1, 12));
    Update.setBorder(BorderFactory.createRaisedBevelBorder());
    Update.setMnemonic('U');
    Update.setText("Update");
    Update.addActionListener(new Adjust_Update_actionAdapter(this));
    exit.setText("Exit");
    exit.addActionListener(new Adjust_exit_actionAdapter(this));
    exit.setFont(new java.awt.Font("Dialog", 1, 12));
    exit.setBounds(new Rectangle(315, 5, 109, 29));
    exit.setBorder(BorderFactory.createRaisedBevelBorder());
    exit.setMnemonic('X');
    this.getContentPane().add(jPanel1, null);
    jPanel1.add(jLabel1, null);
    this.getContentPane().add(jPanel2, null);
    jPanel2.add(jScrollPane1, null);
    jScrollPane1.getViewport().add(bname_list, null);
    jPanel2.add(jLabel4, null);
    jPanel2.add(upd, null);
    jPanel2.add(jLabel3, null);
    jPanel2.add(upn, null);
    jPanel2.add(jLabel2, null);
    jPanel2.add(jScrollPane2, null);
    jScrollPane2.getViewport().add(dlist, null);
    jPanel2.add(jLabel5, null);
    jPanel2.add(jScrollPane3, null);
    jPanel2.add(name_label, null);
    jPanel2.add(imp_q, null);
    jPanel2.add(jLabel11, null);
    jPanel2.add(adj_q, null);
    jPanel2.add(jLabel12, null);
    jPanel2.add(jLabel7, null);
    jPanel2.add(imp_v, null);
    jPanel2.add(jLabel8, null);
    jPanel2.add(adj_v, null);
    jPanel2.add(balance_v, null);
    jPanel2.add(jLabel13, null);
    jPanel2.add(balance_q, null);
    jPanel2.add(jLabel14, null);
    jPanel2.add(quan, null);
    jPanel2.add(val, null);
    jPanel2.add(jLabel10, null);
    jPanel2.add(jLabel9, null);
    this.getContentPane().add(jPanel3, null);
    jPanel3.add(Update, null);
    jScrollPane3.getViewport().add(clist, null);
    jPanel3.add(exit, null);
  }

  public static void main(String[] args) {
    Adjust adjust = new Adjust();
  }

  void adj_v_actionPerformed(ActionEvent e) {

  }

  void Update_actionPerformed(ActionEvent e) {

    String up_no="",up_date="",list1=null,list2=null,list3=null;
    String quantity="",value="";

    up_no =  upn.getText();
    up_date =  upd.getText();
    list1 = (String) bname_list.getSelectedValue();
    list2 = (String) dlist.getSelectedValue();
    list3 = (String) clist.getSelectedValue();
    quantity = quan.getText();
    value = val.getText();
    String sql="";

    if(!up_no.equals("") &&  !up_date.equals("") && !(list1==null) && !(list2==null) && !(list3==null) && !quantity.equals("") && !value.equals("") )
    {
      try{

        boolean insertResult;
        sql = "select Import_Quantity,Import_value,Adjusted_Quantity,Adjusted_Value from "+entry_table+" where (Bond_Name = '"+list1+"' AND Bond_Date = '"+list2+"' AND "+Main.names+"_Name = '"+list3+"')";
        //JOptionPane.showMessageDialog(null,sql);
        stat = Main.conn.createStatement();
        ResultSet rset = stat.executeQuery(sql);
        double imp_quantity=0,imp_value=0,adj_quantity=0,adj_value=0,q=0,v=0;
        double balance_quan=0,balance_val=0;
        int p=0;
        while (rset.next()) {
        imp_quantity = Double.parseDouble(rset.getString("Import_Quantity"));
        imp_value = Double.parseDouble(rset.getString("Import_Value"));
        adj_quantity = Double.parseDouble(rset.getString("Adjusted_Quantity"));
        adj_value = Double.parseDouble(rset.getString("Adjusted_Value"));
       }

       q = Double.parseDouble(quantity);
       v = Double.parseDouble(value);




       adj_quantity +=q;
       adj_value +=v;
       balance_quan = imp_quantity - adj_quantity;
       balance_val = imp_value - adj_value;

       if (balance_quan < 0)
         JOptionPane.showMessageDialog(null,
                                       "Invalid Input\nExceed your Balanced Quantity");
       else if (balance_val < 0)
         JOptionPane.showMessageDialog(null,
                                       "Invalid Input\nExceed your Balanced Value");
       else {

         imp_q.setText(String.valueOf(three.format(imp_quantity)));
         imp_v.setText(String.valueOf(three.format(imp_value)));
         adj_q.setText(String.valueOf(three.format(adj_quantity)));
         adj_v.setText(String.valueOf(three.format(adj_value)));
         balance_q.setText(String.valueOf(three.format(balance_quan)));
         balance_v.setText(String.valueOf(three.format(balance_val)));

         sql = "update "+entry_table+" set UP_No ='" + up_no + "' , UP_Date='" +
             up_date + "' , Adjusted_Quantity =" + adj_quantity +
             " , Adjusted_Value =" + adj_value + " , Balanced_Quantity =" +
             balance_quan + " , Balanced_Value =" + balance_val +
             "  where (Bond_Name = '" + list1 + "' AND Bond_Date = '" + list2 +
             "' AND "+Main.names+"_Name = '" + list3 + "')";
         insertResult = stat.execute(sql);
       }





      }
      catch (SQLException sqlException) {
        JOptionPane.showMessageDialog(null, sqlException.getMessage(),
                                      "Database error",
                                      JOptionPane.ERROR_MESSAGE);
      }



    }
    else
    {
        JOptionPane.showMessageDialog(null,"Fill all the Fields");
    }




  }

  void exit_actionPerformed(ActionEvent e) {
    dispose();
  }
}

class Adjust_adj_v_actionAdapter implements java.awt.event.ActionListener {
  Adjust adaptee;

  Adjust_adj_v_actionAdapter(Adjust adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.adj_v_actionPerformed(e);
  }
}

class Adjust_Update_actionAdapter implements java.awt.event.ActionListener {
  Adjust adaptee;

  Adjust_Update_actionAdapter(Adjust adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.Update_actionPerformed(e);
  }
}

class Adjust_exit_actionAdapter implements java.awt.event.ActionListener {
  Adjust adaptee;

  Adjust_exit_actionAdapter(Adjust adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.exit_actionPerformed(e);
  }
}
