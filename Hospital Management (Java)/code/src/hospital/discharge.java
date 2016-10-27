package hospital;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.DecimalFormat;
import java.sql.Date;


public class discharge extends JFrame {

  Connection connection;
  private long id = 0,day_diff=0;
  private double madvance=0,grand_final=0;
  private String days="",months="",years="";
  private String final_day="";
  String dat="";

  DecimalFormat two = new DecimalFormat("0.00");




  JPanel jPanel2 = new JPanel();
  JLabel Hospital_name1 = new JLabel();
  JPanel jPanel1 = new JPanel();
  JRadioButton ward = new JRadioButton();
  JRadioButton cabin = new JRadioButton();
  JRadioButton pb = new JRadioButton();
  JRadioButton gb = new JRadioButton();
  JTextField name = new JTextField();
  JFormattedTextField dates = new JFormattedTextField();
  JScrollPane jScrollPane1 = new JScrollPane();
  JScrollPane jScrollPane2 = new JScrollPane();
  JScrollPane jScrollPane3 = new JScrollPane();
  JScrollPane jScrollPane4 = new JScrollPane();
  JScrollPane jScrollPane5 = new JScrollPane();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JPanel jPanel3 = new JPanel();
  JPanel jPanel4 = new JPanel();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JLabel jLabel5 = new JLabel();
  JLabel jLabel6 = new JLabel();
  JLabel jLabel7 = new JLabel();
  JLabel jLabel8 = new JLabel();
  JTextField tot = new JTextField();
  JTextField discount = new JTextField();
  JTextField service = new JTextField();
  JTextField final_total = new JTextField();
  JTextField advance = new JTextField();
  JTextField dues = new JTextField();
  JLabel jLabel9 = new JLabel();
  JTextField pay = new JTextField();
  JPanel jPanel5 = new JPanel();
  JButton pays = new JButton();
  JButton ds_letter = new JButton();
  JList ward_list = new JList();
  JList bed_list = new JList();
  JList cabin_list = new JList();
  JList pb_list = new JList();
  JList gb_list = new JList();
  ButtonGroup group = new ButtonGroup();
  JButton discharge1 = new JButton();
  JTextField ids = new JTextField();
  JLabel jLabel10 = new JLabel();

  public discharge() {
    try {
      jbInit();
      setSize(600,480);
      setLocation(110,80);
      show();

      pays.setEnabled(false);
      ds_letter.setEnabled(false);
      ids.setEditable(false);
      pay.setEnabled(false);
      tot.setEditable(false);
      name.setEditable(false);
      dues.setEditable(false);
      final_total.setEditable(false);
      discount.setEditable(false);
      service.setEditable(false);
      advance.setEditable(false);

      Statement stat;
      ResultSet rset;
      String sql;


      //DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
      //String url = "jdbc:oracle:oci8:@";
      //connection = DriverManager.getConnection(url, "system","manager");
     connection = Main.connection;

      String str = "";
      sql = "select to_char(sysDate,'DD-MM-YYYY') from dual";
      stat = connection.createStatement();
      rset = stat.executeQuery(sql);
      while (rset.next())
        dat = rset.getString(1);
      dates.setText(dat);

      dates.setEditable(false);

          stat.close();


      name.setEditable(false);
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }

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

         while (rset.next()) {
           madvance = Double.parseDouble(rset.getString("advance"));
         }
         ids.setText(String.valueOf(id));
         advance.setText(String.valueOf(two.format(madvance)));
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
         long money=0;
         while (rset.next()) {
           madvance = Double.parseDouble(rset.getString("advance"));
         }

         advance.setText(String.valueOf(two.format(madvance)));

       ids.setText(String.valueOf(id));
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

         long money=0;
         while (rset.next()) {
           madvance = Double.parseDouble(rset.getString("advance"));
         }



         advance.setText(String.valueOf(two.format(madvance)));

     ids.setText(String.valueOf(id));
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


         while (rset.next()) {
           madvance = Double.parseDouble(rset.getString("advance"));
         }

        advance.setText(String.valueOf(two.format(madvance)));
      ids.setText(String.valueOf(id));
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







  }

