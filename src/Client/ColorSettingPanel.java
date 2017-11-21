package Client;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Ian
 */
public class ColorSettingPanel extends JPanel implements IPanel {
    JButton goBack;
    JButton black;
    JButton red;
    JButton standard;
    JButton yellow;
    JPanel panel = new JPanel();
    Color backgroundColor = new Color(175, 175, 200); 

    public ColorSettingPanel(ActionListener al) {
        
        goBack = new JButton("Tillbaka");
        standard = new JButton("Standard");
        black = new JButton("Svart");
        red = new JButton("Röd");
        yellow = new JButton("Gul");
        goBack.addActionListener(al);
        black.addActionListener(al);
        red.addActionListener(al);
        yellow.addActionListener(al);
        standard.addActionListener(al);
    }
    
    
    
    @Override
    public void setPanel() {
        setBackground(backgroundColor);
        panel.setBackground(backgroundColor);
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder((new Color(175, 175, 200)), 10));
        goBack.setPreferredSize(new Dimension(50, 50));
        add("North", goBack);
        
        
        panel.setLayout(new GridLayout(1,4,10,10));
        panel.add(black);
        panel.add(yellow);
        panel.add(red);
        panel.add(standard);
        add("Center", panel);
        
 
    }
    @Override
    public void setColor(Color backgroundColor){
        this.backgroundColor = backgroundColor;
        setPanel();
        repaint();
    }
    
}
