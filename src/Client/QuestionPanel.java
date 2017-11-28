package Client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.MouseListener;
import java.util.*;
import javax.swing.*;

class QuestionPanel extends JPanel {
    
    JLabel question = new JLabel("", JLabel.CENTER);
    Label answer1 = new Label("", Label.CENTER);
    Label answer2 = new Label("", Label.CENTER);
    Label answer3 = new Label("", Label.CENTER);
    Label answer4 = new Label("", Label.CENTER);
    String correctAnswer = "";
    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();
    Color backgroundColor = new Color(20, 134, 186);  

    
    
    java.util.List<String> currentQuestion;

    protected QuestionPanel(MouseListener ma) {

        answer1.addMouseListener(ma);
        answer2.addMouseListener(ma);
        answer3.addMouseListener(ma);
        answer4.addMouseListener(ma);
        currentQuestion = new ArrayList<>();
        
    }

    protected void setPanel() {
        question.setPreferredSize(new Dimension(100, 200));
        question.setBackground(new Color(240,240,240));
        
        panel.setBackground(new Color(53,53,53));
        panel.setBorder(BorderFactory.createLineBorder(backgroundColor, 5));
        setLayout(new BorderLayout());
        panel.setLayout(new GridLayout(2, 2));
        add("North", panel2);
        add("Center", panel);
        answer1.setForeground(Color.WHITE);
        answer2.setForeground(Color.WHITE);
        answer3.setForeground(Color.WHITE);
        answer4.setForeground(Color.WHITE);
        
        
        panel.add(answer1);
        panel.add(answer2);
        panel.add(answer3);
        panel.add(answer4);
        panel2.setBackground(new Color(238,238,238));
        panel2.setLayout(new BorderLayout());
        panel2.add("Center", question);
        panel2.setBackground(new Color(242,242,242));
        panel2.setBorder(BorderFactory.createLineBorder(backgroundColor, 5));
        setBorder(BorderFactory.createLineBorder(backgroundColor, 20));

    }
    protected void setQuestions(List<String> question){
        this.question.setText(question.get(1));
        correctAnswer = question.get(2);
        for (int i = 2; i < question.size(); i++) {
            currentQuestion.add(question.get(i));
        }
        Collections.shuffle(currentQuestion);
        answer1.setText(currentQuestion.get(0));
        answer2.setText(currentQuestion.get(1));
        answer3.setText(currentQuestion.get(2));
        answer4.setText(currentQuestion.get(3));
    }
}