  void jbInit() throws Exception {
    jPanel2.setBackground(new Color(173, 201, 139));
    jPanel2.setEnabled(true);
    jPanel2.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel2.setBounds(new Rectangle(7, 8, 585, 55));
    jPanel2.setLayout(null);
    this.getContentPane().setBackground(new Color(173, 201, 139));
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setResizable(false);
    this.setTitle("DISCHARGE ");
    this.getContentPane().setLayout(null);
    Hospital_name1.setBounds(new Rectangle(21, 12, 537, 28));
    Hospital_name1.setText("JALALABAD RAGIB-RABEYA MEDICAL COLLEGE HOSPITAL");
    Hospital_name1.setForeground(SystemColor.desktop);
    Hospital_name1.setFont(new java.awt.Font("Dialog", 1, 18));
    jPanel1.setBackground(new Color(173, 201, 139));
    jPanel1.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel1.setBounds(new Rectangle(3, 71, 590, 151));
    jPanel1.setLayout(null);
    ward.setBackground(new Color(173, 201, 139));
    ward.setFont(new java.awt.Font("Dialog", 1, 12));
    ward.setText("WARD");
    ward.setBounds(new Rectangle(5, 43, 65, 22));
    ward.addActionListener(new discharge_ward_actionAdapter(this));
    cabin.setBackground(new Color(173, 201, 139));
    cabin.setFont(new java.awt.Font("Dialog", 1, 12));
    cabin.setText("CABIN");
    cabin.setBounds(new Rectangle(6, 72, 86, 20));
    cabin.addActionListener(new discharge_cabin_actionAdapter(this));
    pb.setBackground(new Color(173, 201, 139));
    pb.setFont(new java.awt.Font("Dialog", 1, 12));
    pb.setText("PAYING BED");
    pb.setBounds(new Rectangle(231, 39, 96, 24));
    pb.addActionListener(new discharge_pb_actionAdapter(this));
    gb.setBackground(new Color(173, 201, 139));
    gb.setFont(new java.awt.Font("Dialog", 1, 12));
    gb.setText("GENERAL BED");
    gb.setBounds(new Rectangle(232, 65, 118, 31));
    gb.addActionListener(new discharge_gb_actionAdapter(this));
    name.setBackground(SystemColor.textHighlightText);
    name.setFont(new java.awt.Font("Dialog", 1, 12));
    name.setDisabledTextColor(SystemColor.activeCaption);
    name.setText("");
    name.setBounds(new Rectangle(94, 107, 159, 27));
    dates.setBackground(SystemColor.textHighlightText);
    dates.setDisabledTextColor(SystemColor.activeCaption);
    dates.setEditable(false);
    dates.setFont(new java.awt.Font("SansSerif", 1, 12));
    dates.setForeground(SystemColor.activeCaption);
    dates.setText("");
    dates.setBounds(new Rectangle(428, 7, 119, 25));
    jScrollPane1.setBounds(new Rectangle(94, 44, 53, 22));
    jScrollPane2.setBounds(new Rectangle(156, 43, 51, 24));
    jScrollPane3.setBounds(new Rectangle(95, 73, 52, 21));
    jScrollPane4.setBounds(new Rectangle(368, 40, 52, 21));
    jScrollPane5.setBounds(new Rectangle(369, 66, 52, 21));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1.setText("NAME");
    jLabel1.setBounds(new Rectangle(16, 110, 60, 24));
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel2.setText("DATE");
    jLabel2.setBounds(new Rectangle(368, 9, 50, 22));
    jPanel3.setBackground(new Color(173, 201, 139));
    jPanel3.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel3.setBounds(new Rectangle(6, 238, 291, 126));
    jPanel3.setLayout(null);
    jPanel4.setLayout(null);
    jPanel4.setBounds(new Rectangle(305, 238, 290, 126));
    jPanel4.setBackground(new Color(173, 201, 139));
    jPanel4.setBorder(BorderFactory.createLoweredBevelBorder());
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel3.setText("TOTAL");
    jLabel3.setBounds(new Rectangle(12, 16, 59, 23));
    jLabel4.setBounds(new Rectangle(11, 42, 59, 23));
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel4.setText("DISCOUNT");
    jLabel5.setBounds(new Rectangle(11, 68, 130, 23));
    jLabel5.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel5.setText("SEVICE CHARGE(10%)");
    jLabel6.setBounds(new Rectangle(11, 91, 87, 23));
    jLabel6.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel6.setText("GRAND TOTAL");
    jLabel7.setBounds(new Rectangle(19, 14, 108, 23));
    jLabel7.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel7.setText("ADVANCE PAID");
    jLabel8.setBounds(new Rectangle(17, 43, 59, 23));
    jLabel8.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel8.setText("DUE");
    tot.setBackground(SystemColor.textHighlightText);
    tot.setFont(new java.awt.Font("Dialog", 1, 12));
    tot.setText("");
    tot.setBounds(new Rectangle(189, 14, 90, 20));
    discount.setBackground(SystemColor.textHighlightText);
    discount.setFont(new java.awt.Font("Dialog", 1, 12));
    discount.setCaretColor(SystemColor.textHighlightText);
    discount.setText("");
    discount.setBounds(new Rectangle(189, 41, 90, 20));
    service.setBackground(SystemColor.textHighlightText);
    service.setFont(new java.awt.Font("Dialog", 1, 12));
    service.setText("");
    service.setBounds(new Rectangle(189, 68, 90, 20));
    final_total.setBackground(SystemColor.textHighlightText);
    final_total.setFont(new java.awt.Font("Dialog", 1, 12));
    final_total.setText("");
    final_total.setBounds(new Rectangle(190, 92, 90, 20));
    advance.setBackground(SystemColor.textHighlightText);
    advance.setFont(new java.awt.Font("Dialog", 1, 12));
    advance.setSelectedTextColor(SystemColor.textHighlightText);
    advance.setText("");
    advance.setBounds(new Rectangle(152, 18, 127, 20));
    dues.setBackground(SystemColor.textHighlightText);
    dues.setFont(new java.awt.Font("Dialog", 1, 12));
    dues.setSelectedTextColor(SystemColor.textHighlightText);
    dues.setText("");
    dues.setHorizontalAlignment(SwingConstants.LEFT);
    dues.setBounds(new Rectangle(153, 46, 127, 20));
    jLabel9.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel9.setText("PAY");
    jLabel9.setBounds(new Rectangle(16, 75, 45, 23));
    pay.setBackground(SystemColor.textHighlightText);
    pay.setFont(new java.awt.Font("Dialog", 1, 12));
    pay.setSelectedTextColor(SystemColor.textHighlightText);
    pay.setBounds(new Rectangle(154, 76, 127, 20));
    jPanel5.setBackground(new Color(173, 201, 139));
    jPanel5.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel5.setBounds(new Rectangle(8, 375, 589, 55));
    jPanel5.setLayout(null);
    pays.setBackground(new Color(173, 201, 139));
    pays.setBounds(new Rectangle(196, 11, 101, 28));
    pays.setFont(new java.awt.Font("Dialog", 1, 12));
    pays.setBorder(BorderFactory.createRaisedBevelBorder());
    pays.setMnemonic('D');
    pays.setText("PAY");
    pays.addActionListener(new discharge_discharge_actionAdapter(this));
    ds_letter.setBackground(new Color(173, 201, 139));
    ds_letter.setBounds(new Rectangle(324, 12, 164, 28));
    ds_letter.setFont(new java.awt.Font("Dialog", 1, 12));
    ds_letter.setBorder(BorderFactory.createRaisedBevelBorder());
    ds_letter.setMnemonic('L');
    ds_letter.setText("DISCHARGE");
    ds_letter.addActionListener(new discharge_ds_letter_actionAdapter(this));
    discharge1.setText("SHOW BILL");
    discharge1.addActionListener(new discharge_discharge1_actionAdapter(this));
    discharge1.setMnemonic('D');
    discharge1.setBorder(BorderFactory.createRaisedBevelBorder());
    discharge1.setFont(new java.awt.Font("Dialog", 1, 12));
    discharge1.setBackground(new Color(173, 201, 139));
    discharge1.setBounds(new Rectangle(59, 11, 101, 28));
    ids.setBackground(SystemColor.textHighlightText);
    ids.setFont(new java.awt.Font("Dialog", 1, 12));
    ids.setForeground(SystemColor.activeCaption);
    ids.setDisabledTextColor(SystemColor.activeCaption);
    ids.setBounds(new Rectangle(365, 107, 123, 25));
    jLabel10.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel10.setText("ID");
    jLabel10.setBounds(new Rectangle(335, 106, 24, 24));
    ward_list.setFont(new java.awt.Font("Dialog", 1, 12));
    bed_list.setFont(new java.awt.Font("Dialog", 1, 12));
    cabin_list.setFont(new java.awt.Font("Dialog", 1, 12));
    gb_list.setFont(new java.awt.Font("Dialog", 1, 12));
    pb_list.setFont(new java.awt.Font("Dialog", 1, 12));
    jPanel2.add(Hospital_name1, null);
    this.getContentPane().add(jPanel3, null);
    jPanel3.add(jLabel3, null);
    jPanel3.add(jLabel4, null);
    jPanel3.add(jLabel5, null);
    jPanel3.add(jLabel6, null);
    jPanel3.add(tot, null);
    jPanel3.add(discount, null);
    jPanel3.add(service, null);
    jPanel3.add(final_total, null);
    this.getContentPane().add(jPanel4, null);
    jPanel4.add(jLabel7, null);
    jPanel4.add(advance, null);
    jPanel4.add(dues, null);
    jPanel4.add(jLabel8, null);
    jPanel4.add(jLabel9, null);
    jPanel4.add(pay, null);
    this.getContentPane().add(jPanel5, null);
    jPanel5.add(ds_letter, null);
    jPanel5.add(pays, null);
    jPanel5.add(discharge1, null);
    this.getContentPane().add(jPanel1, null);
    jPanel1.add(ward, null);
    jPanel1.add(cabin, null);
    jPanel1.add(pb, null);
    jPanel1.add(gb, null);
    jPanel1.add(jScrollPane2, null);
    jScrollPane2.getViewport().add(bed_list, null);
    jPanel1.add(jScrollPane1, null);
    jScrollPane1.getViewport().add(ward_list, null);
    jPanel1.add(jScrollPane3, null);
    jScrollPane3.getViewport().add(cabin_list, null);
    jPanel1.add(jScrollPane4, null);
    jScrollPane4.getViewport().add(pb_list, null);
    jPanel1.add(jScrollPane5, null);
    jScrollPane5.getViewport().add(gb_list, null);
    jPanel1.add(name, null);
    jPanel1.add(jLabel1, null);
    jPanel1.add(dates, null);
    jPanel1.add(jLabel2, null);
    jPanel1.add(ids, null);
    jPanel1.add(jLabel10, null);
    this.getContentPane().add(jPanel2, null);

    group.add(ward);
    group.add(cabin);
    group.add(gb);
    group.add(pb);


  }

