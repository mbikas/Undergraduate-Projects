package inventory;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.border.*;


public class BillEntry extends JFrame {

  public Statement stat;
  JPanel jPanel1 = new JPanel();
  JLabel jLabel1 = new JLabel();
  JPanel jPanel2 = new JPanel();
  JLabel jLabel2 = new JLabel();
  JTextField bondName = new JTextField();
  JLabel jLabel3 = new JLabel();
  JTextField bondDate = new JTextField();
  JLabel jLabel4 = new JLabel();
  JTextField lcDate = new JTextField();
  JTextField lcNo = new JTextField();
  JLabel jLabel5 = new JLabel();
  JTextField bondEntry = new JTextField();
  JLabel jLabel6 = new JLabel();
  JLabel jLabel7 = new JLabel();
  JTextField beDate = new JTextField();
  JTextField beNo = new JTextField();
  JLabel jLabel8 = new JLabel();
  JLabel name_label = new JLabel();
  JTextField chName = new JTextField();
  JLabel des_label = new JLabel();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextArea chDesp = new JTextArea();
  JLabel jLabel11 = new JLabel();
  JTextField impValue = new JTextField();
  JLabel jLabel12 = new JLabel();
  JTextField impQuantity = new JTextField();
  JLabel jLabel13 = new JLabel();
  JTextField unitPrice = new JTextField();
  JLabel jLabel14 = new JLabel();
  JLabel jLabel15 = new JLabel();
  JTextField pageNo = new JTextField();
  JTextField vol = new JTextField();
  JLabel jLabel16 = new JLabel();
  JTextField hsCode = new JTextField();
  JPanel jPanel3 = new JPanel();
  JButton entry = new JButton();
  JButton jButton2 = new JButton();
  TitledBorder titledBorder1;
  Connection connection=Main.conn;
  String entry_table=Main.entryTable;
  String up_table = Main.upTable;



