package inventory;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import com.borland.dbswing.*;
import java.awt.event.*;
import java.sql.*;
import java.text.DecimalFormat;

import com.borland.dx.sql.dataset.*;
import com.borland.dbswing.*;
import com.borland.dx.sql.dataset.ConnectionDescriptor;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class search_item extends JFrame {
  String b[]=new String[22];
  String select="";
  boolean selected[]=new boolean[22];

Connection connection=Main.conn;
  String names[]= {"Show All","Bond Name","Bond Date","Into Bond Date","L/C No","L/C Date"
                    ,"B/E No","B/E Date","Chemical Name","Chemical Description",
                    "Import Quantity","Import Value","Unit Price",
                    "HS Code","Page No","Volume","UP No","UP Date"};
  JPanel jPanel1 = new JPanel();
  JLabel jLabel1 = new JLabel();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel3 = new JPanel();
  TitledBorder titledBorder1;
  TableScrollPane tableScrollPane1 = new TableScrollPane();
  JdbTable JDbTable1 = new JdbTable();

  JPanel jPanel4 = new JPanel();
  JButton search = new JButton();
  JButton jButton2 = new JButton();
  ButtonGroup group = new ButtonGroup();
  Database database1 = new Database();
  QueryDataSet queryDataSet1 = new QueryDataSet();

  JComboBox combo = new JComboBox(names);
  JLabel jLabel2 = new JLabel();
  JTextField one = new JTextField();
  JTextField two = new JTextField();
  JLabel label1 = new JLabel();
  JLabel label2 = new JLabel();
  JLabel label3 = new JLabel();
  JLabel label4 = new JLabel();
  JTextField text3 = new JTextField();
  JTextField text4 = new JTextField();
  JPanel jPanel5 = new JPanel();
  JLabel jLabel3 = new JLabel();
  JCheckBox box1 = new JCheckBox();
  JCheckBox box2 = new JCheckBox();
  JCheckBox box3 = new JCheckBox();
  JCheckBox box4 = new JCheckBox();
  JCheckBox box5 = new JCheckBox();
  JCheckBox box7 = new JCheckBox();
  JCheckBox box9 = new JCheckBox();
  JCheckBox box6 = new JCheckBox();
  JCheckBox box10 = new JCheckBox();
  JCheckBox box8 = new JCheckBox();
  JCheckBox box12 = new JCheckBox();
  JCheckBox box14 = new JCheckBox();
  JCheckBox box20 = new JCheckBox();
  JCheckBox box16 = new JCheckBox();
  JCheckBox box17 = new JCheckBox();
  JCheckBox box11 = new JCheckBox();
  JCheckBox box19 = new JCheckBox();
  JCheckBox box18 = new JCheckBox();
  JCheckBox box15 = new JCheckBox();
  JCheckBox box13 = new JCheckBox();
  JCheckBox box21 = new JCheckBox();
  JTextField text6 = new JTextField();
  JLabel label6 = new JLabel();
  JTextField text5 = new JTextField();
  JLabel label5 = new JLabel();



  public search_item() {
    try {
      jbInit();

      box8.setText(Main.names+" Name");
      box9.setText(Main.names+" Description");

      for (int i = 1; i <= 21; i++) selected[i] = false;
      select = "*";
      select_all();
      one.setVisible(false);
      two.setVisible(false);
      label1.setVisible(false);
      label2.setVisible(false);
      label3.setVisible(false);
      label4.setVisible(false);
      label5.setVisible(false);
      label6.setVisible(false);
      label1.setText("");
      label2.setText("");
      text3.setVisible(false);
      text4.setVisible(false);
      text5.setVisible(false);
      text6.setVisible(false);
      JDbTable1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

      //JDbTable1.setSelectionMode();
      setSize(740, 535);
      centerScreen();
      show();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }


  }

  void centerScreen()
        {
                Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
                int x = (int) ((d.getWidth() - getWidth()) / 2);
                int y = (int) ((d.getHeight() - getHeight()) / 2);
                setLocation(x, y);
        }


  void jbInit() throws Exception {
    titledBorder1 = new TitledBorder("");
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setResizable(false);
    this.getContentPane().setLayout(null);
    jPanel1.setBorder(BorderFactory.createRaisedBevelBorder());
    jPanel1.setBounds(new Rectangle(5, 1, 569, 37));
    jPanel1.setLayout(null);
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1.setForeground(Color.blue);
    jLabel1.setText("SEARCH  ITEMS");
    jLabel1.setBounds(new Rectangle(226, 3, 96, 26));
    jPanel2.setBorder(BorderFactory.createLineBorder(Color.black));
    jPanel2.setToolTipText("");
    jPanel2.setBounds(new Rectangle(5, 39, 568, 62));
    jPanel2.setLayout(null);
    jPanel3.setFont(new java.awt.Font("Dialog", 1, 12));
    jPanel3.setBorder(BorderFactory.createEtchedBorder());
    jPanel3.setBounds(new Rectangle(5, 104, 570, 341));
    jPanel3.setLayout(null);
    tableScrollPane1.setAutoscrolls(true);
    tableScrollPane1.setBorder(BorderFactory.createLineBorder(Color.black));
    tableScrollPane1.setMaximumSize(new Dimension(32767, 32767));
    tableScrollPane1.setBounds(new Rectangle(9, 7, 554, 261));
    jPanel4.setBorder(BorderFactory.createLineBorder(Color.black));
    jPanel4.setBounds(new Rectangle(6, 448, 569, 45));
    jPanel4.setLayout(null);
    search.setBounds(new Rectangle(83, 5, 101, 29));
    search.setFont(new java.awt.Font("Dialog", 1, 12));
    search.setBorder(BorderFactory.createRaisedBevelBorder());
    search.setBorderPainted(true);
    search.setMnemonic('S');
    search.setText("Search");
    search.addActionListener(new search_item_search_actionAdapter(this));
    jButton2.setText("Exit");
    jButton2.addActionListener(new search_item_jButton2_actionAdapter(this));
    jButton2.setBorderPainted(true);
    jButton2.setBorder(BorderFactory.createRaisedBevelBorder());
    jButton2.setFont(new java.awt.Font("Dialog", 1, 12));
    jButton2.setBounds(new Rectangle(436, 6, 101, 29));
    combo.setFont(new java.awt.Font("Dialog", 1, 12));
    combo.setBounds(new Rectangle(5, 27, 151, 27));
    combo.addActionListener(new search_item_combo_actionAdapter(this));
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 11));
    jLabel2.setText("Select Search Criteria");
    jLabel2.setBounds(new Rectangle(5, 7, 143, 16));
    one.setText("");
    one.setBounds(new Rectangle(191, 26, 164, 28));
    two.setText("");
    two.setBounds(new Rectangle(382, 26, 167, 28));
    label1.setText("Enter ");
    label1.setBounds(new Rectangle(206, 4, 148, 16));
    label1.setFont(new java.awt.Font("Dialog", 1, 11));
    label1.setText("Give Search Word");
    label2.setFont(new java.awt.Font("Dialog", 1, 11));
    label2.setText("Give Search Word");
    label2.setBounds(new Rectangle(400, 4, 149, 16));
    label3.setFont(new java.awt.Font("Dialog", 1, 12));
    label3.setBorder(BorderFactory.createLineBorder(Color.black));
    label3.setHorizontalAlignment(SwingConstants.CENTER);
    label3.setHorizontalTextPosition(SwingConstants.CENTER);
    label3.setText("Total Import Quantity");
    label3.setBounds(new Rectangle(8, 272, 142, 29));
    label4.setBounds(new Rectangle(157, 272, 122, 29));
    label4.setText("Total Import Value");
    label4.setBorder(BorderFactory.createLineBorder(Color.black));
    label4.setHorizontalAlignment(SwingConstants.CENTER);
    label4.setFont(new java.awt.Font("Dialog", 1, 12));
    label4.setAlignmentX((float) 0.0);
    text3.setEnabled(true);
    text3.setFont(new java.awt.Font("Dialog", 1, 12));
    text3.setForeground(Color.blue);
    text3.setBorder(BorderFactory.createLineBorder(Color.black));
    text3.setDisabledTextColor(Color.blue);
    text3.setEditable(false);
    text3.setText("");
    text3.setHorizontalAlignment(SwingConstants.CENTER);
    text3.setBounds(new Rectangle(8, 301, 142, 29));
    text4.setBounds(new Rectangle(157, 301, 122, 29));
    text4.setText("");
    text4.setHorizontalAlignment(SwingConstants.CENTER);
    text4.setEditable(false);
    text4.setDisabledTextColor(Color.blue);
    text4.setForeground(Color.blue);
    text4.setBorder(BorderFactory.createLineBorder(Color.black));
    text4.setEnabled(true);
    text4.setFont(new java.awt.Font("Dialog", 1, 12));
    jPanel5.setBorder(BorderFactory.createLineBorder(Color.black));
    jPanel5.setBounds(new Rectangle(577, 2, 152, 491));
    jPanel5.setLayout(null);
    jLabel3.setBackground(Color.pink);
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 13));
    jLabel3.setForeground(Color.red);
    jLabel3.setAlignmentY((float) 0.5);
    jLabel3.setBorder(BorderFactory.createEtchedBorder());
    jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel3.setHorizontalTextPosition(SwingConstants.CENTER);
    jLabel3.setText("Select Fields");
    jLabel3.setBounds(new Rectangle(11, 5, 118, 20));
    box1.setFont(new java.awt.Font("Dialog", 1, 12));
    box1.setText("Bond Name");
    box1.setBounds(new Rectangle(4, 27, 108, 23));
    box1.addActionListener(new search_item_box1_actionAdapter(this));
    box2.setBounds(new Rectangle(4, 49, 108, 23));
    box2.addActionListener(new search_item_box2_actionAdapter(this));
    box2.setText("Bond Date");
    box2.setFont(new java.awt.Font("Dialog", 1, 12));
    box3.setBounds(new Rectangle(4, 70, 108, 23));
    box3.addActionListener(new search_item_box3_actionAdapter(this));
    box3.setText("Into Bond Date");
    box3.setFont(new java.awt.Font("Dialog", 1, 12));
    box4.setBounds(new Rectangle(4, 93, 108, 23));
    box4.addActionListener(new search_item_box4_actionAdapter(this));
    box4.setText("LC No");
    box4.setFont(new java.awt.Font("Dialog", 1, 12));
    box5.setBounds(new Rectangle(4, 116, 108, 23));
    box5.addActionListener(new search_item_box5_actionAdapter(this));
    box5.setText("LC Date");
    box5.setFont(new java.awt.Font("Dialog", 1, 12));
    box7.setFont(new java.awt.Font("Dialog", 1, 12));
    box7.setText("BE Date");
    box7.setBounds(new Rectangle(5, 158, 108, 23));
    box7.addActionListener(new search_item_box7_actionAdapter(this));
    box9.setFont(new java.awt.Font("Dialog", 1, 12));
    box9.setText("Chemical Description");
    box9.setBounds(new Rectangle(5, 202, 146, 23));
    box9.addActionListener(new search_item_box9_actionAdapter(this));
    box6.setBounds(new Rectangle(5, 136, 108, 23));
    box6.addActionListener(new search_item_box6_actionAdapter(this));
    box6.setText("BE No");
    box6.setFont(new java.awt.Font("Dialog", 1, 12));
    box10.setFont(new java.awt.Font("Dialog", 1, 12));
    box10.setText("Import Quantity");
    box10.setBounds(new Rectangle(5, 225, 125, 23));
    box10.addActionListener(new search_item_box10_actionAdapter(this));
    box8.setFont(new java.awt.Font("Dialog", 1, 12));
    box8.setText("Chemical Name");
    box8.setBounds(new Rectangle(5, 179, 135, 23));
    box8.addActionListener(new search_item_box8_actionAdapter(this));
    box12.setFont(new java.awt.Font("Dialog", 1, 12));
    box12.setText("Adjusted Quantity");
    box12.setBounds(new Rectangle(5, 269, 135, 23));
    box12.addActionListener(new search_item_box12_actionAdapter(this));
    box14.setFont(new java.awt.Font("Dialog", 1, 12));
    box14.setText("Balanced Quantity");
    box14.setBounds(new Rectangle(5, 313, 131, 23));
    box14.addActionListener(new search_item_box14_actionAdapter(this));
    box20.setBounds(new Rectangle(6, 445, 108, 23));
    box20.addActionListener(new search_item_box20_actionAdapter(this));
    box20.setText("UP No");
    box20.setFont(new java.awt.Font("Dialog", 1, 12));
    box16.setFont(new java.awt.Font("Dialog", 1, 12));
    box16.setText("Unit Price");
    box16.setBounds(new Rectangle(6, 356, 108, 23));
    box16.addActionListener(new search_item_box16_actionAdapter(this));
    box17.setBounds(new Rectangle(6, 378, 108, 23));
    box17.addActionListener(new search_item_box17_actionAdapter(this));
    box17.setText("HS Code");
    box17.setFont(new java.awt.Font("Dialog", 1, 12));
    box11.setBounds(new Rectangle(5, 247, 108, 23));
    box11.addActionListener(new search_item_box11_actionAdapter(this));
    box11.setText("Import Value");
    box11.setFont(new java.awt.Font("Dialog", 1, 12));
    box19.setBounds(new Rectangle(6, 422, 108, 23));
    box19.addActionListener(new search_item_box19_actionAdapter(this));
    box19.setText("Volume");
    box19.setFont(new java.awt.Font("Dialog", 1, 12));
    box18.setBounds(new Rectangle(6, 399, 108, 23));
    box18.addActionListener(new search_item_box18_actionAdapter(this));
    box18.setText("Page No");
    box18.setFont(new java.awt.Font("Dialog", 1, 12));
    box15.setFont(new java.awt.Font("Dialog", 1, 12));
    box15.setText("Balanced Value");
    box15.setBounds(new Rectangle(5, 336, 122, 23));
    box15.addActionListener(new search_item_box15_actionAdapter(this));
    box13.setFont(new java.awt.Font("Dialog", 1, 12));
    box13.setText("Adjusted Value");
    box13.setBounds(new Rectangle(5, 290, 127, 23));
    box13.addActionListener(new search_item_box13_actionAdapter(this));
    box21.setFont(new java.awt.Font("Dialog", 1, 12));
    box21.setText("UP Date");
    box21.setBounds(new Rectangle(6, 465, 106, 20));
    box21.addActionListener(new search_item_box21_actionAdapter(this));
    JDbTable1.setAlignmentX((float) 0.5);
    JDbTable1.setBorder(BorderFactory.createLineBorder(Color.black));
    JDbTable1.setDoubleBuffered(false);
    JDbTable1.setAutoCreateColumnsFromModel(true);
    JDbTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    JDbTable1.setCellSelectionEnabled(true);
    JDbTable1.setRowMargin(1);
    JDbTable1.setRowSelectionAllowed(true);
    JDbTable1.setAutoSelection(true);
    JDbTable1.setEditable(false);
    text6.setFont(new java.awt.Font("Dialog", 1, 12));
    text6.setEnabled(true);
    text6.setBorder(BorderFactory.createLineBorder(Color.black));
    text6.setForeground(Color.blue);
    text6.setDisabledTextColor(Color.blue);
    text6.setEditable(false);
    text6.setHorizontalAlignment(SwingConstants.CENTER);
    text6.setText("");
    text6.setBounds(new Rectangle(439, 301, 122, 29));
    label6.setAlignmentX((float) 0.0);
    label6.setFont(new java.awt.Font("Dialog", 1, 12));
    label6.setHorizontalAlignment(SwingConstants.CENTER);
    label6.setBorder(BorderFactory.createLineBorder(Color.black));
    label6.setText("Balanced Value");
    label6.setBounds(new Rectangle(439, 272, 122, 29));
    text5.setBounds(new Rectangle(288, 301, 142, 29));
    text5.setHorizontalAlignment(SwingConstants.CENTER);
    text5.setText("");
    text5.setEditable(false);
    text5.setDisabledTextColor(Color.blue);
    text5.setBorder(BorderFactory.createLineBorder(Color.black));
    text5.setForeground(Color.blue);
    text5.setFont(new java.awt.Font("Dialog", 1, 12));
    text5.setEnabled(true);
    label5.setBounds(new Rectangle(288, 272, 142, 29));
    label5.setText("Balanced Quantity");
    label5.setHorizontalTextPosition(SwingConstants.CENTER);
    label5.setHorizontalAlignment(SwingConstants.CENTER);
    label5.setBorder(BorderFactory.createLineBorder(Color.black));
    label5.setFont(new java.awt.Font("Dialog", 1, 12));
    this.getContentPane().add(jPanel1, null);
    jPanel1.add(jLabel1, null);
    this.getContentPane().add(jPanel2, null);
    jPanel2.add(label2, null);
    jPanel2.add(two, null);
    jPanel2.add(one, null);
    jPanel2.add(label1, null);
    jPanel2.add(combo, null);
    jPanel2.add(jLabel2, null);
    this.getContentPane().add(jPanel3, null);
    jPanel3.add(tableScrollPane1, null);
    jPanel3.add(text3, null);
    jPanel3.add(label3, null);
    jPanel3.add(label5, null);
    jPanel3.add(text5, null);
    jPanel3.add(label4, null);
    jPanel3.add(text4, null);
    jPanel3.add(label6, null);
    jPanel3.add(text6, null);
    jPanel4.add(jButton2, null);
    jPanel4.add(search, null);
    this.getContentPane().add(jPanel5, null);
    jPanel5.add(jLabel3, null);
    jPanel5.add(box1, null);
    jPanel5.add(box16, null);
    jPanel5.add(box15, null);
    jPanel5.add(box20, null);
    jPanel5.add(box18, null);
    jPanel5.add(box19, null);
    jPanel5.add(box17, null);
    jPanel5.add(box21, null);
    jPanel5.add(box14, null);
    jPanel5.add(box13, null);
    jPanel5.add(box12, null);
    jPanel5.add(box11, null);
    jPanel5.add(box10, null);
    jPanel5.add(box9, null);
    jPanel5.add(box8, null);
    jPanel5.add(box7, null);
    jPanel5.add(box6, null);
    jPanel5.add(box5, null);
    jPanel5.add(box4, null);
    jPanel5.add(box3, null);
    jPanel5.add(box2, null);
    this.getContentPane().add(jPanel4, null);
    tableScrollPane1.getViewport().add(JDbTable1, null);


  }

  public static void main(String[] args) {
    search_item search_item = new search_item();
  }

  void select_all()
  {
    box1.setSelected(true);box2.setSelected(true);
    box3.setSelected(true);box4.setSelected(true);
    box5.setSelected(true);box6.setSelected(true);
    box7.setSelected(true);box8.setSelected(true);
    box9.setSelected(true);box10.setSelected(true);
    box11.setSelected(true);box12.setSelected(true);
    box13.setSelected(true);box14.setSelected(true);
    box15.setSelected(true);box16.setSelected(true);
    box17.setSelected(true);box18.setSelected(true);
    box19.setSelected(true);box20.setSelected(true);
    box21.setSelected(true);
  }
  void check_select()
  {
    int i;
    for(i=1;i<=21;i++){
      b[i] = "";
      selected[i]=false;
    }
    if (box1.isSelected()) selected[1] = true;
    if (box2.isSelected()) selected[2] = true;
    if (box3.isSelected()) selected[3] = true;
    if (box4.isSelected()) selected[4] = true;
    if (box5.isSelected()) selected[5] = true;
    if (box6.isSelected()) selected[6] = true;
    if (box7.isSelected()) selected[7] = true;
    if (box8.isSelected()) selected[8] = true;
    if (box9.isSelected()) selected[9] = true;
    if (box10.isSelected()) selected[10] = true;
    if (box11.isSelected()) selected[11] = true;
    if (box12.isSelected()) selected[12] = true;
    if (box13.isSelected()) selected[13] = true;
    if (box14.isSelected()) selected[14] = true;
    if (box15.isSelected()) selected[15] = true;
    if (box16.isSelected()) selected[16] = true;
    if (box17.isSelected()) selected[17] = true;
    if (box18.isSelected()) selected[18] = true;
    if (box19.isSelected()) selected[19] = true;
    if (box20.isSelected()) selected[20] = true;
    if (box21.isSelected()) selected[21] = true;


    select="";
    if(selected[1])b[1]="Bond_Name";
    if(selected[2])b[2]="Bond_Date";
    if(selected[3])b[3]="Into_Bond_Date";
    if(selected[4])b[4]="LC_No";
    if(selected[5])b[5]="LC_Date";
    if(selected[6])b[6]="BE_No";
    if(selected[7])b[7]="BE_Date";
    if(selected[8])b[8]=""+Main.names+"_Name";
    if(selected[9])b[9]=""+Main.names+"_Description";
    if(selected[10])b[10]="Import_Quantity";
    if(selected[11])b[11]="Import_Value";
    if(selected[12])b[12]="Adjusted_Quantity";
    if(selected[13])b[13]="Adjusted_Value";
    if(selected[14])b[14]="Balanced_Quantity";
    if(selected[15])b[15]="Balanced_Value";
    if(selected[16])b[16]="Unit_price";
    if(selected[17])b[17]="HS_Code";
    if(selected[18])b[18]="Page_No";
    if(selected[19])b[19]="Volume";
    if(selected[20])b[20]="UP_No";
    if(selected[21])b[21]="UP_Date";

    for(i=1;i<=21;i++)
    {
      if(select.equals(""))
        select+=b[i];
      else
      {
          if(selected[i])select+=","+b[i];
      }
    }

  }

  void search_actionPerformed(ActionEvent e) {

    check_select();

    if(select.equals(""))  JOptionPane.showMessageDialog(null,"Select Fields");
    else{
      String sql = "", sql2 = "";

      String str1 = "", str2 = "";
      int day1, day2, p = 0;

      int ind = combo.getSelectedIndex();
      if (ind == 0) {
        sql = "select " + select + " from "+Main.entryTable+" order by "+Main.names+"_Name";
        sql2 = "select * from "+Main.entryTable+" order by "+Main.names+"_Name";
      }
      else if (ind == 3) {
        str1 = one.getText();
        str2 = two.getText();
      }
      else {
        str1 = one.getText();
        str2 = names[ind];
        char str[] = str2.toCharArray();
        String s = "";
        for (int i = 0; i < str.length; i++) {
          if (str[i] == ' ') s += '_';
          else if (str[i] == '/') {
          }
          else s += str[i];
        }
        str2 = s;
        //JOptionPane.showMessageDialog(null,str2);

        sql = "select " + select + " from "+Main.entryTable+" where " + str2 + " = '" +
            str1 + "' order by "+Main.names+"_Name";
        sql2 = "select * from "+Main.entryTable+" where " + str2 + " = '" + str1 +
            "' order by "+Main.names+"_Name";
        //JOptionPane.showMessageDialog(null,sql);
      }

      if (ind == 3) {

        if (str1.equals("") || str2.equals(""))
          JOptionPane.showMessageDialog(null,
                                        "Starting Date/Ending Date Missing");
        else {

          if (str1.length() != 10 && str2.length() != 10)
            JOptionPane.showMessageDialog(null, "Date Format Error");
          else {
            day1 = BillEntry.getDates(str1);
            day2 = BillEntry.getDates(str2);
            sql =
                " select " + select +
                " from "+Main.entryTable+" where Day in(select Day from "+Main.entryTable+"" +
                " where Day>=" + day1 + " AND DAY<=" + day2 +
                ") order by "+Main.names+"_Name";
            sql2 =
                " select * from "+Main.entryTable+" where Day in(select Day from "+Main.entryTable+"" +
                " where Day>=" + day1 + " AND DAY<=" + day2 +
                ") order by "+Main.names+"_Name";

            //JOptionPane.showMessageDialog(null, sql);
            p = 1;
          }
        }

      }
      if (str1.equals("") && ind != 0)
        JOptionPane.showMessageDialog(null, "Give Search Word");
      else if (ind == 3 && p == 0) {

      }

      else {
        try {

          database1.setConnection(new ConnectionDescriptor(Main.url,
              Main.user_name, Main.password, false, "com.mysql.jdbc.Driver"));
          Statement statement = database1.createStatement();
          queryDataSet1.close();
          queryDataSet1.setQuery(new com.borland.dx.sql.dataset.QueryDescriptor(
              database1,
              sql, null, true, Load.ALL));
          queryDataSet1.executeQuery();
          JDbTable1.setDataSet(queryDataSet1);
          database1.closeConnection();

          DecimalFormat two = new DecimalFormat("0.000");

          Statement stat = connection.createStatement();
          ResultSet rset = stat.executeQuery(sql2);
          double import_quantity = 0, import_value = 0,adj_q=0,adj_v=0,b_q=0,b_v=0;
          while (rset.next()) {
            import_quantity +=
                Double.parseDouble(rset.getString("Import_Quantity"));
            import_value += Double.parseDouble(rset.getString("Import_Value"));
            adj_q +=
                 Double.parseDouble(rset.getString("Adjusted_Quantity"));
             adj_v += Double.parseDouble(rset.getString("Adjusted_Value"));
          }

          b_q = import_quantity - adj_q;
          b_v = import_value - adj_v;


          text3.setVisible(true);
          text4.setVisible(true);
          text5.setVisible(true);
          text6.setVisible(true);
          label3.setVisible(true);
          label4.setVisible(true);
          label5.setVisible(true);
          label6.setVisible(true);
          text3.setText(String.valueOf(two.format(import_quantity)));
          text4.setText(String.valueOf(two.format(import_value)));
          text5.setText(String.valueOf(two.format(b_q)));
          text6.setText(String.valueOf(two.format(b_v)));
          JDbTable1.selectAll();
          JDbTable1.setSmartColumnWidths(true);


        }
        catch (Exception ex) {
          DBExceptionHandler.handleException(ex);
          JOptionPane.showMessageDialog(null, " DB TABLE ERROR");
        }
      }
    }


  }

  void combo_actionPerformed(ActionEvent e) {
      one.setVisible(false);
      two.setVisible(false);
      label1.setVisible(false);
      label2.setVisible(false);
      label3.setVisible(false);
      label4.setVisible(false);
      label5.setVisible(false);
      label6.setVisible(false);
      label1.setText("");
      label2.setText("");
      one.setText("");
      two.setText("");


      text3.setVisible(false);
      text4.setVisible(false);
      text5.setVisible(false);
      text6.setVisible(false);


      JDbTable1.setDataSet(null);
      int ind =  combo.getSelectedIndex();
      if(ind==0){

      }
      else if(ind==3){
        one.setVisible(true);
        two.setVisible(true);
        label1.setVisible(true);
        label2.setVisible(true);
        label1.setText("Starting Date(DD/MM/YYYY)");
        label2.setText("Ending Date(DD/MM/YYYY)");
      }
     else{
       one.setVisible(true);
       label1.setText("Enter Search Word");
       label1.setVisible(true);
     }
  }

  void jButton2_actionPerformed(ActionEvent e) {
    dispose();
  }

  void box1_actionPerformed(ActionEvent e) {

    if(box1.isSelected())
      selected[1] =true;
    else
      selected[1]=false;
  }

  void box2_actionPerformed(ActionEvent e) {
    if(box2.isSelected())
     selected[2] =true;
   else
     selected[2]=false;
  }

  void box3_actionPerformed(ActionEvent e) {
    if(box3.isSelected())
         selected[3] =true;
       else
         selected[3]=false;

  }

  void box4_actionPerformed(ActionEvent e) {
    if(box4.isSelected())
     selected[4] =true;
   else
     selected[4]=false;

  }

  void box5_actionPerformed(ActionEvent e) {
    if(box5.isSelected())
     selected[5] =true;
   else
     selected[5]=false;

  }

  void box6_actionPerformed(ActionEvent e) {
    if(box6.isSelected())
     selected[6] =true;
   else
     selected[6]=false;

  }

  void box7_actionPerformed(ActionEvent e) {
    if(box7.isSelected())
     selected[7] =true;
   else
     selected[7]=false;

  }

  void box8_actionPerformed(ActionEvent e) {
    if(box8.isSelected())
     selected[8] =true;
   else
     selected[8]=false;

  }

  void box9_actionPerformed(ActionEvent e) {
    if(box9.isSelected())
     selected[9] =true;
   else
     selected[9]=false;

  }

  void box10_actionPerformed(ActionEvent e) {
    if(box10.isSelected())
     selected[10] =true;
   else
     selected[10]=false;

  }

  void box11_actionPerformed(ActionEvent e) {
    if(box11.isSelected())
     selected[11] =true;
   else
     selected[11]=false;

  }

  void box12_actionPerformed(ActionEvent e) {
    if(box12.isSelected())
     selected[12] =true;
   else
     selected[12]=false;

  }

  void box13_actionPerformed(ActionEvent e) {
    if(box13.isSelected())
     selected[13] =true;
   else
     selected[13]=false;

  }

  void box14_actionPerformed(ActionEvent e) {
    if(box14.isSelected())
     selected[14] =true;
   else
     selected[14]=false;

  }

  void box15_actionPerformed(ActionEvent e) {
    if(box15.isSelected())
     selected[15] =true;
   else
     selected[15]=false;

  }

  void box16_actionPerformed(ActionEvent e) {
    if(box16.isSelected())
     selected[16] =true;
   else
     selected[16]=false;

  }

  void box17_actionPerformed(ActionEvent e) {
    if(box17.isSelected())
     selected[17] =true;
   else
     selected[17]=false;

  }

  void box18_actionPerformed(ActionEvent e) {
    if(box18.isSelected())
     selected[18] =true;
   else
     selected[18]=false;

  }

  void box19_actionPerformed(ActionEvent e) {
    if(box19.isSelected())
     selected[19] =true;
   else
     selected[19]=false;

  }

  void box20_actionPerformed(ActionEvent e) {
    if(box20.isSelected())
     selected[20] =true;
   else
     selected[20]=false;

  }

  void box21_actionPerformed(ActionEvent e) {
    if(box21.isSelected())
     selected[21] =true;
   else
     selected[21]=false;

  }
}

