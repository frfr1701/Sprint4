package Client;

import Domain.*;
import static Domain.State.MIDDLE;
import java.awt.Color;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

class GamePanel extends Client implements ActionListener, IPanel {
    Queue panelQueue;

    JFrame mastern;
    ColorSettingPanel colorSetterPanel;
    StartPanel startPanel;
    CategoryPanel categoryPanel;
    QuestionPanel questionPanel;
    ResultPanel resultPanel;
    
    JPanel CurrentPanel;

    List<IPanel> panelList;

    Color standardColor = new Color(238, 238, 238);
    Color backgroundColor = new Color(175, 175, 200);



    @Override
    public void setGameStageGUI() {
        switch (session.getGameState()) {
            case FIRST:
                panelQueue = new LinkedList<>();
                panelQueue.add(categoryPanel = new CategoryPanel(this));
                panelQueue.add(questionPanel = new QuestionPanel(ma));
                panelQueue.add(questionPanel = new QuestionPanel(ma));
                panelQueue.add(questionPanel = new QuestionPanel(ma));
                
                subjects = session.getSubjects();
                state = session.getGameState();

                session.setGameState(MIDDLE);
                break;
            case MIDDLE:
                panelQueue = new LinkedList<>();
                panelQueue.add(questionPanel = new QuestionPanel(ma));
                panelQueue.add(questionPanel = new QuestionPanel(ma));
                panelQueue.add(questionPanel = new QuestionPanel(ma));
                panelQueue.add(categoryPanel = new CategoryPanel(this));
                panelQueue.add(questionPanel = new QuestionPanel(ma));
                panelQueue.add(questionPanel = new QuestionPanel(ma));
                panelQueue.add(questionPanel = new QuestionPanel(ma));
                break;
            case FINAL:
                panelQueue = new LinkedList<>();
                panelQueue.add(categoryPanel = new CategoryPanel(this));
                break;
            case GAMECOMPLETE:

                break;
            default:
                writeObject();
        }
    }

    

    @Override
    public void setPanel() {
        mastern = new JFrame();
        mastern.setTitle("VÄRLDENS BÄSTA QUIZ!");
        mastern.setSize(450, 550);
        mastern.setVisible(true);
        mastern.setLocationRelativeTo(null);
        mastern.setDefaultCloseOperation(3);
        mastern.add(startPanel = new StartPanel(this));
        startPanel.setPanel();

        mastern.revalidate();
        mastern.repaint();
    }