  public static void main(String[] args) {
    discharge discharge = new discharge();
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

    tot.setText("");
    discount.setText("");
    service.setText("");
    final_total.setText("");
    advance.setText("");
    dues.setText("");
    pays.setEnabled(false);
    ds_letter.setEnabled(false);


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

   tot.setText("");
   discount.setText("");
   service.setText("");
   final_total.setText("");
   advance.setText("");
   dues.setText("");
   pays.setEnabled(false);
   ds_letter.setEnabled(false);


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

    tot.setText("");
   discount.setText("");
   service.setText("");
   final_total.setText("");
   advance.setText("");
   dues.setText("");
   pays.setEnabled(false);
   ds_letter.setEnabled(false);


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

    tot.setText("");
   discount.setText("");
   service.setText("");
   final_total.setText("");
   advance.setText("");
   dues.setText("");
   pays.setEnabled(false);
   ds_letter.setEnabled(false);


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
     pb_list.setListData(pbs);

     stat.close();

     rset.close();
   }
   catch (SQLException sqlException) {
     JOptionPane.showMessageDialog(null, sqlException.getMessage(),
                                   "Database error", JOptionPane.ERROR_MESSAGE);
   }


  }

  void discharge1_actionPerformed(ActionEvent e) {

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
    double mtotal=0,mdiscount=0,mfinal_amount=0,mdue=0;


    sql = "select bed,cabin from bill_1 where patient_id = "+id+" " ;
    stat = connection.createStatement();
    rset = stat.executeQuery(sql);
    while (rset.next()) {
      mbed = Double.parseDouble(rset.getString("bed"));
      mcabin = Double.parseDouble(rset.getString("cabin"));
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

   ///////////////////////////////////taking system date
    String sql1 = "select to_char(sysdate,'DD') from dual";
    String sql2 = "select to_char(sysdate,'MON') from dual";
    String sql3 = "select to_char(sysdate,'YYYY') from dual";
    stat = connection.createStatement();
    rset = stat.executeQuery(sql1);
    while (rset.next()) {
     days = rset.getString(1);
   }
   stat = connection.createStatement();
    rset = stat.executeQuery(sql2);
    while (rset.next()) {
     months = rset.getString(1);
   }

     stat = connection.createStatement();
       rset = stat.executeQuery(sql3);
       while (rset.next()) {
        years = rset.getString(1);
      }


      final_day = days + "-"+months +"-" + years;
      //System.out.println(final_day);

       sql1 = "select ceil (sysDate - dat) from  patient_adm_date where patient_id="+id+" ";
       stat = connection.createStatement();
       rset = stat.executeQuery(sql1);
      while (rset.next()) {
       day_diff = Integer.parseInt(rset.getString(1));
     }
     //System.out.println(day_diff);

     if(ward.isSelected() || gb.isSelected() || pb.isSelected())
     {
        double bed_bill = day_diff*150;
        bed_bill = bed_bill - mbed;
        if(bed_bill>0)
          mtotal += bed_bill;
     }

     if(cabin.isSelected())
     {
        double cabin_bill = day_diff*350;
        cabin_bill = cabin_bill - mcabin;
        if(cabin_bill>0)
          mtotal += cabin_bill;
     }

     tot.setText(String.valueOf(two.format(mtotal)));
     discount.setText(String.valueOf(two.format(mdiscount)));
     mtotal = mtotal - mdiscount;

     double  dis = (mtotal*10)/100;
     two.format(dis);
     service.setText(String.valueOf(two.format(dis)));
     grand_final = mtotal + dis;

     final_total.setText(String.valueOf(two.format(grand_final)));
     double due = grand_final - madvance;
     advance.setText(String.valueOf(two.format(madvance)));
     dues.setText(String.valueOf(two.format(due)));

     //System.out.println(due);

     if(due>0)
      {
        pay.setEditable(true);
        pay.setEnabled(true);
        pays.setEnabled(true);

      }
    else
    {
        ds_letter.setEnabled(true);
        pay.setEditable(false);

    }







  ////////////////////////////////////////////////////////






              stat.close();

              rset.close();

  }
  catch (SQLException sqlException) {
    JOptionPane.showMessageDialog(null, sqlException.getMessage(),"Database error",JOptionPane.ERROR_MESSAGE);
  }
}






  }

  void discharge_actionPerformed(ActionEvent e) {

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
     else if(pay.getText().equals(""))
       JOptionPane.showMessageDialog(null, "Pls Pay the Bill", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);



     else{


       double pay_bill = Double.parseDouble(pay.getText());
       double due_bill = Double.parseDouble(dues.getText());



       try {

         Statement stat;
         ResultSet rset;
         String sql = "";

         double new_money = Double.parseDouble(pay.getText());
         madvance = madvance + new_money;
         stat = connection.createStatement();
         sql = "delete from bill_advance where patient_id = " + id + "";
         boolean insertResult = stat.execute(sql);
         stat.close();



         stat = connection.createStatement();
         sql = "insert into bill_advance values(" + id + "," + madvance + ")";
         boolean insertResult1 = stat.execute(sql);
         stat.close();


        if(pay_bill>=due_bill)
        {
          pay.setEnabled(false);
          ds_letter.setEnabled(true);
        }

        two.format(madvance);
        advance.setText(String.valueOf(two.format(madvance)));

        ///////updating income//////

        double income1 = 0,income=0,pays,due;
        pays = Double.parseDouble(pay.getText());
        due = Double.parseDouble(dues.getText());
      // if(pays>=due)
      //          income1 = due;
       //else  income1 = pays;
       income1=pays;


        double indoor = 0;
        int outdoor = 0;
        String temp1="";
        sql = "select indoor,outdoor from income where dates = '" + dat + "' ";
        stat = connection.createStatement();
        rset = stat.executeQuery(sql);
        while (rset.next()) {
          indoor = Integer.parseInt(rset.getString("indoor"));
          outdoor = Integer.parseInt(rset.getString("outdoor"));
          temp1+=indoor;
        }
        //System.out.println(indoor);
        if (temp1.equals("")) {
          indoor = income1;
          stat = connection.createStatement();
          sql = "insert into income values('" + dat + "'," + indoor + "," +
              outdoor + ")";
          insertResult = stat.execute(sql);
          stat.close();
        }
        else {
          indoor = indoor + income1;
          stat = connection.createStatement();
          sql = "update income set indoor=" + indoor + " where dates='" + dat +
              "'";
          insertResult = stat.execute(sql);
          stat.close();

        }

        pay.setText("");
//////////////////////////





        dues.setText(String.valueOf(two.format(grand_final-madvance)));




       }
       catch (SQLException sqlException) {
         JOptionPane.showMessageDialog(null, sqlException.getMessage(),
                                       "Database error",
                                       JOptionPane.ERROR_MESSAGE);
       }
     }





  }

  void ds_letter_actionPerformed(ActionEvent e) {

    try {

       Statement stat;
       ResultSet rset;
       String sql = "";
       boolean insertResult1,insertResult2,insertResult3,insertResult4;

       String name="",sex="",date1="",date2="";
       int age=0;

       sql = "select patient_name,patient_age,patient_sex from patient_names_age where patient_id = "+id+" ";

       stat = connection.createStatement();
       rset = stat.executeQuery(sql);
         while (rset.next()) {
          name = rset.getString("patient_name");
          age = Integer.parseInt(rset.getString("patient_age"));
          sex = rset.getString("patient_sex");
      }

      ///////////////////////////////////taking system date
      String sql1 = "select to_char(dat,'DD') from patient_adm_date where patient_id = "+id +" ";
      String sql2 = "select to_char(dat,'MON') from patient_adm_date where patient_id = "+id +" ";
      String sql3 = "select to_char(dat,'YYYY') from patient_adm_date where patient_id = "+id +" ";
      stat = connection.createStatement();
      rset = stat.executeQuery(sql1);
      while (rset.next()) {
        days = rset.getString(1);
      }
      stat = connection.createStatement();
      rset = stat.executeQuery(sql2);
      while (rset.next()) {
        months = rset.getString(1);
      }
      stat = connection.createStatement();
      rset = stat.executeQuery(sql3);
      while (rset.next()) {
        years = rset.getString(1);
      }

      date1 = days + "-" + months + "-" + years;
      date2 = final_day;
      //    System.out.println(date1);
      //   System.out.println(date2);

       stat = connection.createStatement();
       sql = " insert into old_patient_info values("+id+",'"+name+"',"+age+",'"+sex+"','"+date1+"','"+date2+"') ";
       insertResult1 = stat.execute(sql);
       stat.close();



       long in_id=0,out_id=0;
       String sql4 = "select indoor_id,outdoor_id from id_print";
       stat = connection.createStatement();
       rset = stat.executeQuery(sql4);
       while (rset.next()) {
        in_id  = Integer.parseInt(rset.getString("indoor_id"));
        out_id = Integer.parseInt(rset.getString("outdoor_id"));
      }

       stat = connection.createStatement();
       sql = "delete from id_print" ;
       insertResult3 = stat.execute(sql);
       stat.close();

       stat = connection.createStatement();
       sql = "insert into id_print values("+id+","+out_id+")" ;
       insertResult3 = stat.execute(sql);
       stat.close();


       ///////updating income//////

       double due;
       due = Double.parseDouble(dues.getText());


       double indoor = 0;
       int outdoor = 0;
       String temp2="";
       sql = "select indoor,outdoor from income where dates = '" + dat + "' ";
       stat = connection.createStatement();
       rset = stat.executeQuery(sql);
       while (rset.next()) {
         indoor = Integer.parseInt(rset.getString("indoor"));
         outdoor = Integer.parseInt(rset.getString("outdoor"));
         temp2+=indoor;
       }
       //System.out.println(indoor);
       if (temp2.equals("")) {
         indoor = due;
         stat = connection.createStatement();
         sql = "insert into income values('" + dat + "'," + indoor + "," +
             outdoor + ")";
         insertResult1 = stat.execute(sql);
         stat.close();
       }
       else {
         indoor = indoor + due;
         stat = connection.createStatement();
         sql = "update income set indoor=" + indoor + " where dates='" + dat +
             "'";
         insertResult1 = stat.execute(sql);
         stat.close();

       }

 //////////////////////////



       JOptionPane.showMessageDialog(null,"The Patient is Discharged.","CONFIRMATION MESSAGE",JOptionPane.INFORMATION_MESSAGE);


       dispose();
       new discharge_letter();





     }
     catch (SQLException sqlException) {
       JOptionPane.showMessageDialog(null, sqlException.getMessage(),
                                     "Database error",
                                     JOptionPane.ERROR_MESSAGE);
     }











  }
}