class search_item_search_actionAdapter implements java.awt.event.ActionListener {
  search_item adaptee;

  search_item_search_actionAdapter(search_item adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.search_actionPerformed(e);
  }
}

class search_item_combo_actionAdapter implements java.awt.event.ActionListener {
  search_item adaptee;

  search_item_combo_actionAdapter(search_item adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.combo_actionPerformed(e);
  }
}

class search_item_jButton2_actionAdapter implements java.awt.event.ActionListener {
  search_item adaptee;

  search_item_jButton2_actionAdapter(search_item adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton2_actionPerformed(e);
  }
}

class search_item_box1_actionAdapter implements java.awt.event.ActionListener {
  search_item adaptee;

  search_item_box1_actionAdapter(search_item adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.box1_actionPerformed(e);
  }
}

class search_item_box2_actionAdapter implements java.awt.event.ActionListener {
  search_item adaptee;

  search_item_box2_actionAdapter(search_item adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.box2_actionPerformed(e);
  }
}

class search_item_box3_actionAdapter implements java.awt.event.ActionListener {
  search_item adaptee;

  search_item_box3_actionAdapter(search_item adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.box3_actionPerformed(e);
  }
}

class search_item_box4_actionAdapter implements java.awt.event.ActionListener {
  search_item adaptee;