    MouseListener ma = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {

            if (e.getSource() == questionPanel.answer1) {
                if (questionPanel.answer1.getText().equalsIgnoreCase(questionPanel.currentQuestion.get(2))) {
                    questionPanel.answer1.setBackground(Color.GREEN);
                } else {
                    questionPanel.answer1.setBackground(Color.RED);
                }
            } else if (e.getSource() == questionPanel.answer2) {

                if (questionPanel.answer1.getText().equalsIgnoreCase(questionPanel.currentQuestion.get(2))) {
                    questionPanel.answer2.setBackground(Color.GREEN);
                } else {
                    questionPanel.answer2.setBackground(Color.RED);
                }
            } else if (e.getSource() == questionPanel.answer3) {
                if (questionPanel.answer1.getText().equalsIgnoreCase(questionPanel.currentQuestion.get(2))) {
                    questionPanel.answer3.setBackground(Color.GREEN);
                } else {
                    questionPanel.answer3.setBackground(Color.RED);
                }
            } else if (e.getSource() == questionPanel.answer4) {
                if (questionPanel.answer1.getText().equalsIgnoreCase(questionPanel.currentQuestion.get(2))) {
                    questionPanel.answer4.setBackground(Color.GREEN);
                } else {
                    questionPanel.answer4.setBackground(Color.RED);
                }
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (questions.size() > 0) {
                if (e.getSource() == questionPanel.answer1) {
                    mastern.remove(questionPanel);
                    questionPanel.answer1.setBackground(standardColor);
                    questionPanel = new QuestionPanel(this);

                    questionPanel.setQuestions(questions.remove());
                } else if (e.getSource() == questionPanel.answer2) {
                    mastern.remove(questionPanel);

                    questionPanel.answer2.setBackground(standardColor);
                    questionPanel = new QuestionPanel(this);
                    questionPanel.setQuestions(questions.remove());
                } else if (e.getSource() == questionPanel.answer3) {
                    mastern.remove(questionPanel);

                    questionPanel.answer3.setBackground(standardColor);
                    questionPanel.setQuestions(questions.remove());
                    questionPanel = new QuestionPanel(this);
                } else if (e.getSource() == questionPanel.answer4) {
                    mastern.remove(questionPanel);

                    questionPanel.answer4.setBackground(standardColor);
                    questionPanel = new QuestionPanel(this);
                    questionPanel.setQuestions(questions.remove());
                }
                questionPanel.setPanel();
                mastern.add(questionPanel);
            } else if (state == State.MIDDLE) {

            } else {
                mastern.remove(questionPanel);
                writeObject();
            }

            mastern.revalidate();
            mastern.repaint();
        }
    };

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == startPanel.newGame) {
            mastern.remove(startPanel);
            mastern.add(CurrentPanel = categoryPanel = (CategoryPanel)(panelQueue.remove()));
            categoryPanel.setPanel();
            categoryPanel.setSubjects(subjects);
        } else if (ae.getSource() == startPanel.exitGame || ae.getSource() == categoryPanel.exitGame) {
            System.exit(0);
        } else if (ae.getSource() == categoryPanel.goBack) {
//            mastern.remove(categoryPanel);
//            mastern.add(startPanel);
//            startPanel.setPanel();
        } else if (ae.getSource() == categoryPanel.category1) {
            mastern.remove(CurrentPanel);
            CurrentPanel = questionPanel = (QuestionPanel)(panelQueue.remove());
            
            categoryPanel.subject = categoryPanel.category1.getText();
            questions = session.getQuestions(categoryPanel.subject);
            session.setQuestionsThisRound(new LinkedList(questions));
            questionPanel.setQuestions(questions.remove());
            questionPanel.setPanel();
            
            mastern.add(CurrentPanel);
        } else if (ae.getSource() == categoryPanel.category2) {
            mastern.remove(CurrentPanel);
            CurrentPanel = questionPanel = (QuestionPanel)(panelQueue.remove());
            
            categoryPanel.subject = categoryPanel.category1.getText();
            questions = session.getQuestions(categoryPanel.subject);
            session.setQuestionsThisRound(new LinkedList(questions));
            questionPanel.setQuestions(questions.remove());
            questionPanel.setPanel();
            
            mastern.add(CurrentPanel);
        } else if (ae.getSource() == categoryPanel.category3) {
            mastern.remove(CurrentPanel);
            CurrentPanel = questionPanel = (QuestionPanel)(panelQueue.remove());
            
            categoryPanel.subject = categoryPanel.category1.getText();
            questions = session.getQuestions(categoryPanel.subject);
            session.setQuestionsThisRound(new LinkedList(questions));
            questionPanel.setQuestions(questions.remove());
            questionPanel.setPanel();
            
            mastern.add(CurrentPanel);
        } else if (ae.getSource() == startPanel.settings) {
            mastern.remove(startPanel);
            mastern.add(colorSetterPanel);
            colorSetterPanel.setPanel();
        } else if (ae.getSource() == colorSetterPanel.black) {
            panelList.forEach(p -> p.setColor(Color.BLACK));
        } else if (ae.getSource() == colorSetterPanel.yellow) {
            panelList.forEach(p -> p.setColor(Color.YELLOW));
        } else if (ae.getSource() == colorSetterPanel.red) {
            panelList.forEach(p -> p.setColor(Color.RED));
        } else if (ae.getSource() == colorSetterPanel.standard) {
            panelList.forEach(p -> p.setColor(backgroundColor));
        } else if (ae.getSource() == colorSetterPanel.goBack) {
            mastern.remove(colorSetterPanel);
            mastern.add(startPanel);
            startPanel.setPanel();
        }
        mastern.revalidate();
        mastern.repaint();

    }

    @Override
    public void setColor(Color backgroundColor) {
    }
}
