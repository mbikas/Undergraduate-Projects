
package hospital;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.ButtonGroup;




public class Patient_admission_form extends JFrame {
  Connection connection;
 public long outdoor_id=0;
  public String str_patient_id;
  public String wards[]=new String[100];
  public String gbs[]=new String[100];
  public String pbs[]=new String[100];
  public String doc[]=new String[100],inf="",inf_cabin="",inf_bed="",inf_pb="",inf_gb="";
  public int id,total_cabin,total_ward,total_gb,total_pb;

  public String cabin_avail[] = new String[100];
  public String bed_avail[] = new String[100];
  public String pb_avail[] = new String[100];
  public String gb_avail[] = new String[100];
  JLabel Hospital_name = new JLabel();
  ButtonGroup radioGroup = new ButtonGroup();


  JLabel Relative_name = new JLabel();
  ButtonGroup res_group = new ButtonGroup();
  JPopupMenu jPopupMenu1 = new JPopupMenu();
  CheckboxGroup checkboxGroup1 = new CheckboxGroup();
  CheckboxGroup checkboxGroup2 = new CheckboxGroup();
  CheckboxGroup checkboxGroup3 = new CheckboxGroup();
  CheckboxGroup checkboxGroup4 = new CheckboxGroup();
  CheckboxGroup checkboxGroup5 = new CheckboxGroup();
  CheckboxGroup checkboxGroup6 = new CheckboxGroup();
  String religions[]={"Muslim","Hindu","Christian","Buddisht","Others"};
  String  sexs[]={"Male","Female"};
  ButtonGroup dr_group = new ButtonGroup();

  ButtonGroup fa_hu_group = new ButtonGroup();
  JLabel Reg_label = new JLabel();
  JComboBox religion = new JComboBox(religions);
  JTextField patient_age = new JTextField();
  JTextField father_name = new JTextField();
  JTextField husband_name = new JTextField();
  JRadioButton father = new JRadioButton();
  JLabel Name_lebel = new JLabel();
  JTextField patient_name = new JTextField();
  JLabel Age_lebel = new JLabel();
  JFormattedTextField dates = new JFormattedTextField();
  JLabel Religion_lebel = new JLabel();
  JRadioButton husband = new JRadioButton();
  JComboBox sex_combo = new JComboBox(sexs);
  JLabel Patient_admission_form_label = new JLabel();
  JLabel Sex_lebel = new JLabel();
  JTextField patient_id = new JTextField();
  JLabel Date_lebel = new JLabel();
  JLabel label1 = new JLabel();
  JLabel Occupation_lebel = new JLabel();
  JLabel Doctor = new JLabel();
  JRadioButton other_dr = new JRadioButton();
  JLabel Permanent_address_lebel = new JLabel();
  JTextField rname = new JTextField();
  JLabel jLabel1 = new JLabel();
  JLabel Disease = new JLabel();
  JRadioButton central_dr = new JRadioButton();
  JLabel Dept = new JLabel();
  JLabel Rlative_addresss = new JLabel();
  String depts[]={"Medicine","Surgery","Gynae","Paediactric","Orthopaeddics","Neoral"};
  JComboBox dept = new JComboBox(depts);
  JTextField out_dr = new JTextField();
  JButton save = new JButton();
  JButton exit = new JButton();
  JRadioButton cabin = new JRadioButton();
  JRadioButton ward = new JRadioButton();
  JButton clear = new JButton();
  JLabel Hospital_address = new JLabel();
  JLabel Hospital_web_address = new JLabel();
  JLabel Hospital_phone = new JLabel();
  JLabel Hospital_name1 = new JLabel();
  JTextField occupation = new JTextField();
  ButtonGroup group1 = new ButtonGroup();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextArea present_add = new JTextArea();
  JScrollPane jScrollPane2 = new JScrollPane();
  JTextArea permanent_add = new JTextArea();
  JScrollPane jScrollPane3 = new JScrollPane();
  JTextArea radd = new JTextArea();
  JScrollPane jScrollPane4 = new JScrollPane();
  JTextArea disease = new JTextArea();
  JScrollPane pane = new JScrollPane();
  JScrollPane jScrollPane5 = new JScrollPane();
  JList dr_list = new JList();
  JScrollPane jScrollPane6 = new JScrollPane();
  JScrollPane jScrollPane7 = new JScrollPane();
  JList bed_list = new JList();
  JList cabin_list = new JList();
  ButtonGroup group3 = new ButtonGroup();
  JScrollPane jScrollPane8 = new JScrollPane();
  JList ward_list = new JList();
  JRadioButton pb = new JRadioButton();
  JRadioButton gb = new JRadioButton();
  JScrollPane jScrollPane9 = new JScrollPane();
  JList pb_list = new JList();
  JScrollPane jScrollPane10 = new JScrollPane();
  JList gb_list = new JList();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JLabel Dept1 = new JLabel();
  JTextField contact = new JTextField();

