
package hospital;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;


public class Bill extends JFrame {

  Connection connection;
  public long id=0;
  String dat="";
  JButton jButton2 = new JButton();
  JPanel jPanel1 = new JPanel();
  JLabel jLabel2 = new JLabel();
  JLabel Hospital_name1 = new JLabel();
  JPanel jPanel2 = new JPanel();
  JCheckBox misc = new JCheckBox();
  JTextField radio_field = new JTextField();
  JTextField urine_field = new JTextField();
  JTextField ecg_field = new JTextField();
  JCheckBox ot = new JCheckBox();
  JCheckBox urine = new JCheckBox();
  JTextField del_field = new JTextField();
  JCheckBox pack = new JCheckBox();
  JCheckBox ecg = new JCheckBox();
  JTextField misc_field = new JTextField();
  JCheckBox po = new JCheckBox();
  JTextField bed_field = new JTextField();
  JCheckBox radio = new JCheckBox();
  JTextField nebu_field = new JTextField();
  JCheckBox del = new JCheckBox();
  JTextField po_field = new JTextField();
  JCheckBox dressing = new JCheckBox();
  JTextField ot_field = new JTextField();
  JCheckBox nebu = new JCheckBox();
  JLabel Amount = new JLabel();
  JTextField oxyzen_field = new JTextField();
  JCheckBox cabins = new JCheckBox();
  JTextField dressing_field = new JTextField();
  JCheckBox oxyzen = new JCheckBox();
  JTextField cabin_field = new JTextField();
  JCheckBox bed = new JCheckBox();
  JTextField pack_field = new JTextField();
  JCheckBox patho = new JCheckBox();
  JTextField patho_field = new JTextField();
  JPanel jPanel4 = new JPanel();
  JPanel jPanel5 = new JPanel();
  JLabel jLabel3 = new JLabel();
  JTextField total_field = new JTextField();
  JCheckBox discount = new JCheckBox();
  JTextField discount_field = new JTextField();
  JLabel jLabel4 = new JLabel();
  JTextField amount_field = new JTextField();
  JLabel jLabel7 = new JLabel();
  JTextField advance = new JTextField();
  JLabel jLabel8 = new JLabel();
  JTextField due = new JTextField();
  JButton jButton4 = new JButton();
  JButton jButton1 = new JButton();
  JButton jButton3 = new JButton();
  JPanel jPanel6 = new JPanel();
  JRadioButton ward = new JRadioButton();
  JRadioButton gb = new JRadioButton();
  JRadioButton cabin = new JRadioButton();
  JScrollPane bed_scroll = new JScrollPane();
  JLabel jLabel6 = new JLabel();
  JTextField name = new JTextField();
  JLabel jLabel5 = new JLabel();
  JScrollPane ward_scroll = new JScrollPane();
  JLabel jLabel1 = new JLabel();
  JPanel jPanel3 = new JPanel();
  JFormattedTextField dates = new JFormattedTextField();
  JScrollPane pb_scroll = new JScrollPane();
  JScrollPane cabin_scroll = new JScrollPane();
  JRadioButton pb = new JRadioButton();
  JScrollPane gb_scroll = new JScrollPane();
  JList ward_list = new JList();
  JList bed_list = new JList();
  JList cabin_list = new JList();
  JList gb_list = new JList();
  JList pb_list = new JList();
  ButtonGroup group = new ButtonGroup();
  JLabel Amount1 = new JLabel();
  Date dated;
  JLabel jLabel9 = new JLabel();

