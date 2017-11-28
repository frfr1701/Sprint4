package Client;

import java.awt.*;
import java.awt.event.MouseListener;
import java.util.*;
import java.util.List;
import javax.swing.*;

class QuestionPanel extends JPanel {
<<<<<<< HEAD

    private final JPanel panel;
    private final JPanel panel2;
    private final JLabel question;
    protected Label answer1;
    protected Label answer2;
    protected Label answer3;
    protected Label answer4;
    protected String correctAnswer;
    private List<String> currentQuestion;

=======
    
    JLabel question = new JLabel("", JLabel.CENTER);
    Label answer1 = new Label("", Label.CENTER);
    Label answer2 = new Label("", Label.CENTER);
    Label answer3 = new Label("", Label.CENTER);
    Label answer4 = new Label("", Label.CENTER);
    String correctAnswer = "";
    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();
    Color backgroundColor = new Color(20, 134, 186);  
    final String html1 = "<html><body style='width: 100px>";

    
    
    java.util.List<String> currentQuestion;
>>>>>>> färgläggning

    protected QuestionPanel(MouseListener ma) {
        answer4 = new Label("", Label.CENTER);
        answer3 = new Label("", Label.CENTER);
        answer2 = new Label("", Label.CENTER);
        answer1 = new Label("", Label.CENTER);
        question = new JLabel("", JLabel.CENTER);
        panel2 = new JPanel();
        panel = new JPanel();

        answer1.addMouseListener(ma);
        answer2.addMouseListener(ma);
        answer3.addMouseListener(ma);
        answer4.addMouseListener(ma);
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
<<<<<<< HEAD

    protected void setQuestions(List<String> question) {
        if (question.get(1).length() > 45) {
            int add = question.get(1).length() / 2;
            String temp = question.get(1).substring(add);
            add += temp.indexOf(" ");
            temp = "<html>" + question.get(1).substring(0, add) + "<br>" + question.get(1).substring(add + 1) + "</html>";
            this.question.setText(temp);
        } else {
            this.question.setText(question.get(1));
        }
        correctAnswer=question.get(2);
=======
    protected void setQuestions(List<String> question){
        this.question.setText(html1+question.get(1));
        correctAnswer = question.get(2);
>>>>>>> färgläggning
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
