package hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class docto_stuff_schedule extends JFrame {

  Statement stat;
  ResultSet rset;
  String sql;
  Connection connection;


  JPanel jPanel1 = new JPanel();
  JLabel Hospital_name = new JLabel();
  JLabel jLabel1 = new JLabel();
  JPanel jPanel3 = new JPanel();
  JPanel jPanel4 = new JPanel();
  JRadioButton doctor = new JRadioButton();
  JRadioButton stuff = new JRadioButton();
  JPanel jPanel2 = new JPanel();
  String depts[]={"Medicine","Surgery","Gynae","Paediactric","Orthopaeddics","Neoral"};
  JComboBox dept = new JComboBox(depts);
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JScrollPane jScrollPane1 = new JScrollPane();
  JList name = new JList();
  JLabel jLabel4 = new JLabel();
  String days[]={"SATURDAY","SUNDAY","MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY"};
  JComboBox day = new JComboBox(days);
  JLabel jLabel5 = new JLabel();
  JLabel jLabel6 = new JLabel();
  JTextField h1 = new JTextField();
  JTextField m1 = new JTextField();
  JTextField h2 = new JTextField();
  JTextField m2 = new JTextField();
  JLabel jLabel7 = new JLabel();
  JLabel jLabel8 = new JLabel();
  JLabel jLabel9 = new JLabel();
  JLabel jLabel10 = new JLabel();
  JLabel jLabel11 = new JLabel();
  JLabel jLabel12 = new JLabel();
  JLabel jLabel13 = new JLabel();
  JPanel jPanel5 = new JPanel();
  JButton jButton1 = new JButton();
  JButton jButton2 = new JButton();
  JButton jButton3 = new JButton();
  ButtonGroup group = new ButtonGroup();

  public docto_stuff_schedule() {
    try {
      jbInit();
      setSize(605,450);
      setLocation(110,80);

      connection = Main.connection;
      show();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    jPanel1.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel1.setBackground(new Color(173, 201, 139));
    jPanel1.setBounds(new Rectangle(6, 9, 581, 62));
    jPanel1.setLayout(null);
    this.getContentPane().setBackground(new Color(173, 201, 139));
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setResizable(false);
    this.setTitle("DOCTOR AND STUFF ENTRY");
    this.getContentPane().setLayout(null);
    Hospital_name.setBounds(new Rectangle(24, 12, 546, 28));
    Hospital_name.setText("JALALABAD RAGIB-RABEYA MEDICAL COLLEGE HOSPITAL");
    Hospital_name.setForeground(SystemColor.desktop);
    Hospital_name.setFont(new java.awt.Font("Dialog", 1, 18));
    jLabel1.setFont(new java.awt.Font("Book Antiqua", 1, 14));
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("Doctor & Stuff Schedule Entry");
    jLabel1.setBounds(new Rectangle(149, 6, 218, 25));
    jPanel3.setBackground(new Color(173, 201, 139));
    jPanel3.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel3.setBounds(new Rectangle(7, 75, 582, 35));
    jPanel3.setLayout(null);
    jPanel4.setLayout(null);
    jPanel4.setBounds(new Rectangle(7, 116, 582, 35));
    jPanel4.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel4.setBackground(new Color(173, 201, 139));
    doctor.setBackground(new Color(173, 201, 139));
    doctor.setFont(new java.awt.Font("Dialog", 1, 11));
    doctor.setText("DOCTOR");
    doctor.setBounds(new Rectangle(83, 8, 82, 18));
    doctor.addActionListener(new docto_stuff_schedule_doctor_actionAdapter(this));
    stuff.setBackground(new Color(173, 201, 139));
    stuff.setFont(new java.awt.Font("Dialog", 1, 11));
    stuff.setText("STUFF");
    stuff.setBounds(new Rectangle(333, 8, 86, 17));
    stuff.addActionListener(new docto_stuff_schedule_stuff_actionAdapter(this));
    jPanel2.setBackground(new Color(173, 201, 139));
    jPanel2.setFont(new java.awt.Font("Dialog", 1, 11));
    jPanel2.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel2.setBounds(new Rectangle(9, 161, 580, 205));
    jPanel2.setLayout(null);
    dept.setBackground(new Color(173, 201, 139));
    dept.setFont(new java.awt.Font("Dialog", 1, 11));
    dept.setBounds(new Rectangle(17, 28, 101, 26));
    dept.addActionListener(new docto_stuff_schedule_dept_actionAdapter(this));
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel2.setText("DEPARTMENT");
    jLabel2.setBounds(new Rectangle(18, 8, 100, 16));
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel3.setText("NAME");
    jLabel3.setBounds(new Rectangle(19, 62, 98, 19));
    jScrollPane1.setBounds(new Rectangle(19, 90, 99, 109));
    name.setBackground(new Color(173, 201, 139));
    name.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel4.setBackground(new Color(173, 201, 139));
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel4.setText("DAY");
    jLabel4.setBounds(new Rectangle(152, 5, 68, 20));
    day.setBackground(new Color(173, 201, 139));
    day.setFont(new java.awt.Font("Dialog", 1, 11));
    day.setBounds(new Rectangle(151, 27, 90, 26));
    day.addActionListener(new docto_stuff_schedule_day_actionAdapter(this));
    jLabel5.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel5.setText("STARTING TIME");
    jLabel5.setBounds(new Rectangle(290, 8, 101, 21));
    jLabel6.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel6.setText("ENDING TIME");
    jLabel6.setBounds(new Rectangle(444, 8, 96, 20));
    h1.setFont(new java.awt.Font("Dialog", 1, 11));
    h1.setText("");
    h1.setBounds(new Rectangle(283, 52, 45, 27));
    m1.setBounds(new Rectangle(344, 53, 46, 25));
    m1.setFont(new java.awt.Font("Dialog", 1, 11));
    m1.setText("");
    h2.setBounds(new Rectangle(435, 53, 45, 27));
    h2.setFont(new java.awt.Font("Dialog", 1, 11));
    h2.setText("");
    m2.setBounds(new Rectangle(493, 53, 45, 27));
    m2.setFont(new java.awt.Font("Dialog", 1, 11));
    m2.setText("");
    jLabel7.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel7.setText("HH");
    jLabel7.setBounds(new Rectangle(295, 35, 28, 15));
    jLabel8.setBounds(new Rectangle(351, 35, 37, 15));
    jLabel8.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel8.setText("MM");
    jLabel9.setBounds(new Rectangle(444, 36, 25, 15));
    jLabel9.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel9.setText("HH");
    jLabel10.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel10.setText("MM");
    jLabel10.setBounds(new Rectangle(503, 34, 37, 15));
    jLabel11.setFont(new java.awt.Font("Dialog", 1, 14));
    jLabel11.setText(":");
    jLabel11.setBounds(new Rectangle(331, 54, 10, 23));
    jLabel12.setBounds(new Rectangle(482, 54, 10, 23));
    jLabel12.setText(":");
    jLabel12.setFont(new java.awt.Font("Dialog", 1, 14));
    jLabel13.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel13.setText("TO");
    jLabel13.setBounds(new Rectangle(401, 53, 28, 24));
    jPanel5.setLayout(null);
    jPanel5.setBounds(new Rectangle(9, 368, 582, 43));
    jPanel5.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel5.setBackground(new Color(173, 201, 139));
    jButton1.setBackground(new Color(173, 201, 139));
    jButton1.setBounds(new Rectangle(151, 8, 71, 25));
    jButton1.setFont(new java.awt.Font("Dialog", 1, 12));
    jButton1.setBorder(BorderFactory.createRaisedBevelBorder());
    jButton1.setText("ENTRY");
    jButton1.addActionListener(new docto_stuff_schedule_jButton1_actionAdapter(this));
    jButton2.setText("CLEAR");
    jButton2.addActionListener(new docto_stuff_schedule_jButton2_actionAdapter(this));
    jButton2.setBorder(BorderFactory.createRaisedBevelBorder());
    jButton2.setFont(new java.awt.Font("Dialog", 1, 12));
    jButton2.setBounds(new Rectangle(255, 9, 71, 25));
    jButton2.setBackground(new Color(173, 201, 139));
    jButton3.setText("CLOSE");
    jButton3.addActionListener(new docto_stuff_schedule_jButton3_actionAdapter(this));
    jButton3.setBorder(BorderFactory.createRaisedBevelBorder());
    jButton3.setFont(new java.awt.Font("Dialog", 1, 12));
    jButton3.setBounds(new Rectangle(355, 10, 71, 25));
    jButton3.setBackground(new Color(173, 201, 139));
    this.getContentPane().add(jPanel1, null);
    jPanel1.add(Hospital_name, null);
    this.getContentPane().add(jPanel3, null);
    jPanel3.add(jLabel1, null);
    this.getContentPane().add(jPanel4, null);
    jPanel4.add(doctor, null);
    jPanel4.add(stuff, null);
    this.getContentPane().add(jPanel2, null);
    jPanel2.add(jLabel2, null);
    jPanel2.add(dept, null);
    jPanel2.add(jLabel3, null);
    jPanel2.add(jScrollPane1, null);
    jPanel2.add(jLabel4, null);
    jPanel2.add(day, null);
    jPanel2.add(jLabel5, null);
    jPanel2.add(jLabel6, null);
    jPanel2.add(h1, null);
    jPanel2.add(m1, null);
    jPanel2.add(m2, null);
    jPanel2.add(h2, null);
    jPanel2.add(jLabel9, null);
    jPanel2.add(jLabel10, null);
    jPanel2.add(jLabel8, null);
    jPanel2.add(jLabel7, null);
    jPanel2.add(jLabel11, null);
    jPanel2.add(jLabel12, null);
    jPanel2.add(jLabel13, null);
    this.getContentPane().add(jPanel5, null);
    jPanel5.add(jButton1, null);
    jPanel5.add(jButton2, null);
    jPanel5.add(jButton3, null);
    jScrollPane1.getViewport().add(name, null);

    group.add(doctor);
    group.add(stuff);


  }

  public static void main(String[] args) {
    docto_stuff_schedule docto_stuff_schedule = new docto_stuff_schedule();
  }

  void doctor_actionPerformed(ActionEvent e) {

    String temp[]=new String[1];
    name.setListData(temp);
    m1.setText("");
    m2.setText("");
    h1.setText("");
    h2.setText("");


  }

  void stuff_actionPerformed(ActionEvent e) {
    String temp[]=new String[1];
    name.setListData(temp);
    m1.setText("");
    m2.setText("");
    h1.setText("");
    h2.setText("");


  }

  void dept_actionPerformed(ActionEvent e) {

    try {



             stat = connection.createStatement();
             if(doctor.isSelected())
             sql = "select name from doctor_info where doctor_id in (select doctor_id from doctor_info "+
                   "where dept = '"+dept.getSelectedItem()+"')";
              else
                sql = "select name from stuff_info where stuff_id in (select stuff_id from stuff_info "+
                   "where dept = '"+dept.getSelectedItem()+"')";

             rset = stat.executeQuery(sql);
             int ct = 0,i;
             String doc[] = new String[100];
             while (rset.next()) {
               doc[ct] = rset.getString(1) ;
               ct++;
             }

             String temp[] = new String[ct];
             for (i = 0; i < ct; i++)
             temp[i] = doc[i];
             name.setListData(temp);

             stat.close();
             rset.close();
           }
           catch (SQLException sqlException) {
             JOptionPane.showMessageDialog(null, sqlException.getMessage(),"Database error",JOptionPane.ERROR_MESSAGE);
           }


  }

  void jButton1_actionPerformed(ActionEvent e) {

    int doc_id=0,stuff_id=0;
    int starth,endh,startm,endm;
    String start="",end="";

    if( !doctor.isSelected() && !stuff.isSelected())
            JOptionPane.showMessageDialog(null,"Insert Doctor or Stuff Catagory","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
    else if(name.isSelectionEmpty())
            JOptionPane.showMessageDialog(null,"select a Name","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
    else if( h1.getText().equals("") || m1.getText().equals("") ||h2.getText().equals("") ||m2.getText().equals("") )
            JOptionPane.showMessageDialog(null,"Fillup all the fields","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
    else
    {
      try {

        boolean insertResult1, insertResult2, insertResult3;
        Statement stat1, stat2;
        String sql,sql1, sql2;

        if (doctor.isSelected()) {

            stat = connection.createStatement();
            sql = "select doctor_id from doctor_info where ( name = '"+name.getSelectedValue()+"' AND dept = '"+dept.getSelectedItem()+"') " ;
            rset = stat.executeQuery(sql);
            while (rset.next()) {
              doc_id = Integer.parseInt(rset.getString("doctor_id")) ;
            }

           // System.out.println(doc_id);

           starth = Integer.parseInt(h1.getText());
           endh = Integer.parseInt(h2.getText());
           startm = Integer.parseInt(m1.getText());
           endm = Integer.parseInt(m2.getText());

           start +=String.valueOf(starth);
           start +=":";
           if(startm<=9)
             start+="0";
           start +=String.valueOf(startm);
           end +=String.valueOf(endh);
           end +=":";
           if(endm<=9)
             end+="0";
           end +=String.valueOf(endm);



          //for table doctor_info
          sql1 = "insert into doctor_schedule values(" + doc_id + ",'"+day.getSelectedItem()+ "','" + start+ "','" +end + "' )";
          stat = connection.createStatement();
          insertResult3 = stat.execute(sql1);

        }
        else {
          stat = connection.createStatement();
          sql = "select stuff_id from stuff_info where ( name ='"+name.getSelectedValue() + "' AND dept = '" + dept.getSelectedItem() +"') ";
          rset = stat.executeQuery(sql);
          while (rset.next()) {
            stuff_id = Integer.parseInt(rset.getString(1));
          }

          starth = Integer.parseInt(h1.getText());
          endh = Integer.parseInt(h2.getText());
          startm = Integer.parseInt(m1.getText());
          endm = Integer.parseInt(m2.getText());

          start += String.valueOf(starth);
          start += ":";
          if (startm <= 9)
            start += "0";
          start += String.valueOf(startm);
          end += String.valueOf(endh);
          end += ":";
          if (endm <= 9)
            end += "0";
          end += String.valueOf(endm);

          //for table doctor_info
          sql1 = "insert into stuff_schedule values(" + stuff_id + ",'" +day.getSelectedItem() + "','" + start + "','" + end + "' )";
          stat = connection.createStatement();
          insertResult3 = stat.execute(sql1);

        }

        JOptionPane.showMessageDialog(null,"Your Information have successfully saved.","CONFIRMATION MESSAGE",JOptionPane.INFORMATION_MESSAGE);

        stat.close();


      }
      catch (SQLException sqlException) {
        JOptionPane.showMessageDialog(null, sqlException.getMessage(),
                                      "Database error",
                                      JOptionPane.ERROR_MESSAGE);
      }



    }

  }

  void jButton2_actionPerformed(ActionEvent e) {

    String temp[]=new String[1];
   name.setListData(temp);
   m1.setText("");
   m2.setText("");
   h1.setText("");
   h2.setText("");


  }

  void jButton3_actionPerformed(ActionEvent e) {
   dispose();
  }

  void day_actionPerformed(ActionEvent e) {

  }
}

class docto_stuff_schedule_doctor_actionAdapter implements java.awt.event.ActionListener {
  docto_stuff_schedule adaptee;

  docto_stuff_schedule_doctor_actionAdapter(docto_stuff_schedule adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.doctor_actionPerformed(e);
  }
}

class docto_stuff_schedule_stuff_actionAdapter implements java.awt.event.ActionListener {
  docto_stuff_schedule adaptee;

  docto_stuff_schedule_stuff_actionAdapter(docto_stuff_schedule adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.stuff_actionPerformed(e);
  }
}

class docto_stuff_schedule_dept_actionAdapter implements java.awt.event.ActionListener {
  docto_stuff_schedule adaptee;

  docto_stuff_schedule_dept_actionAdapter(docto_stuff_schedule adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.dept_actionPerformed(e);
  }
}

class docto_stuff_schedule_jButton1_actionAdapter implements java.awt.event.ActionListener {
  docto_stuff_schedule adaptee;

  docto_stuff_schedule_jButton1_actionAdapter(docto_stuff_schedule adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton1_actionPerformed(e);
  }
}

class docto_stuff_schedule_jButton2_actionAdapter implements java.awt.event.ActionListener {
  docto_stuff_schedule adaptee;

  docto_stuff_schedule_jButton2_actionAdapter(docto_stuff_schedule adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton2_actionPerformed(e);
  }
}

class docto_stuff_schedule_jButton3_actionAdapter implements java.awt.event.ActionListener {
  docto_stuff_schedule adaptee;

  docto_stuff_schedule_jButton3_actionAdapter(docto_stuff_schedule adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton3_actionPerformed(e);
  }
}

class docto_stuff_schedule_day_actionAdapter implements java.awt.event.ActionListener {
  docto_stuff_schedule adaptee;

  docto_stuff_schedule_day_actionAdapter(docto_stuff_schedule adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.day_actionPerformed(e);
  }
}