  public Bill() {
    try {
      jbInit();
      setSize(700,520);
      setLocation(90,50);
      show();

      Statement stat;
      ResultSet rset;
      String sql;
      connection = Main.connection;






       sql = "select to_char(sysDate,'DD-MM-YYYY') from dual";
       stat = connection.createStatement();
       rset = stat.executeQuery(sql);
       while(rset.next())
       dat= rset.getString(1);
       dates.setText(dat);

       stat.close();


    }
    catch(Exception ex) {
      ex.printStackTrace();
    }

    name.setEditable(false);
    bed_field.setEnabled(false);
    cabin_field.setEnabled(false);
    ot_field.setEnabled(false);
    del_field.setEnabled(false);
    pack_field.setEnabled(false);
    po_field.setEnabled(false);
    nebu_field.setEnabled(false);
    oxyzen_field.setEnabled(false);
    patho_field.setEnabled(false);
    radio_field.setEnabled(false);
    ecg_field.setEnabled(false);
    urine_field.setEnabled(false);
    dressing_field.setEnabled(false);
    misc_field.setEnabled(false);
    //service_field.setEnabled(false);
    total_field.setEnabled(false);
    amount_field.setEnabled(false);
    due.setEnabled(false);
    advance.setEnabled(false);
    discount_field.setEnabled(false);


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
         String str="";

         while (rset.next()) {
           id = Integer.parseInt(rset.getString("patient_id"));
           str += rset.getString("patient_name") ;
         }

         stat = connection.createStatement();
         sql = "select advance from bill_advance where  patient_id = "+id+" ";
         rset = stat.executeQuery(sql);
         String str1="";
         double money=0;
         while (rset.next()) {
           money = Double.parseDouble(rset.getString("advance"));
         }

         stat = connection.createStatement();
         sql = "select due from bill_money where  patient_id = "+id+" ";
         rset = stat.executeQuery(sql);
         double duess=0;
         while (rset.next()) {
           duess = Double.parseDouble(rset.getString("due"));
         }



         advance.setText(String.valueOf(money));
         due.setText(String.valueOf(duess));
         name.setText(str);

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
         String str="";

         while (rset.next()) {
           id = Integer.parseInt(rset.getString("patient_id"));
           str += rset.getString("patient_name") ;
         }

         stat = connection.createStatement();
         sql = "select advance from bill_advance where  patient_id = "+id+" ";
         rset = stat.executeQuery(sql);
         String str1="";
         double money=0;
         while (rset.next()) {
           money = Double.parseDouble(rset.getString("advance"));
         }

         stat = connection.createStatement();
         sql = "select due from bill_money where  patient_id = "+id+" ";
         rset = stat.executeQuery(sql);
         double duess=0;
         while (rset.next()) {
           duess = Double.parseDouble(rset.getString("due"));
         }



         advance.setText(String.valueOf(money));
         due.setText(String.valueOf(duess));

       name.setText(str);

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
         String str="";
         while (rset.next()) {
           id = Integer.parseInt(rset.getString("patient_id"));
           str += rset.getString("patient_name") ;
         }

         stat = connection.createStatement();
         sql = "select advance from bill_advance where  patient_id = "+id+" ";
         rset = stat.executeQuery(sql);

         double money=0;
         while (rset.next()) {
           money = Double.parseDouble(rset.getString("advance"));
         }

         stat = connection.createStatement();
         sql = "select due from bill_money where  patient_id = "+id+" ";
         rset = stat.executeQuery(sql);
         double duess=0;
         while (rset.next()) {
           duess = Double.parseDouble(rset.getString("due"));
         }

         advance.setText(String.valueOf(money));
         due.setText(String.valueOf(duess));

     name.setText(str);

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
         String str="";
         //long id=0;
         while (rset.next()) {
           id = Integer.parseInt(rset.getString("patient_id"));
           str += rset.getString("patient_name") ;
         }

         stat = connection.createStatement();
         sql = "select advance from bill_advance where  patient_id = "+id+" ";
         rset = stat.executeQuery(sql);

         double money=0;
         while (rset.next()) {
           money = Double.parseDouble(rset.getString("advance"));
         }

         stat = connection.createStatement();
         sql = "select due from bill_money where  patient_id = "+id+" ";
         rset = stat.executeQuery(sql);
         double duess=0;
         while (rset.next()) {
           duess = Double.parseDouble(rset.getString("due"));
         }

         advance.setText(String.valueOf(money));
         due.setText(String.valueOf(duess));

       name.setText(str);

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
  }

