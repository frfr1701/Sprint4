package Client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Ian
 */
public class CategoryPanel extends JPanel implements IPanel {
    
    JButton category1 = new JButton("Sport och fritid");
    JButton category2 = new JButton("Nöje och media");
    JButton category3 = new JButton("I labbet");
    JButton goBack = new JButton("Tillbaka");
    JButton exitGame = new JButton("Avsluta");
    JPanel panel = new JPanel();
    Color backgroundColor = new Color(175, 175, 200);
    

    public CategoryPanel(ActionListener al) {
        category1.addActionListener(al);
        category2.addActionListener(al);
        category3.addActionListener(al);
        goBack.addActionListener(al);
        exitGame.addActionListener(al);
    }
    
    @Override
    public void setPanel(){
        setBackground(backgroundColor);
        panel.setBackground(backgroundColor);
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder((new Color(175, 175, 200)), 10));
        panel.setLayout(new GridLayout(1,3,10,10));
        panel.add(category1);
        panel.add(category2);
        panel.add(category3);
        add("Center", panel);
        add("South", exitGame);
        add("North", goBack);
        goBack.setPreferredSize(new Dimension(50, 50));
        exitGame.setPreferredSize(new Dimension(100, 100));
         
        
        
    }
    
    
    @Override
    public void setColor(Color backgroundColor){
        this.backgroundColor = backgroundColor;
        setPanel();
        repaint();
        
    }
    
}
