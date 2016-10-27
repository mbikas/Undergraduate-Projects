
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



public class search_supply extends JFrame {

    Connection connection;
    PrinterJob job;
    String str0,str1,str2,str3,str4,str5,str6,str7;
    String sql = "",info="";



  Database database1 = new Database();
  QueryDataSet queryDataSet1 = new QueryDataSet();

  JPanel jPanel1 = new JPanel();
  JLabel Hospital_name = new JLabel();
  JLabel jLabel1 = new JLabel();
  JPanel jPanel3 = new JPanel();
  JPanel jPanel2 = new JPanel();
  JTextField name = new JTextField();
  String depts[]={"Medicine","Surgery","Gynae","Paediactric","Orthopaeddics","Neoral"};
  JComboBox dept = new JComboBox(depts);
  JPanel jPanel5 = new JPanel();
  JButton jButton2 = new JButton();
  JButton jButton1 = new JButton();
  JButton jButton3 = new JButton();
  JLabel jLabel2 = new JLabel();
  JRadioButton dept_button = new JRadioButton();
  JRadioButton name_button = new JRadioButton();
  TableScrollPane tableScrollPane1 = new TableScrollPane();
  ButtonGroup group = new ButtonGroup();
  JdbTable jdbTable1 = new JdbTable();
  JButton preview = new JButton();
  JButton print = new JButton();

