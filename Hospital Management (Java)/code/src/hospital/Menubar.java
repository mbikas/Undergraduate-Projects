
package hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.sql.*;
import java.util.*;

public class Menubar extends JFrame implements ActionListener {

  public int id=0;
  JMenuBar jMenuBar1 = new JMenuBar();
  JMenu FILE = new JMenu();
  JMenuItem outdoor = new JMenuItem();
  JMenu jMenu1 = new JMenu();
  JMenuItem admission = new JMenuItem();
  JMenuItem exit = new JMenuItem();
  JMenu jMenu2 = new JMenu();
  JMenuItem store = new JMenuItem();
  JMenu jMenu3 = new JMenu();
  JMenuItem patient = new JMenuItem();
  JMenuItem bill_search = new JMenuItem();
  JMenuItem doctor = new JMenuItem();
  JMenuItem stuff = new JMenuItem();
  JMenu jMenu4 = new JMenu();
  JMenu jMenu5 = new JMenu();
  JMenuItem bill_inf = new JMenuItem();
  JMenuItem doctor_sch = new JMenuItem();
  JMenuItem seat_inf = new JMenuItem();
  JMenuItem old_patient_inf = new JMenuItem();
  JMenu jMenu6 = new JMenu();
  JMenuItem store_search = new JMenuItem();
  JMenuItem us = new JMenuItem();
  JMenuItem seat = new JMenuItem();
  JMenuItem soft = new JMenuItem();
  JMenuItem dis = new JMenuItem();
  JMenuItem old = new JMenuItem();
  JMenuItem help = new JMenuItem();
  JMenuItem advance = new JMenuItem();
  JMenuItem bill = new JMenuItem();
  JMenuItem doctor_stuff = new JMenuItem();
  JMenuItem schedule = new JMenuItem();
  JMenu admin = new JMenu();
  JMenuItem create_user = new JMenuItem();
  JMenuItem change_pass = new JMenuItem();
  JMenuItem total_income = new JMenuItem();
  JMenuItem init = new JMenuItem();

  Icon icon = new ImageIcon("header.gif");

