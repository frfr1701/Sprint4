package Client;

import java.awt.event.*;
import java.awt.*;
import java.util.List;
import javax.swing.*;

public class CategoryPanel extends JPanel {

<<<<<<< HEAD
    private final Color backgroundColor;
    private final JPanel panel;
    protected JButton category1;
    protected JButton category2;
    protected JButton category3;
    protected JButton exitGame;
=======
    JButton category1 = new JButton("");
    JButton category2 = new JButton("");
    JButton category3 = new JButton("");
    JButton exitGame = new JButton("Avsluta");
    JPanel panel = new JPanel();
    Color backgroundColor = new Color(20, 134, 186);
    Color redColor = new Color(210, 45, 45);
>>>>>>> färgläggning

    protected CategoryPanel(ActionListener al) {
        backgroundColor = new Color(175, 175, 200);
        panel = new JPanel();
        category1 = new JButton();
        category2 = new JButton();
        category3 = new JButton();
        exitGame = new JButton("Avsluta");

        category1.addActionListener(al);
        category2.addActionListener(al);
        category3.addActionListener(al);
        exitGame.addActionListener(al);
    }

    protected void setPanel() {
        setBackground(backgroundColor);
        panel.setBackground(backgroundColor);
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(backgroundColor, 20));
        panel.setLayout(new GridLayout(1, 3, 50, 50));
        category1.setBackground( new Color(240,240,240));
        category1.setBorder(BorderFactory.createLineBorder(backgroundColor, 5));
        category2.setBackground(new Color(240,240,240));
        category2.setBorder(BorderFactory.createLineBorder(backgroundColor, 5));
        category3.setBackground(new Color(240,240,240));
        category3.setBorder(BorderFactory.createLineBorder(backgroundColor, 5));
        exitGame.setBackground(new Color(240,240,240));
        panel.setBackground(backgroundColor);
        panel.add(category1);
        panel.add(category2);
        panel.add(category3);
        add("Center", panel);
        add("South", exitGame);
        exitGame.setBorder(BorderFactory.createLineBorder(backgroundColor, 5));
        exitGame.setPreferredSize(new Dimension(50, 50));
    }

    protected void setSubjects(List<String> subjects) {
        category1.setText(subjects.get(0));
        category2.setText(subjects.get(1));
        category3.setText(subjects.get(2));
    }
}
