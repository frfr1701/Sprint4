package Client;

import java.awt.event.*;
import java.awt.*;
import java.util.List;
import javax.swing.*;

public class CategoryPanel extends JPanel{

    JButton category1 = new JButton("");
    JButton category2 = new JButton("");
    JButton category3 = new JButton("");
    JButton exitGame = new JButton("Avsluta");
    JPanel panel = new JPanel();
    Color backgroundColor = new Color(175, 175, 200);

    protected CategoryPanel(ActionListener al) {
        category1.addActionListener(al);
        category2.addActionListener(al);
        category3.addActionListener(al);
        exitGame.addActionListener(al);
    }

    protected void setPanel() {
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

    protected void setSubjects(List<String> subjects) {
        category1.setText(subjects.get(0));
        category2.setText(subjects.get(1));
        category3.setText(subjects.get(2));
    }
}