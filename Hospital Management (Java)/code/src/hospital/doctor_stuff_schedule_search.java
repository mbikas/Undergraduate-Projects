package hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class doctor_stuff_schedule_search extends JFrame {
  Connection connection;
  JLabel jLabel4 = new JLabel();
  JButton jButton2 = new JButton();
  JPanel jPanel4 = new JPanel();
  JRadioButton doctor = new JRadioButton();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel13 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JPanel jPanel3 = new JPanel();
  JLabel jLabel2 = new JLabel();
  JButton jButton1 = new JButton();
  JPanel jPanel2 = new JPanel();
  JButton jButton3 = new JButton();
  JPanel jPanel5 = new JPanel();
  //JList name = new JList();
  JRadioButton stuff = new JRadioButton();
  JPanel jPanel1 = new JPanel();
  String days[]={"SATURDAY","SUNDAY","MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY"};
  JComboBox day = new JComboBox(days);
  JLabel Hospital_name = new JLabel();
  JLabel jLabel6 = new JLabel();
  String depts[]={"Medicine","Surgery","Gynae","Paediactric","Orthopaeddics","Neoral"};
  JComboBox dept = new JComboBox(depts);
  JLabel jLabel5 = new JLabel();
  JTextField starts = new JTextField();
  JTextField ends = new JTextField();
  JTextField avail = new JTextField();
  JLabel jLabel7 = new JLabel();
  ButtonGroup group = new ButtonGroup();
  JScrollPane jScrollPane1 = new JScrollPane();
  JList name = new JList();

  public doctor_stuff_schedule_search() {
    try {
      jbInit();
      setSize(600,500);
      setLocation(110,80);
      show();


      connection = Main.connection;
      starts.setEditable(false);
      ends.setEditable(false);
      avail.setEditable(false);
      doctor.setSelected(true);
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    jPanel4.setBackground(new Color(173, 201, 139));
    jPanel4.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel4.setBounds(new Rectangle(7, 89, 582, 35));
    jPanel4.setLayout(null);
    jButton2.setBackground(new Color(173, 201, 139));
    jButton2.setBounds(new Rectangle(255, 9, 71, 25));
    jButton2.setFont(new java.awt.Font("Dialog", 1, 12));
    jButton2.setBorder(BorderFactory.createRaisedBevelBorder());
    jButton2.setText("CLEAR");
    jButton2.addActionListener(new doctor_stuff_schedule_search_jButton2_actionAdapter(this));
    jLabel4.setBounds(new Rectangle(152, 5, 68, 20));
    jLabel4.setText("DAY");
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel4.setBackground(new Color(173, 201, 139));
    this.getContentPane().setBackground(new Color(173, 201, 139));
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setTitle("DOCTOR AND STUFF SCHEDULE");
    this.getContentPane().setLayout(null);
    doctor.setBackground(new Color(173, 201, 139));
    doctor.setFont(new java.awt.Font("Dialog", 1, 11));
    doctor.setText("DOCTOR");
    doctor.setBounds(new Rectangle(83, 8, 82, 18));
    doctor.addActionListener(new doctor_stuff_schedule_search_doctor_actionAdapter(this));
    jLabel1.setFont(new java.awt.Font("Book Antiqua", 1, 14));
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("Doctor & Stuff Schedule ");
    jLabel1.setBounds(new Rectangle(149, 6, 218, 25));
    jLabel13.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel13.setText("TO");
    jLabel13.setBounds(new Rectangle(393, 39, 28, 24));
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel3.setText("NAME");
    jLabel3.setBounds(new Rectangle(19, 62, 98, 19));
    jPanel3.setBackground(new Color(173, 201, 139));
    jPanel3.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel3.setBounds(new Rectangle(7, 55, 582, 31));
    jPanel3.setLayout(null);
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel2.setText("DEPARTMENT");
    jLabel2.setBounds(new Rectangle(18, 8, 100, 16));
    jButton1.setBackground(new Color(173, 201, 139));
    jButton1.setBounds(new Rectangle(151, 8, 71, 25));
    jButton1.setFont(new java.awt.Font("Dialog", 1, 12));
    jButton1.setBorder(BorderFactory.createRaisedBevelBorder());
    jButton1.setText("SHOW");
    jButton1.addActionListener(new doctor_stuff_schedule_search_jButton1_actionAdapter(this));
    jPanel2.setBackground(new Color(173, 201, 139));
    jPanel2.setFont(new java.awt.Font("Dialog", 1, 11));
    jPanel2.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel2.setBounds(new Rectangle(6, 126, 580, 205));
    jPanel2.setLayout(null);
    jButton3.setText("CLOSE");
    jButton3.addActionListener(new doctor_stuff_schedule_search_jButton3_actionAdapter(this));
    jButton3.setBorder(BorderFactory.createRaisedBevelBorder());
    jButton3.setFont(new java.awt.Font("Dialog", 1, 12));
    jButton3.setBounds(new Rectangle(355, 10, 71, 25));
    jButton3.setBackground(new Color(173, 201, 139));
    jPanel5.setLayout(null);
    jPanel5.setBounds(new Rectangle(6, 337, 582, 43));
    jPanel5.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel5.setBackground(new Color(173, 201, 139));
    //name.setBackground(new Color(173, 201, 139));
    //name.setFont(new java.awt.Font("Dialog", 1, 11));
    stuff.setBackground(new Color(173, 201, 139));
    stuff.setFont(new java.awt.Font("Dialog", 1, 11));
    stuff.setText("STUFF");
    stuff.setBounds(new Rectangle(333, 8, 86, 17));
    stuff.addActionListener(new doctor_stuff_schedule_search_stuff_actionAdapter(this));
    jPanel1.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel1.setBackground(new Color(173, 201, 139));
    jPanel1.setBounds(new Rectangle(6, 9, 581, 45));
    jPanel1.setLayout(null);
    day.setBackground(new Color(173, 201, 139));
    day.setFont(new java.awt.Font("Dialog", 1, 11));
    day.setBounds(new Rectangle(151, 27, 90, 26));
    day.addActionListener(new doctor_stuff_schedule_search_day_actionAdapter(this));
    Hospital_name.setBounds(new Rectangle(24, 12, 546, 28));
    Hospital_name.setText("JALALABAD RAGIB-RABEYA MEDICAL COLLEGE HOSPITAL");
    Hospital_name.setForeground(SystemColor.desktop);
    Hospital_name.setFont(new java.awt.Font("Dialog", 1, 18));
    jLabel6.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel6.setText("ENDING TIME");
    jLabel6.setBounds(new Rectangle(444, 8, 96, 20));
    dept.setBackground(new Color(173, 201, 139));
    dept.setFont(new java.awt.Font("Dialog", 1, 11));
    dept.setBounds(new Rectangle(17, 28, 101, 26));
    dept.addActionListener(new doctor_stuff_schedule_search_dept_actionAdapter(this));
    jLabel5.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel5.setText("STARTING TIME");
    jLabel5.setBounds(new Rectangle(290, 8, 101, 21));
    starts.setBackground(SystemColor.textHighlightText);
    starts.setFont(new java.awt.Font("Dialog", 1, 11));
    starts.setDisabledTextColor(SystemColor.activeCaption);
    starts.setEditable(false);
    starts.setText("");
    starts.setBounds(new Rectangle(284, 37, 98, 30));
    ends.setBackground(SystemColor.textHighlightText);
    ends.setFont(new java.awt.Font("Dialog", 1, 11));
    ends.setDisabledTextColor(SystemColor.activeCaption);
    ends.setEditable(false);
    ends.setText("");
    ends.setBounds(new Rectangle(433, 37, 92, 30));
    avail.setBackground(SystemColor.textHighlightText);
    avail.setFont(new java.awt.Font("Dialog", 1, 11));
    avail.setText("");
    avail.setBounds(new Rectangle(289, 156, 242, 32));
    jLabel7.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel7.setText("AVAILABILITY");
    jLabel7.setBounds(new Rectangle(361, 122, 100, 28));
    jScrollPane1.setBounds(new Rectangle(20, 87, 99, 111));
    name.setBackground(SystemColor.textHighlightText);
    name.setFont(new java.awt.Font("Dialog", 1, 11));
    jPanel4.add(doctor, null);
    jPanel4.add(stuff, null);
    this.getContentPane().add(jPanel2, null);
    this.getContentPane().add(jPanel3, null);
    jPanel3.add(jLabel1, null);
    jPanel2.add(jLabel2, null);
    jPanel2.add(dept, null);
    jPanel2.add(jLabel3, null);
    jPanel2.add(jLabel4, null);
    jPanel2.add(day, null);
    jPanel2.add(jLabel5, null);
    jPanel2.add(jLabel6, null);
    jPanel2.add(starts, null);
    jPanel2.add(jLabel13, null);
    jPanel2.add(ends, null);
    jPanel2.add(avail, null);
    jPanel2.add(jLabel7, null);
    jPanel2.add(jScrollPane1, null);
    this.getContentPane().add(jPanel5, null);
    jScrollPane1.getViewport().add(name, null);
    jPanel5.add(jButton1, null);
    jPanel5.add(jButton2, null);
    jPanel5.add(jButton3, null);
    this.getContentPane().add(jPanel1, null);
    jPanel1.add(Hospital_name, null);
    this.getContentPane().add(jPanel4, null);

    group.add(doctor);
    group.add(stuff);

  }

  public static void main(String[] args) {
    doctor_stuff_schedule_search doctor_stuff_schedule_search = new doctor_stuff_schedule_search();
  }

  void doctor_actionPerformed(ActionEvent e) {

    String temp[]=new String[1];
    name.setListData(temp);
    starts.setText("");
    ends.setText("");
    avail.setText("");


  }

  void stuff_actionPerformed(ActionEvent e) {

    String temp[]=new String[1];
    name.setListData(temp);
    starts.setText("");
    ends.setText("");
    avail.setText("");




  }

  void dept_actionPerformed(ActionEvent e) {

    starts.setText("");
    ends.setText("");
    avail.setText("");


    try {


            Statement stat;
            ResultSet rset;
            String sql;

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

           // connection.close();
            stat.close();
            rset.close();
          }
          catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, sqlException.getMessage(),"Database error",JOptionPane.ERROR_MESSAGE);
          }


  }

  void jButton1_actionPerformed(ActionEvent e) {
    int doc_id=0,stuff_id=0;
    String start="",end="";

    if( !doctor.isSelected() && !stuff.isSelected())
            JOptionPane.showMessageDialog(null,"Insert Doctor or Stuff Catagory","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
    else if(name.isSelectionEmpty())
            JOptionPane.showMessageDialog(null,"select a Name","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
    else
    {
      try {

        boolean insertResult1, insertResult2, insertResult3;
        Statement stat1, stat2, stat;
        String sql,sql1, sql2;
        ResultSet rset;


        if (doctor.isSelected()) {

            stat = connection.createStatement();
            sql = "select doctor_id from doctor_info where ( name = '"+name.getSelectedValue()+"' AND dept = '"+dept.getSelectedItem()+"') " ;
            rset = stat.executeQuery(sql);
            while (rset.next()) {
              doc_id = Integer.parseInt(rset.getString("doctor_id")) ;
            }

            String str="";
            stat = connection.createStatement();
            sql = "select starts,ends from doctor_schedule  where ( doctor_id = "+doc_id+" AND days = '"+day.getSelectedItem()+"') " ;
            rset = stat.executeQuery(sql);
            while (rset.next()) {
              start = rset.getString("starts");
              end = rset.getString("ends");
              str+=rset.getString(1);

            }

           if(str.equals(""))
           {
              starts.setText("");
              ends.setText("");
              avail.setText("Not Available");
           }
           else
           {
               avail.setText("FOUND");
               starts.setText(start);
               ends.setText(end);

           }


        }
        else {

          stat = connection.createStatement();
          sql = "select stuff_id from stuff_info where ( name ='"+name.getSelectedValue() + "' AND dept = '" + dept.getSelectedItem() +"') ";
          rset = stat.executeQuery(sql);
          while (rset.next()) {
            stuff_id = Integer.parseInt(rset.getString(1));
          }

          String str="";
          stat = connection.createStatement();
          sql = "select starts,ends from stuff_schedule  where ( stuff_id = "+stuff_id+" AND days = '"+day.getSelectedItem()+"') " ;
          rset = stat.executeQuery(sql);
          while (rset.next()) {
            start = rset.getString("starts");
            end = rset.getString("ends");
            str+=rset.getString(1);
          }


          if(str.equals(""))
          {
            starts.setText("");
            ends.setText("");
            avail.setText("Not Available");
          }
          else
          {
              avail.setText("FOUND");
              starts.setText(start);
              ends.setText(end);
          }



        }

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
    starts.setText("");
    ends.setText("");
    avail.setText("");

  }

  void jButton3_actionPerformed(ActionEvent e) {
   dispose();
  }

  void day_actionPerformed(ActionEvent e) {
    starts.setText("");
    ends.setText("");
    avail.setText("");


  }
}

class doctor_stuff_schedule_search_doctor_actionAdapter implements java.awt.event.ActionListener {
  doctor_stuff_schedule_search adaptee;

  doctor_stuff_schedule_search_doctor_actionAdapter(doctor_stuff_schedule_search adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.doctor_actionPerformed(e);
  }
}

class doctor_stuff_schedule_search_stuff_actionAdapter implements java.awt.event.ActionListener {
  doctor_stuff_schedule_search adaptee;

  doctor_stuff_schedule_search_stuff_actionAdapter(doctor_stuff_schedule_search adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.stuff_actionPerformed(e);
  }
}

class doctor_stuff_schedule_search_dept_actionAdapter implements java.awt.event.ActionListener {
  doctor_stuff_schedule_search adaptee;

  doctor_stuff_schedule_search_dept_actionAdapter(doctor_stuff_schedule_search adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.dept_actionPerformed(e);
  }
}

class doctor_stuff_schedule_search_jButton1_actionAdapter implements java.awt.event.ActionListener {
  doctor_stuff_schedule_search adaptee;

  doctor_stuff_schedule_search_jButton1_actionAdapter(doctor_stuff_schedule_search adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton1_actionPerformed(e);
  }
}

class doctor_stuff_schedule_search_jButton2_actionAdapter implements java.awt.event.ActionListener {
  doctor_stuff_schedule_search adaptee;

  doctor_stuff_schedule_search_jButton2_actionAdapter(doctor_stuff_schedule_search adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton2_actionPerformed(e);
  }
}

class doctor_stuff_schedule_search_jButton3_actionAdapter implements java.awt.event.ActionListener {
  doctor_stuff_schedule_search adaptee;

  doctor_stuff_schedule_search_jButton3_actionAdapter(doctor_stuff_schedule_search adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton3_actionPerformed(e);
  }
}

class doctor_stuff_schedule_search_day_actionAdapter implements java.awt.event.ActionListener {
  doctor_stuff_schedule_search adaptee;

  doctor_stuff_schedule_search_day_actionAdapter(doctor_stuff_schedule_search adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.day_actionPerformed(e);
  }
}
