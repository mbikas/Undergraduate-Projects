

package hospital;

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


public class search_bill extends JFrame {

  Connection connection;
  public long id=0;
  String names="";
  double mbed=0,mcabin=0,mot=0,mdelivery=0,mpack=0,mpo=0,mnebu=0,moxy=0,mpatho=0,mradio=0,mecg=0,murine=0,mdress=0,mmisc=0,mservice=0;
  double mtotal=0,mdiscount=0,mfinal_amount=0,mdue=0,madvance=0;

  PrinterJob job;
  String str0,str1,str2,str3,str4,str5,str6,str7;
  String sql = "",info="";


  JTextField advance = new JTextField();
  JTextField radio = new JTextField();
  JRadioButton ward = new JRadioButton();
  JTextField urine = new JTextField();
  JTextField ecg = new JTextField();
  JRadioButton gb = new JRadioButton();
  JTextField fin = new JTextField();
  JTextField misc = new JTextField();
  JTextField po = new JTextField();
  JRadioButton cabin = new JRadioButton();
  JScrollPane jScrollPane5 = new JScrollPane();
  JLabel Amount = new JLabel();
  JPanel jPanel1 = new JPanel();
  JTextField oxyzen = new JTextField();
  JTextField tot = new JTextField();
  JTextField dressing = new JTextField();
  JLabel jLabel6 = new JLabel();
  JTextField cabin_field = new JTextField();
  JTextField name = new JTextField();
  JTextField pack = new JTextField();
  JLabel jLabel5 = new JLabel();
  JPanel jPanel4 = new JPanel();
  JScrollPane jScrollPane1 = new JScrollPane();
  JLabel jLabel1 = new JLabel();
  JLabel Hospital_name1 = new JLabel();
  JPanel jPanel3 = new JPanel();
  JLabel jLabel2 = new JLabel();
  JFormattedTextField dates = new JFormattedTextField();
  JTextField patho = new JTextField();
  JScrollPane jScrollPane4 = new JScrollPane();
  JTextField del = new JTextField();
  JPanel jPanel2 = new JPanel();
  JTextField bed = new JTextField();
  JScrollPane jScrollPane2 = new JScrollPane();
  JRadioButton pb = new JRadioButton();
  JTextField nebu = new JTextField();
  JTextField ot = new JTextField();
  JScrollPane jScrollPane3 = new JScrollPane();
  JButton jButton3 = new JButton();
  JPanel jPanel6 = new JPanel();
  JButton jButton4 = new JButton();
  JButton jButton5 = new JButton();
  JList ward_list = new JList();
  JList bed_list = new JList();
  JList cabin_list = new JList();
  JList gb_list = new JList();
  JList pb_list = new JList();
  ButtonGroup group = new ButtonGroup();
  JLabel jLabel3 = new JLabel();
  JTextField dis = new JTextField();
  JLabel jLabel4 = new JLabel();
  JLabel jLabel7 = new JLabel();
  JLabel jLabel8 = new JLabel();
  JLabel jLabel9 = new JLabel();
  Border border1;
  JTextField due = new JTextField();
  JLabel jLabel10 = new JLabel();
  JLabel jLabel11 = new JLabel();
  JLabel jLabel12 = new JLabel();
  JLabel jLabel13 = new JLabel();
  JLabel jLabel14 = new JLabel();
  JLabel jLabel15 = new JLabel();
  JLabel jLabel16 = new JLabel();
  JLabel jLabel17 = new JLabel();
  JLabel jLabel18 = new JLabel();
  JLabel jLabel19 = new JLabel();
  JLabel jLabel110 = new JLabel();
  JLabel jLabel20 = new JLabel();
  JLabel jLabel111 = new JLabel();
  JLabel jLabel21 = new JLabel();
  JLabel Amount1 = new JLabel();
  JButton preview = new JButton();
  JButton print = new JButton();

  public search_bill() {
    try {
      jbInit();
      setSize(700,530);
      setLocation(80,40);
      show();


     print.setEnabled(false);
     preview.setEnabled(false);


     Statement stat;
     ResultSet rset;
     String sql;
     connection = Main.connection;



     String str = "";
     sql = "select to_char(sysDate,'DD-MM-YYYY') from dual";
     stat = connection.createStatement();
     rset = stat.executeQuery(sql);
     while (rset.next())
       str = rset.getString(1);
     dates.setText(str);

          stat.close();


    }
    catch(Exception ex) {
      ex.printStackTrace();
    }

    name.setEditable(false);



    //listener for ward_list
  ward_list.addListSelectionListener(
     new ListSelectionListener()
     { public void valueChanged(ListSelectionEvent e)
        {
          try {


            Statement stat;
            ResultSet rset;
            String sql;

            stat = connection.createStatement();
            sql = "select bed_no from ward_info where (flag=0 AND ward_no="+ward_list.getSelectedValue()+") order by bed_no";
            rset = stat.executeQuery(sql);
            int ct = 0,i;
            String bed_avail[] = new String[100];

            while (rset.next()) {
              bed_avail[ct] = rset.getString(1) ;
              ct++;
            }

            String temp[] = new String[ct];
            for (i = 0; i < ct; i++)
            temp[i] = bed_avail[i];
            bed_list.setListData(temp);


            stat.close();
            rset.close();
          }
          catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, sqlException.getMessage(),"Database error",JOptionPane.ERROR_MESSAGE);
          }


        }
     }
  );
  //////////////////////////
  //listener for cabin_list
