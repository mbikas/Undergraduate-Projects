package hospital;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
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



public class search_old_patient extends JFrame {

  Connection connection;

  PrinterJob job;
  Database database1 = new Database();
  QueryDataSet queryDataSet1 = new QueryDataSet();

  String sql="",info="";
  String str0,str1,str2,str3,str4,str5,str6;

  JPanel jPanel4 = new JPanel();
  JLabel Hospital_name1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel1 = new JPanel();
  JTextField id = new JTextField();
  JTextField name = new JTextField();
  JButton jButton2 = new JButton();
  JButton jButton3 = new JButton();
  JPanel jPanel3 = new JPanel();
  JButton jButton1 = new JButton();
  JRadioButton ids = new JRadioButton();
  JRadioButton names = new JRadioButton();
  ButtonGroup group = new ButtonGroup();
  TableScrollPane tableScrollPane1 = new TableScrollPane();
  JdbTable jdbTable1 = new JdbTable();
  JButton print = new JButton();
  JButton preview = new JButton();

  public search_old_patient() {
    try {
      jbInit();

      print.setEnabled(false);
      setSize(600,480);
      setLocation(110,80);
      show();

     connection = Main.connection;



      id.setEditable(false);
      name.setEditable(false);
      jdbTable1.setVisible(false);
      preview.setEnabled(false);
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    jPanel4.setBackground(new Color(173, 201, 139));
    jPanel4.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel4.setBounds(new Rectangle(9, 84, 578, 35));
    jPanel4.setLayout(null);
    this.getContentPane().setBackground(new Color(173, 201, 139));
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setResizable(false);
    this.setTitle("SEARCH OLD PATIENT");
    this.getContentPane().setLayout(null);
    Hospital_name1.setBounds(new Rectangle(21, 12, 536, 28));
    Hospital_name1.setText("JALALABAD RAGIB-RABEYA MEDICAL COLLEGE HOSPITAL");
    Hospital_name1.setForeground(SystemColor.desktop);
    Hospital_name1.setFont(new java.awt.Font("Dialog", 1, 18));
    jLabel2.setBounds(new Rectangle(150, 6, 218, 25));
    jLabel2.setText("Search Old Patient");
    jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel2.setFont(new java.awt.Font("Book Antiqua", 1, 14));
    jPanel2.setBackground(new Color(173, 201, 139));
    jPanel2.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel2.setBounds(new Rectangle(6, 10, 579, 62));
    jPanel2.setLayout(null);
    jPanel1.setBackground(new Color(173, 201, 139));
    jPanel1.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel1.setBounds(new Rectangle(10, 133, 578, 249));
    jPanel1.setLayout(null);
    id.setBackground(SystemColor.textHighlightText);
    id.setFont(new java.awt.Font("Dialog", 1, 12));
    id.setBounds(new Rectangle(249, 12, 144, 22));
    name.setBackground(SystemColor.textHighlightText);
    name.setFont(new java.awt.Font("Dialog", 1, 12));
    name.setText("");
    name.setBounds(new Rectangle(249, 49, 146, 21));
    jButton2.setBackground(new Color(173, 201, 139));
    jButton2.setBounds(new Rectangle(164, 11, 74, 23));
    jButton2.setFont(new java.awt.Font("Dialog", 1, 12));
    jButton2.setAlignmentY((float) 0.5);
    jButton2.setBorder(BorderFactory.createRaisedBevelBorder());
    jButton2.setMnemonic('C');
    jButton2.setText("CLEAR");
    jButton2.addActionListener(new search_old_patient_jButton2_actionAdapter(this));
    jButton3.setBackground(new Color(173, 201, 139));
    jButton3.setBounds(new Rectangle(492, 12, 72, 23));
    jButton3.setFont(new java.awt.Font("Dialog", 1, 12));
    jButton3.setBorder(BorderFactory.createRaisedBevelBorder());
    jButton3.setMnemonic('L');
    jButton3.setText("CLOSE");
    jButton3.addActionListener(new search_old_patient_jButton3_actionAdapter(this));
    jPanel3.setBackground(new Color(173, 201, 139));
    jPanel3.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel3.setBounds(new Rectangle(9, 385, 580, 46));
    jPanel3.setLayout(null);
    jButton1.setBackground(new Color(173, 201, 139));
    jButton1.setBounds(new Rectangle(54, 12, 74, 24));
    jButton1.setFont(new java.awt.Font("Dialog", 1, 12));
    jButton1.setBorder(BorderFactory.createRaisedBevelBorder());
    jButton1.setMnemonic('S');
    jButton1.setText("SHOW");
    jButton1.addActionListener(new search_old_patient_jButton1_actionAdapter(this));
    ids.setBackground(new Color(173, 201, 139));
    ids.setFont(new java.awt.Font("Dialog", 1, 12));
    ids.setText("ID");
    ids.setBounds(new Rectangle(177, 10, 57, 25));
    ids.addActionListener(new search_old_patient_ids_actionAdapter(this));
    names.setBounds(new Rectangle(174, 49, 59, 25));
    names.addActionListener(new search_old_patient_names_actionAdapter(this));
    names.setBackground(new Color(173, 201, 139));
    names.setFont(new java.awt.Font("Dialog", 1, 12));
    names.setText("NAME");
    tableScrollPane1.getViewport().setBackground(new Color(173, 201, 139));
    tableScrollPane1.setFont(new java.awt.Font("Dialog", 1, 11));
    tableScrollPane1.setBounds(new Rectangle(11, 97, 554, 137));
    jdbTable1.setBackground(new Color(173, 210, 139));
    //print.addActionListener(new search_old_patient_print_actionAdapter(this));
    print.setText("PRINT");
    print.addActionListener(new search_old_patient_print_actionAdapter(this));
    print.setMnemonic('L');
    print.setBorder(BorderFactory.createRaisedBevelBorder());
    print.setFont(new java.awt.Font("Dialog", 1, 12));
    print.setBounds(new Rectangle(385, 11, 72, 23));
    print.setBackground(new Color(173, 201, 139));
    //preview.addActionListener(new search_old_patient_preview_actionAdapter(this));
    preview.setText("PRINT PREVIEW");
    preview.addActionListener(new search_old_patient_preview_actionAdapter(this));
    preview.setMnemonic('L');
    preview.setBorder(BorderFactory.createRaisedBevelBorder());
    preview.setFont(new java.awt.Font("Dialog", 1, 12));
    preview.setBounds(new Rectangle(256, 11, 112, 23));
    preview.setBackground(new Color(173, 201, 139));
    this.getContentPane().add(jPanel2, null);
    jPanel2.add(Hospital_name1, null);
    jPanel1.add(ids, null);
    jPanel1.add(names, null);
    jPanel1.add(id, null);
    jPanel1.add(name, null);
    jPanel1.add(tableScrollPane1, null);
    this.getContentPane().add(jPanel3, null);
    tableScrollPane1.getViewport().add(jdbTable1, null);
    this.getContentPane().add(jPanel4, null);
    jPanel4.add(jLabel2, null);
    this.getContentPane().add(jPanel1, null);
    jPanel3.add(jButton3, null);
    jPanel3.add(jButton1, null);
    jPanel3.add(jButton2, null);
    jPanel3.add(preview, null);
    jPanel3.add(print, null);

    group.add(ids);
    group.add(names);

  }

  public static void main(String[] args) {
    search_old_patient search_old_patient = new search_old_patient();
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

  void jButton1_actionPerformed(ActionEvent e) {




       if(!ids.isSelected() && !names.isSelected())
         JOptionPane.showMessageDialog(null,"Give ID or NAME","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
       else if(ids.isSelected() && id.getText().equals(""))
         JOptionPane.showMessageDialog(null,"Give an ID","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
       else if(names.isSelected() && name.getText().equals(""))
        JOptionPane.showMessageDialog(null,"Enter a Name","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
       else
       {

         try {

           jdbTable1.setVisible(true);

           if(ids.isSelected())
              sql = "Select id,name,age,sex,to_char(adm_date,'DD-MM-YYYY') as admittion_date,to_char(rel_date,'DD-MM-YYYY')as release_date from old_patient_info where id = "+Integer.parseInt(id.getText())+" ";

         else if (names.isSelected())
           sql = "Select id,name,age,sex,to_char(adm_date,'DD-MM-YYYY') as admittion_date,to_char(rel_date,'DD-MM-YYYY')as release_date from old_patient_info where id in (select id from old_patient_info where lower(name) like lower('"+name.getText()+"%') ) ";





           database1.setConnection(new ConnectionDescriptor("jdbc:oracle:oci8:@",
               "system", "manager", false, "oracle.jdbc.driver.OracleDriver"));
           Statement statement=database1.createStatement();
           queryDataSet1.close();
           queryDataSet1.setQuery(new com.borland.dx.sql.dataset.QueryDescriptor(database1,
               sql, null, true, Load.ALL));
           queryDataSet1.executeQuery();
           jdbTable1.setDataSet(queryDataSet1);
           database1.closeConnection();

           preview.setEnabled(true);



         }
         catch(Exception ex){
           DBExceptionHandler.handleException(ex);
         }

    }




  }

  void ids_actionPerformed(ActionEvent e) {
    name.setEditable(false);
    name.setText("");
    id.setEditable(true);
    jdbTable1.setVisible(false);
     print.setEnabled(false);
     preview.setEnabled(false);


  }

  void names_actionPerformed(ActionEvent e) {
    id.setEditable(false);
    id.setText("");
    name.setEditable(true);
    jdbTable1.setVisible(false);
      print.setEnabled(false);
      preview.setEnabled(false);


  }

  void jButton2_actionPerformed(ActionEvent e) {
     id.setText("");
     name.setText("");
     jdbTable1.setVisible(false);
      print.setEnabled(false);

  }

  void jButton3_actionPerformed(ActionEvent e) {
  dispose();
  }

  void print_actionPerformed(ActionEvent e) {
    print_it();
  }

  void preview_actionPerformed(ActionEvent e) {

    int ct = 0;

   // System.out.println(sql);




   try {

   Statement stat;
   ResultSet rset;


   stat = connection.createStatement();
   rset = stat.executeQuery(sql);

    info="";

   while (rset.next()) {
     str1 = "ID: " + rset.getString("id") ;
     info+=str1+"\n";
     str2 = "Name: " + rset.getString("name");
     info+=str2+"\n";
     str3 = "Age: " + rset.getString("age");
     info+=str3+"\n";
     str4 = "Sex: " + rset.getString("sex");
     info+=str4+"\n";
     str5 = "Admission Date: " + rset.getString("admittion_date");
     info+=str5+"\n";
     str6 = "Release Date: " + rset.getString("release_date");
     info+=str6+"\n";
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
   //                              "Database error", JOptionPane.ERROR_MESSAGE);
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

class search_old_patient_jButton1_actionAdapter implements java.awt.event.ActionListener {
  search_old_patient adaptee;

  search_old_patient_jButton1_actionAdapter(search_old_patient adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton1_actionPerformed(e);
  }
}

class search_old_patient_ids_actionAdapter implements java.awt.event.ActionListener {
  search_old_patient adaptee;

  search_old_patient_ids_actionAdapter(search_old_patient adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.ids_actionPerformed(e);
  }
}

class search_old_patient_names_actionAdapter implements java.awt.event.ActionListener {
  search_old_patient adaptee;

  search_old_patient_names_actionAdapter(search_old_patient adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.names_actionPerformed(e);
  }
}

class search_old_patient_jButton2_actionAdapter implements java.awt.event.ActionListener {
  search_old_patient adaptee;

  search_old_patient_jButton2_actionAdapter(search_old_patient adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton2_actionPerformed(e);
  }
}

class search_old_patient_jButton3_actionAdapter implements java.awt.event.ActionListener {
  search_old_patient adaptee;

  search_old_patient_jButton3_actionAdapter(search_old_patient adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton3_actionPerformed(e);
  }
}

class search_old_patient_print_actionAdapter implements java.awt.event.ActionListener {
  search_old_patient adaptee;

  search_old_patient_print_actionAdapter(search_old_patient adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.print_actionPerformed(e);
  }
}

class search_old_patient_preview_actionAdapter implements java.awt.event.ActionListener {
  search_old_patient adaptee;

  search_old_patient_preview_actionAdapter(search_old_patient adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.preview_actionPerformed(e);
  }
}