  void jbInit() throws Exception {
    Object jScrollPane = "";
    this.getContentPane().setLayout(null);
    jButton2.setText("jButton2");
    this.getContentPane().setBackground(new Color(173, 201, 139));
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setResizable(false);
    this.setTitle("BILL ENTRY");
    jPanel1.setBackground(new Color(173, 201, 139));
    jPanel1.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel1.setBounds(new Rectangle(21, 135, 666, 25));
    jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 13));
    jLabel2.setForeground(SystemColor.infoText);
    jLabel2.setText("BILL ENTRY");
    Hospital_name1.setFont(new java.awt.Font("Dialog", 1, 18));
    Hospital_name1.setForeground(SystemColor.desktop);
    Hospital_name1.setText("JALALABAD RAGIB-RABEYA MEDICAL COLLEGE HOSPITAL");
    Hospital_name1.setBounds(new Rectangle(67, 6, 560, 28));
    jPanel2.setBackground(new Color(173, 201, 139));
    jPanel2.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel2.setBounds(new Rectangle(22, 160, 664, 192));
    jPanel2.setLayout(null);
    misc.setBounds(new Rectangle(359, 167, 67, 21));
    misc.addActionListener(new Bill_misc_actionAdapter(this));
    misc.setBackground(new Color(173, 201, 139));
    misc.setText("MISC:");
    radio_field.setFont(new java.awt.Font("Dialog", 1, 12));
    radio_field.setText("");
    radio_field.setBounds(new Rectangle(510, 45, 122, 19));
    urine_field.setFont(new java.awt.Font("Dialog", 1, 12));
    urine_field.setText("");
    urine_field.setBounds(new Rectangle(509, 93, 124, 19));
    ecg_field.setFont(new java.awt.Font("Dialog", 1, 12));
    ecg_field.setText("");
    ecg_field.setBounds(new Rectangle(510, 70, 122, 19));
    ot.setBounds(new Rectangle(6, 73, 205, 21));
    ot.addActionListener(new Bill_ot_actionAdapter(this));
    ot.setBackground(new Color(173, 201, 139));
    ot.setText("OT CHARGES+ANAESTHESIA:");
    urine.setBounds(new Rectangle(357, 95, 148, 21));
    urine.addActionListener(new Bill_urine_actionAdapter(this));
    urine.setBackground(new Color(173, 201, 139));
    urine.setText("BED SIDE URINE TEST");
    del_field.setFont(new java.awt.Font("Dialog", 1, 12));
    del_field.setText("");
    del_field.setBounds(new Rectangle(222, 97, 114, 19));
    pack.setBounds(new Rectangle(6, 120, 152, 21));
    pack.addActionListener(new Bill_pack_actionAdapter(this));
    pack.setBackground(new Color(173, 201, 139));
    pack.setText("PACKAGE PROGRAM:");
    ecg.setBounds(new Rectangle(357, 70, 58, 21));
    ecg.addActionListener(new Bill_ecg_actionAdapter(this));
    ecg.setBackground(new Color(173, 201, 139));
    ecg.setText("E.C.G");
    misc_field.setFont(new java.awt.Font("Dialog", 1, 12));
    misc_field.setText("");
    misc_field.setBounds(new Rectangle(509, 173, 127, 21));
    po.setBounds(new Rectangle(6, 143, 103, 21));
    po.addActionListener(new Bill_po_actionAdapter(this));
    po.setBackground(new Color(173, 201, 139));
    po.setText("PO CHARGES:");
    bed_field.setFont(new java.awt.Font("Dialog", 1, 12));
    bed_field.setForeground(Color.black);
    bed_field.setDisabledTextColor(SystemColor.activeCaption);
    bed_field.setText("");
    bed_field.setBounds(new Rectangle(224, 26, 114, 19));
    radio.setBounds(new Rectangle(357, 46, 147, 21));
    radio.addActionListener(new Bill_radio_actionAdapter(this));
    radio.setBackground(new Color(173, 201, 139));
    radio.setText("RADIOLOGY &IMAGING");
    nebu_field.setFont(new java.awt.Font("Dialog", 1, 12));
    nebu_field.setText("");
    nebu_field.setBounds(new Rectangle(223, 168, 114, 19));
    del.setBounds(new Rectangle(6, 98, 210, 21));
    del.addActionListener(new Bill_del_actionAdapter(this));
    del.setBackground(new Color(173, 201, 139));
    del.setFont(new java.awt.Font("Dialog", 1, 11));
    del.setText("NORMAL DELIVERY/ D&C CHARGE ");
    po_field.setFont(new java.awt.Font("Dialog", 1, 12));
    po_field.setText("");
    po_field.setBounds(new Rectangle(223, 143, 114, 21));
    dressing.setBounds(new Rectangle(358, 121, 150, 21));
    dressing.addActionListener(new Bill_dressing_actionAdapter(this));
    dressing.setBackground(new Color(173, 201, 139));
    dressing.setText("DRESSING CHARGE:");
    ot_field.setFont(new java.awt.Font("Dialog", 1, 12));
    ot_field.setText("");
    ot_field.setBounds(new Rectangle(223, 74, 114, 19));
    nebu.setBounds(new Rectangle(7, 164, 120, 21));
    nebu.addActionListener(new Bill_nebu_actionAdapter(this));
    nebu.setBackground(new Color(173, 201, 139));
    nebu.setText("NEBULIZATION:");
    Amount.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
    Amount.setText("AMOUNT");
    Amount.setBounds(new Rectangle(241, 3, 85, 17));
    oxyzen_field.setFont(new java.awt.Font("Dialog", 1, 12));
    oxyzen_field.setText("");
    oxyzen_field.setBounds(new Rectangle(510, 144, 124, 23));
    cabins.setBounds(new Rectangle(6, 50, 127, 21));
    cabins.addActionListener(new Bill_cabins_actionAdapter(this));
    cabins.setBackground(new Color(173, 201, 139));
    cabins.setText("CABIN CHARGES:");
    dressing_field.setFont(new java.awt.Font("Dialog", 1, 12));
    dressing_field.setText("");
    dressing_field.setBounds(new Rectangle(511, 118, 123, 22));
    oxyzen.setBounds(new Rectangle(358, 144, 144, 21));
    oxyzen.addActionListener(new Bill_oxyzen_actionAdapter(this));
    oxyzen.setBackground(new Color(173, 201, 139));
    oxyzen.setText("OXYZEN CHARGES:");
    cabin_field.setFont(new java.awt.Font("Dialog", 1, 12));
    cabin_field.setForeground(Color.black);
    cabin_field.setDisabledTextColor(SystemColor.activeCaption);
    cabin_field.setText("");
    cabin_field.setBounds(new Rectangle(223, 49, 114, 19));
    bed.setBackground(new Color(173, 201, 139));
    bed.setText("BED CHARGES:");
    bed.setBounds(new Rectangle(7, 26, 170, 21));
    bed.addActionListener(new Bill_bed_actionAdapter(this));
    pack_field.setFont(new java.awt.Font("Dialog", 1, 12));
    pack_field.setText("");
    pack_field.setBounds(new Rectangle(223, 120, 114, 19));
    patho.setBackground(new Color(173, 201, 139));
    patho.setText("PATHOLOGY:");
    patho.setBounds(new Rectangle(356, 24, 113, 21));
    patho.addActionListener(new Bill_patho_actionAdapter(this));
    patho_field.setFont(new java.awt.Font("Dialog", 1, 12));
    patho_field.setText("");
    patho_field.setBounds(new Rectangle(510, 21, 122, 19));
    jPanel4.setBackground(new Color(173, 201, 139));
    jPanel4.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel4.setBounds(new Rectangle(21, 353, 327, 86));
    jPanel4.setLayout(null);
    jPanel5.setLayout(null);
    jPanel5.setBounds(new Rectangle(353, 354, 332, 86));
    jPanel5.setBackground(new Color(173, 201, 139));
    jPanel5.setBorder(BorderFactory.createLoweredBevelBorder());
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel3.setText("TOTAL");
    jLabel3.setBounds(new Rectangle(54, 7, 50, 19));
    total_field.setFont(new java.awt.Font("Dialog", 1, 12));
    total_field.setDisabledTextColor(SystemColor.activeCaption);
    total_field.setText("");
    total_field.setBounds(new Rectangle(161, 6, 99, 22));
    discount.setBackground(new Color(173, 201, 139));
    discount.setFont(new java.awt.Font("Dialog", 1, 12));
    discount.setText("DISCOUNT");
    discount.setBounds(new Rectangle(51, 32, 95, 19));
    discount.addActionListener(new Bill_discount_actionAdapter(this));
    discount_field.setFont(new java.awt.Font("Dialog", 1, 12));
    discount_field.setText("");
    discount_field.setBounds(new Rectangle(161, 34, 98, 22));
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel4.setText("TOTAL AMOUNT");
    jLabel4.setBounds(new Rectangle(54, 59, 107, 24));
    amount_field.setFont(new java.awt.Font("Dialog", 1, 12));
    amount_field.setDisabledTextColor(SystemColor.activeCaption);
    amount_field.setText("");
    amount_field.setBounds(new Rectangle(162, 60, 97, 21));
    jLabel7.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel7.setText("ADVANCE PAID");
    jLabel7.setBounds(new Rectangle(28, 19, 90, 19));
    advance.setFont(new java.awt.Font("Dialog", 1, 13));
    advance.setForeground(Color.blue);
    advance.setDisabledTextColor(SystemColor.activeCaption);
    advance.setText("");
    advance.setBounds(new Rectangle(132, 15, 130, 24));
    jLabel8.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel8.setText("DUE");
    jLabel8.setBounds(new Rectangle(29, 43, 37, 25));
    due.setFont(new java.awt.Font("Dialog", 1, 12));
    due.setDisabledTextColor(SystemColor.activeCaption);
    due.setBounds(new Rectangle(133, 47, 129, 23));
    jButton4.setBackground(new Color(173, 201, 139));
    jButton4.setBounds(new Rectangle(275, 8, 75, 25));
    jButton4.setFont(new java.awt.Font("Dialog", 1, 12));
    jButton4.setBorder(BorderFactory.createRaisedBevelBorder());
    jButton4.setMnemonic('C');
    jButton4.setText("CLEAR");
    jButton4.addActionListener(new Bill_jButton4_actionAdapter(this));
    jButton1.setBackground(new Color(173, 201, 139));
    jButton1.setBounds(new Rectangle(168, 8, 72, 26));
    jButton1.setFont(new java.awt.Font("Dialog", 1, 12));
    jButton1.setBorder(BorderFactory.createRaisedBevelBorder());
    jButton1.setMnemonic('E');
    jButton1.setText("ENTRY");
    jButton1.addActionListener(new Bill_jButton1_actionAdapter(this));
    jButton3.setBackground(new Color(173, 201, 139));
    jButton3.setBounds(new Rectangle(384, 7, 66, 27));
    jButton3.setFont(new java.awt.Font("Dialog", 1, 12));
    jButton3.setBorder(BorderFactory.createRaisedBevelBorder());
    jButton3.setMnemonic('L');
    jButton3.setText("CLOSE");
    jButton3.addActionListener(new Bill_jButton3_actionAdapter(this));
    jPanel6.setBackground(new Color(173, 201, 139));
    jPanel6.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel6.setBounds(new Rectangle(19, 442, 664, 39));
    jPanel6.setLayout(null);
    ward.setBounds(new Rectangle(15, 15, 67, 27));
    ward.addActionListener(new Bill_ward_actionAdapter(this));
    ward.setBackground(new Color(173, 201, 139));
    ward.setFont(new java.awt.Font("Dialog", 1, 12));
    ward.setText("WARD");
    gb.setBounds(new Rectangle(350, 10, 106, 24));
    gb.addActionListener(new Bill_gb_actionAdapter(this));
    gb.setBackground(new Color(173, 201, 139));
    gb.setFont(new java.awt.Font("Dialog", 1, 12));
    gb.setText("GENERAL BED");
    cabin.setBounds(new Rectangle(15, 42, 72, 23));
    cabin.addActionListener(new Bill_cabin_actionAdapter(this));
    cabin.setBackground(new Color(173, 201, 139));
    cabin.setFont(new java.awt.Font("Dialog", 1, 12));
    cabin.setText("CABIN");
    bed_scroll.setBounds(new Rectangle(178, 19, 62, 20));
    jLabel6.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel6.setText("DATE");
    jLabel6.setBounds(new Rectangle(369, 64, 45, 23));
    name.setBackground(SystemColor.textHighlightText);
    name.setFont(new java.awt.Font("Dialog", 1, 12));
    name.setText("");
    name.setBounds(new Rectangle(93, 74, 154, 23));
    jLabel5.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel5.setText("NAME");
    jLabel5.setBounds(new Rectangle(22, 73, 56, 20));
    ward_scroll.setBounds(new Rectangle(102, 19, 59, 20));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1.setText("BED");
    jLabel1.setBounds(new Rectangle(192, 4, 38, 14));
    jPanel3.setBackground(new Color(173, 201, 139));
    jPanel3.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel3.setBounds(new Rectangle(21, 32, 665, 102));
    jPanel3.setLayout(null);
    dates.setBackground(SystemColor.textHighlightText);
    dates.setDisabledTextColor(SystemColor.activeCaption);
    dates.setFont(new java.awt.Font("SansSerif", 1, 13));
    dates.setForeground(SystemColor.activeCaption);
    dates.setBounds(new Rectangle(481, 63, 85, 20));
    pb_scroll.setBounds(new Rectangle(481, 37, 56, 20));
    cabin_scroll.setBounds(new Rectangle(102, 45, 60, 20));
    pb.setBackground(new Color(173, 201, 139));
    pb.setFont(new java.awt.Font("Dialog", 1, 12));
    pb.setText("PAYING BED");
    pb.setBounds(new Rectangle(351, 37, 98, 23));
    pb.addActionListener(new Bill_pb_actionAdapter(this));
    gb_scroll.setBounds(new Rectangle(481, 11, 55, 20));
    Amount1.setBounds(new Rectangle(539, 3, 64, 17));
    Amount1.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
    Amount1.setText("AMOUNT");
    jLabel9.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel9.setText("%");
    jLabel9.setBounds(new Rectangle(261, 35, 22, 23));
    ward_list.setFont(new java.awt.Font("Dialog", 1, 12));
    bed_list.setFont(new java.awt.Font("Dialog", 1, 12));
    cabin_list.setFont(new java.awt.Font("Dialog", 1, 12));
    gb_list.setFont(new java.awt.Font("Dialog", 1, 12));
    pb_list.setFont(new java.awt.Font("Dialog", 1, 12));
    jPanel5.add(jLabel7, null);
    jPanel5.add(advance, null);
    jPanel5.add(due, null);
    jPanel5.add(jLabel8, null);
    this.getContentPane().add(jPanel6, null);
    jPanel6.add(jButton3, null);
    jPanel6.add(jButton4, null);
    jPanel6.add(jButton1, null);
    jPanel4.add(jLabel4, null);
    jPanel4.add(discount, null);
    jPanel4.add(jLabel3, null);
    jPanel4.add(amount_field, null);
    jPanel4.add(discount_field, null);
    jPanel4.add(total_field, null);
    jPanel4.add(jLabel9, null);
    this.getContentPane().add(jPanel5, null);
    this.getContentPane().add(jPanel1, null);
    jPanel1.add(jLabel2, null);
    this.getContentPane().add(jPanel2, null);
    jPanel2.add(ot, null);
    jPanel2.add(cabins, null);
    jPanel2.add(bed, null);
    jPanel2.add(bed_field, null);
    jPanel2.add(Amount, null);
    jPanel2.add(del, null);
    jPanel2.add(cabin_field, null);
    jPanel2.add(ot_field, null);
    jPanel2.add(del_field, null);
    jPanel2.add(pack, null);
    jPanel2.add(pack_field, null);
    jPanel2.add(po, null);
    jPanel2.add(po_field, null);
    jPanel2.add(nebu, null);
    jPanel2.add(nebu_field, null);
    jPanel2.add(patho, null);
    jPanel2.add(radio, null);
    jPanel2.add(ecg, null);
    jPanel2.add(urine, null);
    jPanel2.add(dressing, null);
    jPanel2.add(patho_field, null);
    jPanel2.add(radio_field, null);
    jPanel2.add(ecg_field, null);
    jPanel2.add(urine_field, null);
    jPanel2.add(dressing_field, null);
    jPanel2.add(Amount1, null);
    jPanel2.add(oxyzen, null);
    jPanel2.add(misc, null);
    jPanel2.add(oxyzen_field, null);
    jPanel2.add(misc_field, null);
    this.getContentPane().add(jPanel4, null);
    this.getContentPane().add(Hospital_name1, null);
    this.getContentPane().add(jPanel3, null);
    jPanel3.add(cabin, null);
    jPanel3.add(cabin_scroll, null);
    jPanel3.add(ward_scroll, null);
    jPanel3.add(ward, null);
    jPanel3.add(bed_scroll, null);
    jPanel3.add(jLabel1, null);
    jPanel3.add(jLabel5, null);
    jPanel3.add(name, null);
    jPanel3.add(gb_scroll, null);
    jPanel3.add(pb_scroll, null);
    jPanel3.add(dates, null);
    jPanel3.add(gb, null);
    jPanel3.add(pb, null);
    jPanel3.add(jLabel6, null);
    ward_scroll.getViewport().add(ward_list, null);
    bed_scroll.getViewport().add(bed_list, null);
    cabin_scroll.getViewport().add(cabin_list, null);
    gb_scroll.getViewport().add(gb_list, null);
    pb_scroll.getViewport().add(pb_list, null);

    group.add(ward);
    group.add(cabin);
    group.add(gb);
    group.add(pb);


  }

  public static void main(String[] args) {
    Bill bill = new Bill();
  }

  void ward_actionPerformed(ActionEvent e) {

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
    name.setText("");

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
    cabin_list.setEnabled(true);
    name.setText("");
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

  void bed_actionPerformed(ActionEvent e) {

       if(bed.isSelected())
         {  //bed_field.setEnabled(true);
            bed_field.setText("100");
         }
       else
           bed_field.setText("");
  }

  void cabins_actionPerformed(ActionEvent e) {
    if(cabins.isSelected())
          cabin_field.setText("250");
      else
         cabin_field.setText("");


  }

  void ot_actionPerformed(ActionEvent e) {
    //ot_field.setEnabled(true);
    if(ot.isSelected())
          ot_field.setEnabled(true);
      else
         ot_field.setEnabled(false);

  }

  void del_actionPerformed(ActionEvent e) {
    //del_field.setEnabled(true);
    if(del.isSelected())
          del_field.setEnabled(true);
      else
         del_field.setEnabled(false);

  }

  void pack_actionPerformed(ActionEvent e) {
    //pack_field.setEnabled(true);
    if(pack.isSelected())
         pack_field.setEnabled(true);
    else
         pack_field.setEnabled(false);

  }

  void po_actionPerformed(ActionEvent e) {
        //po_field.setEnabled(true);
        if(po.isSelected())
          po_field.setEnabled(true);
        else
          po_field.setEnabled(false);

  }

  void nebu_actionPerformed(ActionEvent e) {
        //nebu_field.setEnabled(true);
        if(nebu.isSelected())
          nebu_field.setEnabled(true);
      else
         nebu_field.setEnabled(false);

  }

  void oxyzen_actionPerformed(ActionEvent e) {
        //oxyzen_field.setEnabled(true);
        if(oxyzen.isSelected())
          oxyzen_field.setEnabled(true);
        else
         oxyzen_field.setEnabled(false);

  }

  void patho_actionPerformed(ActionEvent e) {
        //patho_field.setEnabled(true);
        if(patho.isSelected())
          patho_field.setEnabled(true);
        else
         patho_field.setEnabled(false);

  }

  void radio_actionPerformed(ActionEvent e) {
        //radio_field.setEnabled(true);
        if(radio.isSelected())
          radio_field.setEnabled(true);
      else
         radio_field.setEnabled(false);

  }

  void ecg_actionPerformed(ActionEvent e) {
        //ecg_field.setEnabled(true);
        if(ecg.isSelected())
         ecg_field.setEnabled(true);
        else
         ecg_field.setEnabled(false);

  }

  void urine_actionPerformed(ActionEvent e) {
        //urine_field.setEnabled(true);
        if(urine.isSelected())
          urine_field.setEnabled(true);
      else
         urine_field.setEnabled(false);

  }

  void dressing_actionPerformed(ActionEvent e) {
        //dressing_field.setEnabled(true);
        if(dressing.isSelected())
          dressing_field.setEnabled(true);
        else
         dressing_field.setEnabled(false);

  }

  void misc_actionPerformed(ActionEvent e) {
        //misc_field.setEnabled(true);
        if(misc.isSelected())
          misc_field.setEnabled(true);
        else
         misc_field.setEnabled(false);

  }



  void discount_actionPerformed(ActionEvent e) {

    if(discount.isSelected())
      {
        discount_field.setEnabled(true);

      }
      else
        {  discount_field.setEnabled(false);
            discount_field.setText("");
        }

  }

  void jButton1_actionPerformed(ActionEvent e) {

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

     double mbed=0,mcabin=0,mot=0,mdelivery=0,mpack=0,mpo=0,mnebu=0,moxy=0,mpatho=0,mradio=0,mecg=0,murine=0,mdress=0,mmisc=0,mservice=0;
     double mtotal=0,mdiscount=0,mfinal_amount=0,mdue=0,madvance=0;

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

    double total=0,temp=0;

    if(bed.isSelected()) {
      temp = Double.parseDouble(bed_field.getText());
      total+=temp;
      mbed +=temp;

    }
     if(cabins.isSelected()) {
      temp = Double.parseDouble(cabin_field.getText());
      total +=temp;
      mcabin += temp;


    }
    if(ot.isSelected()) {
      temp = Double.parseDouble(ot_field.getText());
      mot+=temp;
      total+=temp;

    }
    if(del.isSelected()) {
          temp = Double.parseDouble(del_field.getText());
          mdelivery += temp;
          total+=temp;
        }
    if(pack.isSelected()) {
          temp = Double.parseDouble(pack_field.getText());
          mpack+=temp;
          total+=temp;
    }
    if(po.isSelected()) {
           temp= Double.parseDouble(po_field.getText());
           mpo+=temp;
           total+=temp;
    }
    if(nebu.isSelected()) {
       temp = Double.parseDouble(nebu_field.getText());
      mnebu+=temp;
      total+=temp;
    }
    if(oxyzen.isSelected()) {
      temp = Double.parseDouble(oxyzen_field.getText());
      moxy+=temp;
      total+=temp;
    }
    if(patho.isSelected()) {
      temp = Double.parseDouble(patho_field.getText());
      mpatho+=temp;
      total+=temp;
    }
    if(radio.isSelected()) {
      temp= Double.parseDouble(radio_field.getText());
      mradio+=temp;
      total+=temp;
    }
    if(ecg.isSelected()) {
      temp= Double.parseDouble(ecg_field.getText());
      mecg+=temp;
      total+=temp;
    }
    if(urine.isSelected()) {
      temp =Double.parseDouble(urine_field.getText());
      murine+=temp;
      total+=temp;
    }
    if(dressing.isSelected()) {
      temp = Double.parseDouble(dressing_field.getText());
      mdress+=temp;
      total+=temp;
    }
    if(misc.isSelected()) {
      temp = Double.parseDouble(misc_field.getText());
      mmisc+=temp;
      total+=temp;
    }

    //System.out.println(total);

    total_field.setText(String.valueOf(total));
    double final_totals=0,discounts=0,dues=0;

   if(discount.isSelected())
   {
       double com = Double.parseDouble(discount_field.getText());
       discounts = (total * com)/100;
       final_totals = total - discounts;
       dues = final_totals - Double.parseDouble(advance.getText());
       //due.setText(String.valueOf(dues));
       amount_field.setText(String.valueOf(final_totals));
   }
   else
   {
      final_totals = total ;
      dues = final_totals - Double.parseDouble(advance.getText());
      //due.setText(String.valueOf(dues));
      amount_field.setText(String.valueOf(final_totals));
  }

  mtotal +=total;
  mdiscount += discounts;
  mfinal_amount += final_totals;
  mdue = mfinal_amount - madvance;

  due.setText(String.valueOf(mdue));

  // deleteing billing tables
              sql = "delete from bill_1 where patient_id = "+id+"";
              stat = connection.createStatement();
              boolean insertResult1 = stat.execute(sql);

              sql = "delete from bill_2 where patient_id = "+id+"";
              stat = connection.createStatement();
              boolean insertResult2 = stat.execute(sql);

              sql = "delete from bill_money where patient_id = "+id+"";
              stat = connection.createStatement();
              boolean insertResult3 = stat.execute(sql);

              sql = "insert into bill_1 values ("+id+","+mbed+","+mcabin+","+mot+","+mdelivery+","+mpack+","+mpo+","+mnebu+","+moxy+") ";
              stat = connection.createStatement();
               boolean insertResult4 = stat.execute(sql);

               sql = "insert into bill_2 values ("+id+","+mpatho+","+mradio+","+mecg+","+murine+","+mdress+","+mmisc+","+mservice+") ";
              stat = connection.createStatement();
               boolean insertResult5 = stat.execute(sql);

               sql = "insert into bill_money values ("+id+","+mtotal+","+mdiscount+","+mfinal_amount+","+mdue+") ";
             stat = connection.createStatement();
              boolean insertResult6 = stat.execute(sql);


              ///////updating income//////



         double indoor=0;
         int outdoor=0;
         String temp1="";
         sql = "select indoor,outdoor from income where dates = '"+dat+"' ";
         stat = connection.createStatement();
         rset = stat.executeQuery(sql);
         while (rset.next()) {
          indoor  = Integer.parseInt(rset.getString("indoor"));
          outdoor  = Integer.parseInt(rset.getString("outdoor"));
          temp1+=indoor;
        }


        if(temp1.equals(""))
        {
          indoor = final_totals;
          stat = connection.createStatement();
          sql = "insert into income values('"+dat+"',"+indoor+","+outdoor+")";
          insertResult3 = stat.execute(sql);
          stat.close();
        }
        else
        {
          indoor = indoor + final_totals;
          stat = connection.createStatement();
          sql = "update income set indoor="+indoor+" where dates='"+dat+"'" ;
          insertResult3 = stat.execute(sql);
          stat.close();

        }

      //////////////////////////
      rset.close();
      JOptionPane.showMessageDialog(null,"Your Bill have updated.","CONFIRMATION MESSAGE",JOptionPane.INFORMATION_MESSAGE);


   }
   catch (SQLException sqlException) {
     JOptionPane.showMessageDialog(null, sqlException.getMessage(),"Database error",JOptionPane.ERROR_MESSAGE);
   }
 }





  }

  void jButton3_actionPerformed(ActionEvent e) {
   dispose();
  }

  void jButton4_actionPerformed(ActionEvent e) {
    name.setText("");
    bed_field.setText("");
    cabin_field.setText("");
    ot_field.setText("");
    del_field.setText("");
    pack_field.setText("");
    po_field.setText("");
    nebu_field.setText("");
    oxyzen_field.setText("");
    patho_field.setText("");
    radio_field.setText("");
    ecg_field.setText("");
    urine_field.setText("");
    dressing_field.setText("");
    misc_field.setText("");
    total_field.setText("");
    amount_field.setText("");
    due.setText("");
    advance.setText("");
    discount_field.setText("");

    ward.setSelected(false);
    cabin.setSelected(false);
    gb.setSelected(false);
    pb.setSelected(false);
    String temp[]=new String[1];
    ward_list.setListData(temp);
    bed_list.setListData(temp);
    cabin_list.setListData(temp);
    gb_list.setListData(temp);
    pb_list.setListData(temp);


    bed.setSelected(false);
    cabins.setSelected(false);
    ot.setSelected(false);
    del.setSelected(false);
    pack.setSelected(false);
    po.setSelected(false);
    nebu.setSelected(false);
    oxyzen.setSelected(false);
    patho.setSelected(false);
    radio.setSelected(false);
    ecg.setSelected(false);
    urine.setSelected(false);
    dressing.setSelected(false);
    misc.setSelected(false);
    discount.setSelected(false);

  }
}

