package Client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Ian
 */
public class CategoryPanel extends JPanel implements IPanel {

    JButton category1 = new JButton("");
    JButton category2 = new JButton("");
    JButton category3 = new JButton("");
    JButton exitGame = new JButton("Avsluta");
    JPanel panel = new JPanel();
    Color backgroundColor = new Color(175, 175, 200);
    
    String subject = "";

    public CategoryPanel(ActionListener al) {
        category1.addActionListener(al);
        category2.addActionListener(al);
        category3.addActionListener(al);
        exitGame.addActionListener(al);
    }

    @Override
    public void setPanel() {
        setBackground(backgroundColor);
        panel.setBackground(backgroundColor);
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.BLUE, 20));
        panel.setLayout(new GridLayout(1, 3, 10, 10));
        category1.setBackground(Color.WHITE);
        category1.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
        category2.setBackground(Color.WHITE);
        category2.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
        category3.setBackground(Color.WHITE);
        category3.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
        exitGame.setBackground(Color.WHITE);
        panel.setBackground(Color.BLUE);
        panel.add(category1);
        panel.add(category2);
        panel.add(category3);
        add("Center", panel);
        add("South", exitGame);
        exitGame.setPreferredSize(new Dimension(50, 50));
    }

    @Override
    public void setColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        setPanel();
        repaint();

    }
    public void setSubjects(List<String> subjects){
        category1.setText(subjects.get(0));
        category2.setText(subjects.get(1));
        category3.setText(subjects.get(2));
    }

    String getSubject() {
        return subject;
    }
}
