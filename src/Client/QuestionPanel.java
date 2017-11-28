package Client;

import java.awt.*;
import java.awt.event.MouseListener;
import java.util.*;
import java.util.List;
import javax.swing.*;

class QuestionPanel extends JPanel {

    private final JPanel panel;
    private final JPanel panel2;
    private final JLabel question;
    protected Label answer1;
    protected Label answer2;
    protected Label answer3;
    protected Label answer4;
    protected String correctAnswer;
    private List<String> currentQuestion;


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
