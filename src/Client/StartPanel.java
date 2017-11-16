package Client;

import java.awt.event.*;
import javax.swing.*;

class StartPanel extends JPanel {
    
    JButton newGame = new JButton("Nytt spel");
    JLabel logo = new JLabel(new ImageIcon("/Users/Ian/Desktop/test/export.png"));
    JPanel panel = new JPanel();
    JPanel test = new JPanel();

    public StartPanel(ActionListener al) {
        newGame.addActionListener(al);
        
    }
    
    public void setPanel(){
       //panel.add(logo);
       //panel.add(newGame);
       //add(panel);
        test.add(newGame);
        test.setOpaque(true);
        add(test);
        setOpaque(true);
        newGame.setOpaque(true);
    }
    

}
