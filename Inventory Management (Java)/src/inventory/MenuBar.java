package inventory;


import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.sql.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import com.borland.dx.sql.dataset.*;


public class MenuBar extends JFrame implements ActionListener {

  public int id=0;
  JMenuBar jMenuBar1 = new JMenuBar();
  JMenu FILE = new JMenu();
  JMenuItem exit = new JMenuItem();
  JMenu jMenu4 = new JMenu();
  JMenu jMenu6 = new JMenu();
  JMenuItem me = new JMenuItem();
  JMenuItem help = new JMenuItem();
  JMenu admin = new JMenu();
  JMenuItem update = new JMenuItem();

  //ImageIcon image  = new ImageIcon("bangladesh.gif");

  JMenu jMenu3 = new JMenu();
  JMenuItem search = new JMenuItem();
  JMenuItem adj = new JMenuItem();
  JMenuItem data_entry = new JMenuItem();
  JMenuItem lc_in = new JMenuItem();
  JMenuItem soft = new JMenuItem();
  JLabel label;
  JMenuItem lc_search = new JMenuItem();
  JMenu jMenu1 = new JMenu();
  JMenuItem ch = new JMenuItem();
  JMenuItem dy = new JMenuItem();
  JMenuItem ya = new JMenuItem();
  JMenuItem fab = new JMenuItem();
  JMenuItem access = new JMenuItem();



