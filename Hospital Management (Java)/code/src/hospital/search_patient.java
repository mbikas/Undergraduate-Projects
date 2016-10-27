package hospital;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import com.borland.dx.sql.dataset.*;
import com.borland.dbswing.*;
import com.borland.dx.sql.dataset.ConnectionDescriptor;
import java.awt.event.*;
import java.awt.print.Printable;
import java.awt.print.PageFormat;
import java.awt.print.PrinterJob;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;





public class search_patient extends JFrame {

  Connection connection;
  String str1,str2,str3,str4,str5,str6,str7,str8,str9,str10;
  Database database1 = new Database();
  QueryDataSet queryDataSet1 = new QueryDataSet();

   PrinterJob job;
   String sql="",info="";
   String str[] = new String[100];

  JButton jButton2 = new JButton();
  JPanel jPanel4 = new JPanel();
  JLabel jLabel1 = new JLabel();
  JPanel jPanel3 = new JPanel();
  JPanel jPanel1 = new JPanel();
  JLabel jLabel2 = new JLabel();
  JButton search = new JButton();
  JLabel Hospital_name = new JLabel();
  JPanel jPanel2 = new JPanel();
  JButton jButton3 = new JButton();
  JPanel jPanel5 = new JPanel();
  JRadioButton ward = new JRadioButton();
  JRadioButton cabin = new JRadioButton();
  JRadioButton gb = new JRadioButton();
  JRadioButton pb = new JRadioButton();
  JTextField name_text = new JTextField();
  ButtonGroup group1 = new ButtonGroup();
  ButtonGroup group2 = new ButtonGroup();
  JScrollPane jScrollPane2 = new JScrollPane();
  JScrollPane jScrollPane3 = new JScrollPane();
  JScrollPane jScrollPane4 = new JScrollPane();
  JScrollPane jScrollPane5 = new JScrollPane();
  JScrollPane jScrollPane6 = new JScrollPane();
  JLabel jLabel3 = new JLabel();
  JList ward_list = new JList();
  JList cabin_list = new JList();
  JList gb_list = new JList();
  JList pb_list = new JList();
  JList bed_list = new JList();
  JRadioButton name = new JRadioButton();
  JLabel Hospital_name1 = new JLabel();
  TableScrollPane tableScrollPane1 = new TableScrollPane();
  JdbTable jdbTable1 = new JdbTable();
  JButton print = new JButton();
  JButton preview = new JButton();

