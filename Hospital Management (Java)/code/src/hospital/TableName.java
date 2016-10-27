package hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TableName extends JFrame {
  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  JLabel jLabel1 = new JLabel();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextArea names = new JTextArea();
  JButton quit = new JButton();

  public TableName() {
    try {
      jbInit();
      setSize(295,370);
      setLocation(100,60);
      show();

      names.setEditable(false);
      String table="";


      table+= "patient_id_generator"+"\n";

      table+= "patient_names_age"+"\n";
      table+= "patient_address"+"\n";
      table+= "patient_adm_date"+"\n";
      table+= "patient_relative_dept_doc"+"\n";
      table+= "patient_seat"+"\n";
      table+= "bill_1"+"\n";
      table+= "bill_2"+"\n";
      table+= "bill_money"+"\n";
      table+= "bill_advance"+"\n";
      table+= "old_patient_info"+"\n";
      table+= "outdoor_patient"+"\n";
      table+= "patient_seat"+"\n";
      table+="user_password"+"\n";
      table+="income"+"\n";
      table+= "doc_stuff_id_gen"+"\n";
      table+= "doctor_schedule"+"\n";
     table+= "stuff_schedule"+"\n";
     table+= "doctor_info"+"\n";
     table+= "stuff_info"+"\n";
     table+= "seat_id_generator"+"\n";
     table+= "ward_info"+"\n";
     table+= "cabin_info"+"\n";
     table+= "gb_info"+"\n";
     table+= "pb_info"+"\n";
     table+= "total_ward_cabin_gb_pb"+"\n";
     table+= "supply_entry"+"\n";
     table+= "id_print"+"\n";

     names.setText(table);










    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    this.getContentPane().setBackground(new Color(173, 201, 139));
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setResizable(false);
    this.getContentPane().setLayout(null);
    jPanel1.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel1.setBounds(new Rectangle(8, 44, 268, 241));
    jPanel1.setLayout(null);
    jPanel2.setBackground(new Color(173, 201, 139));
    jPanel2.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel2.setBounds(new Rectangle(8, 9, 267, 30));
    jPanel2.setLayout(null);
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1.setForeground(Color.blue);
    jLabel1.setText("TABLE NAMES");
    jLabel1.setBounds(new Rectangle(77, 1, 124, 24));
    jScrollPane1.setBounds(new Rectangle(3, 3, 264, 233));
    names.setFont(new java.awt.Font("Dialog", 1, 12));
    names.setText("");
    quit.setBackground(new Color(173, 201, 139));
    quit.setBounds(new Rectangle(84, 288, 114, 29));
    quit.setFont(new java.awt.Font("Dialog", 1, 12));
    quit.setText("QUIT");
    quit.addActionListener(new TableName_quit_actionAdapter(this));
    this.getContentPane().add(jPanel2, null);
    jPanel2.add(jLabel1, null);
    this.getContentPane().add(jPanel1, null);
    jPanel1.add(jScrollPane1, null);
    jScrollPane1.getViewport().add(names, null);
    this.getContentPane().add(quit, null);
  }

  public static void main(String[] args) {
    TableName tableName = new TableName();
  }

  void quit_actionPerformed(ActionEvent e) {
   dispose();
  }
}

class TableName_quit_actionAdapter implements java.awt.event.ActionListener {
  TableName adaptee;

  TableName_quit_actionAdapter(TableName adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.quit_actionPerformed(e);
  }
}