  public Menubar() {
    try {
      jbInit();

     id = Main.status;

    //System.out.println(id);

     if(id==2)//doctor_stuff
     {
       outdoor.setEnabled(false);
       doctor_stuff.setEnabled(false);
       schedule.setEnabled(false);
       store.setEnabled(false);
       seat.setEnabled(false);
       change_pass.setEnabled(false);
       create_user.setEnabled(false);
       total_income.setEnabled(false);
       init.setEnabled(false);

       admission.setEnabled(false);
       advance.setEnabled(false);
       bill.setEnabled(false);
       dis.setEnabled(false);


     }

     if(id==3)//user
     {


       doctor_stuff.setEnabled(false);
       schedule.setEnabled(false);
       store.setEnabled(false);
       seat.setEnabled(false);
       change_pass.setEnabled(false);
       create_user.setEnabled(false);
       total_income.setEnabled(false);
       init.setEnabled(false);

     }

      setSize(820,680);
      show();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    jMenuBar1.setBackground(new Color(173, 201, 139));
    jMenuBar1.setFont(new java.awt.Font("Tahoma", 1, 12));
    this.getContentPane().setBackground(new Color(173, 201, 139));
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setJMenuBar(jMenuBar1);
    this.setTitle("Hospital Management Software");
    this.getContentPane().setLayout(null);
    FILE.setBackground(new Color(173, 201, 139));
    FILE.setFont(new java.awt.Font("Tahoma", 1, 12));
    FILE.setMnemonic('F');
    FILE.setText("FILE   ");
    outdoor.setBackground(new Color(173, 201, 139));
    outdoor.setMnemonic('U');
    outdoor.setText("OUTDOOR PATIENT");
    jMenu1.setBackground(new Color(173, 201, 139));
    jMenu1.setMnemonic('N');
    jMenu1.setText("INDOOR PATIENT");
    admission.setBackground(new Color(173, 201, 139));
    admission.setMnemonic('A');
    admission.setText("ADMISSIOM FORM");
    exit.setBackground(new Color(173, 201, 139));
    exit.setMnemonic('E');
    exit.setText("EXIT");
    jMenu2.setBackground(new Color(173, 201, 139));
    jMenu2.setMnemonic('D');
    jMenu2.setText("DATA ENTRY");
    store.setBackground(new Color(173, 201, 139));
    store.setMnemonic('R');
    store.setText("STORE ROOM");
    jMenu3.setBackground(new Color(173, 201, 139));
    jMenu3.setMnemonic('S');
    jMenu3.setText("SEARCH");
    patient.setBackground(new Color(173, 201, 139));
    patient.setMnemonic('P');
    patient.setText("CURRENT PATIENT");
    bill_search.setBackground(new Color(173, 201, 139));
    bill_search.setMnemonic('B');
    bill_search.setText("BILL");
    doctor.setBackground(new Color(173, 201, 139));
    doctor.setActionCommand("DOCTOR");
    doctor.setMnemonic('T');
    doctor.setText("DOCTOR");
    stuff.setBackground(new Color(173, 201, 139));
    stuff.setMinimumSize(new Dimension(0, 0));
    stuff.setMnemonic('F');
    stuff.setText("STUFF");
    jMenu4.setBackground(new Color(173, 201, 139));
    jMenu4.setMnemonic('A');
    jMenu4.setText("ABOUT US");
    jMenu5.setBackground(new Color(173, 201, 139));
    jMenu5.setMnemonic('I');
    jMenu5.setText("INFORMATION");
    bill_inf.setBackground(new Color(173, 201, 139));
    bill_inf.setMnemonic('B');
    bill_inf.setText("BILL");
    doctor_sch.setBackground(new Color(173, 201, 139));
    doctor_sch.setMnemonic('T');
    doctor_sch.setText("DOCTOR/STUFF SCHEDULE");
    seat_inf.setBackground(new Color(173, 201, 139));
    seat_inf.setMnemonic('S');
    seat_inf.setText("SEAT");
    old_patient_inf.setBackground(new Color(173, 201, 139));
    old_patient_inf.setMnemonic('O');
    old_patient_inf.setText("OLD PATIENT");
    jMenu6.setBackground(new Color(173, 201, 139));
    jMenu6.setMnemonic('H');
    jMenu6.setText("HELP");
    store_search.setBackground(new Color(173, 201, 139));
    store_search.setMnemonic('R');
    store_search.setText("STORE ROOM");
    us.setBackground(new Color(173, 201, 139));
    us.setText("ABOUT DEVELOPERS");
    seat.setBackground(new Color(173, 201, 139));
    seat.setText("SEAT ENTRY");
    soft.setBackground(new Color(173, 201, 139));
    soft.setText("ABOUT SOFTWARE");
    dis.setBackground(new Color(173, 201, 139));
    dis.setText("DISCHARGE");
    old.setBackground(new Color(173, 201, 139));
    old.setMnemonic('O');
    old.setText("OLD PATIENT");
    help.setBackground(new Color(173, 201, 139));
    help.setText("HELP TOPICS");
    advance.setBackground(new Color(173, 201, 139));
    advance.setText("ADVANCE PAYMENT");
    bill.setBackground(new Color(173, 201, 139));
    bill.setText("BILL ENTRY");
    doctor_stuff.setBackground(new Color(173, 201, 139));
    doctor_stuff.setMnemonic('T');
    doctor_stuff.setText("DOCTOR/STUFF");
    schedule.setBackground(new Color(173, 201, 139));
    schedule.setText("SCHEDULE");
    admin.setBackground(new Color(173, 201, 139));
    admin.setText("ADMINISTRATOR");
    create_user.setBackground(new Color(173, 201, 139));
    create_user.setText("CREATE NEW USER");
    change_pass.setBackground(new Color(173, 201, 139));
    change_pass.setText("CHANGE PASSWORD");
    total_income.setBackground(new Color(173, 201, 139));
    total_income.setText("TOTAL INCOME");
    init.setBackground(new Color(173, 201, 139));
    init.setText("ADMINISTRATION");




    jMenuBar1.add(FILE);
    jMenuBar1.add(jMenu2);
    jMenuBar1.add(jMenu3);
    jMenuBar1.add(jMenu5);
    jMenuBar1.add(admin);
    jMenuBar1.add(jMenu4);
    jMenuBar1.add(jMenu6);
    FILE.add(outdoor);
    FILE.add(jMenu1);
    FILE.add(exit);
    jMenu1.add(admission);
    jMenu1.add(advance);
    jMenu1.add(bill);
    jMenu1.add(dis);
    jMenu2.add(doctor_stuff);
    jMenu2.add(schedule);
    jMenu2.add(store);
    jMenu2.add(seat);
    jMenu3.add(patient);
    jMenu3.add(old);
    jMenu3.add(bill_search);
    jMenu3.add(doctor);
    jMenu3.add(stuff);
    jMenu3.add(store_search);
    jMenu5.add(bill_inf);
    jMenu5.add(doctor_sch);
    jMenu5.add(seat_inf);
    jMenu5.add(old_patient_inf);
    jMenu4.add(us);
    jMenu4.add(soft);
    jMenu6.add(help);
    admin.add(create_user);
    admin.add(change_pass);
    admin.add(total_income);
    admin.add(init);

     store.addActionListener(this);
     stuff.addActionListener(this);
     store_search.addActionListener(this);
     doctor.addActionListener(this);
     outdoor.addActionListener(this);
     admission.addActionListener(this);
     exit.addActionListener(this);
     seat.addActionListener(this);
     bill_search.addActionListener(this);
     patient.addActionListener(this);
     bill_inf.addActionListener(this);
     seat_inf.addActionListener(this);
     old_patient_inf.addActionListener(this);
     us.addActionListener(this);
     dis.addActionListener(this);
     old.addActionListener(this);
     help.addActionListener(this);

     bill.addActionListener(this);
     advance.addActionListener(this);
     schedule.addActionListener(this);
     doctor_sch.addActionListener(this);
     doctor_stuff.addActionListener(this);
     soft.addActionListener(this);
     help.addActionListener(this);

     create_user.addActionListener(this);
     change_pass.addActionListener(this);
     total_income.addActionListener(this);
     init.addActionListener(this);
  }

  public static void main(String[] args) {
    Menubar menubar = new Menubar();
  }




  /////////////////////////////////////////
  public void actionPerformed(ActionEvent e) {

    if(e.getSource() == create_user)

           new Create_user();

       if(e.getSource() == change_pass)
         new change_name_pass();


      if(e.getSource() == total_income)
       new Income();

     if(e.getSource() == init)
       new admin_pass();

      if(e.getSource() == store)
            new supply_entry();

    if(e.getSource() == outdoor)
      new outdoor();


   if(e.getSource() == doctor)
    new search_doctor();

  if(e.getSource() == stuff)
    new search_stuff();
  if(e.getSource()== store_search)
      new search_supply();

   if(e.getSource() == admission)
    new Patient_admission_form();

    if(e.getSource() ==  exit)
    {

    try {
      Main.connection.close();
    }
    catch (SQLException ex) {
    }
        System.exit(0);
    }
   if(e.getSource() == seat)
        new seat_entry();
 /////////////////////


   if(e.getSource() == bill_search)
        new search_bill();
   if(e.getSource() == patient)
        new search_patient();
   if(e.getSource() == bill_inf)
        new information_charges();
    if(e.getSource() == old_patient_inf)
        new search_old_patient();
    if(e.getSource() == seat_inf)
       new available();
    if(e.getSource() == us)
       new aboutus();
     if(e.getSource()==dis)
       new discharge();
    if(e.getSource()==old)
      new search_old_patient();



    if(e.getSource() == bill)
      new Bill();

    if(e.getSource() == advance)
      new advance_payment();

    if(e.getSource() == schedule)
      new docto_stuff_schedule();
    if(e.getSource() == doctor_sch)
      new doctor_stuff_schedule_search();
    if(e.getSource() == doctor_stuff)
      new doctor_stuff_entry();



    if(e.getSource() == soft)
    {

      String info="";

      info += "This software is developed for any hospital."+"\n";
      info += "We developed this software is such a way that"+"\n";
      info += "any hospital can use this software efficiently."+"\n";
      info += "We providing also a readme file attching with the software."+"\n";
      info += "The readme file will guide you how to use this software."+"\n";
      info += "Thank You."+"\n";

      JOptionPane.showMessageDialog(this,info);

    }



   if(e.getSource() == help)
     new help();


  }




  ///////////////////////////////////////////



}
