package Client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class StartPanel extends JPanel implements IPanel {

    JButton exitGame;
    JButton newGame;
    JButton settings;
    JPanel top = new JPanel();
    JPanel mid = new JPanel();
    JPanel low = new JPanel();
    JLabel team = new JLabel(new ImageIcon("src/Client/Resources/export.png"));
    Color backgroundColor = new Color(175, 175, 200); 

    public StartPanel(ActionListener al) {
        exitGame = new JButton("Avsluta");
        newGame = new JButton("Nytt spel");
        settings = new JButton("Inställningar");
        
        newGame.addActionListener(al);
        exitGame.addActionListener(al);
        settings.addActionListener(al);

    }

    @Override
    public void setPanel() {
        newGame.setPreferredSize(new Dimension(100, 100));
        exitGame.setPreferredSize(new Dimension(50, 50));
        setBackground(backgroundColor);
        top.setBackground(backgroundColor);
        low.setBackground(backgroundColor);
        mid.setBackground(backgroundColor);
        top.setLayout(new BorderLayout());
        top.add("Center", team);
        low.setLayout(new GridLayout(1, 2));
        low.add(newGame);
        low.add(exitGame);
        low.add(settings);
        mid.setLayout(new BorderLayout());
        mid.add("North", top);
        mid.add("South", low);
        add(mid);

        setBorder(BorderFactory.createLineBorder((new Color(175, 175, 200)), 10));

    }
    @Override
    public void setColor(Color backgroundColor){
        this.backgroundColor = backgroundColor;
        setPanel();
        repaint();
    }

}
