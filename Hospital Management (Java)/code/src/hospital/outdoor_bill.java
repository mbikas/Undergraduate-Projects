
package hospital;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.print.Printable;
import java.awt.print.PageFormat;
import java.awt.print.PrinterJob;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class outdoor_bill extends JFrame {

  Connection connection;

  public long out_id=0;
  String names="",medicine="",depts="",docs="",dates="";
  long id=0,age=0;
  JLabel jLabel2 = new JLabel();
  JPanel jPanel4 = new JPanel();
  JPanel jPanel2 = new JPanel();
  JLabel Hospital_name1 = new JLabel();
  JLabel Hospital_phone = new JLabel();
  JLabel Hospital_address = new JLabel();
  JLabel Hospital_web_address = new JLabel();
  JPanel jPanel1 = new JPanel();
  JButton jButton1 = new JButton();
  JButton jButton2 = new JButton();
  JScrollPane jScrollPane1 = new JScrollPane();
  JScrollPane jScrollPane2 = new JScrollPane();
  JTextArea area = new JTextArea();
  PrinterJob job;

  public outdoor_bill() {
    try {
      jbInit();
      setSize(600,450);
      setLocation(110,80);
      show();

      Statement stat;
      ResultSet rset;
      String sql="";
      boolean insertResult1,insertResult2,insertResult3,insertResult4;
      connection = Main.connection;

        String str="";
        sql = "select outdoor_id from id_print";
        stat = connection.createStatement();
        rset = stat.executeQuery(sql);
        while(rset.next())
        out_id = Integer.parseInt(rset.getString("outdoor_id"));
        stat.close();



        ///////////////////// generating patient infomations////////////////////////


        sql = "select serial,name,dept,doctor,age,medicine from outdoor_patient where serial = "+out_id+" " ;
        stat = connection.createStatement();
        rset = stat.executeQuery(sql);
        while (rset.next()) {
          id = Integer.parseInt(rset.getString("serial"));
          names = rset.getString("name");
          depts = rset.getString("dept");
          docs = rset.getString("doctor");
          age = Integer.parseInt(rset.getString("age"));
          medicine = rset.getString("medicine");

        }



       sql = "select to_char(sysdate,'DD-MM-YYYY') from dual " ;
       stat = connection.createStatement();
       rset = stat.executeQuery(sql);
       while (rset.next()) {
       dates = rset.getString(1);
      }

      String out="";

      out += "Serial = "+ id +"            Date= "+dates+"\n";
      out += "Name = " + names + "\n";
      out += "Age = " + age + "\n";
      out += "Department = " + depts + "\n";
      out += "Doctor = " + docs + "\n\n";
      out += "Medicine\n--------\n" + medicine + "\n";
      out += "\nSign\n------\n\n\n";

      area.setText(out);
      area.setEditable(false);


    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    jPanel4.setLayout(null);
    jPanel4.setBounds(new Rectangle(10, 112, 575, 35));
    jPanel4.setBackground(new Color(173, 201, 139));
    jPanel4.setBorder(BorderFactory.createLoweredBevelBorder());
    jLabel2.setBounds(new Rectangle(180, 6, 218, 25));
    jLabel2.setText("Outdoor Patient Bill");
    jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel2.setFont(new java.awt.Font("Book Antiqua", 1, 14));
    this.getContentPane().setLayout(null);
    jPanel2.setBackground(new Color(173, 201, 139));
    jPanel2.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel2.setBounds(new Rectangle(10, 10, 576, 96));
    jPanel2.setLayout(null);
    Hospital_name1.setBounds(new Rectangle(21, 12, 553, 28));
    Hospital_name1.setText("JALALABAD RAGIB-RABEYA MEDICAL COLLEGE HOSPITAL");
    Hospital_name1.setForeground(SystemColor.desktop);
    Hospital_name1.setFont(new java.awt.Font("Dialog", 1, 18));
    Hospital_phone.setFont(new java.awt.Font("Dialog", 1, 12));
    Hospital_phone.setText("PHONE: 719090");
    Hospital_phone.setBounds(new Rectangle(252, 72, 94, 20));
    Hospital_address.setFont(new java.awt.Font("Dialog", 1, 12));
    Hospital_address.setText("RAGIB-RABEYA MEDICAL COLLEGE ROAD, PATHANTULA, SYLHET. ");
    Hospital_address.setBounds(new Rectangle(124, 39, 377, 17));
    Hospital_web_address.setFont(new java.awt.Font("Dialog", 1, 12));
    Hospital_web_address.setText("WEB: www.jrrmc.edu.bd      EMAIL: jrrmc@btsnet.net");
    Hospital_web_address.setBounds(new Rectangle(154, 57, 302, 15));
    jPanel1.setBackground(new Color(173, 201, 139));
    jPanel1.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel1.setBounds(new Rectangle(10, 357, 576, 41));
    jPanel1.setLayout(null);
    jButton1.setBackground(new Color(173, 201, 139));
    jButton1.setBounds(new Rectangle(214, 8, 57, 22));
    jButton1.setFont(new java.awt.Font("Dialog", 1, 12));
    jButton1.setBorder(BorderFactory.createRaisedBevelBorder());
    jButton1.setMnemonic('P');
    jButton1.setText("PRINT");
    jButton1.addActionListener(new outdoor_bill_jButton1_actionAdapter(this));
    jButton2.setBackground(new Color(173, 201, 139));
    jButton2.setBounds(new Rectangle(345, 7, 63, 25));
    jButton2.setFont(new java.awt.Font("Dialog", 1, 12));
    jButton2.setBorder(BorderFactory.createRaisedBevelBorder());
    jButton2.setBorderPainted(true);
    jButton2.setMnemonic('E');
    jButton2.setText("EXIT");
    jButton2.addActionListener(new outdoor_bill_jButton2_actionAdapter(this));
    this.getContentPane().setBackground(new Color(173, 201, 139));
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setResizable(false);
    this.setTitle("OUTDOOR BILL");
    jScrollPane1.setBounds(new Rectangle(138, 206, 2, 2));
    jScrollPane2.setBorder(BorderFactory.createLoweredBevelBorder());
    jScrollPane2.setBounds(new Rectangle(11, 153, 570, 197));
    area.setBackground(SystemColor.textHighlightText);
    area.setFont(new java.awt.Font("Dialog", 1, 12));
    this.getContentPane().add(jPanel2, null);
    jPanel2.add(Hospital_name1, null);
    jPanel2.add(Hospital_address, null);
    jPanel2.add(Hospital_web_address, null);
    jPanel2.add(Hospital_phone, null);
    this.getContentPane().add(jPanel4, null);
    jPanel4.add(jLabel2, null);
    this.getContentPane().add(jPanel1, null);
    jPanel1.add(jButton2, null);
    jPanel1.add(jButton1, null);
    this.getContentPane().add(jScrollPane1, null);
    this.getContentPane().add(jScrollPane2, null);
    jScrollPane2.getViewport().add(area, null);
  }

  public static void main(String[] args) {
    outdoor_bill outdoor_bill = new outdoor_bill();
  }


  public class Test implements Printable{


 public int print(Graphics g, PageFormat pageFormat, int pageIndex) {
   if (pageIndex >= 1)
       return Printable.NO_SUCH_PAGE;

     String str1,str2,str3,str4,str5,str6,str7,str8,str9,str10;

      str1 = "Serial = "+id +"              Date= "+dates;
      str2 = "Name = " + names;
      str3 = "Age = " + age ;
      str4 = "Department = " + depts;
      str5 = "Doctor = " + docs;
      str6 = "Medicine";
      str7= "-----------";
      str8 = medicine;
      str9 = "Sign";
      str10 = "-------";


      g.drawString(str1,100,100);
      g.drawString(str2,100,150);
            g.drawString(str3,100,170);
            g.drawString(str4,100,190);
            g.drawString(str5,100,210);
            g.drawString(str6,100,240);
            g.drawString(str7,100,250);
            g.drawString(str8,100,270);
            g.drawString(str9,100,320);
            g.drawString(str10,100,330);





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



  void jButton2_actionPerformed(ActionEvent e) {
     dispose();
  }

  void jButton1_actionPerformed(ActionEvent e) {
    print_it();


  }
}

class outdoor_bill_jButton2_actionAdapter implements java.awt.event.ActionListener {
  outdoor_bill adaptee;

  outdoor_bill_jButton2_actionAdapter(outdoor_bill adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton2_actionPerformed(e);
  }
}

class outdoor_bill_jButton1_actionAdapter implements java.awt.event.ActionListener {
  outdoor_bill adaptee;

  outdoor_bill_jButton1_actionAdapter(outdoor_bill adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton1_actionPerformed(e);
  }
}
