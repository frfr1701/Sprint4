package Client;

import java.awt.event.*;
import javax.swing.*;

class StartPanel extends JPanel {
    
    JButton newGame = new JButton("Nytt spel");
    JPanel test = new JPanel();

    public StartPanel(ActionListener al) {
        newGame.addActionListener(al);
    }
    
    public void setPanel(){
        test.add(newGame);
        add(test);
    }
    

}
