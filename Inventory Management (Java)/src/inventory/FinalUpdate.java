package inventory;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.text.DecimalFormat;


public class FinalUpdate extends JFrame {

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
  JTextField iv = new JTextField();
  JLabel jLabel12 = new JLabel();
  JTextField iq = new JTextField();
  JLabel jLabel13 = new JLabel();
  JTextField unitPrice = new JTextField();
  JLabel jLabel14 = new JLabel();
  JLabel jLabel15 = new JLabel();
  JTextField pageNo = new JTextField();
  JTextField vol = new JTextField();
  JLabel jLabel16 = new JLabel();
  JTextField hsCode = new JTextField();
  JPanel jPanel3 = new JPanel();
  TitledBorder titledBorder1;
  Connection connection=Main.conn;
  JLabel jLabel17 = new JLabel();
  JTextField av = new JTextField();
  JLabel jLabel18 = new JLabel();
  JTextField aq = new JTextField();
  JTextField bq = new JTextField();
  JTextField bv = new JTextField();
  JLabel jLabel19 = new JLabel();
  JLabel jLabel110 = new JLabel();
  JTextField upDate = new JTextField();
  JLabel jLabel111 = new JLabel();
  JTextField upNo = new JTextField();
  JLabel jLabel112 = new JLabel();
  JButton update = new JButton();
  JButton delete = new JButton();
  JButton exit = new JButton();
  JButton back = new JButton();

  String b_name="",b_date="",b_entry_date="",lc_no="",lc_date="",be_no="",be_date="",ch_name="",ch_des="";
  double import_quantity=0,import_value=0,adj_quantity=0,adj_value=0,unit_price=0;
  double balance_q=0,balance_v=0;
  String hs_code="";
  int page_no=0;
  String volume="",up_no="",up_date="";




