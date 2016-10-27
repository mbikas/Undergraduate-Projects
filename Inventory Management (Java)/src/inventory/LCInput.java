package inventory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.sql.*;

public class LCInput extends JFrame {


  String nam="Chemical",table_name="";
  String types[]={"Chemical","Dyes","Fabrics","Yarn","Accessories"};


  JPanel jPanel1 = new JPanel();
  JLabel jLabel1 = new JLabel();
  JPanel jPanel2 = new JPanel();
  JLabel jLabel2 = new JLabel();
  JScrollPane jScrollPane1 = new JScrollPane();
  JCheckBox box1 = new JCheckBox();
  JTextField name1 = new JTextField();
  JLabel jLabel4 = new JLabel();
  JTextField date1 = new JTextField();
  JTextField val1 = new JTextField();
  JLabel jLabel5 = new JLabel();
  JLabel jLabel6 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JScrollPane jScrollPane2 = new JScrollPane();
  JTextField val2 = new JTextField();
  JCheckBox box2 = new JCheckBox();
  JTextField date2 = new JTextField();
  JTextField name2 = new JTextField();
  JTextField name4 = new JTextField();
  JCheckBox box4 = new JCheckBox();
  JTextField val3 = new JTextField();
  JTextField val4 = new JTextField();
  JCheckBox box3 = new JCheckBox();
  JTextField date4 = new JTextField();
  JTextField date3 = new JTextField();
  JTextField name3 = new JTextField();
  JTextField date5 = new JTextField();
  JTextField name5 = new JTextField();
  JTextField val5 = new JTextField();
  JCheckBox box5 = new JCheckBox();
  Statement stat;
  JList list_date = new JList();
  JPanel jPanel3 = new JPanel();
  JButton Entry = new JButton();
  JButton exit = new JButton();
  JLabel jLabel7 = new JLabel();
  JList list_name = new JList();
  JComboBox combo = new JComboBox(types);


  public LCInput() {
    try {
      jbInit();
      setSize(440,420);
      nam = types[combo.getSelectedIndex()];
      centerScreen();
      intialize();
      show();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }

    //listener for bond name list
  list_name.addListSelectionListener(
      new ListSelectionListener() {
    public void valueChanged(ListSelectionEvent e) {


        ResultSet rset;
        String s = "", sql;

        int x=-1;
        x = list_name.getSelectedIndex();
        if (x !=-1) {
          try{
          s = (String) list_name.getSelectedValue();
          int n = 0;
          if (!s.equals("")) n = Integer.parseInt(s);
          stat = Main.conn.createStatement();
          sql = "select UP_Date from dataentry_" + nam + " where UP_No = " +
              n + " order by UP_Date";
          rset = stat.executeQuery(sql);
          int p = 0, i;
          String str1[] = new String[100];
          while (rset.next()) {
            str1[p] = rset.getString("UP_Date");
            //JOptionPane.showMessageDialog(null,str1[p]);
            p++;
          }
          String str[] = new String[p];
          for (i = 0; i < p; i++)
            str[i] = str1[i];
          list_date.setListData(str);
          stat.close();
          rset.close();
        }
        catch (SQLException sqlException) {
          JOptionPane.showMessageDialog(null, sqlException.getMessage(),
                                        "Database error",
                                        JOptionPane.ERROR_MESSAGE);
        }
      }

    }
  }
  );

  }

  void intialize()
  {
    name1.setText("");
    name2.setText("");
    name3.setText("");
    name4.setText("");
    name5.setText("");

    date1.setText("");
    date2.setText("");
    date3.setText("");
    date4.setText("");
    date5.setText("");

    val1.setText("");
    val2.setText("");
    val3.setText("");
    val4.setText("");
    val5.setText("");


  }

  void centerScreen()
       {
               Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
               int x = (int) ((d.getWidth() - getWidth()) / 2);
               int y = (int) ((d.getHeight() - getHeight()) / 2);
               setLocation(x, y);
       }