cabin_list.addListSelectionListener(
 new ListSelectionListener()
 { public void valueChanged(ListSelectionEvent e)
    {
      try {

        Statement stat;
        ResultSet rset;
        String sql;

        stat = connection.createStatement();
        sql = "select patient_names_age.patient_id,patient_names_age.patient_name from patient_names_age where  patient_id = (select patient_seat.patient_id from patient_seat where cabin="+cabin_list.getSelectedValue()+")";
        rset = stat.executeQuery(sql);
        //String str="";

        while (rset.next()) {
          id = Integer.parseInt(rset.getString("patient_id"));
          names = rset.getString("patient_name") ;
        }


        name.setText(names);

        stat.close();
        rset.close();
      }
      catch (SQLException sqlException) {
        JOptionPane.showMessageDialog(null, sqlException.getMessage(),"Database error",JOptionPane.ERROR_MESSAGE);
      }


    }
 }
);
////////////////////////////////////////
 //listener for gb_list
gb_list.addListSelectionListener(
new ListSelectionListener()
{ public void valueChanged(ListSelectionEvent e)
  {
    try {

      Statement stat;
      ResultSet rset;
      String sql;

        stat = connection.createStatement();
        sql = "select patient_names_age.patient_id,patient_names_age.patient_name from patient_names_age where  patient_id = (select patient_seat.patient_id from patient_seat where gb="+gb_list.getSelectedValue()+")";
        rset = stat.executeQuery(sql);
        //String str="";

        while (rset.next()) {
          id = Integer.parseInt(rset.getString("patient_id"));
          names = rset.getString("patient_name") ;
        }


      name.setText(names);

      stat.close();
      rset.close();
    }
    catch (SQLException sqlException) {
      JOptionPane.showMessageDialog(null, sqlException.getMessage(),"Database error",JOptionPane.ERROR_MESSAGE);
    }


  }
}
);
////////////////////////////////////////
//listener for pb_list
pb_list.addListSelectionListener(
new ListSelectionListener()
{ public void valueChanged(ListSelectionEvent e)
{
  try {

    Statement stat;
    ResultSet rset;
    String sql;

        stat = connection.createStatement();
        sql = "select patient_names_age.patient_id,patient_names_age.patient_name from patient_names_age where  patient_id = (select patient_seat.patient_id from patient_seat where pb="+pb_list.getSelectedValue()+")";
        rset = stat.executeQuery(sql);
        //String str="";
        while (rset.next()) {
          id = Integer.parseInt(rset.getString("patient_id"));
          names = rset.getString("patient_name") ;
        }
        name.setText(names);

    stat.close();
    rset.close();
  }
  catch (SQLException sqlException) {
    JOptionPane.showMessageDialog(null, sqlException.getMessage(),"Database error",JOptionPane.ERROR_MESSAGE);
  }


}
}
);
////////////////////////////////////////
   //listener for bed_list
