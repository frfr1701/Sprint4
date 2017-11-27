package Client;

import static Domain.State.MIDDLE;
import java.awt.Color;
import java.awt.Label;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

class GameFrame extends Client implements ActionListener, IPanel {

    Queue panelQueue;

    JFrame mastern;
    ColorSettingPanel colorSetterPanel;
    StartPanel startPanel;
    CategoryPanel categoryPanel;
    QuestionPanel questionPanel;
    ResultPanel resultPanel;

    JPanel currentPanel;

    List<IPanel> panelList;

    Color standardColor = new Color(238, 238, 238);
    Color backgroundColor = new Color(175, 175, 200);


    @Override
    public void setGameStageGUI() {
        panelQueue = new LinkedList<>();
        switch (state = session.getGameState()) {
            case FIRST:
                panelQueue.add(new CategoryPanel(this));
                addQuestionPanelToQueue();
                initFirstSubjectPanel();
                session.setGameState(MIDDLE);
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
                panelQueue = new LinkedList<>();
                panelQueue.add(new  ResultPanel(this));
                
                mastern.add(currentPanel = resultPanel = (ResultPanel) (panelQueue.remove()));
                resultPanel.setPanel();
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
        subjects = session.getSubjects();
        mastern.add(currentPanel = categoryPanel = (CategoryPanel) (panelQueue.remove()));
        categoryPanel.setPanel();
        categoryPanel.setSubjects(subjects);
    }

    private void initFirstQuestionPanel() {
        mastern.add(currentPanel = questionPanel = (QuestionPanel) (panelQueue.remove()));
        questionPanel.setPanel();
        questions = session.getQuestionsThisRound();
        questionPanel.setQuestions(questions.remove());
    }

    @Override
    public void setPanel() {
        mastern = new JFrame();
        mastern.setTitle("VÄRLDENS BÄSTA QUIZ!");
        mastern.setSize(450, 550);
        mastern.setVisible(true);
        mastern.setLocationRelativeTo(null);
        mastern.setDefaultCloseOperation(3);


        mastern.revalidate();
        mastern.repaint();

        colorSetterPanel = new ColorSettingPanel(this);
        startPanel = new StartPanel(this);
        categoryPanel = new CategoryPanel(this);
        questionPanel = new QuestionPanel(ma);
        resultPanel = new ResultPanel(this);

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
            mastern.remove(questionPanel);
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

            } else if (session.getGameState() == MIDDLE && panelQueue.size() > session.getNumberOfQuestions()) {
                subjects = session.getSubjects();
                mastern.add(currentPanel = categoryPanel = (CategoryPanel) (panelQueue.remove()));
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
        if (ae.getSource() == startPanel.newGame) {

        } else if (ae.getSource() == startPanel.exitGame || ae.getSource() == categoryPanel.exitGame || ae.getSource()==resultPanel.exitGame) {
            System.exit(0);
        } else if (ae.getSource() == categoryPanel.goBack) {

        } else if (ae.getSource() == categoryPanel.category1) {
            chooseCategory(categoryPanel.category1);
        } else if (ae.getSource() == categoryPanel.category2) {
            chooseCategory(categoryPanel.category2);
        } else if (ae.getSource() == categoryPanel.category3) {
            chooseCategory(categoryPanel.category3);

        } else if (ae.getSource() == startPanel.settings) {

        } else if (ae.getSource() == colorSetterPanel.black) {
            panelList.forEach(p -> p.setColor(Color.BLACK));
        } else if (ae.getSource() == colorSetterPanel.yellow) {
            panelList.forEach(p -> p.setColor(Color.YELLOW));
        } else if (ae.getSource() == colorSetterPanel.red) {
            panelList.forEach(p -> p.setColor(Color.RED));
        } else if (ae.getSource() == colorSetterPanel.standard) {
            panelList.forEach(p -> p.setColor(backgroundColor));
        } else if (ae.getSource() == colorSetterPanel.goBack) {
        } 
        mastern.revalidate();
        mastern.repaint();
    }

    void chooseCategory(JButton category) {
        mastern.remove(currentPanel);
        categoryPanel.subject = category.getText();
        questions = session.getQuestions(categoryPanel.subject);
        session.setQuestionsThisRound(new LinkedList(questions));

        currentPanel = questionPanel = (QuestionPanel) (panelQueue.remove());
        questionPanel.setQuestions(questions.remove());
        questionPanel.setPanel();

        mastern.add(currentPanel);
    }

    @Override
    public void setColor(Color backgroundColor) {
    }
    
//    private void checkAnswers() {
//        questions.stream()
//                .filter((question) -> (question.get(2).equalsIgnoreCase(answers.remove())))
//                .forEach((correctAnswer) -> {
//                    session.givePointToPlayer();
//                });
//    }
}
