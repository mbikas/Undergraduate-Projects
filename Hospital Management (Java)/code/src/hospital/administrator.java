package hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;



public class administrator extends JFrame {

  Connection connection;
  public String querys = "";
  JLabel jLabel2 = new JLabel();
  JPanel jPanel4 = new JPanel();
  JPanel panel2 = new JPanel();
  JButton execute1 = new JButton();
  JButton close = new JButton();
  JButton drop = new JButton();
  JPanel jPanel3 = new JPanel();
  JButton access = new JButton();
  JLabel jLabel1 = new JLabel();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextArea area = new JTextArea();

  public administrator() {
    try {
      jbInit();
      setSize(480,280);
      setLocation(100,50);
      show();


     connection = Main.connection;

     area.setEnabled(false);











     querys+="For Indoor Patient\n----------\n\n";
     querys += "create table patient_id_generator(indoor_id number,outdoor_id number)" + "\n";
     querys +="insert into patient_id_generator values(1,1)";
     querys+="\n";
     querys +="create table patient_names_age(patient_id number,patient_name varchar(20), "+
              "patient_father_name varchar(20),patient_age number(10), "+
              "patient_sex varchar(10),patient_religion varchar(15), " +
              "patient_husband_name varchar(20),primary key(patient_id))";
  querys+="\n";
   querys +="create table patient_address(patient_id number,present_add varchar(50),"+
             "permanent_add varchar(50),occupation varchar(20),contact varchar(15),"+
            "primary key(patient_id),foreign key(patient_id) references patient_names_age(patient_id))";
   querys+="\n";
    querys +="Create table patient_relative_dept_doc (patient_id number,"+
              "r_name varchar(25),r_add varchar(150),disease varchar(50),dept varchar(20),"+
              "doc varchar(20),primary key(patient_id),"+
              "foreign key(patient_id) references patient_names_age(patient_id))";
    querys+="\n";
    querys+= "Create table patient_seat(patient_id number,ward number,bed number,cabin number,"+
             "gb number,pb number,primary key(patient_id),"+
             "foreign key(patient_id) references patient_names_age(patient_id))";
    querys+="\n";
    querys  += "Create table patient_adm_date(patient_id number, dat date,"+
               "primary key(patient_id),foreign key(patient_id) references patient_names_age( ))";
    querys+="\n";

    querys+="\nFor Outdoor Patient\n----------\n\n";
    querys  += "Create table outdoor_patient(serial number,name varchar(20),dept varchar(20),"+
              "doctor varchar(20),age number,medicine varchar(80),primary key(serial))";
    querys+="\n";

    querys+="\nFor Old Patient\n----------\n\n";
    querys += "create table old_patient_info(id number,name varchar(20),age number,sex varchar(10),"+
              "adm_date date,rel_date date,primary key(id) )";
    querys+="\n";

    querys+="\nFor Supply\n----------\n\n";
    querys+= "create table supply_entry(name varchar(25),dept varchar(15),quantity number,price number,"+
             "primary key(name,dept))";
    querys+="\n";

    querys+="\nFor Seat\n----------\n\n";
    querys+="create table seat_id_generator(ward_id number,cabin_id number,gb_id number,pb_id number)";
    querys+="\n";
    querys+="insert into seat_id_generator values(1,1,1,1)";
    querys+="\n";
    querys +="create table total_ward_cabin_gb_pb(total_cabin number,total_ward number,"+
             "total_gb number,total_pb number)";
         querys+="\n";

    querys +="create table cabin_info(cabin_no number,flag number,primary key(cabin_no))";
    querys+="\n";

    querys += "create table ward_info(ward_no number,bed_no number, flag number,"+
              "primary key(ward_no,bed_no))";
        querys+="\n";

    querys+="create table gb_info(gb_no number,flag number,primary key(gb_no))";
    querys+="\n";

    querys+="create table pb_info(pb_no number,flag number,primary key(pb_no))";
    querys+="\n";

    querys+="\nFor Doctor\n----------\n\n";
    querys+="create table doc_stuff_id_gen(doctor_id number,stuff_id number)";
    querys+="\n";
    querys+="insert into doc_stuff_id_gen values(1,1)";
    querys+="\n";
    querys+="create table doctor_info(doctor_id number,name varchar(20),dept varchar(20),"+
            "religion varchar(10),age number,degree varchar(20),address varchar(80),"+
             "salary number,sex varchar(7),dates varchar(20),"+
             "primary key(doctor_id))";
    querys+="\n";
    querys +="create table doctor_schedule(doctor_id number,days varchar(10),starts varchar(10),"+
             "ends varchar(10),primary key(doctor_id,days), foreign key(doctor_id) references doctor_info(doctor_id))";
    querys+="\n";

    querys+="\nFor Stuff\n----------\n\n";
    querys+="create table stuff_info(stuff_id number,name varchar(20),dept varchar(20),"+
             "religion varchar(10),age number,degree varchar(20),address varchar(80),"+
            "salary number,sex varchar(7),dates varchar(20),"+
            "primary key(stuff_id))";
      querys+="\n";

    querys +="create table stuff_schedule(stuff_id number,days varchar(10),starts varchar(10),"+
             "ends varchar(10),primary key(stuff_id,days), foreign key(stuff_id) references stuff_info(stuff_id))";
    querys+="\n";

    querys+="\nFor patient Bill\n----------\n\n";
    querys+="create table bill_1(patient_id number,bed number,cabin number,ot number,delivery number,"+
            "pack number,po number,nebu number,oxyzen number,primary key(patient_id),"+
            "foreign key(patient_id) references patient_names_age(patient_id))";
    querys+="\n";
    querys +="create table bill_2(patient_id number,patho number,radio number,ecg number,urine number,"+
             "dressing number,misc number,service number,primary key(patient_id),"+
             "foreign key(patient_id) references patient_names_age(patient_id))";
    querys+="\n";
    querys +="create table bill_money(patient_id number,total number,discount number,"+
             "final_amount number,due number,"+
             "primary key(patient_id),foreign key(patient_id) references patient_names_age(patient_id))";
    querys+="\n";
    querys+="create table bill_advance(patient_id number,advance number,"+
            "primary key(patient_id),foreign key(patient_id) references patient_names_age(patient_id))";
    querys+="\n";

    querys+="\nForPrint\n----------\n\n";
    querys+="create table id_print(indoor_id number,outdoor_id number)";
    querys+="\n";
    querys+="insert into id_print values(1,1)";
    querys+="\n";

    querys+="\nFor create new user\n----------\n\n";
    querys+="create table user_password(name varchar(20),pass varchar(20),primary key(name))";
    querys+="\n";

    querys+="\nFor Income\n----------\n\n";
    querys+="create table income(dates varchar(12),indoor number,outdoor number,primary key(dates))";
    querys+="\n";

    area.setText(querys);





    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    jPanel4.setBackground(new Color(173, 201, 139));
    jPanel4.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel4.setBounds(new Rectangle(10, 6, 437, 28));
    jPanel4.setLayout(null);
    jLabel2.setBackground(new Color(173, 201, 139));
    jLabel2.setFont(new java.awt.Font("Book Antiqua", 1, 14));
    jLabel2.setForeground(SystemColor.activeCaption);
    jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel2.setText("Administrator");
    jLabel2.setBounds(new Rectangle(112, 1, 187, 23));
    this.getContentPane().setBackground(new Color(173, 201, 139));
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setResizable(false);
    this.setTitle("ADMINISTRATOR");
    this.getContentPane().setLayout(null);
    panel2.setBackground(new Color(173, 201, 139));
    panel2.setBorder(BorderFactory.createLoweredBevelBorder());
    panel2.setBounds(new Rectangle(11, 36, 147, 166));
    panel2.setLayout(null);
    execute1.setBackground(new Color(173, 201, 139));
    execute1.setBounds(new Rectangle(11, 14, 107, 25));
    execute1.setFont(new java.awt.Font("Dialog", 1, 12));
    execute1.setBorder(BorderFactory.createRaisedBevelBorder());
    execute1.setMnemonic('C');
    execute1.setText("CREATE TABLES");
    execute1.addActionListener(new administrator_execute1_actionAdapter(this));
    close.setText("CLOSE");
    close.addActionListener(new administrator_close_actionAdapter(this));
    close.setMnemonic('E');
    close.setBorder(BorderFactory.createRaisedBevelBorder());
    close.setFont(new java.awt.Font("Dialog", 1, 12));
    close.setBackground(new Color(173, 201, 139));
    close.setBounds(new Rectangle(11, 117, 107, 25));
    drop.setBackground(new Color(173, 201, 139));
    drop.setBounds(new Rectangle(11, 49, 107, 25));
    drop.setFont(new java.awt.Font("Dialog", 1, 12));
    drop.setBorder(BorderFactory.createRaisedBevelBorder());
    drop.setMnemonic('D');
    drop.setSelected(false);
    drop.setText("DROP TABLES");
    drop.addActionListener(new administrator_drop_actionAdapter(this));
    jPanel3.setBackground(new Color(173, 201, 139));
    jPanel3.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel3.setDebugGraphicsOptions(0);
    jPanel3.setBounds(new Rectangle(163, 36, 284, 166));
    jPanel3.setLayout(null);
    access.addActionListener(new administrator_access_actionAdapter(this));
    access.setText("ACCESS TABLES");
    access.setMnemonic('A');
    access.setBorder(BorderFactory.createRaisedBevelBorder());
    access.setFont(new java.awt.Font("Dialog", 1, 12));
    access.setBackground(new Color(173, 201, 139));
    access.setBounds(new Rectangle(11, 82, 107, 25));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1.setText("ALL THE TABLES");
    jLabel1.setBounds(new Rectangle(84, 3, 109, 25));
    jScrollPane1.setBounds(new Rectangle(11, 27, 265, 126));
    area.setFont(new java.awt.Font("Dialog", 1, 12));
    area.setDisabledTextColor(SystemColor.activeCaption);
    area.setText("");
    panel2.add(access, null);
    panel2.add(close, null);
    panel2.add(drop, null);
    panel2.add(execute1, null);
    this.getContentPane().add(jPanel3, null);
    jPanel3.add(jScrollPane1, null);
    jScrollPane1.getViewport().add(area, null);
    jPanel3.add(jLabel1, null);
    this.getContentPane().add(panel2, null);
    this.getContentPane().add(jPanel4, null);
    jPanel4.add(jLabel2, null);
  }

  public static void main(String[] args) {
    administrator administrator = new administrator();
  }



  void execute1_actionPerformed(ActionEvent e) {
    try {

    Statement stat;
    String sql = "";
    boolean insertResult;


    stat = connection.createStatement();
    sql =  "create table patient_id_generator(indoor_id number,outdoor_id number)";
    insertResult = stat.execute(sql);
    stat.close();

    stat = connection.createStatement();
    sql = "insert into patient_id_generator values(1,1)";
    insertResult = stat.execute(sql);
    stat.close();


    stat = connection.createStatement();
    sql = " create table patient_names_age(patient_id number,patient_name varchar(20), "+
       " patient_father_name varchar(20),patient_age number(10), " +
       " patient_sex varchar(10),patient_religion varchar(15), " +
       " patient_husband_name varchar(20),primary key(patient_id)) ";
    insertResult = stat.execute(sql);
    stat.close();

    stat = connection.createStatement();
    sql =  "Create table patient_address(patient_id number,present_add varchar(50), "+
           "permanent_add varchar(50),occupation varchar(20),contact varchar(15), " +
           " primary key(patient_id),  foreign key(patient_id) references patient_names_age(patient_id)) ";
    insertResult = stat.execute(sql);
    stat.close();

    stat = connection.createStatement();
    sql = "Create table patient_relative_dept_doc (patient_id number, "+
        "r_name varchar(25),r_add varchar(150),disease varchar(50),dept varchar(20), "+
        "doc varchar(20),primary key(patient_id), "+
        "foreign key(patient_id) references patient_names_age(patient_id))";
    insertResult = stat.execute(sql);
    stat.close();



    stat = connection.createStatement();
    sql = "create table patient_seat(patient_id number,ward number,bed number,cabin number, "+
        " gb number,pb number,primary key(patient_id), "+
         " foreign key(patient_id) references patient_names_age(patient_id)) ";
    insertResult = stat.execute(sql);
    stat.close();

    stat = connection.createStatement();
    sql = "Create table patient_adm_date(patient_id number, dat date, "+
        " primary key(patient_id), "+
       " foreign key(patient_id) references patient_names_age(patient_id)) ";
    insertResult = stat.execute(sql);
    stat.close();

    stat = connection.createStatement();
    sql = " create table outdoor_patient(serial number,name varchar(20),dept varchar(20), "+
        "doctor varchar(20),age number,medicine varchar(80), "+
        "primary key(serial))";
    insertResult = stat.execute(sql);
    stat.close();

    stat = connection.createStatement();
    sql = " create table old_patient_info(id number,name varchar(20),age number,sex varchar(10), "+
        "adm_date date,rel_date date,primary key(id) )";
    insertResult = stat.execute(sql);
    stat.close();

   stat = connection.createStatement();
   sql = "create table supply_entry(name varchar(25),dept varchar(15),quantity number,price number, "+
       "primary key(name,dept))";
   insertResult = stat.execute(sql);
   stat.close();


    stat = connection.createStatement();
    sql = "create table seat_id_generator(ward_id number,cabin_id number,gb_id number,pb_id number)";
    insertResult = stat.execute(sql);
    stat.close();

   stat = connection.createStatement();
   sql = "insert into seat_id_generator values(1,1,1,1)";
   insertResult = stat.execute(sql);
   stat.close();

   stat = connection.createStatement();
   sql = " create table total_ward_cabin_gb_pb(total_cabin number,total_ward number, "+
       "total_gb number,total_pb number)";
   insertResult = stat.execute(sql);
   stat.close();

   stat = connection.createStatement();
   sql = "create table cabin_info(cabin_no number,flag number,primary key(cabin_no))";
   insertResult = stat.execute(sql);
   stat.close();


   stat = connection.createStatement();
   sql = "create table ward_info(ward_no number,bed_no number, flag number, primary key(ward_no,bed_no))";
   insertResult = stat.execute(sql);
   stat.close();

   stat = connection.createStatement();
   sql = "create table gb_info(gb_no number,flag number,primary key(gb_no))";
   insertResult = stat.execute(sql);
   stat.close();

   stat = connection.createStatement();
   sql = "create table pb_info(pb_no number,flag number,primary key(pb_no))";
   insertResult = stat.execute(sql);
   stat.close();

   stat = connection.createStatement();
   sql = "create table doc_stuff_id_gen(doctor_id number,stuff_id number)";
   insertResult = stat.execute(sql);
   stat.close();

   stat = connection.createStatement();
   sql = "insert into doc_stuff_id_gen values(1,1)";
   insertResult = stat.execute(sql);
   stat.close();


   stat = connection.createStatement();
   sql = "create table doctor_info(doctor_id number,name varchar(20),dept varchar(20), "+
       "religion varchar(10),age number,degree varchar(20),address varchar(80), "+
       " salary number,sex varchar(7),dates varchar(20), "+
       "primary key(doctor_id)) ";
   insertResult = stat.execute(sql);
   stat.close();


    stat = connection.createStatement();
    sql = " create table stuff_info(stuff_id number,name varchar(20),dept varchar(20), "+
        " religion varchar(10),age number,degree varchar(20),address varchar(80), "+
        " salary number,sex varchar(7),dates varchar(20), primary key(stuff_id)) ";
    insertResult = stat.execute(sql);
    stat.close();


    stat = connection.createStatement();
    sql = " create table doctor_schedule(doctor_id number,days varchar(10),starts varchar(10), "+
          " ends varchar(10),primary key(doctor_id,days), foreign key(doctor_id) references doctor_info(doctor_id))";
    insertResult = stat.execute(sql);
    stat.close();

    stat = connection.createStatement();
    sql = "create table stuff_schedule(stuff_id number,days varchar(10),starts varchar(10), "+
          " ends varchar(10),primary key(stuff_id,days), foreign key(stuff_id) references stuff_info(stuff_id))";
    insertResult = stat.execute(sql);
    stat.close();



    stat = connection.createStatement();
    sql = " create table bill_1(patient_id number,bed number,cabin number,ot number,delivery number, "+
        " pack number,po number,nebu number,oxyzen number,primary key(patient_id), "+
        "foreign key(patient_id) references patient_names_age(patient_id)) ";
    insertResult = stat.execute(sql);
    stat.close();


    stat = connection.createStatement();
    sql = "create table bill_2(patient_id number,patho number,radio number,ecg number,urine number, "+
        "dressing number,misc number,service number,primary key(patient_id), "+
        "foreign key(patient_id) references patient_names_age(patient_id)) ";
    insertResult = stat.execute(sql);
    stat.close();

    stat = connection.createStatement();
    sql = "create table bill_money(patient_id number,total number,discount number, "+
        " final_amount number,due number, "+
        " primary key(patient_id),foreign key(patient_id) references patient_names_age(patient_id)) ";
    insertResult = stat.execute(sql);
    stat.close();

    stat = connection.createStatement();
    sql = "create table bill_advance(patient_id number,advance number, "+
        "primary key(patient_id),foreign key(patient_id) references patient_names_age(patient_id))";
    insertResult = stat.execute(sql);
    stat.close();

    stat = connection.createStatement();
    sql = "create table id_print(indoor_id number,outdoor_id number)";
    insertResult = stat.execute(sql);
    stat.close();

    stat = connection.createStatement();
    sql = "create table income(dates varchar(12),indoor number,outdoor number,   primary key(dates))";
    insertResult = stat.execute(sql);
    stat.close();

    stat = connection.createStatement();
   sql = "create table user_password(name varchar(20),pass varchar(20),primary key(name))";
   insertResult = stat.execute(sql);
   stat.close();
   JOptionPane.showMessageDialog(null,"All table have been created successfully.","CONFIRMATION MESSAGE",JOptionPane.INFORMATION_MESSAGE);



  }
  catch (SQLException sqlException) {
    JOptionPane.showMessageDialog(null, sqlException.getMessage(),"Database error",JOptionPane.ERROR_MESSAGE);
  }




  }

  void drop_actionPerformed(ActionEvent e) {
    try {

    Statement stat;
    String sql = "";
    boolean insertResult;


    stat = connection.createStatement();
    sql =  "drop table bill_1";
    insertResult = stat.execute(sql);
    stat.close();

    stat = connection.createStatement();
    sql = "drop table bill_2";
    insertResult = stat.execute(sql);
    stat.close();


    stat = connection.createStatement();
    sql = " drop table bill_money ";
    insertResult = stat.execute(sql);
    stat.close();

    stat = connection.createStatement();
    sql =  "drop table bill_advance ";
    insertResult = stat.execute(sql);
    stat.close();

    stat = connection.createStatement();
    sql = "drop table patient_adm_date ";
    insertResult = stat.execute(sql);
    stat.close();



    stat = connection.createStatement();
    sql = "drop table patient_seat ";
    insertResult = stat.execute(sql);
    stat.close();

    stat = connection.createStatement();
    sql = "drop table patient_relative_dept_doc ";
    insertResult = stat.execute(sql);
    stat.close();

    stat = connection.createStatement();
    sql = " drop table patient_address ";
    insertResult = stat.execute(sql);
    stat.close();

    stat = connection.createStatement();
    sql = " drop table patient_names_age ";
    insertResult = stat.execute(sql);
    stat.close();

   stat = connection.createStatement();
   sql = "drop table old_patient_info ";
   insertResult = stat.execute(sql);
   stat.close();


    stat = connection.createStatement();
    sql = "drop table patient_id_generator ";
    insertResult = stat.execute(sql);
    stat.close();

   stat = connection.createStatement();
   sql = " drop table outdoor_patient";
   insertResult = stat.execute(sql);
   stat.close();

   stat = connection.createStatement();
   sql = " drop table supply_entry ";
   insertResult = stat.execute(sql);
   stat.close();

   stat = connection.createStatement();
   sql = "drop table seat_id_generator ";
   insertResult = stat.execute(sql);
   stat.close();


   stat = connection.createStatement();
   sql = "drop table ward_info ";
   insertResult = stat.execute(sql);
   stat.close();

   stat = connection.createStatement();
   sql = "drop table cabin_info ";
   insertResult = stat.execute(sql);
   stat.close();

   stat = connection.createStatement();
   sql = "drop table gb_info";
   insertResult = stat.execute(sql);
   stat.close();

   stat = connection.createStatement();
   sql = "drop table pb_info";
   insertResult = stat.execute(sql);
   stat.close();

   stat = connection.createStatement();
   sql = "drop table total_ward_cabin_gb_pb ";
   insertResult = stat.execute(sql);
   stat.close();

   stat = connection.createStatement();
   sql = "drop table doc_stuff_id_gen ";
   insertResult = stat.execute(sql);
   stat.close();


   stat = connection.createStatement();
   sql = "drop table doctor_schedule ";
   insertResult = stat.execute(sql);
   stat.close();

    stat = connection.createStatement();
    sql = "drop table stuff_schedule ";
    insertResult = stat.execute(sql);
    stat.close();



    stat = connection.createStatement();
    sql = " drop table doctor_info ";
    insertResult = stat.execute(sql);
    stat.close();


    stat = connection.createStatement();
    sql = " drop table stuff_info ";
    insertResult = stat.execute(sql);
    stat.close();


    stat = connection.createStatement();
    sql = " drop table id_print ";
    insertResult = stat.execute(sql);
    stat.close();

    stat = connection.createStatement();
    sql = "drop table user_password ";
    insertResult = stat.execute(sql);
    stat.close();

    stat = connection.createStatement();
    sql = "drop table income ";
    insertResult = stat.execute(sql);
    stat.close();

    JOptionPane.showMessageDialog(null,"All table have been deleted successfully.","CONFIRMATION MESSAGE",JOptionPane.INFORMATION_MESSAGE);


  }
  catch (SQLException sqlException) {
    JOptionPane.showMessageDialog(null, sqlException.getMessage(),"Database error",JOptionPane.ERROR_MESSAGE);
  }

  }

  void close_actionPerformed(ActionEvent e) {

    dispose();

  }

  void access_actionPerformed(ActionEvent e) {
         dispose();
         new access_tables();
  }



}

class administrator_execute1_actionAdapter implements java.awt.event.ActionListener {
  administrator adaptee;

  administrator_execute1_actionAdapter(administrator adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.execute1_actionPerformed(e);
  }
}

class administrator_drop_actionAdapter implements java.awt.event.ActionListener {
  administrator adaptee;

  administrator_drop_actionAdapter(administrator adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.drop_actionPerformed(e);
  }
}

class administrator_close_actionAdapter implements java.awt.event.ActionListener {
  administrator adaptee;

  administrator_close_actionAdapter(administrator adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.close_actionPerformed(e);
  }
}

class administrator_access_actionAdapter implements java.awt.event.ActionListener {
  administrator adaptee;

  administrator_access_actionAdapter(administrator adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.access_actionPerformed(e);
  }
}
