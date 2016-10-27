package inventory;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class About_Me
    extends JFrame {
  Container c;
  private JLabel bangladesh, bikas;
  private JButton close;
  private JTextArea logo;
  Icon icon = new ImageIcon("bangladesh.gif");
  Icon icon1 = new ImageIcon("bikas.jpg");

  String string = "";

  public About_Me() {
    super("About Me");
    c = getContentPane();
    c.setLayout(new FlowLayout());
    c.setBackground(new Color(136, 225, 165));

    setSize(600,500);

    //bangladesh = new JLabel(icon);
    bikas = new JLabel(icon1);

    string = string + "#This Software is developed by:\n" +
        "\nMd Abu Naser Bikas" +
        "\nContact Number: 01911614279" +
        "\nE-MAIL: bikasbd@yahoo.com" +
        "\nBANGLADESH";
    logo = new JTextArea(22, 30);
    logo.setEditable(false);
    logo.setBackground(new Color(136, 225, 165));
    logo.setForeground(Color.BLACK);
    logo.setFont(new Font("sherif", Font.BOLD, 14));
    logo.setText(string);

    close = new JButton("CLOSE");
    close.setBackground(new Color(136, 225, 165));
    close.setForeground(Color.blue);
    close.setMnemonic('C');
    close.setToolTipText("Press Alt+C");

//adding components to container
    c.add(logo);

    //c.add(bangladesh);
    c.add(bikas);
    c.add(close);

//associating Handler
    Handler hand = new Handler();
    close.addActionListener(hand);

    show();
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }

  }

  private class Handler
      implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      if (event.getSource() == close)
        dispose();
    }
  } //end of class Handler1

  public static void main(String[] args) {
    About_Me About1 = new About_Me();
  }
  private void jbInit() throws Exception {
    this.setResizable(false);
  }
}
