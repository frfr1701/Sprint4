package Client;

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

    JPanel currentPanel;

    List<IPanel> panelList;

    Color standardColor = new Color(238, 238, 238);
    Color backgroundColor = new Color(175, 175, 200);
<<<<<<< HEAD
    int correctAnswer;
    JFrame mastern;
    public GamePanel() {
        this.mastern = new JFrame();
        this.csp = new ColorSettingPanel(this);
        this.sp = new StartPanel(this);

        this.qp = new QuestionPanel(ma);
        this.rp = new ResultPanel(this);
        this.cp = new CategoryPanel(this);

=======

    @Override
    public void setGameStageGUI() {
        switch (session.getGameState()) {
            case FIRST:
                panelQueue = new LinkedList<>();
                panelQueue.add(new CategoryPanel(this));
                for (int i = 0; i < session.getNumberOfQuestions(); i++) {
                    panelQueue.add(new QuestionPanel(ma));
                }
                state = session.getGameState();

                subjects = session.getSubjects();
                mastern.add(currentPanel = categoryPanel = (CategoryPanel) (panelQueue.remove()));
                categoryPanel.setPanel();
                categoryPanel.setSubjects(subjects);

                session.setGameState(MIDDLE);
                break;
            case MIDDLE:
                panelQueue = new LinkedList<>();
                for (int i = 0; i < session.getNumberOfQuestions(); i++) {
                    panelQueue.add(new QuestionPanel(ma));
                }
                panelQueue.add(new CategoryPanel(this));
                for (int i = 0; i < session.getNumberOfQuestions(); i++) {
                    panelQueue.add(new QuestionPanel(ma));
                }
                state = session.getGameState();

                mastern.add(currentPanel = questionPanel = (QuestionPanel) (panelQueue.remove()));
                questionPanel.setPanel();
                questions = session.getQuestionsThisRound();
                questionPanel.setQuestions(questions.remove());
                break;
            case FINAL:
                panelQueue = new LinkedList<>();
                for (int i = 0; i < session.getNumberOfQuestions(); i++) {
                    panelQueue.add(new QuestionPanel(ma));
                }
                state = session.getGameState();

                mastern.add(currentPanel = questionPanel = (QuestionPanel) (panelQueue.remove()));
                questionPanel.setPanel();
                questions = session.getQuestionsThisRound();
                questionPanel.setQuestions(questions.remove());
                break;
            case GAMECOMPLETE:
                System.exit(0);
                break;
            default:
                writeObject();
        }
        mastern.revalidate();
        mastern.repaint();
>>>>>>> Jakobgui
    }

    @Override
    public void setPanel() {
        mastern = new JFrame();
        mastern.setTitle("VÄRLDENS BÄSTA QUIZ!");
        mastern.setSize(450, 550);
        mastern.setVisible(true);
        mastern.setLocationRelativeTo(null);
        mastern.setDefaultCloseOperation(3);
<<<<<<< HEAD
        mastern.add(sp);
        sp.setPanel();
//  mastern.add(rp);
//        rp.setPanel();
=======

>>>>>>> Jakobgui
        mastern.revalidate();
        mastern.repaint();

        colorSetterPanel = new ColorSettingPanel(this);
        startPanel = new StartPanel(this);
        categoryPanel = new CategoryPanel(this);
        questionPanel = new QuestionPanel(ma);
        resultPanel = new ResultPanel();

    }

    MouseListener ma = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getSource() == questionPanel.answer1) {
                if (questionPanel.answer1.getText().equalsIgnoreCase(questionPanel.correctAnswer)) {
                    questionPanel.answer1.setBackground(Color.GREEN);
                } else {
                    questionPanel.answer1.setBackground(Color.RED);
                }
            } else if (e.getSource() == questionPanel.answer2) {

                if (questionPanel.answer2.getText().equalsIgnoreCase(questionPanel.correctAnswer)) {
                    questionPanel.answer2.setBackground(Color.GREEN);
                } else {
                    questionPanel.answer2.setBackground(Color.RED);
                }
            } else if (e.getSource() == questionPanel.answer3) {
                if (questionPanel.answer3.getText().equalsIgnoreCase(questionPanel.correctAnswer)) {
                    questionPanel.answer3.setBackground(Color.GREEN);
                } else {
                    questionPanel.answer3.setBackground(Color.RED);
                }
            } else if (e.getSource() == questionPanel.answer4) {
                if (questionPanel.answer4.getText().equalsIgnoreCase(questionPanel.correctAnswer)) {
                    questionPanel.answer4.setBackground(Color.GREEN);
                } else {
                    questionPanel.answer4.setBackground(Color.RED);
                }
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
    };

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == startPanel.newGame) {
            
        } else if (ae.getSource() == startPanel.exitGame || ae.getSource() == categoryPanel.exitGame) {
            System.exit(0);
        } else if (ae.getSource() == categoryPanel.goBack) {
            
        }
        
        
        else if (ae.getSource() == categoryPanel.category1) {
            mastern.remove(currentPanel);
            categoryPanel.subject = categoryPanel.category1.getText();
            questions = session.getQuestions(categoryPanel.subject);
            session.setQuestionsThisRound(new LinkedList(questions));

            currentPanel = questionPanel = (QuestionPanel) (panelQueue.remove());
            questionPanel.setQuestions(questions.remove());
            questionPanel.setPanel();

            mastern.add(currentPanel);
        } else if (ae.getSource() == categoryPanel.category2) {
            mastern.remove(currentPanel);
            currentPanel = questionPanel = (QuestionPanel) (panelQueue.remove());

            categoryPanel.subject = categoryPanel.category2.getText();
            questions = session.getQuestions(categoryPanel.subject);
            session.setQuestionsThisRound(new LinkedList(questions));
            questionPanel.setQuestions(questions.remove());
            questionPanel.setPanel();

            mastern.add(currentPanel);
        } else if (ae.getSource() == categoryPanel.category3) {
            mastern.remove(currentPanel);
            currentPanel = questionPanel = (QuestionPanel) (panelQueue.remove());

            categoryPanel.subject = categoryPanel.category3.getText();
            questions = session.getQuestions(categoryPanel.subject);
            session.setQuestionsThisRound(new LinkedList(questions));
            questionPanel.setQuestions(questions.remove());
            questionPanel.setPanel();

            mastern.add(currentPanel);
        }
        
        
        
        else if (ae.getSource() == startPanel.settings) {
            
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

    @Override
    public void setColor(Color backgroundColor) {
    }
}