  public search_patient() {
    try {
      jbInit();
      setSize(630, 510);
      setLocation(100,50);
      show();

      connection = Main.connection;



      name_text.setEnabled(false);
      jdbTable1.setVisible(false);
      print.setEnabled(false);
      preview.setEnabled(false);

    }
    catch (Exception ex) {
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

  }

  void jbInit() throws Exception {
    jPanel4.setLayout(null);
    jPanel4.setBounds(new Rectangle(9, 215, 612, 186));
    jPanel4.setBackground(new Color(173, 201, 139));
    jPanel4.setBorder(BorderFactory.createLoweredBevelBorder());
    jButton2.setText("CLEAR");
    jButton2.addActionListener(new search_patient_jButton2_actionAdapter(this));
    jButton2.setMnemonic('C');
    jButton2.setFont(new java.awt.Font("Dialog", 1, 12));
    jButton2.setBorder(BorderFactory.createRaisedBevelBorder());
    jButton2.setBackground(new Color(173, 201, 139));
    jButton2.setBounds(new Rectangle(170, 17, 75, 25));
    this.getContentPane().setLayout(null);
    jLabel1.setFont(new java.awt.Font("Book Antiqua", 1, 14));
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("Search  Patient");
    jLabel1.setBounds(new Rectangle(169, 4, 218, 25));
    jPanel3.setBackground(new Color(173, 201, 139));
    jPanel3.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel3.setBounds(new Rectangle(8, 74, 608, 35));
    jPanel3.setLayout(null);
    jPanel1.setBackground(new Color(173, 201, 139));
    jPanel1.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel1.setBounds(new Rectangle(8, 5, 606, 62));
    jPanel1.setLayout(null);
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel2.setText("INFORMATION");
    jLabel2.setBounds(new Rectangle(226, 5, 98, 20));
    search.setBackground(new Color(173, 201, 139));
    search.setBounds(new Rectangle(55, 16, 72, 26));
    search.setFont(new java.awt.Font("Dialog", 1, 12));
    search.setBorder(BorderFactory.createRaisedBevelBorder());
    search.setMnemonic('S');
    search.setText("SEARCH");
    search.addActionListener(new search_patient_search_actionAdapter(this));

    jPanel2.setBackground(new Color(173, 201, 139));
    jPanel2.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel2.setBounds(new Rectangle(8, 117, 610, 95));
    jPanel2.setLayout(null);
    jButton3.setBackground(new Color(173, 201, 139));
    jButton3.setBounds(new Rectangle(483, 17, 66, 27));
    jButton3.setFont(new java.awt.Font("Dialog", 1, 12));
    jButton3.setBorder(BorderFactory.createRaisedBevelBorder());
    jButton3.setMnemonic('L');
    jButton3.setText("CLOSE");
    jButton3.addActionListener(new search_patient_jButton3_actionAdapter(this));
    jPanel5.setBackground(new Color(173, 201, 139));
    jPanel5.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel5.setBounds(new Rectangle(8, 411, 613, 62));
    jPanel5.setLayout(null);
    ward.setBackground(new Color(173, 201, 139));
    ward.setFont(new java.awt.Font("Dialog", 1, 11));
    ward.setText("WARD NO:");
    ward.setBounds(new Rectangle(5, 50, 86, 21));
    ward.addActionListener(new search_patient_ward_actionAdapter(this));
    cabin.setBounds(new Rectangle(301, 8, 88, 21));
    cabin.addActionListener(new search_patient_cabin_actionAdapter(this));
    cabin.setBackground(new Color(173, 201, 139));
    cabin.setFont(new java.awt.Font("Dialog", 1, 11));
    cabin.setText("CABIN NO");
    this.getContentPane().setBackground(new Color(173, 201, 139));
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setResizable(false);
    this.setTitle("SEARCH PATIENT");
    gb.setBounds(new Rectangle(303, 33, 109, 21));
    gb.addActionListener(new search_patient_gb_actionAdapter(this));
    gb.setBackground(new Color(173, 201, 139));
    gb.setFont(new java.awt.Font("Dialog", 1, 11));
    gb.setText("GENERAL BED:");
    pb.setBounds(new Rectangle(303, 61, 95, 21));
    pb.addActionListener(new search_patient_pb_actionAdapter(this));
    pb.setBackground(new Color(173, 201, 139));
    pb.setFont(new java.awt.Font("Dialog", 1, 11));
    pb.setText("PAYING BED:");
    name_text.setBackground(SystemColor.textHighlightText);
    name_text.setFont(new java.awt.Font("Dialog", 1, 12));
    name_text.setText("");
    name_text.setBounds(new Rectangle(101, 8, 148, 25));
    jScrollPane2.setBounds(new Rectangle(432, 7, 75, 23));
    jScrollPane3.setBounds(new Rectangle(432, 33, 76, 22));
    jScrollPane4.setBounds(new Rectangle(433, 59, 76, 22));
    jScrollPane5.setBounds(new Rectangle(101, 46, 76, 26));
    jScrollPane6.setBounds(new Rectangle(183, 45, 68, 28));
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel3.setText("BED");
    jLabel3.setBounds(new Rectangle(200, 31, 46, 15));
    name.setBackground(new Color(173, 201, 139));
    name.setFont(new java.awt.Font("Dialog", 1, 12));
    name.setText("NAME");
    name.setBounds(new Rectangle(2, 4, 84, 28));
    name.addActionListener(new search_patient_name_actionAdapter(this));
    Hospital_name1.setFont(new java.awt.Font("Dialog", 1, 18));
    Hospital_name1.setForeground(SystemColor.desktop);
    Hospital_name1.setText("JALALABAD RAGIB-RABEYA MEDICAL COLLEGE HOSPITAL");
    Hospital_name1.setBounds(new Rectangle(16, 14, 552, 28));
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
    tableScrollPane1.getViewport().setBackground(new Color(173, 201, 139));
    tableScrollPane1.setBounds(new Rectangle(6, 27, 598, 153));
    print.setText("PRINT");
    print.addActionListener(new search_patient_print_actionAdapter(this));
    print.setMnemonic('L');
    print.setBorder(BorderFactory.createRaisedBevelBorder());
    print.setFont(new java.awt.Font("Dialog", 1, 12));
    print.setBounds(new Rectangle(387, 18, 66, 27));
    print.setBackground(new Color(173, 201, 139));
    preview.setText("PRINT PREVIEW");
    preview.addActionListener(new search_patient_preview_actionAdapter(this));
    preview.setMnemonic('L');
    preview.setBorder(BorderFactory.createRaisedBevelBorder());
    preview.setFont(new java.awt.Font("Dialog", 1, 12));
    preview.setBounds(new Rectangle(267, 17, 109, 27));
    preview.setBackground(new Color(173, 201, 139));
    jPanel4.add(tableScrollPane1, null);
    tableScrollPane1.getViewport().add(jdbTable1, null);
    jPanel4.add(jLabel2, null);
    this.getContentPane().add(jPanel5, null);
    jPanel5.add(search, null);
    jPanel5.add(jButton2, null);
    jPanel5.add(jButton3, null);
    jPanel5.add(print, null);
    jPanel5.add(preview, null);
    this.getContentPane().add(jPanel1, null);
    jPanel1.add(Hospital_name, null);
    jPanel1.add(Hospital_name1, null);
    this.getContentPane().add(jPanel3, null);
    jPanel3.add(jLabel1, null);
    this.getContentPane().add(jPanel2, null);
    jPanel2.add(name_text, null);
    jPanel2.add(name, null);
    jPanel2.add(ward, null);
    jPanel2.add(jScrollPane5, null);
    jPanel2.add(jScrollPane6, null);
    jScrollPane6.getViewport().add(bed_list, null);
    jPanel2.add(jLabel3, null);
    jPanel2.add(cabin, null);
    jPanel2.add(jScrollPane3, null);
    jScrollPane3.getViewport().add(gb_list, null);
    jPanel2.add(jScrollPane2, null);
    jScrollPane2.getViewport().add(cabin_list, null);
    jPanel2.add(jScrollPane4, null);
    jScrollPane4.getViewport().add(pb_list, null);
    jPanel2.add(pb, null);
    jPanel2.add(gb, null);
    this.getContentPane().add(jPanel4, null);
    jScrollPane5.getViewport().add(ward_list, null);
    group1.add(ward);
    group1.add(cabin);
    group1.add(gb);
    group1.add(pb);
    group1.add(name);

  }

  public static void main(String[] args) {
    search_patient search_patient = new search_patient();
  }


  ////////////////////for print////////////

  public class Test implements Printable{


 public int print(Graphics g, PageFormat pageFormat, int pageIndex) {
   if (pageIndex >= 1)
       return Printable.NO_SUCH_PAGE;




            g.drawString(str1,100,100);
            g.drawString(str2,100,120);
            g.drawString(str3,100,140);
            g.drawString(str4,100,160);
            g.drawString(str5,100,180);
            g.drawString(str6,100,200);
            g.drawString(str7,100,220);
            g.drawString(str8,100,240);
            g.drawString(str9,100,260);





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





  //////////////////////////////////////////








  void ward_actionPerformed(ActionEvent e) {
    print.setEnabled(false);
   preview.setEnabled(false);
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
    name_text.setText("");
    name_text.setEnabled(false);
    jdbTable1.setVisible(false);


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

    print.setEnabled(false);
   preview.setEnabled(false);

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
    name_text.setText("");
    name_text.setEnabled(false);
    jdbTable1.setVisible(false);

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
   preview.setEnabled(false);

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
    name_text.setText("");
    name_text.setEnabled(false);
    jdbTable1.setVisible(false);

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
      gb_list.setListData(gbs);

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
   preview.setEnabled(false);

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
    name_text.setText("");
    name_text.setEnabled(false);
    jdbTable1.setVisible(false);

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
      {
        pbs[i] = str[i];
        System.out.println(str[i]);
      }


      stat.close();
      rset.close();
    }
    catch (SQLException sqlException) {
      JOptionPane.showMessageDialog(null, sqlException.getMessage(),
                                    "Database error", JOptionPane.ERROR_MESSAGE);
    }

  }

  void search_actionPerformed(ActionEvent e) {

    if(!ward.isSelected() &&  !cabin.isSelected() && !gb.isSelected() &&  !pb.isSelected() &&  !name.isSelected())
      JOptionPane.showMessageDialog(null,"Select a catagory","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);

    else if(name.isSelected() && name_text.getText().equals(""))
      JOptionPane.showMessageDialog(null,"Insert Patient Name","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
    else if(cabin.isSelected() && cabin_list.isSelectionEmpty())
     JOptionPane.showMessageDialog(null,"Insert a Cabin Number","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
    else if(gb.isSelected() && gb_list.isSelectionEmpty())
     JOptionPane.showMessageDialog(null,"Insert a General Bed Number","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
    else if(pb.isSelected() && pb_list.isSelectionEmpty())
        JOptionPane.showMessageDialog(null,"Insert a Paying Bed Number","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
    else if(ward.isSelected() && ward_list.isSelectionEmpty())
           JOptionPane.showMessageDialog(null,"Insert a Ward Number","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
    else if(ward.isSelected() && !ward_list.isSelectionEmpty() && bed_list.isSelectionEmpty())
                JOptionPane.showMessageDialog(null,"Insert a Bed Number","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);


     else{




         if (name.isSelected() )
           sql = "Select patient_names_age.patient_name,patient_names_age.patient_age,patient_names_age.patient_sex,  "+
                " patient_relative_dept_doc.disease,patient_relative_dept_doc.doc,patient_relative_dept_doc.dept, "+
              " present_add,contact,to_char(dat,'DD-MM-YYYY') as admission_date  from  patient_names_age,  "+
              " patient_relative_dept_doc,patient_adm_date ,patient_address  "+
              " where  patient_names_age.patient_id = "+
              " (select patient_names_age.patient_id from patient_names_age where lower(patient_name) like lower('"+name_text.getText()+"%') "+
              " And patient_names_age.patient_id = patient_relative_dept_doc.patient_id "+
              " AND patient_names_age.patient_id = patient_adm_date.patient_id "+
               " AND patient_names_age.patient_id = patient_address.patient_id) ";



         else if (cabin.isSelected() )
           sql = "Select patient_names_age.patient_name,patient_names_age.patient_age,patient_names_age.patient_sex, " +
               "patient_relative_dept_doc.disease,patient_relative_dept_doc.doc,patient_relative_dept_doc.dept, " +
               "present_add,contact,to_char(dat,'DD-MM-YYYY') as admission_date from  patient_names_age, " +
               "patient_relative_dept_doc,patient_adm_date,patient_address " +
               "where  patient_names_age.patient_id = " +
               "(select patient_seat.patient_id from patient_seat where cabin =" +cabin_list.getSelectedValue() + " " +
               "And patient_names_age.patient_id = patient_relative_dept_doc.patient_id " +
               "AND patient_names_age.patient_id = patient_adm_date.patient_id "+
               "AND patient_names_age.patient_id = patient_address.patient_id)";

         else if (gb.isSelected())
           sql = "Select patient_names_age.patient_name,patient_names_age.patient_age,patient_names_age.patient_sex, " +
               "patient_relative_dept_doc.disease,patient_relative_dept_doc.doc,patient_relative_dept_doc.dept, " +
               " present_add,contact,to_char(dat,'DD-MM-YYYY') as admission_date from  patient_names_age, " +
               "patient_relative_dept_doc,patient_adm_date ,patient_address " +
               "where  patient_names_age.patient_id = " +
               "(select patient_seat.patient_id from patient_seat where gb =" +gb_list.getSelectedValue() + " " +
               "And patient_names_age.patient_id = patient_relative_dept_doc.patient_id " +
               "AND patient_names_age.patient_id = patient_adm_date.patient_id "+
               "AND patient_names_age.patient_id = patient_address.patient_id)";

         else if (pb.isSelected())
           sql = "Select patient_names_age.patient_name,patient_names_age.patient_age,patient_names_age.patient_sex, " +
                "patient_relative_dept_doc.disease,patient_relative_dept_doc.doc,patient_relative_dept_doc.dept, " +
                " present_add,contact,to_char(dat,'DD-MM-YYYY') as admission_date from  patient_names_age, " +
                "patient_relative_dept_doc,patient_adm_date ,patient_address " +
                "where  patient_names_age.patient_id = " +
                "(select patient_seat.patient_id from patient_seat where pb =" +pb_list.getSelectedValue() + " " +
                "And patient_names_age.patient_id = patient_relative_dept_doc.patient_id " +
                "AND patient_names_age.patient_id = patient_adm_date.patient_id "+
                "AND patient_names_age.patient_id = patient_address.patient_id)";

         else if (ward.isSelected())
          sql = "  Select patient_names_age.patient_name,patient_names_age.patient_age,patient_names_age.patient_sex, "+
                " patient_relative_dept_doc.disease,patient_relative_dept_doc.doc,patient_relative_dept_doc.dept, "+
                "    present_add,contact,to_char(dat,'DD-MM-YYYY') as admission_date from  patient_names_age, "+
                " patient_relative_dept_doc,patient_adm_date ,patient_address "+
                "  where  patient_names_age.patient_id =  "+
                " (select patient_seat.patient_id from patient_seat where (ward = "+ward_list.getSelectedValue()+"  AND bed = "+bed_list.getSelectedValue()+") "+
                " And patient_names_age.patient_id = patient_relative_dept_doc.patient_id "+
                "  AND patient_names_age.patient_id = patient_adm_date.patient_id "+
                "  AND patient_names_age.patient_id = patient_address.patient_id)";




       try {

                 jdbTable1.setVisible(true);



                 database1.setConnection(new ConnectionDescriptor("jdbc:oracle:oci8:@",
                     "system", "manager", false, "oracle.jdbc.driver.OracleDriver"));
                 Statement statement=database1.createStatement();
                 queryDataSet1.close();
                 queryDataSet1.setQuery(new com.borland.dx.sql.dataset.QueryDescriptor(database1,
                     sql, null, true, Load.ALL));
                 queryDataSet1.executeQuery();
                 jdbTable1.setDataSet(queryDataSet1);
                 database1.closeConnection();



               }
               catch(Exception ex){
                 DBExceptionHandler.handleException(ex);
               }

    }

    preview.setEnabled(true);

  }

  class search_patient_ward_actionAdapter
      implements java.awt.event.ActionListener {
    search_patient adaptee;

    search_patient_ward_actionAdapter(search_patient adaptee) {
      this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
      adaptee.ward_actionPerformed(e);
    }
  }

  class search_patient_cabin_actionAdapter
      implements java.awt.event.ActionListener {
    search_patient adaptee;

    search_patient_cabin_actionAdapter(search_patient adaptee) {
      this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
      adaptee.cabin_actionPerformed(e);
    }
  }

  class search_patient_gb_actionAdapter
      implements java.awt.event.ActionListener {
    search_patient adaptee;

    search_patient_gb_actionAdapter(search_patient adaptee) {
      this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
      adaptee.gb_actionPerformed(e);
    }
  }

  void name_actionPerformed(ActionEvent e) {

    print.setEnabled(false);
    preview.setEnabled(false);
    String temp[] = new String[1];
    temp[0] = "";
    ward_list.setListData(temp);
    bed_list.setListData(temp);
    gb_list.setListData(temp);
    pb_list.setListData(temp);
    cabin_list.setListData(temp);
    ward_list.setEnabled(false);
    bed_list.setEnabled(false);
    gb_list.setEnabled(false);
    cabin_list.setEnabled(false);
    pb_list.setEnabled(false);

    name_text.setEnabled(true);
    jdbTable1.setVisible(false);




  }

  void jButton3_actionPerformed(ActionEvent e) {
dispose();
  }

  void jButton2_actionPerformed(ActionEvent e) {


    name.setText("");

    String temp[]=new String[1];
   ward_list.setListData(temp);
   bed_list.setListData(temp);
   cabin_list.setListData(temp);
   gb_list.setListData(temp);
   pb_list.setListData(temp);
   jdbTable1.setVisible(true);

  // print.setEnabled(false);
   preview.setEnabled(false);


  }

  void print_actionPerformed(ActionEvent e) {
        print_it();
  }

  void preview_actionPerformed(ActionEvent e) {


   // System.out.println(sql);
     int ct = 0;


    try {

    Statement stat;
    ResultSet rset;


    stat = connection.createStatement();
    rset = stat.executeQuery(sql);

    info="";

    while (rset.next()) {
      str1 = "Name: " + rset.getString("patient_name") ;
      info+=str1+"\n";
      str2 = "Age: " + rset.getString("patient_age");
      info+=str2+"\n";
      str3 = "Sex: " + rset.getString("patient_sex");
      info+=str3+"\n";
      str4 = "Disease: " + rset.getString("disease");
      info+=str4+"\n";
      str5 = "Doctor: " + rset.getString("doc");
      info+=str5+"\n";
      str6 = "Department: " + rset.getString("dept");
      info+=str6+"\n";
      str7 = "Present Address: " + rset.getString("present_add");
      info+=str7+"\n";
      str8 = "Contact No: "+rset.getString("contact");
      info+=str8+"\n";
      str9 = "Admission Date: " + rset.getString("admission_date");
      info+=str9+"\n";
      ct++;
    }
    stat.close();
    rset.close();

    if(ct==0)
      JOptionPane.showMessageDialog(null,"No Information Available");
   else
     preview.setEnabled(true);



  }
  catch (SQLException sqlException) {
    //JOptionPane.showMessageDialog(null, sqlException.getMessage(),
     //                             "Database error", JOptionPane.ERROR_MESSAGE);
  }



    if(ct==0)
        JOptionPane.showMessageDialog(null,"No information available");
    else
     {
         JOptionPane.showMessageDialog(null,info);
         print.setEnabled(true);
     }



  }
}

class search_patient_pb_actionAdapter implements java.awt.event.ActionListener {
  search_patient adaptee;

  search_patient_pb_actionAdapter(search_patient adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.pb_actionPerformed(e);
  }
}

class search_patient_search_actionAdapter implements java.awt.event.ActionListener {
  search_patient adaptee;

  search_patient_search_actionAdapter(search_patient adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.search_actionPerformed(e);
  }
}

class search_patient_ward_actionAdapter implements java.awt.event.ActionListener {
  search_patient adaptee;

  search_patient_ward_actionAdapter(search_patient adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.ward_actionPerformed(e);
  }
}

class search_patient_name_actionAdapter implements java.awt.event.ActionListener {
  search_patient adaptee;

  search_patient_name_actionAdapter(search_patient adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.name_actionPerformed(e);
  }
}

class search_patient_cabin_actionAdapter implements java.awt.event.ActionListener {
  search_patient adaptee;

  search_patient_cabin_actionAdapter(search_patient adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.cabin_actionPerformed(e);
  }
}

class search_patient_gb_actionAdapter implements java.awt.event.ActionListener {
  search_patient adaptee;

  search_patient_gb_actionAdapter(search_patient adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.gb_actionPerformed(e);
  }
}

class search_patient_jButton3_actionAdapter implements java.awt.event.ActionListener {
  search_patient adaptee;

  search_patient_jButton3_actionAdapter(search_patient adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton3_actionPerformed(e);
  }
}

class search_patient_jButton2_actionAdapter implements java.awt.event.ActionListener {
  search_patient adaptee;

  search_patient_jButton2_actionAdapter(search_patient adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton2_actionPerformed(e);
  }
}

class search_patient_print_actionAdapter implements java.awt.event.ActionListener {
  search_patient adaptee;

  search_patient_print_actionAdapter(search_patient adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.print_actionPerformed(e);
  }
}

class search_patient_preview_actionAdapter implements java.awt.event.ActionListener {
  search_patient adaptee;

  search_patient_preview_actionAdapter(search_patient adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.preview_actionPerformed(e);
  }
}