class discharge_ward_actionAdapter implements java.awt.event.ActionListener {
  discharge adaptee;

  discharge_ward_actionAdapter(discharge adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.ward_actionPerformed(e);
  }
}

class discharge_cabin_actionAdapter implements java.awt.event.ActionListener {
  discharge adaptee;

  discharge_cabin_actionAdapter(discharge adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.cabin_actionPerformed(e);
  }
}

class discharge_gb_actionAdapter implements java.awt.event.ActionListener {
  discharge adaptee;

  discharge_gb_actionAdapter(discharge adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.gb_actionPerformed(e);
  }
}

class discharge_pb_actionAdapter implements java.awt.event.ActionListener {
  discharge adaptee;

  discharge_pb_actionAdapter(discharge adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.pb_actionPerformed(e);
  }
}

class discharge_discharge1_actionAdapter implements java.awt.event.ActionListener {
  discharge adaptee;

  discharge_discharge1_actionAdapter(discharge adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.discharge1_actionPerformed(e);
  }
}

class discharge_discharge_actionAdapter implements java.awt.event.ActionListener {
  discharge adaptee;

  discharge_discharge_actionAdapter(discharge adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.discharge_actionPerformed(e);
  }
}

class discharge_ds_letter_actionAdapter implements java.awt.event.ActionListener {
  discharge adaptee;

  discharge_ds_letter_actionAdapter(discharge adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.ds_letter_actionPerformed(e);
  }
}