  public search_supply() {
    try {
      jbInit();
      setSize(600,440);
      setLocation(110,80);
      show();

      connection = Main.connection;


      jdbTable1.setVisible(false);
      name_button.setSelected(true);
      print.setEnabled(false);
      preview.setEnabled(false);
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    jPanel1.setBackground(new Color(173, 201, 139));
    jPanel1.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel1.setBounds(new Rectangle(5, 6, 580, 62));
    jPanel1.setLayout(null);
    this.getContentPane().setLayout(null);
    Hospital_name.setBounds(new Rectangle(21, 12, 553, 28));
    Hospital_name.setText("JALALABAD RAGIB-RABEYA MEDICAL COLLEGE HOSPITAL");
    Hospital_name.setForeground(SystemColor.desktop);
    Hospital_name.setFont(new java.awt.Font("Dialog", 1, 18));
    jLabel1.setFont(new java.awt.Font("Book Antiqua", 1, 14));
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("Supply Search");
    jLabel1.setBounds(new Rectangle(150, 6, 218, 25));
    jPanel3.setBackground(new Color(173, 201, 139));
    jPanel3.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel3.setBounds(new Rectangle(6, 73, 580, 35));
    jPanel3.setLayout(null);
    jPanel2.setBackground(new Color(173, 201, 139));
    jPanel2.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel2.setBounds(new Rectangle(9, 119, 577, 219));
    jPanel2.setLayout(null);
    name.setBackground(SystemColor.textHighlightText);
    name.setFont(new java.awt.Font("Dialog", 1, 12));
    name.setText("");
    name.setBounds(new Rectangle(100, 11, 140, 24));
    dept.setBackground(new Color(173, 201, 139));
    dept.setFont(new java.awt.Font("Dialog", 1, 12));
    dept.setBounds(new Rectangle(416, 10, 132, 24));
    dept.addActionListener(new search_supply_dept_actionAdapter(this));
    jPanel5.setLayout(null);
    jPanel5.setBounds(new Rectangle(9, 340, 579, 51));
    jPanel5.setBackground(new Color(173, 201, 139));
    jPanel5.setBorder(BorderFactory.createLoweredBevelBorder());
    jButton2.setText("CLEAR");
    jButton2.addActionListener(new search_supply_jButton2_actionAdapter(this));
    jButton2.setMnemonic('C');
    jButton2.setBorder(BorderFactory.createRaisedBevelBorder());
    jButton2.setFont(new java.awt.Font("Dialog", 1, 12));
    jButton2.setBackground(new Color(173, 201, 139));
    jButton2.setBounds(new Rectangle(174, 11, 75, 27));
    jButton1.setText("SHOW");
    jButton1.addActionListener(new search_supply_jButton1_actionAdapter(this));
    jButton1.setMnemonic('S');
    jButton1.setBorder(BorderFactory.createRaisedBevelBorder());
    jButton1.setFont(new java.awt.Font("Dialog", 1, 12));
    jButton1.setBackground(new Color(173, 201, 139));
    jButton1.setBounds(new Rectangle(85, 10, 72, 28));
    jButton3.setText("CLOSE");
    jButton3.addActionListener(new search_supply_jButton3_actionAdapter(this));
    jButton3.setMnemonic('L');
    jButton3.setBorder(BorderFactory.createRaisedBevelBorder());
    jButton3.setActionCommand("CLOSE");
    jButton3.setFont(new java.awt.Font("Dialog", 1, 12));
    jButton3.setBackground(new Color(173, 201, 139));
    jButton3.setBounds(new Rectangle(484, 8, 66, 28));
    this.getContentPane().setBackground(new Color(173, 201, 139));
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setResizable(false);
    this.setTitle("SEARCH SUPPLY");
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel2.setText("INFORMATION");
    jLabel2.setBounds(new Rectangle(239, 52, 128, 19));
    dept_button.setBounds(new Rectangle(285, 9, 115, 26));
    dept_button.addActionListener(new search_supply_dept_button_actionAdapter(this));
    dept_button.setBackground(new Color(173, 201, 139));
    dept_button.setFont(new java.awt.Font("Dialog", 1, 12));
    dept_button.setText("DEPARTMENT");
    name_button.setText("ITEM");
    name_button.setFont(new java.awt.Font("Dialog", 1, 12));
    name_button.setBackground(new Color(173, 201, 139));
    name_button.setBounds(new Rectangle(7, 8, 91, 26));
    name_button.addActionListener(new search_supply_name_button_actionAdapter(this));
    tableScrollPane1.getViewport().setBackground(new Color(173, 201, 139));
    tableScrollPane1.setFont(new java.awt.Font("Dialog", 1, 12));
    tableScrollPane1.setForeground(new Color(62, 55, 152));
    tableScrollPane1.setBounds(new Rectangle(35, 77, 519, 134));
    preview.setBounds(new Rectangle(269, 10, 113, 28));
    preview.setBackground(new Color(173, 201, 139));
    preview.setFont(new java.awt.Font("Dialog", 1, 12));
    preview.setActionCommand("CLOSE");
    preview.setBorder(BorderFactory.createRaisedBevelBorder());
    preview.setMnemonic('L');
    //preview.addActionListener(new search_supply_preview_actionAdapter(this));
    preview.setText("PRINT PREVIEW");
    preview.addActionListener(new search_supply_preview_actionAdapter(this));
    print.setBounds(new Rectangle(395, 9, 66, 28));
    print.setBackground(new Color(173, 201, 139));
    print.setFont(new java.awt.Font("Dialog", 1, 12));
    print.setActionCommand("CLOSE");
    print.setBorder(BorderFactory.createRaisedBevelBorder());
    print.setMnemonic('L');
    print.setText("PRINT");
    print.addActionListener(new search_supply_print_actionAdapter(this));
    this.getContentPane().add(jPanel1, null);
    jPanel1.add(Hospital_name, null);
    this.getContentPane().add(jPanel3, null);
    jPanel3.add(jLabel1, null);
    this.getContentPane().add(jPanel2, null);
    jPanel5.add(jButton3, null);
    jPanel5.add(jButton1, null);
    jPanel5.add(jButton2, null);
    jPanel5.add(preview, null);
    jPanel5.add(print, null);
    jPanel2.add(name_button, null);
    jPanel2.add(dept_button, null);
    jPanel2.add(dept, null);
    jPanel2.add(tableScrollPane1, null);
    jPanel2.add(jLabel2, null);
    jPanel2.add(name, null);
    this.getContentPane().add(jPanel5, null);
    tableScrollPane1.getViewport().add(jdbTable1, null);
    group.add(dept_button);
    group.add(name_button);

  }

  public static void main(String[] args) {
    search_supply search_supply = new search_supply();
  }


  public class Test implements Printable{


 public int print(Graphics g, PageFormat pageFormat, int pageIndex) {
   if (pageIndex >= 1)
       return Printable.NO_SUCH_PAGE;




            g.drawString(str1,100,100);
            g.drawString(str2,100,120);
            g.drawString(str3,100,140);
            g.drawString(str4,100,160);





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


  void dept_actionPerformed(ActionEvent e) {


    name.setEnabled(true);

  }

  void jButton1_actionPerformed(ActionEvent e) {

    if(name_button.isSelected() && name.getText().equals(""))
       JOptionPane.showMessageDialog(null,"Give an ID","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);

     else{


       try {

         jdbTable1.setVisible(true);


         if (name_button.isSelected())
           sql = "select * from  supply_entry where lower(name) like lower('" +name.getText() + "%') ";

         else //for combo
           sql = "select * from  supply_entry where dept = '" +dept.getSelectedItem() + "' ";

         database1.setConnection(new ConnectionDescriptor("jdbc:oracle:oci8:@",
             "system", "manager", false, "oracle.jdbc.driver.OracleDriver"));
         Statement statement = database1.createStatement();
         queryDataSet1.close();
         queryDataSet1.setQuery(new com.borland.dx.sql.dataset.QueryDescriptor(
             database1, sql, null, true, Load.ALL));
         queryDataSet1.executeQuery();
         jdbTable1.setDataSet(queryDataSet1);
         database1.closeConnection();
       }
       catch (Exception ex) {
         DBExceptionHandler.handleException(ex);
       }
     }

      preview.setEnabled(true);

  }

  void jButton2_actionPerformed(ActionEvent e) {
      name.setText("");
      jdbTable1.setVisible(false);
      print.setEnabled(false);

  }

  void jButton3_actionPerformed(ActionEvent e) {
dispose();
  }

  void name_button_actionPerformed(ActionEvent e) {
    jdbTable1.setVisible(false);
    dept.setEnabled(false);
    name.setEnabled(true);

    print.setEnabled(false);
      preview.setEnabled(false);

  }

  void dept_button_actionPerformed(ActionEvent e) {
    name.setEnabled(false);
    jdbTable1.setVisible(false);
    dept.setEnabled(true);
    print.setEnabled(false);
    preview.setEnabled(false);

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
    str1 = "Name: " + rset.getString("name") ;
    info+=str1+"\n";
    str2 = "Department: " + rset.getString("dept");
    info+=str2+"\n";
    str3 = "Quantity: " + rset.getString("quantity");
    info+=str3+"\n";
    str4 = "Price: " + rset.getString("price");
    info+=str4+"\n";
     ct++;
  }






   // System.out.println(info);





  stat.close();

  rset.close();
}
catch (SQLException sqlException) {
  //JOptionPane.showMessageDialog(null, sqlException.getMessage(),
   //                             "Database error", JOptionPane.ERROR_MESSAGE);
}



  if(ct==0)
      JOptionPane.showMessageDialog(null,"No Information available");
  else
   {
       JOptionPane.showMessageDialog(null,info);
       print.setEnabled(true);
   }


  }

  void print_actionPerformed(ActionEvent e) {
   print_it();
  }
}

class search_supply_dept_actionAdapter implements java.awt.event.ActionListener {
  search_supply adaptee;

  search_supply_dept_actionAdapter(search_supply adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.dept_actionPerformed(e);
  }
}

class search_supply_jButton1_actionAdapter implements java.awt.event.ActionListener {
  search_supply adaptee;

  search_supply_jButton1_actionAdapter(search_supply adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton1_actionPerformed(e);
  }
}

class search_supply_jButton2_actionAdapter implements java.awt.event.ActionListener {
  search_supply adaptee;

  search_supply_jButton2_actionAdapter(search_supply adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton2_actionPerformed(e);
  }
}

class search_supply_jButton3_actionAdapter implements java.awt.event.ActionListener {
  search_supply adaptee;

  search_supply_jButton3_actionAdapter(search_supply adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton3_actionPerformed(e);
  }
}

class search_supply_name_button_actionAdapter implements java.awt.event.ActionListener {
  search_supply adaptee;

  search_supply_name_button_actionAdapter(search_supply adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.name_button_actionPerformed(e);
  }
}

class search_supply_dept_button_actionAdapter implements java.awt.event.ActionListener {
  search_supply adaptee;

  search_supply_dept_button_actionAdapter(search_supply adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.dept_button_actionPerformed(e);
  }
}

class search_supply_preview_actionAdapter implements java.awt.event.ActionListener {
  search_supply adaptee;

  search_supply_preview_actionAdapter(search_supply adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.preview_actionPerformed(e);
  }
}

class search_supply_print_actionAdapter implements java.awt.event.ActionListener {
  search_supply adaptee;

  search_supply_print_actionAdapter(search_supply adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.print_actionPerformed(e);
  }
}
