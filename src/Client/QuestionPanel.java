package Client;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

class QuestionPanel extends JPanel implements IPanel {
    
    Label question = new Label("Vem är längst av Jakob och?", Label.CENTER);
    Label answer1 = new Label("1", Label.CENTER);
    Label answer2 = new Label("Svar 2", Label.CENTER);
    Label answer3 = new Label("Svar 3", Label.CENTER);
    Label answer4 = new Label("Svar 4", Label.CENTER);
    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();
    Color backgroundColor = new Color(175, 175, 200);    

    public QuestionPanel(MouseListener ma) {

        answer1.addMouseListener(ma);
        answer2.addMouseListener(ma);
        answer3.addMouseListener(ma);
        answer4.addMouseListener(ma);
        
    }

    @Override
    public void setPanel() {
        question.setPreferredSize(new Dimension(100, 200));
        panel.setBackground(backgroundColor);
        setLayout(new BorderLayout());
        panel.setLayout(new GridLayout(2, 2));
        add("North", panel2);
        add("Center", panel);
        panel.add(answer1);
        panel.add(answer2);
        panel.add(answer3);
        panel.add(answer4);
        panel2.setLayout(new BorderLayout());
        panel2.add("Center", question);
        
        setBorder(BorderFactory.createLineBorder((new Color(175, 175, 200)), 10));
        panel2.setBorder(BorderFactory.createLineBorder((new Color(175, 175, 200)), 5));

    }
    @Override
    public void setColor(Color backgroundColor){
        this.backgroundColor = backgroundColor;
        setPanel();
        repaint();
    }
    
//    public void setAnswers(List<String> answers){
//        
//    }

}
