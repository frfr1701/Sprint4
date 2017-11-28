package Client;

import java.awt.*;
import java.awt.event.MouseListener;
import java.util.*;
import java.util.List;
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
    Color backgroundColor = new Color(175, 175, 200);

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
        question.setBackground(Color.WHITE);
        question.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        panel.setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        panel.setLayout(new GridLayout(2, 2));
        add("North", panel2);
        add("Center", panel);
        answer1.setBackground(Color.WHITE);
        answer2.setBackground(Color.WHITE);
        answer3.setBackground(Color.WHITE);
        answer4.setBackground(Color.WHITE);
        panel.add(answer1);
        panel.add(answer2);
        panel.add(answer3);
        panel.add(answer4);
        panel2.setLayout(new BorderLayout());
        panel2.add("Center", question);
        panel2.setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLUE, 20));

    }

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