bed_list.addListSelectionListener(
new ListSelectionListener()
{ public void valueChanged(ListSelectionEvent e)
  {
    try {

      Statement stat;
      ResultSet rset;
      String sql;

      stat = connection.createStatement();
      sql = "select patient_names_age.patient_id, patient_names_age.patient_name from patient_names_age where  patient_id = (select patient_seat.patient_id from patient_seat where (ward ="+ward_list.getSelectedValue()+" AND bed = "+bed_list.getSelectedValue()+") ) ";
      rset = stat.executeQuery(sql);
       // String str="";
        //long id=0;
        while (rset.next()) {
          id = Integer.parseInt(rset.getString("patient_id"));
          names = rset.getString("patient_name") ;
        }
      name.setText(names);

      stat.close();
      rset.close();
    }
    catch (SQLException sqlException) {
      JOptionPane.showMessageDialog(null, sqlException.getMessage(),"Database error",JOptionPane.ERROR_MESSAGE);
    }


  }
}
);








  }

  void jbInit() throws Exception {
    border1 = BorderFactory.createLineBorder(Color.black,3);
    jLabel9.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel9.setText("DUE");
    jLabel9.setBounds(new Rectangle(291, 63, 86, 23));
    jLabel8.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel8.setText("ADVANCED PAID");
    jLabel8.setBounds(new Rectangle(289, 34, 104, 23));
    jLabel7.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel7.setText("FINAL TOTAL");
    jLabel7.setBounds(new Rectangle(291, 7, 105, 23));
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel4.setText("TOTAL");
    jLabel4.setBounds(new Rectangle(21, 7, 104, 23));
    this.getContentPane().setLayout(null);
    this.getContentPane().setBackground(new Color(173, 201, 139));
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setResizable(false);
    this.setTitle("SEARCH BILL");
    advance.setBackground(SystemColor.textHighlightText);
    advance.setFont(new java.awt.Font("Dialog", 1, 12));
    advance.setDisabledTextColor(SystemColor.activeCaption);
    advance.setEditable(false);
    advance.setText("");
    advance.setBounds(new Rectangle(408, 35, 135, 23));
    radio.setBackground(SystemColor.textHighlightText);
    radio.setFont(new java.awt.Font("Dialog", 1, 12));
    radio.setDisabledTextColor(SystemColor.activeCaption);
    radio.setEditable(false);
    radio.setText("");
    radio.setBounds(new Rectangle(510, 45, 122, 19));
    ward.setBounds(new Rectangle(15, 15, 67, 27));
    ward.addActionListener(new search_bill_ward_actionAdapter(this));
    ward.setBackground(new Color(173, 201, 139));
    ward.setFont(new java.awt.Font("Dialog", 1, 12));
    ward.setText("WARD");
    urine.setBackground(SystemColor.textHighlightText);
    urine.setFont(new java.awt.Font("Dialog", 1, 12));
    urine.setDisabledTextColor(SystemColor.activeCaption);
    urine.setEditable(false);
    urine.setText("");
    urine.setBounds(new Rectangle(509, 93, 124, 19));
    urine.addActionListener(new search_bill_urine_actionAdapter(this));
    ecg.setBackground(SystemColor.textHighlightText);
    ecg.setFont(new java.awt.Font("Dialog", 1, 12));
    ecg.setDisabledTextColor(SystemColor.activeCaption);
    ecg.setEditable(false);
    ecg.setText("");
    ecg.setBounds(new Rectangle(510, 70, 122, 19));
    gb.setBounds(new Rectangle(350, 10, 106, 24));
    gb.addActionListener(new search_bill_gb_actionAdapter(this));
    gb.setBackground(new Color(173, 201, 139));
    gb.setFont(new java.awt.Font("Dialog", 1, 12));
    gb.setText("GENERAL BED");
    fin.setBounds(new Rectangle(408, 8, 135, 24));
    fin.setBackground(SystemColor.textHighlightText);
    fin.setFont(new java.awt.Font("Dialog", 1, 12));
    fin.setForeground(Color.red);
    fin.setBorder(BorderFactory.createLineBorder(Color.black));
    fin.setDisabledTextColor(Color.red);
    fin.setEditable(false);
    fin.setText("");
    misc.setBackground(SystemColor.textHighlightText);
    misc.setFont(new java.awt.Font("Dialog", 1, 12));
    misc.setDisabledTextColor(SystemColor.activeCaption);
    misc.setEditable(false);
    misc.setBounds(new Rectangle(509, 169, 124, 19));
    po.setBackground(SystemColor.textHighlightText);
    po.setFont(new java.awt.Font("Dialog", 1, 11));
    po.setDisabledTextColor(SystemColor.activeCaption);
    po.setEditable(false);
    po.setText("");
    po.setBounds(new Rectangle(223, 143, 114, 21));
    cabin.setBounds(new Rectangle(15, 42, 72, 23));
    cabin.addActionListener(new search_bill_cabin_actionAdapter(this));
    cabin.setBackground(new Color(173, 201, 139));
    cabin.setFont(new java.awt.Font("Dialog", 1, 12));
    cabin.setText("CABIN");
    jScrollPane5.setBounds(new Rectangle(178, 19, 62, 20));
    Amount.setBounds(new Rectangle(241, 3, 85, 17));
    Amount.setFont(new java.awt.Font("Dialog", 1, 11));
    Amount.setText("AMOUNT");
    jPanel1.setBounds(new Rectangle(17, 139, 662, 25));
    jPanel1.setBackground(new Color(173, 201, 139));
    jPanel1.setBorder(BorderFactory.createLoweredBevelBorder());
    oxyzen.setBackground(SystemColor.textHighlightText);
    oxyzen.setFont(new java.awt.Font("Dialog", 1, 12));
    oxyzen.setDisabledTextColor(SystemColor.activeCaption);
    oxyzen.setEditable(false);
    oxyzen.setText("");
    oxyzen.setBounds(new Rectangle(511, 143, 124, 22));
    tot.setBackground(SystemColor.textHighlightText);
    tot.setFont(new java.awt.Font("Dialog", 1, 12));
    tot.setDisabledTextColor(SystemColor.activeCaption);
    tot.setEditable(false);
    tot.setText("");
    tot.setBounds(new Rectangle(140, 6, 131, 22));
    dressing.setBackground(SystemColor.textHighlightText);
    dressing.setEnabled(true);
    dressing.setFont(new java.awt.Font("Dialog", 1, 12));
    dressing.setDoubleBuffered(false);
    dressing.setDisabledTextColor(SystemColor.activeCaption);
    dressing.setEditable(false);
    dressing.setText("");
    dressing.setBounds(new Rectangle(511, 118, 123, 22));
    jLabel6.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel6.setText("DATE");
    jLabel6.setBounds(new Rectangle(369, 64, 45, 23));
    cabin_field.setBackground(SystemColor.textHighlightText);
    cabin_field.setFont(new java.awt.Font("Dialog", 1, 11));
    cabin_field.setDoubleBuffered(true);
    cabin_field.setDisabledTextColor(SystemColor.activeCaption);
    cabin_field.setEditable(false);
    cabin_field.setText("");
    cabin_field.setBounds(new Rectangle(223, 49, 114, 19));
    name.setBackground(SystemColor.textHighlightText);
    name.setFont(new java.awt.Font("Dialog", 1, 12));
    name.setText("");
    name.setBounds(new Rectangle(93, 74, 154, 23));
    pack.setBackground(SystemColor.textHighlightText);
    pack.setFont(new java.awt.Font("Dialog", 1, 11));
    pack.setDisabledTextColor(SystemColor.activeCaption);
    pack.setEditable(false);
    pack.setText("");
    pack.setBounds(new Rectangle(223, 120, 114, 19));
    jLabel5.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel5.setText("NAME");
    jLabel5.setBounds(new Rectangle(22, 73, 56, 20));
    jPanel4.setBackground(new Color(173, 201, 139));
    jPanel4.setFont(new java.awt.Font("MS Sans Serif", 0, 11));
    jPanel4.setAlignmentY((float) 0.5);
    jPanel4.setBorder(border1);
    jPanel4.setBounds(new Rectangle(19, 358, 661, 92));
    jPanel4.setLayout(null);
    jScrollPane1.setBounds(new Rectangle(102, 19, 59, 20));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1.setText("BED");
    jLabel1.setBounds(new Rectangle(192, 4, 38, 14));
    Hospital_name1.setFont(new java.awt.Font("Dialog", 1, 18));
    Hospital_name1.setForeground(SystemColor.desktop);
    Hospital_name1.setText("JALALABAD RAGIB-RABEYA MEDICAL COLLEGE HOSPITAL");
    Hospital_name1.setBounds(new Rectangle(65, 6, 560, 28));
    jPanel3.setBackground(new Color(173, 201, 139));
    jPanel3.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel3.setBounds(new Rectangle(17, 37, 665, 101));
    jPanel3.setLayout(null);
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel2.setForeground(Color.blue);
    jLabel2.setText("SEARCH BILL");
    dates.setBackground(new Color(173, 201, 139));
    dates.setDisabledTextColor(SystemColor.activeCaption);
    dates.setEditable(false);
    dates.setFont(new java.awt.Font("SansSerif", 1, 13));
    dates.setForeground(SystemColor.activeCaption);
    dates.setBounds(new Rectangle(481, 63, 126, 20));
    patho.setBackground(SystemColor.textHighlightText);
    patho.setFont(new java.awt.Font("Dialog", 1, 12));
    patho.setDisabledTextColor(SystemColor.activeCaption);
    patho.setEditable(false);
    patho.setText("");
    patho.setBounds(new Rectangle(510, 21, 122, 19));
    jScrollPane4.setBounds(new Rectangle(481, 37, 56, 20));
    del.setBackground(SystemColor.textHighlightText);
    del.setFont(new java.awt.Font("Dialog", 1, 11));
    del.setDisabledTextColor(SystemColor.activeCaption);
    del.setEditable(false);
    del.setText("");
    del.setBounds(new Rectangle(222, 97, 114, 19));
    jPanel2.setBackground(new Color(173, 201, 139));
    jPanel2.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel2.setBounds(new Rectangle(18, 165, 662, 193));
    jPanel2.setLayout(null);
    bed.setBackground(SystemColor.textHighlightText);
    bed.setFont(new java.awt.Font("Dialog", 1, 11));
    bed.setDisabledTextColor(SystemColor.activeCaption);
    bed.setEditable(false);
    bed.setText("");
    bed.setBounds(new Rectangle(224, 26, 114, 19));
    jScrollPane2.setBounds(new Rectangle(102, 45, 60, 20));
    pb.setBackground(new Color(173, 201, 139));
    pb.setFont(new java.awt.Font("Dialog", 1, 12));
    pb.setText("PAYING BED");
    pb.setBounds(new Rectangle(351, 37, 98, 23));
    pb.addActionListener(new search_bill_pb_actionAdapter(this));
    nebu.setBackground(SystemColor.textHighlightText);
    nebu.setFont(new java.awt.Font("Dialog", 1, 11));
    nebu.setDisabledTextColor(SystemColor.activeCaption);
    nebu.setEditable(false);
    nebu.setText("");
    nebu.setBounds(new Rectangle(223, 168, 114, 19));
    ot.setBackground(SystemColor.textHighlightText);
    ot.setFont(new java.awt.Font("Dialog", 1, 11));
    ot.setDisabledTextColor(SystemColor.activeCaption);
    ot.setEditable(false);
    ot.setText("");
    ot.setBounds(new Rectangle(223, 74, 114, 19));
    jScrollPane3.setBounds(new Rectangle(481, 11, 55, 20));
    jButton3.setBackground(new Color(173, 201, 139));
    jButton3.setBounds(new Rectangle(460, 6, 66, 27));
    jButton3.setFont(new java.awt.Font("Dialog", 1, 12));
    jButton3.setBorder(BorderFactory.createRaisedBevelBorder());
    jButton3.setMnemonic('L');
    jButton3.setText("CLOSE");
    jButton3.addActionListener(new search_bill_jButton3_actionAdapter(this));
    jPanel6.setBackground(new Color(173, 201, 139));
    jPanel6.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel6.setBounds(new Rectangle(19, 453, 664, 39));
    jPanel6.setLayout(null);
    jButton4.setBackground(new Color(173, 201, 139));
    jButton4.setBounds(new Rectangle(135, 6, 75, 25));
    jButton4.setFont(new java.awt.Font("Dialog", 1, 12));
    jButton4.setBorder(BorderFactory.createRaisedBevelBorder());
    jButton4.setMnemonic('C');
    jButton4.setText("CLEAR");
    jButton4.addActionListener(new search_bill_jButton4_actionAdapter(this));
    jButton5.setText("SHOW");
    jButton5.addActionListener(new search_bill_jButton5_actionAdapter(this));
    jButton5.setMnemonic('S');
    jButton5.setBorder(BorderFactory.createRaisedBevelBorder());
    jButton5.setFont(new java.awt.Font("Dialog", 1, 12));
    jButton5.setBackground(new Color(173, 201, 139));
    jButton5.setBounds(new Rectangle(29, 6, 75, 25));
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel3.setText("DISCOUNT");
    jLabel3.setBounds(new Rectangle(21, 35, 102, 23));
    dis.setBackground(SystemColor.textHighlightText);
    dis.setFont(new java.awt.Font("Dialog", 1, 12));
    dis.setDisabledTextColor(SystemColor.activeCaption);
    dis.setEditable(false);
    dis.setText("");
    dis.setBounds(new Rectangle(139, 36, 132, 24));
    due.setBackground(SystemColor.textHighlightText);
    due.setFont(new java.awt.Font("Dialog", 1, 12));
    due.setForeground(Color.red);
    due.setDisabledTextColor(Color.red);
    due.setEditable(false);
    due.setSelectionStart(11);
    due.setBounds(new Rectangle(409, 63, 135, 23));
    due.setText("");
    jLabel10.setBounds(new Rectangle(11, 24, 164, 25));
    jLabel10.setText("BED CHARGES:");
    jLabel10.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel11.setText("CABIN CHARGES:");
    jLabel11.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel11.setBounds(new Rectangle(9, 48, 174, 25));
    jLabel12.setText("OT+ANAESTHESIA CHARGES:");
    jLabel12.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel12.setBounds(new Rectangle(10, 71, 179, 25));
    jLabel13.setText("NORMAL DELIVERY D&C  CHARGES:");
    jLabel13.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel13.setBounds(new Rectangle(9, 93, 202, 25));
    jLabel14.setText("PACKAGE CHARGES");
    jLabel14.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel14.setBounds(new Rectangle(9, 118, 130, 25));
    jLabel15.setText("PO CHARGES:");
    jLabel15.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel15.setBounds(new Rectangle(9, 141, 175, 25));
    jLabel16.setText("NEBULIZATION CHARGES");
    jLabel16.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel16.setBounds(new Rectangle(9, 165, 171, 25));
    jLabel17.setBounds(new Rectangle(359, 18, 127, 25));
    jLabel17.setText("PATHOLOGY CHARGE:");
    jLabel17.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel18.setBounds(new Rectangle(358, 43, 126, 25));
    jLabel18.setText("RADIOLOGY CHARGE:");
    jLabel18.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel19.setBounds(new Rectangle(357, 67, 122, 25));
    jLabel19.setText("E.C.G CHARGES:");
    jLabel19.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel110.setBounds(new Rectangle(357, 89, 126, 25));
    jLabel110.setText("BED SDE URINE TEST:");
    jLabel110.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel20.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel20.setText("DRESSING CHARGE");
    jLabel20.setBounds(new Rectangle(356, 118, 121, 20));
    jLabel111.setText("OXYZEN CHARGES:");
    jLabel111.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel111.setBounds(new Rectangle(355, 141, 126, 25));
    jLabel21.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel21.setText("MISC");
    jLabel21.setBounds(new Rectangle(358, 168, 93, 20));
    ward_list.setBackground(SystemColor.textHighlightText);
    ward_list.setFont(new java.awt.Font("Dialog", 1, 12));
    bed_list.setBackground(SystemColor.textHighlightText);
    bed_list.setFont(new java.awt.Font("Dialog", 1, 12));
    cabin_list.setBackground(SystemColor.textHighlightText);
    cabin_list.setFont(new java.awt.Font("Dialog", 1, 12));
    gb_list.setBackground(SystemColor.textHighlightText);
    gb_list.setFont(new java.awt.Font("Dialog", 1, 12));
    pb_list.setBackground(SystemColor.textHighlightText);
    pb_list.setFont(new java.awt.Font("Dialog", 1, 12));
    Amount1.setFont(new java.awt.Font("Dialog", 1, 11));
    Amount1.setText("AMOUNT");
    Amount1.setBounds(new Rectangle(545, 2, 56, 17));
    //preview.addActionListener(new search_bill_preview_actionAdapter(this));
    preview.setText("PRINT PREVIEW");
    preview.addActionListener(new search_bill_preview_actionAdapter(this));
    preview.setMnemonic('L');
    preview.setBorder(BorderFactory.createRaisedBevelBorder());
    preview.setFont(new java.awt.Font("Dialog", 1, 12));
    preview.setBounds(new Rectangle(231, 7, 111, 27));
    preview.setBackground(new Color(173, 201, 139));
   // print.addActionListener(new search_bill_print_actionAdapter(this));
    print.setText("PRINT");
    print.addActionListener(new search_bill_print_actionAdapter(this));
    print.setMnemonic('L');
    print.setBorder(BorderFactory.createRaisedBevelBorder());
    print.setFont(new java.awt.Font("Dialog", 1, 12));
    print.setBounds(new Rectangle(365, 6, 66, 27));
    print.setBackground(new Color(173, 201, 139));
    jPanel6.add(jButton4, null);
    jPanel6.add(jButton5, null);
    jPanel6.add(jButton3, null);
    jPanel6.add(print, null);
    jPanel6.add(preview, null);
    jPanel3.add(cabin, null);
    jPanel3.add(jScrollPane2, null);
    jScrollPane2.getViewport().add(cabin_list, null);
    jPanel3.add(jScrollPane1, null);
    jScrollPane1.getViewport().add(ward_list, null);
    jPanel3.add(ward, null);
    jPanel3.add(jScrollPane5, null);
    jScrollPane5.getViewport().add(bed_list, null);
    jPanel3.add(jLabel1, null);
    jPanel3.add(jLabel5, null);
    jPanel3.add(name, null);
    jPanel3.add(jScrollPane3, null);
    jScrollPane3.getViewport().add(gb_list, null);
    jPanel3.add(jScrollPane4, null);
    jScrollPane4.getViewport().add(pb_list, null);
    jPanel3.add(dates, null);
    jPanel3.add(gb, null);
    jPanel3.add(pb, null);
    jPanel3.add(jLabel6, null);
    this.getContentPane().add(Hospital_name1, null);
    this.getContentPane().add(jPanel3, null);
    jPanel2.add(bed, null);
    jPanel2.add(Amount, null);
    jPanel2.add(cabin_field, null);
    jPanel2.add(ot, null);
    jPanel2.add(del, null);
    jPanel2.add(pack, null);
    jPanel2.add(po, null);
    jPanel2.add(nebu, null);
    jPanel2.add(patho, null);
    jPanel2.add(radio, null);
    jPanel2.add(ecg, null);
    jPanel2.add(urine, null);
    jPanel2.add(dressing, null);
    jPanel2.add(misc, null);
    jPanel2.add(oxyzen, null);
    jPanel2.add(jLabel10, null);
    jPanel2.add(jLabel11, null);
    jPanel2.add(jLabel12, null);
    jPanel2.add(jLabel13, null);
    jPanel2.add(jLabel14, null);
    jPanel2.add(jLabel15, null);
    jPanel2.add(jLabel16, null);
    jPanel2.add(jLabel17, null);
    jPanel2.add(jLabel18, null);
    jPanel2.add(jLabel19, null);
    jPanel2.add(jLabel110, null);
    jPanel2.add(jLabel20, null);
    jPanel2.add(jLabel111, null);
    jPanel2.add(jLabel21, null);
    jPanel2.add(Amount1, null);
    this.getContentPane().add(jPanel6, null);
    this.getContentPane().add(jPanel4, null);

    group.add(ward);
    group.add(cabin);
    group.add(gb);
    group.add(pb);
    jPanel4.add(jLabel4, null);
    jPanel4.add(tot, null);
    jPanel4.add(jLabel3, null);
    jPanel4.add(dis, null);
    jPanel4.add(jLabel7, null);
    jPanel4.add(advance, null);
    jPanel4.add(jLabel8, null);
    jPanel4.add(due, null);
    jPanel4.add(fin, null);
    jPanel4.add(jLabel9, null);
    this.getContentPane().add(jPanel1, null);
    jPanel1.add(jLabel2, null);
    this.getContentPane().add(jPanel2, null);

  }

  public static void main(String[] args) {
    search_bill search_bill = new search_bill();
  }


  public class Test implements Printable{


 public int print(Graphics g, PageFormat pageFormat, int pageIndex) {
   if (pageIndex >= 1)
       return Printable.NO_SUCH_PAGE;




            g.drawString(str1,100,100);
            g.drawString(str2,100,150);
            g.drawString(str3,100,170);
            g.drawString(str4,100,190);
            g.drawString(str5,100,210);
            g.drawString(str6,100,230);
            //g.drawString(str4,100,250);





      return Printable.PAGE_EXISTS;

 }

 }

 public void print_it(){

 job = PrinterJob.getPrinterJob();
 job.setPrintable(new Test());
 if(job.printDialog())
 {

    try{
         job.print();
       }
   catch (Exception abc)
     {
       JOptionPane.showMessageDialog( null, "Error printing page");
     }
 }

 }


