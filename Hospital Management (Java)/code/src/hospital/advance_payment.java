
package hospital;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.ButtonGroup;
import java.util.Date;


public class advance_payment extends JFrame {

  Connection connection;
  String dat="";

  JLabel jLabel1 = new JLabel();
  JPanel jPanel3 = new JPanel();
  JLabel Hospital_name1 = new JLabel();
  JRadioButton pb = new JRadioButton();
  JScrollPane jScrollPane1 = new JScrollPane();
  JRadioButton ward = new JRadioButton();
  JLabel jLabel7 = new JLabel();
  JRadioButton cabin = new JRadioButton();
  JScrollPane jScrollPane5 = new JScrollPane();
  JPanel jPanel5 = new JPanel();
  JFormattedTextField dates = new JFormattedTextField();
  JRadioButton gb = new JRadioButton();
  JScrollPane jScrollPane4 = new JScrollPane();
  JLabel jLabel6 = new JLabel();
  JTextField name_text = new JTextField();
  JScrollPane jScrollPane3 = new JScrollPane();
  JScrollPane jScrollPane2 = new JScrollPane();
  JLabel jLabel5 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JTextField amount = new JTextField();
  JButton jButton2 = new JButton();
  JButton jButton1 = new JButton();
  JButton jButton3 = new JButton();
  JPanel jPanel6 = new JPanel();
  JList bed_list = new JList();
  JList ward_list = new JList();
  JList cabin_list = new JList();
  JList gb_list = new JList();
  JList pb_list = new JList();
  ButtonGroup group = new ButtonGroup();
  JLabel Hospital_name2 = new JLabel();
  Date dated;

  public advance_payment() {
    try {
      jbInit();
      setSize(600,475);
      setLocation(100,60);
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
           dates.setEditable(false);


           stat.close();








    }
    catch(Exception ex) {
      ex.printStackTrace();
    }

    dates.setEditable(false);
    name_text.setEditable(false);


    //listener for ward_list
    ward_list.addListSelectionListener(
        new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent e) {
        try {

          Statement stat;
          ResultSet rset;
          String sql;

          stat = connection.createStatement();
          sql = "select bed_no from ward_info where (flag=0 AND ward_no= " +
              ward_list.getSelectedValue() + ") order by bed_no";
          rset = stat.executeQuery(sql);
          int ct = 0, i;
          String bed_avail[] = new String[100];

          while (rset.next()) {
            bed_avail[ct] = rset.getString(1);
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
          JOptionPane.showMessageDialog(null, sqlException.getMessage(),
                                        "Database error",
                                        JOptionPane.ERROR_MESSAGE);
        }

      }
    }
    );
//////////////////////////

//listener for cabin_list
    cabin_list.addListSelectionListener(
        new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent e) {
        try {

          Statement stat;
          ResultSet rset;
          String sql;

          stat = connection.createStatement();
          sql = "select patient_names_age.patient_name from patient_names_age where  patient_id = (select patient_seat.patient_id from patient_seat where cabin= " +
              cabin_list.getSelectedValue() + ")";
          rset = stat.executeQuery(sql);
          String str = "";
          while (rset.next()) {
            str += rset.getString("patient_name");
          }

          name_text.setText(str);
          stat.close();
          rset.close();
        }
        catch (SQLException sqlException) {
          JOptionPane.showMessageDialog(null, sqlException.getMessage(),
                                        "Database error",
                                        JOptionPane.ERROR_MESSAGE);
        }

      }
    }
    );
////////////////////////////////////////
//listener for gb_list
    gb_list.addListSelectionListener(
        new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent e) {
        try {

          Statement stat;
          ResultSet rset;
          String sql;


          stat = connection.createStatement();
          sql = "select patient_names_age.patient_name from patient_names_age where  patient_id = (select patient_seat.patient_id from patient_seat where gb= " +
              gb_list.getSelectedValue() + ")";
          rset = stat.executeQuery(sql);
          String str = "";
          while (rset.next()) {
            str += rset.getString("patient_name");
          }

          name_text.setText(str);
          stat.close();
          rset.close();
        }
        catch (SQLException sqlException) {
          JOptionPane.showMessageDialog(null, sqlException.getMessage(),
                                        "Database error",
                                        JOptionPane.ERROR_MESSAGE);
        }

      }
    }
    );