  public BillEntry() {
    try {
      jbInit();

      name_label.setText(Main.names+" Name");
      des_label.setText(Main.names+" Description");

      //JOptionPane.showMessageDialog(null,entry_table);


      setSize(550,480);
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
    titledBorder1 = new TitledBorder("");
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setResizable(false);
    this.getContentPane().setLayout(null);
    jPanel1.setBorder(BorderFactory.createRaisedBevelBorder());
    jPanel1.setBounds(new Rectangle(14, 6, 518, 33));
    jPanel1.setLayout(null);
    jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 13));
    jLabel1.setForeground(Color.blue);
    jLabel1.setText("DATA ENTRY");
    jLabel1.setBounds(new Rectangle(229, 4, 100, 22));
    jPanel2.setBorder(BorderFactory.createLineBorder(Color.black));
    jPanel2.setBounds(new Rectangle(15, 45, 516, 325));
    jPanel2.setLayout(null);
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel2.setBorder(null);
    jLabel2.setText("Bond Name");
    jLabel2.setBounds(new Rectangle(9, 13, 72, 22));
    bondName.setText("");
    bondName.setBounds(new Rectangle(132, 12, 121, 22));
    jLabel3.setBounds(new Rectangle(281, 11, 87, 22));
    jLabel3.setText("Bond Date");
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel3.setToolTipText("DD/MM/YYYY");
    bondDate.setBounds(new Rectangle(384, 11, 121, 22));
    bondDate.setToolTipText("DD/MM/YYYY");
    bondDate.setSelectionStart(0);
    bondDate.setText("");
    jLabel4.setBounds(new Rectangle(281, 44, 50, 22));
    jLabel4.setText("L/C No");
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 12));
    lcDate.setToolTipText("DD/MM/YYYY");
    lcDate.setText("");
    lcDate.setBounds(new Rectangle(132, 72, 121, 22));
    lcNo.setBounds(new Rectangle(384, 41, 121, 22));
    lcNo.setText("");
    jLabel5.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel5.setBorder(null);
    jLabel5.setToolTipText("DD/MM/YYYY");
    jLabel5.setText("L/C Date");
    jLabel5.setBounds(new Rectangle(9, 71, 56, 22));
    bondEntry.setToolTipText("DD/MM/YYYY");
    bondEntry.setText("");
    bondEntry.setBounds(new Rectangle(132, 41, 121, 22));
    jLabel6.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel6.setBorder(null);
    jLabel6.setToolTipText("DD/MM/YYYY");
    jLabel6.setText("Into Bond Date");
    jLabel6.setBounds(new Rectangle(9, 40, 96, 22));
    jLabel7.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel7.setText("B/E No");
    jLabel7.setBounds(new Rectangle(281, 75, 50, 22));
    beDate.setBounds(new Rectangle(132, 103, 121, 22));
    beDate.setToolTipText("DD/MM/YYYY");
    beDate.setText("");
    beNo.setText("");
    beNo.setBounds(new Rectangle(384, 70, 121, 22));
    jLabel8.setBounds(new Rectangle(9, 100, 56, 22));
    jLabel8.setText("B/E Date");
    jLabel8.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel8.setBorder(null);
    jLabel8.setToolTipText("DD/MM/YYYY");
    name_label.setBounds(new Rectangle(281, 104, 92, 22));
    name_label.setText("Chemical Name");
    name_label.setFont(new java.awt.Font("Dialog", 1, 12));
    chName.setBounds(new Rectangle(384, 101, 121, 22));
    chName.setText("");
    des_label.setFont(new java.awt.Font("Dialog", 1, 12));
    des_label.setText("Chemical Description");
    des_label.setBounds(new Rectangle(9, 137, 121, 22));
    jScrollPane1.setBounds(new Rectangle(134, 142, 370, 70));
    chDesp.setText("");
    jLabel11.setBounds(new Rectangle(9, 226, 112, 22));
    jLabel11.setText("import Quantity");
    jLabel11.setFont(new java.awt.Font("Dialog", 1, 12));
    impValue.setText("");
    impValue.setBounds(new Rectangle(384, 226, 121, 22));
    jLabel12.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel12.setText("Import Value");
    jLabel12.setBounds(new Rectangle(269, 225, 72, 22));
    impQuantity.setBounds(new Rectangle(132, 225, 121, 22));
    impQuantity.setText("");
    jLabel13.setBounds(new Rectangle(9, 285, 72, 22));
    jLabel13.setText("Unit Price");
    jLabel13.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel13.setDisplayedMnemonic('0');
    unitPrice.setBounds(new Rectangle(132, 286, 121, 22));
    unitPrice.setEnabled(false);
    unitPrice.setFont(new java.awt.Font("Dialog", 1, 12));
    unitPrice.setForeground(Color.blue);
    unitPrice.setDisabledTextColor(Color.blue);
    unitPrice.setEditable(false);
    unitPrice.setText("");
    jLabel14.setBounds(new Rectangle(275, 253, 58, 22));
    jLabel14.setText("Page No");
    jLabel14.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel15.setDisplayedMnemonic('0');
    jLabel15.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel15.setText("Volume");
    jLabel15.setBounds(new Rectangle(274, 284, 72, 22));
    pageNo.setBounds(new Rectangle(384, 256, 121, 22));
    pageNo.setText("");
    vol.setText("");
    vol.setEnabled(true);
    vol.setEditable(true);
    vol.setBounds(new Rectangle(384, 283, 121, 22));
    jLabel16.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel16.setText("H.S Code");
    jLabel16.setBounds(new Rectangle(9, 253, 73, 22));
    hsCode.setText("");
    hsCode.setBounds(new Rectangle(132, 253, 121, 22));
    hsCode.addActionListener(new BillEntry_hsCode_actionAdapter(this));
    jPanel3.setBorder(BorderFactory.createEtchedBorder());
    jPanel3.setBounds(new Rectangle(14, 377, 519, 50));
    jPanel3.setLayout(null);
    entry.setBounds(new Rectangle(51, 11, 105, 29));
    entry.setFont(new java.awt.Font("Dialog", 1, 12));
    entry.setBorder(BorderFactory.createRaisedBevelBorder());
    entry.setToolTipText("");
    entry.setMnemonic('E');
    entry.setText("Entry");
    entry.addActionListener(new BillEntry_entry_actionAdapter(this));
    jButton2.setText("Exit");
    jButton2.addActionListener(new BillEntry_jButton2_actionAdapter(this));
    jButton2.setBorder(BorderFactory.createRaisedBevelBorder());
    jButton2.setMnemonic('X');
    jButton2.setFont(new java.awt.Font("Dialog", 1, 12));
    jButton2.setBounds(new Rectangle(292, 11, 105, 29));
    this.getContentPane().add(jPanel1, null);
    jPanel1.add(jLabel1, null);
    this.getContentPane().add(jPanel2, null);
    jPanel2.add(jLabel2, null);
    jPanel2.add(des_label, null);
    jPanel2.add(bondName, null);
    jPanel2.add(jScrollPane1, null);
    jScrollPane1.getViewport().add(chDesp, null);
    jPanel2.add(impQuantity, null);
    jPanel2.add(jLabel11, null);
    jPanel2.add(unitPrice, null);
    jPanel2.add(jLabel13, null);
    jPanel2.add(jLabel14, null);
    jPanel2.add(jLabel15, null);
    jPanel2.add(bondEntry, null);
    jPanel2.add(jLabel6, null);
    jPanel2.add(jLabel5, null);
    jPanel2.add(jLabel8, null);
    jPanel2.add(jLabel12, null);
    jPanel2.add(jLabel16, null);
    jPanel2.add(lcDate, null);
    jPanel2.add(beDate, null);
    jPanel2.add(bondDate, null);
    jPanel2.add(lcNo, null);
    jPanel2.add(beNo, null);
    jPanel2.add(chName, null);
    jPanel2.add(jLabel4, null);
    jPanel2.add(jLabel7, null);
    jPanel2.add(name_label, null);
    jPanel2.add(jLabel3, null);
    jPanel2.add(hsCode, null);
    jPanel2.add(impValue, null);
    jPanel2.add(pageNo, null);
    jPanel2.add(vol, null);
    this.getContentPane().add(jPanel3, null);
    jPanel3.add(entry, null);
    jPanel3.add(jButton2, null);
  }

  public static void main(String[] args) {
    BillEntry billEntry = new BillEntry();
  }


   void entry_actionPerformed(ActionEvent e) {

    String b_name,b_date,b_entry_date,lc_no,lc_date,be_no,be_date,ch_name,ch_des;
    double import_quantity,import_value,unit_price;
    String hs_code;
    int page_no,day;
    String volume,date="";



    b_name = bondName.getText();
    b_date = bondDate.getText();
    b_entry_date = bondEntry.getText();
    lc_no = lcNo.getText();
    lc_date = lcDate.getText();
    be_no = beNo.getText();
    be_date = beDate.getText();
    ch_name = chName.getText();
    ch_des = chDesp.getText();
    hs_code = hsCode.getText();
    volume = vol.getText();


    if (b_name.equals(""))
      JOptionPane.showMessageDialog(null, "Enter Bond Name");
    else if (b_date.equals(""))
      JOptionPane.showMessageDialog(null, "Enter Bond Date");
    else if (b_entry_date.equals(""))
      JOptionPane.showMessageDialog(null, "Enter Into Bond Date");
    else if (lc_no.equals(""))
      JOptionPane.showMessageDialog(null, "Enter L/C No");
    else if (lc_date.equals(""))
      JOptionPane.showMessageDialog(null, "Enter L/C Date");
    else if (be_no.equals(""))
      JOptionPane.showMessageDialog(null, "Enter B/E No");
    else if (be_date.equals(""))
      JOptionPane.showMessageDialog(null, "Enter B/E Date");
    else if (ch_name.equals(""))
      JOptionPane.showMessageDialog(null, "Enter "+Main.names+" name");
    else if (hs_code.equals(""))
      JOptionPane.showMessageDialog(null, "Enter H.S Code No");
    else if (volume.equals(""))
      JOptionPane.showMessageDialog(null, "Enter Volume");
    else if (impQuantity.getText().equals(""))
      JOptionPane.showMessageDialog(null, "Enter Import Quantity");
    else if (impValue.getText().equals(""))
      JOptionPane.showMessageDialog(null, "Enter Import Value");
    else if (pageNo.getText().equals(""))
      JOptionPane.showMessageDialog(null, "Enter Page No");

    else {

      import_quantity = Double.parseDouble(impQuantity.getText());
      import_value = Double.parseDouble(impValue.getText());
      hs_code = hsCode.getText();
      page_no = Integer.parseInt(pageNo.getText());
      volume = vol.getText();
      unit_price = import_value / import_quantity;

      day = getDates(b_entry_date);

      date = parseDate(b_entry_date);
      bondEntry.setText(date);
      b_entry_date = date;

      date = parseDate(b_date);
      bondDate.setText(date);
      b_date = date;

      date = parseDate(lc_date);
      lcDate.setText(date);
      lc_date = date;

      date = parseDate(be_date);
      beDate.setText(date);
      be_date = date;
      String nul=null;
      double val=0;

      try {

        stat = connection.createStatement();
        String sql = " insert into  "+entry_table+" values('" + b_name + "','" +
            b_date + "','" + b_entry_date + "','" + lc_no + "','" + lc_date +
            "','" + be_no + "','" + be_date + "','" + ch_name + "','" + ch_des +
            "'," + import_quantity + "," + import_value + ", "+val+","+val+","+val+","+val+"," + unit_price +
            ",'" + hs_code + "'," + page_no + ",'" + volume + "'," + day + ",0,'"+nul+"')";
        boolean insertResult = stat.execute(sql);
        stat.close();
        JOptionPane.showMessageDialog(null,"Your Information have been successfully updated.");
      }

      catch (SQLException sqlException) {
        JOptionPane.showMessageDialog(null, sqlException.getMessage(),
                                      "Database error",
                                      JOptionPane.ERROR_MESSAGE);
      }

      unitPrice.setText(String.valueOf(unit_price));
    }

  }




  public static int getDates(String dates){
    int p = 1;
    char str[] = dates.toCharArray();
    String day = "", month = "", year = "";
    for (int i = 0; i < str.length; i++) {
      if ( (str[i] == '/' || str[i] == '-') && p == 1) p = 2;
      else if ( (str[i] == '/' || str[i] == '-') && p == 2) p = 3;
      else {
        if (p == 1) day += str[i];
        else if (p == 2) month += str[i];
        else year += str[i];
      }
    }

    if (day.length() < 2) {
      day = "0" + day;
    }
    if (month.length() < 2) {
      month = "0" + month;
    }
    if (year.length() < 4) {
      year = "20" + year;
    }
    int c_date, c_month, c_year;
    c_date = Integer.parseInt(day);
    c_month = Integer.parseInt(month);
    c_year = Integer.parseInt(year);

    int days[] = {
        0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365}
        , din;

    din = days[c_month - 1] + c_date;

    if (c_month > 2) {
      if (c_year % 100 == 0) {
        if (c_year % 400 == 0)
          din++;
      }
      else if (c_year % 4 == 0)
        din++;
    }

    din += (c_year*365);



    //System.out.println(din);
    //System.out.println(month);
   // System.out.println(year);
    return din;
  }

  String parseDate(String dates){
    int p=1;
    char str[]=dates.toCharArray();
    String day="",month="",year="",date="";
    for(int i=0;i<str.length;i++)
    {
      if( (str[i]=='/' || str[i]=='-' ) && p==1 ) p=2;
      else if( (str[i]=='/' || str[i]=='-' ) && p==2 ) p=3;
      else{
        if (p == 1) day += str[i];
        else if (p == 2) month += str[i];
        else year += str[i];
      }
    }
    date ="";
    if(day.length()<2){
      day="0"+day;
    }
    date = day+"/";
    if(month.length()<2){
          month ="0"+month;
        }
      date+=month+"/";
    if(year.length()<4){
      year="20"+year;
    }
    date+=year;

    //System.out.println(date);
    return date;
  }




  void jButton2_actionPerformed(ActionEvent e) {
    dispose();
  }

  void hsCode_actionPerformed(ActionEvent e) {

  }

}

class BillEntry_entry_actionAdapter implements java.awt.event.ActionListener {
  BillEntry adaptee;

  BillEntry_entry_actionAdapter(BillEntry adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.entry_actionPerformed(e);
  }
}

class BillEntry_jButton2_actionAdapter implements java.awt.event.ActionListener {
  BillEntry adaptee;

  BillEntry_jButton2_actionAdapter(BillEntry adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton2_actionPerformed(e);
  }
}

class BillEntry_hsCode_actionAdapter implements java.awt.event.ActionListener {
  BillEntry adaptee;

  BillEntry_hsCode_actionAdapter(BillEntry adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.hsCode_actionPerformed(e);
  }
}
