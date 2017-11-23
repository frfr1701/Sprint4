package Client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.MouseListener;
import java.util.*;
import javax.swing.*;

class QuestionPanel extends JPanel implements IPanel {
    
    Label question = new Label("", Label.CENTER);
    Label answer1 = new Label("", Label.CENTER);
    Label answer2 = new Label("", Label.CENTER);
    Label answer3 = new Label("", Label.CENTER);
    Label answer4 = new Label("", Label.CENTER);
    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();
    Color backgroundColor = new Color(175, 175, 200);   
    
    java.util.List<String> currentQuestion;

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
    public void setQuestions(List<String> question){
        currentQuestion = question;
        this.question.setText(currentQuestion.get(1));
        answer1.setText(currentQuestion.get(2));
        answer2.setText(currentQuestion.get(3));
        answer3.setText(currentQuestion.get(4));
        answer4.setText(currentQuestion.get(5));
    }
}