////////////////////////////////////////
//listener for pb_list
    pb_list.addListSelectionListener(
        new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent e) {
        try {

          Statement stat;
          ResultSet rset;
          String sql;

          stat = connection.createStatement();
          sql = "select patient_names_age.patient_name from patient_names_age where  patient_id = (select patient_seat.patient_id from patient_seat where pb=" +
              pb_list.getSelectedValue() + ")";
          rset = stat.executeQuery(sql);
          String str = "";
          while (rset.next()) {
            str += rset.getString("patient_name");
          }

          name_text.setText(str);

          stat.close();
          rset.close();
        }
        catch (SQLException sqlException) {
          JOptionPane.showMessageDialog(null, sqlException.getMessage(),
                                        "Database error",
                                        JOptionPane.ERROR_MESSAGE);
        }

      }
    }
    );
////////////////////////////////////////
    //listener for bed_list
    bed_list.addListSelectionListener(
        new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent e) {
        try {

          Statement stat;
          ResultSet rset;
          String sql;

          stat = connection.createStatement();
          sql = "select patient_names_age.patient_name from patient_names_age where  patient_id = (select patient_seat.patient_id from patient_seat where (ward =" +
              ward_list.getSelectedValue() + " AND bed = " +
              bed_list.getSelectedValue() + ") ) ";
          rset = stat.executeQuery(sql);
          String str = "";
          while (rset.next()) {
            str += rset.getString("patient_name");
          }

          name_text.setText(str);
          stat.close();
          rset.close();
        }
        catch (SQLException sqlException) {
          JOptionPane.showMessageDialog(null, sqlException.getMessage(),
                                        "Database error",
                                        JOptionPane.ERROR_MESSAGE);
        }

      }
    }
    );




  }

  void jbInit() throws Exception {
    this.getContentPane().setLayout(null);
    jLabel1.setFont(new java.awt.Font("Book Antiqua", 1, 14));
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("Advance Payment");
    jLabel1.setBounds(new Rectangle(158, 4, 218, 25));
    jPanel3.setBackground(new Color(173, 201, 139));
    jPanel3.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel3.setBounds(new Rectangle(57, 44, 474, 35));
    jPanel3.setLayout(null);
    this.getContentPane().setBackground(new Color(173, 201, 139));
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setResizable(false);
    this.setTitle("ADVANCE PAYMENT");
    pb.setBounds(new Rectangle(262, 43, 98, 23));
    pb.addActionListener(new advance_payment_pb_actionAdapter(this));
    pb.setBackground(new Color(173, 201, 139));
    pb.setText("PAYING BED");
    jScrollPane1.setBounds(new Rectangle(102, 19, 59, 20));
    ward.setBounds(new Rectangle(15, 15, 67, 27));
    ward.addActionListener(new advance_payment_ward_actionAdapter(this));
    ward.setBackground(new Color(173, 201, 139));
    ward.setText("WARD");
    jLabel7.setBounds(new Rectangle(192, 4, 38, 14));
    jLabel7.setText("BED");
    cabin.setBounds(new Rectangle(15, 42, 72, 23));
    cabin.addActionListener(new advance_payment_cabin_actionAdapter(this));
    cabin.setBackground(new Color(173, 201, 139));
    cabin.setText("CABIN");
    jScrollPane5.setBounds(new Rectangle(178, 19, 62, 20));
    jPanel5.setLayout(null);
    jPanel5.setBounds(new Rectangle(58, 97, 471, 217));
    jPanel5.setBackground(new Color(173, 201, 139));
    jPanel5.setBorder(BorderFactory.createLoweredBevelBorder());
    dates.setBackground(new Color(173, 201, 139));
    dates.setDisabledTextColor(SystemColor.activeCaption);
    dates.setFont(new java.awt.Font("SansSerif", 1, 13));
    dates.setForeground(SystemColor.activeCaption);
    dates.setText("");
    dates.setBounds(new Rectangle(321, 73, 124, 20));
    gb.setBackground(new Color(173, 201, 139));
    gb.setText("GENERAL BED");
    gb.setBounds(new Rectangle(260, 12, 106, 24));
    gb.addActionListener(new advance_payment_gb_actionAdapter(this));
    jScrollPane4.setBounds(new Rectangle(372, 43, 71, 20));
    jLabel6.setText("DATE");
    jLabel6.setBounds(new Rectangle(274, 72, 45, 23));
    name_text.setBackground(SystemColor.textHighlightText);
    name_text.setFont(new java.awt.Font("Dialog", 1, 12));
    name_text.setBorder(BorderFactory.createLoweredBevelBorder());
    name_text.setText("");
    name_text.setBounds(new Rectangle(93, 74, 149, 23));
    jScrollPane3.setFont(new java.awt.Font("Dialog", 1, 12));
    jScrollPane3.setBounds(new Rectangle(371, 14, 71, 20));
    jScrollPane2.setBounds(new Rectangle(102, 45, 60, 20));
    jLabel5.setText("NAME");
    jLabel5.setBounds(new Rectangle(22, 73, 56, 20));
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel2.setText("AMOUNT");
    jLabel2.setBounds(new Rectangle(26, 129, 84, 34));
    amount.setFont(new java.awt.Font("Dialog", 1, 11));
    amount.setText("");
    amount.setBounds(new Rectangle(108, 132, 132, 30));
    jButton2.setText("CLEAR");
    jButton2.addActionListener(new advance_payment_jButton2_actionAdapter(this));
    jButton2.setMnemonic('C');
    jButton2.setBorder(BorderFactory.createRaisedBevelBorder());
    jButton2.setFont(new java.awt.Font("Dialog", 1, 12));
    jButton2.setBackground(new Color(173, 201, 139));
    jButton2.setBounds(new Rectangle(204, 5, 75, 25));
    jButton1.setText("ENTRY");
    jButton1.addActionListener(new advance_payment_jButton1_actionAdapter(this));
    jButton1.setMnemonic('E');
    jButton1.setBorder(BorderFactory.createRaisedBevelBorder());
    jButton1.setFont(new java.awt.Font("Dialog", 1, 12));
    jButton1.setBackground(new Color(173, 201, 139));
    jButton1.setBounds(new Rectangle(65, 6, 72, 26));
    jButton3.setText("CLOSE");
    jButton3.addActionListener(new advance_payment_jButton3_actionAdapter(this));
    jButton3.setMnemonic('L');
    jButton3.setBorder(BorderFactory.createRaisedBevelBorder());
    jButton3.setFont(new java.awt.Font("Dialog", 1, 12));
    jButton3.setBackground(new Color(173, 201, 139));
    jButton3.setBounds(new Rectangle(338, 5, 66, 27));
    jPanel6.setLayout(null);
    jPanel6.setBounds(new Rectangle(57, 331, 472, 39));
    jPanel6.setBackground(new Color(173, 201, 139));
    jPanel6.setBorder(BorderFactory.createLoweredBevelBorder());
    Hospital_name2.setBounds(new Rectangle(31, 4, 560, 28));
    Hospital_name2.setText("JALALABAD RAGIB-RABEYA MEDICAL COLLEGE HOSPITAL");
    Hospital_name2.setForeground(SystemColor.desktop);
    Hospital_name2.setFont(new java.awt.Font("Dialog", 1, 18));
    ward_list.setFont(new java.awt.Font("Dialog", 1, 12));
    bed_list.setFont(new java.awt.Font("Dialog", 1, 12));
    cabin_list.setFont(new java.awt.Font("Dialog", 1, 12));
    gb_list.setFont(new java.awt.Font("Dialog", 1, 11));
    pb_list.setFont(new java.awt.Font("Dialog", 1, 12));
    jPanel5.add(cabin, null);
    jPanel5.add(jScrollPane2, null);
    jPanel5.add(jScrollPane1, null);
    jPanel5.add(ward, null);
    jPanel5.add(jScrollPane5, null);
    jPanel5.add(jLabel7, null);
    jPanel5.add(gb, null);
    jPanel5.add(pb, null);
    jPanel5.add(jScrollPane3, null);
    jPanel5.add(jScrollPane4, null);
    jPanel5.add(jLabel5, null);
    jPanel5.add(name_text, null);
    jPanel5.add(dates, null);
    jPanel5.add(jLabel6, null);
    jPanel5.add(jLabel2, null);
    jPanel5.add(amount, null);
    this.getContentPane().add(Hospital_name2, null);
    this.getContentPane().add(jPanel3, null);
    jPanel3.add(jLabel1, null);
    this.getContentPane().add(jPanel6, null);
    jPanel6.add(jButton1, null);
    jPanel6.add(jButton2, null);
    jPanel6.add(jButton3, null);
    this.getContentPane().add(Hospital_name1, null);
    this.getContentPane().add(jPanel5, null);
    jScrollPane5.getViewport().add(bed_list, null);
    jScrollPane1.getViewport().add(ward_list, null);
    jScrollPane2.getViewport().add(cabin_list, null);
    jScrollPane3.getViewport().add(gb_list, null);
    jScrollPane4.getViewport().add(pb_list, null);

    group.add(ward);
    group.add(cabin);
    group.add(gb);
    group.add(pb);


  }

  public static void main(String[] args) {
    advance_payment advance_payment = new advance_payment();
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
   name_text.setText("");


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
     //connection.close();
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
   name_text.setText("");


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
   name_text.setText("");


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
     //connection.close();
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
    name_text.setText("");


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
      //connection.close();
      rset.close();
    }
    catch (SQLException sqlException) {
      JOptionPane.showMessageDialog(null, sqlException.getMessage(),
                                    "Database error", JOptionPane.ERROR_MESSAGE);
    }


  }

  void jButton1_actionPerformed(ActionEvent e) {

      if(amount.getText().equals(""))
        JOptionPane.showMessageDialog(null,"Pls give the amount","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
     else if(!ward.isSelected() && !cabin.isSelected() && !gb.isSelected() && !pb.isSelected())
         JOptionPane.showMessageDialog(null,"select ward/cabin/paying bed/general bed","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
        else if( ward.isSelected() && ward_list.isSelectionEmpty() )
         JOptionPane.showMessageDialog(null,"select ward number","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
       else if( ( ward.isSelected() && !ward_list.isSelectionEmpty()) && bed_list.isSelectionEmpty())
         JOptionPane.showMessageDialog(null,"select a bed number","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
       else if( cabin.isSelected() && cabin_list.isSelectionEmpty() )
          JOptionPane.showMessageDialog(null,"select a cabin numebr","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
       else if( gb.isSelected() && gb_list.isSelectionEmpty() )
           JOptionPane.showMessageDialog(null,"select a general bed","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
       else if( pb.isSelected() && pb_list.isSelectionEmpty() )
                  JOptionPane.showMessageDialog(null,"select a paying bed","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
   else{

     try {

       Statement stat;
       ResultSet rset;
       String sql = "";

       if (ward.isSelected())
         sql = "select bill_advance.patient_id,advance from bill_advance where patient_id =  "+
                "(select patient_id from patient_seat where (ward= "+ward_list.getSelectedValue()+"  "+
               " AND bed = "+bed_list.getSelectedValue()+"  ) )";

       else if (cabin.isSelected())
         sql = "select bill_advance.patient_id,advance from bill_advance where patient_id =  "+
                "(select patient_id from patient_seat where cabin = "+cabin_list.getSelectedValue()+")  ";
      else if (gb.isSelected())
        sql = "select bill_advance.patient_id,advance from bill_advance where patient_id =  "+
                  "(select patient_id from patient_seat where cabin = "+gb_list.getSelectedValue()+")  ";
      else if (pb.isSelected())
        sql = "select bill_advance.patient_id,advance from bill_advance where patient_id =  "+
               "(select patient_id from patient_seat where cabin = "+pb_list.getSelectedValue()+")  ";



       stat = connection.createStatement();
       rset = stat.executeQuery(sql);
       int id=0;
       double past_money=0,new_money;
       while (rset.next()) {
         id = Integer.parseInt(rset.getString("patient_id"));
         past_money =  Double.parseDouble(rset.getString("advance"));
       }

       new_money = Double.parseDouble(amount.getText());
       double money = new_money;
       new_money = past_money + new_money;

       //System.out.println(id);
       //System.out.println(new_money);


       stat = connection.createStatement();
       sql = "delete from bill_advance where patient_id = "+id+"";
       boolean insertResult = stat.execute(sql);
       stat.close();

       stat = connection.createStatement();
       sql = "insert into bill_advance values("+id+","+new_money+")";
       boolean insertResult1 = stat.execute(sql);

       stat.close();

       rset.close();


       ///////updating income//////



       double indoor = 0;
       int outdoor = 0;
       String temp="";
       sql = "select indoor,outdoor from income where dates = '" + dat + "' ";
       stat = connection.createStatement();
       rset = stat.executeQuery(sql);
       while (rset.next()) {
         indoor = Integer.parseInt(rset.getString("indoor"));
         outdoor = Integer.parseInt(rset.getString("outdoor"));
         temp+=indoor;
       }

       if (temp.equals("")) {
         indoor = money;
         stat = connection.createStatement();
         sql = "insert into income values('" + dat + "'," + indoor + "," +
             outdoor + ")";
         insertResult = stat.execute(sql);
         stat.close();
       }
       else {
         indoor = indoor + money;
         stat = connection.createStatement();
         sql = "update income set indoor=" + indoor + " where dates='" + dat +
             "'";
         insertResult = stat.execute(sql);
         stat.close();

       }

       //////////////////////////




       JOptionPane.showMessageDialog(null,"Your Information have successfully saved.","CONFIRMATION MESSAGE",JOptionPane.INFORMATION_MESSAGE);

     }
     catch (SQLException sqlException) {
       JOptionPane.showMessageDialog(null, sqlException.getMessage(),"Database error",JOptionPane.ERROR_MESSAGE);
     }
   }





  }

  void jButton3_actionPerformed(ActionEvent e) {



    dispose();
  }

  void jButton2_actionPerformed(ActionEvent e) {

    name_text.setText("");
    String temp[]=new String[1];
    ward_list.setListData(temp);
    bed_list.setListData(temp);
    cabin_list.setListData(temp);
    gb_list.setListData(temp);
    pb_list.setListData(temp);
    amount.setText("");

  }
}

class advance_payment_ward_actionAdapter implements java.awt.event.ActionListener {
  advance_payment adaptee;

  advance_payment_ward_actionAdapter(advance_payment adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.ward_actionPerformed(e);
  }
}

class advance_payment_cabin_actionAdapter implements java.awt.event.ActionListener {
  advance_payment adaptee;

  advance_payment_cabin_actionAdapter(advance_payment adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.cabin_actionPerformed(e);
  }
}

class advance_payment_gb_actionAdapter implements java.awt.event.ActionListener {
  advance_payment adaptee;

  advance_payment_gb_actionAdapter(advance_payment adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.gb_actionPerformed(e);
  }
}

class advance_payment_pb_actionAdapter implements java.awt.event.ActionListener {
  advance_payment adaptee;

  advance_payment_pb_actionAdapter(advance_payment adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.pb_actionPerformed(e);
  }
}

class advance_payment_jButton1_actionAdapter implements java.awt.event.ActionListener {
  advance_payment adaptee;

  advance_payment_jButton1_actionAdapter(advance_payment adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton1_actionPerformed(e);
  }
}

class advance_payment_jButton3_actionAdapter implements java.awt.event.ActionListener {
  advance_payment adaptee;

  advance_payment_jButton3_actionAdapter(advance_payment adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton3_actionPerformed(e);
  }
}

class advance_payment_jButton2_actionAdapter implements java.awt.event.ActionListener {
  advance_payment adaptee;

  advance_payment_jButton2_actionAdapter(advance_payment adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton2_actionPerformed(e);
  }
}