  public Patient_admission_form() {

    try {

        jbInit();
        setSize(610,540);
        show();
        setLocation(70,35);

        /////////generating id for patient////////
        Statement stat;
        ResultSet rset;
        String sql;
        connection = Main.connection;



        //getting id from table patient_id_generator
      stat = connection.createStatement();
      sql ="select indoor_id,outdoor_id from  patient_id_generator";
      rset = stat.executeQuery(sql);
      while(rset.next()){
           id = Integer.parseInt(rset.getString("indoor_id"));
           outdoor_id = Integer.parseInt(rset.getString("outdoor_id"));
      }

     ///////////////end of generating id/////////////////////


        /////////initialization/////////////////
        patient_id.setText(String.valueOf(id));
        patient_id.setEditable(false);
        husband_name.setEditable(false);
        father.setSelected(true);
       // ward.setSelected(true);

        ////////////////////////////////////
        central_dr.setEnabled(false);
        other_dr.setEnabled(false);
        out_dr.setEnabled(false);
        dr_list.setEnabled(false);


         ///////////////////////////////////////////////////////////////////////
           stat = connection.createStatement();
           sql ="select total_cabin,total_ward,total_gb,total_pb from total_ward_cabin_gb_pb";
           rset = stat.executeQuery(sql);

           while(rset.next()){
             total_cabin = Integer.parseInt(rset.getString("total_cabin"));
             total_ward = Integer.parseInt(rset.getString("total_ward"));
             total_gb = Integer.parseInt(rset.getString("total_gb"));
             total_pb = Integer.parseInt(rset.getString("total_pb"));
            }

            ///////////////////////////////////////////////////////end no//////////////////////

            String str="";
            sql = "select to_char(sysDate,'DD-MM-YYYY') from dual";
            stat = connection.createStatement();
            rset = stat.executeQuery(sql);
            while(rset.next())
            str += rset.getString(1);
            dates.setText(str);

            stat.close();
            rset.close();


    }
    catch(Exception ex) {
      ex.printStackTrace();
    }

   //listener for ward_list
   ward_list.addListSelectionListener(
      new ListSelectionListener()
      { public void valueChanged(ListSelectionEvent e)
         {

           try {


             Statement stat;
             ResultSet rset;
             String sql;

             stat = connection.createStatement();
             sql = "select bed_no from ward_info where (flag=1 AND ward_no="+ward_list.getSelectedValue()+") order by bed_no";
             rset = stat.executeQuery(sql);
             int ct = 0,i;
             String str1 = "";

             while (rset.next()) {
               bed_avail[ct] = rset.getString(1) ;
               ct++;
               inf_bed += rset.getString(1);
             }

             String temp[] = new String[ct];
             for (i = 0; i < ct; i++)
             temp[i] = bed_avail[i];
             bed_list.setListData(temp);




             stat.close();
             rset.close();
           }
           catch (SQLException sqlException) {
             JOptionPane.showMessageDialog(null, sqlException.getMessage(),"Database error",JOptionPane.ERROR_MESSAGE);
           }


         }
      }
   );





  }