  public FinalUpdate() {
    try {
      jbInit();

      name_label.setText(Main.names+" Name");
      des_label.setText(Main.names+" Description");
      Initialize();
      setSize(550,560);
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



  void  Initialize()
  {


      b_name = Update.bname;
      b_date = Update.bdate;
      ch_name = Update.cname;
      //JOptionPane.showMessageDialog(null,b_name+"\n"+b_date+"\n"+ch_name);
      DecimalFormat three = new DecimalFormat("0.000");
      String sql = "select * from "+Main.entryTable+" where (Bond_Name = '" +
                b_name + "'  AND Bond_Date = '" + b_date + "' AND "+Main.names+"_Name = '" +
                ch_name + "')";
      //JOptionPane.showMessageDialog(null,b_name+"\n"+b_date+"\n"+ch_name);


      try {
        Statement stat = connection.createStatement();
        ResultSet rset = stat.executeQuery(sql);
        while (rset.next()) {
          b_entry_date = rset.getString("Into_Bond_Date");
          lc_no = rset.getString("LC_No");
          lc_date = rset.getString("LC_Date");
          be_no = rset.getString("BE_No");
          be_date = rset.getString("BE_Date");
          ch_des = rset.getString(""+Main.names+"_Description");
          import_quantity = Double.parseDouble(rset.getString("Import_Quantity"));
          import_value = Double.parseDouble(rset.getString("Import_Value"));
          adj_quantity = Double.parseDouble(rset.getString("Adjusted_Quantity"));
          adj_value = Double.parseDouble(rset.getString("Adjusted_Value"));
          import_quantity = Double.parseDouble(rset.getString("Import_Quantity"));
          import_quantity = Double.parseDouble(rset.getString("Import_Quantity"));

          hs_code = rset.getString("HS_Code");
          page_no = Integer.parseInt(rset.getString("Page_No"));
          volume = rset.getString("Volume");
          up_no = rset.getString("UP_No");
          up_date = rset.getString("UP_Date");

        }

        if (import_quantity != 0)
          unit_price = import_value / import_quantity;
        balance_q = import_quantity - adj_quantity;
        balance_v = import_value - adj_value;

        bondName.setText(b_name);
        bondDate.setText(b_date);
        bondEntry.setText(b_entry_date);
        lcNo.setText(lc_no);
        lcDate.setText(lc_date);
        beNo.setText(be_no);
        beDate.setText(be_date);
        chName.setText(ch_name);
        chDesp.setText(ch_des);
        hsCode.setText(hs_code);
        vol.setText(volume);
        upNo.setText(up_no);
        upDate.setText(up_date);
        iq.setText(String.valueOf(three.format(import_quantity)));
        iv.setText(String.valueOf(three.format(import_value)));
        aq.setText(String.valueOf(three.format(adj_quantity)));
        av.setText(String.valueOf(three.format(adj_value)));
        bq.setText(String.valueOf(three.format(balance_q)));
        bv.setText(String.valueOf(three.format(balance_v)));
        unitPrice.setText(String.valueOf(three.format(unit_price)));
        pageNo.setText(String.valueOf(page_no));

      }
      catch (SQLException sqlException) {
        JOptionPane.showMessageDialog(null, sqlException.getMessage(),
                                      "Database error",
                                      JOptionPane.ERROR_MESSAGE);
      }




  }



  void jbInit() throws Exception {
    titledBorder1 = new TitledBorder("");
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setResizable(false);
    this.getContentPane().setLayout(null);
    jPanel1.setBorder(BorderFactory.createRaisedBevelBorder());
    jPanel1.setBounds(new Rectangle(14, 6, 521, 33));
    jPanel1.setLayout(null);
    jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 13));
    jLabel1.setForeground(Color.blue);
    jLabel1.setText("FINAL UPDATE");
    jLabel1.setBounds(new Rectangle(229, 4, 100, 22));
    jPanel2.setBorder(BorderFactory.createLineBorder(Color.black));
    jPanel2.setBounds(new Rectangle(15, 45, 519, 417));
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
    lcDate.setText("");
    lcDate.setBounds(new Rectangle(132, 72, 121, 22));
    lcNo.setBounds(new Rectangle(384, 41, 121, 22));
    lcNo.setText("");
    jLabel5.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel5.setBorder(null);
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
    jLabel11.setBounds(new Rectangle(21, 226, 103, 22));
    jLabel11.setText("import Quantity");
    jLabel11.setFont(new java.awt.Font("Dialog", 1, 12));
    iv.setText("");
    iv.setBounds(new Rectangle(384, 226, 121, 22));
    jLabel12.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel12.setText("Import Value");
    jLabel12.setBounds(new Rectangle(269, 225, 72, 22));
    iq.setBounds(new Rectangle(132, 225, 121, 22));
    iq.setText("");
    jLabel13.setBounds(new Rectangle(21, 307, 72, 22));
    jLabel13.setText("Unit Price");
    jLabel13.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel13.setDisplayedMnemonic('0');
    unitPrice.setBounds(new Rectangle(131, 308, 121, 22));
    unitPrice.setEnabled(false);
    unitPrice.setFont(new java.awt.Font("Dialog", 1, 12));
    unitPrice.setForeground(Color.blue);
    unitPrice.setDisabledTextColor(Color.blue);
    unitPrice.setEditable(false);
    unitPrice.setText("");
    jLabel14.setBounds(new Rectangle(21, 360, 58, 22));
    jLabel14.setText("Page No");
    jLabel14.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel15.setDisplayedMnemonic('0');
    jLabel15.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel15.setText("Volume");
    jLabel15.setBounds(new Rectangle(269, 360, 72, 22));
    pageNo.setBounds(new Rectangle(130, 363, 121, 22));
    pageNo.setText("");
    vol.setText("");
    vol.setEnabled(true);
    vol.setEditable(true);
    vol.setBounds(new Rectangle(384, 365, 121, 22));
    jLabel16.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel16.setText("H.S Code");
    jLabel16.setBounds(new Rectangle(269, 309, 73, 22));
    hsCode.setText("");
    hsCode.setBounds(new Rectangle(382, 308, 121, 22));
    jPanel3.setBorder(BorderFactory.createEtchedBorder());
    jPanel3.setBounds(new Rectangle(15, 464, 519, 50));
    jPanel3.setLayout(null);
    jLabel17.setBounds(new Rectangle(269, 254, 102, 22));
    jLabel17.setText("Adjusted Value");
    jLabel17.setFont(new java.awt.Font("Dialog", 1, 12));
    av.setBounds(new Rectangle(383, 255, 121, 22));
    av.setText("");
    jLabel18.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel18.setText("Adjusted Quantity");
    jLabel18.setBounds(new Rectangle(21, 255, 108, 22));
    aq.setText("");
    aq.setBounds(new Rectangle(131, 254, 121, 22));
    bq.setBounds(new Rectangle(131, 281, 121, 22));
    bq.setFont(new java.awt.Font("Dialog", 1, 12));
    bq.setForeground(Color.blue);
    bq.setDisabledTextColor(Color.blue);
    bq.setEditable(false);
    bq.setText("");
    bv.setFont(new java.awt.Font("Dialog", 1, 12));
    bv.setForeground(Color.blue);
    bv.setDisabledTextColor(Color.blue);
    bv.setEditable(false);
    bv.setText("");
    bv.setBounds(new Rectangle(383, 282, 121, 22));
    jLabel19.setBounds(new Rectangle(21, 282, 106, 22));
    jLabel19.setText("Balanced Quantity");
    jLabel19.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel110.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel110.setText("Balanced Value");
    jLabel110.setBounds(new Rectangle(269, 281, 102, 22));
    upDate.setBounds(new Rectangle(383, 335, 121, 22));
    upDate.setText("");
    jLabel111.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel111.setText("UP No");
    jLabel111.setBounds(new Rectangle(21, 335, 78, 22));
    upNo.setText("");
    upNo.setBounds(new Rectangle(131, 334, 121, 22));
    jLabel112.setBounds(new Rectangle(269, 334, 102, 22));
    jLabel112.setText("UP Date");
    jLabel112.setFont(new java.awt.Font("Dialog", 1, 12));
    update.setBounds(new Rectangle(8, 9, 115, 31));
    update.setFont(new java.awt.Font("Dialog", 1, 12));
    update.setBorder(BorderFactory.createRaisedBevelBorder());
    update.setMnemonic('U');
    update.setText("Update");
    update.addActionListener(new FinalUpdate_update_actionAdapter(this));
    delete.setText("Delete");
    delete.addActionListener(new FinalUpdate_delete_actionAdapter(this));
    delete.setBorder(BorderFactory.createRaisedBevelBorder());
    delete.setMnemonic('D');
    delete.setFont(new java.awt.Font("Dialog", 1, 12));
    delete.setBounds(new Rectangle(136, 8, 115, 31));
    exit.setBounds(new Rectangle(389, 8, 115, 31));
    exit.setFont(new java.awt.Font("Dialog", 1, 12));
    exit.setBorder(BorderFactory.createRaisedBevelBorder());
    exit.setMnemonic('X');
    exit.setText("Exit");
    exit.addActionListener(new FinalUpdate_exit_actionAdapter(this));
    back.setText("Back");
    back.addActionListener(new FinalUpdate_back_actionAdapter(this));
    back.setBorder(BorderFactory.createRaisedBevelBorder());
    back.setMnemonic('B');
    back.setFont(new java.awt.Font("Dialog", 1, 12));
    back.setBounds(new Rectangle(262, 9, 115, 31));
    this.getContentPane().add(jPanel1, null);
    jPanel1.add(jLabel1, null);
    this.getContentPane().add(jPanel2, null);
    jPanel2.add(jLabel2, null);
    jPanel2.add(des_label, null);
    jPanel2.add(bondName, null);
    jPanel2.add(jScrollPane1, null);
    jScrollPane1.getViewport().add(chDesp, null);
    jPanel2.add(iq, null);
    jPanel2.add(jLabel11, null);
    jPanel2.add(bondEntry, null);
    jPanel2.add(jLabel6, null);
    jPanel2.add(jLabel5, null);
    jPanel2.add(jLabel8, null);
    jPanel2.add(jLabel12, null);
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
    jPanel2.add(iv, null);
    jPanel2.add(aq, null);
    jPanel2.add(av, null);
    jPanel2.add(jLabel17, null);
    jPanel2.add(jLabel18, null);
    jPanel2.add(bq, null);
    jPanel2.add(jLabel19, null);
    jPanel2.add(jLabel110, null);
    jPanel2.add(bv, null);
    jPanel2.add(unitPrice, null);
    jPanel2.add(jLabel13, null);
    jPanel2.add(hsCode, null);
    jPanel2.add(upNo, null);
    jPanel2.add(upDate, null);
    jPanel2.add(jLabel111, null);
    jPanel2.add(jLabel112, null);
    jPanel2.add(jLabel16, null);
    jPanel2.add(pageNo, null);
    jPanel2.add(jLabel14, null);
    jPanel2.add(jLabel15, null);
    jPanel2.add(vol, null);
    this.getContentPane().add(jPanel3, null);
    jPanel3.add(update, null);
    jPanel3.add(delete, null);
    jPanel3.add(back, null);
    jPanel3.add(exit, null);
  }