  void jbInit() throws Exception {
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setResizable(false);
    this.getContentPane().setLayout(null);
    jPanel1.setBorder(BorderFactory.createRaisedBevelBorder());
    jPanel1.setBounds(new Rectangle(9, 4, 412, 36));
    jPanel1.setLayout(null);
    jLabel1.setFont(new java.awt.Font("Bookman Old Style", 1, 13));
    jLabel1.setForeground(Color.blue);
    jLabel1.setText("LC INPUT");
    jLabel1.setBounds(new Rectangle(175, 5, 74, 25));
    jPanel2.setForeground(Color.blue);
    jPanel2.setBorder(BorderFactory.createLineBorder(Color.black));
    jPanel2.setBounds(new Rectangle(10, 44, 411, 284));
    jPanel2.setLayout(null);
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel2.setText("Select UP No");
    jLabel2.setBounds(new Rectangle(165, 4, 95, 16));
    jScrollPane1.setBounds(new Rectangle(162, 23, 113, 87));

    box1.setText("");
    box1.setBounds(new Rectangle(8, 134, 21, 24));
    box1.addActionListener(new LCInput_box1_actionAdapter(this));
    name1.setEditable(false);
    name1.setBounds(new Rectangle(39, 138, 112, 24));
    jLabel4.setBounds(new Rectangle(53, 117, 58, 16));
    jLabel4.setText("LC No");
    jLabel4.setFont(new java.awt.Font("Dialog", 1, 12));
    date1.setEditable(false);
    date1.setBounds(new Rectangle(161, 138, 112, 24));
    val1.setEditable(false);
    val1.setBounds(new Rectangle(283, 138, 112, 24));
    jLabel5.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel5.setText("LC Date");
    jLabel5.setBounds(new Rectangle(179, 117, 58, 16));
    jLabel6.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel6.setText("LC Value");
    jLabel6.setBounds(new Rectangle(306, 118, 58, 16));
    jLabel3.setBounds(new Rectangle(289, 4, 95, 16));
    jLabel3.setText("Select UP Date");
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 12));
    jScrollPane2.setBounds(new Rectangle(283, 23, 111, 87));
    val2.setEditable(false);
    val2.setBounds(new Rectangle(283, 166, 112, 24));
    box2.setBounds(new Rectangle(8, 162, 21, 24));
    box2.addActionListener(new LCInput_box2_actionAdapter(this));
    box2.setText("");
    date2.setEditable(false);
    date2.setBounds(new Rectangle(161, 166, 112, 24));
    name2.setEditable(false);
    name2.setBounds(new Rectangle(39, 166, 112, 24));
    name4.setEditable(false);
    name4.setBounds(new Rectangle(38, 222, 112, 24));
    box4.setText("");
    box4.setBounds(new Rectangle(7, 218, 21, 24));
    box4.addActionListener(new LCInput_box4_actionAdapter(this));
    val3.setEditable(false);
    val3.setBounds(new Rectangle(282, 194, 112, 24));
    val4.setEditable(false);
    val4.setBounds(new Rectangle(282, 222, 112, 24));
    box3.setBounds(new Rectangle(7, 190, 21, 24));
    box3.addActionListener(new LCInput_box3_actionAdapter(this));
    box3.setText("");
    date4.setEditable(false);
    date4.setBounds(new Rectangle(160, 222, 112, 24));
    date3.setEditable(false);
    date3.setBounds(new Rectangle(160, 194, 112, 24));
    name3.setEditable(false);
    name3.setBounds(new Rectangle(38, 194, 112, 24));
    date5.setEditable(false);
    date5.setBounds(new Rectangle(160, 251, 112, 24));
    name5.setEditable(false);
    name5.setBounds(new Rectangle(38, 251, 112, 24));
    val5.setEditable(false);
    val5.setBounds(new Rectangle(282, 251, 112, 24));
    box5.setBounds(new Rectangle(7, 247, 21, 24));
    box5.addActionListener(new LCInput_box5_actionAdapter(this));
    box5.setText("");
    list_date.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    jPanel3.setBorder(BorderFactory.createEtchedBorder());
    jPanel3.setBounds(new Rectangle(10, 334, 412, 43));
    jPanel3.setLayout(null);
    Entry.setBounds(new Rectangle(34, 8, 99, 26));
    Entry.setFont(new java.awt.Font("Dialog", 1, 12));
    Entry.setBorder(BorderFactory.createRaisedBevelBorder());
    Entry.setMnemonic('E');
    Entry.setText("Entry");
    Entry.addActionListener(new LCInput_Entry_actionAdapter(this));
    exit.setText("Exit");
    exit.addActionListener(new LCInput_exit_actionAdapter(this));
    exit.setFont(new java.awt.Font("Dialog", 1, 12));
    exit.setBounds(new Rectangle(276, 6, 99, 26));
    exit.setBorder(BorderFactory.createRaisedBevelBorder());
    exit.setMnemonic('X');
    jLabel7.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel7.setText("Select Types");
    jLabel7.setBounds(new Rectangle(32, 4, 85, 16));
    combo.setFont(new java.awt.Font("Dialog", 1, 12));
    combo.setBounds(new Rectangle(24, 25, 128, 21));
    combo.addActionListener(new LCInput_combo_actionAdapter(this));
    this.getContentPane().add(jPanel1, null);
    jPanel1.add(jLabel1, null);
    this.getContentPane().add(jPanel2, null);
    jPanel2.add(name1, null);
    jPanel2.add(jLabel4, null);
    jPanel2.add(jLabel5, null);
    jPanel2.add(jLabel6, null);
    jPanel2.add(val1, null);
    jPanel2.add(date1, null);
    jPanel2.add(box1, null);
    jPanel2.add(val2, null);
    jPanel2.add(box2, null);
    jPanel2.add(name2, null);
    jPanel2.add(date2, null);
    jPanel2.add(val3, null);
    jPanel2.add(date4, null);
    jPanel2.add(box4, null);
    jPanel2.add(date3, null);
    jPanel2.add(box3, null);
    jPanel2.add(name3, null);
    jPanel2.add(name4, null);
    jPanel2.add(val4, null);
    jPanel2.add(name5, null);
    jPanel2.add(date5, null);
    jPanel2.add(val5, null);
    jPanel2.add(box5, null);
    jPanel2.add(jScrollPane2, null);
    jScrollPane2.getViewport().add(list_date, null);
    jPanel2.add(jScrollPane1, null);
    jScrollPane1.getViewport().add(list_name, null);
    jPanel2.add(jLabel3, null);
    jPanel2.add(jLabel2, null);
    jPanel2.add(jLabel7, null);
    jPanel2.add(combo, null);
    this.getContentPane().add(jPanel3, null);
    jPanel3.add(Entry, null);
    jPanel3.add(exit, null);

  }

  public static void main(String[] args) {
    LCInput LCInput = new LCInput();
  }

  void box1_actionPerformed(ActionEvent e) {
    if (box1.isSelected()) {
      name1.setEditable(true);
      date1.setEditable(true);
      val1.setEditable(true);
    }
    else {
      name1.setEditable(false);
      date1.setEditable(false);
      val1.setEditable(false);
      name1.setText("");
      date1.setText("");
      val1.setText("");
    }
  }

  void box2_actionPerformed(ActionEvent e) {
    if (box2.isSelected()) {
     name2.setEditable(true);
     date2.setEditable(true);
     val2.setEditable(true);
   }
   else {
     name2.setEditable(false);
     date2.setEditable(false);
     val2.setEditable(false);
     name2.setText("");
     date2.setText("");
     val2.setText("");
   }


  }

  void box3_actionPerformed(ActionEvent e) {

    if (box3.isSelected()) {
     name3.setEditable(true);
     date3.setEditable(true);
     val3.setEditable(true);
   }
   else {
     name3.setEditable(false);
     date3.setEditable(false);
     val3.setEditable(false);
     name3.setText("");
     date3.setText("");
     val3.setText("");
   }


  }

  void box4_actionPerformed(ActionEvent e) {

    if (box4.isSelected()) {
     name4.setEditable(true);
     date4.setEditable(true);
     val4.setEditable(true);
   }
   else {
     name4.setEditable(false);
     date4.setEditable(false);
     val4.setEditable(false);
     name4.setText("");
     date4.setText("");
     val4.setText("");
   }


  }

  void box5_actionPerformed(ActionEvent e) {

    if (box5.isSelected()) {
     name5.setEditable(true);
     date5.setEditable(true);
     val5.setEditable(true);
   }
   else {
     name5.setEditable(false);
     date5.setEditable(false);
     val5.setEditable(false);
     name5.setText("");
     date5.setText("");
     val5.setText("");
   }


  }

  void Entry_actionPerformed(ActionEvent e) {



    String sql="";
    boolean insertResult;
    if(list_name.isSelectionEmpty() || list_date.isSelectionEmpty())
      JOptionPane.showMessageDialog(null,"Select UP Name/Date");
    else
    {
      if (box1.isSelected() &&
          (name1.getText().equals("") || date1.getText().equals("") ||
           val1.getText().equals("")))
        JOptionPane.showMessageDialog(null, "Fill up all the field");
      else if (box2.isSelected() &&
          (name2.getText().equals("") || date2.getText().equals("") ||
           val2.getText().equals("")))
        JOptionPane.showMessageDialog(null, "Fill up all the field");

      else if (box3.isSelected() &&
          (name3.getText().equals("") || date3.getText().equals("") ||
           val3.getText().equals("")))
        JOptionPane.showMessageDialog(null, "Fill up all the field");

      else if (box4.isSelected() &&
          (name4.getText().equals("") || date4.getText().equals("") ||
           val4.getText().equals("")))
        JOptionPane.showMessageDialog(null, "Fill up all the field");

      else if (box5.isSelected() &&
          (name5.getText().equals("") || date5.getText().equals("") ||
           val5.getText().equals("")))
        JOptionPane.showMessageDialog(null, "Fill up all the field");
      else if(!box1.isSelected() &&!box2.isSelected() &&!box3.isSelected() &&!box4.isSelected() &&!box5.isSelected())
        JOptionPane.showMessageDialog(null, "Give Input");
      else
      {

        try {
          /////sql



          String s, up_date = "", lc_date = "";
          int up_no = 0, lc_no;
          double lc_value = 0;

          up_date = (String) list_date.getSelectedValue();
          s = (String) list_name.getSelectedValue();
          up_no = Integer.parseInt(s);


            if (box1.isSelected()) {
              lc_no = Integer.parseInt(name1.getText());
              lc_date = date1.getText();
              lc_value = Double.parseDouble(val1.getText());
              sql = "insert into up_no_"+nam+ " values(" + up_no +
                  ",'" +
                  up_date + "'," + lc_no + ",'" + lc_date + "'," + lc_value +
                  ")";
              Statement stat = Main.conn.createStatement();
              insertResult = stat.execute(sql);
            }
            if (box2.isSelected()) {
              lc_no = Integer.parseInt(name2.getText());
              lc_date = date2.getText();
              lc_value = Double.parseDouble(val2.getText());
              sql = "insert into up_no_" + nam + " values(" + up_no +
                  ",'" +
                  up_date + "'," + lc_no + ",'" + lc_date + "'," + lc_value +
                  ")";
              Statement stat = Main.conn.createStatement();
              insertResult = stat.execute(sql);
            }
            if (box3.isSelected()) {
              lc_no = Integer.parseInt(name3.getText());
              lc_date = date3.getText();
              lc_value = Double.parseDouble(val3.getText());
              sql = "insert into up_no_" + nam + " values(" + up_no +
                  ",'" +
                  up_date + "'," + lc_no + ",'" + lc_date + "'," + lc_value +
                  ")";
              Statement stat = Main.conn.createStatement();
              insertResult = stat.execute(sql);
            }
            if (box4.isSelected()) {
              lc_no = Integer.parseInt(name4.getText());
              lc_date = date4.getText();
              lc_value = Double.parseDouble(val4.getText());
              sql = "insert into up_no_" + nam + " values(" + up_no +
                  ",'" +
                  up_date + "'," + lc_no + ",'" + lc_date + "'," + lc_value +
                  ")";
              Statement stat = Main.conn.createStatement();
              insertResult = stat.execute(sql);
            }
            if (box5.isSelected()) {
              lc_no = Integer.parseInt(name5.getText());
              lc_date = date5.getText();
              lc_value = Double.parseDouble(val5.getText());
              sql = "insert into up_no_" + nam + " values(" + up_no +
                  ",'" +
                  up_date + "'," + lc_no + ",'" + lc_date + "'," + lc_value +
                  ")";
              Statement stat = Main.conn.createStatement();
              insertResult = stat.execute(sql);
            }

          JOptionPane.showMessageDialog(null,
              "Your Information have been successfully saved");

        }
        catch (SQLException sqlException) {
          JOptionPane.showMessageDialog(null, sqlException.getMessage(),
                                        "Database error",
                                        JOptionPane.ERROR_MESSAGE);
        }

      }

    }

  }

  void exit_actionPerformed(ActionEvent e) {
    dispose();
  }

  void combo_actionPerformed(ActionEvent e) {

    String s1[]=new String[0];
    list_name.setListData(s1);
    list_date.setListData(s1);
    nam =types[combo.getSelectedIndex()];
    try {

       ResultSet rset;
       String sql;
       stat = Main.conn.createStatement();
       sql = "select UP_No from dataentry_"+nam+" where UP_No>0 order by UP_No";
       //JOptionPane.showMessageDialog(null,sql);
       rset = stat.executeQuery(sql);
       int p = 0, i;
       String str1[] = new String[100];
       while (rset.next()) {
         str1[p] = rset.getString("UP_No");
         //JOptionPane.showMessageDialog(null,str1[p]);
         p++;
       }
       String str[] = new String[p];
       for (i = 0; i < p; i++)
         str[i] = str1[i];
       list_name.setListData(str);
       stat.close();
       rset.close();
     }
     catch (SQLException sqlException) {
       JOptionPane.showMessageDialog(null, sqlException.getMessage(),
                                     "Database error",
                                     JOptionPane.ERROR_MESSAGE);
     }


  }
}