class Bill_ward_actionAdapter implements java.awt.event.ActionListener {
  Bill adaptee;

  Bill_ward_actionAdapter(Bill adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.ward_actionPerformed(e);
  }
}

class Bill_cabin_actionAdapter implements java.awt.event.ActionListener {
  Bill adaptee;

  Bill_cabin_actionAdapter(Bill adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.cabin_actionPerformed(e);
  }
}

class Bill_gb_actionAdapter implements java.awt.event.ActionListener {
  Bill adaptee;

  Bill_gb_actionAdapter(Bill adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.gb_actionPerformed(e);
  }
}

class Bill_pb_actionAdapter implements java.awt.event.ActionListener {
  Bill adaptee;

  Bill_pb_actionAdapter(Bill adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.pb_actionPerformed(e);
  }
}

class Bill_bed_actionAdapter implements java.awt.event.ActionListener {
  Bill adaptee;

  Bill_bed_actionAdapter(Bill adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.bed_actionPerformed(e);
  }
}

class Bill_cabins_actionAdapter implements java.awt.event.ActionListener {
  Bill adaptee;

  Bill_cabins_actionAdapter(Bill adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.cabins_actionPerformed(e);
  }
}

class Bill_ot_actionAdapter implements java.awt.event.ActionListener {
  Bill adaptee;

