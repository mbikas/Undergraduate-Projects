
package hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class doctor_stuff_entry extends JFrame {

  Connection connection;

  public String final_date="";
  public int doctor_id,stuff_id;
  String depts[]={"Medicine","Surgery","Gynae","Paediactric","Orthopaeddics","Neoral"};
  String religions[]={"Muslim","Hindu","Christian","Buddisht","Others"};
  JPanel jPanel1 = new JPanel();
  JLabel Hospital_name = new JLabel();
  JLabel jLabel1 = new JLabel();
  JPanel jPanel3 = new JPanel();
  JPanel jPanel2 = new JPanel();
  JRadioButton doctor = new JRadioButton();
  JRadioButton stuff = new JRadioButton();
  ButtonGroup group = new ButtonGroup();
  JPanel jPanel4 = new JPanel();
  JLabel jLabel2 = new JLabel();
  JTextField name = new JTextField();
  JLabel jLabel3 = new JLabel();
  JTextField id = new JTextField();
  JLabel jLabel4 = new JLabel();
  JComboBox dept = new JComboBox(depts);
  JLabel jLabel5 = new JLabel();
  JTextField age = new JTextField();
  JLabel jLabel6 = new JLabel();
  JComboBox religion = new JComboBox(religions);
  JLabel jLabel7 = new JLabel();
  JTextField degree = new JTextField();
  JLabel jLabel8 = new JLabel();
  JTextArea address = new JTextArea();
  JPanel jPanel5 = new JPanel();
  JButton clear = new JButton();
  JButton close = new JButton();
  JButton save = new JButton();
  JLabel jLabel9 = new JLabel();
  JTextField salary = new JTextField();
  JLabel jLabel10 = new JLabel();
  String Sex[]={"Male","Female"};
  JComboBox sex = new JComboBox(Sex);
  JLabel jLabel11 = new JLabel();
  JTextField dat = new JTextField();

  public doctor_stuff_entry() {
    try {
      jbInit();
      setSize(600,470);
      setLocation(100,60);
      show();


       /////////generating id for patient////////
        Statement stat;
        ResultSet rset;
        String sql;
        connection = Main.connection;

        //getting id from table doctor_id_generator
        stat = connection.createStatement();
        sql ="select doctor_id,stuff_id from  doc_stuff_id_gen";
        rset = stat.executeQuery(sql);
        while(rset.next()){
               doctor_id = Integer.parseInt(rset.getString("doctor_id"));
               stuff_id = Integer.parseInt(rset.getString("stuff_id"));
        }



        id.setEnabled(false);
        stat.close();


        doctor.setSelected(true);

    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    jPanel1.setLayout(null);
    jPanel1.setBounds(new Rectangle(5, 10, 581, 48));
    jPanel1.setBackground(new Color(173, 201, 139));
    jPanel1.setBorder(BorderFactory.createLoweredBevelBorder());
    this.getContentPane().setLayout(null);
    Hospital_name.setBounds(new Rectangle(24, 12, 546, 28));
    Hospital_name.setText("JALALABAD RAGIB-RABEYA MEDICAL COLLEGE HOSPITAL");
    Hospital_name.setForeground(SystemColor.desktop);
    Hospital_name.setFont(new java.awt.Font("Dialog", 1, 18));
    jLabel1.setFont(new java.awt.Font("Book Antiqua", 1, 14));
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("Doctor & Stuff Entry");
    jLabel1.setBounds(new Rectangle(149, 6, 218, 25));
    jPanel3.setBackground(new Color(173, 201, 139));
    jPanel3.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel3.setBounds(new Rectangle(5, 61, 582, 35));
    jPanel3.setLayout(null);
    jPanel2.setBackground(new Color(173, 201, 139));
    jPanel2.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel2.setBounds(new Rectangle(5, 98, 582, 24));
    jPanel2.setLayout(null);
    doctor.setBackground(new Color(173, 201, 139));
    doctor.setFont(new java.awt.Font("Dialog", 1, 11));
    doctor.setText("DOCTOR");
    doctor.setBounds(new Rectangle(125, 5, 115, 17));
    doctor.addActionListener(new doctor_stuff_entry_doctor_actionAdapter(this));
    stuff.setBackground(new Color(173, 201, 139));
    stuff.setFont(new java.awt.Font("Dialog", 1, 11));
    stuff.setText("STUFF");
    stuff.setBounds(new Rectangle(346, 3, 125, 17));
    stuff.addActionListener(new doctor_stuff_entry_stuff_actionAdapter(this));
    jPanel4.setBackground(new Color(173, 201, 139));
    jPanel4.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel4.setBounds(new Rectangle(5, 124, 582, 243));
    jPanel4.setLayout(null);
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel2.setText("NAME:");
    jLabel2.setBounds(new Rectangle(8, 62, 65, 21));
    name.setBackground(SystemColor.textHighlightText);
    name.setFont(new java.awt.Font("Dialog", 1, 12));
    name.setText("");
    name.setBounds(new Rectangle(85, 58, 186, 26));
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel3.setText("ID:");
    jLabel3.setBounds(new Rectangle(7, 27, 61, 21));
    id.setBackground(SystemColor.textHighlightText);
    id.setFont(new java.awt.Font("Dialog", 1, 12));
    id.setDisabledTextColor(SystemColor.activeCaption);
    id.setText("");
    id.setBounds(new Rectangle(29, 25, 139, 24));
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel4.setText("DEPT:");
    jLabel4.setBounds(new Rectangle(10, 95, 55, 21));
    dept.setBackground(new Color(173, 201, 139));
    dept.setFont(new java.awt.Font("Dialog", 1, 12));
    dept.setBounds(new Rectangle(85, 91, 185, 24));
    dept.addActionListener(new doctor_stuff_entry_dept_actionAdapter(this));
    jLabel5.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel5.setText("AGE:");
    jLabel5.setBounds(new Rectangle(290, 93, 35, 21));
    age.setBackground(SystemColor.textHighlightText);
    age.setFont(new java.awt.Font("Dialog", 1, 12));
    age.setText("");
    age.setBounds(new Rectangle(346, 90, 210, 24));
    jLabel6.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel6.setText("RELEGION:");
    jLabel6.setBounds(new Rectangle(12, 120, 70, 25));
    religion.setBackground(new Color(173, 201, 139));
    religion.setFont(new java.awt.Font("Dialog", 1, 12));
    religion.setBounds(new Rectangle(86, 123, 186, 22));
    jLabel7.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel7.setText("DEGREE:");
    jLabel7.setBounds(new Rectangle(292, 58, 62, 24));
    degree.setBackground(SystemColor.textHighlightText);
    degree.setFont(new java.awt.Font("Dialog", 1, 12));
    degree.setText("");
    degree.setBounds(new Rectangle(348, 60, 207, 24));
    jLabel8.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel8.setText("ADDRESS:");
    jLabel8.setBounds(new Rectangle(10, 162, 74, 29));
    address.setFont(new java.awt.Font("Dialog", 1, 12));
    address.setText("");
    address.setBounds(new Rectangle(82, 155, 272, 60));
    jPanel5.setBackground(new Color(173, 201, 139));
    jPanel5.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel5.setBounds(new Rectangle(6, 369, 570, 53));
    jPanel5.setLayout(null);
    clear.setBackground(new Color(173, 201, 139));
    clear.setBounds(new Rectangle(221, 16, 75, 25));
    clear.setFont(new java.awt.Font("Dialog", 1, 12));
    clear.setBorder(BorderFactory.createRaisedBevelBorder());
    clear.setMnemonic('C');
    clear.setText("CLEAR");
    clear.addActionListener(new doctor_stuff_entry_clear_actionAdapter(this));
    close.setBackground(new Color(173, 201, 139));
    close.setBounds(new Rectangle(318, 14, 66, 27));
    close.setFont(new java.awt.Font("Dialog", 1, 12));
    close.setBorder(BorderFactory.createRaisedBevelBorder());
    close.setMnemonic('L');
    close.setText("CLOSE");
    close.addActionListener(new doctor_stuff_entry_close_actionAdapter(this));
    save.setBackground(new Color(173, 201, 139));
    save.setBounds(new Rectangle(127, 16, 72, 26));
    save.setFont(new java.awt.Font("Dialog", 1, 12));
    save.setBorder(BorderFactory.createRaisedBevelBorder());
    save.setMnemonic('S');
    save.setText("SAVE");
    save.addActionListener(new doctor_stuff_entry_save_actionAdapter(this));
    jLabel9.setBounds(new Rectangle(278, 122, 62, 24));
    jLabel9.setText("SALARY:");
    jLabel9.setFont(new java.awt.Font("Dialog", 1, 12));
    salary.setBackground(SystemColor.textHighlightText);
    salary.setFont(new java.awt.Font("Dialog", 1, 12));
    salary.setText("");
    salary.setBounds(new Rectangle(346, 118, 209, 26));
    jLabel10.setBounds(new Rectangle(364, 155, 35, 21));
    jLabel10.setText("SEX:");
    jLabel10.setFont(new java.awt.Font("Dialog", 1, 12));
    sex.setBackground(new Color(173, 201, 139));
    sex.setFont(new java.awt.Font("Dialog", 1, 11));
    sex.setBounds(new Rectangle(403, 153, 150, 24));
    jLabel11.setBounds(new Rectangle(240, 23, 101, 24));
    jLabel11.setText("JOINING DATE:");
    jLabel11.setFont(new java.awt.Font("Dialog", 1, 12));
    dat.setBounds(new Rectangle(347, 25, 207, 24));
    dat.setBackground(SystemColor.textHighlightText);
    dat.setFont(new java.awt.Font("Dialog", 1, 12));
    dat.setDisabledTextColor(SystemColor.activeCaption);
    dat.setText("");
    this.getContentPane().setBackground(new Color(173, 201, 139));
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setResizable(false);
    this.setState(Frame.NORMAL);
    this.setTitle("DOCTOR AND STUFF ENTRY");
    this.getContentPane().add(jPanel1, null);
    jPanel1.add(Hospital_name, null);
    jPanel2.add(doctor, null);
    jPanel2.add(stuff, null);
    this.getContentPane().add(jPanel4, null);
    jPanel4.add(jLabel3, null);
    jPanel4.add(name, null);
    jPanel4.add(dept, null);
    jPanel4.add(jLabel7, null);
    jPanel4.add(degree, null);
    jPanel4.add(age, null);
    jPanel4.add(jLabel5, null);
    jPanel4.add(religion, null);
    jPanel4.add(id, null);
    jPanel4.add(address, null);
    jPanel5.add(save, null);
    jPanel5.add(clear, null);
    jPanel5.add(close, null);
    jPanel4.add(jLabel8, null);
    jPanel4.add(jLabel6, null);
    jPanel4.add(jLabel4, null);
    jPanel4.add(jLabel2, null);
    jPanel4.add(jLabel9, null);
    jPanel4.add(salary, null);
    jPanel4.add(jLabel10, null);
    jPanel4.add(sex, null);
    jPanel4.add(dat, null);
    jPanel4.add(jLabel11, null);
    this.getContentPane().add(jPanel5, null);
    this.getContentPane().add(jPanel3, null);
    jPanel3.add(jLabel1, null);
    this.getContentPane().add(jPanel2, null);

    group.add(doctor);
    group.add(stuff);


  }

  public static void main(String[] args) {
    doctor_stuff_entry doctor_stuff_entry = new doctor_stuff_entry();
  }

  void doctor_actionPerformed(ActionEvent e) {

    //System.out.println(stuff_id);
    id.setText(String.valueOf(doctor_id));
    id.setEnabled(false);

  }

  void stuff_actionPerformed(ActionEvent e) {

    //System.out.println(stuff_id);
    id.setText(String.valueOf(stuff_id));
    id.setEnabled(false);


  }

  void save_actionPerformed(ActionEvent e) {


    if(!doctor.isSelected() && !stuff.isSelected())
      JOptionPane.showMessageDialog(null,"Select doctor or stuff catagory","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);

  else{


    try {

      boolean insertResult1, insertResult2, insertResult3;
      Statement stat1, stat2, stat;
      String sql1, sql2;

      if (doctor.isSelected()) {
        //for table doctor_info
        sql1 = "insert into doctor_info values(" + doctor_id + ",'" +
            name.getText() + "','" + dept.getSelectedItem() + "','" +
            religion.getSelectedItem() + "'," + Integer.parseInt(age.getText()) +
            ",'" + degree.getText() + "','" + address.getText() + "'," +
            Integer.parseInt(salary.getText()) + ",'" + sex.getSelectedItem() +
            "','" + dat.getText() + "')";
        stat = connection.createStatement();
        insertResult3 = stat.execute(sql1);
        doctor_id++;
        id.setText(String.valueOf(doctor_id));
      }
      else {
        sql1 = "insert into stuff_info values(" + stuff_id + ",'" +
            name.getText() + "','" + dept.getSelectedItem() + "','" +
            religion.getSelectedItem() + "'," + Integer.parseInt(age.getText()) +
            ",'" + degree.getText() + "','" + address.getText() + "'," +
            Integer.parseInt(salary.getText()) + ",'" + sex.getSelectedItem() +
            "','" + dat.getText() + "')";
        stat = connection.createStatement();
        insertResult3 = stat.execute(sql1);
        stuff_id++;
        id.setText(String.valueOf(stuff_id));
      }

      //updaing id in the  table generator
      sql1 = "delete from doc_stuff_id_gen";
      stat1 = connection.createStatement();
      insertResult1 = stat1.execute(sql1);
      sql2 = "insert into doc_stuff_id_gen values(" + doctor_id + "," +
          stuff_id + ")";
      stat2 = connection.createStatement();
      insertResult2 = stat2.execute(sql2);
      ///////////////end of generating id/////////////////////

      stat.close();
      stat1.close();
      stat2.close();
      JOptionPane.showMessageDialog(null,"Your Information have successfully saved.","CONFIRMATION MESSAGE",JOptionPane.INFORMATION_MESSAGE);


    }
    catch (SQLException sqlException) {
      JOptionPane.showMessageDialog(null, sqlException.getMessage(),
                                    "Database error",
                                    JOptionPane.ERROR_MESSAGE);
    }
  }


  }

  void clear_actionPerformed(ActionEvent e) {
    id.setText("");
    degree.setText("");
    age.setText("");
    salary.setText("");
    name.setText("");
    address.setText("");
  }

  void close_actionPerformed(ActionEvent e) {
     dispose();
  }

  void dept_actionPerformed(ActionEvent e) {

  }
}

class doctor_stuff_entry_doctor_actionAdapter implements java.awt.event.ActionListener {
  doctor_stuff_entry adaptee;

  doctor_stuff_entry_doctor_actionAdapter(doctor_stuff_entry adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.doctor_actionPerformed(e);
  }
}

class doctor_stuff_entry_stuff_actionAdapter implements java.awt.event.ActionListener {
  doctor_stuff_entry adaptee;

  doctor_stuff_entry_stuff_actionAdapter(doctor_stuff_entry adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.stuff_actionPerformed(e);
  }
}

class doctor_stuff_entry_save_actionAdapter implements java.awt.event.ActionListener {
  doctor_stuff_entry adaptee;

  doctor_stuff_entry_save_actionAdapter(doctor_stuff_entry adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.save_actionPerformed(e);
  }
}

class doctor_stuff_entry_clear_actionAdapter implements java.awt.event.ActionListener {
  doctor_stuff_entry adaptee;

  doctor_stuff_entry_clear_actionAdapter(doctor_stuff_entry adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.clear_actionPerformed(e);
  }
}

class doctor_stuff_entry_close_actionAdapter implements java.awt.event.ActionListener {
  doctor_stuff_entry adaptee;

  doctor_stuff_entry_close_actionAdapter(doctor_stuff_entry adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.close_actionPerformed(e);
  }
}

class doctor_stuff_entry_dept_actionAdapter implements java.awt.event.ActionListener {
  doctor_stuff_entry adaptee;

  doctor_stuff_entry_dept_actionAdapter(doctor_stuff_entry adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.dept_actionPerformed(e);
  }
}
