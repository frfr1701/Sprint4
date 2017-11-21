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
        
        
        panel.setLayout(new GridLayout(2,2, 100, 60));
        panel.add(black);
        panel.add(yellow);
        panel.add(red);
        panel.add(standard);
        add("Center", panel);
        black.setPreferredSize(new Dimension (75, 100));
        red.setPreferredSize(new Dimension (75, 100));
        standard.setPreferredSize(new Dimension (75, 100));
        yellow.setPreferredSize(new Dimension (75, 100));
        
        
       
        
    }
    @Override
    public void setColor(Color backgroundColor){
        this.backgroundColor = backgroundColor;
        setPanel();
        repaint();
    }
    
}