  public static void main(String[] args) {
    FinalUpdate billEntry = new FinalUpdate();
  }






  void exit_actionPerformed(ActionEvent e) {
       dispose();
  }

  void update_actionPerformed(ActionEvent e) {

    String s1 = b_name;
    String s2 = b_date;
    String s3 = ch_name;
   int day=0;

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
   up_no = upNo.getText();
   up_date = upDate.getText();
   import_quantity = Double.parseDouble(iq.getText());
   import_value = Double.parseDouble(iv.getText());
   adj_quantity = Double.parseDouble(aq.getText());
   adj_value = Double.parseDouble(av.getText());
   balance_q = Double.parseDouble(bq.getText());
   balance_v = Double.parseDouble(bv.getText());
   page_no = Integer.parseInt(pageNo.getText());
   unit_price=0;
   if(import_quantity!=0)
   unit_price = import_value / import_quantity;

   day = BillEntry.getDates(b_entry_date);



    try {

        stat = connection.createStatement();
         String sql = "delete from "+Main.entryTable+" where (Bond_Name = '" +
                  s1 + "'  AND Bond_Date = '" + s2 + "' AND "+Main.names+"_Name = '" +
                  s3 + "')";
        boolean insertResult = stat.execute(sql);

         //JOptionPane.showMessageDialog(null,
          //                             "Your Information have been deleted.");





       sql = " insert into  "+Main.entryTable+" values('" + b_name + "','" +
           b_date + "','" + b_entry_date + "','" + lc_no + "','" + lc_date +
           "','" + be_no + "','" + be_date + "','" + ch_name + "','" + ch_des +
           "'," + import_quantity + "," + import_value + ", "+adj_quantity+","+adj_value+","+balance_q+","+balance_v+"," + unit_price +
           ",'" + hs_code + "'," + page_no + ",'" + volume + "'," + day + ",'"+up_no+"','"+up_date+"')";
       insertResult = stat.execute(sql);
       stat.close();
       JOptionPane.showMessageDialog(null,
                                     "Your Information have been successfully updated.");
     }

     catch (SQLException sqlException) {
       JOptionPane.showMessageDialog(null, sqlException.getMessage(),
                                     "Database error",
                                     JOptionPane.ERROR_MESSAGE);
     }




  }

