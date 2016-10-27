
package hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class available extends JFrame {

  Connection connection;

  JButton jButton2 = new JButton();
  JButton jButton3 = new JButton();
  JPanel jPanel1 = new JPanel();
  JLabel Hospital_name = new JLabel();
  JLabel jLabel1 = new JLabel();
  JPanel jPanel3 = new JPanel();
  JButton jButton1 = new JButton();
  JPanel jPanel5 = new JPanel();
  JPanel jPanel2 = new JPanel();
  JRadioButton ward = new JRadioButton();
  JRadioButton gb = new JRadioButton();
  JRadioButton cabin = new JRadioButton();
  JRadioButton pb = new JRadioButton();
  JPanel jPanel4 = new JPanel();
  JTextArea area = new JTextArea();
  JScrollPane jScrollPane1 = new JScrollPane();
  JList ward_list = new JList();
  ButtonGroup group = new ButtonGroup();

  public available() {
    try {
      jbInit();
      setSize(600,470);
      setLocation(110,80);

      connection = Main.connection;


      show();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    jPanel1.setLayout(null);
    jPanel1.setBounds(new Rectangle(6, 6, 575, 62));
    jPanel1.setBackground(new Color(173, 201, 139));
    jPanel1.setBorder(BorderFactory.createLoweredBevelBorder());
    jButton3.setText("CLOSE");
    jButton3.addActionListener(new available_jButton3_actionAdapter(this));
    jButton3.setBorder(BorderFactory.createRaisedBevelBorder());
    jButton3.setMnemonic('L');
    jButton3.setFont(new java.awt.Font("Dialog", 1, 12));
    jButton3.setBackground(new Color(173, 201, 139));
    jButton3.setBounds(new Rectangle(341, 15, 66, 27));
    jButton2.setText("CLEAR");
    jButton2.addActionListener(new available_jButton2_actionAdapter(this));
    jButton2.setMnemonic('C');
    jButton2.setFont(new java.awt.Font("Dialog", 1, 12));
    jButton2.setBorder(BorderFactory.createRaisedBevelBorder());
    jButton2.setBackground(new Color(173, 201, 139));
    jButton2.setBounds(new Rectangle(240, 17, 75, 25));
    this.getContentPane().setLayout(null);
    Hospital_name.setBounds(new Rectangle(21, 12, 544, 28));
    Hospital_name.setText("JALALABAD RAGIB-RABEYA MEDICAL COLLEGE HOSPITAL");
    Hospital_name.setForeground(SystemColor.desktop);
    Hospital_name.setFont(new java.awt.Font("Dialog", 1, 18));
    jLabel1.setFont(new java.awt.Font("Book Antiqua", 1, 14));
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("Search  Available Seats");
    jLabel1.setBounds(new Rectangle(152, 5, 218, 25));
    jPanel3.setBackground(new Color(173, 201, 139));
    jPanel3.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel3.setBounds(new Rectangle(4, 77, 575, 35));
    jPanel3.setLayout(null);
    jButton1.setBackground(new Color(173, 201, 139));
    jButton1.setBounds(new Rectangle(142, 15, 63, 26));
    jButton1.setFont(new java.awt.Font("Dialog", 1, 12));
    jButton1.setBorder(BorderFactory.createRaisedBevelBorder());
    jButton1.setMnemonic('S');
    jButton1.setText("SHOW");
    jButton1.addActionListener(new available_jButton1_actionAdapter(this));
    jPanel5.setBackground(new Color(173, 201, 139));
    jPanel5.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel5.setBounds(new Rectangle(8, 360, 567, 57));
    jPanel5.setLayout(null);
    jPanel2.setBackground(new Color(173, 201, 139));
    jPanel2.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel2.setBounds(new Rectangle(8, 122, 198, 231));
    jPanel2.setLayout(null);
    ward.setBackground(new Color(173, 201, 139));
    ward.setText("WARD");
    ward.setBounds(new Rectangle(11, 45, 75, 23));
    ward.addActionListener(new available_ward_actionAdapter(this));
    gb.setBackground(new Color(173, 201, 139));
    gb.setText("GENERAL BED");
    gb.setBounds(new Rectangle(12, 112, 105, 33));
    gb.addActionListener(new available_gb_actionAdapter(this));
    cabin.setBackground(new Color(173, 201, 139));
    cabin.setText("CABIN");
    cabin.setBounds(new Rectangle(10, 81, 76, 24));
    cabin.addActionListener(new available_cabin_actionAdapter(this));
    pb.setBackground(new Color(173, 201, 139));
    pb.setText("PAYING BED");
    pb.setBounds(new Rectangle(12, 149, 136, 33));
    pb.addActionListener(new available_pb_actionAdapter(this));
    jPanel4.setBackground(new Color(173, 201, 139));
    jPanel4.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel4.setBounds(new Rectangle(222, 121, 356, 232));
    jPanel4.setLayout(null);
    area.setFont(new java.awt.Font("Dialog", 1, 12));
    area.setBounds(new Rectangle(10, 10, 334, 212));
    this.getContentPane().setBackground(new Color(173, 201, 139));
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setResizable(false);
    this.setTitle("AVAILABLE SEATS");
    jScrollPane1.setBounds(new Rectangle(91, 47, 89, 26));
    ward_list.setFont(new java.awt.Font("Dialog", 1, 12));
    jPanel5.add(jButton3, null);
    jPanel5.add(jButton2, null);
    jPanel5.add(jButton1, null);
    this.getContentPane().add(jPanel1, null);
    jPanel1.add(Hospital_name, null);
    this.getContentPane().add(jPanel3, null);
    jPanel3.add(jLabel1, null);
    this.getContentPane().add(jPanel2, null);
    this.getContentPane().add(jPanel4, null);
    jPanel4.add(area, null);
    this.getContentPane().add(jPanel5, null);
    jPanel2.add(pb, null);
    jPanel2.add(gb, null);
    jPanel2.add(cabin, null);
    jPanel2.add(ward, null);
    jPanel2.add(jScrollPane1, null);
    jScrollPane1.getViewport().add(ward_list, null);

    group.add(ward);
    group.add(cabin);
    group.add(gb);
    group.add(pb);


  }

  public static void main(String[] args) {
    available available = new available();
  }

  void ward_actionPerformed(ActionEvent e) {

    String temp[] = new String[1];
    area.setText("");

    try {
    Statement stat;
    ResultSet rset;
    String sql = "";

    sql = "select ward_no from ward_info order by ward_no ";
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
    area.setText("");


  }

  void gb_actionPerformed(ActionEvent e) {
    String temp[] = new String[1];
   temp[0] = "";
   ward_list.setListData(temp);
   area.setText("");


  }

  void pb_actionPerformed(ActionEvent e) {
    String temp[] = new String[1];
   temp[0] = "";
   ward_list.setListData(temp);
   area.setText("");


  }

  void jButton1_actionPerformed(ActionEvent e) {

    if(ward.isSelected() && ward_list.isSelectionEmpty())
         JOptionPane.showMessageDialog(null, "select a bed number", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
    else
    {
      try {

        Statement stat;
        ResultSet rset;
        String sql = "";


        if(ward.isSelected())
         {
           sql = "select bed_no from ward_info where (ward_no = " +
               ward_list.getSelectedValue() + " AND flag=1) order by bed_no   ";
           stat = connection.createStatement();
           rset = stat.executeQuery(sql);
           int i=0,a[]=new int[100];

           while (rset.next()) {
             a[i]=Integer.parseInt(rset.getString("bed_no"));
             i++;
           }
           if(i==0)
             area.setText("No Bed Available\nThank You!!!");
           else
            {
                String str=""+"Available Beds\n--------------\n";
                for(int j=0;j<i;j++)
                       str += String.valueOf(a[j]) + "\n";

                area.setText(str);
            }

           stat.close();


         }
       else if(cabin.isSelected())
        {  sql = "select cabin_no from cabin_info where flag=1 order by cabin_no";
          stat = connection.createStatement();
          rset = stat.executeQuery(sql);
          int i=0,a[]=new int[100];

          while (rset.next()) {
            a[i]=Integer.parseInt(rset.getString("cabin_no"));
            i++;
          }
          if(i==0)
            area.setText("No Cabin Available\nThank You!!!");
          else
           {
               String str=""+"Available Cabins\n--------------\n";
               for(int j=0;j<i;j++)
                      str += String.valueOf(a[j])+ "\n";

               area.setText(str);
           }

          stat.close();

        }
        else if(gb.isSelected())
        {
          sql = "select gb_no from gb_info where flag=1 order by gb_no";
          stat = connection.createStatement();
          rset = stat.executeQuery(sql);
          int i=0,a[]=new int[100];

          while (rset.next()) {
            a[i]=Integer.parseInt(rset.getString("gb_no"));
            i++;
          }
          if(i==0)
            area.setText("No General Bed Available\nThank You!!!");
          else
           {
               String str=""+"Available General Beds\n--------------\n";
               for(int j=0;j<i;j++)
                      str += String.valueOf(a[j])+ "\n";

               area.setText(str);
           }

          stat.close();

        }
        else if(pb.isSelected())
        {
          sql = "select pb_no from pb_info where flag=1 order by pb_no";
          stat = connection.createStatement();
          rset = stat.executeQuery(sql);
          int i=0,a[]=new int[100];

          while (rset.next()) {
            a[i]=Integer.parseInt(rset.getString("pb_no"));
            i++;
          }
          if(i==0)
            area.setText("No Paying Bed Available\nThank You!!!");
          else
           {
               String str=""+"Available Paying Beds\n--------------\n";
               for(int j=0;j<i;j++)
                      str += String.valueOf(a[j])+ "\n";

               area.setText(str);
           }

          stat.close();

        }


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
     area.setText("");
     String temp[]=new String[1];
     ward_list.setListData(temp);


  }

}

class available_ward_actionAdapter implements java.awt.event.ActionListener {
  available adaptee;

  available_ward_actionAdapter(available adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.ward_actionPerformed(e);
  }
}

class available_cabin_actionAdapter implements java.awt.event.ActionListener {
  available adaptee;

  available_cabin_actionAdapter(available adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.cabin_actionPerformed(e);
  }
}

class available_gb_actionAdapter implements java.awt.event.ActionListener {
  available adaptee;

  available_gb_actionAdapter(available adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.gb_actionPerformed(e);
  }
}

class available_pb_actionAdapter implements java.awt.event.ActionListener {
  available adaptee;

  available_pb_actionAdapter(available adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.pb_actionPerformed(e);
  }
}

class available_jButton1_actionAdapter implements java.awt.event.ActionListener {
  available adaptee;

  available_jButton1_actionAdapter(available adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton1_actionPerformed(e);
  }
}

class available_jButton3_actionAdapter implements java.awt.event.ActionListener {
  available adaptee;

  available_jButton3_actionAdapter(available adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton3_actionPerformed(e);
  }
}

class available_jButton2_actionAdapter implements java.awt.event.ActionListener {
  available adaptee;

  available_jButton2_actionAdapter(available adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton2_actionPerformed(e);
  }
}
