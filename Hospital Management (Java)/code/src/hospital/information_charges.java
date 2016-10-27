
package hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class information_charges extends JFrame {
  JLabel jLabel2 = new JLabel();
  JPanel jPanel4 = new JPanel();
  JPanel jPanel2 = new JPanel();
  JLabel Hospital_name1 = new JLabel();
  JPanel jPanel1 = new JPanel();
  JLabel jLabel1 = new JLabel();
  JTextField bed = new JTextField();
  JTextField cabin = new JTextField();
  JLabel jLabel3 = new JLabel();
  JTextField ot = new JTextField();
  JLabel jLabel4 = new JLabel();
  JTextField del = new JTextField();
  JLabel jLabel5 = new JLabel();
  JTextField po = new JTextField();
  JLabel jLabel6 = new JLabel();
  JTextField pack = new JTextField();
  JLabel jLabel7 = new JLabel();
  JTextField nebu = new JTextField();
  JLabel jLabel8 = new JLabel();
  JLabel jLabel11 = new JLabel();
  JLabel jLabel12 = new JLabel();
  JLabel jLabel14 = new JLabel();
  JLabel jLabel15 = new JLabel();
  JLabel jLabel16 = new JLabel();
  JLabel jLabel17 = new JLabel();
  JTextField oxyzen = new JTextField();
  JTextField patho = new JTextField();
  JTextField radio = new JTextField();
  JTextField ecg = new JTextField();
  JTextField urine = new JTextField();
  JTextField dress = new JTextField();
  JLabel jLabel10 = new JLabel();
  JLabel jLabel13 = new JLabel();
  String p1[]={"Laproscopy Surgery","Major Surgery","Intermediate Surgery","Minor Surgery"};
  JComboBox packs = new JComboBox(p1);
  JPanel jPanel3 = new JPanel();
  JButton jButton1 = new JButton();
  JButton jButton2 = new JButton();
  JButton jButton3 = new JButton();
  String p2[]={"Hospital Solution","Party Solution"};
  JComboBox nebus = new JComboBox(p2);

  public information_charges() {
    try {
      jbInit();
      setSize(600,460);
      setLocation(110,80);
      show();

    bed.setEditable(false);
    cabin.setEditable(false);
    ot.setEditable(false);
    del.setEditable(false);
    po.setEditable(false);
    nebu.setEditable(false);
    pack.setEditable(false);
    oxyzen.setEditable(false);
    patho.setEditable(false);
    radio.setEditable(false);
    ecg.setEditable(false);
    urine.setEditable(false);
    dress.setEditable(false);

    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    jPanel4.setLayout(null);
    jPanel4.setBounds(new Rectangle(6, 56, 578, 35));
    jPanel4.setBackground(new Color(173, 201, 139));
    jPanel4.setBorder(BorderFactory.createLoweredBevelBorder());
    jLabel2.setBounds(new Rectangle(150, 6, 218, 25));
    jLabel2.setText("Information About Bill");
    jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel2.setFont(new java.awt.Font("Book Antiqua", 1, 14));
    this.getContentPane().setBackground(new Color(173, 201, 139));
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setResizable(false);
    this.setTitle("INFOMATION ABOUT CHARGES");
    this.getContentPane().setLayout(null);
    jPanel2.setBackground(new Color(173, 201, 139));
    jPanel2.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel2.setBounds(new Rectangle(6, 7, 579, 46));
    jPanel2.setLayout(null);
    Hospital_name1.setBounds(new Rectangle(21, 12, 536, 28));
    Hospital_name1.setText("JALALABAD RAGIB-RABEYA MEDICAL COLLEGE HOSPITAL");
    Hospital_name1.setForeground(SystemColor.desktop);
    Hospital_name1.setFont(new java.awt.Font("Dialog", 1, 18));
    jPanel1.setBackground(new Color(173, 201, 139));
    jPanel1.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel1.setBounds(new Rectangle(7, 93, 578, 273));
    jPanel1.setLayout(null);
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel1.setText("BED CHARGES:");
    jLabel1.setBounds(new Rectangle(38, 28, 164, 25));
    bed.setBackground(SystemColor.textHighlightText);
    bed.setFont(new java.awt.Font("Dialog", 1, 12));
    bed.setEditable(false);
    bed.setBounds(new Rectangle(221, 29, 82, 22));
    cabin.setBackground(SystemColor.textHighlightText);
    cabin.setFont(new java.awt.Font("Dialog", 1, 12));
    cabin.setBounds(new Rectangle(222, 61, 82, 22));
    jLabel3.setBounds(new Rectangle(39, 60, 174, 25));
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel3.setText("CABIN CHARGES:");
    ot.setBackground(SystemColor.textHighlightText);
    ot.setFont(new java.awt.Font("Dialog", 1, 12));
    ot.setBounds(new Rectangle(221, 92, 82, 22));
    jLabel4.setBounds(new Rectangle(38, 91, 179, 25));
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel4.setText("OT+ANAESTHESIA CHARGES:");
    del.setBackground(SystemColor.textHighlightText);
    del.setFont(new java.awt.Font("Dialog", 1, 12));
    del.setBounds(new Rectangle(223, 122, 82, 22));
    jLabel5.setBounds(new Rectangle(36, 121, 185, 25));
    jLabel5.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel5.setText("NORMAL DELIVERY D&C  CHARGE");
    po.setBackground(SystemColor.textHighlightText);
    po.setFont(new java.awt.Font("Dialog", 1, 12));
    po.setBounds(new Rectangle(223, 152, 82, 22));
    jLabel6.setBounds(new Rectangle(40, 151, 175, 25));
    jLabel6.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel6.setText("PO CHARGES:");
    pack.setBackground(SystemColor.textHighlightText);
    pack.setFont(new java.awt.Font("Dialog", 1, 12));
    pack.setBounds(new Rectangle(400, 213, 82, 22));
    jLabel7.setBounds(new Rectangle(39, 213, 130, 25));
    jLabel7.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel7.setText("PACKAGE CHARGES");
    nebu.setBackground(SystemColor.textHighlightText);
    nebu.setFont(new java.awt.Font("Dialog", 1, 12));
    nebu.setBounds(new Rectangle(401, 244, 82, 22));
    jLabel8.setBounds(new Rectangle(38, 244, 171, 25));
    jLabel8.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel8.setText("NEBULIZATION CHARGES");
    jLabel11.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel11.setText("BED SDE URINE TEST:");
    jLabel11.setBounds(new Rectangle(336, 150, 126, 25));
    jLabel12.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel12.setText("E.C.G CHARGES:");
    jLabel12.setBounds(new Rectangle(336, 120, 122, 25));
    jLabel14.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel14.setText("RADIOLOGY CHARGE:");
    jLabel14.setBounds(new Rectangle(334, 90, 126, 25));
    jLabel15.setBounds(new Rectangle(334, 31, 126, 25));
    jLabel15.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel15.setText("OXYZEN CHARGES:");
    jLabel16.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel16.setText("PATHOLOGY CHARGE:");
    jLabel16.setBounds(new Rectangle(335, 59, 127, 25));
    jLabel17.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel17.setText("DRESSING CHARGES:");
    jLabel17.setBounds(new Rectangle(40, 184, 124, 25));
    oxyzen.setBackground(SystemColor.textHighlightText);
    oxyzen.setFont(new java.awt.Font("Dialog", 1, 12));
    oxyzen.setBounds(new Rectangle(461, 33, 82, 22));
    patho.setBackground(SystemColor.textHighlightText);
    patho.setFont(new java.awt.Font("Dialog", 1, 12));
    patho.setBounds(new Rectangle(462, 63, 82, 22));
    radio.setBackground(SystemColor.textHighlightText);
    radio.setFont(new java.awt.Font("Dialog", 1, 12));
    radio.setBounds(new Rectangle(462, 94, 82, 22));
    ecg.setBackground(SystemColor.textHighlightText);
    ecg.setFont(new java.awt.Font("Dialog", 1, 12));
    ecg.setBounds(new Rectangle(463, 125, 82, 22));
    urine.setBackground(SystemColor.textHighlightText);
    urine.setFont(new java.awt.Font("Dialog", 1, 12));
    urine.setBounds(new Rectangle(463, 155, 82, 22));
    dress.setBackground(SystemColor.textHighlightText);
    dress.setFont(new java.awt.Font("Dialog", 1, 12));
    dress.setBounds(new Rectangle(224, 183, 82, 22));
    jLabel10.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel10.setText("AMOUNT");
    jLabel10.setBounds(new Rectangle(230, 7, 52, 18));
    jLabel13.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel13.setText("AMOUNT");
    jLabel13.setBounds(new Rectangle(471, 10, 55, 19));
    packs.setBackground(new Color(173, 201, 139));
    packs.setFont(new java.awt.Font("Dialog", 1, 12));
    packs.setBounds(new Rectangle(225, 215, 153, 21));
    jPanel3.setBackground(new Color(173, 201, 139));
    jPanel3.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanel3.setBounds(new Rectangle(7, 366, 580, 46));
    jPanel3.setLayout(null);
    jButton1.setBackground(new Color(173, 201, 139));
    jButton1.setBounds(new Rectangle(122, 14, 74, 24));
    jButton1.setFont(new java.awt.Font("Dialog", 1, 12));
    jButton1.setBorder(BorderFactory.createRaisedBevelBorder());
    jButton1.setMnemonic('S');
    jButton1.setText("SHOW");
    jButton1.addActionListener(new information_charges_jButton1_actionAdapter(this));
    jButton2.setBackground(new Color(173, 201, 139));
    jButton2.setBounds(new Rectangle(241, 14, 74, 23));
    jButton2.setFont(new java.awt.Font("Dialog", 1, 12));
    jButton2.setBorder(BorderFactory.createRaisedBevelBorder());
    jButton2.setMnemonic('C');
    jButton2.setText("CLEAR");
    jButton2.addActionListener(new information_charges_jButton2_actionAdapter(this));
    jButton3.setBackground(new Color(173, 201, 139));
    jButton3.setBounds(new Rectangle(356, 14, 72, 23));
    jButton3.setFont(new java.awt.Font("Dialog", 1, 12));
    jButton3.setBorder(BorderFactory.createRaisedBevelBorder());
    jButton3.setMnemonic('L');
    jButton3.setText("CLOSE");
    jButton3.addActionListener(new information_charges_jButton3_actionAdapter(this));
    nebus.setBackground(new Color(173, 201, 139));
    nebus.setFont(new java.awt.Font("Dialog", 1, 12));
    nebus.setBounds(new Rectangle(226, 245, 153, 21));
    this.getContentPane().add(jPanel2, null);
    jPanel2.add(Hospital_name1, null);
    jPanel1.add(jLabel1, null);
    jPanel1.add(jLabel3, null);
    jPanel1.add(jLabel4, null);
    jPanel1.add(jLabel5, null);
    jPanel1.add(jLabel6, null);
    jPanel1.add(jLabel16, null);
    jPanel1.add(jLabel14, null);
    jPanel1.add(jLabel12, null);
    jPanel1.add(jLabel11, null);
    jPanel1.add(bed, null);
    jPanel1.add(cabin, null);
    jPanel1.add(ot, null);
    jPanel1.add(del, null);
    jPanel1.add(po, null);
    jPanel1.add(jLabel15, null);
    jPanel1.add(jLabel10, null);
    jPanel1.add(oxyzen, null);
    jPanel1.add(patho, null);
    jPanel1.add(radio, null);
    jPanel1.add(urine, null);
    jPanel1.add(ecg, null);
    jPanel1.add(jLabel13, null);
    jPanel1.add(jLabel17, null);
    jPanel1.add(dress, null);
    jPanel1.add(jLabel7, null);
    jPanel1.add(jLabel8, null);
    jPanel1.add(pack, null);
    jPanel1.add(packs, null);
    jPanel1.add(nebus, null);
    jPanel1.add(nebu, null);
    this.getContentPane().add(jPanel3, null);
    this.getContentPane().add(jPanel4, null);
    jPanel4.add(jLabel2, null);
    this.getContentPane().add(jPanel1, null);
    jPanel3.add(jButton1, null);
    jPanel3.add(jButton2, null);
    jPanel3.add(jButton3, null);
  }

  public static void main(String[] args) {
    information_charges information_charges = new information_charges();
  }

  void jButton1_actionPerformed(ActionEvent e) {

    bed.setText("150");
    cabin.setText("350");
    ot.setText("3500");
    del.setText("3000");
    po.setText("2500");
    cabin.setText("350");
    cabin.setText("350");
    if(packs.getSelectedIndex()==0)
       pack.setText("10000");
    else if(packs.getSelectedIndex()==1)
       pack.setText("25000");
    else if(packs.getSelectedIndex()==2)
       pack.setText("15000");
    else if(packs.getSelectedIndex()==3)
     pack.setText("7500");

    if(nebus.getSelectedIndex()==0)
      nebu.setText("2500");
    else if(nebus.getSelectedIndex()==1)
       nebu.setText("2000");

    oxyzen.setText("900");
    patho.setText("700");
    radio.setText("250");
    ecg.setText("500");
    urine.setText("300");
    dress.setText("150");



  }

  void jButton2_actionPerformed(ActionEvent e) {

    bed.setText("");
   cabin.setText("");
   ot.setText("");
   del.setText("");
   po.setText("");
   cabin.setText("");
   cabin.setText("");
   pack.setText("");
   nebu.setText("");
   oxyzen.setText("");
   patho.setText("");
   radio.setText("");
   ecg.setText("");
   urine.setText("");
   dress.setText("");


  }

  void jButton3_actionPerformed(ActionEvent e) {
          dispose();
  }
}

class information_charges_jButton1_actionAdapter implements java.awt.event.ActionListener {
  information_charges adaptee;

  information_charges_jButton1_actionAdapter(information_charges adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton1_actionPerformed(e);
  }
}

class information_charges_jButton2_actionAdapter implements java.awt.event.ActionListener {
  information_charges adaptee;

  information_charges_jButton2_actionAdapter(information_charges adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton2_actionPerformed(e);
  }
}

class information_charges_jButton3_actionAdapter implements java.awt.event.ActionListener {
  information_charges adaptee;

  information_charges_jButton3_actionAdapter(information_charges adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton3_actionPerformed(e);
  }
}