  void delete_actionPerformed(ActionEvent e) {

        bondName.setText("");
        bondDate.setText("");
        bondEntry.setText("");
        lcNo.setText("");
        lcDate.setText("");
        beNo.setText("");
        beDate.setText("");
        chName.setText("");
        chDesp.setText("");
        hsCode.setText("");
        vol.setText("");
        upNo.setText("");
        upDate.setText("");
        iq.setText("");
        iv.setText("");
        aq.setText("");
        av.setText("");
        bq.setText("");
        bv.setText("");
        unitPrice.setText("");
        pageNo.setText("");


    try {

      stat = connection.createStatement();
      String sql = "delete from "+Main.entryTable+" where (Bond_Name = '" +
               b_name + "'  AND Bond_Date = '" + b_date + "' AND "+Main.names+"_Name = '" +
               ch_name + "')";
     boolean insertResult = stat.execute(sql);
      stat.close();
      JOptionPane.showMessageDialog(null,
                                    "Your Information have been deleted.");
    }

    catch (SQLException sqlException) {
      JOptionPane.showMessageDialog(null, sqlException.getMessage(),
                                    "Database error",
                                    JOptionPane.ERROR_MESSAGE);
    }


  }
  //JButton back = new JButton();

  void back_actionPerformed(ActionEvent e) {
    dispose();
    new Update();
  }

}



class FinalUpdate_exit_actionAdapter implements java.awt.event.ActionListener {
  FinalUpdate adaptee;

  FinalUpdate_exit_actionAdapter(FinalUpdate adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.exit_actionPerformed(e);
  }
}

class FinalUpdate_update_actionAdapter implements java.awt.event.ActionListener {
  FinalUpdate adaptee;

  FinalUpdate_update_actionAdapter(FinalUpdate adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.update_actionPerformed(e);
  }
}

class FinalUpdate_delete_actionAdapter implements java.awt.event.ActionListener {
  FinalUpdate adaptee;

  FinalUpdate_delete_actionAdapter(FinalUpdate adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.delete_actionPerformed(e);
  }
}

class FinalUpdate_back_actionAdapter implements java.awt.event.ActionListener {
  FinalUpdate adaptee;

  FinalUpdate_back_actionAdapter(FinalUpdate adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.back_actionPerformed(e);
  }
}
