package Client;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

class GameFrame extends Client implements ActionListener{

    JFrame mastern;
    CategoryPanel categoryPanel;
    QuestionPanel questionPanel;
    ResultPanel resultPanel;

    JPanel currentPanel;

    Color standardColor = new Color(238, 238, 238);

    protected GameFrame() {
        mastern = new JFrame();
    }

    @Override
    protected void setPanel() {
        IanWasHere();
        mastern.setSize(450, 550);
        mastern.setVisible(true);
        mastern.setLocationRelativeTo(null);
        RevalidateRepaint();
    }

    private void IanWasHere() {
        mastern.setTitle("VÄRLDENS BÄSTA QUIZ!");
    }

    @Override
    protected void RevalidateRepaint() {
        mastern.revalidate();
        mastern.repaint();
    }

    @Override
    protected void addQuestionPanelsToQueue() {
        for (int i = 0; i < session.getNumberOfQuestions(); i++) {
            panelQueue.add(new QuestionPanel(ma));
        }
    }

    @Override
    protected void addCategoryPanelToQueue() {
        panelQueue.add(new CategoryPanel(this));
    }

    @Override
    protected void addResultPanelToQueue() {
        panelQueue.add(new ResultPanel(this, session));
    }

    @Override
    protected void initSubjectPanel() {
        mastern.add(currentPanel = categoryPanel = (CategoryPanel) (panelQueue.remove()));
        subjects = session.getSubjects();
        categoryPanel.setPanel();
        categoryPanel.setSubjects(subjects);
    }

    @Override
    protected void initQuestionPanel() {
        mastern.add(currentPanel = questionPanel = (QuestionPanel) (panelQueue.remove()));
        questionPanel.setQuestions(questions.remove());
        questionPanel.setPanel();
    }

    @Override
    protected void initResultPanel() {
        mastern.add(currentPanel = resultPanel = (ResultPanel) (panelQueue.remove()));
        resultPanel.setPanel();
    }

    private final MouseListener ma = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getSource() == questionPanel.answer1) {
                buttonColor(questionPanel.answer1);
            } else if (e.getSource() == questionPanel.answer2) {
                buttonColor(questionPanel.answer2);
            } else if (e.getSource() == questionPanel.answer3) {
                buttonColor(questionPanel.answer3);
            } else if (e.getSource() == questionPanel.answer4) {
                buttonColor(questionPanel.answer4);
            }
            RevalidateRepaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            mastern.remove(currentPanel);
            if (questions.size() > 0) {
                initQuestionPanel();
                if (e.getSource() == questionPanel.answer1) {
                    questionPanel.answer1.setBackground(standardColor);
                } else if (e.getSource() == questionPanel.answer2) {
                    questionPanel.answer2.setBackground(standardColor);
                } else if (e.getSource() == questionPanel.answer3) {
                    questionPanel.answer3.setBackground(standardColor);
                } else if (e.getSource() == questionPanel.answer4) {
                    questionPanel.answer4.setBackground(standardColor);
                }

            } else if (panelQueue.size() > session.getNumberOfQuestions()) {
                initSubjectPanel();
            } else {
                writeObject();
            }
            RevalidateRepaint();
        }
    };

    @Override
    public void actionPerformed(ActionEvent ae) {
        mastern.remove(currentPanel);
        if (ae.getSource() == categoryPanel.category1) {
            session.setQuestionsThisRound(new LinkedList(questions = session.getQuestions(categoryPanel.category1.getText())));
            initQuestionPanel();
        } else if (ae.getSource() == categoryPanel.category2) {
            session.setQuestionsThisRound(new LinkedList(questions = session.getQuestions(categoryPanel.category1.getText())));
            initQuestionPanel();
        } else if (ae.getSource() == categoryPanel.category3) {
            session.setQuestionsThisRound(new LinkedList(questions = session.getQuestions(categoryPanel.category1.getText())));
            initQuestionPanel();
        } else if (ae.getSource() == categoryPanel.exitGame || ae.getSource() == resultPanel.exitGame) {
            System.exit(0);
        }
        RevalidateRepaint();
    }

    private void buttonColor(Label answer) {
        if (answer.getText().equalsIgnoreCase(questionPanel.correctAnswer)) {
            session.giveAnswerResultToPlayerList(true);
            answer.setBackground(Color.GREEN);
        } else {
            session.giveAnswerResultToPlayerList(false);
            answer.setBackground(Color.RED);
        }
    }

}