  search_item_box4_actionAdapter(search_item adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.box4_actionPerformed(e);
  }
}

class search_item_box5_actionAdapter implements java.awt.event.ActionListener {
  search_item adaptee;

  search_item_box5_actionAdapter(search_item adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.box5_actionPerformed(e);
  }
}

class search_item_box6_actionAdapter implements java.awt.event.ActionListener {
  search_item adaptee;

  search_item_box6_actionAdapter(search_item adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.box6_actionPerformed(e);
  }
}

class search_item_box7_actionAdapter implements java.awt.event.ActionListener {
  search_item adaptee;

  search_item_box7_actionAdapter(search_item adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.box7_actionPerformed(e);
  }
}

class search_item_box8_actionAdapter implements java.awt.event.ActionListener {
  search_item adaptee;

  search_item_box8_actionAdapter(search_item adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.box8_actionPerformed(e);
  }
}

class search_item_box9_actionAdapter implements java.awt.event.ActionListener {
  search_item adaptee;

  search_item_box9_actionAdapter(search_item adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.box9_actionPerformed(e);
  }
}

class search_item_box10_actionAdapter implements java.awt.event.ActionListener {
  search_item adaptee;

  search_item_box10_actionAdapter(search_item adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.box10_actionPerformed(e);
  }
}