  public MenuBar() {
    try {
      jbInit();
      if(Main.id==0)label.setText("CHEMICAL");
      else if(Main.id==1)label.setText("DYES");
      else if(Main.id==2)label.setText("FABRICS");
      else if(Main.id==3)label.setText("YARN");
      else if(Main.id==4)label.setText("ACCESSORIES");
      setSize(820,680);
      show();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {

    label = new JLabel("",SwingConstants.CENTER);
    label.setFont(new java.awt.Font("Dialog", 1, 20));
    label.setHorizontalAlignment(SwingConstants.CENTER);

    jMenuBar1.setBackground(new Color(118, 166, 188));
    jMenuBar1.setFont(new java.awt.Font("Tahoma", 1, 12));
    this.getContentPane().setBackground(new Color(138, 166, 142));
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setJMenuBar(jMenuBar1);
    this.setTitle("Inventory Management Software");
    this.getContentPane().setLayout(null);
    FILE.setBackground(new Color(118, 166, 187));
    FILE.setFont(new java.awt.Font("Tahoma", 1, 12));
    FILE.setMnemonic('F');
    FILE.setText("FILE   ");
    exit.setBackground(Color.white);
    exit.setMnemonic('X');
    exit.setText("EXIT");
    jMenu4.setBackground(new Color(118, 166, 187));
    jMenu4.setMnemonic('B');
    jMenu4.setText("ABOUT");

    jMenu6.setBackground(new Color(118, 166, 187));
    jMenu6.setMnemonic('H');
    jMenu6.setText("HELP");
    me.setBackground(Color.white);
    me.setMnemonic('D');
    me.setText("About Developer");
    help.setBackground(SystemColor.window);
    help.setMnemonic('E');
    help.setText("Help Topics");
    admin.setBackground(new Color(118, 166, 187));
    admin.setMnemonic('A');
    admin.setText("ADMINISTRATOR");
    update.setBackground(Color.white);
    update.setMnemonic('U');
    update.setText("Update");




    jMenu3.setBackground(new Color(118, 166, 187));
    jMenu3.setMnemonic('S');
    jMenu3.setText("SEARCH");
    search.setBackground(SystemColor.window);
    search.setMnemonic('S');
    search.setText("Search Items");
    adj.setBackground(Color.white);
    adj.setMnemonic('A');
    adj.setText("Adjust Items");
    data_entry.setBackground(Color.white);
    data_entry.setMnemonic('D');
    data_entry.setText("Data Entry");
    lc_in.setBackground(Color.white);
    lc_in.setMnemonic('L');
    lc_in.setText("LC Input");
    soft.setBackground(SystemColor.window);
    soft.setMnemonic('S');
    soft.setText("About Software");
    label.setBounds(new Rectangle(175, 149, 280, 96));
    lc_search.setBackground(SystemColor.window);
    lc_search.setMnemonic('L');
    lc_search.setText("LC Search");
    jMenu1.setBackground(new Color(118, 166, 187));
    jMenu1.setMnemonic('T');
    jMenu1.setText("TYPE");
    ch.setBackground(Color.white);
    ch.setMnemonic('C');
    ch.setText("Chemical");
    dy.setBackground(Color.white);
    dy.setMnemonic('D');
    dy.setText("Dyes");
    ya.setBackground(SystemColor.window);
    ya.setMnemonic('Y');
    ya.setText("Yarn");
    fab.setBackground(Color.white);
    fab.setMnemonic('F');
    fab.setText("Fabrics");
    access.setBackground(Color.white);
    access.setMnemonic('A');
    access.setText("Accessories");
    jMenuBar1.add(FILE);
    jMenuBar1.add(jMenu3);

    jMenuBar1.add(admin);
    jMenuBar1.add(jMenu1);
    jMenuBar1.add(jMenu4);
    jMenuBar1.add(jMenu6);
    FILE.add(data_entry);
    FILE.add(adj);
    FILE.add(lc_in);
    FILE.add(exit);
    jMenu4.add(me);
    jMenu4.add(soft);
    jMenu6.add(help);
    admin.add(update);
    jMenu3.add(search);
    jMenu3.add(lc_search);
    this.getContentPane().add(label, null);
    jMenu1.add(ch);
    jMenu1.add(dy);
    jMenu1.add(fab);
    jMenu1.add(ya);
    jMenu1.add(access);

    search.addActionListener(this);
    exit.addActionListener(this);
    adj.addActionListener(this);
    data_entry.addActionListener(this);
    update.addActionListener(this);
    me.addActionListener(this);
    lc_in.addActionListener(this);
    help.addActionListener(this);
    soft.addActionListener(this);
    lc_search.addActionListener(this);
    ch.addActionListener(this);
    fab.addActionListener(this);
    ya.addActionListener(this);
    dy.addActionListener(this);
    access.addActionListener(this);


  }

  public static void main(String[] args) {
    MenuBar menuBar = new MenuBar();
  }




  /////////////////////////////////////////
  public void actionPerformed(ActionEvent e) {


   if(e.getSource() == data_entry)
        new BillEntry();
   if(e.getSource() == search)
        new search_item();
   if(e.getSource() == adj)
      new Adjust();
   if(e.getSource() == update)
     new Update();
   if(e.getSource()==lc_in)
     new LCInput();
   if(e.getSource()==lc_search)
     new LCSearch();
   if(e.getSource()==me)
   {
     About_Me frame1 = new About_Me();
     // Putting in the Center
     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
     Dimension frameSize = frame1.getSize();
     if (frameSize.height > screenSize.height) {
       frameSize.height = screenSize.height;
     }
     if (frameSize.width > screenSize.width) {
       frameSize.width = screenSize.width;
     }
     frame1.setLocation( (screenSize.width - frameSize.width) / 2,
                        (screenSize.height - frameSize.height) / 2);
     frame1.setVisible(true);

   }


    if(e.getSource() == soft)
    {

      String info="";

      info += "This is a simple inventory software."+"\n";
      info += "The developement of this software is not fully completed"+"\n";
      info += "Though any industry can use this software"+"\n";
      info += "Thank You."+"\n";

      JOptionPane.showMessageDialog(this,info);

    }
    if(e.getSource() == help)
      new Help();
    if (e.getSource() == ch) {
      Main.id = 0;
      Main.set_table_and_name(0);
      dispose();
      new MenuBar();
    }
    if (e.getSource() == dy) {
      Main.id = 1;
      Main.set_table_and_name(1);
      dispose();
      new MenuBar();
    }
    if (e.getSource() == fab) {
      Main.id = 2;
      Main.set_table_and_name(2);
      dispose();
      new MenuBar();
    }
    if (e.getSource() == ya) {
      Main.id = 3;
      Main.set_table_and_name(3);
      dispose();
      new MenuBar();
    }
    if (e.getSource() == access) {
      Main.id = 4;
      Main.set_table_and_name(4);
      dispose();
      new MenuBar();
    }
    if(e.getSource()==exit)
    {
      try{
        Main.conn.close();
      }
      catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "SQL ERROR");
       }

      System.exit(0);

    }




 }






}
