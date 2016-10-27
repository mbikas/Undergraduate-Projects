
package hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.*;

public class seat_entry extends JFrame {

  Connection connection;
  public int ward_id,cabin_id,gb_id,pb_id;

  public int total_ward,total_cabin,total_pb,total_gb;
  JLabel jLabel2 = new JLabel();
  JPanel jPanel4 = new JPanel();
  JPanel jPanel2 = new JPanel();
  JLabel Hospital_name1 = new JLabel();
  JPanel jPanel1 = new JPanel();
  String catagories[]={"Ward","General Bed","Cabin","Paying Bed"};
  String depts[]={"Medicine","Surgery","Gynae","Paediactric","Orthopaeddics","Neoral"};
  JPanel jPanel3 = new JPanel();
  JButton entry = new JButton();
  JButton close = new JButton();
  JTextField bed = new JTextField();
  JLabel bed_label = new JLabel();
  JRadioButton ward = new JRadioButton();
  JRadioButton cabin = new JRadioButton();
  JTextField cabin_text = new JTextField();
  ButtonGroup group = new ButtonGroup();
  JTextField tcabin = new JTextField();
  JTextField tward = new JTextField();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JRadioButton rgb = new JRadioButton();
  JTextField gb = new JTextField();
  JRadioButton rpb = new JRadioButton();
  JTextField pb = new JTextField();
  JLabel jLabel4 = new JLabel();
  JTextField tpb = new JTextField();
  JLabel jLabel5 = new JLabel();
  JTextField tgb = new JTextField();

