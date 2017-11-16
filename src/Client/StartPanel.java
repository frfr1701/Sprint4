package Client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class StartPanel extends JPanel {
    JButton exitGame = new JButton("Avsluta");
    JButton newGame = new JButton("Nytt spel");
    JPanel panel = new JPanel();
    JLabel team = new JLabel(new ImageIcon("/Users/Ian/Desktop/test/export.png"));
    
    
    public StartPanel(ActionListener al) {
        newGame.addActionListener(al);
        exitGame.addActionListener(al);
        
    }
    
    public void setPanel(){
        
        setLayout(new FlowLayout());
        panel.setLayout(new BorderLayout());
        panel.add("North", newGame);
        panel.add("Center", team);
        panel.add("South", exitGame);
        add(panel);
         
        
    }
    

}
