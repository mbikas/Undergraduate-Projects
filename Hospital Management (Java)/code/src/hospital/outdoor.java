
package hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;


public class outdoor extends JFrame {

  Connection connection;

  String dat;

  public  String doc[]=new String[100],inf="";
  public long outdoor_id,indoor_id;
  JPanel jPanel2 = new JPanel();
  JLabel Hospital_name1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JPanel jPanel4 = new JPanel();
  JPanel jPanel1 = new JPanel();
  JLabel jLabel1 = new JLabel();
  JTextField name = new JTextField();
  JLabel jLabel3 = new JLabel();
  JTextField serial = new JTextField();
  JLabel jLabel4 = new JLabel();
  String depts[]={"Medicine","Surgery","Gynae","Paediactric","Orthopaeddics","Neoral"};
  JComboBox dept = new JComboBox(depts);
  JLabel jLabel5 = new JLabel();
  JLabel jLabel6 = new JLabel();
  JTextField age = new JTextField();
  JLabel jLabel7 = new JLabel();
  JButton jButton2 = new JButton();
  JButton save = new JButton();
  JButton jButton3 = new JButton();
  JPanel jPanel5 = new JPanel();
  JButton print = new JButton();
  JScrollPane jScrollPane1 = new JScrollPane();
  JLabel jLabel8 = new JLabel();
  JTextField amount = new JTextField();
  JTextArea medicine = new JTextArea();
  JScrollPane jScrollPane2 = new JScrollPane();
  JList dr_list = new JList();
  Border border1;
  Border border2;
  Border border3;
  Border border4;
  Border border5;
  Border border6;
  JLabel jLabel9 = new JLabel();
  JTextField dated = new JTextField();