class LCInput_box1_actionAdapter implements java.awt.event.ActionListener {
  LCInput adaptee;

  LCInput_box1_actionAdapter(LCInput adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.box1_actionPerformed(e);
  }
}

class LCInput_box2_actionAdapter implements java.awt.event.ActionListener {
  LCInput adaptee;

  LCInput_box2_actionAdapter(LCInput adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.box2_actionPerformed(e);
  }
}

class LCInput_box3_actionAdapter implements java.awt.event.ActionListener {
  LCInput adaptee;

  LCInput_box3_actionAdapter(LCInput adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.box3_actionPerformed(e);
  }
}

class LCInput_box4_actionAdapter implements java.awt.event.ActionListener {
  LCInput adaptee;

  LCInput_box4_actionAdapter(LCInput adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.box4_actionPerformed(e);
  }
}

class LCInput_box5_actionAdapter implements java.awt.event.ActionListener {
  LCInput adaptee;

  LCInput_box5_actionAdapter(LCInput adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.box5_actionPerformed(e);
  }
}

class LCInput_Entry_actionAdapter implements java.awt.event.ActionListener {
  LCInput adaptee;

  LCInput_Entry_actionAdapter(LCInput adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.Entry_actionPerformed(e);
  }
}

class LCInput_exit_actionAdapter implements java.awt.event.ActionListener {
  LCInput adaptee;

  LCInput_exit_actionAdapter(LCInput adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.exit_actionPerformed(e);
  }
}

class LCInput_combo_actionAdapter implements java.awt.event.ActionListener {
  LCInput adaptee;

  LCInput_combo_actionAdapter(LCInput adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.combo_actionPerformed(e);
  }
}
