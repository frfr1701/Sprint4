package Client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class StartPanel extends JPanel {

    JButton exitGame = new JButton("Avsluta");
    JButton newGame = new JButton("Nytt spel");
    protected JPanel top = new JPanel();
    protected JPanel mid = new JPanel();
    protected JPanel low = new JPanel();
    JLabel team = new JLabel(new ImageIcon("/Users/Ian/Desktop/test/export.png"));

    public StartPanel(ActionListener al) {
        newGame.addActionListener(al);
        exitGame.addActionListener(al);

    }

    public void setPanel() {
       // setSize(600, 600);
       // setLayout(new BorderLayout());
       // panel.setLayout(new BorderLayout());
       newGame.setPreferredSize(new Dimension(100, 100));
       exitGame.setPreferredSize(new Dimension(100, 100));
        //panel2.add("Center", newGame);
       // panel3.add("Center", exitGame);
       // panel.add("North", panel2);
       // panel.add("Center", team);
       // panel.add("South", panel3);
       // add("Center", panel);
       
       top.setLayout(new BorderLayout());
       top.add("Center", team);
       low.setLayout(new GridLayout(1,2));
       low.add(newGame);
       low.add(exitGame);
       mid.setLayout(new BorderLayout());
       mid.add("North", top);
       mid.add("South", low);
       add(mid);
       
       
       
        setBorder(BorderFactory.createLineBorder((new Color(175, 175, 200)), 10));

    }

}
