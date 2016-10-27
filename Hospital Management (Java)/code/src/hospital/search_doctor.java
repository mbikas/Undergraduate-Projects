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



public class search_doctor extends JFrame {

  Connection connection;
  PrinterJob job;
  String str0,str1,str2,str3,str4,str5,str6,str7;


  Database database1 = new Database();
  QueryDataSet queryDataSet1 =
  new QueryDataSet();
  String sql = "",info="";

  String depts[]={"Medicine","Surgery","Gynae","Paediactric","Orthopaeddics","Neoral"};
  JPanel jPanel1 = new JPanel();
  JLabel Hospital_name = new JLabel();
  JPanel jPanel2 = new JPanel();
  JComboBox dept = new JComboBox(depts);
  JRadioButton name_button = new JRadioButton();
  JRadioButton dept_button = new JRadioButton();
  ButtonGroup group =  new ButtonGroup();
  JPanel jPanel3 = new JPanel();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JPanel jPanel5 = new JPanel();
  JButton clear = new JButton();
  JButton show = new JButton();
  JButton close = new JButton();
  JTextField name = new JTextField();
  JTextField id = new JTextField();
  JRadioButton id_button = new JRadioButton();
  TableScrollPane tableScrollPane1 = new TableScrollPane();
  JdbTable jdbTable1 = new JdbTable();
  JButton preview = new JButton();
  JButton print = new JButton();

