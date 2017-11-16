package Client;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Ian
 */
public class StartMenu extends JPanel {
    JButton startGame;
    Color backgroundColor;
    JButton team;
    

    public StartMenu(JButton startGame, Color backgroundColor, JButton team) {
       this.team = team; 
       this.startGame = startGame;
       this.backgroundColor = backgroundColor;
       
    }

    public void setPanel(){
    this.setLayout(new BorderLayout());
        setSize(300, 300);
    this.add("North", startGame);
    this.add("Center", team);
    
    setBackground(backgroundColor);
    
    
    
    }
    
    
    
    
    
    
    
    
}