  void jbInit() throws Exception {

    this.getContentPane().setBackground(new Color(173, 201, 139));
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setEnabled(true);
    this.setLocale(java.util.Locale.getDefault());
    this.setResizable(false);
    this.setState(Frame.NORMAL);
    this.setTitle("Patient Admission Form");
    this.getContentPane().setLayout(null);


    //save.addActionListener(new Patient_admission_form_save_actionAdapter(this));
    Reg_label.setText("REG NO:");
    Reg_label.setBounds(new Rectangle(10, 121, 52, 18));
    religion.setBackground(new Color(173, 201, 139));
    religion.setFont(new java.awt.Font("Dialog", 1, 12));
    religion.setBounds(new Rectangle(61, 200, 97, 22));
    patient_age.setBackground(SystemColor.textHighlightText);
    patient_age.setFont(new java.awt.Font("Dialog", 1, 12));
    patient_age.setText("");
    patient_age.setBounds(new Rectangle(59, 173, 68, 19));
    father_name.setBackground(SystemColor.textHighlightText);
    father_name.setFont(new java.awt.Font("Dialog", 1, 12));
    father_name.setText("");
    father_name.setBounds(new Rectangle(431, 144, 156, 24));
    husband_name.setBackground(SystemColor.textHighlightText);
    husband_name.setFont(new java.awt.Font("Dialog", 1, 12));
    husband_name.setText("");
    husband_name.setBounds(new Rectangle(432, 172, 156, 23));
    father.setBackground(new Color(173, 201, 139));
    father.setText("FATHER\'S NAME:");
    father.setBounds(new Rectangle(290, 146, 132, 19));
    father.addActionListener(new Patient_admission_form_father_actionAdapter(this));
    Name_lebel.setText("NAME:");
    Name_lebel.setBounds(new Rectangle(8, 148, 44, 21));
    patient_name.setBackground(SystemColor.textHighlightText);
    patient_name.setFont(new java.awt.Font("Dialog", 1, 12));
    patient_name.setText("");
    patient_name.setBounds(new Rectangle(58, 148, 156, 21));
    Age_lebel.setText("AGE:");
    Age_lebel.setBounds(new Rectangle(7, 172, 36, 20));
    dates.setBackground(new Color(173, 201, 139));
    dates.setDisabledTextColor(SystemColor.activeCaption);
    dates.setEditable(false);
    dates.setFont(new java.awt.Font("SansSerif", 1, 13));
    dates.setForeground(SystemColor.activeCaption);
    dates.setBounds(new Rectangle(430, 114, 158, 25));
    Religion_lebel.setText("RELIGION:");
    Religion_lebel.setBounds(new Rectangle(6, 200, 73, 18));
    husband.setBackground(new Color(173, 201, 139));
    husband.setText("HUSBAND\'S NAME:");
    husband.setBounds(new Rectangle(291, 172, 139, 23));
    husband.addActionListener(new Patient_admission_form_husband_actionAdapter(this));
    sex_combo.setBackground(new Color(173, 201, 139));
    sex_combo.setFont(new java.awt.Font("Dialog", 1, 12));
    sex_combo.setBounds(new Rectangle(167, 172, 69, 24));
    Patient_admission_form_label.setFont(new java.awt.Font("Dialog", 1, 14));
    Patient_admission_form_label.setForeground(SystemColor.activeCaption);
    Patient_admission_form_label.setText("Admission Form");
    Patient_admission_form_label.setBounds(new Rectangle(223, 94, 115, 17));
    Sex_lebel.setText("SEX:");
    Sex_lebel.setBounds(new Rectangle(134, 174, 34, 19));
    patient_id.setBackground(SystemColor.textHighlightText);
    patient_id.setFont(new java.awt.Font("Dialog", 1, 12));
    patient_id.setDisabledTextColor(SystemColor.activeCaption);
    patient_id.setEditable(false);
    patient_id.setBounds(new Rectangle(58, 122, 73, 18));
    //patient_id.addActionListener(new Patient_admission_form_patient_id_actionAdapter(this));
    Date_lebel.setText("DATE:");
    Date_lebel.setBounds(new Rectangle(377, 116, 36, 18));
    label1.setText("PRESENT ADDRESS:");
    label1.setBounds(new Rectangle(5, 228, 118, 20));
    Occupation_lebel.setText("OCCUPATION:");
    Occupation_lebel.setBounds(new Rectangle(341, 201, 85, 22));
    Doctor.setText("TREATMENT UNDER DR.:");
    Doctor.setBounds(new Rectangle(224, 332, 136, 16));
    other_dr.setBackground(new Color(173, 201, 139));
    other_dr.setFont(new java.awt.Font("Dialog", 1, 12));
    other_dr.setText("Others");
    other_dr.setBounds(new Rectangle(145, 391, 66, 20));
    other_dr.addActionListener(new Patient_admission_form_other_dr_actionAdapter(this));
    Permanent_address_lebel.setText("PERMANENT ADDRESS");
    Permanent_address_lebel.setBounds(new Rectangle(304, 226, 135, 21));
    rname.setBackground(SystemColor.textHighlightText);
    rname.setFont(new java.awt.Font("Dialog", 1, 12));
    rname.setText("");
    rname.setBounds(new Rectangle(123, 273, 179, 23));
    jLabel1.setText("RELATIVE NAME:");
    jLabel1.setBounds(new Rectangle(3, 269, 116, 23));
    Disease.setText("DISEASE:");
    Disease.setBounds(new Rectangle(6, 303, 62, 20));
    central_dr.setBackground(new Color(173, 201, 139));
    central_dr.setFont(new java.awt.Font("Dialog", 1, 12));
    central_dr.setText("JRRMC");
    central_dr.setBounds(new Rectangle(145, 358, 66, 19));
    central_dr.addActionListener(new Patient_admission_form_central_dr_actionAdapter(this));
    Dept.setText("DEPT:");
    Dept.setBounds(new Rectangle(4, 357, 34, 20));
    Rlative_addresss.setToolTipText("");
    Rlative_addresss.setText("RELATIVE ADDRESS");
    Rlative_addresss.setBounds(new Rectangle(309, 270, 116, 27));
    dept.setBackground(new Color(173, 201, 139));
    dept.setFont(new java.awt.Font("Dialog", 1, 12));
    dept.setBounds(new Rectangle(50, 357, 96, 20));
    dept.addActionListener(new Patient_admission_form_dept_actionAdapter(this));
    //jComboBox1.addActionListener(new Patient_admission_form_jComboBox1_actionAdapter(this));
    out_dr.setBackground(SystemColor.textHighlightText);
    out_dr.setFont(new java.awt.Font("Dialog", 1, 12));
    out_dr.setBounds(new Rectangle(216, 392, 157, 25));
    save.setBackground(new Color(173, 201, 139));
    save.setBounds(new Rectangle(142, 477, 68, 24));
    save.setFont(new java.awt.Font("Dialog", 1, 12));
    save.setBorder(BorderFactory.createRaisedBevelBorder());
    save.setMnemonic('S');
    save.setText("SAVE");
    save.addActionListener(new Patient_admission_form_save_actionAdapter(this));
    exit.setBackground(new Color(173, 201, 139));
    exit.setBounds(new Rectangle(345, 478, 68, 26));
    exit.setFont(new java.awt.Font("Dialog", 1, 12));
    exit.setBorder(BorderFactory.createRaisedBevelBorder());
    exit.setMnemonic('E');
    exit.setText("EXIT");
    exit.addActionListener(new Patient_admission_form_exit_actionAdapter(this));
    cabin.setBackground(new Color(173, 201, 139));
    cabin.setText("CABIN:");
    cabin.setBounds(new Rectangle(377, 373, 83, 17));
    cabin.addActionListener(new Patient_admission_form_cabin_actionAdapter(this));
    ward.setBackground(new Color(173, 201, 139));
    ward.setText("WARD:");
    ward.setBounds(new Rectangle(376, 336, 80, 19));
    ward.addActionListener(new Patient_admission_form_ward_actionAdapter(this));
    clear.setBackground(new Color(173, 201, 139));
    clear.setBounds(new Rectangle(249, 479, 71, 24));
    clear.setFont(new java.awt.Font("Dialog", 1, 12));
    clear.setBorder(BorderFactory.createRaisedBevelBorder());
    clear.setMnemonic('C');
    clear.setText("CLEAR");
    clear.addActionListener(new Patient_admission_form_clear_actionAdapter(this));
    Hospital_address.setBounds(new Rectangle(110, 31, 377, 17));
    Hospital_address.setText("RAGIB-RABEYA MEDICAL COLLEGE ROAD, PATHANTULA, SYLHET. ");
    Hospital_address.setFont(new java.awt.Font("Dialog", 1, 12));
    Hospital_web_address.setBounds(new Rectangle(121, 52, 302, 15));
    Hospital_web_address.setText("WEB: www.jrrmc.edu.bd      EMAIL: jrrmc@btsnet.net");
    Hospital_web_address.setFont(new java.awt.Font("Dialog", 1, 12));
    Hospital_phone.setBounds(new Rectangle(214, 66, 94, 20));
    Hospital_phone.setText("PHONE: 719090");
    Hospital_phone.setFont(new java.awt.Font("Dialog", 1, 12));
    Hospital_name1.setBounds(new Rectangle(23, 5, 560, 28));
    Hospital_name1.setText("JALALABAD RAGIB-RABEYA MEDICAL COLLEGE HOSPITAL");
    Hospital_name1.setForeground(SystemColor.desktop);
    Hospital_name1.setFont(new java.awt.Font("Dialog", 1, 18));
    occupation.setBackground(SystemColor.textHighlightText);
    occupation.setFont(new java.awt.Font("Dialog", 1, 12));
    occupation.setBounds(new Rectangle(432, 200, 155, 23));
    jScrollPane1.setBounds(new Rectangle(124, 230, 178, 38));
    present_add.setBackground(SystemColor.textHighlightText);
    present_add.setFont(new java.awt.Font("Dialog", 1, 12));
    present_add.setText("");
    jScrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    jScrollPane2.setBounds(new Rectangle(433, 227, 155, 39));
    permanent_add.setBackground(SystemColor.textHighlightText);
    permanent_add.setFont(new java.awt.Font("Dialog", 1, 12));
    permanent_add.setText("");
    jScrollPane3.setBounds(new Rectangle(433, 270, 157, 36));
    radd.setBackground(SystemColor.textHighlightText);
    radd.setFont(new java.awt.Font("Dialog", 1, 12));
    radd.setText("");
    jScrollPane4.setBounds(new Rectangle(122, 303, 181, 27));
    disease.setBackground(SystemColor.textHighlightText);
    disease.setFont(new java.awt.Font("Dialog", 1, 12));
    disease.setText("");
    jScrollPane5.setBounds(new Rectangle(217, 353, 154, 35));
    jScrollPane6.setBounds(new Rectangle(533, 336, 61, 29));
    jScrollPane7.setBounds(new Rectangle(489, 373, 106, 28));
    dr_list.setBackground(SystemColor.textHighlightText);
    dr_list.setFont(new java.awt.Font("Dialog", 1, 12));
    dr_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    bed_list.setBackground(SystemColor.textHighlightText);
    bed_list.setFont(new java.awt.Font("Dialog", 1, 12));
    bed_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    cabin_list.setBackground(SystemColor.textHighlightText);
    cabin_list.setFont(new java.awt.Font("Dialog", 1, 12));
    cabin_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    jScrollPane8.setBounds(new Rectangle(459, 337, 67, 29));
    ward_list.setBackground(SystemColor.textHighlightText);
    ward_list.setFont(new java.awt.Font("Dialog", 1, 12));
    ward_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    pb.setBackground(new Color(173, 201, 139));
    pb.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
    pb.setText("PAYING BED:");
    pb.setBounds(new Rectangle(378, 406, 105, 22));
    pb.addActionListener(new Patient_admission_form_pb_actionAdapter(this));
    gb.setBackground(new Color(173, 201, 139));
    gb.setText("GENERAL BED:");
    gb.setBounds(new Rectangle(376, 442, 110, 25));
    gb.addActionListener(new Patient_admission_form_gb_actionAdapter(this));
    jScrollPane9.setBounds(new Rectangle(489, 408, 107, 27));
    jScrollPane10.setBounds(new Rectangle(489, 440, 108, 27));
    jLabel2.setText("BED");
    jLabel2.setBounds(new Rectangle(546, 319, 43, 11));
    jLabel3.setText("WARD");
    jLabel3.setBounds(new Rectangle(468, 316, 48, 14));
    Dept1.setBounds(new Rectangle(7, 434, 91, 24));
    Dept1.setText("CONTACT NO:");
    contact.setBackground(SystemColor.textHighlightText);
    contact.setFont(new java.awt.Font("Dialog", 1, 12));
    contact.setText("");
    contact.setBounds(new Rectangle(100, 433, 161, 26));
    pb_list.setBackground(SystemColor.textHighlightText);
    pb_list.setFont(new java.awt.Font("Dialog", 1, 12));
    gb_list.setBackground(SystemColor.textHighlightText);
    gb_list.setFont(new java.awt.Font("Dialog", 1, 12));
    this.getContentPane().add(Relative_name, null);
    this.getContentPane().add(Hospital_name, null);





    this.getContentPane().add(Hospital_name1, null);
    this.getContentPane().add(Hospital_address, null);
    this.getContentPane().add(Hospital_web_address, null);
    this.getContentPane().add(Hospital_phone, null);
    this.getContentPane().add(Patient_admission_form_label, null);

    ButtonGroup group = new ButtonGroup();
    group.add(father);
    group.add(husband);
    group1.add(cabin);
    group1.add(ward);
    group1.add(pb);
    group1.add(gb);
    group3.add(central_dr);
    group3.add(other_dr);
    this.getContentPane().add(Reg_label, null);
    this.getContentPane().add(patient_id, null);
    this.getContentPane().add(Name_lebel, null);
    this.getContentPane().add(patient_name, null);
    this.getContentPane().add(Age_lebel, null);
    this.getContentPane().add(patient_age, null);
    this.getContentPane().add(Sex_lebel, null);
    this.getContentPane().add(sex_combo, null);
    this.getContentPane().add(Religion_lebel, null);
    this.getContentPane().add(religion, null);
    this.getContentPane().add(label1, null);
    this.getContentPane().add(jScrollPane1, null);
    this.getContentPane().add(Permanent_address_lebel, null);
    this.getContentPane().add(jScrollPane2, null);
    this.getContentPane().add(jLabel1, null);
    this.getContentPane().add(rname, null);
    this.getContentPane().add(Rlative_addresss, null);
    this.getContentPane().add(jScrollPane3, null);
    this.getContentPane().add(father_name, null);
    this.getContentPane().add(husband_name, null);
    this.getContentPane().add(dates, null);
    this.getContentPane().add(occupation, null);
    this.getContentPane().add(Date_lebel, null);
    this.getContentPane().add(Occupation_lebel, null);
    this.getContentPane().add(jScrollPane4, null);
    jScrollPane4.getViewport().add(disease, null);
    this.getContentPane().add(Disease, null);
    this.getContentPane().add(dept, null);
    this.getContentPane().add(Dept, null);
    this.getContentPane().add(jScrollPane5, null);
    jScrollPane5.getViewport().add(dr_list, null);
    this.getContentPane().add(Doctor, null);
    this.getContentPane().add(out_dr, null);
    this.getContentPane().add(jScrollPane8, null);
    this.getContentPane().add(jScrollPane6, null);
    jScrollPane6.getViewport().add(bed_list, null);
    this.getContentPane().add(jLabel2, null);
    this.getContentPane().add(cabin, null);
    this.getContentPane().add(jScrollPane7, null);
    jScrollPane7.getViewport().add(cabin_list, null);
    this.getContentPane().add(pb, null);
    this.getContentPane().add(jScrollPane9, null);
    this.getContentPane().add(gb, null);
    this.getContentPane().add(jScrollPane10, null);
    this.getContentPane().add(jLabel3, null);
    this.getContentPane().add(ward, null);
    this.getContentPane().add(father, null);
    this.getContentPane().add(husband, null);
    this.getContentPane().add(other_dr, null);
    this.getContentPane().add(central_dr, null);
    this.getContentPane().add(Dept1, null);
    this.getContentPane().add(contact, null);
    this.getContentPane().add(exit, null);
    this.getContentPane().add(clear, null);
    this.getContentPane().add(save, null);
    jScrollPane10.getViewport().add(gb_list, null);
    jScrollPane9.getViewport().add(pb_list, null);
    jScrollPane8.getViewport().add(ward_list, null);
    jScrollPane3.getViewport().add(radd, null);
    jScrollPane2.getViewport().add(permanent_add, null);
    jScrollPane1.getViewport().add(present_add, null);


  }