  public seat_entry() {
    try {
      jbInit();
      setSize(600,400);
      setLocation(110,80);
      show();

      bed_label.setEnabled(false);
      bed.setEnabled(false);
      cabin_text.setEnabled(false);



           Statement stat;
           String sql;
           ResultSet rset;

           connection = Main.connection;

           stat = connection.createStatement();
           sql ="select total_cabin,total_ward,total_gb,total_pb from total_ward_cabin_gb_pb";
           rset = stat.executeQuery(sql);

           while(rset.next()){
             total_cabin = Integer.parseInt(rset.getString("total_cabin"));
             total_ward = Integer.parseInt(rset.getString("total_ward"));
             total_gb= Integer.parseInt(rset.getString("total_gb"));
             total_pb= Integer.parseInt(rset.getString("total_pb"));
            }


            stat.close();
            rset.close();


            tcabin.setText(String.valueOf(total_cabin));
            tward.setText(String.valueOf(total_ward));
            tcabin.setEditable(false);
            tward.setEditable(false);

            tgb.setText(String.valueOf(total_cabin));
            tpb.setText(String.valueOf(total_ward));
            tgb.setEditable(false);
            tpb.setEditable(false);


   }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    jPanel4.setLayout(null);
    jPanel4.setBounds(new Rectangle(6, 71, 580, 35));
    jPanel4.setBackground(new Color(173, 201, 139));
    jPanel4.setBorder(BorderFactory.createLoweredBevelBorder());
    jLabel2.setBounds(new Rectangle(150, 6, 218, 25));
    jLabel2.setText("Seat Entry");
    jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel2.setFont(new java.awt.Font("Book Antiqua", 1, 14));
    this.getContentPane().setLayout(null);
    jPanel2.setBackground(new Color(173, 201, 139));
    jPanel2.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel2.setBounds(new Rectangle(5, 5, 580, 62));
    jPanel2.setLayout(null);
    Hospital_name1.setBounds(new Rectangle(21, 12, 557, 28));
    Hospital_name1.setText("JALALABAD RAGIB-RABEYA MEDICAL COLLEGE HOSPITAL");
    Hospital_name1.setForeground(SystemColor.desktop);
    Hospital_name1.setFont(new java.awt.Font("Dialog", 1, 18));
    jPanel1.setBackground(new Color(173, 201, 139));
    jPanel1.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel1.setBounds(new Rectangle(258, 119, 261, 149));
    jPanel1.setLayout(null);
    jPanel3.setLayout(null);
    jPanel3.setBounds(new Rectangle(5, 276, 580, 74));
    jPanel3.setBackground(new Color(173, 201, 139));
    jPanel3.setBorder(BorderFactory.createLoweredBevelBorder());
    entry.setText("ENTRY");
    entry.addActionListener(new seat_entry_entry_actionAdapter(this));
    entry.setMnemonic('E');
    entry.setBorder(BorderFactory.createRaisedBevelBorder());
    entry.setFont(new java.awt.Font("Dialog", 1, 12));
    entry.setBackground(new Color(173, 201, 139));
    entry.setBounds(new Rectangle(194, 23, 72, 26));
    close.setText("CLOSE");
    close.addActionListener(new seat_entry_close_actionAdapter(this));
    close.setMnemonic('L');
    close.setBorder(BorderFactory.createRaisedBevelBorder());
    close.setVerifyInputWhenFocusTarget(true);
    close.setFont(new java.awt.Font("Dialog", 1, 12));
    close.setBackground(new Color(173, 201, 139));
    close.setBounds(new Rectangle(311, 23, 66, 27));
    this.getContentPane().setBackground(new Color(173, 201, 139));
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setResizable(false);
    this.setTitle("SEAT ENTRY");
    bed.setBackground(SystemColor.textHighlightText);
    bed.setFont(new java.awt.Font("Dialog", 1, 12));
    bed.setText("");
    bed.setBounds(new Rectangle(150, 7, 83, 30));
    bed_label.setBackground(new Color(173, 201, 139));
    bed_label.setFont(new java.awt.Font("Dialog", 1, 12));
    bed_label.setDebugGraphicsOptions(0);
    bed_label.setText("BED");
    bed_label.setBounds(new Rectangle(95, 7, 44, 31));
    ward.setBackground(new Color(173, 201, 139));
    ward.setFont(new java.awt.Font("Dialog", 1, 12));
    ward.setText("WARD");
    ward.setBounds(new Rectangle(17, 6, 75, 31));
    ward.addActionListener(new seat_entry_ward_actionAdapter(this));
    cabin.setBackground(new Color(173, 201, 139));
    cabin.setFont(new java.awt.Font("Dialog", 1, 12));
    cabin.setText("CABIN");
    cabin.setBounds(new Rectangle(16, 47, 71, 34));
    cabin.addActionListener(new seat_entry_cabin_actionAdapter(this));
    cabin_text.setBackground(SystemColor.textHighlightText);
    cabin_text.setFont(new java.awt.Font("Dialog", 1, 12));
    cabin_text.setBounds(new Rectangle(150, 47, 82, 26));
    tcabin.setBackground(SystemColor.textHighlightText);
    tcabin.setFont(new java.awt.Font("Dialog", 1, 12));
    tcabin.setText("");
    tcabin.setBounds(new Rectangle(161, 120, 87, 29));
    tward.setBackground(SystemColor.textHighlightText);
    tward.setFont(new java.awt.Font("Dialog", 1, 12));
    tward.setText("");
    tward.setBounds(new Rectangle(162, 162, 85, 28));
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1.setText("TOTAL CABIN:");
    jLabel1.setBounds(new Rectangle(30, 119, 111, 27));
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel3.setText("TOTAL WARD:");
    jLabel3.setBounds(new Rectangle(28, 163, 109, 29));
    rgb.setBackground(new Color(173, 201, 139));
    rgb.setFont(new java.awt.Font("Dialog", 1, 12));
    rgb.setText("GENERAL BED:");
    rgb.setBounds(new Rectangle(20, 86, 119, 23));
    rgb.addActionListener(new seat_entry_rgb_actionAdapter(this));
    gb.setBackground(SystemColor.textHighlightText);
    gb.setFont(new java.awt.Font("Dialog", 1, 12));
    gb.setText("");
    gb.setBounds(new Rectangle(151, 87, 82, 23));
    rpb.setBackground(new Color(173, 201, 139));
    rpb.setFont(new java.awt.Font("Dialog", 1, 12));
    rpb.setText("PAYING BED:");
    rpb.setBounds(new Rectangle(22, 120, 121, 16));
    rpb.addActionListener(new seat_entry_rpb_actionAdapter(this));
    pb.setBackground(SystemColor.textHighlightText);
    pb.setFont(new java.awt.Font("Dialog", 1, 12));
    pb.setText("");
    pb.setBounds(new Rectangle(151, 117, 83, 25));
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel4.setText("TOTAL PAYING BED:");
    jLabel4.setBounds(new Rectangle(26, 202, 114, 31));
    tpb.setBackground(SystemColor.textHighlightText);
    tpb.setFont(new java.awt.Font("Dialog", 1, 12));
    tpb.setText("");
    tpb.setBounds(new Rectangle(163, 205, 83, 30));
    jLabel5.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel5.setText("TOTAL GENERAL BED:");
    jLabel5.setBounds(new Rectangle(24, 245, 124, 29));
    tgb.setBackground(SystemColor.textHighlightText);
    tgb.setFont(new java.awt.Font("Dialog", 1, 12));
    tgb.setBounds(new Rectangle(162, 245, 85, 26));
    this.getContentPane().add(jPanel2, null);
    jPanel2.add(Hospital_name1, null);
    this.getContentPane().add(jPanel4, null);
    jPanel4.add(jLabel2, null);
    this.getContentPane().add(jPanel3, null);
    jPanel3.add(entry, null);
    jPanel3.add(close, null);
    jPanel1.add(ward, null);
    jPanel1.add(bed, null);
    jPanel1.add(rgb, null);
    jPanel1.add(pb, null);
    jPanel1.add(gb, null);
    jPanel1.add(rpb, null);
    jPanel1.add(cabin, null);
    jPanel1.add(cabin_text, null);
    jPanel1.add(bed_label, null);
    this.getContentPane().add(tpb, null);
    this.getContentPane().add(tward, null);
    this.getContentPane().add(tcabin, null);
    this.getContentPane().add(jLabel4, null);
    this.getContentPane().add(jLabel1, null);
    this.getContentPane().add(jLabel3, null);
    group.add(ward);
    group.add(cabin);
    group.add(rgb);
    group.add(rpb);
    this.getContentPane().add(jLabel5, null);
    this.getContentPane().add(tgb, null);
    this.getContentPane().add(jPanel1, null);
  }