  public search_doctor() {
    try {
      jbInit();
      setSize(600,470);
      setLocation(110,80);
      show();

      connection = Main.connection;


      name_button.setSelected(true);
      dept.setEnabled(false);
      jdbTable1.setVisible(false);
      print.setEnabled(false);


    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    this.getContentPane().setLayout(null);
    jPanel1.setBackground(new Color(173, 201, 139));
    jPanel1.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel1.setBounds(new Rectangle(9, 15, 569, 62));
    jPanel1.setLayout(null);
    Hospital_name.setBounds(new Rectangle(21, 12, 544, 28));
    Hospital_name.setText("JALALABAD RAGIB-RABEYA MEDICAL COLLEGE HOSPITAL");
    Hospital_name.setForeground(SystemColor.desktop);
    Hospital_name.setFont(new java.awt.Font("Dialog", 1, 18));
    jPanel2.setBackground(new Color(173, 201, 139));
    jPanel2.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel2.setBounds(new Rectangle(14, 132, 566, 235));
    jPanel2.setLayout(null);
    dept.setBackground(new Color(173, 201, 139));
    dept.setFont(new java.awt.Font("Dialog", 1, 12));
    dept.setBounds(new Rectangle(381, 6, 142, 25));
    dept.addActionListener(new search_doctor_dept_actionAdapter(this));
    name_button.setBackground(new Color(173, 201, 139));
    name_button.setFont(new java.awt.Font("Dialog", 1, 12));
    name_button.setText("NAME:");
    name_button.setBounds(new Rectangle(8, 36, 71, 22));
    name_button.addActionListener(new search_doctor_name_button_actionAdapter(this));
    dept_button.setBackground(new Color(173, 201, 139));
    dept_button.setFont(new java.awt.Font("Dialog", 1, 12));
    dept_button.setText("DEPARTMENT:");
    dept_button.setBounds(new Rectangle(259, 5, 117, 22));
    dept_button.addActionListener(new search_doctor_dept_button_actionAdapter(this));
    jPanel3.setBackground(new Color(173, 201, 139));
    jPanel3.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel3.setBounds(new Rectangle(12, 84, 565, 35));
    jPanel3.setLayout(null);
    jLabel1.setFont(new java.awt.Font("Book Antiqua", 1, 14));
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("Search  Doctor");
    jLabel1.setBounds(new Rectangle(150, 6, 218, 25));
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel2.setText("INFORMATION");
    jLabel2.setBounds(new Rectangle(239, 65, 98, 20));
    jPanel5.setBackground(new Color(173, 201, 139));
    jPanel5.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel5.setBounds(new Rectangle(15, 369, 568, 57));
    jPanel5.setLayout(null);
    clear.setBackground(new Color(173, 201, 139));
    clear.setBounds(new Rectangle(153, 18, 75, 25));
    clear.setFont(new java.awt.Font("Dialog", 1, 12));
    clear.setBorder(BorderFactory.createRaisedBevelBorder());
    clear.setMnemonic('C');
    clear.setText("CLEAR");
    clear.addActionListener(new search_doctor_clear_actionAdapter(this));
    show.setBackground(new Color(173, 201, 139));
    show.setBounds(new Rectangle(52, 18, 72, 26));
    show.setFont(new java.awt.Font("Dialog", 1, 12));
    show.setBorder(BorderFactory.createRaisedBevelBorder());
    show.setMnemonic('E');
    show.setText("SEARCH");
    show.addActionListener(new search_doctor_show_actionAdapter(this));
    close.setBackground(new Color(173, 201, 139));
    close.setBounds(new Rectangle(491, 14, 66, 27));
    close.setFont(new java.awt.Font("Dialog", 1, 12));
    close.setBorder(BorderFactory.createRaisedBevelBorder());
    close.setMnemonic('L');
    close.setText("CLOSE");
    close.addActionListener(new search_doctor_close_actionAdapter(this));
    this.getContentPane().setBackground(new Color(173, 201, 139));
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setResizable(false);
    this.setTitle("SEARCH DOCTOR");
    name.setBackground(SystemColor.textHighlightText);
    name.setFont(new java.awt.Font("Dialog", 1, 12));
    name.setText("");
    name.setBounds(new Rectangle(98, 33, 144, 24));
    id.setBounds(new Rectangle(100, 4, 141, 24));
    id.setBackground(SystemColor.textHighlightText);
    id.setFont(new java.awt.Font("Dialog", 1, 12));
    id.setText("");
    id_button.setBackground(new Color(173, 201, 139));
    id_button.setFont(new java.awt.Font("Dialog", 1, 12));
    id_button.setText("ID:");
    id_button.setBounds(new Rectangle(7, 5, 85, 21));
    id_button.addActionListener(new search_doctor_id_button_actionAdapter(this));
    tableScrollPane1.getViewport().setBackground(new Color(173, 201, 139));
    tableScrollPane1.setBounds(new Rectangle(6, 88, 544, 135));
    preview.setText("PRINT PREVIEW");
    preview.addActionListener(new search_doctor_preview_actionAdapter(this));
    preview.setMnemonic('L');
    preview.setBorder(BorderFactory.createRaisedBevelBorder());
    preview.setFont(new java.awt.Font("Dialog", 1, 12));
    preview.setBounds(new Rectangle(246, 16, 118, 27));
    preview.setBackground(new Color(173, 201, 139));
    print.setText("PRINT");
    print.addActionListener(new search_doctor_print_actionAdapter(this));
    print.setMnemonic('L');
    print.setBorder(BorderFactory.createRaisedBevelBorder());
    print.setFont(new java.awt.Font("Dialog", 1, 12));
    print.setBounds(new Rectangle(392, 15, 66, 27));
    print.setBackground(new Color(173, 201, 139));
    this.getContentPane().add(jPanel1, null);
    jPanel1.add(Hospital_name, null);
    jPanel2.add(id, null);
    jPanel2.add(name_button, null);
    jPanel2.add(id_button, null);
    jPanel2.add(name, null);
    jPanel2.add(dept_button, null);
    jPanel2.add(dept, null);
    jPanel2.add(tableScrollPane1, null);
    jPanel2.add(jLabel2, null);
    this.getContentPane().add(jPanel5, null);
    tableScrollPane1.getViewport().add(jdbTable1, null);
    this.getContentPane().add(jPanel3, null);
    jPanel3.add(jLabel1, null);
    jPanel5.add(close, null);
    jPanel5.add(show, null);
    jPanel5.add(clear, null);
    jPanel5.add(preview, null);
    jPanel5.add(print, null);
    this.getContentPane().add(jPanel2, null);

    group.add(name_button);
    group.add(dept_button);
    group.add(id_button);


  }

  public static void main(String[] args) {
    search_doctor search_doctor = new search_doctor();
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


  void dept_button_actionPerformed(ActionEvent e) {

      dept.setEnabled(true);
      name.setEnabled(true);
      id.setEnabled(true);
      name.setEnabled(false);
      id.setEnabled(false);
      name.setText("");
      id.setText("");
      jdbTable1.setVisible(false);
      print.setEnabled(false);
      sql="";




  }

  void name_button_actionPerformed(ActionEvent e) {

    print.setEnabled(false);
      name.setEnabled(true);
      dept.setEnabled(false);
      id.setEnabled(false);
      id.setText("");
      jdbTable1.setVisible(false);
      sql="";
  }

  void dept_actionPerformed(ActionEvent e) {


  }

  void show_actionPerformed(ActionEvent e) {

      if(id_button.isSelected() && id.getText().equals(""))
        JOptionPane.showMessageDialog(null,"Give an ID","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
      else if(name_button.isSelected() && name.getText().equals(""))
       JOptionPane.showMessageDialog(null,"Enter a Name","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);

      else{


        try {

          jdbTable1.setVisible(true);


          if (id_button.isSelected())
            sql = "select doctor_id,name,dept,religion,age,degree,address,salary,sex,dates   as Joining_date from doctor_info where doctor_id = "+Integer.parseInt(id.getText()) + "  ";
          else if (name_button.isSelected())
            sql = "select doctor_id,name,dept,religion,age,degree,address,salary,sex,dates as Joining_date  from doctor_info where doctor_id in ( select doctor_id from doctor_info where lower(name) like lower('" +
                name.getText() + "%')) ";
          else //for combo
            sql = "select doctor_id,name,dept,religion,age,degree,address,salary,sex,dates  as Joining_date from doctor_info where doctor_id in ( select doctor_id from doctor_info where dept = '" +
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
  }

  void id_button_actionPerformed(ActionEvent e) {

     dept.setEnabled(false);
     name.setEnabled(false);
     id.setEnabled(true);
     name.setText("");
     print.setEnabled(false);
     sql="";
  }

  void close_actionPerformed(ActionEvent e) {
    dispose();
  }

  void clear_actionPerformed(ActionEvent e) {
    id.setText("");
    name.setText("");
    jdbTable1.setVisible(false);
    print.setEnabled(false);
  }

  void preview_actionPerformed(ActionEvent e) {

    int ct = 0;

  // System.out.println(sql);

  if(sql.equals(""))
  {
     JOptionPane.showMessageDialog(null,"No Information Available");
  }
  else
  {


    try {

      Statement stat;
      ResultSet rset;

      stat = connection.createStatement();
      rset = stat.executeQuery(sql);

      info = "";

      while (rset.next()) {
        str1 = "ID: " + rset.getString("doctor_id");
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

      // System.out.println(info);
      stat.close();
      rset.close();

    }
    catch (SQLException sqlException) {
      //JOptionPane.showMessageDialog(null, sqlException.getMessage(),
       //                             "Database error",
      //                              JOptionPane.ERROR_MESSAGE);
    }
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

class search_doctor_dept_button_actionAdapter implements java.awt.event.ActionListener {
  search_doctor adaptee;

  search_doctor_dept_button_actionAdapter(search_doctor adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.dept_button_actionPerformed(e);
  }
}

class search_doctor_name_button_actionAdapter implements java.awt.event.ActionListener {
  search_doctor adaptee;

  search_doctor_name_button_actionAdapter(search_doctor adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.name_button_actionPerformed(e);
  }
}

class search_doctor_dept_actionAdapter implements java.awt.event.ActionListener {
  search_doctor adaptee;

  search_doctor_dept_actionAdapter(search_doctor adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.dept_actionPerformed(e);
  }
}

class search_doctor_show_actionAdapter implements java.awt.event.ActionListener {
  search_doctor adaptee;

  search_doctor_show_actionAdapter(search_doctor adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.show_actionPerformed(e);
  }
}

class search_doctor_id_button_actionAdapter implements java.awt.event.ActionListener {
  search_doctor adaptee;

  search_doctor_id_button_actionAdapter(search_doctor adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.id_button_actionPerformed(e);
  }
}

class search_doctor_close_actionAdapter implements java.awt.event.ActionListener {
  search_doctor adaptee;

  search_doctor_close_actionAdapter(search_doctor adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.close_actionPerformed(e);
  }
}

class search_doctor_clear_actionAdapter implements java.awt.event.ActionListener {
  search_doctor adaptee;

  search_doctor_clear_actionAdapter(search_doctor adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.clear_actionPerformed(e);
  }
}

class search_doctor_preview_actionAdapter implements java.awt.event.ActionListener {
  search_doctor adaptee;

  search_doctor_preview_actionAdapter(search_doctor adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.preview_actionPerformed(e);
  }
}

class search_doctor_print_actionAdapter implements java.awt.event.ActionListener {
  search_doctor adaptee;

  search_doctor_print_actionAdapter(search_doctor adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.print_actionPerformed(e);
  }
}