  public static void main(String[] args) {
    Patient_admission_form patient_admission_form = new Patient_admission_form();
  }

  void save_actionPerformed(ActionEvent e) {


           ////////////////////////////////////////

           if(patient_age.getText().equals("") || patient_name.getText().equals("")||present_add.getText().equals("") ||permanent_add.getText().equals("") ||occupation.getText().equals(""))
                     JOptionPane.showMessageDialog(null,"any of the name/age/address/occupation field are blank","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
           //else if(rname.getText().equals("") || radd.getText().equals("") ||disease.getText().equals("") )
           else if(disease.getText().equals("") )
                            JOptionPane.showMessageDialog(null,"Insert disease name","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
            //else if(disease.getText().equals("") )
             //                              JOptionPane.showMessageDialog(null,"Insert disease name","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);


          else if( (father.isSelected() && father_name.getText().equals(""))||(husband.isSelected() && husband_name.getText().equals("")))
             JOptionPane.showMessageDialog(null,"Insert father or husband name","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
           else if(!central_dr.isSelected() && !other_dr.isSelected())
             JOptionPane.showMessageDialog(null,"select doctor catagory","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
          else if(other_dr.isSelected() && out_dr.getText().equals(""))
            JOptionPane.showMessageDialog(null,"Insert Doctor name","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
          else if(central_dr.isSelected() && dr_list.isSelectionEmpty())
            JOptionPane.showMessageDialog(null,"Select a doctor","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);

          else if(!ward.isSelected() && !cabin.isSelected() && !gb.isSelected() && !pb.isSelected())
           JOptionPane.showMessageDialog(null,"select ward/cabin/paying bed/general bed","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
          else if( ward.isSelected() && ward_list.isSelectionEmpty() )
           JOptionPane.showMessageDialog(null,"select ward number","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
         else if( ( ward.isSelected() && !ward_list.isSelectionEmpty()) && bed_list.isSelectionEmpty())
           JOptionPane.showMessageDialog(null,"select a bed number","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
         else if( cabin.isSelected() && cabin_list.isSelectionEmpty() )
            JOptionPane.showMessageDialog(null,"select a cabin numebr","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
         else if( gb.isSelected() && gb_list.isSelectionEmpty() )
             JOptionPane.showMessageDialog(null,"select a general bed","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
         else if( pb.isSelected() && pb_list.isSelectionEmpty() )
                    JOptionPane.showMessageDialog(null,"select a paying bed","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);

           else
           {




           try{

              String pat_name,pat_father,pat_husband,sql1,sql2,sql3;
              int pat_age;
              boolean insertResult1,insertResult2,insertResult3,insertResult4;
              Statement stat1,stat2;


              pat_name = patient_name.getText();
              pat_age = Integer.parseInt(patient_age.getText());

              String fname="",hname="";

              if(father_name.equals(""))
              {  fname="";
                 hname = husband_name.getText();
              }
             else
              {  hname="";
                 fname= father_name.getText();
              }

               //for table patient_info
               sql1 = "insert into patient_names_age values("+id+",'"+pat_name+"','"+fname+"',"+pat_age+",'"+sex_combo.getSelectedItem()+"','"+religion.getSelectedItem()+"','"+hname+"')";
               Statement stat= connection.createStatement();
               insertResult3 = stat.execute(sql1);

               //for table patient_address
               sql1 = "insert into patient_address values("+id+",'"+present_add.getText()+"','"+permanent_add.getText()+"','"+occupation.getText()+"','"+contact.getText()+"')";
               stat1= connection.createStatement();
               insertResult3 = stat1.execute(sql1);
               stat1.close();


              //for table patient_relative_dept_doc
              if(central_dr.isSelected())
               sql1 = "insert into patient_relative_dept_doc values("+id+",'"+rname.getText()+"','"+radd.getText()+"','"+disease.getText()+"','"+dept.getSelectedItem()+"','"+dr_list.getSelectedValue()+"')";
              else
                sql1 = "insert into patient_relative_dept_doc values("+id+",'"+rname.getText()+"','"+radd.getText()+"','"+disease.getText()+"','"+dept.getSelectedItem()+"','"+out_dr.getText()+"')";
               stat1= connection.createStatement();
               insertResult3 = stat1.execute(sql1);
               stat1.close();

               //for table patient_seat
              if(ward.isSelected())
                   sql1 = "insert into patient_seat values("+id+","+ward_list.getSelectedValue()+","+bed_list.getSelectedValue()+",0,0,0)";
              else if(cabin.isSelected())
                    sql1 = "insert into patient_seat values("+id+",0,0,"+cabin_list.getSelectedValue()+",0,0)";
              else if(gb.isSelected())
                    sql1 = "insert into patient_seat values("+id+",0,0,0,"+gb_list.getSelectedValue()+",0)";
              else if(pb.isSelected())
                    sql1 = "insert into patient_seat values("+id+",0,0,0,0,"+pb_list.getSelectedValue()+")";
              stat1= connection.createStatement();
              insertResult3 = stat1.execute(sql1);
              stat1.close();

              //flagging 0 to the taken seat
              if(ward.isSelected())
                  sql1 = "update ward_info set flag=0 where (ward_no = "+ward_list.getSelectedValue()+" AND bed_no = "+bed_list.getSelectedValue()+")";
              else if(cabin.isSelected())
                   sql1 = "update cabin_info set flag=0 where cabin_no = "+cabin_list.getSelectedValue()+"";
              else if(gb.isSelected())
                   sql1 = "update gb_info set flag=0 where gb_no = "+gb_list.getSelectedValue()+"";
              else if(pb.isSelected())
                   sql1 = "update pb_info set flag=0 where pb_no = "+pb_list.getSelectedValue()+"";
              stat1= connection.createStatement();
              insertResult3 = stat1.execute(sql1);
              stat1.close();

              // for table patient_adm_date
              stat1= connection.createStatement();
              sql1 = "select to_char(sysdate,'DD-MON-YYYY') from dual";
              ResultSet rset = stat1.executeQuery(sql1);
              String final_day = "";
              while (rset.next()) {
                final_day = rset.getString(1);
              }



              stat1 = connection.createStatement();
              sql1 = "insert into patient_adm_date values("+id+",'" + final_day + "')";
              insertResult3 = stat.execute(sql1);
              stat1.close();


              stat1 = connection.createStatement();
              sql1 = "insert into bill_1 values("+id+",0,0,0,0,0,0,0,0)";
              insertResult3 = stat.execute(sql1);
              stat1.close();

              stat1 = connection.createStatement();
              sql1 = "insert into bill_2 values("+id+",0,0,0,0,0,0,0)";
              insertResult3 = stat.execute(sql1);
              stat1.close();

              stat1 = connection.createStatement();
              sql1 = "insert into bill_money values("+id+",0,0,0,0)";
              insertResult3 = stat.execute(sql1);
              stat1.close();

              stat1 = connection.createStatement();
              sql1 = "insert into bill_advance values("+id+",0)";
              insertResult3 = stat.execute(sql1);
              stat1.close();


              //updaing id in the  table generator

               id = id + 1;
               //updaing id in the  table patient_generator
               sql1 = "delete from patient_id_generator";
               stat1 = connection.createStatement();
               insertResult1 = stat1.execute(sql1);
               sql2 = "insert into patient_id_generator values(" + id + "," + outdoor_id + ")";
               stat2 = connection.createStatement();
               insertResult2 = stat2.execute(sql2);
               ///////////////end of generating id/////////////////////

               ///////////////end of generating id/////////////////////
               System.out.print(id);
               stat.close();
               stat1.close();
               stat2.close();
               rset.close();

               String ss = String.valueOf(id);
               patient_id.setText(ss);

               String temp22[]=new String[1];
               ward_list.setListData(temp22);
               bed_list.setListData(temp22);
               cabin_list.setListData(temp22);
               gb_list.setListData(temp22);
               pb_list.setListData(temp22);

               JOptionPane.showMessageDialog(null,"Your Information have successfully saved.","CONFIRMATION MESSAGE",JOptionPane.INFORMATION_MESSAGE);

   }

  catch(SQLException sqlException)
      {
        JOptionPane.showMessageDialog(null,sqlException.getMessage(),
                                      "Database error",JOptionPane.ERROR_MESSAGE);
      }





   }//end of else


           //////////////////////////////////////////

  }

  void other_dr_actionPerformed(ActionEvent e) {

     out_dr.setEnabled(true);
     dr_list.setEnabled(false);
  }

  void father_actionPerformed(ActionEvent e) {
    husband_name.setEditable(true);
    father_name.setEditable(true);
    husband_name.setEditable(false);
    husband_name.setText("");

  }

  void husband_actionPerformed(ActionEvent e) {
   father_name.setEnabled(true);
   husband_name.setEditable(true);
   father_name.setEditable(false);
   father_name.setText("");

  }

  void ward_actionPerformed(ActionEvent e) {

     String temp[]=new String[total_ward];

     for(int i=0;i<total_ward;i++)
       temp[i]=String.valueOf(i+1);


     ward_list.setListData(temp);
     String temp1[]=new String[1];
     cabin_list.setListData(temp1);
     pb_list.setListData(temp1);
     gb_list.setListData(temp1);

  }

  void dept_actionPerformed(ActionEvent e) {

    try {


      other_dr.setEnabled(true);
      central_dr.setEnabled(true);
      Statement stat;
      ResultSet rset;
      String sql;


      stat = connection.createStatement();
      sql ="select name from doctor_info where doctor_id in ( select doctor_id from doctor_info where dept = '"+dept.getSelectedItem()+"')";
      rset = stat.executeQuery(sql);
      int i=0;
      while(rset.next()){
             doc[i]=  rset.getString(1);
             i++;
             inf = inf + rset.getString(1);
      }


      String temp1[]=new String[i];
      for(int j=0;j<i;j++)
      temp1[j]=doc[j];
      dr_list.setListData(temp1);


      stat.close();
      rset.close();

    }
  catch(SQLException sqlException)
         {
           JOptionPane.showMessageDialog(null,sqlException.getMessage(),
                                  "Database error",JOptionPane.ERROR_MESSAGE);
          }




  }

  void cabin_actionPerformed(ActionEvent e) {

    try {

      Statement stat;
      ResultSet rset;
      String sql;

      stat = connection.createStatement();
      sql =" select cabin_no from cabin_info where flag=1 order by cabin_no";
      rset = stat.executeQuery(sql);
      int ct=0;
      String str1="";
      while(rset.next()){
             cabin_avail[ct] = rset.getString(1);
             ct++;
             inf_cabin+= rset.getString(1);
      }

      String temp[] = new String[ct];
      for (int i = 0; i < ct; i++)
      temp[i] = cabin_avail[i];
      cabin_list.setListData(temp);


      stat.close();
      rset.close();

    }
  catch(SQLException sqlException)
         {
           JOptionPane.showMessageDialog(null,sqlException.getMessage(),
                                  "Database error",JOptionPane.ERROR_MESSAGE);
          }


      String temp[]=new String[1];
      ward_list.setListData(temp);
      bed_list.setListData(temp);
      pb_list.setListData(temp);
      gb_list.setListData(temp);





  }

  void central_dr_actionPerformed(ActionEvent e) {

     dr_list.setEnabled(true);
     out_dr.setText("");
     out_dr.setEnabled(false);
  }

  void pb_actionPerformed(ActionEvent e) {
    try {

      Statement stat;
      ResultSet rset;
      String sql;

      stat = connection.createStatement();
      sql =" select pb_no from pb_info where flag=1 order by pb_no";
      rset = stat.executeQuery(sql);
      int ct=0;
      String str1="";
      while(rset.next()){
             pb_avail[ct] = rset.getString(1);
             ct++;
             inf_pb+= rset.getString(1);
      }
       String temp[] = new String[ct];
       for (int i = 0; i < ct; i++)
       temp[i] = pb_avail[i];
       pb_list.setListData(temp);


      stat.close();
      rset.close();

    }
  catch(SQLException sqlException)
         {
           JOptionPane.showMessageDialog(null,sqlException.getMessage(),
                                  "Database error",JOptionPane.ERROR_MESSAGE);
          }


      String temp[]=new String[1];
      ward_list.setListData(temp);
      bed_list.setListData(temp);
      gb_list.setListData(temp);
      cabin_list.setListData(temp);


  }

  void gb_actionPerformed(ActionEvent e) {

    try {

     Statement stat;
     ResultSet rset;
     String sql;

     stat = connection.createStatement();
     sql =" select gb_no from gb_info where flag=1 order by gb_no";
     rset = stat.executeQuery(sql);
     int ct=0;

     while(rset.next()){
            gb_avail[ct] = rset.getString(1);
            ct++;
            inf_gb+= rset.getString(1);
     }

     String temp[] = new String[ct];
     for (int i = 0; i < ct; i++)
     temp[i] = gb_avail[i];
     gb_list.setListData(temp);



     stat.close();
     rset.close();

   }
  catch(SQLException sqlException)
        {
          JOptionPane.showMessageDialog(null,sqlException.getMessage(),
                                 "Database error",JOptionPane.ERROR_MESSAGE);
         }


         String temp[]=new String[1];
         ward_list.setListData(temp);
         bed_list.setListData(temp);
         pb_list.setListData(temp);
         cabin_list.setListData(temp);



  }

  void exit_actionPerformed(ActionEvent e) {
   dispose();
  }

  void clear_actionPerformed(ActionEvent e) {
  patient_name.setText("");
  father_name.setText("");
  husband_name.setText("");
  patient_age.setText("");
  occupation.setText("");
  present_add.setText("");
  rname.setText("");
  permanent_add.setText("");
  disease.setText("");
  radd.setText("");
  out_dr.setText("");
  contact.setText("");
  String temp[]=new String[1];
  dr_list.setListData(temp);
  ward_list.setListData(temp);
  bed_list.setListData(temp);
  cabin_list.setListData(temp);
  gb_list.setListData(temp);
  pb_list.setListData(temp);



  }




}

class Patient_admission_form_other_dr_actionAdapter implements java.awt.event.ActionListener {
  Patient_admission_form adaptee;

  Patient_admission_form_other_dr_actionAdapter(Patient_admission_form adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.other_dr_actionPerformed(e);
  }
}

class Patient_admission_form_father_actionAdapter implements java.awt.event.ActionListener {
  Patient_admission_form adaptee;

  Patient_admission_form_father_actionAdapter(Patient_admission_form adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.father_actionPerformed(e);
  }
}

class Patient_admission_form_husband_actionAdapter implements java.awt.event.ActionListener {
  Patient_admission_form adaptee;

  Patient_admission_form_husband_actionAdapter(Patient_admission_form adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.husband_actionPerformed(e);
  }
}

class Patient_admission_form_save_actionAdapter implements java.awt.event.ActionListener {
  Patient_admission_form adaptee;

  Patient_admission_form_save_actionAdapter(Patient_admission_form adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.save_actionPerformed(e);
  }
}

class Patient_admission_form_ward_actionAdapter implements java.awt.event.ActionListener {
  Patient_admission_form adaptee;

  Patient_admission_form_ward_actionAdapter(Patient_admission_form adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.ward_actionPerformed(e);
  }
}

class Patient_admission_form_dept_actionAdapter implements java.awt.event.ActionListener {
  Patient_admission_form adaptee;

  Patient_admission_form_dept_actionAdapter(Patient_admission_form adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.dept_actionPerformed(e);
  }
}

class Patient_admission_form_cabin_actionAdapter implements java.awt.event.ActionListener {
  Patient_admission_form adaptee;

  Patient_admission_form_cabin_actionAdapter(Patient_admission_form adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.cabin_actionPerformed(e);
  }
}

class Patient_admission_form_central_dr_actionAdapter implements java.awt.event.ActionListener {
  Patient_admission_form adaptee;

  Patient_admission_form_central_dr_actionAdapter(Patient_admission_form adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.central_dr_actionPerformed(e);
  }
}

class Patient_admission_form_pb_actionAdapter implements java.awt.event.ActionListener {
  Patient_admission_form adaptee;

  Patient_admission_form_pb_actionAdapter(Patient_admission_form adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.pb_actionPerformed(e);
  }
}

class Patient_admission_form_gb_actionAdapter implements java.awt.event.ActionListener {
  Patient_admission_form adaptee;

  Patient_admission_form_gb_actionAdapter(Patient_admission_form adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.gb_actionPerformed(e);
  }
}

class Patient_admission_form_exit_actionAdapter implements java.awt.event.ActionListener {
  Patient_admission_form adaptee;

  Patient_admission_form_exit_actionAdapter(Patient_admission_form adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.exit_actionPerformed(e);
  }
}

class Patient_admission_form_clear_actionAdapter implements java.awt.event.ActionListener {
  Patient_admission_form adaptee;

  Patient_admission_form_clear_actionAdapter(Patient_admission_form adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.clear_actionPerformed(e);
  }
}
