package Client;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

class GameFrame extends Client implements ActionListener, IPanel {

    JFrame mastern;

    CategoryPanel categoryPanel;
    QuestionPanel questionPanel;
    ResultPanel resultPanel;

    JPanel currentPanel;
    Queue panelQueue;

    Color standardColor = new Color(238, 238, 238);

    @Override
    public void setGameStageGUI() {
        panelQueue = new LinkedList<>();
        switch (state = session.getGameState()) {
            case FIRST:
                panelQueue.add(new CategoryPanel(this));
                addQuestionPanelToQueue();

                initFirstSubjectPanel();
                break;
            case MIDDLE:
                addQuestionPanelToQueue();
                panelQueue.add(new CategoryPanel(this));
                addQuestionPanelToQueue();

                initFirstQuestionPanel();
                break;
            case FINAL:
                addQuestionPanelToQueue();

                initFirstQuestionPanel();
                break;
            case GAMECOMPLETE:
                initResultPanel();
                break;
            default:
                writeObject();
        }
        mastern.revalidate();
        mastern.repaint();

    }

    private void addQuestionPanelToQueue() {
        for (int i = 0; i < session.getNumberOfQuestions(); i++) {
            panelQueue.add(new QuestionPanel(ma));
        }
    }

    private void initFirstSubjectPanel() {
        mastern.add(currentPanel = categoryPanel = (CategoryPanel) (panelQueue.remove()));
        subjects = session.getSubjects();
        categoryPanel.setPanel();
        categoryPanel.setSubjects(subjects);
    }

    private void initFirstQuestionPanel() {
        mastern.add(currentPanel = questionPanel = (QuestionPanel) (panelQueue.remove()));
        questionPanel.setPanel();
        questions = session.getQuestionsThisRound();
        questionPanel.setQuestions(questions.remove());
    }

    private void initResultPanel() {
        panelQueue.add(new ResultPanel(this, session));
        mastern.add(currentPanel = resultPanel = (ResultPanel) (panelQueue.remove()));
        resultPanel.setPanel();
    }

    @Override
    public void setPanel() {
        mastern = new JFrame();

        mastern.setTitle("VÄRLDENS BÄSTA QUIZ!");
        mastern.setSize(450, 550);
        mastern.setVisible(true);
        mastern.setLocationRelativeTo(null);
        mastern.revalidate();
        mastern.repaint();

        categoryPanel = new CategoryPanel(this);
        questionPanel = new QuestionPanel(ma);
        resultPanel = new ResultPanel(this, session);

    }

    MouseListener ma = new MouseAdapter() {
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
            mastern.revalidate();
            mastern.repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            mastern.remove(currentPanel);
            if (questions.size() > 0) {
                mastern.add(currentPanel = questionPanel = (QuestionPanel) (panelQueue.remove()));
                questionPanel.setPanel();
                questionPanel.setQuestions(questions.remove());

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
                mastern.add(currentPanel = categoryPanel = (CategoryPanel) (panelQueue.remove()));
                subjects = session.getSubjects();
                categoryPanel.setPanel();
                categoryPanel.setSubjects(subjects);

            } else {
                writeObject();
            }

            mastern.revalidate();
            mastern.repaint();
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
    };

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == categoryPanel.exitGame || ae.getSource() == resultPanel.exitGame) {
            System.exit(0);
        } else if (ae.getSource() == categoryPanel.category1) {
            chooseCategory(categoryPanel.category1);
        } else if (ae.getSource() == categoryPanel.category2) {
            chooseCategory(categoryPanel.category2);
        } else if (ae.getSource() == categoryPanel.category3) {
            chooseCategory(categoryPanel.category3);
        }
        mastern.revalidate();
        mastern.repaint();
    }

    void chooseCategory(JButton category) {
        mastern.remove(currentPanel);
        mastern.add(currentPanel = questionPanel = (QuestionPanel) (panelQueue.remove()));

        session.setQuestionsThisRound(new LinkedList(questions = session.getQuestions(category.getText())));
        questionPanel.setQuestions(questions.remove());
        questionPanel.setPanel();
    }
}