  public static void main(String[] args) {
    seat_entry seat_entry = new seat_entry();
  }


  void entry_actionPerformed(ActionEvent e) {



    if(!ward.isSelected() &&  !cabin.isSelected() && !rgb.isSelected() &&  !rpb.isSelected())
      JOptionPane.showMessageDialog(null,"Select a catagory","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);

    else if(ward.isSelected() && bed.getText().equals(""))
      JOptionPane.showMessageDialog(null,"Insert Total Bed ","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
    else if(cabin.isSelected() && cabin_text.getText().equals(""))
     JOptionPane.showMessageDialog(null,"Insert Total Cabin","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
    else if(rgb.isSelected() && gb.getText().equals(""))
     JOptionPane.showMessageDialog(null,"Insert Total General Bed","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
    else if(rpb.isSelected() && pb.getText().equals(""))
        JOptionPane.showMessageDialog(null,"Insert Total Paying Bed","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
   else{


      try {

        boolean insertResult1, insertResult2;
        Statement stat;
        String sql;
        ResultSet rset;

        if (cabin.isSelected()) {
          //System.out.println(total_cabin);
          int i, ct = Integer.parseInt(cabin_text.getText());

          for (i = 0; i < ct; i++) {
            total_cabin++;
            sql = "insert into cabin_info values(" + total_cabin + ",1)";
            stat = connection.createStatement();
            insertResult1 = stat.execute(sql);
            stat.close();
          }
        }
        else if (ward.isSelected()) {
          int i, tbed = Integer.parseInt(bed.getText());

          total_ward++;
          for (i = 1; i <= tbed; i++) {
            sql = "insert into ward_info values(" + total_ward + "," + i +
                ",1)";
            stat = connection.createStatement();
            insertResult1 = stat.execute(sql);
            stat.close();
          }
        }

        else if (rgb.isSelected()) {
          int i, ct = Integer.parseInt(gb.getText());

          for (i = 0; i < ct; i++) {
            total_gb++;
            sql = "insert into gb_info values(" + total_gb + ",1)";
            stat = connection.createStatement();
            insertResult1 = stat.execute(sql);
            stat.close();
          }

        }
        else if (rpb.isSelected()) {
          int i, ct = Integer.parseInt(pb.getText());

          for (i = 0; i < ct; i++) {
            total_pb++;
            sql = "insert into pb_info values(" + total_pb + ",1)";
            stat = connection.createStatement();
            insertResult1 = stat.execute(sql);
            stat.close();
          }

        }

        //updaing id in the  table generator
        sql = "delete from total_ward_cabin_gb_pb";
        stat = connection.createStatement();
        insertResult1 = stat.execute(sql);
        stat.close();
        sql = "insert into total_ward_cabin_gb_pb values(" + total_cabin + "," +
            total_ward + "," + total_gb + "," + total_pb + ")";
        stat = connection.createStatement();
        insertResult2 = stat.execute(sql);
        stat.close();
        ///////////////end of generating id/////////////////////

        tcabin.setText(String.valueOf(total_cabin));
        tward.setText(String.valueOf(total_ward));
        tgb.setText(String.valueOf(total_gb));
        tpb.setText(String.valueOf(total_pb));

        JOptionPane.showMessageDialog(null,
            "Your Information have successfully saved.", "CONFIRMATION MESSAGE",
                                      JOptionPane.INFORMATION_MESSAGE);

      }
      catch (SQLException sqlException) {
        JOptionPane.showMessageDialog(null, sqlException.getMessage(),
                                      "Database error",
                                      JOptionPane.ERROR_MESSAGE);
      }
    }







  }

  void close_actionPerformed(ActionEvent e) {
  dispose();
  }

  void cabin_actionPerformed(ActionEvent e) {
      bed.setText("");
      bed_label.setEnabled(false);
      bed.setEnabled(false);
      cabin_text.setEnabled(true);
      pb.setText("");
      pb.setEnabled(false);
      gb.setText("");
      gb.setEnabled(false);


    }

  void ward_actionPerformed(ActionEvent e) {

      bed_label.setEnabled(true);
      bed.setEnabled(true);
      cabin_text.setEnabled(false);
      cabin_text.setText("");
      pb.setText("");
      pb.setEnabled(false);
      gb.setText("");
      gb.setEnabled(false);


  }

  void rgb_actionPerformed(ActionEvent e) {

      bed_label.setEnabled(false);
      bed.setEnabled(false);
      bed.setText("");
      cabin_text.setEnabled(false);
      cabin_text.setText("");
      pb.setText("");
      pb.setEnabled(false);
      gb.setEnabled(true);


  }

  void rpb_actionPerformed(ActionEvent e) {

     bed_label.setEnabled(false);
     bed.setEnabled(false);
     bed.setText("");
     cabin_text.setEnabled(false);
     cabin_text.setText("");
     gb.setText("");
     gb.setEnabled(false);
     pb.setEnabled(true);


  }
}

class seat_entry_entry_actionAdapter implements java.awt.event.ActionListener {
  seat_entry adaptee;

  seat_entry_entry_actionAdapter(seat_entry adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.entry_actionPerformed(e);
  }
}

class seat_entry_close_actionAdapter implements java.awt.event.ActionListener {
  seat_entry adaptee;

  seat_entry_close_actionAdapter(seat_entry adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.close_actionPerformed(e);
  }
}

class seat_entry_cabin_actionAdapter implements java.awt.event.ActionListener {
  seat_entry adaptee;

  seat_entry_cabin_actionAdapter(seat_entry adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.cabin_actionPerformed(e);
  }
}

class seat_entry_ward_actionAdapter implements java.awt.event.ActionListener {
  seat_entry adaptee;

  seat_entry_ward_actionAdapter(seat_entry adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.ward_actionPerformed(e);
  }
}

class seat_entry_rgb_actionAdapter implements java.awt.event.ActionListener {
  seat_entry adaptee;

  seat_entry_rgb_actionAdapter(seat_entry adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.rgb_actionPerformed(e);
  }
}

class seat_entry_rpb_actionAdapter implements java.awt.event.ActionListener {
  seat_entry adaptee;

  seat_entry_rpb_actionAdapter(seat_entry adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.rpb_actionPerformed(e);
  }
}