  public outdoor() {
    try {
      jbInit();
      setSize(600,460);
      setLocation(110,80);
      show();

      /////////generating id for patient////////
        Statement stat;
        ResultSet rset;
        String sql;
       connection = Main.connection;

//       DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
//       String url = "jdbc:oracle:oci8:@";
//       connection = DriverManager.getConnection(url, "system" , "manager" );



        //getting id from table patient_id_generator
        stat = connection.createStatement();
        sql ="select indoor_id,outdoor_id from  patient_id_generator";
        rset = stat.executeQuery(sql);
        while(rset.next()){
             indoor_id = Integer.parseInt(rset.getString("indoor_id"));
             outdoor_id = Integer.parseInt(rset.getString("outdoor_id"));
        }

       ///////////////end of generating id/////////////////////


         sql = "select to_char(sysDate,'DD-MM-YYYY') from dual";
         stat = connection.createStatement();
         rset = stat.executeQuery(sql);
         while(rset.next())
         dat= rset.getString(1);

         dated.setText(dat);
         stat.close();






        serial.setText(String.valueOf(outdoor_id));
        amount.setText("20");
        serial.setEnabled(false);
        amount.setEnabled(false);
        dated.setEnabled(false);
        stat.close();


    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    border1 = BorderFactory.createLineBorder(Color.black,3);
    border2 = BorderFactory.createLineBorder(Color.black,3);
    border3 = BorderFactory.createLineBorder(Color.black,3);
    border4 = BorderFactory.createLineBorder(Color.black,3);
    border5 = BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,Color.orange,new Color(165, 163, 151));
    border6 = BorderFactory.createLineBorder(Color.black,3);
    jPanel2.setBackground(new Color(173, 201, 139));
    jPanel2.setEnabled(true);
    jPanel2.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel2.setBounds(new Rectangle(9, 9, 576, 48));
    jPanel2.setLayout(null);
    this.getContentPane().setLayout(null);
    Hospital_name1.setBounds(new Rectangle(21, 12, 553, 28));
    Hospital_name1.setText("JALALABAD RAGIB-RABEYA MEDICAL COLLEGE HOSPITAL");
    Hospital_name1.setForeground(SystemColor.desktop);
    Hospital_name1.setFont(new java.awt.Font("Dialog", 1, 18));
    jLabel2.setFont(new java.awt.Font("Book Antiqua", 1, 14));
    jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel2.setText("Outdoor Patient Entry");
    jLabel2.setBounds(new Rectangle(149, 6, 218, 25));
    jPanel4.setBackground(new Color(173, 201, 139));
    jPanel4.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel4.setBounds(new Rectangle(8, 63, 577, 35));
    jPanel4.setLayout(null);
    jPanel1.setBackground(new Color(173, 201, 139));
    jPanel1.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel1.setBounds(new Rectangle(8, 103, 578, 261));
    jPanel1.setLayout(null);
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1.setText("NAME:");
    jLabel1.setBounds(new Rectangle(11, 59, 47, 21));
    name.setBackground(SystemColor.textHighlightText);
    name.setFont(new java.awt.Font("Dialog", 1, 12));
    name.setText("");
    name.setBounds(new Rectangle(78, 59, 138, 25));
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel3.setText("SERIAL:");
    jLabel3.setBounds(new Rectangle(12, 14, 48, 21));
    serial.setBackground(SystemColor.textHighlightText);
    serial.setFont(new java.awt.Font("Dialog", 1, 12));
    serial.setDisabledTextColor(SystemColor.activeCaption);
    serial.setEditable(false);
    serial.setText("");
    serial.setBounds(new Rectangle(76, 15, 65, 23));
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel4.setText("DEPARTMENT");
    jLabel4.setBounds(new Rectangle(317, 58, 94, 21));
    dept.setBackground(new Color(173, 201, 139));
    dept.setFont(new java.awt.Font("Dialog", 1, 12));
    dept.setBounds(new Rectangle(413, 56, 147, 25));
    dept.addActionListener(new outdoor_dept_actionAdapter(this));
    jLabel5.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel5.setText("DOCTOR");
    jLabel5.setBounds(new Rectangle(317, 94, 95, 23));
    jLabel6.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel6.setText("AGE:");
    jLabel6.setBounds(new Rectangle(10, 98, 55, 24));
    age.setBackground(SystemColor.textHighlightText);
    age.setFont(new java.awt.Font("Dialog", 1, 12));
    age.setBounds(new Rectangle(78, 96, 54, 24));
    jLabel7.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel7.setText("MEDICINE:");
    jLabel7.setBounds(new Rectangle(5, 138, 67, 26));
    jButton2.setText("CLEAR");
    jButton2.addActionListener(new outdoor_jButton2_actionAdapter(this));
    jButton2.setMnemonic('C');
    jButton2.setBorder(BorderFactory.createRaisedBevelBorder());
    jButton2.setFont(new java.awt.Font("Dialog", 1, 12));
    jButton2.setBackground(new Color(173, 201, 139));
    jButton2.setBounds(new Rectangle(209, 8, 75, 25));
    save.setText("SAVE");
    save.addActionListener(new outdoor_save_actionAdapter(this));
    save.setMnemonic('S');
    save.setBorder(BorderFactory.createRaisedBevelBorder());
    save.setFont(new java.awt.Font("Dialog", 1, 12));
    save.setBackground(new Color(173, 201, 139));
    save.setBounds(new Rectangle(103, 8, 72, 26));
    jButton3.setText("CLOSE");
    jButton3.addActionListener(new outdoor_jButton3_actionAdapter(this));
    jButton3.setMnemonic('L');
    jButton3.setBorder(BorderFactory.createRaisedBevelBorder());
    jButton3.setFont(new java.awt.Font("Dialog", 1, 12));
    jButton3.setBackground(new Color(173, 201, 139));
    jButton3.setBounds(new Rectangle(317, 7, 66, 27));
    jPanel5.setLayout(null);
    jPanel5.setBounds(new Rectangle(8, 368, 576, 47));
    jPanel5.setBackground(new Color(173, 201, 139));
    jPanel5.setBorder(BorderFactory.createLoweredBevelBorder());
    print.setBackground(new Color(173, 201, 139));
    print.setBounds(new Rectangle(415, 7, 69, 27));
    print.setEnabled(false);
    print.setFont(new java.awt.Font("Dialog", 1, 12));
    print.setBorder(BorderFactory.createRaisedBevelBorder());
    print.setMnemonic('P');
    print.setText("PRINT");
    print.addActionListener(new outdoor_print_actionAdapter(this));
    this.getContentPane().setBackground(new Color(173, 201, 139));
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setResizable(false);
    this.setTitle("OUTDOOR ENTRY");
    jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    jScrollPane1.setBounds(new Rectangle(79, 136, 219, 118));
    jLabel8.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel8.setText("AMOUNT:");
    jLabel8.setBounds(new Rectangle(400, 12, 77, 23));
    amount.setBackground(SystemColor.textHighlightText);
    amount.setFont(new java.awt.Font("Dialog", 1, 12));
    amount.setAlignmentY((float) 0.5);
    amount.setDisabledTextColor(SystemColor.activeCaption);
    amount.setEditable(false);
    amount.setBounds(new Rectangle(494, 13, 48, 22));
    amount.addActionListener(new outdoor_amount_actionAdapter(this));
    medicine.setBackground(SystemColor.textHighlightText);
    medicine.setFont(new java.awt.Font("Dialog", 1, 12));
    medicine.setText("");
    jScrollPane2.setBounds(new Rectangle(413, 92, 149, 26));
    dr_list.setBackground(SystemColor.textHighlightText);
    dr_list.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel9.setBounds(new Rectangle(175, 13, 59, 23));
    jLabel9.setText("DATE:");
    jLabel9.setFont(new java.awt.Font("Dialog", 1, 12));
    dated.setEnabled(true);
    dated.setFont(new java.awt.Font("Dialog", 1, 12));
    dated.setForeground(Color.black);
    dated.setDisabledTextColor(SystemColor.activeCaption);
    dated.setBounds(new Rectangle(222, 11, 149, 27));
    jPanel1.add(jLabel3, null);
    jPanel1.add(amount, null);
    jPanel1.add(jLabel8, null);
    jPanel1.add(jScrollPane2, null);
    jScrollPane2.getViewport().add(dr_list, null);
    jPanel1.add(jLabel1, null);
    jPanel1.add(jLabel6, null);
    jPanel1.add(jLabel7, null);
    jPanel1.add(age, null);
    jPanel1.add(jScrollPane1, null);
    jScrollPane1.getViewport().add(medicine, null);
    jPanel1.add(name, null);
    jPanel1.add(serial, null);
    jPanel1.add(dept, null);
    jPanel1.add(jLabel4, null);
    jPanel1.add(jLabel5, null);
    jPanel1.add(jLabel9, null);
    jPanel1.add(dated, null);
    this.getContentPane().add(jPanel4, null);
    jPanel4.add(jLabel2, null);
    this.getContentPane().add(jPanel1, null);
    this.getContentPane().add(jPanel2, null);
    jPanel2.add(Hospital_name1, null);
    this.getContentPane().add(jPanel5, null);
    jPanel5.add(save, null);
    jPanel5.add(jButton2, null);
    jPanel5.add(jButton3, null);
    jPanel5.add(print, null);
  }

