package hospital;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.awt.print.Printable;
import java.awt.print.PageFormat;
import java.awt.print.PrinterJob;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class discharge_letter extends JFrame{

 Connection connection;
 public String str1,str2,str3,str4,str5,str6,str7,str8,str9,str10;
 public String str11,str12,str13,str14,str15,str16,str17,str18,str19,str20,str21,str22;

 String names="",husband="",father="",address="",diseases="",depts="",docs="";
         long age=0,nward=0,nbed=0,ncabin=0,ngb=0,npb=0;
         String adm_date="",rel_date="";
         double mbed=0,mcabin=0,mot=0,mdelivery=0,mpack=0,mpo=0,mnebu=0,moxy=0,mpatho=0,mradio=0,mecg=0,murine=0,mdress=0,mmisc=0,mservice=0;
               double mtotal=0,mdiscount=0,mfinal_amount=0,mdue=0,madvance=0;
double total_dis=0,service=0,final_total=0,bal=0;


  public long in_id=0;
  public String bill_area="",letter_area="";
  JPanel jPanel2 = new JPanel();
  JLabel Hospital_name1 = new JLabel();
  JLabel Hospital_phone = new JLabel();
  JLabel Hospital_address = new JLabel();
  JLabel Hospital_web_address = new JLabel();
  JButton jButton2 = new JButton();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JButton print_letter = new JButton();
  JButton print_bill = new JButton();
  JScrollPane jScrollPane1 = new JScrollPane();
  JScrollPane jScrollPane2 = new JScrollPane();
  JTextArea area_letter = new JTextArea();
  JTextArea area_bill = new JTextArea();
  PrinterJob job,job1 ;

  public discharge_letter() {
    try {
      jbInit();
      setSize(620,510);
      setLocation(100,60);
      show();





      Statement stat;
      ResultSet rset;
      String sql="";
      boolean insertResult1,insertResult2,insertResult3,insertResult4;
      connection = Main.connection;

         String str="";
         sql = "select indoor_id from id_print";
         stat = connection.createStatement();
         rset = stat.executeQuery(sql);
         while(rset.next())
         in_id = Integer.parseInt(rset.getString("indoor_id"));
         stat.close();



         ///////////////////// generating patient infomations////////////////////////


         sql = "select patient_name,patient_father_name,patient_husband_name,patient_age from patient_names_age where patient_id = "+in_id+" " ;
         stat = connection.createStatement();
         rset = stat.executeQuery(sql);
         while (rset.next()) {
           names = rset.getString("patient_name");

           father = rset.getString("patient_father_name");
           husband = rset.getString("patient_husband_name");
           age = Integer.parseInt(rset.getString("patient_age"));
         }

         System.out.println(names);

         sql = "select present_add from patient_address where patient_id = "+in_id+" " ;
         stat = connection.createStatement();
         rset = stat.executeQuery(sql);
         while (rset.next()) {
           address = rset.getString("present_add");
         }

         sql = "select disease,dept,doc from patient_relative_dept_doc where patient_id = "+in_id+" " ;
         stat = connection.createStatement();
         rset = stat.executeQuery(sql);
         while (rset.next()) {
           diseases = rset.getString("disease");
           depts = rset.getString("dept");
           docs = rset.getString("doc");
         }

         sql = "select ward,bed,cabin,gb,pb from patient_seat where patient_id = "+in_id+" " ;
         stat = connection.createStatement();
         rset = stat.executeQuery(sql);
         while (rset.next()) {
           nward = Integer.parseInt(rset.getString("ward"));
           nbed = Integer.parseInt(rset.getString("bed"));
           ncabin = Integer.parseInt(rset.getString("cabin"));
           ngb = Integer.parseInt(rset.getString("gb"));
           npb = Integer.parseInt(rset.getString("pb"));
         }

         sql = "select to_char(adm_date,'DD-MM-YYYY') from old_patient_info where id = "+in_id+" " ;
         stat = connection.createStatement();
         rset = stat.executeQuery(sql);
         while (rset.next()) {
         adm_date = rset.getString(1);
        }

        //System.out.println(adm_date);

        sql = "select to_char(rel_date,'DD-MM-YYYY') from old_patient_info where id = "+in_id+" " ;
        stat = connection.createStatement();
        rset = stat.executeQuery(sql);
        while (rset.next()) {
        rel_date = rset.getString(1);
       }
        //System.out.println(rel_date);

         ///////////////////////////////////////////////

        ///////////////////Generating Bill Information/////////////////////



         //System.out.println(id);


         sql = "select bed,cabin,ot,delivery,pack,po,nebu,oxyzen from bill_1 where patient_id = "+in_id+" " ;
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

         sql = "select patho,radio,ecg,urine,dressing,misc,service from bill_2 where patient_id = "+in_id+" " ;
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

         sql = "select total,discount,final_amount,due from bill_money where patient_id = "+in_id+" " ;
         stat = connection.createStatement();
         rset = stat.executeQuery(sql);
         while (rset.next()) {
          mtotal = Double.parseDouble(rset.getString("total"));
          mdiscount = Double.parseDouble(rset.getString("discount"));
          mfinal_amount = Double.parseDouble(rset.getString("final_amount"));
          mdue = Double.parseDouble(rset.getString("due"));
        }

         sql = "select advance from bill_advance where patient_id = "+in_id+" " ;
         stat = connection.createStatement();
         rset = stat.executeQuery(sql);
         while (rset.next()) {
          madvance = Double.parseDouble(rset.getString("advance"));
        }


        /////////////////////////////////////////////////////////////////////////////

        //////////////creating discharge letter////////////////
        letter_area += "DISCHARGE LETTER\n" + "----------------\n\n" ;
        letter_area += "Name = "+ names + "\n" ;

        letter_area += "Age = "+ age + "\n" ;
        letter_area += "ID = "+ in_id + "\n" ;
        if(father.equals(""))
        letter_area += "Husband Name = "+ husband + "\n" ;

        else
          letter_area += "Father Name = "+ father + "\n" ;
        letter_area += "Address = "+ address + "\n" ;
        letter_area += "Department = "+ depts + "\n" ;
        if(nward!=0)
        letter_area += "Ward = "+ nward + "\n" ;
        if(nbed!=0)
        letter_area += "Bed = "+ nbed + "\n" ;
        if(ncabin!=0)
        letter_area += "Cabin = "+ ncabin + "\n" ;
        if(ngb!=0)
        letter_area += "General Bed = "+ ngb + "\n" ;
        if(npb!=0)
        letter_area += "Paying Bed = "+ npb + "\n" ;
        letter_area += "Admission Date = "+ adm_date + "\n" ;
        letter_area += "Release Date = "+ rel_date + "\n" ;
        letter_area += "Doctor = "+ docs + "\n" ;
        letter_area += "Disease = "+ diseases + "\n" ;

        letter_area += "\nSign of the Authority\n--------------------\n" ;

        area_letter.setText(letter_area);


        /////////////////////creating final bill///////////////////////////////
        bill_area += "FINAL BILL\n" + "----------\n\n" ;
        bill_area += "Name = " + names + "\n" ;
        bill_area += "ID = " + in_id + "\n\n";
        bill_area += "Final Bill\n" + "----------\n";

        // double mbed=0,mcabin=0,mot=0,mdelivery=0,mpack=0,mpo=0,mnebu=0,moxy=0,mpatho=0,mradio=0,mecg=0,murine=0,mdress=0,mmisc=0,mservice=0;
         //double mtotal=0,mdiscount=0,mfinal_amount=0,mdue=0,madvance=0;
        if(mbed!=0)
          bill_area += "Bed Charge = " + mbed + "\n" ;
        if(mcabin!=0)
          bill_area += "Cabin Charge = " + mcabin + "\n" ;
        if(mot!=0)
          bill_area += "OT Charge = " + mot + "\n" ;
        if(mdelivery!=0)
          bill_area += "Delivery Charge = " + mdelivery + "\n" ;
        if(mpack!=0)
          bill_area += "Package Charge = " + mpack + "\n" ;
        if(mpo!=0)
          bill_area += "PO Charge = " + mpo + "\n" ;
        if(mnebu!=0)
          bill_area += "Nebulization Charge = " + mnebu + "\n" ;
        if(moxy!=0)
          bill_area += "Oxyzen Charge = " + moxy + "\n" ;
        if(mpatho!=0)
          bill_area += "Pathology Charge = " + mpatho + "\n" ;
        if(mradio!=0)
          bill_area += "Radiology Charge = " + mradio + "\n" ;
        if(mecg!=0)
          bill_area += "E.C.G. Charge = " + mecg + "\n" ;
        if(murine!=0)
          bill_area += "Bed Side Urine Test Charge = " + murine + "\n" ;
        if(mdress!=0)
          bill_area += "Dressing Charge = " + mdress + "\n" ;

        bill_area += "----------\n";


        total_dis = mtotal - mdiscount;
        service = (total_dis*10)/100;
        final_total = (total_dis + service);
        bal = final_total - madvance;

        bill_area += "  Total = " + mtotal + "\n";
        bill_area += "- Discount = " + mdiscount + "\n";
        bill_area += "----------\nTotal = " + total_dis + "\n";
        bill_area += "+ Service Charge(10%) = " + service + "\n" ;
        bill_area += "---------------------\nFinal Total = " + final_total + "\n";
        bill_area += "Advance Paid = " + madvance + "\n";
        bill_area += "Balance = " + bal + "\n";

        letter_area += "\n\nSign of the AUTHORITY\n";
        letter_area += "-----------------------\n" ;

        area_bill.setText(bill_area);

        area_letter.setEditable(false);
        area_bill.setEditable(false);


         ////////////////////////////////////////////////////////
         //deleting all bills
       stat = connection.createStatement();
       sql = " delete from bill_advance where patient_id="+in_id+" ";
       insertResult2 = stat.execute(sql);
       stat.close();

       stat = connection.createStatement();
       sql = " delete from bill_money where patient_id="+in_id+" ";
       insertResult3 = stat.execute(sql);
       stat.close();

       stat = connection.createStatement();
       sql = " delete from bill_2 where patient_id="+in_id+" ";
       insertResult3 = stat.execute(sql);
       stat.close();

       stat = connection.createStatement();
       sql = " delete from bill_1 where patient_id="+in_id+" ";
       insertResult3 = stat.execute(sql);
       stat.close();
       /////////////////////////////////////////////////////
      stat = connection.createStatement();
       sql = " delete from patient_adm_date where patient_id="+in_id+" ";
       insertResult3 = stat.execute(sql);
       stat.close();

       stat = connection.createStatement();
       sql = " delete from patient_seat where patient_id="+in_id+" ";
       insertResult3 = stat.execute(sql);
       stat.close();

       stat = connection.createStatement();
       sql = " delete from patient_relative_dept_doc where patient_id="+in_id+" ";
       insertResult3 = stat.execute(sql);
       stat.close();

       stat = connection.createStatement();
       sql = " delete from patient_address where patient_id="+in_id+" ";
       insertResult3 = stat.execute(sql);
       stat.close();

       stat = connection.createStatement();
       sql = " delete from patient_names_age where patient_id="+in_id+" ";
       insertResult3 = stat.execute(sql);
       stat.close();


//      ///////////////////////////////////////////////////////

      //flagging 1
    if (ncabin!=0) {
      stat = connection.createStatement();
      sql = " update cabin_info set flag=1 where cabin_no = " +ncabin+ " ";
      insertResult3 = stat.execute(sql);
      stat.close();
    }

    else if (nward!=0 && nbed!=0) {
      stat = connection.createStatement();
      sql = " update ward_info set flag=1 where ( bed_no = " +
          nbed+ "  AND  ward_no = " + nward + ") ";
      insertResult3 = stat.execute(sql);
      stat.close();
    }

    else if (ngb!=0) {
      stat = connection.createStatement();
      sql = " update gb_info set flag=1 where gb_no = " +ngb + " ";
      insertResult3 = stat.execute(sql);
      stat.close();
    }

    else if (npb != 0) {
      stat = connection.createStatement();
      sql = " update pb_info set flag=1 where pb_no = " + npb + " ";
      insertResult3 = stat.execute(sql);
      stat.close();
    }


  }


    catch(Exception ex) {
     ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    jPanel2.setLayout(null);
    jPanel2.setBounds(new Rectangle(7, 9, 596, 109));
    jPanel2.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel2.setBackground(new Color(173, 201, 139));
    jPanel2.setEnabled(true);
    this.getContentPane().setBackground(new Color(173, 201, 139));
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setResizable(false);
    this.setTitle("DISCHARGE LETTER");
    this.getContentPane().setLayout(null);
    Hospital_name1.setBounds(new Rectangle(21, 12, 553, 28));
    Hospital_name1.setText("JALALABAD RAGIB-RABEYA MEDICAL COLLEGE HOSPITAL");
    Hospital_name1.setForeground(SystemColor.desktop);
    Hospital_name1.setFont(new java.awt.Font("Dialog", 1, 18));
    Hospital_phone.setFont(new java.awt.Font("Dialog", 1, 12));
    Hospital_phone.setText("PHONE: 719090");
    Hospital_phone.setBounds(new Rectangle(228, 78, 94, 20));
    Hospital_address.setFont(new java.awt.Font("Dialog", 1, 12));
    Hospital_address.setText("RAGIB-RABEYA MEDICAL COLLEGE ROAD, PATHANTULA, SYLHET. ");
    Hospital_address.setBounds(new Rectangle(103, 40, 377, 17));
    Hospital_web_address.setFont(new java.awt.Font("Dialog", 1, 12));
    Hospital_web_address.setText("WEB: www.jrrmc.edu.bd      EMAIL: jrrmc@btsnet.net");
    Hospital_web_address.setBounds(new Rectangle(134, 59, 302, 15));
    jButton2.setBackground(new Color(173, 201, 139));
    jButton2.setBounds(new Rectangle(264, 446, 80, 28));
    jButton2.setFont(new java.awt.Font("Dialog", 1, 12));
    jButton2.setBorder(BorderFactory.createRaisedBevelBorder());
    jButton2.setMnemonic('E');
    jButton2.setText("CLOSE");
    jButton2.addActionListener(new discharge_letter_jButton2_actionAdapter(this));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1.setText("DISCHARGE LETTER");
    jLabel1.setBounds(new Rectangle(80, 125, 163, 20));
    jLabel2.setBounds(new Rectangle(437, 125, 119, 20));
    jLabel2.setText("FINAL BILL");
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 12));
    print_letter.setText("PRINT");
    print_letter.addActionListener(new discharge_letter_print_letter_actionAdapter(this));
    print_letter.setMnemonic('P');
    print_letter.setBorder(BorderFactory.createRaisedBevelBorder());
    print_letter.setFont(new java.awt.Font("Dialog", 1, 12));
    print_letter.setBackground(new Color(173, 201, 139));
    print_letter.setBounds(new Rectangle(95, 441, 79, 28));
    print_bill.setText("PRINT");
    print_bill.addActionListener(new discharge_letter_print_bill_actionAdapter(this));
    print_bill.setMnemonic('P');
    print_bill.setBorder(BorderFactory.createRaisedBevelBorder());
    print_bill.setFont(new java.awt.Font("Dialog", 1, 12));
    print_bill.setBackground(new Color(173, 201, 139));
    print_bill.setBounds(new Rectangle(434, 446, 79, 28));
    jScrollPane1.setBorder(BorderFactory.createLoweredBevelBorder());
    jScrollPane1.setBounds(new Rectangle(10, 150, 293, 283));
    jScrollPane2.setBounds(new Rectangle(309, 151, 293, 283));
    jScrollPane2.setBorder(BorderFactory.createLoweredBevelBorder());
    area_letter.setFont(new java.awt.Font("Dialog", 1, 12));
    area_letter.setText("");
    area_bill.setFont(new java.awt.Font("Dialog", 1, 12));
    this.getContentPane().add(jPanel2, null);
    jPanel2.add(Hospital_name1, null);
    jPanel2.add(Hospital_address, null);
    jPanel2.add(Hospital_web_address, null);
    jPanel2.add(Hospital_phone, null);
    this.getContentPane().add(jLabel1, null);
    this.getContentPane().add(jLabel2, null);
    this.getContentPane().add(jScrollPane1, null);
    jScrollPane1.getViewport().add(area_letter, null);
    this.getContentPane().add(jScrollPane2, null);
    jScrollPane2.getViewport().add(area_bill, null);
    this.getContentPane().add(print_letter, null);
    this.getContentPane().add(jButton2, null);
    this.getContentPane().add(print_bill, null);

  }

  public static void main(String[] args)
  {
    discharge_letter discharge_letter = new discharge_letter();
  }

  public class Test implements Printable{


 public int print(Graphics g, PageFormat pageFormat, int pageIndex) {
   if (pageIndex >= 1)
       return Printable.NO_SUCH_PAGE;



        str1 = "                      FINAL BILL";
        str2 = "                      -------------";
        str3 = "Name : "+names;
        str4 = "ID   : "+in_id;



        g.drawString(str1,100,100);
        g.drawString(str2,100,110);
        g.drawString(str3,100,130);
        g.drawString(str4,100,150);


            str1 = "Bed Charge             ------- " + mbed;
            str2 = "Cabin Charge          ------- " + mcabin;
            str3 = "OT Charge              ------- " + mot  ;
            str4 = "Delivery Charge       ------- " + mdelivery ;
            str5 = "Package Charge       ------- " + mpack ;
            str6 = "PO Charge               ------- " + mpo ;
            str7 = "Nebulization Charge  ------- " + mnebu ;
            str8 = "Oxyzen Charge         ------- " + moxy ;
            str9 = "Pathology Charge      ------- " + mpatho;
            str10 = "Radiology Charge      ------- " + mradio;
            str11 = "E.C.G. Charge           ------- " + mecg;
            str12 = "Urine Test Charge      ------- " + murine;
            str13 = "Dressing Charge         ------- " + mdress;

            total_dis = mtotal - mdiscount;
            service = (total_dis*10)/100;
            final_total = (total_dis + service);
            bal = final_total - madvance;

            str14 = "   Total                         ------- " + mtotal;
            str15 = "(-)Discount                  ------- " + mdiscount;
            str16 = "   Remaining Total       ------- " + total_dis;
            str17 = "(+)Service Charge(10%) ---- " + service;
            str18 = "   Final Total                 ------- " + final_total;
            str19 = "   Advance Paid            ------- " + madvance;
            str20 = "   Balance =                  ------- " + bal;
            str21 = "Sign of the Authority";
            str22 = "-----------------------";

            g.drawString(str1,100,180);
            g.drawString(str2,100,200);
            g.drawString(str3,100,220);
            g.drawString(str4,100,240);
            g.drawString(str5,100,260);
            g.drawString(str6,100,280);
            g.drawString(str7,100,300);
            g.drawString(str8,100,320);
            g.drawString(str9,100,340);
            g.drawString(str10,100,360);
            g.drawString(str11,100,380);
            g.drawString(str12,100,400);
            g.drawString(str13,100,420);
            g.drawString(str14,100,440);
            g.drawString(str15,100,460);
            g.drawString(str16,100,480);
            g.drawString(str17,100,500);
            g.drawString(str18,100,520);
            g.drawString(str19,100,540);
            g.drawString(str20,100,560);
            g.drawString(str21,100,600);
            g.drawString(str22,100,610);




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


////////////////////////////////////

  public class Print implements Printable{


public int print(Graphics g, PageFormat pageFormat, int pageIndex) {
if (pageIndex >= 1)
    return Printable.NO_SUCH_PAGE;

  //////////////creating discharge letter////////////////

    str1 = "                      DISCHARGE LETTER";
    str2 = "                      -------------------";
    str3 = "Name : "+names;
    str4 = "ID   : "+in_id;



    g.drawString(str1,100,100);
    g.drawString(str2,100,110);
    g.drawString(str3,100,130);
    g.drawString(str4,100,150);




     if(father.equals(""))
      str5= "Husband Name = "+ husband  ;
     else
      str5= "Father Name = "+ father;


     str6= "Address = "+ address  ;
     str7= "Department = "+ depts  ;
     if(nward!=0)
     str8= "Ward =   "+ nward +"     " +"Bed =   "+ nbed;
     else if(ncabin!=0)
     str8= "Cabin = "+ ncabin  ;
     else if(ngb!=0)
     str8= "General Bed = "+ ngb  ;
     else
     str8 = "Paying Bed = "+ npb ;
     str9= "Admission Date = "+ adm_date;
     str10= "Release Date   = "+ rel_date ;
     str11= "Doctor = "+ docs ;
     str12= "Disease = "+ diseases ;
     str13= "Sign of the Authority" ;
     str14= "-----------------------";

     g.drawString(str5,100,170);
     g.drawString(str6,100,190);
     g.drawString(str7,100,210);
     g.drawString(str8,100,230);
     g.drawString(str9,100,250);
     g.drawString(str10,100,270);
     g.drawString(str11,100,290);
     g.drawString(str12,100,310);
     g.drawString(str13,100,350);
     g.drawString(str14,100,360);



   return Printable.PAGE_EXISTS;

}

}

public void print_to(){

job = PrinterJob.getPrinterJob();
job.setPrintable(new Print());
if(job.printDialog())
{

 try{
      int flag =1;
      job.print();
    }
catch (Exception abc)
  {
    JOptionPane.showMessageDialog( null, "Error printing page");
  }
}

}



    //////////////////////////




  void jButton2_actionPerformed(ActionEvent e) {
          dispose();
  }

  void print_letter_actionPerformed(ActionEvent e) {
   print_to();

  }

  void print_bill_actionPerformed(ActionEvent e) {
    print_it();




  }
}



class discharge_letter_jButton2_actionAdapter implements java.awt.event.ActionListener {
  discharge_letter adaptee;

  discharge_letter_jButton2_actionAdapter(discharge_letter adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton2_actionPerformed(e);
  }
}

class discharge_letter_print_letter_actionAdapter implements java.awt.event.ActionListener {
  discharge_letter adaptee;

  discharge_letter_print_letter_actionAdapter(discharge_letter adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.print_letter_actionPerformed(e);
  }
}

class discharge_letter_print_bill_actionAdapter implements java.awt.event.ActionListener {
  discharge_letter adaptee;

  discharge_letter_print_bill_actionAdapter(discharge_letter adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.print_bill_actionPerformed(e);
  }
}