  Bill_ot_actionAdapter(Bill adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.ot_actionPerformed(e);
  }
}

class Bill_del_actionAdapter implements java.awt.event.ActionListener {
  Bill adaptee;

  Bill_del_actionAdapter(Bill adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.del_actionPerformed(e);
  }
}

class Bill_pack_actionAdapter implements java.awt.event.ActionListener {
  Bill adaptee;

  Bill_pack_actionAdapter(Bill adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.pack_actionPerformed(e);
  }
}

class Bill_po_actionAdapter implements java.awt.event.ActionListener {
  Bill adaptee;

  Bill_po_actionAdapter(Bill adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.po_actionPerformed(e);
  }
}

class Bill_nebu_actionAdapter implements java.awt.event.ActionListener {
  Bill adaptee;

  Bill_nebu_actionAdapter(Bill adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.nebu_actionPerformed(e);
  }
}

class Bill_oxyzen_actionAdapter implements java.awt.event.ActionListener {
  Bill adaptee;

  Bill_oxyzen_actionAdapter(Bill adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.oxyzen_actionPerformed(e);
  }
}

class Bill_patho_actionAdapter implements java.awt.event.ActionListener {
  Bill adaptee;

  Bill_patho_actionAdapter(Bill adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.patho_actionPerformed(e);
  }
}

