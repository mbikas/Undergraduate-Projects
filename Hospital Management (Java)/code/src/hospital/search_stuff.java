
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



 public class search_stuff extends JFrame {

  Connection connection;
  Database database1 = new Database();
  QueryDataSet queryDataSet1 = new QueryDataSet();

  PrinterJob job;
  String str0,str1,str2,str3,str4,str5,str6,str7;
  String sql = "",info="";


  String depts[]={"Medicine","Surgery","Gynae","Paediactric","Orthopaeddics","Neoral"};
  JButton clear = new JButton();
  JLabel jLabel1 = new JLabel();
  JPanel jPanel3 = new JPanel();
  JPanel jPanel1 = new JPanel();
  JLabel Hospital_name = new JLabel();
  JButton close = new JButton();
  JPanel jPanel5 = new JPanel();

  ButtonGroup group = new ButtonGroup();
  JLabel jLabel2 = new JLabel();
  JRadioButton id_button = new JRadioButton();
  JComboBox dept = new JComboBox(depts);
  JPanel jPanel2 = new JPanel();
  JTextField name = new JTextField();
  JTextField id = new JTextField();
  TableScrollPane tableScrollPane1 = new TableScrollPane();
  JRadioButton dept_button = new JRadioButton();
  JRadioButton name_button = new JRadioButton();
  JdbTable jdbTable1 = new JdbTable();
  JButton search = new JButton();
  JButton print = new JButton();
  JButton preview = new JButton();


  public search_stuff() {
    try {
      jbInit();
      setSize(600,480);
      setLocation(110,80);
      show();

      connection = Main.connection;

      jdbTable1.setVisible(false);
      preview.setEnabled(false);
      print.setEnabled(false);

    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    clear.setText("CLEAR");
    clear.addActionListener(new search_stuff_clear_actionAdapter(this));
    clear.setMnemonic('C');
    clear.setFont(new java.awt.Font("Dialog", 1, 12));
    clear.setBorder(BorderFactory.createRaisedBevelBorder());
    clear.setBackground(new Color(173, 201, 139));
    clear.setBounds(new Rectangle(126, 10, 75, 25));
    this.getContentPane().setLayout(null);
    jLabel1.setFont(new java.awt.Font("Book Antiqua", 1, 14));
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("Search Stuff  ");
    jLabel1.setBounds(new Rectangle(149, 4, 218, 25));
    jPanel3.setBackground(new Color(173, 201, 139));
    jPanel3.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel3.setBounds(new Rectangle(9, 66, 570, 35));
    jPanel3.setLayout(null);
    jPanel1.setBackground(new Color(173, 201, 139));
    jPanel1.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel1.setBounds(new Rectangle(9, 13, 569, 51));
    jPanel1.setLayout(null);
    Hospital_name.setBounds(new Rectangle(16, 13, 544, 28));
    Hospital_name.setText("JALALABAD RAGIB-RABEYA MEDICAL COLLEGE HOSPITAL");
    Hospital_name.setForeground(SystemColor.desktop);
    Hospital_name.setFont(new java.awt.Font("Dialog", 1, 18));
    close.setBackground(new Color(173, 201, 139));
    close.setBounds(new Rectangle(467, 10, 66, 27));
    close.setFont(new java.awt.Font("Dialog", 1, 12));
    close.setBorder(BorderFactory.createRaisedBevelBorder());
    close.setMnemonic('L');
    close.setText("CLOSE");
    close.addActionListener(new search_stuff_close_actionAdapter(this));
    jPanel5.setBackground(new Color(173, 201, 139));
    jPanel5.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel5.setBounds(new Rectangle(8, 386, 571, 49));
    jPanel5.setLayout(null);
    this.getContentPane().setBackground(new Color(173, 201, 139));
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setResizable(false);
    this.setTitle("SEARCH STUFF");


    jLabel2.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel2.setText("INFORMATION");
    jLabel2.setBounds(new Rectangle(239, 65, 98, 20));
    id_button.setBackground(new Color(173, 201, 139));
    id_button.setFont(new java.awt.Font("Dialog", 1, 12));
    id_button.setText("ID:");
    id_button.setBounds(new Rectangle(7, 5, 85, 21));
    id_button.addActionListener(new search_stuff_id_button_actionAdapter(this));
     dept.setBackground(new Color(173, 201, 139));
    dept.setFont(new java.awt.Font("Dialog", 1, 12));
    dept.setBounds(new Rectangle(381, 6, 142, 25));
    jPanel2.setBackground(new Color(173, 201, 139));
    jPanel2.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel2.setBounds(new Rectangle(8, 106, 571, 276));
    jPanel2.setLayout(null);
    name.setBackground(SystemColor.textHighlightText);
    name.setFont(new java.awt.Font("Dialog", 1, 12));
    name.setText("");
    name.setBounds(new Rectangle(98, 33, 144, 24));
    id.setBounds(new Rectangle(100, 4, 141, 24));
    id.setBackground(SystemColor.textHighlightText);
    id.setFont(new java.awt.Font("Dialog", 1, 12));
    id.setText("");
    tableScrollPane1.getViewport().setBackground(new Color(173, 201, 139));
    tableScrollPane1.setBounds(new Rectangle(6, 88, 544, 181));
    dept_button.setBackground(new Color(173, 201, 139));
    dept_button.setFont(new java.awt.Font("Dialog", 1, 12));
    dept_button.setText("DEPARTMENT:");
    dept_button.setBounds(new Rectangle(259, 5, 117, 22));
    dept_button.addActionListener(new search_stuff_dept_button_actionAdapter(this));
    name_button.setBackground(new Color(173, 201, 139));
    name_button.setFont(new java.awt.Font("Dialog", 1, 12));
    name_button.setText("NAME:");
    name_button.setBounds(new Rectangle(8, 36, 71, 22));
    name_button.addActionListener(new search_stuff_name_button_actionAdapter(this));
    search.setText("SEARCH");
    search.addActionListener(new search_stuff_search_actionAdapter(this));
    search.setMnemonic('S');
    search.setBorder(BorderFactory.createRaisedBevelBorder());
    search.setFont(new java.awt.Font("Dialog", 1, 12));
    search.setBounds(new Rectangle(36, 9, 66, 27));
    search.setBackground(new Color(173, 201, 139));
    print.setText("PRINT");
    print.addActionListener(new search_stuff_print_actionAdapter(this));
    print.setMnemonic('L');
    print.setBorder(BorderFactory.createRaisedBevelBorder());
    print.setFont(new java.awt.Font("Dialog", 1, 12));
    print.setBounds(new Rectangle(363, 11, 66, 27));
    print.setBackground(new Color(173, 201, 139));
    preview.setBackground(new Color(173, 201, 139));
    preview.setBounds(new Rectangle(230, 10, 110, 27));
    preview.setFont(new java.awt.Font("Dialog", 1, 12));
    preview.setBorder(BorderFactory.createRaisedBevelBorder());
    preview.setMnemonic('L');
    preview.setText("PRINT PREVIEW");
    preview.addActionListener(new search_stuff_preview_actionAdapter(this));
    this.getContentPane().add(jPanel5, null);
    this.getContentPane().add(jPanel3, null);
    jPanel3.add(jLabel1, null);
    jPanel5.add(search, null);
    jPanel5.add(clear, null);
    jPanel5.add(close, null);
    jPanel5.add(print, null);
    jPanel5.add(preview, null);
    this.getContentPane().add(jPanel1, null);
    jPanel1.add(Hospital_name, null);
    this.getContentPane().add(jPanel2, null);
    jPanel2.add(id, null);
    jPanel2.add(name_button, null);
    jPanel2.add(id_button, null);
    jPanel2.add(name, null);
    jPanel2.add(dept_button, null);
    jPanel2.add(dept, null);
    jPanel2.add(tableScrollPane1, null);
    tableScrollPane1.getViewport().add(jdbTable1, null);
    jPanel2.add(jLabel2, null);

    group.add(id_button);
    group.add(name_button);
    group.add(dept_button);




  }

  public static void main(String[] args) {
    search_stuff search_stuff = new search_stuff();
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







  void close_actionPerformed(ActionEvent e) {
    dispose();
  }

  void clear_actionPerformed(ActionEvent e) {

    print.setEnabled(false);

  }

  void id_button_actionPerformed(ActionEvent e) {


    dept.setEnabled(false);
    name.setEnabled(false);
    id.setEnabled(true);
    name.setText("");
    jdbTable1.setVisible(false);
    preview.setEnabled(false);
    print.setEnabled(false);



  }

  void name_button_actionPerformed(ActionEvent e) {

    name.setEnabled(true);
    dept.setEnabled(false);
    id.setEnabled(false);
    id.setText("");
    jdbTable1.setVisible(false);
    preview.setEnabled(false);
     print.setEnabled(false);



  }

  void dept_button_actionPerformed(ActionEvent e) {


    preview.setEnabled(false);
    print.setEnabled(false);


   dept.setEnabled(true);
   name.setEnabled(true);
   id.setEnabled(true);
   name.setEnabled(false);
   id.setEnabled(false);
   name.setText("");
   id.setText("");
   jdbTable1.setVisible(false);


  }

  void search_actionPerformed(ActionEvent e) {

    if(id_button.isSelected() && id.getText().equals(""))
       JOptionPane.showMessageDialog(null,"Give an ID","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
     else if(name_button.isSelected() && name.getText().equals(""))
      JOptionPane.showMessageDialog(null,"Enter a Name","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);

     else{


       try {

         jdbTable1.setVisible(true);
         String sql = "";

         if (id_button.isSelected())
           sql = "select stuff_id,name,dept,religion,age,degree,address,salary,sex,dates   as Joining_date from stuff_info where stuff_id = "+Integer.parseInt(id.getText()) + "  ";
         else if (name_button.isSelected())
           sql = "select stuff_id,name,dept,religion,age,degree,address,salary,sex,dates as Joining_date  from stuff_info where stuff_id in ( select stuff_id from stuff_info where lower(name) like lower('" +
               name.getText() + "%')) ";
         else //for combo
           sql = "select stuff_id,name,dept,religion,age,degree,address,salary,sex,dates  as Joining_date from stuff_info where stuff_id in ( select stuff_id from stuff_info where dept = '" +
               dept.getSelectedItem() + "')";

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

  void preview_actionPerformed(ActionEvent e) {

    int ct = 0;

 // System.out.println(sql);


 try {

   Statement stat;
   ResultSet rset;

   stat = connection.createStatement();
   rset = stat.executeQuery(sql);

   info = "";

   while (rset.next()) {
     str1 = "ID: " + rset.getString("stuff_id");
     info += str1 + "\n";
     str2 = "Name: " + rset.getString("name");
     info += str2 + "\n";
     str3 = "Department: " + rset.getString("dept");
     info += str3 + "\n";
     str4 = "Religion: " + rset.getString("religion");
     info += str4 + "\n";
     str5 = "Age: " + rset.getString("age");
     info += str5 + "\n";
     str6 = "Degree: " + rset.getString("degree");
     info += str6 + "\n";
     str7 = "Address: " + rset.getString("address");
     info += str7 + "\n";
     ct++;
   }

   stat.close();
   rset.close();
   if (ct == 0)
     JOptionPane.showMessageDialog(null, "No information available");
   else {
     JOptionPane.showMessageDialog(null, info);
     print.setEnabled(true);
   }

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

  void print_actionPerformed(ActionEvent e) {

    print_it();

  }






}

class search_stuff_close_actionAdapter implements java.awt.event.ActionListener {
  search_stuff adaptee;

  search_stuff_close_actionAdapter(search_stuff adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.close_actionPerformed(e);
  }
}

class search_stuff_clear_actionAdapter implements java.awt.event.ActionListener {
  search_stuff adaptee;

  search_stuff_clear_actionAdapter(search_stuff adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.clear_actionPerformed(e);
  }
}


class search_stuff_name_button_actionAdapter implements java.awt.event.ActionListener {
  search_stuff adaptee;

  search_stuff_name_button_actionAdapter(search_stuff adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.name_button_actionPerformed(e);
  }
}

class search_stuff_dept_button_actionAdapter implements java.awt.event.ActionListener {
  search_stuff adaptee;

  search_stuff_dept_button_actionAdapter(search_stuff adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.dept_button_actionPerformed(e);
  }
}

class search_stuff_search_actionAdapter implements java.awt.event.ActionListener {
  search_stuff adaptee;

  search_stuff_search_actionAdapter(search_stuff adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.search_actionPerformed(e);
  }
}

class search_stuff_id_button_actionAdapter implements java.awt.event.ActionListener {
  search_stuff adaptee;

  search_stuff_id_button_actionAdapter(search_stuff adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.id_button_actionPerformed(e);
  }
}

class search_stuff_preview_actionAdapter implements java.awt.event.ActionListener {
  search_stuff adaptee;

  search_stuff_preview_actionAdapter(search_stuff adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.preview_actionPerformed(e);
  }
}

class search_stuff_print_actionAdapter implements java.awt.event.ActionListener {
  search_stuff adaptee;

  search_stuff_print_actionAdapter(search_stuff adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.print_actionPerformed(e);
  }
}





