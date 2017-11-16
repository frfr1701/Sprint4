package Client;

import java.awt.event.ActionListener;
import javax.swing.*;

class StartPanel extends JPanel {

    JButton newGame = new JButton("Nytt spel");
    

    public StartPanel(ActionListener al) {
        
        newGame.addActionListener(al);
    }
    

}