//////////////////////////////////////


  void ward_actionPerformed(ActionEvent e) {
     print.setEnabled(false);
    String temp[] = new String[1];
   temp[0] = "";
   cabin_list.setListData(temp);
   gb_list.setListData(temp);
   pb_list.setListData(temp);
   cabin_list.setEnabled(false);
   gb_list.setEnabled(false);
   pb_list.setEnabled(false);
   ward_list.setEnabled(true);
   bed_list.setEnabled(true);
   preview.setEnabled(false);
   name.setText("");

   tot.setText("");
   fin.setText("");
   dis.setText("");
   advance.setText("");
   due.setText("");

   try {

     Statement stat;
     ResultSet rset;
     String sql = "";

     sql = "select ward_no from ward_info order by ward_no";
     stat = connection.createStatement();
     rset = stat.executeQuery(sql);
     String str[] = new String[100];
     int ct = 0;
     while (rset.next()) {
       str[ct] = rset.getString(1);
       ct++;
     }
     String wards[] = new String[ct];
     for (int i = 0; i < ct; i++)
       wards[i] = str[i];
     ward_list.setListData(wards);

     stat.close();

     rset.close();
   }
   catch (SQLException sqlException) {
     JOptionPane.showMessageDialog(null, sqlException.getMessage(),
                                   "Database error", JOptionPane.ERROR_MESSAGE);
   }


  }

  void cabin_actionPerformed(ActionEvent e) {
   String temp[] = new String[1];
   temp[0] = "";
   ward_list.setListData(temp);
   bed_list.setListData(temp);
   gb_list.setListData(temp);
   pb_list.setListData(temp);
   ward_list.setEnabled(false);
   bed_list.setEnabled(false);
   gb_list.setEnabled(false);
   pb_list.setEnabled(false);
   cabin_list.setListData(temp);
   cabin_list.setEnabled(true);
   name.setText("");
    print.setEnabled(false);
    preview.setEnabled(false);
    tot.setText("");
  fin.setText("");
  dis.setText("");
  advance.setText("");
  due.setText("");

   try {

     Statement stat;
     ResultSet rset;
     String sql = "";

     sql = "select cabin_no from cabin_info where flag=0 order by cabin_no";
     stat = connection.createStatement();
     rset = stat.executeQuery(sql);
     String str[] = new String[100];
     int ct = 0;
     while (rset.next()) {
       str[ct] = rset.getString(1);
       ct++;
     }
     String cabins[] = new String[ct];
     for (int i = 0; i < ct; i++)
       cabins[i] = str[i];
     cabin_list.setListData(cabins);

     stat.close();
     rset.close();

   }
   catch (SQLException sqlException) {
     JOptionPane.showMessageDialog(null, sqlException.getMessage(),
                                   "Database error", JOptionPane.ERROR_MESSAGE);
   }


  }

  void gb_actionPerformed(ActionEvent e) {

    print.setEnabled(false);
    String temp[] = new String[1];
   temp[0] = "";
   ward_list.setListData(temp);
   bed_list.setListData(temp);
   cabin_list.setListData(temp);
   pb_list.setListData(temp);
   ward_list.setEnabled(false);
   bed_list.setEnabled(false);
   cabin_list.setEnabled(false);
   pb_list.setEnabled(false);
   gb_list.setEnabled(true);
   name.setText("");
   preview.setEnabled(false);
   tot.setText("");
  fin.setText("");
  dis.setText("");
  advance.setText("");
  due.setText("");


   try {

    Statement stat;
    ResultSet rset;
    String sql = "";

    sql = "select gb_no from gb_info where flag=0 order by gb_no";
    stat = connection.createStatement();
    rset = stat.executeQuery(sql);
    String str[] = new String[100];
    int ct = 0;
    while (rset.next()) {
      str[ct] = rset.getString(1);
      ct++;
    }
    String gbs[] = new String[ct];
    for (int i = 0; i < ct; i++)
      gbs[i] = str[i];
    cabin_list.setListData(gbs);

    stat.close();
    rset.close();
  }
  catch (SQLException sqlException) {
    JOptionPane.showMessageDialog(null, sqlException.getMessage(),
                                  "Database error", JOptionPane.ERROR_MESSAGE);
  }


  }

  void pb_actionPerformed(ActionEvent e) {

     print.setEnabled(false);
    String temp[] = new String[1];
   temp[0] = "";
   ward_list.setListData(temp);
   bed_list.setListData(temp);
   gb_list.setListData(temp);
   cabin_list.setListData(temp);
   ward_list.setEnabled(false);
   bed_list.setEnabled(false);
   gb_list.setEnabled(false);
   cabin_list.setEnabled(false);
   pb_list.setEnabled(true);
   name.setText("");
   preview.setEnabled(false);
   tot.setText("");
  fin.setText("");
  dis.setText("");
  advance.setText("");
  due.setText("");


   try {

    Statement stat;
    ResultSet rset;
    String sql = "";

    sql = "select pb_no from pb_info where flag=0 order by pb_no";
    stat = connection.createStatement();
    rset = stat.executeQuery(sql);
    String str[] = new String[100];
    int ct = 0;
    while (rset.next()) {
      str[ct] = rset.getString(1);
      ct++;
    }
    String pbs[] = new String[ct];
    for (int i = 0; i < ct; i++)
      pbs[i] = str[i];
    cabin_list.setListData(pbs);

    stat.close();
    rset.close();
  }
  catch (SQLException sqlException) {
    JOptionPane.showMessageDialog(null, sqlException.getMessage(),
                                  "Database error", JOptionPane.ERROR_MESSAGE);
  }



  }

  void jButton5_actionPerformed(ActionEvent e) {

    if(!ward.isSelected() && !cabin.isSelected() && !gb.isSelected() && !pb.isSelected())
        JOptionPane.showMessageDialog(null,"select ward/cabin/paying bed/general bed","ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
      else if (ward.isSelected() && ward_list.isSelectionEmpty())
        JOptionPane.showMessageDialog(null, "select ward number", "ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
      else if ( (ward.isSelected() && !ward_list.isSelectionEmpty()) && bed_list.isSelectionEmpty())
        JOptionPane.showMessageDialog(null, "select a bed number", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
      else if (cabin.isSelected() && cabin_list.isSelectionEmpty())
        JOptionPane.showMessageDialog(null, "select a cabin numebr", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
      else if (gb.isSelected() && gb_list.isSelectionEmpty())
        JOptionPane.showMessageDialog(null, "select a general bed", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
      else if (pb.isSelected() && pb_list.isSelectionEmpty())
        JOptionPane.showMessageDialog(null, "select a paying bed", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
else{

 try {

   Statement stat;
   ResultSet rset;
   String sql = "";




   //System.out.println(id);


   sql = "select bed,cabin,ot,delivery,pack,po,nebu,oxyzen from bill_1 where patient_id = "+id+" " ;
   stat = connection.createStatement();
   rset = stat.executeQuery(sql);
   while (rset.next()) {
     mbed = Double.parseDouble(rset.getString("bed"));
     mcabin = Double.parseDouble(rset.getString("cabin"));
     mot = Double.parseDouble(rset.getString("ot"));
     mdelivery = Double.parseDouble(rset.getString("delivery"));
     mpack = Double.parseDouble(rset.getString("pack"));
     mpo = Double.parseDouble(rset.getString("po"));
     mnebu = Double.parseDouble(rset.getString("nebu"));
     moxy = Double.parseDouble(rset.getString("oxyzen"));
   }

   sql = "select patho,radio,ecg,urine,dressing,misc,service from bill_2 where patient_id = "+id+" " ;
   stat = connection.createStatement();
   rset = stat.executeQuery(sql);
   while (rset.next()) {
    mpatho = Double.parseDouble(rset.getString("patho"));
    mradio = Double.parseDouble(rset.getString("radio"));
    mecg = Double.parseDouble(rset.getString("ecg"));
    murine = Double.parseDouble(rset.getString("urine"));
    mdress = Double.parseDouble(rset.getString("dressing"));
    mmisc = Double.parseDouble(rset.getString("misc"));
    mservice = Double.parseDouble(rset.getString("service"));
  }

   sql = "select total,discount,final_amount,due from bill_money where patient_id = "+id+" " ;
   stat = connection.createStatement();
   rset = stat.executeQuery(sql);
   while (rset.next()) {
    mtotal = Double.parseDouble(rset.getString("total"));
    mdiscount = Double.parseDouble(rset.getString("discount"));
    mfinal_amount = Double.parseDouble(rset.getString("final_amount"));
    mdue = Double.parseDouble(rset.getString("due"));
  }

   sql = "select advance from bill_advance where patient_id = "+id+" " ;
   stat = connection.createStatement();
   rset = stat.executeQuery(sql);
   while (rset.next()) {
    madvance = Double.parseDouble(rset.getString("advance"));
  }

   bed.setText(String.valueOf(mbed));
   cabin_field.setText(String.valueOf(mcabin));
   ot.setText(String.valueOf(mot));
   del.setText(String.valueOf(mdelivery));
   pack.setText(String.valueOf(mpack));
   po.setText(String.valueOf(mpo));
   nebu.setText(String.valueOf(mnebu));
   oxyzen.setText(String.valueOf(moxy));
   patho.setText(String.valueOf(mpatho));
   radio.setText(String.valueOf(mradio));
   urine.setText(String.valueOf(murine));
   ecg.setText(String.valueOf(mecg));
   dressing.setText(String.valueOf(mdress));
   misc.setText(String.valueOf(mmisc));

   tot.setText(String.valueOf(mtotal));
   dis.setText(String.valueOf(mdiscount));
   fin.setText(String.valueOf(mfinal_amount));
   advance.setText(String.valueOf(madvance));
   mdue = mfinal_amount - madvance;
   due.setText(String.valueOf(mdue));




             stat.close();

             rset.close();

 }
 catch (SQLException sqlException) {
   JOptionPane.showMessageDialog(null, sqlException.getMessage(),"Database error",JOptionPane.ERROR_MESSAGE);
 }
}

    preview.setEnabled(true);


  }

  void jButton3_actionPerformed(ActionEvent e) {
     dispose();
  }

  void jButton4_actionPerformed(ActionEvent e) {

    String temp[]=new String[1];

      ward_list.setListData(temp);
      bed_list.setListData(temp);
      cabin_list.setListData(temp);
      gb_list.setListData(temp);
      pb_list.setListData(temp);

      name.setText("");
      bed.setText("");
      cabin_field.setText("");
      ot.setText("");
      del.setText("");
      pack.setText("");
      po.setText("");
      nebu.setText("");
      radio.setText("");
      patho.setText("");
      ecg.setText("");
      urine.setText("");
      dressing.setText("");
      oxyzen.setText("");
      misc.setText("");
      tot.setText("");
      dis.setText("");
      fin.setText("");
      advance.setText("");
      due.setText("");
       print.setEnabled(false);

  }

  void urine_actionPerformed(ActionEvent e) {

  }

  void preview_actionPerformed(ActionEvent e) {

    info="";


     //mtotal=0,mdiscount=0,mfinal_amount=0,mdue=0,madvance=0;
     str1 = names ;
     info+=str1+"\n";

     str2 = "Total: " + String.valueOf(mtotal) ;
     info+=str2+"\n";
     str3 = "discount: " + String.valueOf(mdiscount);
     info+=str3+"\n";
     str4 = "Remaining Total: " + String.valueOf(mfinal_amount);
     info+=str4+"\n";
     str5 = "Due: " + String.valueOf(mdue) ;
     info+=str5+"\n";
     str6 = "Advance: " + String.valueOf(madvance) ;
     info+=str6+"\n";
     //str2 = //mtotal.

     info +="\n";

     JOptionPane.showMessageDialog(null,info);
     print.setEnabled(true);


  }

  void print_actionPerformed(ActionEvent e) {
    print_it();
  }


}

class search_bill_ward_actionAdapter implements java.awt.event.ActionListener {
  search_bill adaptee;

  search_bill_ward_actionAdapter(search_bill adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.ward_actionPerformed(e);
  }
}

class search_bill_cabin_actionAdapter implements java.awt.event.ActionListener {
  search_bill adaptee;

  search_bill_cabin_actionAdapter(search_bill adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.cabin_actionPerformed(e);
  }
}

class search_bill_gb_actionAdapter implements java.awt.event.ActionListener {
  search_bill adaptee;

  search_bill_gb_actionAdapter(search_bill adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.gb_actionPerformed(e);
  }
}

class search_bill_pb_actionAdapter implements java.awt.event.ActionListener {
  search_bill adaptee;

  search_bill_pb_actionAdapter(search_bill adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.pb_actionPerformed(e);
  }
}

class search_bill_jButton5_actionAdapter implements java.awt.event.ActionListener {
  search_bill adaptee;

  search_bill_jButton5_actionAdapter(search_bill adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton5_actionPerformed(e);
  }
}

class search_bill_jButton3_actionAdapter implements java.awt.event.ActionListener {
  search_bill adaptee;

  search_bill_jButton3_actionAdapter(search_bill adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton3_actionPerformed(e);
  }
}

class search_bill_jButton4_actionAdapter implements java.awt.event.ActionListener {
  search_bill adaptee;

  search_bill_jButton4_actionAdapter(search_bill adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton4_actionPerformed(e);
  }
}

class search_bill_urine_actionAdapter implements java.awt.event.ActionListener {
  search_bill adaptee;

  search_bill_urine_actionAdapter(search_bill adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.urine_actionPerformed(e);
  }
}

class search_bill_preview_actionAdapter implements java.awt.event.ActionListener {
  search_bill adaptee;

  search_bill_preview_actionAdapter(search_bill adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.preview_actionPerformed(e);
  }
}

class search_bill_print_actionAdapter implements java.awt.event.ActionListener {
  search_bill adaptee;

  search_bill_print_actionAdapter(search_bill adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.print_actionPerformed(e);
  }
}