  public static void main(String[] args) {
    outdoor outdoor = new outdoor();
  }

  void dept_actionPerformed(ActionEvent e) {

    try {

        Statement stat;
        ResultSet rset;
        String sql;


        stat = connection.createStatement();
        sql ="select name from doctor_info where doctor_id in ( select doctor_id from doctor_info where dept = '"+dept.getSelectedItem()+"')";

        rset = stat.executeQuery(sql);

        String doc[]=new String[100];
        int i=0;
        while(rset.next()){
               doc[i] = rset.getString(1);
               i++;
        }
        String temp[]=new String[i];
        for(int j=0;j<i;j++)
          temp[j]=doc[j];


        dr_list.setListData(temp);


        stat.close();
        rset.close();

      }
    catch(SQLException sqlException)
           {
             JOptionPane.showMessageDialog(null,sqlException.getMessage(),
                                    "Database error",JOptionPane.ERROR_MESSAGE);
            }


  }

  void save_actionPerformed(ActionEvent e) {

    if(name.equals(""))
    JOptionPane.showMessageDialog(null,"Insert ine Patient Name","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
   else if(dr_list.isSelectionEmpty() )
    JOptionPane.showMessageDialog(null,"NO DOCTORS AVAILABLE","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
   else if(age.getText().equals(""))
     JOptionPane.showMessageDialog(null,"Give the age","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);

    else
    {
      try {

        boolean insertResult1, insertResult2, insertResult3;
        Statement stat1, stat2, stat;
        String sql1, sql2;


        int bill = 20;
        long temps=0;

        sql1 = "insert into outdoor_patient values("+outdoor_id +", '"+name.getText()+"', '" + dept.getSelectedItem() + "','" +dr_list.getSelectedValue() + "' ," + Integer.parseInt(age.getText()) +",'" + medicine.getText() + "')";
        stat = connection.createStatement();
        insertResult3 = stat.execute(sql1);
        temps = outdoor_id;
        outdoor_id++;

        //updaing id in the  table patient_generator
        sql1 = "delete from patient_id_generator";
        stat1 = connection.createStatement();
        insertResult1 = stat1.execute(sql1);
        sql2 = "insert into patient_id_generator values(" + indoor_id + "," +
            outdoor_id + ")";
        stat2 = connection.createStatement();
        insertResult2 = stat2.execute(sql2);
        ///////////////end of generating id/////////////////////
        ResultSet rset;

        long in_id=0,out_id=0;
        String sql4 = "select indoor_id,outdoor_id from id_print";
        stat = connection.createStatement();
        rset = stat.executeQuery(sql4);
        while (rset.next()) {
         in_id  = Integer.parseInt(rset.getString("indoor_id"));
         out_id = Integer.parseInt(rset.getString("outdoor_id"));
       }

        stat = connection.createStatement();
        sql4 = "delete from id_print" ;
        insertResult3 = stat.execute(sql4);
        stat.close();

        stat = connection.createStatement();
        sql4 = "insert into id_print values("+in_id+","+temps+")" ;
        insertResult3 = stat.execute(sql4);
        stat.close();


        serial.setText(String.valueOf(outdoor_id));

        stat1.close();
        stat2.close();
        print.setEnabled(true);

        ///////updating income//////

        //System.out.println(dat);

       double indoor=0;
       int outdoor=0;
       sql4 = "select indoor,outdoor from income where dates = '"+dat+"' ";
       stat = connection.createStatement();
       rset = stat.executeQuery(sql4);
       String temp="";
       while (rset.next()) {
        indoor  = Integer.parseInt(rset.getString("indoor"));
        outdoor  = Integer.parseInt(rset.getString("outdoor"));
        temp+=outdoor;
      }


      if(temp.equals(""))
      {
        outdoor=20;
        stat = connection.createStatement();
        sql4 = "insert into income values('"+dat+"',"+indoor+","+outdoor+")";
        insertResult3 = stat.execute(sql4);
        stat.close();
      }
      else
      {
         outdoor = outdoor + 20;
        stat = connection.createStatement();
        sql4 = "update income set outdoor="+outdoor+" where dates='"+dat+"'" ;
        insertResult3 = stat.execute(sql4);
        stat.close();

      }

    // System.out.println(outdoor);


       //////////////////////////

        JOptionPane.showMessageDialog(null,"Your Information have successfully saved.","CONFIRMATION MESSAGE",JOptionPane.INFORMATION_MESSAGE);









      }
      catch (SQLException sqlException) {
        JOptionPane.showMessageDialog(null, sqlException.getMessage(),
                                      "Database error",
                                      JOptionPane.ERROR_MESSAGE);
      }
    }

    print.setVisible(true);





  }

  void jButton2_actionPerformed(ActionEvent e) {

    name.setText("");
    medicine.setText("");
    age.setText("");
    String temp[]=new String[1];
    dr_list.setListData(temp);


  }

  void jButton3_actionPerformed(ActionEvent e) {
    dispose();
  }

  void print_actionPerformed(ActionEvent e) {

    dispose();
    new outdoor_bill();

  }

  void amount_actionPerformed(ActionEvent e) {

  }
}

class outdoor_dept_actionAdapter implements java.awt.event.ActionListener {
  outdoor adaptee;

  outdoor_dept_actionAdapter(outdoor adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.dept_actionPerformed(e);
  }
}

class outdoor_save_actionAdapter implements java.awt.event.ActionListener {
  outdoor adaptee;

  outdoor_save_actionAdapter(outdoor adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.save_actionPerformed(e);
  }

}

class outdoor_jButton2_actionAdapter implements java.awt.event.ActionListener {
  outdoor adaptee;

  outdoor_jButton2_actionAdapter(outdoor adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton2_actionPerformed(e);
  }
}

class outdoor_jButton3_actionAdapter implements java.awt.event.ActionListener {
  outdoor adaptee;

  outdoor_jButton3_actionAdapter(outdoor adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton3_actionPerformed(e);
  }
}

class outdoor_print_actionAdapter implements java.awt.event.ActionListener {
  outdoor adaptee;

  outdoor_print_actionAdapter(outdoor adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.print_actionPerformed(e);
  }
}

class outdoor_amount_actionAdapter implements java.awt.event.ActionListener {
  outdoor adaptee;

  outdoor_amount_actionAdapter(outdoor adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.amount_actionPerformed(e);
  }
}