class Bill_radio_actionAdapter implements java.awt.event.ActionListener {
  Bill adaptee;

  Bill_radio_actionAdapter(Bill adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.radio_actionPerformed(e);
  }
}

class Bill_ecg_actionAdapter implements java.awt.event.ActionListener {
  Bill adaptee;

  Bill_ecg_actionAdapter(Bill adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.ecg_actionPerformed(e);
  }
}

class Bill_urine_actionAdapter implements java.awt.event.ActionListener {
  Bill adaptee;

  Bill_urine_actionAdapter(Bill adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.urine_actionPerformed(e);
  }
}

class Bill_dressing_actionAdapter implements java.awt.event.ActionListener {
  Bill adaptee;

  Bill_dressing_actionAdapter(Bill adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.dressing_actionPerformed(e);
  }
}

class Bill_misc_actionAdapter implements java.awt.event.ActionListener {
  Bill adaptee;

  Bill_misc_actionAdapter(Bill adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.misc_actionPerformed(e);
  }
}

class Bill_discount_actionAdapter implements java.awt.event.ActionListener {
  Bill adaptee;

  Bill_discount_actionAdapter(Bill adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.discount_actionPerformed(e);
  }
}

class Bill_jButton1_actionAdapter implements java.awt.event.ActionListener {
  Bill adaptee;

  Bill_jButton1_actionAdapter(Bill adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton1_actionPerformed(e);
  }
}

class Bill_jButton3_actionAdapter implements java.awt.event.ActionListener {
  Bill adaptee;

  Bill_jButton3_actionAdapter(Bill adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton3_actionPerformed(e);
  }
}

class Bill_jButton4_actionAdapter implements java.awt.event.ActionListener {
  Bill adaptee;

  Bill_jButton4_actionAdapter(Bill adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton4_actionPerformed(e);
  }
}