class search_item_box11_actionAdapter implements java.awt.event.ActionListener {
  search_item adaptee;

  search_item_box11_actionAdapter(search_item adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.box11_actionPerformed(e);
  }
}

class search_item_box12_actionAdapter implements java.awt.event.ActionListener {
  search_item adaptee;

  search_item_box12_actionAdapter(search_item adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.box12_actionPerformed(e);
  }
}

class search_item_box13_actionAdapter implements java.awt.event.ActionListener {
  search_item adaptee;

  search_item_box13_actionAdapter(search_item adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.box13_actionPerformed(e);
  }
}

class search_item_box14_actionAdapter implements java.awt.event.ActionListener {
  search_item adaptee;

  search_item_box14_actionAdapter(search_item adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.box14_actionPerformed(e);
  }
}

class search_item_box15_actionAdapter implements java.awt.event.ActionListener {
  search_item adaptee;

  search_item_box15_actionAdapter(search_item adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.box15_actionPerformed(e);
  }
}

class search_item_box16_actionAdapter implements java.awt.event.ActionListener {
  search_item adaptee;

  search_item_box16_actionAdapter(search_item adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.box16_actionPerformed(e);
  }
}

class search_item_box17_actionAdapter implements java.awt.event.ActionListener {
  search_item adaptee;

  search_item_box17_actionAdapter(search_item adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.box17_actionPerformed(e);
  }
}

class search_item_box18_actionAdapter implements java.awt.event.ActionListener {
  search_item adaptee;

  search_item_box18_actionAdapter(search_item adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.box18_actionPerformed(e);
  }
}

class search_item_box19_actionAdapter implements java.awt.event.ActionListener {
  search_item adaptee;

  search_item_box19_actionAdapter(search_item adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.box19_actionPerformed(e);
  }
}

class search_item_box20_actionAdapter implements java.awt.event.ActionListener {
  search_item adaptee;

  search_item_box20_actionAdapter(search_item adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.box20_actionPerformed(e);
  }
}

class search_item_box21_actionAdapter implements java.awt.event.ActionListener {
  search_item adaptee;

  search_item_box21_actionAdapter(search_item adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.box21_actionPerformed(e);
  }
}
